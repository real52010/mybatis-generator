package com.huilian.dao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 
 */
public class Userprofile implements Serializable {
    /**
     * 用户ID UUID
     */
    private String userid;

    private String phonenum;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户状态
            1 正常
            2 锁定
     */
    private String status;

    /**
     * 在线状态
            1 在线
            2离线
     */
    private String onlinestatus;

    /**
     * 在线状态更新时间
     */
    private Date onlinestatusupdate;

    /**
     * 注册时间
     */
    private Date regdate;

    /**
     * 帐户资金
     */
    private BigDecimal amount;

    /**
     * 账户冻结资金
     */
    private BigDecimal frozenamount;

    /**
     * 备注
     */
    private String remark;

    private Long hlcId;

    private Short dataSource;

    /**
     * 用户来源(0 线上注册 1 线下刷卡 2 汇理财用户 3 后台管理员创建  )
     */
    private String source;

    /**
     * 推荐人
     */
    private String referee;

    /**
     * 注册渠道
     */
    private String usrchannel;

    /**
     * QQ登录ID
     */
    private String qqopenid;

    /**
     * 成为C端经纪人时间
     */
    private Date bectime;

    /**
     * 更新时间
     */
    private Date updatetime;

    /**
     * 用户标签，C:C端经纪人
     */
    private String usertag;

    /**
     * 用户联系方式
     */
    private String contactway;

    /**
     * 顺风openid
     */
    private String sfopenid;

    /**
     * 顺风channelNo
     */
    private String sfchannelno;

    private static final long serialVersionUID = 1L;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOnlinestatus() {
        return onlinestatus;
    }

    public void setOnlinestatus(String onlinestatus) {
        this.onlinestatus = onlinestatus;
    }

    public Date getOnlinestatusupdate() {
        return onlinestatusupdate;
    }

    public void setOnlinestatusupdate(Date onlinestatusupdate) {
        this.onlinestatusupdate = onlinestatusupdate;
    }

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getFrozenamount() {
        return frozenamount;
    }

    public void setFrozenamount(BigDecimal frozenamount) {
        this.frozenamount = frozenamount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getHlcId() {
        return hlcId;
    }

    public void setHlcId(Long hlcId) {
        this.hlcId = hlcId;
    }

    public Short getDataSource() {
        return dataSource;
    }

    public void setDataSource(Short dataSource) {
        this.dataSource = dataSource;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getReferee() {
        return referee;
    }

    public void setReferee(String referee) {
        this.referee = referee;
    }

    public String getUsrchannel() {
        return usrchannel;
    }

    public void setUsrchannel(String usrchannel) {
        this.usrchannel = usrchannel;
    }

    public String getQqopenid() {
        return qqopenid;
    }

    public void setQqopenid(String qqopenid) {
        this.qqopenid = qqopenid;
    }

    public Date getBectime() {
        return bectime;
    }

    public void setBectime(Date bectime) {
        this.bectime = bectime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getUsertag() {
        return usertag;
    }

    public void setUsertag(String usertag) {
        this.usertag = usertag;
    }

    public String getContactway() {
        return contactway;
    }

    public void setContactway(String contactway) {
        this.contactway = contactway;
    }

    public String getSfopenid() {
        return sfopenid;
    }

    public void setSfopenid(String sfopenid) {
        this.sfopenid = sfopenid;
    }

    public String getSfchannelno() {
        return sfchannelno;
    }

    public void setSfchannelno(String sfchannelno) {
        this.sfchannelno = sfchannelno;
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
        return (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getPhonenum() == null ? other.getPhonenum() == null : this.getPhonenum().equals(other.getPhonenum()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getOnlinestatus() == null ? other.getOnlinestatus() == null : this.getOnlinestatus().equals(other.getOnlinestatus()))
            && (this.getOnlinestatusupdate() == null ? other.getOnlinestatusupdate() == null : this.getOnlinestatusupdate().equals(other.getOnlinestatusupdate()))
            && (this.getRegdate() == null ? other.getRegdate() == null : this.getRegdate().equals(other.getRegdate()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getFrozenamount() == null ? other.getFrozenamount() == null : this.getFrozenamount().equals(other.getFrozenamount()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getHlcId() == null ? other.getHlcId() == null : this.getHlcId().equals(other.getHlcId()))
            && (this.getDataSource() == null ? other.getDataSource() == null : this.getDataSource().equals(other.getDataSource()))
            && (this.getSource() == null ? other.getSource() == null : this.getSource().equals(other.getSource()))
            && (this.getReferee() == null ? other.getReferee() == null : this.getReferee().equals(other.getReferee()))
            && (this.getUsrchannel() == null ? other.getUsrchannel() == null : this.getUsrchannel().equals(other.getUsrchannel()))
            && (this.getQqopenid() == null ? other.getQqopenid() == null : this.getQqopenid().equals(other.getQqopenid()))
            && (this.getBectime() == null ? other.getBectime() == null : this.getBectime().equals(other.getBectime()))
            && (this.getUpdatetime() == null ? other.getUpdatetime() == null : this.getUpdatetime().equals(other.getUpdatetime()))
            && (this.getUsertag() == null ? other.getUsertag() == null : this.getUsertag().equals(other.getUsertag()))
            && (this.getContactway() == null ? other.getContactway() == null : this.getContactway().equals(other.getContactway()))
            && (this.getSfopenid() == null ? other.getSfopenid() == null : this.getSfopenid().equals(other.getSfopenid()))
            && (this.getSfchannelno() == null ? other.getSfchannelno() == null : this.getSfchannelno().equals(other.getSfchannelno()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getPhonenum() == null) ? 0 : getPhonenum().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getOnlinestatus() == null) ? 0 : getOnlinestatus().hashCode());
        result = prime * result + ((getOnlinestatusupdate() == null) ? 0 : getOnlinestatusupdate().hashCode());
        result = prime * result + ((getRegdate() == null) ? 0 : getRegdate().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getFrozenamount() == null) ? 0 : getFrozenamount().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getHlcId() == null) ? 0 : getHlcId().hashCode());
        result = prime * result + ((getDataSource() == null) ? 0 : getDataSource().hashCode());
        result = prime * result + ((getSource() == null) ? 0 : getSource().hashCode());
        result = prime * result + ((getReferee() == null) ? 0 : getReferee().hashCode());
        result = prime * result + ((getUsrchannel() == null) ? 0 : getUsrchannel().hashCode());
        result = prime * result + ((getQqopenid() == null) ? 0 : getQqopenid().hashCode());
        result = prime * result + ((getBectime() == null) ? 0 : getBectime().hashCode());
        result = prime * result + ((getUpdatetime() == null) ? 0 : getUpdatetime().hashCode());
        result = prime * result + ((getUsertag() == null) ? 0 : getUsertag().hashCode());
        result = prime * result + ((getContactway() == null) ? 0 : getContactway().hashCode());
        result = prime * result + ((getSfopenid() == null) ? 0 : getSfopenid().hashCode());
        result = prime * result + ((getSfchannelno() == null) ? 0 : getSfchannelno().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userid=").append(userid);
        sb.append(", phonenum=").append(phonenum);
        sb.append(", password=").append(password);
        sb.append(", status=").append(status);
        sb.append(", onlinestatus=").append(onlinestatus);
        sb.append(", onlinestatusupdate=").append(onlinestatusupdate);
        sb.append(", regdate=").append(regdate);
        sb.append(", amount=").append(amount);
        sb.append(", frozenamount=").append(frozenamount);
        sb.append(", remark=").append(remark);
        sb.append(", hlcId=").append(hlcId);
        sb.append(", dataSource=").append(dataSource);
        sb.append(", source=").append(source);
        sb.append(", referee=").append(referee);
        sb.append(", usrchannel=").append(usrchannel);
        sb.append(", qqopenid=").append(qqopenid);
        sb.append(", bectime=").append(bectime);
        sb.append(", updatetime=").append(updatetime);
        sb.append(", usertag=").append(usertag);
        sb.append(", contactway=").append(contactway);
        sb.append(", sfopenid=").append(sfopenid);
        sb.append(", sfchannelno=").append(sfchannelno);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}