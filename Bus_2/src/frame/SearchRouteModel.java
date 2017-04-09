package frame;
import java.sql.*;
import java.util.*;

import javax.swing.table.AbstractTableModel;

public class SearchRouteModel extends AbstractTableModel{
	 
    Vector rowData=null;
    Vector columnNames=null;
     
    public SearchRouteModel(){
        rowData=new Vector();
        columnNames=new Vector();
        columnNames.add("线路名");
        columnNames.add("普通车票价（元）");
        columnNames.add("空调车票价（元）");
        columnNames.add("起点站");
        columnNames.add("起点站首班车");
        columnNames.add("起点站末班车");
        columnNames.add("终点站");
        columnNames.add("终点站首班车");
        columnNames.add("终点站末班车");
        columnNames.add("下行方向停靠车站");
        columnNames.add("上行方向停靠车站");
 
        SQLHelper c=new SQLHelper();
		c.getConnection();
		c.exesql("select * from Route");
		ResultSet rs=c.rs;

        try {
            while(rs.next()){
                Vector v=new Vector();
                
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
        }
    
    }
        
    public SearchRouteModel(String sql){
        rowData=new Vector();
        columnNames=new Vector();
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