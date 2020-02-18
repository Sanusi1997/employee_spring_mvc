package com.employee.dao;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Hameed Sanusi
 *
 */

@ContextConfiguration("classpath:data-context.xml")

@RunWith(SpringRunner.class)
public class EmployeeDaoImplTest {

	@Autowired
	EmployeeDao employeeDaoImpl;

	/**
	 * @throws java.lang.Exception
	 */

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void dbConnectionTest() throws SQLException {
		String jdbcUrl = "jdbc:mysql://localhost:3306/employee_db?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
		String user = "employee_user";
		String password = "employee123";
		String driver = "com.mysql.cj.jdbc.Driver";
			
		Connection dbCon = null;
		
			try {
				dbCon = DriverManager.getConnection(jdbcUrl, user, password);
			}
			catch(SQLException sqle){
				
				sqle.printStackTrace();
			}
			finally {
				dbCon.close();
				
			}
		}

}
