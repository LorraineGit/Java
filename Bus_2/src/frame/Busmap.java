package frame;

import java.awt.Frame;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Busmap {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		new Busmap();

	}
	
	public Busmap(){
		JFrame busmap = new JFrame("���Ϲ�����ѯϵͳ");
		busmap.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		busmap.setLocationRelativeTo(null);
//		ImageIcon loginimg = new ImageIcon(Busmap.class.getResource("/icon/1.jpg"));// ���Ǳ���ͼƬ
//		JLabel loginimgLabel = new JLabel(loginimg);// ������ͼ���ڱ�ǩ�
//		Busmap.getLayeredPane().add(loginimgLabel,new Integer(Integer.MIN_VALUE));// ע�������ǹؼ�����������ǩ��ӵ�jfram��LayeredPane����
//		loginimgLabel.setBounds(0, 0, 1400, 750);// ���ñ�����ǩ��λ��
		JPanel logincp = (JPanel) busmap.getContentPane();
		busmap.getContentPane().setLayout(null);
		busmap.setExtendedState(Frame.MAXIMIZED_BOTH);
		busmap.setVisible(true);
	}

}
