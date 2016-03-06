package cn.itcast.demo1;

import org.junit.Test;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * c3p0
 * @author 杨谦
 * @date 2015-8-16 下午9:53:02
 *
 */
public class Demo1 {
	@Test
	public void fun1()  throws SQLException, PropertyVetoException {
		//创建连接池对象
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		
		//对连接池的四大参数进行配置
		dataSource.setDriverClass("com.mysql.jdbc.Driver");
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/mydb1");
		dataSource.setUser("root");
		dataSource.setPassword("1234");
		
		//对连接池中的属性进行配置
		dataSource.setAcquireIncrement(10);
		dataSource.setInitialPoolSize(20);
		dataSource.setMinPoolSize(2);
		dataSource.setMaxPoolSize(50);
		
		//获取连接
		Connection conn = dataSource.getConnection();
		System.out.println(conn);
		conn.close();
	}
	
	@Test
	/**
	 * 使用默认的c3p0的配置文件中的数据
	 * @throws SQLException
	 */
	public void fun2() throws SQLException {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		
		Connection conn = dataSource.getConnection();
		System.out.println(conn);
		conn.close();
	}
	
	@Test
	/**
	 * 使用的c3p0中由我自身指定的文件的数据
	 * @throws SQLException
	 */
	public void fun3() throws SQLException {
		ComboPooledDataSource dataSource = new ComboPooledDataSource("oracle-config");
		
		Connection conn = dataSource.getConnection();
		System.out.println(conn);
		conn.close();
	}
}
