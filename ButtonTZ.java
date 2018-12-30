import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;
import javax.swing.table.*;
public class ButtonTZ extends JFrame{
    private static final long serialVersionUID = 1L;
    private static JTable table = null;
    private JScrollPane js=null ;
    static AbstractTableModel model;
	  static Vector vect;
	   static Connection con=JavaCoSQL.getConnection();
		static Statement  st;
		static ResultSet  res;
		static PreparedStatement  pst;
    public ButtonTZ(String[] title,String sql){
    	try {
			st=con.createStatement();
			res=st.executeQuery(sql);
			init(title);
         show(title);
		} catch (Exception e) {
			e.printStackTrace();
		} 
    	table.getColumnModel().getColumn(0).setPreferredWidth(166);
        table.getColumnModel().getColumn(1).setPreferredWidth(166);
        table.getColumnModel().getColumn(2).setPreferredWidth(166);
    	 table.getColumnModel().getColumn(2).setCellEditor(new MyRender());//���ñ༭��
         table.getColumnModel().getColumn(2).setCellRenderer(new MyRender() );
        js = new JScrollPane(table);
        this.add(js);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
    }
    
    //�Ѵ����ݿ��л�ȡ��������ʾ����
	static void show(String[] title)
    {
     model.fireTableStructureChanged();
        try
        {
         while(res.next())
         {
          Vector rec_vector = new Vector();
          rec_vector.addElement(res.getString(1));
          rec_vector.addElement(res.getInt(2));
          rec_vector.addElement("");
          vect.addElement(rec_vector);
         }
         model.fireTableStructureChanged(); //���±��,��ʾ����vect������
        
        }catch(Exception e){e.printStackTrace();}
    }
 
   void init(String[] title)
    {
     vect = new Vector();
     vect.removeAllElements();
     //ʵ�ֳ�����AbstractTableModel����model�еķ���
     model = new AbstractTableModel(){
      public int getColumnCount(){
       return title.length;
      }
      public int getRowCount(){
       return vect.size();
      }
      public Object getValueAt(int row,int column){
       if(!vect.isEmpty())
        return ((Vector)vect.elementAt(row)).elementAt(column);
       else
        return null;
      }
      public String getColumnName(int column){
       return title[column];
      }
      public void setValueAt(Object value,int row,int column){}
      public Class getColumnClass(int c){
       return getValueAt(0,c).getClass();
      }
      public boolean isCellEditable(int row,int column){
    	  if(column==title.length-1)
    		  return true;
    	  else   return false;
      }
     };
     table = new JTable(model);
     //���Ʊ��
     table = new JTable(model);
     table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
     
     //���ñ������ߴ�ģʽ
    // table.setCellSelectionEnabled(true); //���õ�Ԫ�����ڷ�ʽ
     //table.setShowVerticalLines(true);  //�����Ƿ���ʾ��Ԫ���ķָ���
   //  table.setShowHorizontalLines(true);
     //table.setAutoResizeMode(4);//�������������еĿ��
    
}


class Dialog extends JDialog implements ActionListener{
	BackgroundPanel bgp,bgp1;
	JLabel jl1,jl2,jl3;
	JTextField text1,text2;
	JButton buttonsubscribe;
	Container c;
	Vector<Vector<Object>> vect1;
	int index = table.getSelectedRow();
  int column = table.getColumnCount();

	public Dialog(ButtonTZ  jf, JTable table) {
	super(jf,"�ڿ���������");
	c=this.getContentPane();
	c.setLayout(null);
	setBounds(300, 100,500, 700);
	init1();
	setVisible(true);
	 }
	void init1() {

		 bgp=new BackgroundPanel((new ImageIcon("back2.jpg")).getImage());
		 c.add(bgp); 
		 bgp.setLayout(null);
		 bgp.setBounds(0,0,500, 700);
		 
		 jl1=new JLabel("�ڿ�����"+table.getValueAt(index,0));
		 jl1.setFont(new Font("��Բ",Font.PLAIN,18));
		 jl1.setBounds(100,50,400,40);
		  bgp.add(jl1);

		 jl2=new JLabel("��������Ҫ�������ڿ���ݣ�");
			jl2.setFont(new Font("��Բ",Font.PLAIN,20));
		    jl2.setBounds(100,120,300,35);
		    bgp.add(jl2);	       
		    text1=new JTextField(30);
		    text1.setBounds(100,155,300,35);
		    text1.setFont(new Font("��Բ",Font.PLAIN,18));
		    bgp.add(text1);

			jl3=new JLabel("��������Ҫ������������");
			jl3.setFont(new Font("��Բ",Font.PLAIN,20));
		    jl3.setBounds(100,220,300,35);
		    bgp.add(jl3);	       
		    text2=new JTextField(30);
		    text2.setBounds(100,255,300,35);
		    text2.setFont(new Font("��Բ",Font.PLAIN,18));
		    bgp.add(text2);
		    
		    buttonsubscribe=new JButton("��    ��");
		    buttonsubscribe.setFont(new Font("��Բ",Font.PLAIN,18));
		    buttonsubscribe.setBounds(160,340,180,40);
		    buttonsubscribe .setBackground(Color.white);
		    buttonsubscribe.addActionListener(this);
		    bgp.add(buttonsubscribe);
		    ImageIcon subscribe;
		    subscribe=new ImageIcon("��3.jpg");
			 Image temp1=subscribe.getImage().getScaledInstance(60,60,subscribe.getImage().SCALE_DEFAULT);
			 subscribe=new ImageIcon(temp1);
			 buttonsubscribe.setIcon(subscribe);//��Ӱ�ť
}
	@Override
	public void actionPerformed(ActionEvent e) {
		  Font font=new Font("��Բ",Font.PLAIN,14);
				UIManager.put("OptionPane.messageFont", font);
				UIManager.put("OptionPane.buttonFont", font);
		 if(e.getSource()== buttonsubscribe){
			 String Mgz_Name =(String) table.getValueAt(index,0);
				int Year_subscribe=Integer.valueOf(text1.getText());
				int S_count=Integer.valueOf(text2.getText());
				String sql="insert into Mgz_ord_List values(?,?,?)";
				if(text1.getText().equals("")||text2.getText().equals(""))
					JOptionPane.showMessageDialog(this, "������Ϣ����Ϊ��");
				else if(Integer.valueOf(text2.getText())<1||Integer.valueOf(text2.getText())>800)
					JOptionPane.showMessageDialog(this, "��������ֻ����1~800֮��");
				else{				
					 try {
					            	pst=con.prepareStatement(sql);
								    pst.setString(1,Mgz_Name);
								    pst.setInt(2,Year_subscribe);
								    pst.setInt(3,S_count);
								    pst.executeUpdate();//�������ݿ�
								    JOptionPane.showMessageDialog(this, "�����ɹ���");
								    //con.close();
								    }
					        catch (Exception exception) {
					            exception.printStackTrace();
					        }			
				
				}
			}
		
	}
}
//��Ⱦ ��  �༭��
class MyRender extends AbstractCellEditor implements TableCellRenderer,ActionListener, TableCellEditor{

private static final long serialVersionUID = 1L;
private JButton button =null;
public MyRender(){
    button = new JButton("����");
    button.addActionListener(this);
}

@Override
public Object getCellEditorValue() {
    // TODO Auto-generated method stub
    return null;
}

@Override
public Component getTableCellRendererComponent(JTable table, Object value,
        boolean isSelected, boolean hasFocus, int row, int column) {
    // TODO Auto-generated method stub
    return button;
}

@Override
public void actionPerformed(ActionEvent e) {
    // TODO Auto-generated method stub
   new Dialog(ButtonTZ.this,table);
     
}

@Override
public Component getTableCellEditorComponent(JTable table, Object value,
        boolean isSelected, int row, int column) {
    // TODO Auto-generated method stub
    return button;
}
}
}


