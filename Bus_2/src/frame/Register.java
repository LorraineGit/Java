package frame;

import java.util.*;
import java.sql.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Register extends JFrame implements ActionListener {
	static String p = "user";
	JButton button_2;
	JFrame register;
	JLabel registerLabel;
	JPanel re;
	JLabel label_1;
	JLabel label_2;
	JLabel label;
	Login frame6;
	private static JTextField textField_1;
	private static JPasswordField passwordField_1;
	private JPasswordField passwordField;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_8;
	private JLabel label_10;
	private JLabel label_11;
	private JLabel label_12;
	private JLabel label_13;
	private JLabel label_14;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	boolean a = false;
	boolean b1=false;
	boolean b2=false;


	public Register() {
		register = new JFrame("新用户注册");
		register.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		register.setResizable(false);
		register.setExtendedState(Frame.MAXIMIZED_BOTH);
//		register.setBounds(50, 40, 1200, 680);
		ImageIcon icon = new ImageIcon(
				Register.class.getResource("/icon/2.jpg"));// 这是背景图片
		registerLabel = new JLabel(icon);// 将背景图放在标签里。

		register.getLayeredPane().add(registerLabel,
				new Integer(Integer.MIN_VALUE));// 注意这里是关键，将背景标签添加到jfram的LayeredPane面板里。
		registerLabel.setBounds(0, 0, 1400, 750);// 设置背景标签的位置
		re = (JPanel) register.getContentPane();
		register.getContentPane().setLayout(null);

		label = new JLabel("\u7528\u6237\u540D\uFF1A");
		label.setFont(new Font("微软雅黑", Font.BOLD, 14));
		label.setBounds(537, 214, 79, 15);
		register.getContentPane().add(label);

		label_1 = new JLabel("\u5BC6\u7801\uFF1A");
		label_1.setFont(new Font("微软雅黑", Font.BOLD, 14));
		label_1.setBounds(537, 289, 54, 15);
		register.getContentPane().add(label_1);

		textField_1 = new JTextField();
		textField_1.setBounds(609, 209, 207, 26);
		register.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		textField_1.setOpaque(false);
		textField_1.setBorder(javax.swing.plaf.basic.BasicBorders
				.getMenuBarBorder());

		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(610, 284, 207, 26);
		register.getContentPane().add(passwordField_1);
		passwordField_1.setOpaque(false);
		passwordField_1.setBorder(javax.swing.plaf.basic.BasicBorders
				.getMenuBarBorder());

		button_2 = new JButton("\u6CE8 \u518C");
		button_2.setBackground(new Color(51, 153, 102));
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("宋体", Font.BOLD, 18));
		button_2.setBounds(537, 427, 352, 38);
		register.getContentPane().add(button_2);

		label_2 = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A");
		label_2.setFont(new Font("微软雅黑", Font.BOLD, 14));
		label_2.setBounds(537, 358, 79, 15);
		register.getContentPane().add(label_2);

		passwordField = new JPasswordField();
		passwordField.setBounds(609, 353, 207, 26);
		register.getContentPane().add(passwordField);
		passwordField.setOpaque(false);
		passwordField.setBorder(javax.swing.plaf.basic.BasicBorders
				.getMenuBarBorder());

		label_3 = new JLabel(
				"\u8BF7\u8F93\u5165\u957F\u5EA6\u4E3A5~16\u4F4D\u7684\u5B57\u6BCD\u6216\u6570\u5B57");
		label_3.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		label_3.setForeground(Color.LIGHT_GRAY);
		label_3.setBounds(609, 246, 280, 15);
		register.getContentPane().add(label_3);

		label_4 = new JLabel(
				"\u8BF7\u8F93\u5165\u957F\u5EA66~14\u4F4D\u7684\u5B57\u6BCD\u6216\u6570\u5B57");
		label_4.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		label_4.setForeground(Color.LIGHT_GRAY);
		label_4.setBounds(609, 328, 245, 15);
		register.getContentPane().add(label_4);

		label_5 = new JLabel("\u8BF7\u518D\u6B21\u8F93\u5165\u5BC6\u7801");
		label_5.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		label_5.setForeground(Color.LIGHT_GRAY);
		label_5.setBounds(609, 384, 126, 26);
		register.getContentPane().add(label_5);

		label_6 = new JLabel("*");
		label_6.setForeground(Color.RED);
		label_6.setBounds(517, 209, 27, 15);
		register.getContentPane().add(label_6);

		label_7 = new JLabel("*");
		label_7.setForeground(Color.RED);
		label_7.setBounds(517, 284, 54, 15);
		register.getContentPane().add(label_7);

		label_8 = new JLabel("*");
		label_8.setForeground(Color.RED);
		label_8.setBounds(517, 353, 54, 15);
		register.getContentPane().add(label_8);

		label_10 = new JLabel("\u7528\u6237\u540D\u91CD\u590D"); // 用户名重复
		label_10.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		label_10.setForeground(Color.RED);
		label_10.setBounds(820, 215, 103, 15);
		register.getContentPane().add(label_10);
		label_10.setVisible(false);

		label_11 = new JLabel("\u2714"); // 密码的对号
		label_11.setForeground(new Color(51, 153, 102));
		label_11.setBounds(820, 290, 54, 15);
		register.getContentPane().add(label_11);
		label_11.setVisible(false);

		lblNewLabel = new JLabel("\u2714"); // 确认密码的对号
		lblNewLabel.setForeground(new Color(51, 153, 102));
		lblNewLabel.setBounds(826, 358, 34, 15);
		register.getContentPane().add(lblNewLabel);
		lblNewLabel.setVisible(false);

		label_12 = new JLabel("\u5BC6\u7801\u683C\u5F0F\u4E0D\u6B63\u786E"); // 密码格式不正确
		label_12.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		label_12.setForeground(Color.RED);
		label_12.setBounds(820, 290, 103, 15);
		register.getContentPane().add(label_12);
		label_12.setVisible(false);

		label_13 = new JLabel(
				"\u4E24\u6B21\u8F93\u5165\u5BC6\u7801\u4E0D\u4E00\u81F4"); // 两次输入密码不一致
		label_13.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		label_13.setForeground(Color.RED);
		label_13.setBounds(820, 359, 126, 15);
		register.getContentPane().add(label_13);
		label_13.setVisible(false);

		label_14 = new JLabel(
				"\u7528\u6237\u540D\u683C\u5F0F\u4E0D\u6B63\u786E"); // 用户名格式不正确
		label_14.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		label_14.setForeground(Color.RED);
		label_14.setBounds(826, 214, 126, 15);
		register.getContentPane().add(label_14);
		label_14.setVisible(false);

		lblNewLabel_1 = new JLabel("\u2714"); // 用户名的对号
		lblNewLabel_1.setForeground(new Color(51, 153, 102));
		lblNewLabel_1.setBounds(826, 215, 54, 15);
		register.getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.setVisible(false);

		button_2.addActionListener(this);
		// textField_1.addActionListener(this);
		// passwordField_1.addActionListener(this);
		// passwordField.addActionListener(this);

		textField_1.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {

			}
		});

		passwordField.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {

			}
		});

		passwordField_1.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {

			}
		});

		((JPanel) re).setOpaque(false); // 注意这里，将内容面板设为透明。这样LayeredPane面板中的背景才能显示出来。

		register.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		try {
			checkregister();
		} catch (Exception e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
	}

	private void checkregister() throws Exception {
		String name = textField_1.getText();
		String po=new String(passwordField_1.getPassword());
		if(name.length()<5||name.length()>16)
			label_14.setVisible(true);
		else{
			lblNewLabel_1.setVisible(true);
			b1=true;}
		if(po.length()<6||po.length()>14)
			label_12.setVisible(true);
		else{
			label_11.setVisible(true);
			b2=true;}
		if(b1==true&&b2==true){
		SQLHelper b = new SQLHelper();
		b.getConnection();
		b.exesql("select user_id  from user_ where user_id = '" + name + "'");
		ResultSet rs = b.rs;
		while (rs.next()) {
			label_10.setVisible(true);
			a = true;
		}

		if (a == false)
			lblNewLabel_1.setVisible(true);
		
		
		if ((new String(passwordField.getPassword())).equals((new String(
				passwordField_1.getPassword())))) {
			b.updatesql("insert into user_ VALUES('" +name+ "','"
					+ po+ "','" + p
					+ "')");

			register.setVisible(false);
			frame6=new Login();
		} else {
			label_13.setVisible(true);
		}

	}
	}
	// String validateStr ="^[a-z,A-Z]\W{6,16}&";

}