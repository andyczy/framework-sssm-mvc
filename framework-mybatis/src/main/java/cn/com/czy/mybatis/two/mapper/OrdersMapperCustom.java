package cn.com.czy.mybatis.two.mapper;

import cn.com.czy.mybatis.pojo.Orders;
import cn.com.czy.mybatis.pojo.OrdersCustom;
import cn.com.czy.mybatis.pojo.User;

import java.util.List;


/**
 * 多对多映射总结：
 * 1、mapper文件：OrdersMapperCustom.xml
 * 2、了解一对一、一对多、多对多、的映射
 * 3、缓存、延迟（了解）
 * 
 * <p>Title: OrdersMapperCustom</p>
 * <p>Description: 订单mapper 接口</p>
 */
public interface OrdersMapperCustom {
	
	//查询订单关联查询用户信息
	public List<OrdersCustom> findOrdersUser()throws Exception;
	
	//查询订单关联查询用户使用resultMap
	public List<Orders> findOrdersUserResultMap()throws Exception;

    //查询订单关联查询用户信息，
    public List<Orders> findOrdersAndOrderDetailResultMap()throws Exception;

    //查询用户购买的信息
    public List<User> findUserAndItemsResultMap()throws Exception;

    //查询订单关联查询用户，用户信息是延迟加载
    public List<Orders> findOrdersUserLazyLoading()throws Exception;
}
