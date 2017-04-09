package frame;
  
import java.sql.*;  
import java.util.logging.*;  

public class SQL  
{  
    /** 
     * ���� 
     */  
	public static String driverName = "oracle.jdbc.driver.OracleDriver";
	//���ӷ����������ݿ�sample
	public static String dbURL = "jdbc:oracle:thin:@211.87.227.230:1521:ORCL";
	public static String userName = "USER201418130123"; //Ĭ���û���
	public static String userPwd = "123"; //����
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
    
    public static void main(String[] args) {
    	SQL a =new SQL();
    	a.getConnection();
    }
}  