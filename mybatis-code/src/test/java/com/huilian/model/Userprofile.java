/* https://github.com/orange1438 */
package com.huilian.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Userprofile implements Serializable {
    //串行版本ID
    private static final long serialVersionUID = -8441752975585140728L;

    // 用户ID UUID
    private String userid;

    private String phonenum;

    // 密码
    private String password;

    // 用户状态
            1 正常
            2 锁定  默认：1
    private String status;

    // 在线状态
            1 在线
            2离线
    private String onlinestatus;

    // 在线状态更新时间
    private Date onlinestatusupdate;

    // 注册时间
    private Date regdate;

    // 帐户资金
    private BigDecimal amount;

    // 账户冻结资金
    private BigDecimal frozenamount;

    // 备注
    private String remark;

    private Long hlcId;

    private Short dataSource;

    // 用户来源(0 线上注册 1 线下刷卡 2 汇理财用户 3 后台管理员创建  )  默认：0
    private String source;

    // 推荐人
    private String referee;

    private String usrchannel;

    // 渠道来源编码id
    private String qqopenid;

    // 成为C端经纪人时间
    private Date bectime;

    // 更新时间
    private Date updatetime;

    // 用户标签，C:C端经纪人
    private String usertag;

    // 用户联系方式
    private String contactway;

    // 顺风openid
    private String sfopenid;

    // 顺风channelNo
    private String sfchannelno;

    // 上次登录时间
    private Date lastlogintime;

    // 密码修改延期次数  默认：1
    private Integer pwdmodifydelay;

    // 密码修改时间
    private Date pwdmodifytime;

    // 统一支付密码
    private String dealpwd;

    // 大数据数据来源
    private String bigdatasource;

    // 用户大数据一级渠道标记导入日期
    private String bigdatasourcetime;

    /** 
     * 获取 用户ID UUID userprofile.UserID
     * @return 用户ID UUID
     */
    public final String getUserid() {
        return userid;
    }

    /** 
     * 设置 用户ID UUID userprofile.UserID
     * @param userid 用户ID UUID
     */
    public final void setUserid(String userid) {
        this.userid = userid;
    }

    /** 
     * 获取 userprofile.PhoneNum
     * @return userprofile.PhoneNum
     */
    public final String getPhonenum() {
        return phonenum;
    }

    /** 
     * 设置 userprofile.PhoneNum
     * @param phonenum userprofile.PhoneNum
     */
    public final void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    /** 
     * 获取 密码 userprofile.Password
     * @return 密码
     */
    public final String getPassword() {
        return password;
    }

    /** 
     * 设置 密码 userprofile.Password
     * @param password 密码
     */
    public final void setPassword(String password) {
        this.password = password;
    }

    /** 
     * 获取 用户状态
            1 正常
            2 锁定 userprofile.Status
     * @return 用户状态
            1 正常
            2 锁定
     */
    public final String getStatus() {
        return status;
    }

    /** 
     * 设置 用户状态
            1 正常
            2 锁定 userprofile.Status
     * @param status 用户状态
            1 正常
            2 锁定
     */
    public final void setStatus(String status) {
        this.status = status;
    }

    /** 
     * 获取 在线状态
            1 在线
            2离线 userprofile.OnlineStatus
     * @return 在线状态
            1 在线
            2离线
     */
    public final String getOnlinestatus() {
        return onlinestatus;
    }

    /** 
     * 设置 在线状态
            1 在线
            2离线 userprofile.OnlineStatus
     * @param onlinestatus 在线状态
            1 在线
            2离线
     */
    public final void setOnlinestatus(String onlinestatus) {
        this.onlinestatus = onlinestatus;
    }

    /** 
     * 获取 在线状态更新时间 userprofile.OnlineStatusUpdate
     * @return 在线状态更新时间
     */
    public final Date getOnlinestatusupdate() {
        return onlinestatusupdate;
    }

    /** 
     * 设置 在线状态更新时间 userprofile.OnlineStatusUpdate
     * @param onlinestatusupdate 在线状态更新时间
     */
    public final void setOnlinestatusupdate(Date onlinestatusupdate) {
        this.onlinestatusupdate = onlinestatusupdate;
    }

    /** 
     * 获取 注册时间 userprofile.RegDate
     * @return 注册时间
     */
    public final Date getRegdate() {
        return regdate;
    }

    /** 
     * 设置 注册时间 userprofile.RegDate
     * @param regdate 注册时间
     */
    public final void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    /** 
     * 获取 帐户资金 userprofile.Amount
     * @return 帐户资金
     */
    public final BigDecimal getAmount() {
        return amount;
    }

    /** 
     * 设置 帐户资金 userprofile.Amount
     * @param amount 帐户资金
     */
    public final void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /** 
     * 获取 账户冻结资金 userprofile.FrozenAmount
     * @return 账户冻结资金
     */
    public final BigDecimal getFrozenamount() {
        return frozenamount;
    }

    /** 
     * 设置 账户冻结资金 userprofile.FrozenAmount
     * @param frozenamount 账户冻结资金
     */
    public final void setFrozenamount(BigDecimal frozenamount) {
        this.frozenamount = frozenamount;
    }

    /** 
     * 获取 备注 userprofile.Remark
     * @return 备注
     */
    public final String getRemark() {
        return remark;
    }

    /** 
     * 设置 备注 userprofile.Remark
     * @param remark 备注
     */
    public final void setRemark(String remark) {
        this.remark = remark;
    }

    /** 
     * 获取 userprofile.hlc_id
     * @return userprofile.hlc_id
     */
    public final Long getHlcId() {
        return hlcId;
    }

    /** 
     * 设置 userprofile.hlc_id
     * @param hlcId userprofile.hlc_id
     */
    public final void setHlcId(Long hlcId) {
        this.hlcId = hlcId;
    }

    /** 
     * 获取 userprofile.data_source
     * @return userprofile.data_source
     */
    public final Short getDataSource() {
        return dataSource;
    }

    /** 
     * 设置 userprofile.data_source
     * @param dataSource userprofile.data_source
     */
    public final void setDataSource(Short dataSource) {
        this.dataSource = dataSource;
    }

    /** 
     * 获取 用户来源(0 线上注册 1 线下刷卡 2 汇理财用户 3 后台管理员创建  ) userprofile.Source
     * @return 用户来源(0 线上注册 1 线下刷卡 2 汇理财用户 3 后台管理员创建  )
     */
    public final String getSource() {
        return source;
    }

    /** 
     * 设置 用户来源(0 线上注册 1 线下刷卡 2 汇理财用户 3 后台管理员创建  ) userprofile.Source
     * @param source 用户来源(0 线上注册 1 线下刷卡 2 汇理财用户 3 后台管理员创建  )
     */
    public final void setSource(String source) {
        this.source = source;
    }

    /** 
     * 获取 推荐人 userprofile.referee
     * @return 推荐人
     */
    public final String getReferee() {
        return referee;
    }

    /** 
     * 设置 推荐人 userprofile.referee
     * @param referee 推荐人
     */
    public final void setReferee(String referee) {
        this.referee = referee;
    }

    /** 
     * 获取 userprofile.usrChannel
     * @return userprofile.usrChannel
     */
    public final String getUsrchannel() {
        return usrchannel;
    }

    /** 
     * 设置 userprofile.usrChannel
     * @param usrchannel userprofile.usrChannel
     */
    public final void setUsrchannel(String usrchannel) {
        this.usrchannel = usrchannel;
    }

    /** 
     * 获取 渠道来源编码id userprofile.qqOpenId
     * @return 渠道来源编码id
     */
    public final String getQqopenid() {
        return qqopenid;
    }

    /** 
     * 设置 渠道来源编码id userprofile.qqOpenId
     * @param qqopenid 渠道来源编码id
     */
    public final void setQqopenid(String qqopenid) {
        this.qqopenid = qqopenid;
    }

    /** 
     * 获取 成为C端经纪人时间 userprofile.beCTime
     * @return 成为C端经纪人时间
     */
    public final Date getBectime() {
        return bectime;
    }

    /** 
     * 设置 成为C端经纪人时间 userprofile.beCTime
     * @param bectime 成为C端经纪人时间
     */
    public final void setBectime(Date bectime) {
        this.bectime = bectime;
    }

    /** 
     * 获取 更新时间 userprofile.updateTime
     * @return 更新时间
     */
    public final Date getUpdatetime() {
        return updatetime;
    }

    /** 
     * 设置 更新时间 userprofile.updateTime
     * @param updatetime 更新时间
     */
    public final void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    /** 
     * 获取 用户标签，C:C端经纪人 userprofile.userTag
     * @return 用户标签，C:C端经纪人
     */
    public final String getUsertag() {
        return usertag;
    }

    /** 
     * 设置 用户标签，C:C端经纪人 userprofile.userTag
     * @param usertag 用户标签，C:C端经纪人
     */
    public final void setUsertag(String usertag) {
        this.usertag = usertag;
    }

    /** 
     * 获取 用户联系方式 userprofile.contactway
     * @return 用户联系方式
     */
    public final String getContactway() {
        return contactway;
    }

    /** 
     * 设置 用户联系方式 userprofile.contactway
     * @param contactway 用户联系方式
     */
    public final void setContactway(String contactway) {
        this.contactway = contactway;
    }

    /** 
     * 获取 顺风openid userprofile.sfOpenId
     * @return 顺风openid
     */
    public final String getSfopenid() {
        return sfopenid;
    }

    /** 
     * 设置 顺风openid userprofile.sfOpenId
     * @param sfopenid 顺风openid
     */
    public final void setSfopenid(String sfopenid) {
        this.sfopenid = sfopenid;
    }

    /** 
     * 获取 顺风channelNo userprofile.sfChannelNo
     * @return 顺风channelNo
     */
    public final String getSfchannelno() {
        return sfchannelno;
    }

    /** 
     * 设置 顺风channelNo userprofile.sfChannelNo
     * @param sfchannelno 顺风channelNo
     */
    public final void setSfchannelno(String sfchannelno) {
        this.sfchannelno = sfchannelno;
    }

    /** 
     * 获取 上次登录时间 userprofile.LastLoginTime
     * @return 上次登录时间
     */
    public final Date getLastlogintime() {
        return lastlogintime;
    }

    /** 
     * 设置 上次登录时间 userprofile.LastLoginTime
     * @param lastlogintime 上次登录时间
     */
    public final void setLastlogintime(Date lastlogintime) {
        this.lastlogintime = lastlogintime;
    }

    /** 
     * 获取 密码修改延期次数 userprofile.pwdModifyDelay
     * @return 密码修改延期次数
     */
    public final Integer getPwdmodifydelay() {
        return pwdmodifydelay;
    }

    /** 
     * 设置 密码修改延期次数 userprofile.pwdModifyDelay
     * @param pwdmodifydelay 密码修改延期次数
     */
    public final void setPwdmodifydelay(Integer pwdmodifydelay) {
        this.pwdmodifydelay = pwdmodifydelay;
    }

    /** 
     * 获取 密码修改时间 userprofile.pwdModifyTime
     * @return 密码修改时间
     */
    public final Date getPwdmodifytime() {
        return pwdmodifytime;
    }

    /** 
     * 设置 密码修改时间 userprofile.pwdModifyTime
     * @param pwdmodifytime 密码修改时间
     */
    public final void setPwdmodifytime(Date pwdmodifytime) {
        this.pwdmodifytime = pwdmodifytime;
    }

    /** 
     * 获取 统一支付密码 userprofile.dealpwd
     * @return 统一支付密码
     */
    public final String getDealpwd() {
        return dealpwd;
    }

    /** 
     * 设置 统一支付密码 userprofile.dealpwd
     * @param dealpwd 统一支付密码
     */
    public final void setDealpwd(String dealpwd) {
        this.dealpwd = dealpwd;
    }

    /** 
     * 获取 大数据数据来源 userprofile.bigdataSource
     * @return 大数据数据来源
     */
    public final String getBigdatasource() {
        return bigdatasource;
    }

    /** 
     * 设置 大数据数据来源 userprofile.bigdataSource
     * @param bigdatasource 大数据数据来源
     */
    public final void setBigdatasource(String bigdatasource) {
        this.bigdatasource = bigdatasource;
    }

    /** 
     * 获取 用户大数据一级渠道标记导入日期 userprofile.bigdataSourceTime
     * @return 用户大数据一级渠道标记导入日期
     */
    public final String getBigdatasourcetime() {
        return bigdatasourcetime;
    }

    /** 
     * 设置 用户大数据一级渠道标记导入日期 userprofile.bigdataSourceTime
     * @param bigdatasourcetime 用户大数据一级渠道标记导入日期
     */
    public final void setBigdatasourcetime(String bigdatasourcetime) {
        this.bigdatasourcetime = bigdatasourcetime;
    }

    @Override
    public final boolean equals(Object that) {
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
            && (this.getSfchannelno() == null ? other.getSfchannelno() == null : this.getSfchannelno().equals(other.getSfchannelno()))
            && (this.getLastlogintime() == null ? other.getLastlogintime() == null : this.getLastlogintime().equals(other.getLastlogintime()))
            && (this.getPwdmodifydelay() == null ? other.getPwdmodifydelay() == null : this.getPwdmodifydelay().equals(other.getPwdmodifydelay()))
            && (this.getPwdmodifytime() == null ? other.getPwdmodifytime() == null : this.getPwdmodifytime().equals(other.getPwdmodifytime()))
            && (this.getDealpwd() == null ? other.getDealpwd() == null : this.getDealpwd().equals(other.getDealpwd()))
            && (this.getBigdatasource() == null ? other.getBigdatasource() == null : this.getBigdatasource().equals(other.getBigdatasource()))
            && (this.getBigdatasourcetime() == null ? other.getBigdatasourcetime() == null : this.getBigdatasourcetime().equals(other.getBigdatasourcetime()));
    }

    @Override
    public final int hashCode() {
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
        result = prime * result + ((getLastlogintime() == null) ? 0 : getLastlogintime().hashCode());
        result = prime * result + ((getPwdmodifydelay() == null) ? 0 : getPwdmodifydelay().hashCode());
        result = prime * result + ((getPwdmodifytime() == null) ? 0 : getPwdmodifytime().hashCode());
        result = prime * result + ((getDealpwd() == null) ? 0 : getDealpwd().hashCode());
        result = prime * result + ((getBigdatasource() == null) ? 0 : getBigdatasource().hashCode());
        result = prime * result + ((getBigdatasourcetime() == null) ? 0 : getBigdatasourcetime().hashCode());
        return result;
    }

    @Override
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serialVersionUID=").append(serialVersionUID);
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
        sb.append(", lastlogintime=").append(lastlogintime);
        sb.append(", pwdmodifydelay=").append(pwdmodifydelay);
        sb.append(", pwdmodifytime=").append(pwdmodifytime);
        sb.append(", dealpwd=").append(dealpwd);
        sb.append(", bigdatasource=").append(bigdatasource);
        sb.append(", bigdatasourcetime=").append(bigdatasourcetime);
        sb.append("]");
        return sb.toString();
    }
}