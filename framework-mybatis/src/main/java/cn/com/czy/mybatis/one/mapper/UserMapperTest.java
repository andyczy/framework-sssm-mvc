package cn.com.czy.mybatis.one.mapper;

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
 * 
 * 总结：
 * 1、mapper代理方式、理解mapper开发规范 
 * 2、mapper文件是userMapper.xml
 * 3、了解动态sql、别名、sql代码片、
 * 4、了解  resultMap
 * 有问题
 *
 */
public class UserMapperTest {

	private SqlSessionFactory sqlSessionFactory;

	// 此方法是在执行testFindUserById之前执行
	@Before
	public void setUp() throws Exception {
		// mybatis配置文件
		String resource = "config/SqlMapConfig.xml";
		// 得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// 创建会话工厂，传入mybatis的配置文件信息
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	/*用户信息的综合查询*/
	@Test
	public void testFindUserList() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//创建UserMapper对象，mybatis自动生成mapper代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		//创建包装对象，设置查询条件
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustom userCustom = new UserCustom();
		userCustom.setSex("1");
		userCustom.setUsername("王五");
		userQueryVo.setUserCustom(userCustom);
		
		//调用userMapper的方法
		List<UserCustom> list = userMapper.findUserList(userQueryVo);
		System.out.println("输出："+list);
	}
	
	
	/*包装对象，设置查询条件*/
	@Test
	public void testFindUserCount() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//创建UserMapper对象，mybatis自动生成mapper代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		//创建包装对象，设置查询条件
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustom userCustom = new UserCustom();
		userCustom.setSex("1");
		userCustom.setUsername("郑游");
		userQueryVo.setUserCustom(userCustom);
		//调用userMapper的方法
		int count = userMapper.findUserCount(userQueryVo);
		System.out.println("输出："+count);
	}
	
	

	/*根据id查找信息*/
	@Test
	public void testFindUserById() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//创建UserMapper对象，mybatis自动生成mapper代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		//调用userMapper的方法
		User user = userMapper.findUserById(1);
		System.out.println("输出："+user);

	}
	

	/*模糊查询*/
	@Test
	public void testFindUserByName() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//创建UserMapper对象，mybatis自动生成mapper代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		//调用userMapper的方法
		List<User> list = userMapper.findUserByName("小明");
		sqlSession.close();
		System.out.println("输出："+list);
	}


	/*resultMap映射*/
	@Test
	public void testFindUserByIdResultMap() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//创建UserMapper对象，mybatis自动生成mapper代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		//调用userMapper的方法
		User user = userMapper.findUserByIdResultMap(1);
		System.out.println("输出："+user);
	}
}
