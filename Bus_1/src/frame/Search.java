package frame;

import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.border.LineBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

public class Search extends JFrame implements ActionListener {
	private JTextField textField;
	JLabel label;
	JPanel searchcp;
	JLabel searchLabel;
	JButton button;
	JRadioButton radioButton;
	JRadioButton radioButton_1;
	ButtonGroup group;
	JTable table_1;
	JTable table_2;
	JTable table_3 ;
	JTable table_4;
	JScrollPane scrollpane;
	JScrollPane scrollpane_1;
	JScrollPane scrollpane_2;
	JScrollPane scrollPane_1;
	JScrollPane scrollPane_3;
	JPanel d;
	JPanel e;
	JTextArea text;
	jilumodel jilu;
	private JTextField textField_1;
	private JTable table;
	private JLabel label_4;
	private JTextField textField_2;
	public static JTextField textField_3;
	public static JTextField textField_4;
	Boolean a=false;
	Boolean b=false;
	String oldvalue = null;
	String information[]={"search_start","search_end"};
	public static String startstop;
	public static String endstop;

	public Search() {
		JFrame search = new JFrame("济南公交查询系统");
		search.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		search.setLocationRelativeTo(null);
		ImageIcon searchicon = new ImageIcon(
				Login.class.getResource("/icon/151.jpg"));// 这是背景图片
		searchLabel = new JLabel(searchicon);// 将背景图放在标签里。

		search.getLayeredPane()
				.add(searchLabel, new Integer(Integer.MIN_VALUE));// 注意这里是关键，将背景标签添加到jfram的LayeredPane面板里。
		searchLabel.setBounds(0, 0, 1200, 700);// 设置背景标签的位置

		searchcp = (JPanel) search.getContentPane();
		search.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel.setBounds(242, 10, 61, 59); // 请输入

		radioButton = new JRadioButton("\u7EBF\u8DEF\u540D\u79F0"); // 线路名称
		radioButton.setFont(new Font("宋体", Font.PLAIN, 14));
		radioButton.setBounds(342, 23, 85, 32);

		radioButton_1 = new JRadioButton("\u7AD9\u70B9\u540D\u79F0"); // 拼音首字母
		radioButton_1.setFont(new Font("宋体", Font.PLAIN, 14));
		radioButton_1.setBounds(476, 14, 104, 50);

		group = new ButtonGroup();
		group.add(radioButton_1);
		group.add(radioButton);

		textField_1 = new JTextField();
		textField_1.setBounds(639, 19, 182, 41);
		textField_1.setColumns(10);
		textField_1.setOpaque(false);
		textField_1.setBorder(javax.swing.plaf.basic.BasicBorders
				.getMenuBarBorder());

		button = new JButton("\u67E5\u8BE2"); // 查找
		button.setFont(new Font("宋体", Font.PLAIN, 14));
		button.setBounds(966, 28, 93, 23);

		button.addActionListener(this);
		radioButton.addActionListener(this);
		radioButton_1.addActionListener(this);

		((JPanel) searchcp).setOpaque(false); // 注意这里，将内容面板设为透明。这样LayeredPane面板中的背景才能显示出来。
		((JRadioButton) radioButton).setOpaque(false);
		((JRadioButton) radioButton_1).setOpaque(false);

		JLabel label_1 = new JLabel("\u67E5\u8BE2\u7ED3\u679C\uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 14));
		label_1.setBounds(242, 102, 93, 15); // 查询结果

		SearchRouteModel a = new SearchRouteModel();
		table = new JTable(a);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		for(int i=0;i<8;i++)
		table.getColumnModel().getColumn(i).setPreferredWidth(85);
		table.getColumnModel().getColumn(9).setPreferredWidth(1800);
		table.getColumnModel().getColumn(10).setPreferredWidth(1800);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF) ;
		scrollpane = new JScrollPane(table);
		scrollpane.setBounds(242, 133, 891, 462);
		scrollpane.getViewport().setBackground(getBackground().white);

		JTextArea Jtextarea = new JTextArea(
				"济南市公共交通总公司是市属国有一类大型企业，多年来，经过艰苦创业，不断发展壮大，特别是二十世纪九十年代以来，公司步入高速发展的轨道，服务功能和装备水平都得到了大幅度的提高。"
						+ "济南市公共交通总公司下设公交一公司、二公司、三公司、电车公司、恒生公司和快速公交公司六个公共交通运营公司，还有工程公司、物业公司、物资公司、服务公司、职工医院和职工学校等直属单位。现有职工15000余人，公交营运车6000辆，出租小客车800余辆。"
						+ "主要经营济南市辖区公共交通客运、客车出租等业务。2012年8月，总公司运营线路达到199条，其中电车线路4条，K系列公交车线路29条，BRT快速公交线路6条。年运营里程达3亿公里，客运量达到10亿余人次。济南公交以方便人民群众生活为目标，不断优化公交线网，"
						+ "积极开辟和拓展公交线路，努力做到公交线网的发展与城区拓展同步，与我市经济建设发展同步，与人民群众不断增长的出行需求同步，发挥着城市经济“动脉”应有的功能。济南公交不断加大科技投入，建设了公交IC卡系统和运营电子调度系统，建设了公交车来车预报和车载多媒体系统，"
						+ "提高了公交运行效率和指挥调度能力，在努力为乘客乘车提供方便的同时，及时为乘客提供各项公交服务信息。济南公交坚持大力发展绿色公交，引进先进科技和管理理念，不断更新车辆，购置环保车辆，改善车辆技术配置，提高车辆装备性能，为乘客营造一个更为安全和舒适的乘车环境。"
						+ "展望未来，济南公交人满怀“服务大众、更创辉煌”的激情，坚持“心系乘客、服务一流”的理念，提升企业竞争力、经营管理水平和优质服务水平，将济南公交建成服务规范、管理科学、装备先进、机制灵活、充满活力的公交，将济南公交这面展示文明的窗口擦得更亮。"
						+ "济南公交本着“心系乘客、服务一流”的宗旨，致力于服务水平的提升，不断开展各类优质服务活动，打造公交优质服务品牌，努力为乘客营造温馨、舒适的乘车环境，涌现出大量以“全国青年文明号”35路线和全国劳模吴倩为代表的优秀集体和个人。"); // 首页的内容
		Jtextarea.setFont(new Font("宋体", Font.PLAIN, 14));
		Jtextarea.setBounds(232, 75, 797, 520);
		search.getContentPane().add(Jtextarea);
		Jtextarea.setColumns(10);
		Jtextarea.setOpaque(false);
		Jtextarea.setLineWrap(true);

		JLabel label_2 = new JLabel("\u7EBF\u8DEF\u67E5\u8BE2"); // 线路查询
		label_2.setFont(new Font("宋体", Font.BOLD, 15));
		label_2.setBounds(45, 313, 93, 15);
		search.getContentPane().add(label_2);

		d = new JPanel();
		d.setBounds(0, 0, 1184, 641);
		search.getContentPane().add(d);
		d.setLayout(null);
		d.add(lblNewLabel);
		d.add(label_1);
		d.add(button);
		d.add(textField_1);
		d.add(radioButton_1);
		d.add(radioButton);
		d.add(scrollpane);
		d.setOpaque(false);
		
		
		
				

		d.setVisible(false);

		e = new JPanel();
		e.setBounds(0, 0, 1184, 641);
		search.getContentPane().add(e);
		e.setLayout(null);

		JLabel label_5 = new JLabel("\u51FA\u53D1\u5730\uFF1A");
		label_5.setFont(new Font("宋体", Font.PLAIN, 14));
		label_5.setForeground(Color.BLACK);
		label_5.setBounds(252, 98, 83, 23);
		e.add(label_5);

		textField_3 = new JTextField();
		textField_3.setBounds(349, 90, 182, 41);
		e.add(textField_3);
		textField_3.setColumns(10);
		textField_3.setOpaque(false);
		textField_3.setBorder(javax.swing.plaf.basic.BasicBorders
				.getMenuBarBorder());

		JLabel label_6 = new JLabel("\u76EE\u7684\u5730\uFF1A");
		label_6.setFont(new Font("宋体", Font.PLAIN, 14));
		label_6.setBounds(639, 102, 85, 15);
		e.add(label_6);

		textField_4 = new JTextField();
		textField_4.setBounds(773, 90, 182, 41);
		e.add(textField_4);
		textField_4.setColumns(10);
		textField_4.setOpaque(false);
		textField_4.setBorder(javax.swing.plaf.basic.BasicBorders
				.getMenuBarBorder());
		
		JButton button_1 = new JButton("\u589E\u52A0");
		button_1.setBounds(888, 605, 93, 23);
		e.add(button_1);
		button_1.setFont(new Font("宋体", Font.PLAIN, 14));
		button_1.addActionListener(new   ActionListener()   {     
			public   void   actionPerformed(ActionEvent   e)   {     
				addRow();     
			}     
			});

		JButton button_2 = new JButton("\u67E5\u8BE2");
		button_2.setFont(new Font("宋体", Font.PLAIN, 14));
		button_2.setBounds(1040, 98, 93, 23);
		e.add(button_2);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				if (textField_3.getText()!=null&&textField_4.getText()!=null)
				{
					InsertData();
				}
			/*	if(Huanchengmodel.f==false)
					text.setText("没有合适路线到达目的地");
				
				else{*/
				Huanchengmodel HC=new Huanchengmodel();
				table_4 = new JTable(HC);
				table_4.setBorder(new LineBorder(new Color(0, 0, 0)));
				table_4.setRowHeight(30);
				scrollPane_3 = new JScrollPane(table_4);
				scrollPane_3.setBounds(252, 197, 881, 164);
				scrollPane_3.getViewport().setBackground(getBackground().white);
				e.add(scrollPane_3);
				text.setVisible(false);
				table_4.updateUI();
				
			}
		});

		JLabel label_7 = new JLabel("\u67E5\u8BE2\u7ED3\u679C\uFF1A");
		label_7.setFont(new Font("宋体", Font.PLAIN, 14));
		label_7.setBounds(252, 149, 93, 23);
		e.add(label_7);

		text=new JTextArea();
		text.setBounds(252, 197, 881, 164);
		e.add(text);
		
		jilu= new jilumodel();
		table_3 = new JTable(jilu);
		table_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		table_3.setRowHeight(25);
		TableCellRenderer renderer = new EvenOddRenderer(); 
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


table_3.getModel().addTableModelListener(new TableModelListener() {

	public void tableChanged(TableModelEvent e) {
		if (e.getType() == TableModelEvent.UPDATE) {
			/*
			 * do some thing 获得编辑后单元格的值
			 */

			String newvalue = table_3.getValueAt(e.getLastRow(),
					e.getColumn()).toString();

			if (!newvalue.equals(oldvalue)) {
				

				SQLHelper SQL_3 = new SQLHelper();
				SQL_3.getConnection();
				try{
				SQL_3.updatesql("update user_search set "
						+ information[e.getColumn()-1] + "='" + newvalue
						+ "' where user_id ='"+Login.textField.getText()+"' and search_start='"+Search.startstop+"' and search_end = '"+Search.endstop+"'");
				
			
				}catch(Exception e1){
					e1.printStackTrace();
				}

			}

		}

	}

});
table_3.addMouseListener(new MouseAdapter(){

     public void mouseClicked(MouseEvent e){

       //记录进入编辑状态前单元格得数据

          oldvalue = table_3.getValueAt(table_3.getSelectedRow(),table_3.getSelectedColumn()).toString();
          startstop=table_3.getValueAt(table_3.getSelectedRow(),1).toString();
          endstop=table_3.getValueAt(table_3.getSelectedRow(),2).toString();

         }     

     });
		JScrollPane scrollPane_2 = new JScrollPane(table_3);
		scrollPane_2.setBounds(252, 420, 881, 164);
		e.add(scrollPane_2);
		scrollPane_2.getViewport().setBackground(getBackground().white);
		
		
		JButton button_3 = new JButton("\u5220\u9664");
		button_3.setBounds(342, 605, 93, 23);
		e.add(button_3);
		button_3.setFont(new Font("宋体", Font.PLAIN, 14));
		button_3.addActionListener(new   ActionListener()   {     
			public   void   actionPerformed(ActionEvent   e)   {     
			removeRow();     
			}     
			});     

	
		
		

		JLabel label_8 = new JLabel(
				"\u5386\u53F2\u67E5\u8BE2\u8BB0\u5F55\uFF1A");
		label_8.setFont(new Font("宋体", Font.PLAIN, 14));
		label_8.setBounds(252, 381, 129, 15);
		e.add(label_8);

		e.setOpaque(false);
		e.setVisible(false);

		label_2.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				// 处理鼠标点击
			}

			public void mouseEntered(MouseEvent e) {
				label_2.setCursor(Cursor
						.getPredefinedCursor(Cursor.HAND_CURSOR));
				// 处理鼠标移入
			}

			public void mouseExited(MouseEvent e) {
				// 处理鼠标离开
			}

			public void mousePressed(MouseEvent el) {
				d.setVisible(true);
				Jtextarea.setVisible(false);
				e.setVisible(false);
				// 处理鼠标按下
			}

			public void mouseReleased(MouseEvent e) {
			}
		});

		JLabel label_3 = new JLabel("\u6362\u4E58\u67E5\u8BE2"); // 换乘查询
		label_3.setFont(new Font("宋体", Font.BOLD, 15));
		label_3.setBounds(45, 477, 74, 15);
		search.getContentPane().add(label_3);

		label_3.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				// 处理鼠标点击
			}

			public void mouseEntered(MouseEvent e) {
				label_3.setCursor(Cursor
						.getPredefinedCursor(Cursor.HAND_CURSOR));

				// 处理鼠标移入
			}

			public void mouseExited(MouseEvent e) {
				// 处理鼠标离开
			}

			public void mousePressed(MouseEvent el) {
				Jtextarea.setVisible(false);
				d.setVisible(false);
				e.setVisible(true);
				// 处理鼠标按下
			}

			public void mouseReleased(MouseEvent e) {
			}
		});

		label_4 = new JLabel("\u9996\u9875"); // 首页
		label_4.setFont(new Font("宋体", Font.BOLD, 15));
		label_4.setBounds(45, 149, 74, 15);
		search.getContentPane().add(label_4);

		label_4.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				// 处理鼠标点击
			}

			public void mouseEntered(MouseEvent e) {
				label_4.setCursor(Cursor
						.getPredefinedCursor(Cursor.HAND_CURSOR));
				// 处理鼠标移入
			}

			public void mouseExited(MouseEvent e) {
				// 处理鼠标离开
			}

			public void mousePressed(MouseEvent el) {
				Jtextarea.setVisible(true);
				d.setVisible(false);
				e.setVisible(false);
				// 处理鼠标按下
			}

			public void mouseReleased(MouseEvent e) {
			}
		});

		search.setBounds(50, 40, 1200, 680);
		search.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == radioButton)
		{
			a=true;
			b=false;
			
		}
			
		if (e.getSource() == radioButton_1)
		{
			b=true;
			a=false;
			
		}
		if (e.getSource() == button&&a==true) {
			String b = textField_1.getText();
			SearchRouteModel c = new SearchRouteModel("select * from Route where route like '%"+b+"%'");
			
			table_1 = new JTable(c);
			table_1.setBorder(new LineBorder(new Color(0, 0, 0)));
			for(int i=0;i<8;i++)
				table_1.getColumnModel().getColumn(i).setPreferredWidth(85);
			table_1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF) ;
			table_1.getColumnModel().getColumn(9).setPreferredWidth(1800);
			table_1.getColumnModel().getColumn(10).setPreferredWidth(1800);
			scrollpane_1 = new JScrollPane(table_1);
			scrollpane_1.setBounds(242, 133, 891, 462);
			scrollpane_1.getViewport().setBackground(getBackground().white);
			scrollpane.setVisible(false);
			d.add(scrollpane_1);
			scrollpane_1.setVisible(true);
			table_1.updateUI();
		}
		
		if (e.getSource() == button&&b==true) {
			String b = textField_1.getText();
			SearchRouteModel f = new SearchRouteModel("select * from Route where route in (select substring(route,0,charindex('(',route))  from stop_route where stop='"+ textField_1.getText()+"')");

			table_2 = new JTable(f);
			table_2.setBorder(new LineBorder(new Color(0, 0, 0)));
			for(int i=0;i<8;i++)
				table_2.getColumnModel().getColumn(i).setPreferredWidth(85);
			table_2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF) ;
			table_2.getColumnModel().getColumn(9).setPreferredWidth(1800);
			table_2.getColumnModel().getColumn(10).setPreferredWidth(1800);
			scrollpane_2 = new JScrollPane(table_2);
			scrollpane_2.setBounds(242, 133, 891, 462);
			scrollpane_2.getViewport().setBackground(getBackground().white);
			scrollpane.setVisible(false);
			d.add(scrollpane_2);
			scrollpane_2.setVisible(true);
			table_2.updateUI();
		}
	}
	private void removeRow(){
		jilu.removeRow( table_3.getSelectedRow());
		table_3.updateUI();
		
	}
	
	private void InsertData(){
		jilu.InsertData();
		table_3.updateUI();
		
	}
	private   void   addRow()   {     
		jilu.addRow();
		table_3.updateUI();
		
		
		}     
}
