 /** 本文件由 工具自动生成自动生成 https://github.com/real52010/mybatis-generator.git*/
package com.huilian.hyf.order.dao;

import com.huilian.hyf.order.model.AmountChangeRecordEntity;
import com.huilian.hyf.order.model.Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 账户资金变动流水 0正常1删除<br/>
 * @author real code generator
 * date:2018-07-23 00:21:47
 */
public interface AmountChangeRecordMapper {
    /** 
     * 添加对象所有字段
     * @param record 插入字段对象(必须含ID）
     */
    int insert(@Param("record") AmountChangeRecordEntity record);

    /** 
     * 添加List集合对象所有字段
     * @param list
     */
    int insertBatch(List<AmountChangeRecordEntity> list);

    /** 
     *
     * @param id 主键ID
     */
    int deleteById(Long id);

    /**
    * 根据transactionID删除
    * @param transactionID 交易流水
    **/
    int deleteByTransactionID(@Param("transactionID") String transactionID);

    /**
    * 根据type删除
    * @param type      0:线上充值 1:线上订购（冻结） 2:提现 3:本金返还 4:利息返还
                                     5:线下预订购(POS刷卡) 6:送现金 7:水位线超时退款 8:C端提现手续费
                                      9:扣除产品券价值 10:冻结金额返回余额 a:流标退款 b:线下充值
                                     c:线上补订 d:线下订购(一步到位) e:验券后收益调整 f:代付本金给开发商
                                      g:代付利息给开发商 h:代付券价值和券收益调整给开发商 i:线下退款 j:代扣费用 l 调账
    **/
    int deleteByType(@Param("type") String type);

    /**
    * 根据status删除
    * @param status 状态(0成功 1失败,2 待审核,3 充值处理中)
    **/
    int deleteByStatus(@Param("status") String status);

    /**
    * 根据userID删除
    * @param userID UserID
    **/
    int deleteByUserID(@Param("userID") String userID);

    /**
    * 根据productId删除
    * @param productId 关联产品ID
    **/
    int deleteByProductId(@Param("productId") String productId);

    /** 
     *  <strong>根据条件删除,该方法为虚拟删除,该方法要谨慎使用，如果example为空或其属性为空，会删除整表数据 </strong>
     * @param example 条件对象
     */
    
    int deleteByExample(@Param("example") Example example);

    /** 
     *
     * @param id 主键ID
     */
    int vDeleteById(Long id);

    /**
    * 根据transactionID删除,该方法为虚拟删除
    * @param transactionID 交易流水
    */
    int vDeleteByTransactionID(@Param("record") AmountChangeRecordEntity record, @Param("transactionID") String transactionID);

    /**
    * 根据type删除,该方法为虚拟删除
    * @param type      0:线上充值 1:线上订购（冻结） 2:提现 3:本金返还 4:利息返还
                                     5:线下预订购(POS刷卡) 6:送现金 7:水位线超时退款 8:C端提现手续费
                                      9:扣除产品券价值 10:冻结金额返回余额 a:流标退款 b:线下充值
                                     c:线上补订 d:线下订购(一步到位) e:验券后收益调整 f:代付本金给开发商
                                      g:代付利息给开发商 h:代付券价值和券收益调整给开发商 i:线下退款 j:代扣费用 l 调账
    */
    int vDeleteByType(@Param("record") AmountChangeRecordEntity record, @Param("type") String type);

    /**
    * 根据status删除,该方法为虚拟删除
    * @param status 状态(0成功 1失败,2 待审核,3 充值处理中)
    */
    int vDeleteByStatus(@Param("record") AmountChangeRecordEntity record, @Param("status") String status);

    /**
    * 根据userID删除,该方法为虚拟删除
    * @param userID UserID
    */
    int vDeleteByUserID(@Param("record") AmountChangeRecordEntity record, @Param("userID") String userID);

    /**
    * 根据productId删除,该方法为虚拟删除
    * @param productId 关联产品ID
    */
    int vDeleteByProductId(@Param("record") AmountChangeRecordEntity record, @Param("productId") String productId);

    /** 
     *
     * @param example 条件对象
     */
    
    int vDeleteByExample(@Param("example") Example example);

    /** 
     *
     * @param record 修改字段对象(必须含ID）
     * @param id 主键ID
     */
    int updateById(@Param("record") AmountChangeRecordEntity record, @Param("id") Long id);

    /**
    * 根据transactionID修改
    * @param transactionID 交易流水
    **/
    int updateByTransactionID(@Param("record") AmountChangeRecordEntity record, @Param("transactionID") String transactionID);

    /**
    * 根据type修改
    * @param type      0:线上充值 1:线上订购（冻结） 2:提现 3:本金返还 4:利息返还
                                     5:线下预订购(POS刷卡) 6:送现金 7:水位线超时退款 8:C端提现手续费
                                      9:扣除产品券价值 10:冻结金额返回余额 a:流标退款 b:线下充值
                                     c:线上补订 d:线下订购(一步到位) e:验券后收益调整 f:代付本金给开发商
                                      g:代付利息给开发商 h:代付券价值和券收益调整给开发商 i:线下退款 j:代扣费用 l 调账
    **/
    int updateByType(@Param("record") AmountChangeRecordEntity record, @Param("type") String type);

    /**
    * 根据status修改
    * @param status 状态(0成功 1失败,2 待审核,3 充值处理中)
    **/
    int updateByStatus(@Param("record") AmountChangeRecordEntity record, @Param("status") String status);

    /**
    * 根据userID修改
    * @param userID UserID
    **/
    int updateByUserID(@Param("record") AmountChangeRecordEntity record, @Param("userID") String userID);

    /**
    * 根据productId修改
    * @param productId 关联产品ID
    **/
    int updateByProductId(@Param("record") AmountChangeRecordEntity record, @Param("productId") String productId);

    /** 
     * 根据条件修改所有字段
     * @param record 修改字段对象 (JOPO)
     * @param example 条件对象
     */
    int updateByExample(@Param("record") AmountChangeRecordEntity record, @Param("example") Example example);

    /** 
     *
     * @param record 修改字段对象(必须含ID）
     */
    int updateBySelective(@Param("record") AmountChangeRecordEntity record);

    /** 
     * 根据列表里的字段批量修改
     * @param list
     */
    int updateBatchBySelective(List<AmountChangeRecordEntity> list);

    /** 
     *
     * @param id 主键ID
     */
    AmountChangeRecordEntity selectById(Long id);

    /** 
     * 根据条件查询
     * @param example 条件对象
     */
    List<AmountChangeRecordEntity> selectByExample(@Param("example") Example example);

    /**
    * 根据transactionID查询，暂不支持分页查询
    * @param transactionID 交易流水
    **/
    List<AmountChangeRecordEntity> selectByTransactionID(String transactionID);

    /**
    * 根据type查询，暂不支持分页查询
    * @param type      0:线上充值 1:线上订购（冻结） 2:提现 3:本金返还 4:利息返还
                                     5:线下预订购(POS刷卡) 6:送现金 7:水位线超时退款 8:C端提现手续费
                                      9:扣除产品券价值 10:冻结金额返回余额 a:流标退款 b:线下充值
                                     c:线上补订 d:线下订购(一步到位) e:验券后收益调整 f:代付本金给开发商
                                      g:代付利息给开发商 h:代付券价值和券收益调整给开发商 i:线下退款 j:代扣费用 l 调账
    **/
    List<AmountChangeRecordEntity> selectByType(String type);

    /**
    * 根据status查询，暂不支持分页查询
    * @param status 状态(0成功 1失败,2 待审核,3 充值处理中)
    **/
    List<AmountChangeRecordEntity> selectByStatus(String status);

    /**
    * 根据userID查询，暂不支持分页查询
    * @param userID UserID
    **/
    List<AmountChangeRecordEntity> selectByUserID(String userID);

    /**
    * 根据productId查询，暂不支持分页查询
    * @param productId 关联产品ID
    **/
    List<AmountChangeRecordEntity> selectByProductId(String productId);

    /** 
     * 查询数量
     * @param example 条件对象
     */
    int countByExample(@Param("example") Example example);
}