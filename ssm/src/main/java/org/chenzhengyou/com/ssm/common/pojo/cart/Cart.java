package org.chenzhengyou.com.ssm.common.pojo.cart;


import java.math.BigDecimal;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 购物车逻辑层
 *
 */
public class Cart {
	private Map<String,CartItem> map = new LinkedHashMap<String,CartItem>();
	
	/**
	 * 计算合计
	 * @return
	 */
	public double getTotal() {
		// 合计=所有条目的小计之和
		BigDecimal total = new BigDecimal("0");
		for(CartItem cartItem : map.values()) {
			BigDecimal subtotal = new BigDecimal("" + cartItem.getSubtotal());
			total = total.add(subtotal);
		}
		return total.doubleValue();
	}
	
	/**
	 * 添加条目到车中
	 * @param cartItem
	 */
    public void add(CartItem cartItem) {
        if(map.containsKey( cartItem.getItemsCustom().getId() )) {//判断原来车中是否存在该条目
            CartItem _cartItem = map.get( cartItem.getItemsCustom().getId()  );//返回原条目
//            _cartItem.setCount(_cartItem.getCount() + cartItem.getCount());//设置老条目的数量为，其自己数量+新条目的数量
            map.put(String.valueOf(cartItem.getItemsCustom().getId()) , _cartItem);
        } else {
            map.put( String.valueOf(cartItem.getItemsCustom().getId()) , cartItem);
        }
    }
	
	/**
	 * 清空所有条目
	 */
	public void clear() {
		map.clear();
	}
	
	/**
	 * 删除指定条目
	 * @param id
	 */
	public void delete(String id) {
		map.remove(id);
	}
	
	/**
	 * 获取所有条目
	 * @return
	 */
	public Collection<CartItem> getCartItems() {
		return map.values();
	}
}
