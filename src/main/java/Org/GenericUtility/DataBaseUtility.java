package Org.GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.Driver;
/**
 * This class is used to get data From the MySql DataBase
 * @author Shinde
 *
 */
public class DataBaseUtility
{
	Connection connection;
	/**
	 * This method is created to open the DataBase
	 * @param DBurl
	 * @param DBusername
	 * @param DBpassword
	 * @throws SQLException
	 */

	public void openDataBase(String DBurl, String DBusername, String DBpassword) throws SQLException
	{
		Driver driverref=new Driver();
		DriverManager.registerDriver(driverref);
		connection=DriverManager.getConnection(DBurl, DBusername, DBpassword);

	}
	/**
	 * This method is used to get data from database
	 * @param query
	 * @param Col_name
	 * @return
	 * @throws SQLException
	 */
	public List<String> getDataFromDataBase( String query, String Col_name) throws SQLException
	{

		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery(query);
		List<String> list= new ArrayList<String>();
		while(result.next())
		{

			list.add(result.getString(Col_name));
		}


		return list;
	}


	/**
	 * This method is used to  add data to Database
	 * @param query
	 * @throws SQLException
	 */
	public void addDataToDataBase( String query) throws SQLException 
	{

		Statement statement = connection.createStatement();
		int result = statement.executeUpdate(query);
		System.out.println("Data Updated  "+result);

	}

	/** 
	 * This method is used to verify the added data in Database
	 * @param query
	 * @param Col_name
	 * @param expecteddata
	 * @return
	 * @throws SQLException
	 */
	public boolean verifyDataInDataBase(String query, String Col_name,String expecteddata ) throws SQLException 
	{
		List<String> list = getDataFromDataBase(query, Col_name);
		boolean flag = false;
		for (String actualdata : list) 
		{
			if(actualdata.equalsIgnoreCase(expecteddata))
			{
				flag=true;

			}
		}
		return flag;
	}


	/**
	 * This method is used to close the DataBase connection
	 * @throws SQLException
	 */
	public void closeDataBase() throws SQLException
	{

		connection.close();

	}
}
