 /** 本文件由 工具自动生成自动生成 https://github.com/real52010/mybatis-generator.git*/
package com.real.demo.biz.mapper;

import com.real.demo.common.base.mybatis.Example;
import com.real.demo.biz.domain.Order;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 订单表 null<br/>
 * @author real code generator
 * date:2018-11-27 18:03:07
 */
public interface OrderMapper {
    /** 
     * 添加对象所有字段
     * @param record 插入字段对象(必须含ID）
     */
    int insert(@Param("record") Order record);

    /** 
     * 添加List集合对象所有字段
     * @param list
     */
    int insertBatch(List<Order> list);

    /** 
     *
     * @param id 主键ID
     */
    int deleteById(Integer id);

    /** 
     *  <strong>根据条件删除,该方法要谨慎使用，如果example为空或其属性为空，会删除整表数据 </strong>
     * @param example 条件对象
     */
    
    int deleteByExample(@Param("example") Example example);

    /** 
     *
     * @param id 主键ID
     */
    int vDeleteById(Integer id);

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
    int updateById(@Param("record") Order record, @Param("id") Integer id);

    /** 
     * 根据条件修改所有字段
     * @param record 修改字段对象 (JOPO)
     * @param example 条件对象
     */
    int updateByExample(@Param("record") Order record, @Param("example") Example example);

    /** 
     *
     * @param record 修改字段对象(必须含ID）
     */
    int updateBySelective(@Param("record") Order record);

    /** 
     * 根据列表里的字段批量修改
     * @param list
     */
    int updateBatchBySelective(List<Order> list);

    /** 
     *
     * @param id 主键ID
     */
    Order getById(Integer id);

    /** 
     * 根据条件查询
     * @param example 条件对象
     */
    List<Order> selectByExample(@Param("example") Example example);

    /** 
     * 查询数量
     * @param example 条件对象
     */
    int countByExample(@Param("example") Example example);
}