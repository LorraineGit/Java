package frame;

import java.awt.Color;  
import java.awt.Component;  
   

import javax.swing.JTable;  
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableCellRenderer;  
import javax.swing.table.TableCellRenderer;  
   
public class EvenOddRenderer extends JTextArea implements TableCellRenderer {  
	

   
    public static  DefaultTableCellRenderer DEFAULT_RENDERER = new DefaultTableCellRenderer();  

   
    @Override  
    public Component getTableCellRendererComponent(JTable table, Object value,  
            boolean isSelected, boolean hasFocus, int row, int column) {  
        // TODO Auto-generated method stub  
     

        Component renderer = DEFAULT_RENDERER.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);  
        Color foreground = null, background = null;  
        if(isSelected) {  
            foreground = Color.black;  
            background = Color.LIGHT_GRAY;  
        }  
        
 
       
        renderer.setForeground(foreground);  
        renderer.setBackground(background);  
        return renderer;  
    }  
   
}  