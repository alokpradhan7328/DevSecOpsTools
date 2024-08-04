package org.alok.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JdbcAppTest 
{
	//enabling logger
	private static Logger logger = LoggerFactory.getLogger(JdbcAppTest.class);
	
	public static void main(String[] args) 
	{
		logger.debug("org.alok.jdbc.JdbcAppTest::> Main method start()...");
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		try
		{
			//load driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");
			logger.info("org.alok.jdbc.JdbcAppTest::>Driver Class Loaded Successfully");
			//establishing connection
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "ALOKDB", "ALOKDB");
			if(con!=null)
			{
				logger.info("org.alok.jdbc.JdbcAppTest::>Driver Connection Successfully");
				//prepare sql query
				st = con.createStatement();
			}
			if(st!=null)
			{
				logger.info("org.alok.jdbc.JdbcAppTest::>Statement obj ready to Execute The SQL Query");
				rs = st.executeQuery("Select * From Emp");
			}
			if(rs!=null)
			{
				logger.info("org.alok.jdbc.JdbcAppTest::>ResultSet is keep the reuslt obj..");
				//process the rs obj data
				while(rs.next())
				{
					System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4));
					logger.debug("org.alok.jdbc.JdbcAppTest::>Data Retrieved From ResultSet obj usig getString(-)..");
				}//while
				logger.debug("org.alok.jdbc.JdbcAppTest::>ResultSet Data is Processed");
			}//if
			
		} //try
		catch (ClassNotFoundException cne) {
			logger.error("org.alok.jdbc.JdbcAppTest::>Some problem occur at loading the class.");
			cne.printStackTrace();
		}
		catch(SQLException se)
		{
			logger.error("org.alok.jdbc.JdbcAppTest::>Driver Connection Failed");
			se.printStackTrace();
		}
		
		finally 
		{
		logger.debug("org.alok.jdbc.JdbcAppTest::>Closig The JDBC Objs");
		//close thr jdbc objs
		try
		{
		if(rs!=null)
			rs.close();
		logger.debug("org.alok.jdbc.JdbcAppTest::>ResultSet Obj is Closed..");
		}//try
		catch(SQLException se)
		{
			logger.error("org.alok.jdbc.JdbcAppTest::>Some Problem Occur at RessultSet Obj "+se.getMessage());
		}//catch
		
		try {
			if(st!=null)
				st.close();
			logger.debug("org.alok.jdbc.JdbcAppTest::>Statement Obj is Closed..");
		}//try
		catch(SQLException se)
		{
			logger.error("org.alok.jdbc.JdbcAppTest::>Some Problem Occur at Statement Obj"+se.getMessage());
		}//catch
		
		try {
			if(con!=null)
				con.close();
			logger.debug("org.alok.jdbc.JdbcAppTest::>Connection is disconnected");
		}//try
		catch(SQLException se)
		{
			logger.error("org.alok.jdbc.JdbcAppTest::>Some Problem Occur at Connection Obj"+se.getMessage());
		}//catch
		}//finally
	}
}
