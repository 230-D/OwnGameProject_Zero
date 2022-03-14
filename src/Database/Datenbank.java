package Database;

import java.sql.*;

public class Datenbank {

	// Connection with JDBC-Driver
	 private static Connection connection;
	{
		try
		{
			Class<?> c = Class.forName("com.mysql.cj.jdbc.Driver");
					if (c != null)
					{
						System.out.println("JDBC-Treiber geladen");
					}
		}
		catch (ClassNotFoundException e)
		{
			System.err.println("Fehler beim Laden des JDBC-Treibers");
			System.exit(1);
		}
	}

	public Datenbank()
	{
		createConnection();
		createDBStructure();
		
		Thread shutDownHook = new Thread ()
		{
			public void run()
			{
				System.out.println("Running shutdown hook");	
				if (connection == null)
				{
					System.out.println("Connection to Database already closed");
				}
					try
					{
						if(connection != null && !connection.isClosed())
						{
							connection.close();
							if (connection.isClosed())
								System.out.println("Connection to Database closed");
						}	
					}
					catch (SQLException e)
					{
						System.err.println("Shutdown hook couldn't close Database connection.");
					}
			}
		};
				Runtime.getRuntime().addShutdownHook(shutDownHook);
	}
	
	private void createConnection()
	{
		String url = "jdbc:mysql://localhost/?rewriteBatchedStatements=true";
		String user = "root";
		String pass = "";
		
		try
		{
			System.out.println("Creating DBConnection");
			connection = DriverManager.getConnection(url, user, pass);
		}
		catch (SQLException e)
		{
			System.err.println("Couldn't Create DBConnection");
			System.exit(1);
		}
	}
	
	// Create DBName and Table Structure
	private boolean createDBStructure()
	{
		String dbName = "story";
		String query0 = "CREATE DATABASE IF NOT EXISTS `" + dbName +"`";
		String query1 = "USE `" + dbName + "`";
		String query2 = "SET SQL_MODE ='NO_AUTO_VALUE_ON_ZERO' ";
		
		String query3 = "CREATE TABLE IF NOT EXISTS `story`.`history` ("
				+ "`ID` int(50) NOT NULL auto_increment PRIMARY KEY, "
				+ "`Avatarname` varchar(50) NOT NULL DEFAULT '', "
				+ "`Charakter` varchar(20) NOT NULL DEFAULT '', "
                + "`Gegenstand` varchar(50) NOT NULL DEFAULT '' "
                + ") ENGINE=InnoDB DEFAULT CHARSET=utf8 "
                + "DEFAULT COLLATE=utf8_german2_ci"; 
		
/*	String query4 = "CREATE TABLE IF NOT EXISTS `test`.`bla` ("
                + "`Avatar` varchar(50) NULL, "
                + "`Gegen` varchar(100) NULL, "
                + "`GegenID` int(50) NOT NULL auto_increment, " + "UNIQUE KEY `ID` (`GegenID`)"
                + ") ENGINE=InnoDB DEFAULT CHARSET=utf8 "
                + "DEFAULT COLLATE=utf8_german2_ci"; 
*/
		Statement stmt = null;
		
		try
		{
			connection.setAutoCommit(false);
			stmt = connection.createStatement();
			stmt.addBatch(query0);
			stmt.addBatch(query1);
			stmt.addBatch(query2);
			stmt.addBatch(query3);
			//stmt.addBatch(query4);
			stmt.executeBatch();
			connection.commit();
			stmt.close();
			connection.close();
			System.out.println("Database sucessfully created or just existing");
			return true;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (stmt != null)
					stmt.close();
				if (connection != null)
					connection.close();
			}
			catch (SQLException e)
			{
				
			}
		}
		return false;		
	}

	public static void main(String[] args) {
		new Datenbank();
	}
}
