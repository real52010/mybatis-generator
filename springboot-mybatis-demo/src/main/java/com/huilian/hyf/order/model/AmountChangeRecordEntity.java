 /** 本文件由 工具自动生成自动生成 https://github.com/real52010/mybatis-generator.git*/
package com.huilian.hyf.order.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/** 
 * 账户资金变动流水 0正常1删除
 * @author real code generator
 * date:2018-07-23 00:21:47
 */
public class AmountChangeRecordEntity implements Serializable {
    /**串行版本ID**/
    private static final long serialVersionUID = 3266534883002651656L;

    /** 
     * 主键自增
     */ 
    private Long id;

    /** 
     * 交易流水
     */ 
    private String transactionID;

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
    private BigDecimal changeAmount;

    /** 
     * 帐户余额
     */ 
    private BigDecimal amount;

    /** 
     * 操作时间
     */ 
    private Date createTime;

    /** 
     * UserID
     */ 
    private String userID;

    /** 
     * 备注（扩展字段）
     */ 
    private String remark;

    /** 
     * 银行卡号
     */ 
    private String bankCard;

    /** 
     * 银行编码
     */ 
    private String bankCode;

    /** 
     * 关联产品ID
     */ 
    private String productId;

    /** 
     * 关联订购关系ID
     */ 
    private String purchaseRecordId;

    private Integer dataSource;

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
    public String getTransactionID() {
        return transactionID;
    }

    /** 
     * 设置 交易流水 
     * @param transactionID 交易流水
     */
    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
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
    public BigDecimal getChangeAmount() {
        return changeAmount;
    }

    /** 
     * 设置 操作金额 
     * @param changeAmount 操作金额
     */
    public void setChangeAmount(BigDecimal changeAmount) {
        this.changeAmount = changeAmount;
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
    public Date getCreateTime() {
        return createTime;
    }

    /** 
     * 设置 操作时间 
     * @param createTime 操作时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /** 
     * 获取 UserID 
     * @return UserID
     */
    public String getUserID() {
        return userID;
    }

    /** 
     * 设置 UserID 
     * @param userID UserID
     */
    public void setUserID(String userID) {
        this.userID = userID;
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
    public String getBankCard() {
        return bankCard;
    }

    /** 
     * 设置 银行卡号 
     * @param bankCard 银行卡号
     */
    public void setBankCard(String bankCard) {
        this.bankCard = bankCard;
    }

    /** 
     * 获取 银行编码 
     * @return 银行编码
     */
    public String getBankCode() {
        return bankCode;
    }

    /** 
     * 设置 银行编码 
     * @param bankCode 银行编码
     */
    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    /** 
     * 获取 关联产品ID 
     * @return 关联产品ID
     */
    public String getProductId() {
        return productId;
    }

    /** 
     * 设置 关联产品ID 
     * @param productId 关联产品ID
     */
    public void setProductId(String productId) {
        this.productId = productId;
    }

    /** 
     * 获取 关联订购关系ID 
     * @return 关联订购关系ID
     */
    public String getPurchaseRecordId() {
        return purchaseRecordId;
    }

    /** 
     * 设置 关联订购关系ID 
     * @param purchaseRecordId 关联订购关系ID
     */
    public void setPurchaseRecordId(String purchaseRecordId) {
        this.purchaseRecordId = purchaseRecordId;
    }

    /** 
     * 获取 amountchangerecord.data_source
     * @return amountchangerecord.data_source
     */
    public Integer getDataSource() {
        return dataSource;
    }

    /** 
     * 设置 amountchangerecord.data_source
     * @param dataSource amountchangerecord.data_source
     */
    public void setDataSource(Integer dataSource) {
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
        AmountChangeRecordEntity other = (AmountChangeRecordEntity) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTransactionID() == null ? other.getTransactionID() == null : this.getTransactionID().equals(other.getTransactionID()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getChangeAmount() == null ? other.getChangeAmount() == null : this.getChangeAmount().equals(other.getChangeAmount()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUserID() == null ? other.getUserID() == null : this.getUserID().equals(other.getUserID()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getBankCard() == null ? other.getBankCard() == null : this.getBankCard().equals(other.getBankCard()))
            && (this.getBankCode() == null ? other.getBankCode() == null : this.getBankCode().equals(other.getBankCode()))
            && (this.getProductId() == null ? other.getProductId() == null : this.getProductId().equals(other.getProductId()))
            && (this.getPurchaseRecordId() == null ? other.getPurchaseRecordId() == null : this.getPurchaseRecordId().equals(other.getPurchaseRecordId()))
            && (this.getDataSource() == null ? other.getDataSource() == null : this.getDataSource().equals(other.getDataSource()))
            && (this.getDataStatus() == null ? other.getDataStatus() == null : this.getDataStatus().equals(other.getDataStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTransactionID() == null) ? 0 : getTransactionID().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getChangeAmount() == null) ? 0 : getChangeAmount().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUserID() == null) ? 0 : getUserID().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getBankCard() == null) ? 0 : getBankCard().hashCode());
        result = prime * result + ((getBankCode() == null) ? 0 : getBankCode().hashCode());
        result = prime * result + ((getProductId() == null) ? 0 : getProductId().hashCode());
        result = prime * result + ((getPurchaseRecordId() == null) ? 0 : getPurchaseRecordId().hashCode());
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
        sb.append(", transactionID=").append(transactionID);
        sb.append(", type=").append(type);
        sb.append(", status=").append(status);
        sb.append(", changeAmount=").append(changeAmount);
        sb.append(", amount=").append(amount);
        sb.append(", createTime=").append(createTime);
        sb.append(", userID=").append(userID);
        sb.append(", remark=").append(remark);
        sb.append(", bankCard=").append(bankCard);
        sb.append(", bankCode=").append(bankCode);
        sb.append(", productId=").append(productId);
        sb.append(", purchaseRecordId=").append(purchaseRecordId);
        sb.append(", dataSource=").append(dataSource);
        sb.append(", dataStatus=").append(dataStatus);
        sb.append("]");
        return sb.toString();
    }
}