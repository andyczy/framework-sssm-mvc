package spring.ioc.frist;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @auther 陈郑游
 * @create 2016-12-01-20:36
 * @功能描述 IOC入门测试
 * @公司地址
 */

public class UserTest {

	@Test
	public void userTest(){

		//1、加载配置文件
		ApplicationContext context = new
				ClassPathXmlApplicationContext("spring/spring-bean.xml");

		//2、得到实例
		User user =  (User)context.getBean("user");
		user.getAdd();

		//关闭资源
		((ConfigurableApplicationContext)context).close();
	}
}
