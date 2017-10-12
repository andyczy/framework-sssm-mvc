package cn.com.czy.mybatis.annotation.mapping;

import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;


/**
 * 总结：
 * 1、用注解方式
 * 2、了解getClassLoader、SqlSessionFactory的基本原理
 * 3、接口规范
 */
public class AnnotationTest {
	private SqlSessionFactory sessionFactory;

	@Before
	public void setUp() {
		// 1. 声明配置文件
		String resource = "config/SqlMapConfig.xml";
		// 2. 加载应用配置文件
		InputStream is = AnnotationTest.class.getClassLoader().getResourceAsStream(resource);
		// 3. 创建SqlSessonFactory
		sessionFactory = new SqlSessionFactoryBuilder().build(is);
	}

	@Test
	public void testAnnotation() throws Exception {

		// 4、获取注解配置
		Configuration conf = sessionFactory.getConfiguration();
		conf.addMapper(GetUserInfoAnnotation.class);
		// 5. 获取Session
		SqlSession session = sessionFactory.openSession();
		try {
			// 6. 获取操作类
			GetUserInfoAnnotation getUserInfo = session.getMapper(GetUserInfoAnnotation.class);

			// 7、查询用户
			User_one user_one = getUserInfo.getUser(1);
			System.out.println(
						" userId:" + user_one.getId() +
							", userName:" + user_one.getUsername()+
							", address:" + user_one.getAddress()+
							", sex:" + user_one.getSex()
			);

		} finally {
			// 7.关闭Session
			session.close();
		}
	}
}
