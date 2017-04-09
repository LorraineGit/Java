package frame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Button extends JButton{
    private static final long serialVersionUID = 1218571878182523580L;
    
    public Button(){
        // ���ð�ť�Ĵ�С��ͼƬ��Сһ��
        Dimension d = new Dimension(100, 38);
        this.setSize(d);
        this.setMaximumSize(d);
        this.setMinimumSize(d);
        
        // ���ð�ť����ͼ��
        ImageIcon icon1=new ImageIcon(Button.class.getResource("/icon/05.png"));
        setIcon(icon1);

        // �����������ڰ�ť��ʱ�ı���ͼ��
 //       ImageIcon icon2=new ImageIcon(Button.class.getResource("/button/lightblue.gif"));
   //     setRolloverIcon(icon2);
        
        // ������������ڰ�ťͼ���λ�ã�ˮƽ���У���ֱ����
        this.setHorizontalTextPosition(CENTER);
        this.setVerticalTextPosition(CENTER);

        // �����Ʊ߿�
        setBorderPainted(false);

        // �����ƽ���
        setFocusPainted(false);

        // ������������
        setContentAreaFilled(false);

        // ���ý������
        setFocusable(true);

        // ���ð�ť�߿���߿�����֮���������
        setMargin(new Insets(0, 0, 0, 0));

        // ��������
  //      setText(buttonText);
        
        // ������������
 //       Font font=new Font("Arial",Font.BOLD,18);   
//        setFont(font); 
        
        // ����ǰ��ɫ��������ɫ��
  //      setForeground(Color.white);
    }
}