package nuc.ss.dao;

import nuc.ss.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    /**
     * 获取ID查询用户
     * @param id
     * @return 查询id用户
     */
    User getUserById(int id);

    /**
     * 分页
     * @param map
     * @return
     */
    List<User> getUserByLimit(Map<String, Integer> map);

    List<User> getUserByRowBounds();
}
