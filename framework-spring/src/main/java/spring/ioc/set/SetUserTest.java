package spring.ioc.set;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @auther 陈郑游
 * @create 2016-12-01-22:01
 * @功能描述 set注入
 * @公司地址
 */

public class SetUserTest {

	@Test
	public void userTest(){

		//1、加载配置文件
		ApplicationContext context = new
				ClassPathXmlApplicationContext("spring/spring-bean.xml");
		//2、得到实例
		SetUser user =  (SetUser)context.getBean("userSet");
		user.userSetTest();

		//关闭资源
		((ConfigurableApplicationContext)context).close();
	}
}
