package frame;

import java.awt.Frame;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Busmap {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		new Busmap();

	}
	
	public Busmap(){
		JFrame busmap = new JFrame("济南公交查询系统");
		busmap.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		busmap.setLocationRelativeTo(null);
//		ImageIcon loginimg = new ImageIcon(Busmap.class.getResource("/icon/1.jpg"));// 这是背景图片
//		JLabel loginimgLabel = new JLabel(loginimg);// 将背景图放在标签里。
//		Busmap.getLayeredPane().add(loginimgLabel,new Integer(Integer.MIN_VALUE));// 注意这里是关键，将背景标签添加到jfram的LayeredPane面板里。
//		loginimgLabel.setBounds(0, 0, 1400, 750);// 设置背景标签的位置
		JPanel logincp = (JPanel) busmap.getContentPane();
		busmap.getContentPane().setLayout(null);
		busmap.setExtendedState(Frame.MAXIMIZED_BOTH);
		busmap.setVisible(true);
	}

}
