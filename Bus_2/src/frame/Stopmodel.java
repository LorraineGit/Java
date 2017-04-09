package frame;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class Stopmodel extends AbstractTableModel{
	Vector rowData=null;
    Vector columnNames=null;
    
    public Stopmodel(){
    	rowData=new Vector();
        columnNames=new Vector();
        columnNames.add("选择");
        columnNames.add("序号");
        columnNames.add("站点名称");
        columnNames.add("经度");
        columnNames.add("纬度");
        
        SQLHelper SQL_1=new SQLHelper();
		SQL_1.getConnection();
		SQL_1.exesql("select * from Stop order by index1");
		ResultSet rs=SQL_1.rs;

        try {
            while(rs.next()){
                Vector v=new Vector();
                v.add("");
                v.add(rs.getString(4));
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                //返回查询到的值
                rowData.add(v);
            }
             
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    	
    }
    
    public Stopmodel(String sql){
    	rowData=new Vector();
        columnNames=new Vector();
        columnNames.add("选择");
        columnNames.add("序号");
        columnNames.add("站点名称");
        columnNames.add("经度");
        columnNames.add("纬度");
        
        SQLHelper SQL_1=new SQLHelper();
		SQL_1.getConnection();
		SQL_1.exesql(sql);
		ResultSet rs=SQL_1.rs;

        try {
            while(rs.next()){
                Vector v=new Vector();
                v.add("");
                v.add(rs.getString(4));
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                //返回查询到的值
                rowData.add(v);
            }
             
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public   void   addRow()   {     
    	Vector   v   =   new   Vector(11);
    	SQLHelper SQL_2=new SQLHelper();
 		SQL_2.getConnection();
   	  
    	for(int i=0;i<3;i++)
    	{
    		v.add("");
    	}
     
    	rowData.add(v);    
    	
 		SQL_2.updatesql("insert into  Stop values('',0,0)");
 		


    	}     
    	    
    	public   void   removeRow(int   row)   {     
    		rowData.remove(row);     
    		SQLHelper SQL_4=new SQLHelper();
    		SQL_4.getConnection();
    		SQL_4.updatesql("delete from Stop where index1= "+Management.index+"");
    		
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
