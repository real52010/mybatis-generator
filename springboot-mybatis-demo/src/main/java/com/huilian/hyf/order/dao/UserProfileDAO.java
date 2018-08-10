 /** 本文件由 工具自动生成自动生成 https://github.com/real52010/mybatis-generator.git*/
package com.huilian.hyf.order.dao;

import com.huilian.hyf.order.model.Example;
import com.huilian.hyf.order.model.UserProfilePOJO;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 用户帐号信息 三要素校验手机号<br/>
 * @author real code generator
 * date:2018-07-23 17:35:54
 */
public interface UserProfileDAO {
    /** 
     * 添加对象所有字段
     * @param record 插入字段对象(必须含ID）
     */
    int insert(@Param("record") UserProfilePOJO record);

    /** 
     * 添加List集合对象所有字段
     * @param list
     */
    int insertBatch(List<UserProfilePOJO> list);

    /** 
     *
     * @param userID 主键ID
     */
    int deleteByUserID(String userID);

    /**
    * 根据phoneNum删除
    * @param phoneNum 
    **/
    int deleteByPhoneNum(@Param("phoneNum") String phoneNum);

    /**
    * 根据updateTime删除
    * @param updateTime 更新时间
    **/
    int deleteByUpdateTime(@Param("updateTime") Date updateTime);

    /** 
     *  <strong>根据条件删除,该方法为虚拟删除,该方法要谨慎使用，如果example为空或其属性为空，会删除整表数据 </strong>
     * @param example 条件对象
     */
    
    int deleteByExample(@Param("example") Example example);

    /** 
     *
     * @param userID 主键ID
     */
    int vDeleteByUserID(String userID);

    /**
    * 根据phoneNum删除,该方法为虚拟删除
    * @param phoneNum 
    */
    int vDeleteByPhoneNum(@Param("phoneNum") String phoneNum);

    /**
    * 根据updateTime删除,该方法为虚拟删除
    * @param updateTime 更新时间
    */
    int vDeleteByUpdateTime(@Param("updateTime") Date updateTime);

    /** 
     *
     * @param example 条件对象
     */
    
    int vDeleteByExample(@Param("example") Example example);

    /** 
     *
     * @param record 修改字段对象(必须含ID）
     * @param userID 主键ID
     */
    int updateByUserID(@Param("record") UserProfilePOJO record, @Param("userID") String userID);

    /**
    * 根据phoneNum修改
    * @param phoneNum 
    **/
    int updateByPhoneNum(@Param("record") UserProfilePOJO record, @Param("phoneNum") String phoneNum);

    /**
    * 根据updateTime修改
    * @param updateTime 更新时间
    **/
    int updateByUpdateTime(@Param("record") UserProfilePOJO record, @Param("updateTime") Date updateTime);

    /** 
     * 根据条件修改所有字段
     * @param record 修改字段对象 (JOPO)
     * @param example 条件对象
     */
    int updateByExample(@Param("record") UserProfilePOJO record, @Param("example") Example example);

    /** 
     *
     * @param record 修改字段对象(必须含ID）
     */
    int updateBySelective(@Param("record") UserProfilePOJO record);

    /** 
     * 根据列表里的字段批量修改
     * @param list
     */
    int updateBatchBySelective(List<UserProfilePOJO> list);

    /** 
     *
     * @param userID 主键ID
     */
    UserProfilePOJO selectByUserID(String userID);

    /** 
     * 根据条件查询
     * @param example 条件对象
     */
    List<UserProfilePOJO> selectByExample(@Param("example") Example example);

    /**
    * 根据phoneNum查询，暂不支持分页查询
    * @param phoneNum 
    **/
    UserProfilePOJO selectByPhoneNum(String phoneNum);

    /**
    * 根据updateTime查询，暂不支持分页查询
    * @param updateTime 更新时间
    **/
    List<UserProfilePOJO> selectByUpdateTime(Date updateTime);

    /** 
     * 查询数量
     * @param example 条件对象
     */
    int countByExample(@Param("example") Example example);
}