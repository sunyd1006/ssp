package nuc.ss.dao.bill;

import nuc.ss.pojo.Bill;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface BillMapper {


	/**
	 * 根据供应商ID查询订单数量
	 * @param providerId
	 * @return
	 * @throws Exception
	 */
	public int getBillCountByProviderId(@Param("providerId") Integer providerId)throws Exception;


	/**
	 * 增加订单
	 * @param bill
	 * @return
	 * @throws Exception
	 */
	public int add(Bill bill)throws Exception;

	/**
	 *
	 * 通过查询条件获取供应商列表-模糊查询-getBillList
	 * @param productName
	 * @param providerId
	 * @param isPayment
	 * @param currentPageNo
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public List<Bill> getBillList(@Param("productName") String productName, @Param("providerId") Integer providerId, @Param("isPayment") Integer isPayment,
								  @Param("from") Integer currentPageNo,@Param("pageSize") Integer pageSize)throws Exception;

	/**
	 * 通过条件查询--订单表的记录数
	 * @param productName
	 * @param providerId
	 * @param isPayment
	 * @return
	 */
	public int getBillCount(@Param("productName") String productName, @Param("providerId") Integer providerId,@Param("isPayment") Integer isPayment);
	/**
	 * 通过delId删除Bill
	 * @param delId
	 * @return
	 * @throws Exception
	 */
	public int deleteBillById(@Param("id") String delId)throws Exception;
	
	
	/**
	 * 通过billId获取Bill
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Bill getBillById(@Param("id") Integer id)throws Exception;
	
	/**
	 * 修改订单信息
	 * @param bill
	 * @return
	 * @throws Exception
	 */
	public int modify(Bill bill)throws Exception;

	/**
	 * 根据供应商ID删除订单信息
	 * @param providerId
	 * @return
	 * @throws Exception
	 */
	public int deleteBillByProviderId(@Param("providerId") Integer providerId) throws Exception;

}
