 /** 本文件由 工具自动生成自动生成 https://github.com/real52010/mybatis-generator.git*/
package com.huilian.model;

import java.io.Serializable;
import java.util.Date;

/** 
 * 用户帐号信息 数据状态 0：正常  1 删除 
 * @author real code generator
 * date:2017-12-14 21:00:03
 */
public class Userprofile implements Serializable {
    /**串行版本ID**/
    private static final long serialVersionUID = -6540967747918443432L;

    /** 
     * id
     */ 
    private Long id;

    /** 
     * 用户ID UUID
     */ 
    private String userid;

    /** 
     * 登录用户名
     */ 
    private String loginName;

    /** 
     * 用户号码
     */ 
    private String phonenum;

    /** 
     * 用户邮箱
     */ 
    private String email;

    /** 
     * 密码
     */ 
    private String password;

    /** 
     * 用户状态
            1 正常
            2 锁定
     * 默认：1
     */ 
    private String status;

    /** 
     * 注册平台
     */ 
    private Integer platform;

    /** 
     * 创建时间
     */ 
    private Date createTime;

    /** 
     * 创建人
     */ 
    private String createBy;

    /** 
     * 修改时间
     */ 
    private Date updateTime;

    /** 
     * 修改人
     */ 
    private Date updateBy;

    /** 
     * 数据状态 0：正常  1 删除 
     * 默认：0
     */ 
    private String dataStatus;

    /** 
     * 获取 id 
     * @return id
     */
    public Long getId() {
        return id;
    }

    /** 
     * 设置 id 
     * @param id id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /** 
     * 获取 用户ID UUID 
     * @return 用户ID UUID
     */
    public String getUserid() {
        return userid;
    }

    /** 
     * 设置 用户ID UUID 
     * @param userid 用户ID UUID
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    /** 
     * 获取 登录用户名 
     * @return 登录用户名
     */
    public String getLoginName() {
        return loginName;
    }

    /** 
     * 设置 登录用户名 
     * @param loginName 登录用户名
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    /** 
     * 获取 用户号码 
     * @return 用户号码
     */
    public String getPhonenum() {
        return phonenum;
    }

    /** 
     * 设置 用户号码 
     * @param phonenum 用户号码
     */
    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    /** 
     * 获取 用户邮箱 
     * @return 用户邮箱
     */
    public String getEmail() {
        return email;
    }

    /** 
     * 设置 用户邮箱 
     * @param email 用户邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /** 
     * 获取 密码 
     * @return 密码
     */
    public String getPassword() {
        return password;
    }

    /** 
     * 设置 密码 
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /** 
     * 获取 用户状态
            1 正常
            2 锁定 
     * @return 用户状态
            1 正常
            2 锁定
     */
    public String getStatus() {
        return status;
    }

    /** 
     * 设置 用户状态
            1 正常
            2 锁定 
     * @param status 用户状态
            1 正常
            2 锁定
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /** 
     * 获取 注册平台 
     * @return 注册平台
     */
    public Integer getPlatform() {
        return platform;
    }

    /** 
     * 设置 注册平台 
     * @param platform 注册平台
     */
    public void setPlatform(Integer platform) {
        this.platform = platform;
    }

    /** 
     * 获取 创建时间 
     * @return 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /** 
     * 设置 创建时间 
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /** 
     * 获取 创建人 
     * @return 创建人
     */
    public String getCreateBy() {
        return createBy;
    }

    /** 
     * 设置 创建人 
     * @param createBy 创建人
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /** 
     * 获取 修改时间 
     * @return 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /** 
     * 设置 修改时间 
     * @param updateTime 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /** 
     * 获取 修改人 
     * @return 修改人
     */
    public Date getUpdateBy() {
        return updateBy;
    }

    /** 
     * 设置 修改人 
     * @param updateBy 修改人
     */
    public void setUpdateBy(Date updateBy) {
        this.updateBy = updateBy;
    }

    /** 
     * 获取 数据状态 0：正常  1 删除  
     * @return 数据状态 0：正常  1 删除 
     */
    public String getDataStatus() {
        return dataStatus;
    }

    /** 
     * 设置 数据状态 0：正常  1 删除  
     * @param dataStatus 数据状态 0：正常  1 删除 
     */
    public void setDataStatus(String dataStatus) {
        this.dataStatus = dataStatus;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Userprofile other = (Userprofile) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getLoginName() == null ? other.getLoginName() == null : this.getLoginName().equals(other.getLoginName()))
            && (this.getPhonenum() == null ? other.getPhonenum() == null : this.getPhonenum().equals(other.getPhonenum()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getPlatform() == null ? other.getPlatform() == null : this.getPlatform().equals(other.getPlatform()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateBy() == null ? other.getCreateBy() == null : this.getCreateBy().equals(other.getCreateBy()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getUpdateBy() == null ? other.getUpdateBy() == null : this.getUpdateBy().equals(other.getUpdateBy()))
            && (this.getDataStatus() == null ? other.getDataStatus() == null : this.getDataStatus().equals(other.getDataStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getLoginName() == null) ? 0 : getLoginName().hashCode());
        result = prime * result + ((getPhonenum() == null) ? 0 : getPhonenum().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getPlatform() == null) ? 0 : getPlatform().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateBy() == null) ? 0 : getCreateBy().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getUpdateBy() == null) ? 0 : getUpdateBy().hashCode());
        result = prime * result + ((getDataStatus() == null) ? 0 : getDataStatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append(", id=").append(id);
        sb.append(", userid=").append(userid);
        sb.append(", loginName=").append(loginName);
        sb.append(", phonenum=").append(phonenum);
        sb.append(", email=").append(email);
        sb.append(", password=").append(password);
        sb.append(", status=").append(status);
        sb.append(", platform=").append(platform);
        sb.append(", createTime=").append(createTime);
        sb.append(", createBy=").append(createBy);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", dataStatus=").append(dataStatus);
        sb.append("]");
        return sb.toString();
    }
}