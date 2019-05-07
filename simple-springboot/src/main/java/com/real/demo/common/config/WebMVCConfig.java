package com.real.demo.common.config;

import static springfox.documentation.schema.AlternateTypeRules.newRule;

import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.fasterxml.classmate.TypeResolver;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.WildcardType;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
 * swagger配置类
 *
 * @author fengshuonan
 * @date 2017年6月1日19:42:59
 */
@Configuration
@EnableSwagger2
@ConditionalOnProperty(prefix = "real", name = "swagger-open", havingValue = "true")
@ComponentScan(basePackages = "com.real.demo") 
public class WebMVCConfig extends WebMvcConfigurationSupport {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("docs.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("doc.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        
        registry.addResourceHandler("/**").addResourceLocations("/");
    }
    @Autowired
    private TypeResolver typeResolver;

    @Bean
    public Docket createRestApi() {

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("默认接口")
                .apiInfo(apiInfo())
                .genericModelSubstitutes(ResponseEntity.class)
                .alternateTypeRules(
                        newRule(typeResolver.resolve(DeferredResult.class,
                                typeResolver.resolve(ResponseEntity.class, WildcardType.class)),
                                typeResolver.resolve(WildcardType.class)))
                .useDefaultResponseMessages(false)
                .forCodeGeneration(true)
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.real.demo"))
                .paths(PathSelectors.any())
                .build()
                .securityContexts(Lists.newArrayList(securityContext(),securityContext1())).securitySchemes(Lists.<SecurityScheme>newArrayList(apiKey(),apiKey1()));

    }


    private ApiInfo apiInfo() {

        return new ApiInfoBuilder()
                .title("前端接口")
                .description("前端接口")
                .termsOfServiceUrl("http://www.8real.com/")
                .contact("real-yqdt@163.com")
                .version("1.0")
                .build();

    }

    private ApiKey apiKey() {
        return new ApiKey("BearerToken", "Authorization", "header");
    }

    private ApiKey apiKey1() {
        return new ApiKey("BearerToken1", "Authorization-x", "header");
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.regex("/.*"))
                .build();
    }

    private SecurityContext securityContext1() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth1())
                .forPaths(PathSelectors.regex("/.*"))
                .build();
    }

    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Lists.newArrayList(new SecurityReference("BearerToken", authorizationScopes));
    }

    List<SecurityReference> defaultAuth1() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Lists.newArrayList(new SecurityReference("BearerToken1", authorizationScopes));
    }
    /**
     * 替换框架json为Jackson
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);
        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        //设置日期格式
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleDateFormat smt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        objectMapper.setDateFormat(smt);
        
		// objectMapper.setDefaultPropertyInclusion(JsonInclude.Include.NON_NULL);
        // null或""都不序列化
        objectMapper.setDefaultPropertyInclusion(JsonInclude.Include.NON_EMPTY );
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        mappingJackson2HttpMessageConverter.setObjectMapper(objectMapper);
        //设置中文编码格式
        List<MediaType> list = new ArrayList<MediaType>();
        list.add(MediaType.APPLICATION_JSON_UTF8);
        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(list);

        //处理字符串, 避免直接返回字符串的时候被添加了引号
        StringHttpMessageConverter smc = new StringHttpMessageConverter(Charset.forName("UTF-8"));
        converters.add(smc);
        converters.add(mappingJackson2HttpMessageConverter);
    }
    /**
     * 替换框架json为fastjson
     */
//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        super.configureMessageConverters(converters);
//        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
//        FastJsonConfig fastJsonConfig = new FastJsonConfig();
//        fastJsonConfig.setSerializerFeatures(
//                SerializerFeature.PrettyFormat, 
//                SerializerFeature.WriteNullNumberAsZero, 
//                SerializerFeature.WriteNullStringAsEmpty
//            );
//        // 处理中文乱码问题
//        List<MediaType> fastMediaTypes = new ArrayList<>();
//        fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
//        fastConverter.setSupportedMediaTypes(fastMediaTypes);
//        fastConverter.setFastJsonConfig(fastJsonConfig);
//
//        //处理字符串, 避免直接返回字符串的时候被添加了引号
//        StringHttpMessageConverter smc = new StringHttpMessageConverter(Charset.forName("UTF-8"));
//        converters.add(smc);
//
//        converters.add(fastConverter);
//    }
//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
//        builder.serializationInclusion(JsonInclude.Include.NON_NULL);
//        builder.propertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
//        builder.serializationInclusion(Include.NON_EMPTY);
//        builder.indentOutput(true).dateFormat(new SimpleDateFormat("yyyy-MM-dd"));
//        converters.add(new MappingJackson2HttpMessageConverter(builder.build()));
//        converters.add(new MappingJackson2XmlHttpMessageConverter(builder.createXmlMapper(true).build()));
//    }


    /**
     * 解决跨域问题
     */
    @Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();
        // 允许cookies跨域
        config.setAllowCredentials(true);
        // #允许向该服务器提交请求的URI，*表示全部允许
        config.addAllowedOrigin("*");
        // #允许访问的头信息,*表示全部
        config.addAllowedHeader("*");
        // 预检请求的缓存时间（秒），即在这个时间段里，对于相同的跨域请求不会再预检了
        config.setMaxAge(18000L);
        // 允许提交请求的方法，*表示全部允许，也可以单独设置GET、PUT等
        config.addAllowedMethod("*");
        config.addAllowedMethod("HEAD");
        // 允许Get的请求方法
        config.addAllowedMethod("GET");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("DELETE");
        config.addAllowedMethod("PATCH");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
	    @Bean
	    InternalResourceViewResolver viewResolver(){
	
	        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	        resolver.setPrefix("/webapp/");
	        resolver.setSuffix(".html");
	
	        return resolver;
	    }
	    @Bean  
	    public ViewResolver jspViewResolver(){  
	    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();  
	    viewResolver.setViewClass(JstlView.class);  
	    viewResolver.setPrefix("/jsp/");  
	    viewResolver.setSuffix(".jsp");  
	    viewResolver.setOrder(1);  
	    return viewResolver;  
	    }  
}
