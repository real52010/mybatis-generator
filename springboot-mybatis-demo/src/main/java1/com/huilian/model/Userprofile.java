 /** 本文件由 工具自动生成自动生成 https://github.com/real52010/mybatis-generator.git*/
package com.huilian.model;

import java.io.Serializable;
import java.util.Date;

/** 
 * 用户帐号信息 数据状态 0：正常  1 删除 
 * @author real code generator
 * date:2017-12-13 22:27:19
 */
public class Userprofile implements Serializable {
    /**串行版本ID**/
    private static final long serialVersionUID = -5897651939257482052L;

    /** 
     * id
     */ 
    private Long id;

    /** 
     * 用户ID UUID
     */ 
    private String userID;

    /** 
     * 登录用户名
     */ 
    private String login_name;

    /** 
     * 用户号码
     */ 
    private String phoneNum;

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
    private Date create_time;

    /** 
     * 创建人
     */ 
    private String create_by;

    /** 
     * 修改时间
     */ 
    private Date update_time;

    /** 
     * 修改人
     */ 
    private Date update_by;

    /** 
     * 数据状态 0：正常  1 删除 
     * 默认：0
     */ 
    private String data_status;

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
    public String getUserID() {
        return userID;
    }

    /** 
     * 设置 用户ID UUID 
     * @param userID 用户ID UUID
     */
    public void setUserID(String userID) {
        this.userID = userID;
    }

    /** 
     * 获取 登录用户名 
     * @return 登录用户名
     */
    public String getLogin_name() {
        return login_name;
    }

    /** 
     * 设置 登录用户名 
     * @param login_name 登录用户名
     */
    public void setLogin_name(String login_name) {
        this.login_name = login_name;
    }

    /** 
     * 获取 用户号码 
     * @return 用户号码
     */
    public String getPhoneNum() {
        return phoneNum;
    }

    /** 
     * 设置 用户号码 
     * @param phoneNum 用户号码
     */
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
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
    public Date getCreate_time() {
        return create_time;
    }

    /** 
     * 设置 创建时间 
     * @param create_time 创建时间
     */
    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    /** 
     * 获取 创建人 
     * @return 创建人
     */
    public String getCreate_by() {
        return create_by;
    }

    /** 
     * 设置 创建人 
     * @param create_by 创建人
     */
    public void setCreate_by(String create_by) {
        this.create_by = create_by;
    }

    /** 
     * 获取 修改时间 
     * @return 修改时间
     */
    public Date getUpdate_time() {
        return update_time;
    }

    /** 
     * 设置 修改时间 
     * @param update_time 修改时间
     */
    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    /** 
     * 获取 修改人 
     * @return 修改人
     */
    public Date getUpdate_by() {
        return update_by;
    }

    /** 
     * 设置 修改人 
     * @param update_by 修改人
     */
    public void setUpdate_by(Date update_by) {
        this.update_by = update_by;
    }

    /** 
     * 获取 数据状态 0：正常  1 删除  
     * @return 数据状态 0：正常  1 删除 
     */
    public String getData_status() {
        return data_status;
    }

    /** 
     * 设置 数据状态 0：正常  1 删除  
     * @param data_status 数据状态 0：正常  1 删除 
     */
    public void setData_status(String data_status) {
        this.data_status = data_status;
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
            && (this.getUserID() == null ? other.getUserID() == null : this.getUserID().equals(other.getUserID()))
            && (this.getLogin_name() == null ? other.getLogin_name() == null : this.getLogin_name().equals(other.getLogin_name()))
            && (this.getPhoneNum() == null ? other.getPhoneNum() == null : this.getPhoneNum().equals(other.getPhoneNum()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getPlatform() == null ? other.getPlatform() == null : this.getPlatform().equals(other.getPlatform()))
            && (this.getCreate_time() == null ? other.getCreate_time() == null : this.getCreate_time().equals(other.getCreate_time()))
            && (this.getCreate_by() == null ? other.getCreate_by() == null : this.getCreate_by().equals(other.getCreate_by()))
            && (this.getUpdate_time() == null ? other.getUpdate_time() == null : this.getUpdate_time().equals(other.getUpdate_time()))
            && (this.getUpdate_by() == null ? other.getUpdate_by() == null : this.getUpdate_by().equals(other.getUpdate_by()))
            && (this.getData_status() == null ? other.getData_status() == null : this.getData_status().equals(other.getData_status()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserID() == null) ? 0 : getUserID().hashCode());
        result = prime * result + ((getLogin_name() == null) ? 0 : getLogin_name().hashCode());
        result = prime * result + ((getPhoneNum() == null) ? 0 : getPhoneNum().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getPlatform() == null) ? 0 : getPlatform().hashCode());
        result = prime * result + ((getCreate_time() == null) ? 0 : getCreate_time().hashCode());
        result = prime * result + ((getCreate_by() == null) ? 0 : getCreate_by().hashCode());
        result = prime * result + ((getUpdate_time() == null) ? 0 : getUpdate_time().hashCode());
        result = prime * result + ((getUpdate_by() == null) ? 0 : getUpdate_by().hashCode());
        result = prime * result + ((getData_status() == null) ? 0 : getData_status().hashCode());
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
        sb.append(", userID=").append(userID);
        sb.append(", login_name=").append(login_name);
        sb.append(", phoneNum=").append(phoneNum);
        sb.append(", email=").append(email);
        sb.append(", password=").append(password);
        sb.append(", status=").append(status);
        sb.append(", platform=").append(platform);
        sb.append(", create_time=").append(create_time);
        sb.append(", create_by=").append(create_by);
        sb.append(", update_time=").append(update_time);
        sb.append(", update_by=").append(update_by);
        sb.append(", data_status=").append(data_status);
        sb.append("]");
        return sb.toString();
    }
}