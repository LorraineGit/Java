package frame;

import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;


















import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Management extends JFrame implements ActionListener {
	JLabel label;
	JPanel management_cp;
	JLabel management_Label;
	JButton button;
	JButton button_2;
	ManagementRouteModel MR;
	ManagementRouteModel MS;
	Stopmodel ST;
	JScrollPane scrollPane;
	JScrollPane scrollPane_1;
	JScrollPane scrollPane_2;
	JScrollPane scrollPane_3;
	private JTextField textField_1;
	private JTextField textField_10;
	private JTable table;
	 JTable table_1;
	 JTable table_2;
	 JTable table_3;
	 static String index;
	private JTextField textField_11;
	String aa="(往";
	String bb="方向)";
	String oldvalue = null;
	String routeinformation =null;
	String start=null;
	String end =null;
	String [] information={"route","ORDINARY_FARE","AIR_CONDITIONED_FARE","start_stop",
			"first_start_stop_bus","last_start_stop_bus","end_stop","first_end_stop_bus",
			"last_end_stop_bus","down_route","up_route"};
	String [] information1={"index1","name","Longitude","Latitude"};

	public Management() {
		JFrame management = new JFrame("济南公交后台管理系统");
		management.getContentPane().setFont(new Font("宋体", Font.PLAIN, 14));
		management.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		management.setLocationRelativeTo(null);
		//management.setResizable(false);
		management_cp = (JPanel) management.getContentPane();
		management.getContentPane().setLayout(null);
		management.setExtendedState(Frame.MAXIMIZED_BOTH);
		ImageIcon searchicon = new ImageIcon(
				Login.class.getResource("/icon/145.jpg"));// 这是背景图片
		management_Label = new JLabel(searchicon);// 将背景图放在标签里。

		management.getLayeredPane().add(management_Label,
				new Integer(Integer.MIN_VALUE));// 注意这里是关键，将背景标签添加到jfram的LayeredPane面板里。
		management_Label.setBounds(0, 0, 1500, 800);// 设置背景标签的位置

		textField_1 = new JTextField();
		textField_1.setBounds(141, 72, 104, 30);
		textField_1.setColumns(10);

		JLabel label_11 = new JLabel("\u7EBF\u8DEF\u7BA1\u7406"); // 修改路线
		label_11.setFont(new Font("宋体", Font.BOLD, 16));
		label_11.setBounds(62, 186, 89, 15);
		management.getContentPane().add(label_11);

		JLabel label_12 = new JLabel("\u7AD9\u70B9\u7BA1\u7406"); // 站点管理
		label_12.setFont(new Font("宋体", Font.BOLD, 16));
		label_12.setBounds(62, 408, 89, 15);
		management.getContentPane().add(label_12);

		button = new JButton("\u4FDD\u5B58");          //线路管理中的保存
		button.setFont(new Font("宋体", Font.PLAIN, 14));
		button.setBounds(705, 585, 98, 23);
		button.addActionListener(new   ActionListener()   {     
			public   void   actionPerformed(ActionEvent   e)   {     
		    	SQLHelper SQL_5=new SQLHelper();
		 		SQL_5.getConnection();
		 		SQL_5.exesql("select * from Route");
		 		ResultSet rs = SQL_5.rs;

				try {
					while (rs.next()) {
						String a=rs.getString(2)+aa+rs.getString(8)+bb;
						String b=rs.getString(2)+aa+rs.getString(5)+bb;
						SQL_5.updatesql("exec InsertRoute '"+a+"','"+ rs.getString(11)+ "'");
						SQL_5.updatesql("exec InsertRoute '"+b+"','"+ rs.getString(12)+ "'");
						
					}
				} catch (SQLException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}   
			}     
			});     

		JPanel a = new JPanel();
		a.setBounds(180, 0, 977, 631);
		management.getContentPane().add(a);
		a.setLayout(null);
		a.add(button);

		a.setOpaque(false);

		JLabel label_10 = new JLabel(
				"\u8BF7\u8F93\u5165\u7EBF\u8DEF\u540D\uFF1A");
		label_10.setFont(new Font("宋体", Font.PLAIN, 14));
		label_10.setBounds(10, 33, 103, 15);
		a.add(label_10);

		textField_10 = new JTextField();
		textField_10.setBounds(123, 31, 153, 21);
		a.add(textField_10);
		textField_10.setColumns(10);
		textField_10.setOpaque(false);
		textField_10.setBorder(javax.swing.plaf.basic.BasicBorders
				.getMenuBarBorder());

		JButton button_1 = new JButton("\u5220\u9664");
		button_1.setFont(new Font("宋体", Font.PLAIN, 14));
		button_1.setBounds(173, 585, 93, 23);
		a.add(button_1);
		button_1.addActionListener(new   ActionListener()   {     
			public   void   actionPerformed(ActionEvent   e)   {     
			removeRow();     
			}     
			});     
		
		
		
		MR = new ManagementRouteModel();
		table_1 = new JTable(MR);
		table_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		table_1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF) ;
		for(int i=1;i<11;i++)
		table_1.getColumnModel().getColumn(i).setPreferredWidth(85);
		
		table_1.getColumnModel().getColumn(11).setPreferredWidth(2000);
		table_1.getColumnModel().getColumn(12).setPreferredWidth(2000);
	    TableCellRenderer renderer = new EvenOddRenderer(); 
	    table_1.setRowHeight(30);
	  
	   	table_1.setDefaultRenderer(Object.class,renderer);  
		table_1.getColumnModel().getColumn(0).setCellRenderer(new TableCellRenderer(){
					public Component getTableCellRendererComponent(
							JTable table, Object value, boolean isSelected,
							boolean hasFocus, int row, int column) {
						// 创建用于返回的渲染组件
						JCheckBox ck = new JCheckBox();
						// 使具有焦点的行对应的复选框选中
						ck.setSelected(isSelected);
						// 设置单选box.setSelected(hasFocus);
						// 使复选框在单元格内居中显示
						ck.setBackground(Color.white);
						ck.setHorizontalAlignment((int) 0.5f);
						return ck;
					}
				});
		
		
		table_1.getModel().addTableModelListener(new TableModelListener() {

			public void tableChanged(TableModelEvent e) {
				if (e.getType() == TableModelEvent.UPDATE) {
					/*
					 * do some thing 获得编辑后单元格的值
					 */

					String newvalue = table_1.getValueAt(e.getLastRow(),
							e.getColumn()).toString();
					
					if (!newvalue.equals(oldvalue)) {
						SQLHelper SQL_3 = new SQLHelper();
						SQL_3.getConnection();
						try{
						SQL_3.updatesql("update Route set "
								+ information[e.getColumn()-2] + "='" + newvalue
								+ "' where ID = " + (e.getLastRow()+1) + "");
						if (table_1.getSelectedColumn()==11&&oldvalue!=null)
						{
							String a=(routeinformation+aa+end+bb);
							SQL_3.updatesql("delete from stop_route where route ='"+a+"'");							
						}
						if (table_1.getSelectedColumn()==12&&oldvalue!=null)
					{
							String b=(routeinformation+aa+start+bb);
						SQL_3.updatesql("delete from stop_route where route ='"+b+"'");						
					}
						}catch(Exception e1){
							e1.printStackTrace();
						}

					}

				}

			}

		});
		table_1.addMouseListener(new MouseAdapter(){

	         public void mouseClicked(MouseEvent e){

	           //记录进入编辑状态前单元格得数据

	              oldvalue = table_1.getValueAt(table_1.getSelectedRow(),table_1.getSelectedColumn()).toString();
	              routeinformation=table_1.getValueAt(table_1.getSelectedRow(), 2).toString();
	              start=table_1.getValueAt(table_1.getSelectedRow(), 5).toString();
	              end=table_1.getValueAt(table_1.getSelectedRow(), 8).toString();

	             }     

	         });
		
		scrollPane_1 = new JScrollPane(table_1);
		scrollPane_1.setBounds(10, 62, 907, 502);
		a.add(scrollPane_1);
		scrollPane_1.getViewport().setBackground(getBackground().white);
		
		
		button_2 = new JButton("\u589E\u52A0");
		button_2.setFont(new Font("宋体", Font.PLAIN, 14));
		button_2.setBounds(445, 585, 93, 23);
		a.add(button_2);
		button_2.addActionListener(new   ActionListener()   {     
			public   void   actionPerformed(ActionEvent   e)   {     
				addRow();     
			}     
			});   
		
		JButton button_7 = new JButton("\u67E5 \u627E");
		button_7.setForeground(Color.BLACK);
		button_7.setFont(new Font("宋体", Font.PLAIN, 14));		
		button_7.setBounds(351, 29, 112, 23);
		a.add(button_7);
		
				
		
		button_7.addActionListener(new   ActionListener()   {     
			public   void   actionPerformed(ActionEvent   e)   {     
				MS=new ManagementRouteModel("select * from Route where route like '%"+textField_10.getText()+"%'");   
				scrollPane_1.setVisible(false);
				table_1.setVisible(false);
				table_2 = new JTable(MS);
				table_2.setBorder(new LineBorder(new Color(0, 0, 0)));
				table_2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF) ;
				for(int i=1;i<11;i++)
				table_2.getColumnModel().getColumn(i).setPreferredWidth(85);
				table_2.getColumnModel().getColumn(11).setPreferredWidth(2000);
				table_2.getColumnModel().getColumn(12).setPreferredWidth(2000);
			    TableCellRenderer renderer = new EvenOddRenderer();  
			    table_2.setDefaultRenderer(Object.class, renderer);  
			    table_2.setRowHeight(30);
			    
				table_2.getColumnModel().getColumn(0).setCellRenderer(new TableCellRenderer(){
							public Component getTableCellRendererComponent(
									JTable table, Object value, boolean isSelected,
									boolean hasFocus, int row, int column) {
								// 创建用于返回的渲染组件
								JCheckBox ck = new JCheckBox();
								// 使具有焦点的行对应的复选框选中
								ck.setSelected(isSelected);
								ck.setBackground(Color.white);
								
								// 设置单选box.setSelected(hasFocus);
								// 使复选框在单元格内居中显示
								ck.setHorizontalAlignment((int) 0.5f);
								return ck;
							}
						});
				
				
				table_2.getModel().addTableModelListener(new TableModelListener() {

					public void tableChanged(TableModelEvent e) {
						if (e.getType() == TableModelEvent.UPDATE) {
							String newvalue = table_2.getValueAt(e.getLastRow(),
									e.getColumn()).toString();

							if (!newvalue.equals(oldvalue)) {

								SQLHelper SQL_7 = new SQLHelper();
								SQL_7.getConnection();
								try{
								SQL_7.updatesql("update Route set "
										+ information[e.getColumn()-2] + "='" + newvalue
										+ "' where route = " + routeinformation + "");
							if (table_2.getSelectedColumn()==11&&oldvalue!=null)
								{
									SQL_7.updatesql("delete stop_route where route = '" + routeinformation+aa+end+bb + "'");
									
									
								}
							if (table_2.getSelectedColumn()==12&&oldvalue!=null)
							{
								SQL_7.updatesql("delete stop_route where route = '" + routeinformation+aa+start+bb + "'");
								
								
							}
								}catch(Exception e1){
									e1.printStackTrace();
								}

							}

						}

					}

				});
				table_2.addMouseListener(new MouseAdapter(){

			         public void mouseClicked(MouseEvent e){

			           //记录进入编辑状态前单元格得数据

			              oldvalue = table_2.getValueAt(table_2.getSelectedRow(),table_2.getSelectedColumn()).toString();
			              routeinformation=table_2.getValueAt(table_2.getSelectedRow(), 2).toString();
			              start=table_2.getValueAt(table_2.getSelectedRow(), 5).toString();
			              end=table_2.getValueAt(table_2.getSelectedRow(), 8).toString();

			             }     

			         });
				 
				
				scrollPane_2 = new JScrollPane(table_2);
				scrollPane_2.setBounds(10, 62, 907, 502);
				scrollPane_2.getViewport().setBackground(getBackground().white);
				a.add(scrollPane_2);
				table_2.updateUI(); 
			}     
			});   
		

		JPanel b = new JPanel();
		b.setLayout(null);
		b.setBounds(180, 0, 977, 631);
		management.getContentPane().add(b);

		JButton button_4 = new JButton("\u589E\u52A0");
		button_4.setBounds(692, 585, 93, 23);
		b.add(button_4);
		button_4.setFont(new Font("宋体", Font.PLAIN, 14));
		button_4.addActionListener(new   ActionListener()   {     
			public   void   actionPerformed(ActionEvent   e)   {     
				addRow1();     
			}     
			});
		
		
		ST = new Stopmodel();
		table = new JTable(ST);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
	//	table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF) ;
		
		
	   	table.setDefaultRenderer(Object.class,renderer);  
		table.getColumnModel().getColumn(0).setCellRenderer(new TableCellRenderer(){
					public Component getTableCellRendererComponent(
							JTable table, Object value, boolean isSelected,
							boolean hasFocus, int row, int column) {
						// 创建用于返回的渲染组件
						JCheckBox ck = new JCheckBox();
						// 使具有焦点的行对应的复选框选中
						ck.setSelected(isSelected);
						// 设置单选box.setSelected(hasFocus);
						// 使复选框在单元格内居中显示
						ck.setBackground(Color.white);
						ck.setHorizontalAlignment((int) 0.5f);
						return ck;
					}
				});
		
		
		table.getModel().addTableModelListener(new TableModelListener() {
			public void tableChanged(TableModelEvent e) {
				if (e.getType() == TableModelEvent.UPDATE) {
					/*
					 * do some thing 获得编辑后单元格的值
					 */
					String newvalue = table.getValueAt(e.getLastRow(),
							e.getColumn()).toString();
					if (!newvalue.equals(oldvalue)) {
						SQLHelper SQL_3 = new SQLHelper();
						SQL_3.getConnection();
						try{
						SQL_3.updatesql("update Stop set "
								+ information1[e.getColumn()-2] + "='" + newvalue
								+ "' where index1 = " + index + "");
						}catch(Exception e1){
							e1.printStackTrace();
						}
					}
				}
			}
		});
		table.addMouseListener(new MouseAdapter(){
	         public void mouseClicked(MouseEvent e){
	           //记录进入编辑状态前单元格得数据
	              oldvalue = table.getValueAt(table.getSelectedRow(),table.getSelectedColumn()).toString();	
	              index= table.getValueAt(table.getSelectedRow(), 1).toString();
	             }     
	         });
		
		
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(57, 164, 821, 394);
		b.add(scrollPane);
		scrollPane.getViewport().setBackground(getBackground().white);
		

		JButton btnNewButton = new JButton("\u67E5 \u8BE2");
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 14));
		btnNewButton.setBounds(378, 65, 106, 23);
		b.add(btnNewButton);
		btnNewButton.addActionListener(new   ActionListener()   {     
			public   void   actionPerformed(ActionEvent   e)   {     
				ST=new Stopmodel("select * from Stop where name like '%"+textField_11.getText()+"%'");   
				table_3 = new JTable(ST);
				table_3.setDefaultRenderer(Object.class,renderer);  
				table_3.getColumnModel().getColumn(0).setCellRenderer(new TableCellRenderer(){
							public Component getTableCellRendererComponent(
									JTable table, Object value, boolean isSelected,
									boolean hasFocus, int row, int column) {
								// 创建用于返回的渲染组件
								JCheckBox ck = new JCheckBox();
								// 使具有焦点的行对应的复选框选中
								ck.setSelected(isSelected);
								// 设置单选box.setSelected(hasFocus);
								// 使复选框在单元格内居中显示
								ck.setBackground(Color.white);
								ck.setHorizontalAlignment((int) 0.5f);
								return ck;
							}
						});
				scrollPane_3 = new JScrollPane(table_3);
				scrollPane_3.setBounds(57, 164, 600, 394);
				b.add(scrollPane_3);
				scrollPane.setVisible(false);
				scrollPane_3.getViewport().setBackground(getBackground().white);
				
			}
		});
		
		
		
		
		
		
		
		

		JLabel lblNewLabel_2 = new JLabel(
				"\u8BF7\u8F93\u5165\u7AD9\u540D\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(57, 71, 98, 15);
		b.add(lblNewLabel_2);

		textField_11 = new JTextField();
		textField_11.setBounds(165, 68, 174, 21);
		b.add(textField_11);
		textField_11.setColumns(10);
		textField_11.setOpaque(false);
		textField_11.setBorder(javax.swing.plaf.basic.BasicBorders
				.getMenuBarBorder());

		JLabel label_13 = new JLabel("\u67E5\u8BE2\u7ED3\u679C\uFF1A");
		label_13.setFont(new Font("宋体", Font.PLAIN, 14));
		label_13.setBounds(57, 123, 98, 15);
		b.add(label_13);

		JButton button_3 = new JButton("\u5220\u9664");
		button_3.setFont(new Font("宋体", Font.PLAIN, 14));
		button_3.setBounds(173, 585, 93, 23);
		b.add(button_3);
		b.setVisible(false);

		label_11.addMouseListener(new MouseListener() { // 线路管理
			public void mouseClicked(MouseEvent e) {
				// 处理鼠标点击
			}

			public void mouseEntered(MouseEvent e) {
				label_11.setCursor(Cursor
						.getPredefinedCursor(Cursor.HAND_CURSOR));

				// 处理鼠标移入
			}

			public void mouseExited(MouseEvent e) {
				// 处理鼠标离开
			}

			public void mousePressed(MouseEvent e) {
				a.setVisible(true);
				b.setVisible(false);
			
				// 处理鼠标按下
			}

			public void mouseReleased(MouseEvent e) {
			}
		});

		label_12.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				// 处理鼠标点击
			}

			public void mouseEntered(MouseEvent e) {
				label_12.setCursor(Cursor
						.getPredefinedCursor(Cursor.HAND_CURSOR));

				// 处理鼠标移入
			}

			public void mouseExited(MouseEvent e) {
				// 处理鼠标离开
			}

			public void mousePressed(MouseEvent e) {
				b.setVisible(true);
				a.setVisible(false);
			
				// 处理鼠标按下
			}

			public void mouseReleased(MouseEvent e) {
			}
		});
		b.setOpaque(false);
		
		
		
		button.addActionListener(this);

		((JPanel) management_cp).setOpaque(false); // 注意这里，将内容面板设为透明。这样LayeredPane面板中的背景才能显示出来。
//		management.setBounds(50, 40, 1200, 680);
		management.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button){
			try {
				insertroute();
			} catch (Exception e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}

	}

}
	private void removeRow(){
		if(table_1.isVisible()==true)
		MR.removeRow( table_1.getSelectedRow());
		table_1.updateUI();
		if(table_2!=null)
		table_2.updateUI();
	}
	
	private   void   addRow()   {     
		MR.addRow();
		if(table_1.isVisible()==true)
		table_1.updateUI();
		if(table_2!=null)
			table_2.updateUI();
		
		}   
	
	private   void   addRow1()   {     
		ST.addRow();
		if(table.isVisible()==true)
			table.updateUI();
			if(table_3!=null)
				table_3.updateUI();		
		}   
	
	private   void   removeRow1()   {     
		if(table.isVisible()==true)
			ST.removeRow( table.getSelectedRow());
			table.updateUI();
			if(table_3!=null)
			{	
				ST.removeRow( table.getSelectedRow());
				table_3.updateUI();
			}
		}     
	
	private   void   removeData()   {     
		MR.removeRows(0, MR.getRowCount());     
		table_1.updateUI();     
		}     
	
	
	void insertroute() throws Exception{
		SQLHelper d=new SQLHelper();
		d.getConnection();
		
	
	}
}