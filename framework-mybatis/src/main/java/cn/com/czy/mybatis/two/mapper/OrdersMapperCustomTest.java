package cn.com.czy.mybatis.two.mapper;

import cn.com.czy.mybatis.pojo.Orders;
import cn.com.czy.mybatis.pojo.OrdersCustom;
import cn.com.czy.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * 总结：
 * 1、mapper文件：OrdersMapperCustom.xml
 * 2、了解一对一、一对多、多对多、的映射
 * 3、缓存、延迟（了解）
 * 有问题
 */
public class OrdersMapperCustomTest {

	private SqlSessionFactory sqlSessionFactory;

    /**此方法是在执行testFindUserById之前执行*/
	 @Before
	 public void setUp() throws Exception {
	 // 创建sqlSessionFactory

	 // mybatis配置文件
	 String resource = "config/SqlMapConfig.xml";
	 // 得到配置文件流
	 InputStream inputStream = Resources.getResourceAsStream(resource);

	 // 创建会话工厂，传入mybatis的配置文件信息
	 sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	 }

	 /**一对一的查询 使用resultType  = OrdersCustom（里面的属性包含查询出来的字段属性）*/
	@Test
	public void testFindOrdersUser() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 创建代理对象
		OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);

		// 调用maper的方法
		List<OrdersCustom> list = ordersMapperCustom.findOrdersUser();

		for (OrdersCustom ordersCustom :list){
			System.out.println("输出："+ordersCustom.getUsername());
            System.out.println("输出："+ordersCustom.getCreatetime());
		}
		sqlSession.close();
	}


	/**一对一的查询(使用resultmap):查询订单关联查询用户信息*/
	@Test
    public void testFindOrdersUserResultMap() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 创建代理对象
        OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);

        // 调用maper的方法
        List<Orders> list = ordersMapperCustom.findOrdersUserResultMap();

		for (Orders orders :list){
			System.out.println("输出："+orders.getUser().getUsername());
            System.out.println("输出："+orders.getUser().getUsername());
		}
        sqlSession.close();
    }

    /**一对一的查询(使用resultmap):查询订单关联查询用户信息*/
    @Test
    public void testFindOrdersAndOrderDetailResultMap() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 创建代理对象
        OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);

        // 调用maper的方法
        List<Orders> list = ordersMapperCustom.findOrdersAndOrderDetailResultMap();


	    for (Orders orders :list){
		    System.out.println("输出："+orders.getUser().getUsername());
	    }
        sqlSession.close();
    }

    /*查询用户购买的信息*/
    @Test
    public void testFindUserAndItemsResultMap() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 创建代理对象
        OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);

        // 调用maper的方法
        List<User> list = ordersMapperCustom.findUserAndItemsResultMap();

	    for (User user :list){
		    System.out.println("输出："+user.getUsername());
	    }
        sqlSession.close();
    }


    /**延迟加载:查询订单并且关联查询用户信息*/
    @Test
    public void testFindOrdersUserLazyLoading() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 创建代理对象
        OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);

        // 调用maper的方法
        List<Orders> list = ordersMapperCustom.findOrdersUserLazyLoading();

        for (Orders orders :list){
            User user = orders.getUser();
            System.out.println("输出："+user.getUsername());
        }
        sqlSession.close();
    }

}
