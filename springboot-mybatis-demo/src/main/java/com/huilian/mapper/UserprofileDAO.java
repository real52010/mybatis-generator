 /** 本文件由 工具自动生成自动生成 https://github.com/real52010/mybatis-generator.git*/
package com.huilian.mapper;

import com.huilian.model.Example;
import com.huilian.model.Userprofile;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 用户帐号信息 数据状态 0：正常  1 删除 <br/>
 * @author real code generator
 * date:2017-12-14 21:00:03
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
     * @param userid 主键ID
     */
    int delete(@Param("id") Long id, @Param("userid") String userid);

    /**
    * 根据phonenum删除
    * @param phonenum 用户号码
    **/
    int deleteByPhonenum(@Param("record") Userprofile record, @Param("phonenum") String phonenum);

    /**
    * 根据userid删除
    * @param userid 用户ID UUID
    **/
    int deleteByUserid(@Param("record") Userprofile record, @Param("userid") String userid);

    /** 
     *  <strong>根据条件删除,该方法为虚拟删除,该方法要谨慎使用，如果example为空或其属性为空，会删除整表数据 </strong>
     * @param example 条件对象
     */
    
    int deleteByExample(@Param("example") Example example);

    /** 
     * 根据主键修改
     * @param record 修改字段对象(必须含ID）
     * @param id 主键ID
     * @param userid 主键ID
     */
    int update(@Param("record") Userprofile record, @Param("id") Long id, @Param("userid") String userid);

    /**
    * 根据userid,phonenum修改
    * @param userid 用户ID UUID
    * @param phonenum 用户号码
    **/
    int updateByUseridAndPhonenum(@Param("record") Userprofile record, @Param("userid") String userid, @Param("phonenum") String phonenum);

    /**
    * 根据phonenum修改
    * @param phonenum 用户号码
    **/
    int updateByPhonenum(@Param("record") Userprofile record, @Param("phonenum") String phonenum);

    /**
    * 根据id,userid修改
    * @param id id
    * @param userid 用户ID UUID
    **/
    int updateByIdAndUserid(@Param("record") Userprofile record, @Param("id") Long id, @Param("userid") String userid);

    /**
    * 根据userid修改
    * @param userid 用户ID UUID
    **/
    int updateByUserid(@Param("record") Userprofile record, @Param("userid") String userid);

    /** 
     * 根据条件修改所有字段
     * @param record 修改字段对象 (JOPO)
     * @param example 条件对象
     */
    int updateByExample(@Param("record") Userprofile record, @Param("example") Example example);

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
     * @param userid 主键ID
     */
    Userprofile select(@Param("id") Long id, @Param("userid") String userid);

    /** 
     * 根据条件查询
     * @param example 条件对象
     */
    List<Userprofile> selectByExample(@Param("example") Example example);

    /**
    * 根据phonenum查询，暂不支持分页查询
    * @param phonenum 用户号码
    **/
    Userprofile selectByPhonenum(@Param("phonenum") String phonenum);

    /**
    * 根据userid查询，暂不支持分页查询
    * @param userid 用户ID UUID
    **/
    List<Userprofile> selectByUserid(@Param("userid") String userid);

    /** 
     * 查询数量
     * @param example 条件对象
     */
    int countByExample(@Param("example") Example example);
}