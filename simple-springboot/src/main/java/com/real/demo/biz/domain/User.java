 /** 本文件由 工具自动生成自动生成 https://github.com/real52010/mybatis-generator.git*/
package com.real.demo.biz.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/** 
 * 用户表 更新时间
 * @author real code generator
 * date:2018-11-27 18:00:37
 */
@Data
public class User implements Serializable {
    /**串行版本ID**/
    private static final long serialVersionUID = 8044662614258953876L;

    private Integer id;

    /** 
     * 用户id
     */ 
    private String userId;

    /** 
     * 用户名
     */ 
    private String userName;

    /** 
     * 密码
     */ 
    private String password;

    /** 
     * 电话号码
     */ 
    private String phone;

    /** 
     * email
     */ 
    private String email;

    /** 
     * 性别
     */ 
    private Integer sex;

    /** 
     * 地址
     */ 
    private String address;

    /** 
     * 0 正常状态  1 已锁定登录  2 已锁定交易 3 黑名单用户
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