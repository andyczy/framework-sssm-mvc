package org.chenzhengyou.com.ssm.common.pojo.cart;


import org.chenzhengyou.com.ssm.common.pojo.ItemsCustom;

import java.math.BigDecimal;

/**
 * 购物车条目类
 * 
 */
public class CartItem {
	
	private ItemsCustom itemsCustom;// 商品
	private Integer count;// 数量
	
	/**
	 * 小计方法
	 * @return
	 * 处理了二进制运算误差问题
	 */
	public double getSubtotal() {
		//小计方法，但它没有对应的成员！
		BigDecimal d1 = new BigDecimal(itemsCustom.getPrice() + "");
		BigDecimal d2 = new BigDecimal(count + "");
		return d1.multiply(d2).doubleValue();
	}

	public ItemsCustom getItemsCustom() {
		return itemsCustom;
	}

	public void setItemsCustom(ItemsCustom itemsCustom) {
		this.itemsCustom = itemsCustom;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
