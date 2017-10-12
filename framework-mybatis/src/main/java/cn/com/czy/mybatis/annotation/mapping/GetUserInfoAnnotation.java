package cn.com.czy.mybatis.annotation.mapping;

import org.apache.ibatis.annotations.Select;

/**
 * 总结：
 * 1、用注解方式
 * 2、了解getClassLoader、SqlSessionFactory的基本原理
 * 3、接口规范
 */
public interface GetUserInfoAnnotation {
	
	@Select("select * from user where id = #{id}")
	public User_one getUser(int id);
}
