package frame;
  
import java.sql.*;  
import java.util.logging.*;  

public class SQL  
{  
    /** 
     * 驱动 
     */  
	public static String driverName = "oracle.jdbc.driver.OracleDriver";
	//连接服务器和数据库sample
	public static String dbURL = "jdbc:oracle:thin:@211.87.227.230:1521:ORCL";
	public static String userName = "USER201418130123"; //默认用户名
	public static String userPwd = "123"; //密码
	public static Connection Conn;
	public static Statement stmt;
	public static ResultSet rs ;
	public static PreparedStatement pst;
    
	
	 public  void getConnection()  
	    {  
	        try  
	        {  
	            // 获取驱动,这里使用的是 sqljdbc_1.2.2828.100_chs.exe,不同版本的驱动,语句有所不同  
	            Class.forName(driverName);  
	        }  catch (Exception e1) {
				System.out.println("找不到驱动程序类 ，加载驱动失败！");
				e1.printStackTrace();}
	        try  
	        {  
	            Conn=DriverManager.getConnection(dbURL, userName, userPwd); 
	            
	        }catch (Exception e1) {
				e1.printStackTrace();
				System.out.println("数据库连接失败");
			}
	    }  
 
	 public  ResultSet exesql(String a)  {
		try {
			stmt = Conn.createStatement();
			rs = stmt.executeQuery(a);
			return rs;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	 }
	 
	 public  void updatesql(String a)  {
			try {
				stmt = Conn.createStatement();
				stmt.executeUpdate(a);
				Conn.commit(); 
				
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			
		 }
    
    public static void close(Object obj)  
    {  
        if (obj == null)  
        {  
            return;  
        }  
        try  
        {  
            if (obj instanceof Statement)  
            {  
                ((Statement) obj).close();  
            } else if (obj instanceof PreparedStatement)  
            {  
                ((PreparedStatement) obj).close();  
            } else if (obj instanceof ResultSet)  
            {  
                ((ResultSet) obj).close();  
            } else if (obj instanceof Connection)  
            {  
                ((Connection) obj).close();  
            }  
        } catch (SQLException ex)  
        {  
            Logger.getLogger(SQLHelper.class.getName()).log(Level.SEVERE, null, ex);  
        }  
    }  
    
    public static void main(String[] args) {
    	SQL a =new SQL();
    	a.getConnection();
    }
}  