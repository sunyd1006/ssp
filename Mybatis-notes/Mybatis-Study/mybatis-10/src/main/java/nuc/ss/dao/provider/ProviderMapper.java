package nuc.ss.dao.provider;

import nuc.ss.pojo.Provider;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProviderMapper {
	
	/**
	 * 增加供应商
	 * @param provider
	 * @return
	 * @throws Exception
	 */
	public int add(Provider provider)throws Exception;

	/**
	 * 通过供应商名称、编码获取供应商列表-模糊查询-providerList
	 * @param proName
	 * @param proCode
	 * @param currentPageNo
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public List<Provider> getProviderList(@Param("proName") String proName, @Param("proCode") String proCode,
										  @Param("from") Integer currentPageNo, @Param("pageSize") Integer pageSize)throws Exception;

	/**
	 * 获取供应商列表
	 * @return
	 * @throws Exception
	 */
	public List<Provider> getProList() throws Exception;

	/**
	 * 通过条件查询-供应商表记录数
	 * @param proName
	 * @param proCode
	 * @return
	 * @throws Exception
	 */
	public int getProviderCount(@Param("proName") String proName, @Param("proCode") String proCode) throws Exception;
	/**
	 * 通过proId删除Provider
	 * @param delId
	 * @return
	 * @throws Exception
	 */
	public int deleteProviderById(@Param("id") Integer delId)throws Exception;
	
	
	/**
	 * 通过proId获取Provider
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Provider getProviderById(@Param("id") Integer id)throws Exception;
	
	/**
	 * 修改用户信息
	 * @return
	 * @throws Exception
	 */
	public int modify(Provider provider)throws Exception;
	
	
}
