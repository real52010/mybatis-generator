/* https://github.com/real52010/mybatis-generator.git */
package com.huilian.dao;

import com.huilian.model.UserProfile;
import com.huilian.model.UserProfileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 本文件由 工具自动生成自动生成 https://github.com/real52010/mybatis-generator.git
 * @author real code generator
 * date:2017-11-02 19:15:10
 */
public interface UserProfileDAO {
    /** 
     * 添加对象所有字段
     * @param record 插入字段对象(必须含ID）
     */
    int insert(@Param("record") UserProfile record);

    /** 
     * 添加List集合对象所有字段
     * @param list
     */
    int insertBatch(List<UserProfile> list);

    /** 
     * 根据主键删除
     * @param id 主键ID
     */
    int delete(Long id);

    /** 
     *  <strong>根据条件删除,该方法要谨慎使用，如果example为空或其属性为空，会删除整表数据 </strong>
     * @param example 条件对象
     */
    @Deprecated
    int deleteByExample(@Param("example") UserProfileExample example);

    /** 
     * 根据主键修改
     * @param record 修改字段对象(必须含ID）
     * @param id 主键ID
     */
    int update(@Param("record") UserProfile record, @Param("id") Long id);

    /** 
     * 根据条件修改所有字段
     * @param record 修改字段对象 (JOPO)
     * @param example 条件对象
     */
    int updateByExample(@Param("record") UserProfile record, @Param("example") UserProfileExample example);

    /** 
     *
     * @param record 修改字段对象(必须含ID）
     */
    int updateBySelective(@Param("record") UserProfile record);

    /** 
     * 根据列表里的字段批量修改
     * @param list
     */
    int updateBatchBySelective(List<UserProfile> list);

    /** 
     * 根据主键查询
     * @param id 主键ID
     */
    UserProfile select(Long id);

    /** 
     * 根据条件查询
     * @param example 条件对象
     */
    List<UserProfile> selectByExample(@Param("example") UserProfileExample example);

    /** 
     * 查询数量
     * @param example 条件对象
     */
    int countByExample(@Param("example") UserProfileExample example);
}