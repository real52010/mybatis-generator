 /** 本文件由 工具自动生成自动生成 https://github.com/real52010/mybatis-generator.git*/
package com.huilian.mapper;

import com.huilian.model.Amountchangerecord;
import com.huilian.model.Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 账户资金变动流水 0正常1删除<br/>
 * @author real code generator
 * date:2018-07-18 18:10:52
 */
public interface AmountchangerecordDAO {
    /** 
     * 添加对象所有字段
     * @param record 插入字段对象(必须含ID）
     */
    int insert(@Param("record") Amountchangerecord record);

    /** 
     * 添加List集合对象所有字段
     * @param list
     */
    int insertBatch(List<Amountchangerecord> list);

    /** 
     * 根据主键删除,该方法为物理删除
     * @param id 主键ID
     */
    int delete(Long id);

    /**
    * 根据transactionid删除
    * @param transactionid 交易流水
    **/
    int deleteByTransactionid(@Param("record") Amountchangerecord record, @Param("transactionid") String transactionid);

    /**
    * 根据id删除
    * @param id 主键自增
    **/
    int deleteById(@Param("record") Amountchangerecord record, @Param("id") Long id);

    /**
    * 根据type删除
    * @param type      0:线上充值 1:线上订购（冻结） 2:提现 3:本金返还 4:利息返还
                                     5:线下预订购(POS刷卡) 6:送现金 7:水位线超时退款 8:C端提现手续费
                                      9:扣除产品券价值 10:冻结金额返回余额 a:流标退款 b:线下充值
                                     c:线上补订 d:线下订购(一步到位) e:验券后收益调整 f:代付本金给开发商
                                      g:代付利息给开发商 h:代付券价值和券收益调整给开发商 i:线下退款 j:代扣费用 l 调账
    **/
    int deleteByType(@Param("record") Amountchangerecord record, @Param("type") String type);

    /**
    * 根据status删除
    * @param status 状态(0成功 1失败,2 待审核,3 充值处理中)
    **/
    int deleteByStatus(@Param("record") Amountchangerecord record, @Param("status") String status);

    /**
    * 根据userid删除
    * @param userid UserID
    **/
    int deleteByUserid(@Param("record") Amountchangerecord record, @Param("userid") String userid);

    /**
    * 根据productid删除
    * @param productid 关联产品ID
    **/
    int deleteByProductid(@Param("record") Amountchangerecord record, @Param("productid") String productid);

    /** 
     *  <strong>根据条件删除,该方法为虚拟删除,该方法要谨慎使用，如果example为空或其属性为空，会删除整表数据 </strong>
     * @param example 条件对象
     */
    
    int deleteByExample(@Param("example") Example example);

    /** 
     * 根据主键删除,该方法为物理删除
     * @param id 主键ID
     */
    int virtualDelete(Long id);

    /**
    * 根据transactionid删除,该方法为虚拟删除
    * @param transactionid 交易流水
    */
    int virtualDeleteByTransactionid(@Param("record") Amountchangerecord record, @Param("transactionid") String transactionid);

    /**
    * 根据id删除,该方法为虚拟删除
    * @param id 主键自增
    */
    int virtualDeleteById(@Param("record") Amountchangerecord record, @Param("id") Long id);

    /**
    * 根据type删除,该方法为虚拟删除
    * @param type      0:线上充值 1:线上订购（冻结） 2:提现 3:本金返还 4:利息返还
                                     5:线下预订购(POS刷卡) 6:送现金 7:水位线超时退款 8:C端提现手续费
                                      9:扣除产品券价值 10:冻结金额返回余额 a:流标退款 b:线下充值
                                     c:线上补订 d:线下订购(一步到位) e:验券后收益调整 f:代付本金给开发商
                                      g:代付利息给开发商 h:代付券价值和券收益调整给开发商 i:线下退款 j:代扣费用 l 调账
    */
    int virtualDeleteByType(@Param("record") Amountchangerecord record, @Param("type") String type);

    /**
    * 根据status删除,该方法为虚拟删除
    * @param status 状态(0成功 1失败,2 待审核,3 充值处理中)
    */
    int virtualDeleteByStatus(@Param("record") Amountchangerecord record, @Param("status") String status);

    /**
    * 根据userid删除,该方法为虚拟删除
    * @param userid UserID
    */
    int virtualDeleteByUserid(@Param("record") Amountchangerecord record, @Param("userid") String userid);

    /**
    * 根据productid删除,该方法为虚拟删除
    * @param productid 关联产品ID
    */
    int virtualDeleteByProductid(@Param("record") Amountchangerecord record, @Param("productid") String productid);

    /** 
     *  <strong>根据条件删除,该方法要谨慎使用，如果example为空或其属性为空，会删除整表数据 </strong>
     * @param example 条件对象
     */
    
    int virtualDeleteByExample(@Param("example") Example example);

    /** 
     * 根据主键修改
     * @param record 修改字段对象(必须含ID）
     * @param id 主键ID
     */
    int update(@Param("record") Amountchangerecord record, @Param("id") Long id);

    /**
    * 根据transactionid修改
    * @param transactionid 交易流水
    **/
    int updateByTransactionid(@Param("record") Amountchangerecord record, @Param("transactionid") String transactionid);

    /**
    * 根据id修改
    * @param id 主键自增
    **/
    int updateById(@Param("record") Amountchangerecord record, @Param("id") Long id);

    /**
    * 根据type修改
    * @param type      0:线上充值 1:线上订购（冻结） 2:提现 3:本金返还 4:利息返还
                                     5:线下预订购(POS刷卡) 6:送现金 7:水位线超时退款 8:C端提现手续费
                                      9:扣除产品券价值 10:冻结金额返回余额 a:流标退款 b:线下充值
                                     c:线上补订 d:线下订购(一步到位) e:验券后收益调整 f:代付本金给开发商
                                      g:代付利息给开发商 h:代付券价值和券收益调整给开发商 i:线下退款 j:代扣费用 l 调账
    **/
    int updateByType(@Param("record") Amountchangerecord record, @Param("type") String type);

    /**
    * 根据status修改
    * @param status 状态(0成功 1失败,2 待审核,3 充值处理中)
    **/
    int updateByStatus(@Param("record") Amountchangerecord record, @Param("status") String status);

    /**
    * 根据userid修改
    * @param userid UserID
    **/
    int updateByUserid(@Param("record") Amountchangerecord record, @Param("userid") String userid);

    /**
    * 根据productid修改
    * @param productid 关联产品ID
    **/
    int updateByProductid(@Param("record") Amountchangerecord record, @Param("productid") String productid);

    /** 
     * 根据条件修改所有字段
     * @param record 修改字段对象 (JOPO)
     * @param example 条件对象
     */
    int updateByExample(@Param("record") Amountchangerecord record, @Param("example") Example example);

    /** 
     *
     * @param record 修改字段对象(必须含ID）
     */
    int updateBySelective(@Param("record") Amountchangerecord record);

    /** 
     * 根据列表里的字段批量修改
     * @param list
     */
    int updateBatchBySelective(List<Amountchangerecord> list);

    /** 
     * 根据主键查询
     * @param id 主键ID
     */
    Amountchangerecord select(Long id);

    /** 
     * 根据条件查询
     * @param example 条件对象
     */
    List<Amountchangerecord> selectByExample(@Param("example") Example example);

    /**
    * 根据transactionid查询，暂不支持分页查询
    * @param transactionid 交易流水
    **/
    List<Amountchangerecord> selectByTransactionid(String transactionid);

    /**
    * 根据id查询，暂不支持分页查询
    * @param id 主键自增
    **/
    Amountchangerecord selectById(Long id);

    /**
    * 根据type查询，暂不支持分页查询
    * @param type      0:线上充值 1:线上订购（冻结） 2:提现 3:本金返还 4:利息返还
                                     5:线下预订购(POS刷卡) 6:送现金 7:水位线超时退款 8:C端提现手续费
                                      9:扣除产品券价值 10:冻结金额返回余额 a:流标退款 b:线下充值
                                     c:线上补订 d:线下订购(一步到位) e:验券后收益调整 f:代付本金给开发商
                                      g:代付利息给开发商 h:代付券价值和券收益调整给开发商 i:线下退款 j:代扣费用 l 调账
    **/
    List<Amountchangerecord> selectByType(String type);

    /**
    * 根据status查询，暂不支持分页查询
    * @param status 状态(0成功 1失败,2 待审核,3 充值处理中)
    **/
    List<Amountchangerecord> selectByStatus(String status);

    /**
    * 根据userid查询，暂不支持分页查询
    * @param userid UserID
    **/
    List<Amountchangerecord> selectByUserid(String userid);

    /**
    * 根据productid查询，暂不支持分页查询
    * @param productid 关联产品ID
    **/
    List<Amountchangerecord> selectByProductid(String productid);

    /** 
     * 查询数量
     * @param example 条件对象
     */
    int countByExample(@Param("example") Example example);
}