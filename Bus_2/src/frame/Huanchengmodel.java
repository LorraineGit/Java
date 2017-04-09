package frame;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class Huanchengmodel extends AbstractTableModel{
	Vector rowData=null;
    Vector columnNames=null;
    public static boolean f=false;
     
    public Huanchengmodel(){
        rowData=new Vector();
        columnNames=new Vector();
        columnNames.add("起始站点");
        columnNames.add("乘坐路线1");
        columnNames.add("中转站点1");
        columnNames.add("乘坐路线2");
        columnNames.add("中转站点2");
        columnNames.add("乘坐路线3");
        columnNames.add("目的站点");
        columnNames.add("总站点数");}
    
    public void huancheng(){
 
        SQLHelper c=new SQLHelper();
		c.getConnection();
		c.exesql("exec InquiryT0'"+Search.textField_3.getText()+"','"+Search.textField_4.getText()+"' ");
		ResultSet rs=c.rs;
		if(rs!=null){
		try {
            while(rs.next()){
                Vector v=new Vector();
                v.add(rs.getString(1));
                v.add(rs.getString(3));
                v.add("");
                v.add("");
                v.add("");
                v.add("");
                v.add(rs.getString(2));
                v.add(rs.getString(4));//返回查询到的值
                rowData.add(v);
                
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }}
		else
			f=true;
		

		c.exesql("exec InquiryT1'"+Search.textField_3.getText()+"','"+Search.textField_4.getText()+"' " );
		ResultSet os=c.rs;
		if(os!=null){
		try {
            while(os.next()){
                Vector s=new Vector();
                s.add(os.getString(1));
                s.add(os.getString(2));
                s.add(os.getString(3));
                s.add(os.getString(4));
                s.add("");
                s.add("");
                s.add(os.getString(5));
                s.add(os.getString(6));//返回查询到的值
                rowData.add(s);
        }} catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }}
		else
			f=true;
		
		
		
		c.exesql("exec InquiryT2'"+Search.textField_3.getText()+"','"+Search.textField_4.getText()+"'");
		ResultSet ss=c.rs;
		if(ss!=null){
		try {
            while(ss.next()){
                Vector w=new Vector();
                w.add(ss.getString(1));
                w.add(ss.getString(2));
                w.add(ss.getString(3));
                w.add(ss.getString(4));
                w.add(ss.getString(5));
                w.add(ss.getString(6));
                w.add(ss.getString(7));
                w.add(ss.getString(8));//返回查询到的值
                rowData.add(w);
            }
        
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		}
    else
    	f=true;
		
		
    }   
        
    public Huanchengmodel(String aa,String bb){
        rowData=new Vector();
        columnNames=new Vector();
        columnNames.add("起始站点");
        columnNames.add("乘坐路线1");
        columnNames.add("中转站点1");
        columnNames.add("乘坐路线2");
        columnNames.add("中转站点2");
        columnNames.add("乘坐路线3");
        columnNames.add("目的站点");
        columnNames.add("总站点数");
 
        
        SQLHelper c=new SQLHelper();
		c.getConnection();
		c.exesql("exec InquiryT0'"+aa+"','"+bb+"'");
		ResultSet rs=c.rs;
		if(rs!=null){
			try {
	            while(rs.next()){
	                Vector v=new Vector();
	                v.add(rs.getString(1));
	                v.add(rs.getString(3));
	                v.add("");
	                v.add("");
	                v.add("");
	                v.add("");
	                v.add(rs.getString(2));
	                v.add(rs.getString(4));//返回查询到的值
	                rowData.add(v);
	                
	            }
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }}
			else
				f=true;
			
		
		
		c.exesql("exec InquiryT1'"+aa+"','"+bb+"' " );
		ResultSet os=c.rs;
		if(os!=null){
			try {
	            while(os.next()){
	                Vector s=new Vector();
	                s.add(os.getString(1));
	                s.add(os.getString(2));
	                s.add(os.getString(3));
	                s.add(os.getString(4));
	                s.add("");
	                s.add("");
	                s.add(os.getString(5));
	                s.add(os.getString(6));//返回查询到的值
	                rowData.add(s);
	        }} catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }}
			else
				f=true;
			
		
		c.exesql("exec InquiryT2'"+aa+"','"+bb+"'");
		ResultSet ss=c.rs;
		if(ss!=null){
			try {
	            while(ss.next()){
	                Vector w=new Vector();
	                w.add(ss.getString(1));
	                w.add(ss.getString(2));
	                w.add(ss.getString(3));
	                w.add(ss.getString(4));
	                w.add(ss.getString(5));
	                w.add(ss.getString(6));
	                w.add(ss.getString(7));
	                w.add(ss.getString(8));//返回查询到的值
	                rowData.add(w);
	            }
	        
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
			}
	    else
	    	f=true;
		
		
    
    }
 
    
    
    public void addrow(String aa,String bb){
        
        SQLHelper c=new SQLHelper();
		c.getConnection();
		c.exesql("exec InquiryT0'"+aa+"','"+bb+"'");
		ResultSet rs=c.rs;
		if(rs!=null){
			try {
	            while(rs.next()){
	                Vector v=new Vector();
	                v.add(rs.getString(1));
	                v.add(rs.getString(3));
	                v.add("");
	                v.add("");
	                v.add("");
	                v.add("");
	                v.add(rs.getString(2));
	                v.add(rs.getString(4));//返回查询到的值
	                rowData.add(v);
	                
	            }
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }}
			else
				f=true;
			
		
		
		c.exesql("exec InquiryT1'"+aa+"','"+bb+"' " );
		ResultSet os=c.rs;
		if(os!=null){
			try {
	            while(os.next()){
	                Vector s=new Vector();
	                s.add(os.getString(1));
	                s.add(os.getString(2));
	                s.add(os.getString(3));
	                s.add(os.getString(4));
	                s.add("");
	                s.add("");
	                s.add(os.getString(5));
	                s.add(os.getString(6));//返回查询到的值
	                rowData.add(s);
	        }} catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }}
			else
				f=true;
			
		
		c.exesql("exec InquiryT2'"+aa+"','"+bb+"'");
		ResultSet ss=c.rs;
		if(ss!=null){
			try {
	            while(ss.next()){
	                Vector w=new Vector();
	                w.add(ss.getString(1));
	                w.add(ss.getString(2));
	                w.add(ss.getString(3));
	                w.add(ss.getString(4));
	                w.add(ss.getString(5));
	                w.add(ss.getString(6));
	                w.add(ss.getString(7));
	                w.add(ss.getString(8));//返回查询到的值
	                rowData.add(w);
	            }
	        
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
			}
	    else
	    	f=true;
		
		
    
    }
    public   void   removeRows(int   row,   int   count)   { 
		for   (int   i   =   0;   i   <   count;   i++)   {     
		if   (rowData.size()   >   row)   {     
		rowData.remove(row);     
		}     
		}     
	}
 
    @Override
    public int getColumnCount() {
        // TODO Auto-generated method stub
        return this.columnNames.size();
    }
 
    @Override
    public int getRowCount() {
        // TODO Auto-generated method stub
        return this.rowData.size();
    }
 
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        // TODO Auto-generated method stub
        return ((Vector)this.rowData.get(rowIndex)).get(columnIndex);
    }
 
    @Override
    public String getColumnName(int column) {
        // TODO Auto-generated method stub
        return (String)this.columnNames.get(column);
    }

}
