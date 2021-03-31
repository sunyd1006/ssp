package nuc.ss.dao;

import nuc.ss.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    /**
     * 模糊查询
     * @return
     */
    List<User> getUserLike(String value);
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
     * 万能的map
     * @param map
     * @return
     */
    int addUser2(Map<String, Object> map);


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
