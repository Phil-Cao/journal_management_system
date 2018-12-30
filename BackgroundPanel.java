import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

public class BackgroundPanel extends JPanel {
	Image im;
	public BackgroundPanel(Image im){
    this.im=im;
    this.setOpaque(true);
    }

public void paintComponent(Graphics g){//从左上角开始画图片
   super.paintComponents(g);
   g.drawImage(im,0,0,this.getWidth(),this.getHeight(),this);
   }
}