package orange1438.service;

import java.util.List;
import orange1438.entity.Criteria;
import orange1438.entity.User;

public interface UserService {
    int countByExample(Criteria example);

    User selectByPrimaryKey(Long id);

    List<User> selectByExample(Criteria example);

    int deleteByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int deleteByExample(Criteria example);

    int updateByExampleSelective(User record, Criteria example);

    int updateByExample(User record, Criteria example);

    int insert(User record);

    int insertSelective(User record);
}