package spring.ioc.constructor;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @auther 陈郑游
 * @create 2016-12-01-21:58
 * @功能描述 有参构造注入
 * @公司地址
 */

public class ConstructionUserBeanTest {


	@Test
	public void userTest(){

		//1、加载配置文件
		ApplicationContext context = new
				ClassPathXmlApplicationContext("spring/spring-bean.xml");
		//2、得到实例
		ConstructionUserBean user =  (ConstructionUserBean)context.getBean("userBean");
		user.beanTest();

		//关闭资源
		((ConfigurableApplicationContext)context).close();
	}
}
