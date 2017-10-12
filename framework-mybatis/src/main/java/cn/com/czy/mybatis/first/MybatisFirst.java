package cn.com.czy.mybatis.first;

import cn.com.czy.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * 《单表映射》
 * 入门程序总结：这是简单的mybatis入门程序
 * -- 1、映射(mapper)文件是userFirst.xml
 * -- 2、逻辑基本的resultType、parameterType等一下基础知识
 * -- 3、SqlSessionFactory、SqlSession的原理
 */
public class MybatisFirst {


    /**
     * 1、通过SqlSessionFactoryBuilder构造器构建sqlSerssionFactory(this is interface class)
     *
     *
     * @return SqlSessionFactory
     */
    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        // mybatis配置文件
        String resource = "config/SqlMapConfig.xml";
        // 得到配置文件流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 创建会话工厂，传入mybatis的配置文件信息
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 返回sqlSessionFactory
        return sqlSessionFactory;
    }



    /**
     * 根据id查询用户信息，得到一条记录结果
     *
     *
     * @return SqlSessionFactory
     */
    @Test
    public void findUserByIdTest() throws IOException {
        // 通过工厂得到SqlSession
        SqlSession sqlSession = this.getSqlSessionFactory().openSession();
        // 通过SqlSession操作数据库
        // 第一个参数：映射文件中statement的id，等于=namespace+"."+statement的id
        // 第二个参数：指定和映射文件中所匹配的parameterType类型的参数
        // sqlSession.selectOne结果 是与映射文件中所匹配的resultType类型的对象
        // selectOne查询出一条记录
        User user = sqlSession.selectOne("test.findUserById", 1);
        // 后台输出
        System.out.println(user);
        // 释放资源
        sqlSession.close();
    }



    // 根据用户名称模糊查询用户列表
    @Test
    public void findUserByNameTest() throws IOException {
        // 通过工厂得到SqlSession
        SqlSession sqlSession = this.getSqlSessionFactory().openSession();
        // list中的user和映射文件中resultType所指定的类型一致
        List<User> list = sqlSession.selectList("test.findUserByName", "小明");
        System.out.println("信息：" + list);
        // 释放资源
        sqlSession.close();
    }

    // 添加用户信息
    @Test
    public void insertUserTest() throws IOException {
        // 通过工厂得到SqlSession
        SqlSession sqlSession = this.getSqlSessionFactory().openSession();
        // 插入用户对象
        User user = new User();
        user.setUsername("军");
        user.setBirthday(new Date());
        user.setSex("1");
        user.setAddress("郑州");
        // 执行
        sqlSession.insert("test.insertUser", user);
        // 提交事务
        sqlSession.commit();
        // 获取用户信息主键
        System.out.println(user.getId());
        // 关闭会话
        sqlSession.close();
    }

    // 根据id删除 用户信息
    @Test
    public void deleteUserTest() throws IOException {
        // 通过工厂得到SqlSession
        SqlSession sqlSession = this.getSqlSessionFactory().openSession();
        // 传入id删除 用户
        sqlSession.delete("test.deleteUser", 49);
        // 提交事务
        sqlSession.commit();
        // 关闭会话
        sqlSession.close();
    }

    // 更新用户信息
    @Test
    public void updateUserTest() throws IOException {
        // 通过工厂得到SqlSession
        SqlSession sqlSession = this.getSqlSessionFactory().openSession();
        // 更新用户信息
        User user = new User();
        // 必须设置id
        user.setId(41);
        user.setUsername("王大军");
        user.setBirthday(new Date());
        user.setSex("2");
        user.setAddress("河南郑州");
        //执行
        sqlSession.update("test.updateUser", user);
        // 提交事务
        sqlSession.commit();
        // 关闭会话
        sqlSession.close();
    }
}