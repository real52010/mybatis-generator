 /** 本文件由 工具自动生成自动生成 https://github.com/real52010/mybatis-generator.git*/
package com.real.demo.biz.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/** 
 * 产品表 更新时间
 * @author real code generator
 * date:2018-11-27 18:00:34
 */
@Data
public class Product implements Serializable {
    /**串行版本ID**/
    private static final long serialVersionUID = -5686366697765443425L;

    /** 
     * 主键
     */ 
    private Integer id;

    /** 
     * 产品id
     */ 
    private String productId;

    /** 
     * 产品名称
     */ 
    private String name;

    /** 
     * 价格
     */ 
    private BigDecimal price;

    /** 
     * 描述
     */ 
    private String describe;

    /** 
     * 库存数量
     */ 
    private Integer stockCount;

    /** 
     * 状态 0 未上架 1 已上架 2 已下架
     * 默认：0
     */ 
    private Integer status;

    /** 
     * 0 正常状态  1 已删除
     * 默认：0
     */ 
    private Integer delFlag;

    /** 
     * 创建时间
     */ 
    private Date createTime;

    /** 
     * 更新时间
     */ 
    private Date updateTime;
}