package spring.messageSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

/**
 * @auther 陈郑游
 * @create 2016-12-02-23:05
 * @功能描述 messageSource
 */

public class MessTest {


	@Test
	public void Test() throws IOException {

		@SuppressWarnings("resource")
		ApplicationContext act = new ClassPathXmlApplicationContext("spring/spring-bean.xml");

		/**
		 * Internationalization using MessageSource
		 * 国际化
		 */
		String[] a = {"孙悟空","这是一个应用"};
		String hello = act.getMessage("hello", new String[]{"陈郑游"},Locale.CANADA);
		String hello2 = act.getMessage("hello", a ,Locale.US);
		System.out.println(hello);
		System.out.println(hello2);

		//多个占位符、取第一个
		String title = act.getMessage("title", a ,Locale.CANADA);
		String title2 = act.getMessage("title", a ,Locale.US);
		System.out.println(title);
		System.out.println(title2);
		System.out.println("  ");


		/**
		 * 加载资源文件
		 * classpath:classpath.txt
		 */
		Resource res = act.getResource("classpath:config/classpath.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(res.getInputStream()));
		String line ="";
		while((line = br.readLine()) != null ){
			System.out.println(line);
		}





	}
}
