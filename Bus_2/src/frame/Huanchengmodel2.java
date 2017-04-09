package frame;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class Huanchengmodel2 extends AbstractTableModel{
	static Dijkstra1 search=new Dijkstra1();
	Node[] node=search.getNode();
	int x;
	int y;
	int price=0;
	Vector rowData=null;
    Vector columnNames=null;
    boolean a=false;
    boolean b=false;
    boolean d=false;
    public static boolean f=true;
    Object [] info=new Object[11]; 
    public Huanchengmodel2(){
    	rowData=new Vector();
    	columnNames=new Vector();
    	columnNames.add("");
    	columnNames.add("起始站点");
    	columnNames.add("乘坐路线1");
    	columnNames.add("中转站点1");
    	columnNames.add("乘坐路线2");
    	columnNames.add("目的站点");
    	columnNames.add("总站点数");
    	columnNames.add("总时间");
    	columnNames.add("总价格");
    	
    }
  
    
public void work1(){
	price=0;
        for(int i=1;i<Dijkstra1.nodelen;i++){
        	if(node[i].getName().equals(Search.textField_3.getText())&&node[i]!=null)
        		x=node[i].getIndex();
        	if(node[i].getName().equals(Search.textField_4.getText())&&node[i]!=null)
        		y=node[i].getIndex();
        }
        int []ans1=search.work1(x, y);
        int i=ans1[0];        //经过的站点数
		int k=1;
		int j=i+1;
		int r=0;
		while(j<i*2){
			//System.out.println("No."+Dijkstra1.route[ans1[j]].getName()+" :"+node[ans1[k++]].getName()+"->");
			info[r++]=node[ans1[k++]].getName();
			info[r++]=Dijkstra1.route[ans1[j]].getName();
			price=price+Dijkstra1.route[ans1[j]].getPrice();
			j++;
			while(ans1[j]==ans1[j-1]&&j<i*2){//System.out.println(node[ans1[k]].getName()+"->");
			j++;k++;}
			if(j<i*2||k<=i)
				info[r++]=node[ans1[k]].getName();
				//System.out.println(""+node[ans1[k]].getName());

		}
		info[8]=ans1[0];
		info[9]=new DecimalFormat("#.00").format(search.getAnsTime());
		info[10]=price;
		//System.out.println("Full time "+new DecimalFormat("#.00").format(search.getAnsTime())+"\n");
       
		if(info[3]==null){
                Vector v=new Vector();
                v.add("最省时间（不含换乘等待时间）");
                v.add(info[0]);
                v.add(info[1]);
                v.add("");
                v.add("");
                v.add(info[2]);
                v.add(info[8]);
                v.add(info[9]);
                v.add(info[10]);//返回查询到的值
                rowData.add(v);
    
		} 
		else{
			 Vector v=new Vector();
			 v.add("最省时间（不含换乘等待时间）");
             v.add(info[0]);
             v.add(info[1]);
             v.add(info[2]);
             v.add(info[4]);
             v.add(info[5]);
             v.add(info[8]);
             v.add(info[9]);
             v.add(info[10]);//返回查询到的值
             rowData.add(v);
 
			
		}
		
		 
        }
 
    
    public void work2(){
    	price=0;
        for(int i=1;i<Dijkstra1.nodelen;i++){
        	if(node[i].getName().equals(Search.textField_3.getText())&&node[i]!=null)
        		x=node[i].getIndex();
        	if(node[i].getName().equals(Search.textField_4.getText())&&node[i]!=null)
        		y=node[i].getIndex();
        }
        int []ans1=search.work2(x, y);
        int i=ans1[0];        //经过的站点数
		int k=1;
		int j=i+1;
		int r=0;
		while(j<i*2){
			//System.out.println("No."+Dijkstra1.route[ans1[j]].getName()+" :"+node[ans1[k++]].getName()+"->");
			info[r++]=node[ans1[k++]].getName();
			info[r++]=Dijkstra1.route[ans1[j]].getName();
			price=price+Dijkstra1.route[ans1[j]].getPrice();
			j++;
			while(ans1[j]==ans1[j-1]&&j<i*2){//System.out.println(node[ans1[k]].getName()+"->");
			j++;k++;}
			if(j<i*2||k<=i)
				info[r++]=node[ans1[k]].getName();
				//System.out.println(""+node[ans1[k]].getName());

		}
		info[8]=ans1[0];
		info[9]=new DecimalFormat("#.00").format(search.getAnsTime());
		info[10]=price;
		//System.out.println("Full time "+new DecimalFormat("#.00").format(search.getAnsTime())+"\n");
       
		if(info[3]==null){
                Vector v=new Vector();
                v.add("最省时间");
                v.add(info[0]);
                v.add(info[1]);
                v.add("");
                v.add("");
                v.add(info[2]);
                v.add(info[8]);
                v.add(info[9]);
                v.add(info[10]);//返回查询到的值
                rowData.add(v);
                a=true;
		} 
		else{
			 Vector v=new Vector();
			 v.add("最省时间");
             v.add(info[0]);
             v.add(info[1]);
             v.add(info[2]);
             v.add(info[4]);
             v.add(info[5]);
             v.add(info[8]);
             v.add(info[9]);
             v.add(info[10]);//返回查询到的值
             rowData.add(v);
             a=true;
			
		}
        }
    
    
    
    public void work3(){
    	price=0;
        for(int i=1;i<Dijkstra1.nodelen;i++){
        	if(node[i].getName().equals(Search.textField_3.getText())&&node[i]!=null)
        		x=node[i].getIndex();
        	if(node[i].getName().equals(Search.textField_4.getText())&&node[i]!=null)
        		y=node[i].getIndex();
        }
        int []ans1=search.work3(x, y);
        int i=ans1[0];        //经过的站点数
		int k=1;
		int j=i+1;
		int r=0;
		while(j<i*2){
			//System.out.println("No."+Dijkstra1.route[ans1[j]].getName()+" :"+node[ans1[k++]].getName()+"->");
			info[r++]=node[ans1[k++]].getName();
			info[r++]=Dijkstra1.route[ans1[j]].getName();
			price=price+Dijkstra1.route[ans1[j]].getPrice();
			j++;
			while(ans1[j]==ans1[j-1]&&j<i*2){//System.out.println(node[ans1[k]].getName()+"->");
			j++;k++;}
			if(j<i*2||k<=i)
				info[r++]=node[ans1[k]].getName();
				//System.out.println(""+node[ans1[k]].getName());

		}
		info[8]=ans1[0];
		info[9]=new DecimalFormat("#.00").format(search.getAnsTime());
		info[10]=price;
		//System.out.println("Full time "+new DecimalFormat("#.00").format(search.getAnsTime())+"\n");
       
		if(info[3]==null){
                Vector v=new Vector();
                v.add("花费最少");
                v.add(info[0]);
                v.add(info[1]);
                v.add("");
                v.add("");
                v.add(info[2]);
                v.add(info[8]);
                v.add(info[9]);
                v.add(info[10]);//返回查询到的值
                rowData.add(v);
                a=true;
		} 
		else{
			 Vector v=new Vector();
			 v.add("花费最少");
             v.add(info[0]);
             v.add(info[1]);
             v.add(info[2]);
             v.add(info[4]);
             v.add(info[5]);
             v.add(info[8]);
             v.add("");
             v.add(info[10]);//返回查询到的值
             rowData.add(v);
             a=true;
			
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
