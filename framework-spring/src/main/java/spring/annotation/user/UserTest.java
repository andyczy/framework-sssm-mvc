package spring.annotation.user;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @auther 陈郑游
 * @create 2016-12-02-23:05
 * @功能描述 注解开发
 * @公司地址 @Component(value = "user")
 *
 */

public class UserTest {

	@Test
	public void userTest(){

		//1、加载配置文件
		ApplicationContext context = new
				ClassPathXmlApplicationContext("spring/spring-annotation.xml");
		//2、得到实例
		User user =  (User)context.getBean("user");
		user.add();

		//关闭资源
		((ConfigurableApplicationContext)context).close();
	}

}
