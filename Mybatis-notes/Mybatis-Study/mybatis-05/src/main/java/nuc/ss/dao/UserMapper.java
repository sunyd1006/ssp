package nuc.ss.dao;

import nuc.ss.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    /**
     *  返回所有用户
     * @return
     */
    @Select("select * from user")
    List<User> getUsers();

    /**
     * 查询某个id用户
     * 方法存在多个参数，所有的参数面前必须加上@Param("id")
     * @param id
     * @return
     */
    @Select("select * from user where id = #{id}")
    User getUserById(@Param("id") int id);

    /**
     * 增加用户a
     * @param user
     * @return
     */
    @Insert("insert into user(id,name,pwd) values (#{id},#{name},#{password})")
    int addUser(User user);

    /**
     * 更改信息
     * @param user
     * @return
     */
    @Update("update user set name=#{name},pwd=#{password} where id=#{id}")
    int updateUser(User user);

    /**
     * 删除某个用户
     * @param id
     * @return
     */
    @Delete("delete from user where id = #{id}")
    int deleteUser(@Param("id") int id);
}
