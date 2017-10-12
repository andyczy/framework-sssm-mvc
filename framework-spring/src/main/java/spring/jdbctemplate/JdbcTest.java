package spring.jdbctemplate;

import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;


/**
 * @auther 陈郑游
 * @create 2016-12-03-17:49
 * @功能描述 JdbcTemplate实现
 * @公司地址
 */

public class JdbcTest {

	private DriverManagerDataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	/**配置的方式、直接读取配置文件*/
	public void setDataSource(DataSource dataSource){
		jdbcTemplate.setDataSource(dataSource);
	}

	@Before
	public void before(){
		//配置数据库信息
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///ssm");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
	}

	@Test
	public void add(){
		//配置模板数据源
		jdbcTemplate = new JdbcTemplate(dataSource);

		String sql = "insert into user value(?,?) ";
		int rows = jdbcTemplate.update(sql,"10","user");
		System.out.println(rows);
	}
}
