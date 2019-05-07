 /** 本文件由 工具自动生成自动生成 https://github.com/real52010/mybatis-generator.git*/
package com.real.demo.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/** 
 * 产品类型表 备注
 * @author real code generator
 * date:2019-05-07 09:52:41
 */
@Data
public class PrdProductType implements Serializable {
    /**串行版本ID**/
    private static final long serialVersionUID = 4540245331986901833L;

    /** 
     * id
     */ 
    private Integer id;

    /** 
     * 类型ID
     */ 
    private String productTypeId;

    /** 
     * 类型名称
     */ 
    private String productTypeName;

    /** 
     * 属性
     */ 
    private String productPropertyId;

    /** 
     * 是否启动资格认证( 1 启动 2 禁用)
     */ 
    private Integer qualificationAuthenticate;

    /** 
     * 是否启用风险评测
     */ 
    private Integer riskAssessment;

    /** 
     * 是否启用(1 启动 2 禁用)
     */ 
    private Integer available;

    /** 
     * 排序
     */ 
    private Integer orderNum;

    /** 
     * 是否删除（0,正常,1删除）
     */ 
    private Integer deleted;

    /** 
     * 创建人
     */ 
    private String createBy;

    /** 
     * 创建时间
     */ 
    private Date createTime;

    /** 
     * 更新人
     */ 
    private String updateBy;

    /** 
     * 更新时间
     */ 
    private Date updateTime;

    /** 
     * 备注
     */ 
    private String remark;
}