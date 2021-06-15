
import java.sql.*;  
class MysqlCon{  
	

public static void add(Employee employee) {
	
	try
	{  
		Class.forName("com.mysql.cj.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/jsp","root","root"); 
		String query = " insert into emp (id, name, age)"
		        + " values (?, ?, ?)";
		int id=employee.id;
		String name=employee.name;
		int age=employee.age;
		PreparedStatement preparedStmt = con.prepareStatement(query);
	     preparedStmt.setInt(1,id);
	     preparedStmt.setString(2,name);
	     preparedStmt.setInt(3,age);
	     preparedStmt.execute();
        System.out.println("Employee added!");
		con.close();  
	}
	catch(Exception e)
	{ 
		System.out.println(e);
	} 
}

	public static void delete(int id) {
		try
		{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/jsp","root","root"); 
			  String query = "delete from emp where id = ?";
		      PreparedStatement preparedStmt = con.prepareStatement(query);
		      preparedStmt.setInt(1, id);
		      preparedStmt.execute();
		      System.out.println("Employee deleted!");
		      con.close();
		}
		catch(Exception e)
		{ 
			System.out.println(e);
		} 
		
	}  
	public static void display() {
		try
		{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/jsp","root","root");  
			 
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from emp");  
			while(rs.next())  
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
			con.close();  
		}
		catch(Exception e)
		{ 
			System.out.println(e);
		} 
		
	}  

}  