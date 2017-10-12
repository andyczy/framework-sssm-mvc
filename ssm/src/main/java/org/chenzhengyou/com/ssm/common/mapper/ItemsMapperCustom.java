package org.chenzhengyou.com.ssm.common.mapper;


import org.chenzhengyou.com.ssm.common.pojo.ItemsCustom;
import org.chenzhengyou.com.ssm.common.pojo.ItemsQueryVo;

import java.util.List;

public interface ItemsMapperCustom {
    //商品查询列表
	List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo)throws Exception;

    void deleteItems(Integer[] items_id) throws Exception;
}