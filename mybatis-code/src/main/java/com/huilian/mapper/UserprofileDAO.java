package com.huilian.mapper;

import com.huilian.dao.Userprofile;
import com.huilian.dao.UserprofileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserprofileDAO {
    long countByExample(UserprofileExample example);

    int deleteByExample(UserprofileExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Userprofile record);

    int insertSelective(Userprofile record);

    List<Userprofile> selectByExample(UserprofileExample example);

    Userprofile selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Userprofile record, @Param("example") UserprofileExample example);

    int updateByExample(@Param("record") Userprofile record, @Param("example") UserprofileExample example);

    int updateByPrimaryKeySelective(Userprofile record);

    int updateByPrimaryKey(Userprofile record);
}