 /** 本文件由 工具自动生成自动生成 https://github.com/real52010/mybatis-generator.git*/
package com.huilian.mapper;

import com.huilian.model.Userprofile;
import com.huilian.model.UserprofileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 用户帐号信息 数据状态 0：正常  1 删除 <br/>
 * @author real code generator
 * date:2017-12-13 22:27:19
 */
public interface UserprofileDAO {
    /** 
     * 添加对象所有字段
     * @param record 插入字段对象(必须含ID）
     */
    int insert(@Param("record") Userprofile record);

    /** 
     * 添加List集合对象所有字段
     * @param list
     */
    int insertBatch(List<Userprofile> list);

    /** 
     * 根据主键删除,该方法为物理删除
     * @param id 主键ID
     * @param userID 主键ID
     */
    int delete(@Param("id") Long id, @Param("userID") String userID);

    /**
    * 根据phoneNum删除
    * @param phoneNum 用户号码
    **/
    int deleteByPhoneNum(@Param("record") Userprofile record, @Param("phoneNum") String phoneNum);

    /**
    * 根据userID删除
    * @param userID 用户ID UUID
    **/
    int deleteByUserID(@Param("record") Userprofile record, @Param("userID") String userID);

    /** 
     *  <strong>根据条件删除,该方法为虚拟删除,该方法要谨慎使用，如果example为空或其属性为空，会删除整表数据 </strong>
     * @param example 条件对象
     */
    
    int deleteByExample(@Param("example") UserprofileExample example);

    /** 
     * 根据主键删除,该方法为物理删除
     * @param id 主键ID
     * @param userID 主键ID
     */
    int virtualDelete(@Param("id") Long id, @Param("userID") String userID);

    /**
    * 根据phoneNum删除,该方法为虚拟删除
    * @param phoneNum 用户号码
    */
    int virtualDeleteByPhoneNum(@Param("record") Userprofile record, @Param("phoneNum") String phoneNum);

    /**
    * 根据userID删除,该方法为虚拟删除
    * @param userID 用户ID UUID
    */
    int virtualDeleteByUserID(@Param("record") Userprofile record, @Param("userID") String userID);

    /** 
     *  <strong>根据条件删除,该方法要谨慎使用，如果example为空或其属性为空，会删除整表数据 </strong>
     * @param example 条件对象
     */
    
    int virtualDeleteByExample(@Param("example") UserprofileExample example);

    /** 
     * 根据主键修改
     * @param record 修改字段对象(必须含ID）
     * @param id 主键ID
     * @param userID 主键ID
     */
    int update(@Param("record") Userprofile record, @Param("id") Long id, @Param("userID") String userID);

    /**
    * 根据userID,phoneNum修改
    * @param userID 用户ID UUID
    * @param phoneNum 用户号码
    **/
    int updateByUserIDAndPhoneNum(@Param("record") Userprofile record, @Param("userID") String userID, @Param("phoneNum") String phoneNum);

    /**
    * 根据phoneNum修改
    * @param phoneNum 用户号码
    **/
    int updateByPhoneNum(@Param("record") Userprofile record, @Param("phoneNum") String phoneNum);

    /**
    * 根据id,userID修改
    * @param id id
    * @param userID 用户ID UUID
    **/
    int updateByIdAndUserID(@Param("record") Userprofile record, @Param("id") Long id, @Param("userID") String userID);

    /**
    * 根据userID修改
    * @param userID 用户ID UUID
    **/
    int updateByUserID(@Param("record") Userprofile record, @Param("userID") String userID);

    /** 
     * 根据条件修改所有字段
     * @param record 修改字段对象 (JOPO)
     * @param example 条件对象
     */
    int updateByExample(@Param("record") Userprofile record, @Param("example") UserprofileExample example);

    /** 
     *
     * @param record 修改字段对象(必须含ID）
     */
    int updateBySelective(@Param("record") Userprofile record);

    /** 
     * 根据列表里的字段批量修改
     * @param list
     */
    int updateBatchBySelective(List<Userprofile> list);

    /** 
     * 根据主键查询
     * @param id 主键ID
     * @param userID 主键ID
     */
    Userprofile select(@Param("id") Long id, @Param("userID") String userID);

    /** 
     * 根据条件查询
     * @param example 条件对象
     */
    List<Userprofile> selectByExample(@Param("example") UserprofileExample example);

    /**
    * 根据phoneNum查询，暂不支持分页查询
    * @param phoneNum 用户号码
    **/
    Userprofile selectByPhoneNum(@Param("phoneNum") String phoneNum);

    /**
    * 根据userID查询，暂不支持分页查询
    * @param userID 用户ID UUID
    **/
    List<Userprofile> selectByUserID(@Param("userID") String userID);

    /** 
     * 查询数量
     * @param example 条件对象
     */
    int countByExample(@Param("example") UserprofileExample example);
}