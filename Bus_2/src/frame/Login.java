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
		Login = new JFrame("���Ϲ�����ѯϵͳ");
		Login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Login.setLocationRelativeTo(null);
		ImageIcon loginimg = new ImageIcon(
				Login.class.getResource("/icon/1.jpg"));// ���Ǳ���ͼƬ
		JLabel loginimgLabel = new JLabel(loginimg);// ������ͼ���ڱ�ǩ�
//		Login.setResizable(false); 
		Login.getLayeredPane().add(loginimgLabel,
				new Integer(Integer.MIN_VALUE));// ע�������ǹؼ�����������ǩ��ӵ�jfram��LayeredPane����
		loginimgLabel.setBounds(0, 0, 1400, 750);// ���ñ�����ǩ��λ��
		JPanel logincp = (JPanel) Login.getContentPane();
		Login.getContentPane().setLayout(null);

		lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u7528\u6237\u540D");
		lblNewLabel.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setBounds(594, 217, 84, 40);
		Login.getContentPane().add(lblNewLabel);

		lblNewLabel_1 = new JLabel("\u8BF7\u8F93\u5165\u5BC6\u7801");
		lblNewLabel_1.setFont(new Font("΢���ź�", Font.PLAIN, 12));
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
		button.setFont(new Font("����", Font.BOLD, 18));
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
		label_1.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		label_1.setBounds(560, 367, 54, 15);
		Login.getContentPane().add(label_1);

		label_1.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				// ���������
			}

			public void mouseEntered(MouseEvent e) {
				label_1.setCursor(Cursor
						.getPredefinedCursor(Cursor.HAND_CURSOR));
				// �����������
			}

			public void mouseExited(MouseEvent e) {
				// ��������뿪
			}

			public void mousePressed(MouseEvent e) {
				frame2 = new Register();
				Login.setVisible(false);
				// ������갴��
			}

			public void mouseReleased(MouseEvent e) {
			}
		});

		textField.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				lblNewLabel.setVisible(false);
				// ���������
			}

			public void mouseEntered(MouseEvent e) {
				// �����������
			}

			public void mouseExited(MouseEvent e) {
				// ��������뿪
			}

			public void mousePressed(MouseEvent e) {
				lblNewLabel.setVisible(false);
				// ������갴��
			}

			public void mouseReleased(MouseEvent e) {
				// ��������ͷ�
			}
		});

		passwordField.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				lblNewLabel_1.setVisible(false);
				// ���������
			}

			public void mouseEntered(MouseEvent e) {
				// �����������
			}

			public void mouseExited(MouseEvent e) {
				// ��������뿪
			}

			public void mousePressed(MouseEvent e) {
				lblNewLabel_1.setVisible(false);
				// ������갴��
			}

			public void mouseReleased(MouseEvent e) {
				// ��������ͷ�
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
				// TODO �Զ����ɵ� catch ��
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
