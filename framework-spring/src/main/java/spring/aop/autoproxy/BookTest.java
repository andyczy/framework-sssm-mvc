package spring.aop.autoproxy;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @auther 陈郑游
 * @create 2016-12-02-23:05
 * @功能描述 注解开发
 * @公司地址
 *
 */


public class BookTest {

	@Test
	public void userTest(){
		//1、加载配置文件
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-aop-autopsy.xml");
		//2、得到实例
		Book book =  (Book)context.getBean("book");
		book.add();

		//关闭资源
		((ConfigurableApplicationContext)context).close();
	}



}
