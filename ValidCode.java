import java.awt.Color;  
import java.awt.Dimension;  
import java.awt.Font;  
import java.awt.FontMetrics;  
import java.awt.Graphics;  
import java.awt.Graphics2D;  
import java.awt.event.MouseEvent;  
import java.awt.event.MouseListener;  
import java.awt.geom.AffineTransform;  
import java.util.Random;  
  
import javax.swing.JComponent;  
  
public class ValidCode extends JComponent implements MouseListener {  
  
    private String code;  
  
    private int width, height = 30;  
  
    private int codeLength = 4;  
  
    private Random random = new Random();  
  
    public ValidCode() {  
        width = this.codeLength * 14 + (this.codeLength - 1) * 10;  
        setPreferredSize(new Dimension(width, height));  
        setSize(width, height);  
        this.addMouseListener(this);  
        setToolTipText("������Ը�����֤��");  
    }  
  
    public int getCodeLength() {  
        return codeLength;  
    }  
  
    /* 
    ������֤�����ֵĳ��� 
    */  
    public void setCodeLength(int codeLength) {  
        if(codeLength < 4) {  
            this.codeLength = 4;  
        } else {  
            this.codeLength = codeLength;  
        }  
          
    }  
  
    public String getCode() {  
        return code;  
    }  
  
    /* 
        �����������ɫ 
    */  
    public Color getRandColor(int min, int max) {  
  
        if (min > 255)  
            min = 255;  
        if (max > 255)  
            max = 255;  
        int red = random.nextInt(max - min) + min;  
        int green = random.nextInt(max - min) + min;  
        int blue = random.nextInt(max - min) + min;  
        return new Color(red, green, blue);  
    }  
    /* 
        ������֤��������ĸ��ʲô 
    */  
    protected String generateCode() {  
        char[] codes = new char[this.codeLength];  
        for (int i = 0, len = codes.length; i < len; i++) {  
            if (random.nextBoolean()) {  
                codes[i] = (char) (random.nextInt(26) + 65);  
            } else {  
                codes[i] = (char) (random.nextInt(26) + 97);  
            }  
        }  
        this.code = new String(codes);  
        return this.code;  
    }  
  
    @Override  
    protected void paintComponent(Graphics g) {  
        super.paintComponent(g);  
        if(this.code == null || this.code.length() != this.codeLength) {  
            this.code = generateCode();  
        }  
        width = this.codeLength * 14 + (this.codeLength - 1) * 10;  
        super.setSize(width, height);  
        super.setPreferredSize(new Dimension(width, height));  
        Font mFont = new Font("Arial", Font.BOLD | Font.ITALIC, 25);  
        g.setFont(mFont);  
        //���Ƴ���֤��ı����ľ�������  
        Graphics2D g2d = (Graphics2D) g;  
        g2d.setColor(getRandColor(200, 250));  
        g2d.fillRect(0, 0, width, height);  
        g2d.setColor(getRandColor(180, 200));  
        g2d.drawRect(0, 0, width - 1, height - 1);  
        //���Ƴ���֤�뱳������  
        int i = 0, len = 150;  
        for (; i < len; i++) {  
            int x = random.nextInt(width - 1);  
            int y = random.nextInt(height - 1);  
            int x1 = random.nextInt(width - 10) + 10;  
            int y1 = random.nextInt(height - 4) + 4;  
            g2d.setColor(getRandColor(180, 200));  
            g2d.drawLine(x, y, x1, y1);  
        }  
          
        /*i = 0; len = 300; 
        for (; i < len; i++) { 
            int x = random.nextInt(width); 
            int y = random.nextInt(height); 
            g2d.setColor(getRandColor(150, 180)); 
            g2d.drawRect(x, y, 0, 0); 
        }*/  
  
        //���Ƴ���֤��ľ�����ĸ  
        i = 0; len = this.codeLength;  
        FontMetrics fm = g2d.getFontMetrics();  
        int base = (height - fm.getHeight())/2 + fm.getAscent();  
        for(;i<len;i++) {  
            int b = random.nextBoolean() ? 1 : -1;  
            g2d.rotate(random.nextInt(10)*0.01*b);  
            g2d.setColor(getRandColor(20, 130));  
            g2d.drawString(code.charAt(i)+"", 16 * i + 10, base);  
        }  
    }  
  
    //��һ����֤��  
    public void nextCode() {  
        generateCode();  
        repaint();  
    }  
  
    @Override  
    public void mouseClicked(MouseEvent e) {  
          
        nextCode();  
    }  
  
    @Override  
    public void mousePressed(MouseEvent e) {  
        // TODO Auto-generated method stub  
          
    }  
  
    @Override  
    public void mouseReleased(MouseEvent e) {  
        // TODO Auto-generated method stub  
          
    }  
  
    @Override  
    public void mouseEntered(MouseEvent e) {  
        // TODO Auto-generated method stub  
          
    }  
  
    @Override  
    public void mouseExited(MouseEvent e) {  
        // TODO Auto-generated method stub  
          
    }  
}  