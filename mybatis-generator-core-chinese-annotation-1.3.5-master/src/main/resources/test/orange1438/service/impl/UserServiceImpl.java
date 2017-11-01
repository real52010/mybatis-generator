package orange1438.service.impl;

import java.util.List;
import orange1438.entity.Criteria;
import orange1438.entity.User;
import orange1438.mappers.UserDAO;
import orange1438.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    public int countByExample(Criteria example) {
        int count = this.userDAO.countByExample(example);
        logger.debug("count: {}", count);
        return count;
    }

    public User selectByPrimaryKey(Long id) {
        return this.userDAO.selectByPrimaryKey(id);
    }

    public List<User> selectByExample(Criteria example) {
        return this.userDAO.selectByExample(example);
    }

    public int deleteByPrimaryKey(Long id) {
        return this.userDAO.deleteByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(User record) {
        return this.userDAO.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(User record) {
        return this.userDAO.updateByPrimaryKey(record);
    }

    public int deleteByExample(Criteria example) {
        return this.userDAO.deleteByExample(example);
    }

    public int updateByExampleSelective(User record, Criteria example) {
        return this.userDAO.updateByExampleSelective(record, example);
    }

    public int updateByExample(User record, Criteria example) {
        return this.userDAO.updateByExample(record, example);
    }

    public int insert(User record) {
        return this.userDAO.insert(record);
    }

    public int insertSelective(User record) {
        return this.userDAO.insertSelective(record);
    }
}