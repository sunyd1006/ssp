package nuc.ss.dao;

import nuc.ss.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    // 根据id查询用户
    User queryUserById(@Param("id") int id);

    int updateUser(User user);
}
