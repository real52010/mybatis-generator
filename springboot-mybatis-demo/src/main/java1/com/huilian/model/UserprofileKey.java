 /** 本文件由 工具自动生成自动生成 https://github.com/real52010/mybatis-generator.git*/
package com.huilian.model;

import java.io.Serializable;

/** 
 * 用户帐号信息 数据状态 0：正常  1 删除 
 * @author real code generator
 * date:2017-12-13 22:09:50
 */
public class UserprofileKey implements Serializable {
    /**串行版本ID**/
    private static final long serialVersionUID = 912610287083660775L;

    /** 
     * id
     */ 
    private Long id;

    /** 
     * 用户ID UUID
     */ 
    private String userid;

    /** 
     * 获取 id userprofile.id
     * @return id
     */
    public Long getId() {
        return id;
    }

    /** 
     * 设置 id userprofile.id
     * @param id id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /** 
     * 获取 用户ID UUID userprofile.UserID
     * @return 用户ID UUID
     */
    public String getUserid() {
        return userid;
    }

    /** 
     * 设置 用户ID UUID userprofile.UserID
     * @param userid 用户ID UUID
     */
    public void setUserid(String userid) {
        this.userid = userid;
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
        UserprofileKey other = (UserprofileKey) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
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
        sb.append("]");
        return sb.toString();
    }
}