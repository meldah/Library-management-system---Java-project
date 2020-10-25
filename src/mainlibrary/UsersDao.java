package mainlibrary;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class UsersDao {
    
    
    public static boolean validate(String name,String password){
		boolean status=false;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from Users where UserName=? and UserPass=?");
			ps.setString(1,name);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			status=rs.next();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
    
    public static boolean CheckIfAlready(String UserName)
    {
        boolean status=false;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from Users where UserName=?");
			ps.setString(1,UserName);
			ResultSet rs=ps.executeQuery();
			status=rs.next();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
        
    }
    
    

    public  static int AddUser(String user, String userPass, String userEmail, String date,String userFullName,String studentClass,String year) {
       
         int status =0;
         try{
        
            Connection con =DB.getConnection();
            PreparedStatement ps= con.prepareStatement("insert into Users(UserPass,RegDate,UserName,Email,UserFullName,StudentClass,Year) values(?,?,?,?,?,?,?)");
            ps.setString(1,userPass);
            ps.setString(2,date);
            ps.setString(3,user);
            ps.setString(4,userEmail);
            ps.setString(5,userFullName);
            ps.setString(6,studentClass);
            ps.setString(7, year);
            status =ps.executeUpdate();
            con.close();
}catch(Exception e){System.out.println(e);}
    return status; 
    
    
    }

    
}
