package org.chenzhengyou.com.ssm.common.service;


import org.chenzhengyou.com.ssm.common.pojo.ItemsCustom;
import org.chenzhengyou.com.ssm.common.pojo.ItemsQueryVo;

import java.util.List;

/**
 * <p>Title: ItemsService</p>
 * <p>Description:商品管理service </p>
 */
public interface ItemsService {
	
	//商品查询列表
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
	
	//根据id查询商品信息
	/**
	 * 
	 * <p>Title: findItemsById</p>
	 * <p>Description: </p>
	 * @param id 查询商品的id
	 * @return
	 * @throws Exception
	 */
	public ItemsCustom findItemsById(Integer id) throws Exception;
	
	//修改商品信息
	/**
	 * 
	 * <p>Title: updateItems</p>
	 * <p>Description: </p>
	 * @param id 修改商品的id
	 * @param itemsCustom 修改的商品信息
	 * @throws Exception
	 */
	public void updateItems(Integer id, ItemsCustom itemsCustom) throws Exception;



    public void deleteItems(Integer[] id) throws Exception ;


}
