package frame;
import java.sql.*;
import java.util.*;

import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
public class jilumodel extends AbstractTableModel{
	Vector rowData=null;
    Vector columnNames=null;
    boolean abc;
    int df;
 
     
    public jilumodel(){
    	
        rowData=new Vector();
        columnNames=new Vector();
        columnNames.add("ѡ��");
        columnNames.add("���վ");
        columnNames.add("�յ�վ");
        
 
        SQLHelper SQL_1=new SQLHelper();
		SQL_1.getConnection();
		SQL_1.exesql("select * from user_search where user_id ='"+Login.textField.getText()+"'");
		ResultSet rs=SQL_1.rs;

        try {
            while(rs.next()){
                Vector v=new Vector();
                v.add("");
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                //���ز�ѯ����ֵ
                rowData.add(v);
            }
             
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    
    }
        
    public jilumodel(String sql){
        rowData=new Vector();
        columnNames=new Vector();
        columnNames.add("ѡ��");
        columnNames.add("���");
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
    
    
    public   void   addRow()   {     
    	Vector   v   =   new   Vector();
    	SQLHelper SQL_2=new SQLHelper();
 		SQL_2.getConnection();
 		v.add("");
    	v.add("");
    	v.add("");
    	rowData.add(v);    
    	
 		SQL_2.updatesql("insert into  user_search values('"+Login.textField.getText()+"','','','','')");
 		


    	}     
    
    public   void   InsertData()   {     
    	Vector   v   =   new   Vector();
    	SQLHelper SQL_2=new SQLHelper();
 		SQL_2.getConnection(); 		
 		v.add("");
        v.add(Search.textField_3.getText());
        v.add(Search.textField_4.getText());
    	rowData.add(v);    
    	
 		SQL_2.updatesql("insert into user_search values('"+Login.textField.getText()+"','"+Search.textField_3.getText()+"','"+Search.textField_4.getText()+"','','')");
 		


    	}     
    	    
    	public   void   removeRow(int   row)   {     
    		rowData.remove(row);     
    		SQLHelper SQL_4=new SQLHelper();
    		SQL_4.getConnection();
     		SQL_4.updatesql("delete from user_search where user_id= '"+Login.textField.getText()+"' and search_start='"+Search.startstop+"' and search_end = '"+Search.endstop+"'");
    		
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
    	this.fireTableCellUpdated(rowIndex,   columnIndex);     

    }


}

