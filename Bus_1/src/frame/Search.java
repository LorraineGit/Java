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
		JFrame search = new JFrame("���Ϲ�����ѯϵͳ");
		search.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		search.setLocationRelativeTo(null);
		ImageIcon searchicon = new ImageIcon(
				Login.class.getResource("/icon/151.jpg"));// ���Ǳ���ͼƬ
		searchLabel = new JLabel(searchicon);// ������ͼ���ڱ�ǩ�

		search.getLayeredPane()
				.add(searchLabel, new Integer(Integer.MIN_VALUE));// ע�������ǹؼ�����������ǩ��ӵ�jfram��LayeredPane����
		searchLabel.setBounds(0, 0, 1200, 700);// ���ñ�����ǩ��λ��

		searchcp = (JPanel) search.getContentPane();
		search.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\uFF1A");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 14));
		lblNewLabel.setBounds(242, 10, 61, 59); // ������

		radioButton = new JRadioButton("\u7EBF\u8DEF\u540D\u79F0"); // ��·����
		radioButton.setFont(new Font("����", Font.PLAIN, 14));
		radioButton.setBounds(342, 23, 85, 32);

		radioButton_1 = new JRadioButton("\u7AD9\u70B9\u540D\u79F0"); // ƴ������ĸ
		radioButton_1.setFont(new Font("����", Font.PLAIN, 14));
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

		button = new JButton("\u67E5\u8BE2"); // ����
		button.setFont(new Font("����", Font.PLAIN, 14));
		button.setBounds(966, 28, 93, 23);

		button.addActionListener(this);
		radioButton.addActionListener(this);
		radioButton_1.addActionListener(this);

		((JPanel) searchcp).setOpaque(false); // ע����������������Ϊ͸��������LayeredPane����еı���������ʾ������
		((JRadioButton) radioButton).setOpaque(false);
		((JRadioButton) radioButton_1).setOpaque(false);

		JLabel label_1 = new JLabel("\u67E5\u8BE2\u7ED3\u679C\uFF1A");
		label_1.setFont(new Font("����", Font.PLAIN, 14));
		label_1.setBounds(242, 102, 93, 15); // ��ѯ���

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
				"�����й�����ͨ�ܹ�˾����������һ�������ҵ����������������ഴҵ�����Ϸ�չ׳���ر��Ƕ�ʮ���;�ʮ�����������˾������ٷ�չ�Ĺ���������ܺ�װ��ˮƽ���õ��˴���ȵ���ߡ�"
						+ "�����й�����ͨ�ܹ�˾���蹫��һ��˾������˾������˾���糵��˾��������˾�Ϳ��ٹ�����˾����������ͨ��Ӫ��˾�����й��̹�˾����ҵ��˾�����ʹ�˾������˾��ְ��ҽԺ��ְ��ѧУ��ֱ����λ������ְ��15000���ˣ�����Ӫ�˳�6000��������С�ͳ�800������"
						+ "��Ҫ��Ӫ������Ͻ��������ͨ���ˡ��ͳ������ҵ��2012��8�£��ܹ�˾��Ӫ��·�ﵽ199�������е糵��·4����Kϵ�й�������·29����BRT���ٹ�����·6��������Ӫ��̴�3�ڹ���������ﵽ10�����˴Ρ����Ϲ����Է�������Ⱥ������ΪĿ�꣬�����Ż�����������"
						+ "�������ٺ���չ������·��Ŭ���������������ķ�չ�������չͬ���������о��ý��跢չͬ����������Ⱥ�ڲ��������ĳ�������ͬ���������ų��о��á�������Ӧ�еĹ��ܡ����Ϲ������ϼӴ�Ƽ�Ͷ�룬�����˹���IC��ϵͳ����Ӫ���ӵ���ϵͳ�������˹���������Ԥ���ͳ��ض�ý��ϵͳ��"
						+ "����˹�������Ч�ʺ�ָ�ӵ�����������Ŭ��Ϊ�˿ͳ˳��ṩ�����ͬʱ����ʱΪ�˿��ṩ�����������Ϣ�����Ϲ�����ִ�����չ��ɫ�����������Ƚ��Ƽ��͹���������ϸ��³��������û������������Ƴ����������ã���߳���װ�����ܣ�Ϊ�˿�Ӫ��һ����Ϊ��ȫ�����ʵĳ˳�������"
						+ "չ��δ�������Ϲ�����������������ڡ������Ի͡��ļ��飬��֡���ϵ�˿͡�����һ���������������ҵ����������Ӫ����ˮƽ�����ʷ���ˮƽ�������Ϲ������ɷ���淶�������ѧ��װ���Ƚ������������������Ĺ����������Ϲ�������չʾ�����Ĵ��ڲ��ø�����"
						+ "���Ϲ������š���ϵ�˿͡�����һ��������ּ�������ڷ���ˮƽ�����������Ͽ�չ�������ʷ��������칫�����ʷ���Ʒ�ƣ�Ŭ��Ϊ�˿�Ӫ����ܰ�����ʵĳ˳�������ӿ�ֳ������ԡ�ȫ�����������š�35·�ߺ�ȫ����ģ��ٻΪ��������㼯��͸��ˡ�"); // ��ҳ������
		Jtextarea.setFont(new Font("����", Font.PLAIN, 14));
		Jtextarea.setBounds(232, 75, 797, 520);
		search.getContentPane().add(Jtextarea);
		Jtextarea.setColumns(10);
		Jtextarea.setOpaque(false);
		Jtextarea.setLineWrap(true);

		JLabel label_2 = new JLabel("\u7EBF\u8DEF\u67E5\u8BE2"); // ��·��ѯ
		label_2.setFont(new Font("����", Font.BOLD, 15));
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
		label_5.setFont(new Font("����", Font.PLAIN, 14));
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
		label_6.setFont(new Font("����", Font.PLAIN, 14));
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
		button_1.setFont(new Font("����", Font.PLAIN, 14));
		button_1.addActionListener(new   ActionListener()   {     
			public   void   actionPerformed(ActionEvent   e)   {     
				addRow();     
			}     
			});

		JButton button_2 = new JButton("\u67E5\u8BE2");
		button_2.setFont(new Font("����", Font.PLAIN, 14));
		button_2.setBounds(1040, 98, 93, 23);
		e.add(button_2);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				if (textField_3.getText()!=null&&textField_4.getText()!=null)
				{
					InsertData();
				}
			/*	if(Huanchengmodel.f==false)
					text.setText("û�к���·�ߵ���Ŀ�ĵ�");
				
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
		label_7.setFont(new Font("����", Font.PLAIN, 14));
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
				// �������ڷ��ص���Ⱦ���
				JCheckBox ck = new JCheckBox();
				// ʹ���н�����ж�Ӧ�ĸ�ѡ��ѡ��
				ck.setSelected(isSelected);
				// ���õ�ѡbox.setSelected(hasFocus);
				// ʹ��ѡ���ڵ�Ԫ���ھ�����ʾ
				ck.setBackground(Color.white);
				ck.setHorizontalAlignment((int) 0.5f);
				return ck;
			}
		});


table_3.getModel().addTableModelListener(new TableModelListener() {

	public void tableChanged(TableModelEvent e) {
		if (e.getType() == TableModelEvent.UPDATE) {
			/*
			 * do some thing ��ñ༭��Ԫ���ֵ
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

       //��¼����༭״̬ǰ��Ԫ�������

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
		button_3.setFont(new Font("����", Font.PLAIN, 14));
		button_3.addActionListener(new   ActionListener()   {     
			public   void   actionPerformed(ActionEvent   e)   {     
			removeRow();     
			}     
			});     

	
		
		

		JLabel label_8 = new JLabel(
				"\u5386\u53F2\u67E5\u8BE2\u8BB0\u5F55\uFF1A");
		label_8.setFont(new Font("����", Font.PLAIN, 14));
		label_8.setBounds(252, 381, 129, 15);
		e.add(label_8);

		e.setOpaque(false);
		e.setVisible(false);

		label_2.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				// ���������
			}

			public void mouseEntered(MouseEvent e) {
				label_2.setCursor(Cursor
						.getPredefinedCursor(Cursor.HAND_CURSOR));
				// �����������
			}

			public void mouseExited(MouseEvent e) {
				// ��������뿪
			}

			public void mousePressed(MouseEvent el) {
				d.setVisible(true);
				Jtextarea.setVisible(false);
				e.setVisible(false);
				// ������갴��
			}

			public void mouseReleased(MouseEvent e) {
			}
		});

		JLabel label_3 = new JLabel("\u6362\u4E58\u67E5\u8BE2"); // ���˲�ѯ
		label_3.setFont(new Font("����", Font.BOLD, 15));
		label_3.setBounds(45, 477, 74, 15);
		search.getContentPane().add(label_3);

		label_3.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				// ���������
			}

			public void mouseEntered(MouseEvent e) {
				label_3.setCursor(Cursor
						.getPredefinedCursor(Cursor.HAND_CURSOR));

				// �����������
			}

			public void mouseExited(MouseEvent e) {
				// ��������뿪
			}

			public void mousePressed(MouseEvent el) {
				Jtextarea.setVisible(false);
				d.setVisible(false);
				e.setVisible(true);
				// ������갴��
			}

			public void mouseReleased(MouseEvent e) {
			}
		});

		label_4 = new JLabel("\u9996\u9875"); // ��ҳ
		label_4.setFont(new Font("����", Font.BOLD, 15));
		label_4.setBounds(45, 149, 74, 15);
		search.getContentPane().add(label_4);

		label_4.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				// ���������
			}

			public void mouseEntered(MouseEvent e) {
				label_4.setCursor(Cursor
						.getPredefinedCursor(Cursor.HAND_CURSOR));
				// �����������
			}

			public void mouseExited(MouseEvent e) {
				// ��������뿪
			}

			public void mousePressed(MouseEvent el) {
				Jtextarea.setVisible(true);
				d.setVisible(false);
				e.setVisible(false);
				// ������갴��
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
