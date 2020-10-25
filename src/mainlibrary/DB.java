package mainlibrary;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DB {
    

	public static Connection getConnection(){
		Connection con=null;
		try{
                            Properties props = new Properties(); 
    props.put("user", "root");         
    props.put("password", "adminMelda96");
    props.put("useUnicode", "true");
    props.put("useServerPrepStmts", "false"); 
    props.put("characterEncoding", "UTF-8"); 

			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/library?autoReconnect=true&useSSL=false",
                                props);
		}catch(ClassNotFoundException | SQLException e){System.out.println(e);}
		return con;
	}
}
