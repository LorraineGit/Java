package frame;
import java.sql.*;
import java.util.*;

import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
public class ManagementRouteModel extends AbstractTableModel{
	Vector rowData=null;
    Vector columnNames=null;
    boolean abc;
    int df;
 
     
    public ManagementRouteModel(){
    	
        rowData=new Vector();
        columnNames=new Vector();
        columnNames.add("选择");
        columnNames.add("序号");
        columnNames.add("线路名");
        columnNames.add("普通车票价（元）");
        columnNames.add("空调车票价（元)");
        columnNames.add("起点站");
        columnNames.add("起点站首班车");
        columnNames.add("起点站末班车");
        columnNames.add("终点站");
        columnNames.add("终点站首班车");
        columnNames.add("终点站末班车");
        columnNames.add("下行方向停靠车站");
        columnNames.add("上行方向停靠车站");
 
        SQLHelper SQL_1=new SQLHelper();
		SQL_1.getConnection();
		SQL_1.exesql("select * from Route order by Id");
		ResultSet rs=SQL_1.rs;

        try {
            while(rs.next()){
                Vector v=new Vector();
                v.add("");
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getString(5));
                v.add(rs.getString(6));
                v.add(rs.getString(7));
                v.add(rs.getString(8));
                v.add(rs.getString(9));
                v.add(rs.getString(10));
                v.add(rs.getString(11));
                v.add(rs.getString(12));
                //返回查询到的值
                rowData.add(v);
            }
             
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    
    }
        
    public ManagementRouteModel(String sql){
        rowData=new Vector();
        columnNames=new Vector();
        columnNames.add("选择");
        columnNames.add("序号");
        columnNames.add("线路名");
        columnNames.add("普通车票价（元）");
        columnNames.add("空调车票价（元）");
        columnNames.add("起点站");
        columnNames.add("起点站首班车");
        columnNames.add("起点站末班车");
        columnNames.add("终点站");
        columnNames.add("终点站首班车");
        columnNames.add("终点站末班车");
        columnNames.add("下行的方向停靠车站");
        columnNames.add("上行的方向停靠车站");
 
         
        //创建SqlHelper对象
        SQLHelper sh=new SQLHelper();
        sh.getConnection();
        sh.exesql(sql);
        ResultSet rs=sh.rs;
        try {
            while(rs.next()){
                Vector v=new Vector();
                v.add("");
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getString(5));
                v.add(rs.getString(6));
                v.add(rs.getString(7));
                v.add(rs.getString(8));
                v.add(rs.getString(9));
                v.add(rs.getString(10));
                v.add(rs.getString(11));
                v.add(rs.getString(12));//返回查询到的值
                rowData.add(v);
            }
             
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            sh.close(rs);
        }
         
    }
    
    
    public   void   addRow()   {     
    	Vector   v   =   new   Vector(11);
    	SQLHelper SQL_2=new SQLHelper();
 		SQL_2.getConnection();
 		SQL_2.exesql("select count from count where ID=1");
 		ResultSet rs = SQL_2.rs;

		try {
			while (rs.next()) {
				df=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		df++;
		
		SQL_2.updatesql("update count set count="+df+"  where ID=1");

    	v.add("");
    	v.add(df);
    	  
    	for(int i=0;i<11;i++)
    	{
    		v.add("");
    	}
     
    	rowData.add(v);    
    	
 		SQL_2.updatesql("insert into  Route values('"+df+"','','','','','','','','','','','')");
 		


    	}     
    	    
    	public   void   removeRow(int   row)   {     
    		rowData.remove(row);     
    		SQLHelper SQL_4=new SQLHelper();
    		SQL_4.getConnection();
     		SQL_4.exesql("select count from count where ID=1");
     		ResultSet rs = SQL_4.rs;

    		try {
    			while (rs.next()) {
    				df=rs.getInt(1);
    			}
    		} catch (SQLException e) {
    			// TODO 自动生成的 catch 块
    			e.printStackTrace();
    		}
    		df--;
    		
    		SQL_4.updatesql("update count set count="+df+"  where ID=1");
    		SQL_4.updatesql("delete from Route where ID= "+(row+1)+"");
    		
    	}     
    
    	
    	
    	
    	
    	public   void   removeRows(int   row,   int   count)   { 
    		SQLHelper SQL_4=new SQLHelper();
    		SQL_4.getConnection();
     		SQL_4.exesql("select count from count where ID=1");
     		ResultSet rs = SQL_4.rs;

    		try {
    			while (rs.next()) {
    				df=rs.getInt(1);
    			}
    		} catch (SQLException e) {
    			// TODO 自动生成的 catch 块
    			e.printStackTrace();
    		}
    		df--;
    		
    		SQL_4.updatesql("update count set count="+df+"  where ID=1");
    		
    		for   (int   i   =   0;   i   <   count;   i++)   {     
    		if   (rowData.size()   >   row)   {     
    		rowData.remove(row);     
    		}     
    		}     
    	}
 
    public boolean isCellEditable(int rowIndex, int columnIndex) {
    	return true;
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
    
    public void setValueAt(Object aValue, int rowIndex, int columnIndex)
    {
    	((Vector)   rowData.get(rowIndex)).remove(columnIndex);     
    	((Vector)   rowData.get(rowIndex)).add(columnIndex,   aValue);     
    	this.fireTableCellUpdated(rowIndex, columnIndex);     

    }

}

