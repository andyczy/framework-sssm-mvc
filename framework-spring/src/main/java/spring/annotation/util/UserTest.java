package spring.annotation.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;


/**
 * @auther 陈郑游
 * @create 2016-12-02-23:05
 * @功能描述 注解开发
 */

@RunWith(SpringJUnit4ClassRunner.class)
//有ContextConfiguration就不能加载properties配置文件
@ContextConfiguration(locations={"classpath:spring/spring-annotation.xml"})
public class UserTest {

	@Resource()
	private UserService service;
	
	
	@Test
	public void getTest() throws Exception{
		service.getPritn();
	}
	
}
