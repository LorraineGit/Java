package frame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Login extends JFrame implements ActionListener {
	public static JTextField textField;
	JPasswordField passwordField;
	JLabel lblNewLabel;
	JLabel lblNewLabel_1;
	JFrame Login;
	JButton button;
	Register frame2;
	Search frame3;
	JLabel label_1;
	Management frame5;
	public boolean flag = false;
	public JLabel label;

	public static void main(String[] args) {
		new Login();

	}

	public Login() {
		Login = new JFrame("济南公交查询系统");
		Login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Login.setLocationRelativeTo(null);
		ImageIcon loginimg = new ImageIcon(
				Login.class.getResource("/icon/1.jpg"));// 这是背景图片
		JLabel loginimgLabel = new JLabel(loginimg);// 将背景图放在标签里。
//		Login.setResizable(false); 
		Login.getLayeredPane().add(loginimgLabel,
				new Integer(Integer.MIN_VALUE));// 注意这里是关键，将背景标签添加到jfram的LayeredPane面板里。
		loginimgLabel.setBounds(0, 0, 1400, 750);// 设置背景标签的位置
		JPanel logincp = (JPanel) Login.getContentPane();
		Login.getContentPane().setLayout(null);

		lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u7528\u6237\u540D");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setBounds(594, 217, 84, 40);
		Login.getContentPane().add(lblNewLabel);

		lblNewLabel_1 = new JLabel("\u8BF7\u8F93\u5165\u5BC6\u7801");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		lblNewLabel_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1.setBounds(594, 294, 105, 40);
		Login.getContentPane().add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBounds(580, 217, 290, 45);
		Login.getContentPane().add(textField);
		textField.setColumns(10);
		textField.setOpaque(false);
		textField.setBorder(javax.swing.plaf.basic.BasicBorders
				.getMenuBarBorder());

		passwordField = new JPasswordField();
		passwordField.setBounds(580, 294, 290, 45);
		Login.getContentPane().add(passwordField);
		passwordField.setOpaque(false);
		passwordField.setBorder(javax.swing.plaf.basic.BasicBorders
				.getMenuBarBorder());

		button = new JButton("\u767B \u5F55");
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(51, 153, 102));
		button.setFont(new Font("宋体", Font.BOLD, 18));
		button.setBounds(536, 400, 334, 43);
		Login.getContentPane().add(button);

		label = new JLabel(
				"\u7528\u6237\u540D\u6216\u5BC6\u7801\u9519\u8BEF\uFF01");
		label.setForeground(Color.RED);
		label.setBounds(638, 469, 213, 15);
		Login.getContentPane().add(label);
		label.setVisible(false);

		label_1 = new JLabel("\u6CE8\u518C\u8D26\u53F7");
		label_1.setForeground(new Color(51, 153, 102));
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		label_1.setBounds(560, 367, 54, 15);
		Login.getContentPane().add(label_1);

		label_1.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				// 处理鼠标点击
			}

			public void mouseEntered(MouseEvent e) {
				label_1.setCursor(Cursor
						.getPredefinedCursor(Cursor.HAND_CURSOR));
				// 处理鼠标移入
			}

			public void mouseExited(MouseEvent e) {
				// 处理鼠标离开
			}

			public void mousePressed(MouseEvent e) {
				frame2 = new Register();
				Login.setVisible(false);
				// 处理鼠标按下
			}

			public void mouseReleased(MouseEvent e) {
			}
		});

		textField.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				lblNewLabel.setVisible(false);
				// 处理鼠标点击
			}

			public void mouseEntered(MouseEvent e) {
				// 处理鼠标移入
			}

			public void mouseExited(MouseEvent e) {
				// 处理鼠标离开
			}

			public void mousePressed(MouseEvent e) {
				lblNewLabel.setVisible(false);
				// 处理鼠标按下
			}

			public void mouseReleased(MouseEvent e) {
				// 处理鼠标释放
			}
		});

		passwordField.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				lblNewLabel_1.setVisible(false);
				// 处理鼠标点击
			}

			public void mouseEntered(MouseEvent e) {
				// 处理鼠标移入
			}

			public void mouseExited(MouseEvent e) {
				// 处理鼠标离开
			}

			public void mousePressed(MouseEvent e) {
				lblNewLabel_1.setVisible(false);
				// 处理鼠标按下
			}

			public void mouseReleased(MouseEvent e) {
				// 处理鼠标释放
			}
		});

		button.addActionListener(this);

		((JPanel) logincp).setOpaque(false);
		Login.setExtendedState(Frame.MAXIMIZED_BOTH);
	//	Login.setBounds(0, 0, 1480, 750);
		Login.setVisible(true);

	}

	public void actionPerformed(ActionEvent arg0) {

		if (arg0.getSource() == button) {
			try {
				checkuser();
			} catch (Exception e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
		}
	}

	void checkuser() throws Exception {
		SQLHelper a=new SQLHelper();
		a.getConnection();
		a.exesql("select * from user_ ");
		ResultSet rs=a.rs;
			while (rs.next()) {
				if (textField.getText().equals(rs.getString(1))
						&& (new String(passwordField.getPassword()).equals(rs
								.getString(2)))) {
					flag = true;
					label.setVisible(false);
					if (rs.getString(3).equals("user")) {
						frame3 = new Search();
						Login.setVisible(false);
					}
					if (rs.getString(3).equals("admini")) {
						//frame4 = new Management();
						frame5=new Management();
						Login.setVisible(false);
					}
				}
				if (flag == false)

					label.setVisible(true);
			}

		} 
	

}
