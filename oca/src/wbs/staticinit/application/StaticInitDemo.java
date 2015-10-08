package wbs.staticinit.application;

import java.sql.SQLException;

import wbs.staticinit.IStatement;
import wbs.staticinit.MyDriverManager;

public class StaticInitDemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
//		String driver_1 = "wbs.staticinit.mysql.MySqlDriver";
//		String driver_2 = "wbs.staticinit.derby.DerbyDriver";
//		
//		String url_1 = "jdbc:mysql://localhost:3306/lotto";
//		String url_2 = "jdbc:derby://localhost:1507/mydict";
		
		
		String driver_1 = args[0];
		String driver_2 = args[1];
		
		String url_1 = args[2];
		String url_2 = args[3];
		
		Class.forName(driver_1);
		Class.forName(driver_2);
		
		IStatement stmt1 = MyDriverManager.getConnection(url_1).createStatement();
		IStatement stmt2 = MyDriverManager.getConnection(url_2).createStatement();
		
		System.out.println(stmt1.getClass().getName());
		System.out.println(stmt2.getClass().getName());


	}

}
