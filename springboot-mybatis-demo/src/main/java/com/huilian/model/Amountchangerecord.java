 /** 本文件由 工具自动生成自动生成 https://github.com/real52010/mybatis-generator.git*/
package com.huilian.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/** 
 * 账户资金变动流水 0正常1删除
 * @author real code generator
 * date:2018-07-18 18:10:52
 */
public class Amountchangerecord implements Serializable {
    /**串行版本ID**/
    private static final long serialVersionUID = 2451589693866876446L;

    /** 
     * 主键自增
     */ 
    private Long id;

    /** 
     * 交易流水
     */ 
    private String transactionid;

    /** 
     *      0:线上充值 1:线上订购（冻结） 2:提现 3:本金返还 4:利息返还
                                     5:线下预订购(POS刷卡) 6:送现金 7:水位线超时退款 8:C端提现手续费
                                      9:扣除产品券价值 10:冻结金额返回余额 a:流标退款 b:线下充值
                                     c:线上补订 d:线下订购(一步到位) e:验券后收益调整 f:代付本金给开发商
                                      g:代付利息给开发商 h:代付券价值和券收益调整给开发商 i:线下退款 j:代扣费用 l 调账
     */ 
    private String type;

    /** 
     * 状态(0成功 1失败,2 待审核,3 充值处理中)
     */ 
    private String status;

    /** 
     * 操作金额
     */ 
    private BigDecimal changeamount;

    /** 
     * 帐户余额
     */ 
    private BigDecimal amount;

    /** 
     * 操作时间
     */ 
    private Date createtime;

    /** 
     * UserID
     */ 
    private String userid;

    /** 
     * 备注（扩展字段）
     */ 
    private String remark;

    /** 
     * 银行卡号
     */ 
    private String bankcard;

    /** 
     * 银行编码
     */ 
    private String bankcode;

    /** 
     * 关联产品ID
     */ 
    private String productid;

    /** 
     * 关联订购关系ID
     */ 
    private String purchaserecordid;

    private Short dataSource;

    /** 
     * 0正常1删除
     * 默认：0
     */ 
    private Boolean dataStatus;

    /** 
     * 获取 主键自增 
     * @return 主键自增
     */
    public Long getId() {
        return id;
    }

    /** 
     * 设置 主键自增 
     * @param id 主键自增
     */
    public void setId(Long id) {
        this.id = id;
    }

    /** 
     * 获取 交易流水 
     * @return 交易流水
     */
    public String getTransactionid() {
        return transactionid;
    }

    /** 
     * 设置 交易流水 
     * @param transactionid 交易流水
     */
    public void setTransactionid(String transactionid) {
        this.transactionid = transactionid;
    }

    /** 
     * 获取      0:线上充值 1:线上订购（冻结） 2:提现 3:本金返还 4:利息返还
                                     5:线下预订购(POS刷卡) 6:送现金 7:水位线超时退款 8:C端提现手续费
                                      9:扣除产品券价值 10:冻结金额返回余额 a:流标退款 b:线下充值
                                     c:线上补订 d:线下订购(一步到位) e:验券后收益调整 f:代付本金给开发商
                                      g:代付利息给开发商 h:代付券价值和券收益调整给开发商 i:线下退款 j:代扣费用 l 调账 
     * @return      0:线上充值 1:线上订购（冻结） 2:提现 3:本金返还 4:利息返还
                                     5:线下预订购(POS刷卡) 6:送现金 7:水位线超时退款 8:C端提现手续费
                                      9:扣除产品券价值 10:冻结金额返回余额 a:流标退款 b:线下充值
                                     c:线上补订 d:线下订购(一步到位) e:验券后收益调整 f:代付本金给开发商
                                      g:代付利息给开发商 h:代付券价值和券收益调整给开发商 i:线下退款 j:代扣费用 l 调账
     */
    public String getType() {
        return type;
    }

    /** 
     * 设置      0:线上充值 1:线上订购（冻结） 2:提现 3:本金返还 4:利息返还
                                     5:线下预订购(POS刷卡) 6:送现金 7:水位线超时退款 8:C端提现手续费
                                      9:扣除产品券价值 10:冻结金额返回余额 a:流标退款 b:线下充值
                                     c:线上补订 d:线下订购(一步到位) e:验券后收益调整 f:代付本金给开发商
                                      g:代付利息给开发商 h:代付券价值和券收益调整给开发商 i:线下退款 j:代扣费用 l 调账 
     * @param type      0:线上充值 1:线上订购（冻结） 2:提现 3:本金返还 4:利息返还
                                     5:线下预订购(POS刷卡) 6:送现金 7:水位线超时退款 8:C端提现手续费
                                      9:扣除产品券价值 10:冻结金额返回余额 a:流标退款 b:线下充值
                                     c:线上补订 d:线下订购(一步到位) e:验券后收益调整 f:代付本金给开发商
                                      g:代付利息给开发商 h:代付券价值和券收益调整给开发商 i:线下退款 j:代扣费用 l 调账
     */
    public void setType(String type) {
        this.type = type;
    }

    /** 
     * 获取 状态(0成功 1失败,2 待审核,3 充值处理中) 
     * @return 状态(0成功 1失败,2 待审核,3 充值处理中)
     */
    public String getStatus() {
        return status;
    }

    /** 
     * 设置 状态(0成功 1失败,2 待审核,3 充值处理中) 
     * @param status 状态(0成功 1失败,2 待审核,3 充值处理中)
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /** 
     * 获取 操作金额 
     * @return 操作金额
     */
    public BigDecimal getChangeamount() {
        return changeamount;
    }

    /** 
     * 设置 操作金额 
     * @param changeamount 操作金额
     */
    public void setChangeamount(BigDecimal changeamount) {
        this.changeamount = changeamount;
    }

    /** 
     * 获取 帐户余额 
     * @return 帐户余额
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /** 
     * 设置 帐户余额 
     * @param amount 帐户余额
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /** 
     * 获取 操作时间 
     * @return 操作时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /** 
     * 设置 操作时间 
     * @param createtime 操作时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /** 
     * 获取 UserID 
     * @return UserID
     */
    public String getUserid() {
        return userid;
    }

    /** 
     * 设置 UserID 
     * @param userid UserID
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    /** 
     * 获取 备注（扩展字段） 
     * @return 备注（扩展字段）
     */
    public String getRemark() {
        return remark;
    }

    /** 
     * 设置 备注（扩展字段） 
     * @param remark 备注（扩展字段）
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /** 
     * 获取 银行卡号 
     * @return 银行卡号
     */
    public String getBankcard() {
        return bankcard;
    }

    /** 
     * 设置 银行卡号 
     * @param bankcard 银行卡号
     */
    public void setBankcard(String bankcard) {
        this.bankcard = bankcard;
    }

    /** 
     * 获取 银行编码 
     * @return 银行编码
     */
    public String getBankcode() {
        return bankcode;
    }

    /** 
     * 设置 银行编码 
     * @param bankcode 银行编码
     */
    public void setBankcode(String bankcode) {
        this.bankcode = bankcode;
    }

    /** 
     * 获取 关联产品ID 
     * @return 关联产品ID
     */
    public String getProductid() {
        return productid;
    }

    /** 
     * 设置 关联产品ID 
     * @param productid 关联产品ID
     */
    public void setProductid(String productid) {
        this.productid = productid;
    }

    /** 
     * 获取 关联订购关系ID 
     * @return 关联订购关系ID
     */
    public String getPurchaserecordid() {
        return purchaserecordid;
    }

    /** 
     * 设置 关联订购关系ID 
     * @param purchaserecordid 关联订购关系ID
     */
    public void setPurchaserecordid(String purchaserecordid) {
        this.purchaserecordid = purchaserecordid;
    }

    /** 
     * 获取 amountchangerecord.data_source
     * @return amountchangerecord.data_source
     */
    public Short getDataSource() {
        return dataSource;
    }

    /** 
     * 设置 amountchangerecord.data_source
     * @param dataSource amountchangerecord.data_source
     */
    public void setDataSource(Short dataSource) {
        this.dataSource = dataSource;
    }

    /** 
     * 获取 0正常1删除 
     * @return 0正常1删除
     */
    public Boolean getDataStatus() {
        return dataStatus;
    }

    /** 
     * 设置 0正常1删除 
     * @param dataStatus 0正常1删除
     */
    public void setDataStatus(Boolean dataStatus) {
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
        Amountchangerecord other = (Amountchangerecord) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTransactionid() == null ? other.getTransactionid() == null : this.getTransactionid().equals(other.getTransactionid()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getChangeamount() == null ? other.getChangeamount() == null : this.getChangeamount().equals(other.getChangeamount()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getBankcard() == null ? other.getBankcard() == null : this.getBankcard().equals(other.getBankcard()))
            && (this.getBankcode() == null ? other.getBankcode() == null : this.getBankcode().equals(other.getBankcode()))
            && (this.getProductid() == null ? other.getProductid() == null : this.getProductid().equals(other.getProductid()))
            && (this.getPurchaserecordid() == null ? other.getPurchaserecordid() == null : this.getPurchaserecordid().equals(other.getPurchaserecordid()))
            && (this.getDataSource() == null ? other.getDataSource() == null : this.getDataSource().equals(other.getDataSource()))
            && (this.getDataStatus() == null ? other.getDataStatus() == null : this.getDataStatus().equals(other.getDataStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTransactionid() == null) ? 0 : getTransactionid().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getChangeamount() == null) ? 0 : getChangeamount().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getBankcard() == null) ? 0 : getBankcard().hashCode());
        result = prime * result + ((getBankcode() == null) ? 0 : getBankcode().hashCode());
        result = prime * result + ((getProductid() == null) ? 0 : getProductid().hashCode());
        result = prime * result + ((getPurchaserecordid() == null) ? 0 : getPurchaserecordid().hashCode());
        result = prime * result + ((getDataSource() == null) ? 0 : getDataSource().hashCode());
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
        sb.append(", transactionid=").append(transactionid);
        sb.append(", type=").append(type);
        sb.append(", status=").append(status);
        sb.append(", changeamount=").append(changeamount);
        sb.append(", amount=").append(amount);
        sb.append(", createtime=").append(createtime);
        sb.append(", userid=").append(userid);
        sb.append(", remark=").append(remark);
        sb.append(", bankcard=").append(bankcard);
        sb.append(", bankcode=").append(bankcode);
        sb.append(", productid=").append(productid);
        sb.append(", purchaserecordid=").append(purchaserecordid);
        sb.append(", dataSource=").append(dataSource);
        sb.append(", dataStatus=").append(dataStatus);
        sb.append("]");
        return sb.toString();
    }
}