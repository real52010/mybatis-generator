 /** 本文件由 工具自动生成自动生成 https://github.com/real52010/mybatis-generator.git*/
package com.real.demo.biz.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/** 
 * 订单表 null
 * @author real code generator
 * date:2018-11-27 18:03:07
 */
@Data
public class Order implements Serializable {
    /**串行版本ID**/
    private static final long serialVersionUID = 833148115973722440L;

    /** 
     * 主键
     */ 
    private Integer id;

    /** 
     * 产品id
     */ 
    private String orderId;

    /** 
     * 价格
     */ 
    private BigDecimal orderCount;

    /** 
     * 订单总额
     */ 
    private BigDecimal orderMoney;

    /** 
     * 实付金额
     */ 
    private BigDecimal payMoney;

    /** 
     * 付款时间
     */ 
    private Date payTime;

    /** 
     * 退款时间
     */ 
    private Date refundTime;

    /** 
     * 状态 0 未付款 1 付款中 2 已付款 3 退款中 4 已退款 
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