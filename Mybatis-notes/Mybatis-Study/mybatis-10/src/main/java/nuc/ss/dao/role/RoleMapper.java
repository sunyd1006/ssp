package nuc.ss.dao.role;

import nuc.ss.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
	/**
	 * 获取角色列表
	 * @return
	 * @throws Exception
	 */
	public List<Role> getRoleList()throws Exception;

	/**
	 * 增加角色信息
	 * @param role
	 * @return
	 * @throws Exception
	 */
	public int add(Role role) throws Exception;


	/**
	 * 通过ID删除role
	 * @param delId
	 * @return
	 * @throws Exception
	 */
	public int deleteRoleBuId(@Param("id") Integer delId) throws Exception;

	/**
	 * 修改角色信息
	 * @param role
	 * @return
	 * @throws Exception
	 */
	public int modify(Role role) throws Exception;

	/**
	 * 通过id获取role
	 * @param delId
	 * @return
	 * @throws Exception
	 */
	public Role getRoleById(@Param("id") Integer delId) throws Exception;

	/**
	 * 根据roleCode，进行角色的唯一性验证
	 * @param roleCode
	 * @return
	 * @throws Exception
	 */
	public int roleCodeIsExist(@Param("roleCOde") String roleCode) throws Exception;
}
