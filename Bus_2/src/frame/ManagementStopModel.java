package frame;
import java.sql.*;
import java.util.*;

import javax.swing.table.AbstractTableModel;
public class ManagementStopModel extends AbstractTableModel{
	 Vector rowData=null;
	    Vector columnNames=null;
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
