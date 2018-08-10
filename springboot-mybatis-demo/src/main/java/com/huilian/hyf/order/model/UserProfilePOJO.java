 /** 本文件由 工具自动生成自动生成 https://github.com/real52010/mybatis-generator.git*/
package com.huilian.hyf.order.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/** 
 * 用户帐号信息 三要素校验手机号
 * @author real code generator
 * date:2018-07-23 17:35:54
 */
public class UserProfilePOJO implements Serializable {
    /**串行版本ID**/
    private static final long serialVersionUID = -4348716431136966700L;

    /** 
     * 用户ID UUID
     */ 
    private String userID;

    private String phoneNum;

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
     * 在线状态
            1 在线
            2离线
     */ 
    private String onlineStatus;

    /** 
     * 在线状态更新时间
     */ 
    private Date onlineStatusUpdate;

    /** 
     * 注册时间
     */ 
    private Date regDate;

    /** 
     * 帐户资金
     */ 
    private BigDecimal amount;

    /** 
     * 账户冻结资金
     */ 
    private BigDecimal frozenAmount;

    /** 
     * 备注
     */ 
    private String remark;

    private Long hlcId;

    private Integer dataSource;

    /** 
     * 用户来源(0 线上注册 1 线下刷卡 2 汇理财用户 3 后台管理员创建  )
     * 默认：0
     */ 
    private String source;

    /** 
     * 推荐人
     */ 
    private String referee;

    private String usrChannel;

    /** 
     * 渠道来源编码id
     */ 
    private String qqOpenId;

    /** 
     * 成为C端经纪人时间
     */ 
    private Date beCTime;

    /** 
     * 更新时间
     */ 
    private Date updateTime;

    /** 
     * 用户标签，C:C端经纪人
     */ 
    private String userTag;

    /** 
     * 用户联系方式
     */ 
    private String contactway;

    /** 
     * 顺风openid
     */ 
    private String sfOpenId;

    /** 
     * 顺风channelNo
     */ 
    private String sfChannelNo;

    /** 
     * 上次登录时间
     */ 
    private Date lastLoginTime;

    /** 
     * 密码修改延期次数
     * 默认：1
     */ 
    private Integer pwdModifyDelay;

    /** 
     * 密码修改时间
     */ 
    private Date pwdModifyTime;

    /** 
     * 统一支付密码
     */ 
    private String dealpwd;

    /** 
     * 大数据数据来源
     */ 
    private String bigdataSource;

    /** 
     * 用户大数据一级渠道标记导入日期
     */ 
    private String bigdataSourceTime;

    /** 
     * 三要素校验状态:0.未校验;1.校验通过;2.校验未通过
     * 默认：0
     */ 
    private Integer threeVerifyStatus;

    /** 
     * 三要素校验手机号
     */ 
    private String verifyPhone;

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
     * 获取 userprofile.PhoneNum
     * @return userprofile.PhoneNum
     */
    public String getPhoneNum() {
        return phoneNum;
    }

    /** 
     * 设置 userprofile.PhoneNum
     * @param phoneNum userprofile.PhoneNum
     */
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
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
     * 获取 在线状态
            1 在线
            2离线 
     * @return 在线状态
            1 在线
            2离线
     */
    public String getOnlineStatus() {
        return onlineStatus;
    }

    /** 
     * 设置 在线状态
            1 在线
            2离线 
     * @param onlineStatus 在线状态
            1 在线
            2离线
     */
    public void setOnlineStatus(String onlineStatus) {
        this.onlineStatus = onlineStatus;
    }

    /** 
     * 获取 在线状态更新时间 
     * @return 在线状态更新时间
     */
    public Date getOnlineStatusUpdate() {
        return onlineStatusUpdate;
    }

    /** 
     * 设置 在线状态更新时间 
     * @param onlineStatusUpdate 在线状态更新时间
     */
    public void setOnlineStatusUpdate(Date onlineStatusUpdate) {
        this.onlineStatusUpdate = onlineStatusUpdate;
    }

    /** 
     * 获取 注册时间 
     * @return 注册时间
     */
    public Date getRegDate() {
        return regDate;
    }

    /** 
     * 设置 注册时间 
     * @param regDate 注册时间
     */
    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    /** 
     * 获取 帐户资金 
     * @return 帐户资金
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /** 
     * 设置 帐户资金 
     * @param amount 帐户资金
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /** 
     * 获取 账户冻结资金 
     * @return 账户冻结资金
     */
    public BigDecimal getFrozenAmount() {
        return frozenAmount;
    }

    /** 
     * 设置 账户冻结资金 
     * @param frozenAmount 账户冻结资金
     */
    public void setFrozenAmount(BigDecimal frozenAmount) {
        this.frozenAmount = frozenAmount;
    }

    /** 
     * 获取 备注 
     * @return 备注
     */
    public String getRemark() {
        return remark;
    }

    /** 
     * 设置 备注 
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /** 
     * 获取 userprofile.hlc_id
     * @return userprofile.hlc_id
     */
    public Long getHlcId() {
        return hlcId;
    }

    /** 
     * 设置 userprofile.hlc_id
     * @param hlcId userprofile.hlc_id
     */
    public void setHlcId(Long hlcId) {
        this.hlcId = hlcId;
    }

    /** 
     * 获取 userprofile.data_source
     * @return userprofile.data_source
     */
    public Integer getDataSource() {
        return dataSource;
    }

    /** 
     * 设置 userprofile.data_source
     * @param dataSource userprofile.data_source
     */
    public void setDataSource(Integer dataSource) {
        this.dataSource = dataSource;
    }

    /** 
     * 获取 用户来源(0 线上注册 1 线下刷卡 2 汇理财用户 3 后台管理员创建  ) 
     * @return 用户来源(0 线上注册 1 线下刷卡 2 汇理财用户 3 后台管理员创建  )
     */
    public String getSource() {
        return source;
    }

    /** 
     * 设置 用户来源(0 线上注册 1 线下刷卡 2 汇理财用户 3 后台管理员创建  ) 
     * @param source 用户来源(0 线上注册 1 线下刷卡 2 汇理财用户 3 后台管理员创建  )
     */
    public void setSource(String source) {
        this.source = source;
    }

    /** 
     * 获取 推荐人 
     * @return 推荐人
     */
    public String getReferee() {
        return referee;
    }

    /** 
     * 设置 推荐人 
     * @param referee 推荐人
     */
    public void setReferee(String referee) {
        this.referee = referee;
    }

    /** 
     * 获取 userprofile.usrChannel
     * @return userprofile.usrChannel
     */
    public String getUsrChannel() {
        return usrChannel;
    }

    /** 
     * 设置 userprofile.usrChannel
     * @param usrChannel userprofile.usrChannel
     */
    public void setUsrChannel(String usrChannel) {
        this.usrChannel = usrChannel;
    }

    /** 
     * 获取 渠道来源编码id 
     * @return 渠道来源编码id
     */
    public String getQqOpenId() {
        return qqOpenId;
    }

    /** 
     * 设置 渠道来源编码id 
     * @param qqOpenId 渠道来源编码id
     */
    public void setQqOpenId(String qqOpenId) {
        this.qqOpenId = qqOpenId;
    }

    /** 
     * 获取 成为C端经纪人时间 
     * @return 成为C端经纪人时间
     */
    public Date getBeCTime() {
        return beCTime;
    }

    /** 
     * 设置 成为C端经纪人时间 
     * @param beCTime 成为C端经纪人时间
     */
    public void setBeCTime(Date beCTime) {
        this.beCTime = beCTime;
    }

    /** 
     * 获取 更新时间 
     * @return 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /** 
     * 设置 更新时间 
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /** 
     * 获取 用户标签，C:C端经纪人 
     * @return 用户标签，C:C端经纪人
     */
    public String getUserTag() {
        return userTag;
    }

    /** 
     * 设置 用户标签，C:C端经纪人 
     * @param userTag 用户标签，C:C端经纪人
     */
    public void setUserTag(String userTag) {
        this.userTag = userTag;
    }

    /** 
     * 获取 用户联系方式 
     * @return 用户联系方式
     */
    public String getContactway() {
        return contactway;
    }

    /** 
     * 设置 用户联系方式 
     * @param contactway 用户联系方式
     */
    public void setContactway(String contactway) {
        this.contactway = contactway;
    }

    /** 
     * 获取 顺风openid 
     * @return 顺风openid
     */
    public String getSfOpenId() {
        return sfOpenId;
    }

    /** 
     * 设置 顺风openid 
     * @param sfOpenId 顺风openid
     */
    public void setSfOpenId(String sfOpenId) {
        this.sfOpenId = sfOpenId;
    }

    /** 
     * 获取 顺风channelNo 
     * @return 顺风channelNo
     */
    public String getSfChannelNo() {
        return sfChannelNo;
    }

    /** 
     * 设置 顺风channelNo 
     * @param sfChannelNo 顺风channelNo
     */
    public void setSfChannelNo(String sfChannelNo) {
        this.sfChannelNo = sfChannelNo;
    }

    /** 
     * 获取 上次登录时间 
     * @return 上次登录时间
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    /** 
     * 设置 上次登录时间 
     * @param lastLoginTime 上次登录时间
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /** 
     * 获取 密码修改延期次数 
     * @return 密码修改延期次数
     */
    public Integer getPwdModifyDelay() {
        return pwdModifyDelay;
    }

    /** 
     * 设置 密码修改延期次数 
     * @param pwdModifyDelay 密码修改延期次数
     */
    public void setPwdModifyDelay(Integer pwdModifyDelay) {
        this.pwdModifyDelay = pwdModifyDelay;
    }

    /** 
     * 获取 密码修改时间 
     * @return 密码修改时间
     */
    public Date getPwdModifyTime() {
        return pwdModifyTime;
    }

    /** 
     * 设置 密码修改时间 
     * @param pwdModifyTime 密码修改时间
     */
    public void setPwdModifyTime(Date pwdModifyTime) {
        this.pwdModifyTime = pwdModifyTime;
    }

    /** 
     * 获取 统一支付密码 
     * @return 统一支付密码
     */
    public String getDealpwd() {
        return dealpwd;
    }

    /** 
     * 设置 统一支付密码 
     * @param dealpwd 统一支付密码
     */
    public void setDealpwd(String dealpwd) {
        this.dealpwd = dealpwd;
    }

    /** 
     * 获取 大数据数据来源 
     * @return 大数据数据来源
     */
    public String getBigdataSource() {
        return bigdataSource;
    }

    /** 
     * 设置 大数据数据来源 
     * @param bigdataSource 大数据数据来源
     */
    public void setBigdataSource(String bigdataSource) {
        this.bigdataSource = bigdataSource;
    }

    /** 
     * 获取 用户大数据一级渠道标记导入日期 
     * @return 用户大数据一级渠道标记导入日期
     */
    public String getBigdataSourceTime() {
        return bigdataSourceTime;
    }

    /** 
     * 设置 用户大数据一级渠道标记导入日期 
     * @param bigdataSourceTime 用户大数据一级渠道标记导入日期
     */
    public void setBigdataSourceTime(String bigdataSourceTime) {
        this.bigdataSourceTime = bigdataSourceTime;
    }

    /** 
     * 获取 三要素校验状态:0.未校验;1.校验通过;2.校验未通过 
     * @return 三要素校验状态:0.未校验;1.校验通过;2.校验未通过
     */
    public Integer getThreeVerifyStatus() {
        return threeVerifyStatus;
    }

    /** 
     * 设置 三要素校验状态:0.未校验;1.校验通过;2.校验未通过 
     * @param threeVerifyStatus 三要素校验状态:0.未校验;1.校验通过;2.校验未通过
     */
    public void setThreeVerifyStatus(Integer threeVerifyStatus) {
        this.threeVerifyStatus = threeVerifyStatus;
    }

    /** 
     * 获取 三要素校验手机号 
     * @return 三要素校验手机号
     */
    public String getVerifyPhone() {
        return verifyPhone;
    }

    /** 
     * 设置 三要素校验手机号 
     * @param verifyPhone 三要素校验手机号
     */
    public void setVerifyPhone(String verifyPhone) {
        this.verifyPhone = verifyPhone;
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
        UserProfilePOJO other = (UserProfilePOJO) that;
        return (this.getUserID() == null ? other.getUserID() == null : this.getUserID().equals(other.getUserID()))
            && (this.getPhoneNum() == null ? other.getPhoneNum() == null : this.getPhoneNum().equals(other.getPhoneNum()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getOnlineStatus() == null ? other.getOnlineStatus() == null : this.getOnlineStatus().equals(other.getOnlineStatus()))
            && (this.getOnlineStatusUpdate() == null ? other.getOnlineStatusUpdate() == null : this.getOnlineStatusUpdate().equals(other.getOnlineStatusUpdate()))
            && (this.getRegDate() == null ? other.getRegDate() == null : this.getRegDate().equals(other.getRegDate()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getFrozenAmount() == null ? other.getFrozenAmount() == null : this.getFrozenAmount().equals(other.getFrozenAmount()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getHlcId() == null ? other.getHlcId() == null : this.getHlcId().equals(other.getHlcId()))
            && (this.getDataSource() == null ? other.getDataSource() == null : this.getDataSource().equals(other.getDataSource()))
            && (this.getSource() == null ? other.getSource() == null : this.getSource().equals(other.getSource()))
            && (this.getReferee() == null ? other.getReferee() == null : this.getReferee().equals(other.getReferee()))
            && (this.getUsrChannel() == null ? other.getUsrChannel() == null : this.getUsrChannel().equals(other.getUsrChannel()))
            && (this.getQqOpenId() == null ? other.getQqOpenId() == null : this.getQqOpenId().equals(other.getQqOpenId()))
            && (this.getBeCTime() == null ? other.getBeCTime() == null : this.getBeCTime().equals(other.getBeCTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getUserTag() == null ? other.getUserTag() == null : this.getUserTag().equals(other.getUserTag()))
            && (this.getContactway() == null ? other.getContactway() == null : this.getContactway().equals(other.getContactway()))
            && (this.getSfOpenId() == null ? other.getSfOpenId() == null : this.getSfOpenId().equals(other.getSfOpenId()))
            && (this.getSfChannelNo() == null ? other.getSfChannelNo() == null : this.getSfChannelNo().equals(other.getSfChannelNo()))
            && (this.getLastLoginTime() == null ? other.getLastLoginTime() == null : this.getLastLoginTime().equals(other.getLastLoginTime()))
            && (this.getPwdModifyDelay() == null ? other.getPwdModifyDelay() == null : this.getPwdModifyDelay().equals(other.getPwdModifyDelay()))
            && (this.getPwdModifyTime() == null ? other.getPwdModifyTime() == null : this.getPwdModifyTime().equals(other.getPwdModifyTime()))
            && (this.getDealpwd() == null ? other.getDealpwd() == null : this.getDealpwd().equals(other.getDealpwd()))
            && (this.getBigdataSource() == null ? other.getBigdataSource() == null : this.getBigdataSource().equals(other.getBigdataSource()))
            && (this.getBigdataSourceTime() == null ? other.getBigdataSourceTime() == null : this.getBigdataSourceTime().equals(other.getBigdataSourceTime()))
            && (this.getThreeVerifyStatus() == null ? other.getThreeVerifyStatus() == null : this.getThreeVerifyStatus().equals(other.getThreeVerifyStatus()))
            && (this.getVerifyPhone() == null ? other.getVerifyPhone() == null : this.getVerifyPhone().equals(other.getVerifyPhone()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserID() == null) ? 0 : getUserID().hashCode());
        result = prime * result + ((getPhoneNum() == null) ? 0 : getPhoneNum().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getOnlineStatus() == null) ? 0 : getOnlineStatus().hashCode());
        result = prime * result + ((getOnlineStatusUpdate() == null) ? 0 : getOnlineStatusUpdate().hashCode());
        result = prime * result + ((getRegDate() == null) ? 0 : getRegDate().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getFrozenAmount() == null) ? 0 : getFrozenAmount().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getHlcId() == null) ? 0 : getHlcId().hashCode());
        result = prime * result + ((getDataSource() == null) ? 0 : getDataSource().hashCode());
        result = prime * result + ((getSource() == null) ? 0 : getSource().hashCode());
        result = prime * result + ((getReferee() == null) ? 0 : getReferee().hashCode());
        result = prime * result + ((getUsrChannel() == null) ? 0 : getUsrChannel().hashCode());
        result = prime * result + ((getQqOpenId() == null) ? 0 : getQqOpenId().hashCode());
        result = prime * result + ((getBeCTime() == null) ? 0 : getBeCTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getUserTag() == null) ? 0 : getUserTag().hashCode());
        result = prime * result + ((getContactway() == null) ? 0 : getContactway().hashCode());
        result = prime * result + ((getSfOpenId() == null) ? 0 : getSfOpenId().hashCode());
        result = prime * result + ((getSfChannelNo() == null) ? 0 : getSfChannelNo().hashCode());
        result = prime * result + ((getLastLoginTime() == null) ? 0 : getLastLoginTime().hashCode());
        result = prime * result + ((getPwdModifyDelay() == null) ? 0 : getPwdModifyDelay().hashCode());
        result = prime * result + ((getPwdModifyTime() == null) ? 0 : getPwdModifyTime().hashCode());
        result = prime * result + ((getDealpwd() == null) ? 0 : getDealpwd().hashCode());
        result = prime * result + ((getBigdataSource() == null) ? 0 : getBigdataSource().hashCode());
        result = prime * result + ((getBigdataSourceTime() == null) ? 0 : getBigdataSourceTime().hashCode());
        result = prime * result + ((getThreeVerifyStatus() == null) ? 0 : getThreeVerifyStatus().hashCode());
        result = prime * result + ((getVerifyPhone() == null) ? 0 : getVerifyPhone().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append(", userID=").append(userID);
        sb.append(", phoneNum=").append(phoneNum);
        sb.append(", password=").append(password);
        sb.append(", status=").append(status);
        sb.append(", onlineStatus=").append(onlineStatus);
        sb.append(", onlineStatusUpdate=").append(onlineStatusUpdate);
        sb.append(", regDate=").append(regDate);
        sb.append(", amount=").append(amount);
        sb.append(", frozenAmount=").append(frozenAmount);
        sb.append(", remark=").append(remark);
        sb.append(", hlcId=").append(hlcId);
        sb.append(", dataSource=").append(dataSource);
        sb.append(", source=").append(source);
        sb.append(", referee=").append(referee);
        sb.append(", usrChannel=").append(usrChannel);
        sb.append(", qqOpenId=").append(qqOpenId);
        sb.append(", beCTime=").append(beCTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", userTag=").append(userTag);
        sb.append(", contactway=").append(contactway);
        sb.append(", sfOpenId=").append(sfOpenId);
        sb.append(", sfChannelNo=").append(sfChannelNo);
        sb.append(", lastLoginTime=").append(lastLoginTime);
        sb.append(", pwdModifyDelay=").append(pwdModifyDelay);
        sb.append(", pwdModifyTime=").append(pwdModifyTime);
        sb.append(", dealpwd=").append(dealpwd);
        sb.append(", bigdataSource=").append(bigdataSource);
        sb.append(", bigdataSourceTime=").append(bigdataSourceTime);
        sb.append(", threeVerifyStatus=").append(threeVerifyStatus);
        sb.append(", verifyPhone=").append(verifyPhone);
        sb.append("]");
        return sb.toString();
    }
}