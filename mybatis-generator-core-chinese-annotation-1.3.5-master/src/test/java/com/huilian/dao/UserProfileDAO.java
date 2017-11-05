/* https://github.com/real52010/mybatis-generator.git */
package com.huilian.dao;

import com.huilian.model.UserProfile;
import com.huilian.model.UserProfileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 本文件由 工具自动生成自动生成 https://github.com/real52010/mybatis-generator.git
 * @author real code generator
 * date:2017-11-06 00:24:34
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
     * 根据主键删除,该方法为物理删除
     * @param id 主键ID
     */
    int delete(Long id);

    /**
    * 根据phonenum删除
    * @param phonenum 
    **/
    int deleteByPhonenum(@Param("record") UserProfile record, @Param("phonenum") String phonenum);

    /**
    * 根据usrchannel删除
    * @param usrchannel 
    **/
    int deleteByUsrchannel(@Param("record") UserProfile record, @Param("usrchannel") String usrchannel);

    /**
    * 根据id删除
    * @param id id
    **/
    int deleteById(@Param("record") UserProfile record, @Param("id") Long id);

    /**
    * 根据sfopenid删除
    * @param sfopenid 顺风openid
    **/
    int deleteBySfopenid(@Param("record") UserProfile record, @Param("sfopenid") String sfopenid);

    /** 
     *  <strong>根据条件删除,该方法为虚拟删除,该方法要谨慎使用，如果example为空或其属性为空，会删除整表数据 </strong>
     * @param example 条件对象
     */
    
    int deleteByExample(@Param("example") UserProfileExample example);

    /** 
     * 根据主键删除,该方法为物理删除
     * @param id 主键ID
     */
    int virtualDelete(Long id);

    /**
    * 根据phonenum删除,该方法为虚拟删除
    * @param phonenum 
    */
    int virtualDeleteByPhonenum(@Param("record") UserProfile record, @Param("phonenum") String phonenum);

    /**
    * 根据usrchannel删除,该方法为虚拟删除
    * @param usrchannel 
    */
    int virtualDeleteByUsrchannel(@Param("record") UserProfile record, @Param("usrchannel") String usrchannel);

    /**
    * 根据id删除,该方法为虚拟删除
    * @param id id
    */
    int virtualDeleteById(@Param("record") UserProfile record, @Param("id") Long id);

    /**
    * 根据sfopenid删除,该方法为虚拟删除
    * @param sfopenid 顺风openid
    */
    int virtualDeleteBySfopenid(@Param("record") UserProfile record, @Param("sfopenid") String sfopenid);

    /** 
     *  <strong>根据条件删除,该方法要谨慎使用，如果example为空或其属性为空，会删除整表数据 </strong>
     * @param example 条件对象
     */
    
    int virtualDeleteByExample(@Param("example") UserProfileExample example);

    /** 
     * 根据主键修改
     * @param record 修改字段对象(必须含ID）
     * @param id 主键ID
     */
    int update(@Param("record") UserProfile record, @Param("id") Long id);

    /**
    * 根据userid,phonenum修改
    * @param userid 用户ID UUID
    * @param phonenum 
    **/
    int updateByUseridAndPhonenum(@Param("record") UserProfile record, @Param("userid") String userid, @Param("phonenum") String phonenum);

    /**
    * 根据phonenum修改
    * @param phonenum 
    **/
    int updateByPhonenum(@Param("record") UserProfile record, @Param("phonenum") String phonenum);

    /**
    * 根据usrchannel修改
    * @param usrchannel 
    **/
    int updateByUsrchannel(@Param("record") UserProfile record, @Param("usrchannel") String usrchannel);

    /**
    * 根据id修改
    * @param id id
    **/
    int updateById(@Param("record") UserProfile record, @Param("id") Long id);

    /**
    * 根据sfopenid修改
    * @param sfopenid 顺风openid
    **/
    int updateBySfopenid(@Param("record") UserProfile record, @Param("sfopenid") String sfopenid);

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
    * 根据phonenum查询，暂不支持分页查询
    * @param phonenum 
    **/
    UserProfile selectByPhonenum(String phonenum);

    /**
    * 根据usrchannel查询，暂不支持分页查询
    * @param usrchannel 
    **/
    List<UserProfile> selectByUsrchannel(String usrchannel);

    /**
    * 根据id查询，暂不支持分页查询
    * @param id id
    **/
    UserProfile selectById(Long id);

    /**
    * 根据sfopenid查询，暂不支持分页查询
    * @param sfopenid 顺风openid
    **/
    UserProfile selectBySfopenid(String sfopenid);

    /** 
     * 查询数量
     * @param example 条件对象
     */
    int countByExample(@Param("example") UserProfileExample example);
}