package nuc.ss.dao;

import nuc.ss.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    /**
     * 获取全部查询用户
     * @return 查询所有用户
     */
    List<User> getUserList();

    /**
     * 获取ID查询用户
     * @param id
     * @return 查询id用户
     */
    User getUserById(int id);

    /**
     * insert 一个用户
     * @param user
     * @return 插入是否成功
     */
    int addUser(User user);


    /**
     * 修改用户
     * @param user
     * @return 修改是否成功
     */
    int updateUser(User user);

    /**
     * 删除一个用户
     * @param id
     * @return
     */
    int deleteUser(int id);
}
