package frame;

import java.awt.*;

import javax.swing.JTextArea;

class TransparentArea extends JTextArea {
	
	public TransparentArea(String a){
		super();
		this.setOpaque(false);//�����������ó�͸��
		this.setAutoscrolls(true);//�������Զ���ʾ�����������
		this.setBorder(null);//ȥ�߿�
		setLineWrap(true);//�Զ�����
		setFont(new Font("����", Font.PLAIN, 17));
		setWrapStyleWord(true);//һ��Ӣ�ĵ�����ͬһ��
		setText(a);
	}
	
	@Override
	public void paintComponent(Graphics g) {
	              super.paintComponent(g);
                            //ȡ�û��������2D����
		Graphics2D g2 = (Graphics2D)g;
		//����͸����Ϊ0.4f
		AlphaComposite ac = AlphaComposite.getInstance(
				AlphaComposite.SRC_OVER,0.0f);
		g2.setComposite(ac);
		g2.setColor(Color.white);
		//����һ����������ȴ�С�������ο����γ����͸��Ч��
		g2.fillRect(0, 0, getWidth(), getHeight());
	}
	
}
