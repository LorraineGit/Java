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
        columnNames.add("��·��");
        columnNames.add("��ͨ��Ʊ�ۣ�Ԫ��");
        columnNames.add("�յ���Ʊ�ۣ�Ԫ��");
        columnNames.add("���վ");
        columnNames.add("���վ�װ೵");
        columnNames.add("���վĩ�೵");
        columnNames.add("�յ�վ");
        columnNames.add("�յ�վ�װ೵");
        columnNames.add("�յ�վĩ�೵");
        columnNames.add("���з���ͣ����վ");
        columnNames.add("���з���ͣ����վ");
 
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
                v.add(rs.getString(12));//���ز�ѯ����ֵ
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
        columnNames.add("��·��");
        columnNames.add("��ͨ��Ʊ�ۣ�Ԫ��");
        columnNames.add("�յ���Ʊ�ۣ�Ԫ��");
        columnNames.add("���վ");
        columnNames.add("���վ�װ೵");
        columnNames.add("���վĩ�೵");
        columnNames.add("�յ�վ");
        columnNames.add("�յ�վ�װ೵");
        columnNames.add("�յ�վĩ�೵");
        columnNames.add("���еķ���ͣ����վ");
        columnNames.add("���еķ���ͣ����վ");
 
         
        //����SqlHelper����
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
                v.add(rs.getString(12));//���ز�ѯ����ֵ
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