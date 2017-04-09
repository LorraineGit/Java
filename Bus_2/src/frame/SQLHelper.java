package frame;
  
import java.sql.*;  
import java.util.logging.*;  
  
 
 
public class SQLHelper  
{  
    /** 
     * ���� 
     */  
	public static String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	//���ӷ����������ݿ�sample
	public static String dbURL = "jdbc:sqlserver://localhost:1433; DatabaseName=Bus";
	public static String userName = "sa"; //Ĭ���û���
	public static String userPwd = "allbeautymustdie"; //����
	public static Connection Conn;
	public static Statement stmt;
	public static ResultSet rs ;
	public static PreparedStatement pst;
    
	
	 public  void getConnection()  
	    {  
	        try  
	        {  
	            // ��ȡ����,����ʹ�õ��� sqljdbc_1.2.2828.100_chs.exe,��ͬ�汾������,���������ͬ  
	            Class.forName(driverName);  
	        }  catch (Exception e1) {
				System.out.println("�Ҳ������������� ����������ʧ�ܣ�");
				e1.printStackTrace();}
	        try  
	        {  
	            Conn=DriverManager.getConnection(dbURL, userName, userPwd); 
	            
	        }catch (Exception e1) {
				e1.printStackTrace();
				System.out.println("���ݿ�����ʧ��");
			}
	    }  
 
	 public  ResultSet exesql(String a)  {
		try {
			stmt = Conn.createStatement();
			rs = stmt.executeQuery(a);
			return rs;
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
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
				// TODO �Զ����ɵ� catch ��
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
    
    
}  