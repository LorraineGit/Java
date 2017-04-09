package frame;

import java.awt.*;

import javax.swing.JTextArea;

class TransparentArea extends JTextArea {
	
	public TransparentArea(String a){
		super();
		this.setOpaque(false);//将输入域设置成透明
		this.setAutoscrolls(true);//输入域自动显示刚输入的内容
		this.setBorder(null);//去边框
		setLineWrap(true);//自动换行
		setFont(new Font("宋体", Font.PLAIN, 17));
		setWrapStyleWord(true);//一个英文单词在同一行
		setText(a);
	}
	
	@Override
	public void paintComponent(Graphics g) {
	              super.paintComponent(g);
                            //取得绘制组件的2D引擎
		Graphics2D g2 = (Graphics2D)g;
		//设置透明度为0.4f
		AlphaComposite ac = AlphaComposite.getInstance(
				AlphaComposite.SRC_OVER,0.0f);
		g2.setComposite(ac);
		g2.setColor(Color.white);
		//绘制一个与输入域等大小的填充矩形框来形成其半透明效果
		g2.fillRect(0, 0, getWidth(), getHeight());
	}
	
}
