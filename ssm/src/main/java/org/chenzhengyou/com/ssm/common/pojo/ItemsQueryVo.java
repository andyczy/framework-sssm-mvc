package org.chenzhengyou.com.ssm.common.pojo;

import java.util.List;

/**
 * <p>Title: ItemsQueryVo</p>
 * <p>Description:商品包装对象 </p>
 */
public class ItemsQueryVo {

    //商品信息
    private Items items;

    //为了系统 可扩展性，对原始生成的po进行扩展
    private ItemsCustom itemsCustom;
    private List<ItemsCustom> itemsCustomList;

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }

    public ItemsCustom getItemsCustom() {
        return itemsCustom;
    }

    public void setItemsCustom(ItemsCustom itemsCustom) {
        this.itemsCustom = itemsCustom;
    }

    public List<ItemsCustom> getItemsCustomList() {
        return itemsCustomList;
    }

    public void setItemsCustomList(List<ItemsCustom> itemsCustomList) {
        this.itemsCustomList = itemsCustomList;
    }
}
