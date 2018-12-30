import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.*;
public class ButtonT2 extends JFrame{
    private static final long serialVersionUID = 1L;
    private static JTable table = null;
    private JScrollPane js=null ;
    static AbstractTableModel model;
	  static Vector vect;
	   static Connection con=Conn.getConnection();
		static Statement  st;
		static ResultSet  res;
		static PreparedStatement  pst;
		static String s1;
		String sql1;
    public ButtonT2(String[] title,String sql,String s){
    	try {
			st=con.createStatement();
			res=st.executeQuery(sql);
			s1=s;
			init(title);
         show(title);
		} catch (Exception e) {
			e.printStackTrace();
		} 
    	 table.getColumnModel().getColumn(6).setCellEditor(new MyRender());//���ñ༭��
         table.getColumnModel().getColumn(6).setCellRenderer(new MyRender() );
        js = new JScrollPane(table);
        this.add(js);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.setSize(550, 400);
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
          rec_vector.addElement(res.getString(2));
          rec_vector.addElement(res.getString(3));
          rec_vector.addElement(res.getInt(4));
          rec_vector.addElement(res.getInt(5));
          rec_vector.addElement(res.getInt(6));
          rec_vector.addElement("");
          vect.addElement(rec_vector);
         }
         model.fireTableStructureChanged(); //���±��,��ʾ����vect������
        
        }catch(Exception e){e.printStackTrace();}
    }
 
   void init(final String[] title)
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
	JLabel jl1,jl2,jl3,jl4,jl5,jl6;
	JButton BorrowButton;
	  String MID,Mname,YearTime,Reelnumber,MgzNumber,time;
	  String sql;
	Container c;
	Vector<Vector<Object>> vect1;
	public Dialog(ButtonT2  buttonT2, JTable table) {
	super(buttonT2,"�ڿ�������Ϣ");
	c=this.getContentPane();
	c.setLayout(null);
	setBounds(300, 100,550, 500);
	init1();
	setVisible(true);
	 }
	void init1() {
		 bgp=new BackgroundPanel((new ImageIcon("�û���ѯ1.jpg")).getImage());
		 c.add(bgp); 
		 bgp.setLayout(null);
		 bgp.setBounds(0,0,550, 450);
		 final int index = table.getSelectedRow();
		 int column = table.getColumnCount();
		 if(table.getValueAt(index,2).equals("�����ѧ��"))
		 {
			 
			 bgp1=new BackgroundPanel((new ImageIcon("�����ѧ��.jpg")).getImage());
			 bgp.add(bgp1); 
			 bgp1.setLayout(null);
			 bgp1.setBounds(50,130,90, 100);
		 }
		 else   if(table.getValueAt(index,2).equals("���ѧ��"))
		 {
			 bgp1=new BackgroundPanel((new ImageIcon("���ѧ��.jpg")).getImage());
			 bgp.add(bgp1); 
			 bgp1.setLayout(null);
			 bgp1.setBounds(50,130, 90, 100);
		 }
		 else    if(table.getValueAt(index,2).equals("����"))
		 {
			 bgp1=new BackgroundPanel((new ImageIcon("����.jpg")).getImage());
			 bgp.add(bgp1); 
			 bgp1.setLayout(null);
			 bgp1.setBounds(50,130, 90, 150);
		 }
		 else if(table.getValueAt(index,2).equals("����"))
		 {
			 bgp1=new BackgroundPanel((new ImageIcon("����.jpg")).getImage());
			 bgp.add(bgp1); 
			 bgp1.setLayout(null);
			 bgp1.setBounds(50,130, 90, 150);
		 }
		 jl1=new JLabel("������Ŀ��"+table.getValueAt(index,0));
		 jl1.setFont(new Font("��Բ",Font.PLAIN,18));
		 jl1.setBounds(200,20,400,40);
		 
		 jl2=new JLabel("���ߣ�"+table.getValueAt(index,1));
		 jl2.setFont(new Font("��Բ",Font.PLAIN,18));
		 jl2.setBounds(200,70,200,40);
		 
		 jl3=new JLabel("�ڿ�����"+table.getValueAt(index,2));
		 jl3.setFont(new Font("��Բ",Font.PLAIN,18));
		 jl3.setBounds(200,120,200,40);
		 
		 jl4=new JLabel("��ţ�"+table.getValueAt(index,3));
		 jl4.setFont(new Font("��Բ",Font.PLAIN,18));
		 jl4.setBounds(200,170,200,40);
		 
		 jl5=new JLabel("��ţ�"+table.getValueAt(index,4));
		 jl5.setFont(new Font("��Բ",Font.PLAIN,18));
		 jl5.setBounds(200,220,200,40);
		 
		 jl6=new JLabel("�ںţ�"+table.getValueAt(index,5));
		 jl6.setFont(new Font("��Բ",Font.PLAIN,18));
		 jl6.setBounds(200,270,200,40);	
		 bgp.add(jl1); bgp.add(jl2); bgp.add(jl3); bgp.add(jl4); bgp.add(jl5); bgp.add(jl6);
		 
		 BorrowButton=new JButton("����");
	     BorrowButton.setFont(new Font("��Բ",Font.PLAIN,18));
	     BorrowButton.setBackground(Color.white);
	     BorrowButton.setBounds(200, 320, 80, 30);
	     BorrowButton.addActionListener(this);
	     bgp.add(BorrowButton);
	     sql="select Mgz_ID from  Mgz_log_Inf where Mgz_Name='"+table.getValueAt(index,2)+"' and Yeartime='"+table.getValueAt(index,3)+"' and Reel_number='"+table.getValueAt(index,4)+"' and Mgz_number='"+table.getValueAt(index,5)+"' and Mgz_state='�ڹ�'";
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==BorrowButton){  
			try {
				String sqlu="select Use_Borrownum from User_Inf where UserID='"+s1+"'";
				st=con.createStatement();
				res=st.executeQuery(sqlu);
				if(res.next()){
					String count=res.getString(1);
					if(count.equals("5"))
						JOptionPane.showMessageDialog(this, "���������������ƣ�");
					else{
				         st=con.createStatement();
				        res=st.executeQuery(sql);
				if(res.next())
				{
					MID=res.getString(1);
					String sql2="select Mgz_Name,Yeartime,Reel_number,Mgz_Number from Mgz_log_Inf where Mgz_ID='"+MID+"'";
					st=con.createStatement();
					res=st.executeQuery(sql2);
					if(res.next()){
					Mname=res.getString(1);
					YearTime=res.getString(2);
					Reelnumber=res.getString(3);
					MgzNumber=res.getString(4);
					SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
					Date date = new Date();  
				    Timestamp timeStamp = new Timestamp(date.getTime());
				    time=df.format(timeStamp);
					String sql3="update Mgz_dir_Inf set M_count=M_count-1 where Mgz_Name='"+Mname+"'";
					String sql4="update Mgz_log_Inf set Mgz_state='���' where Mgz_ID='"+MID+"'";
					String sql5="update User_Inf set Use_Borrownum=Use_Borrownum+1 where UserID='"+s1+"'";
					String sql6="insert into Mag_bor_Inf values(?,?,?,?,?,?,?,?,?)";
					pst=con.prepareStatement(sql3);
				    pst.executeUpdate();
				    pst=con.prepareStatement(sql4);
				    pst.executeUpdate();
				    pst=con.prepareStatement(sql5);
				    pst.executeUpdate();
				    pst=con.prepareStatement(sql6);
				    pst.setString(1,s1);
				    pst.setString(2,MID);
				    pst.setString(3,Mname);
				    pst.setString(4,YearTime);
				    pst.setString(5,Reelnumber);
				    pst.setString(6,MgzNumber);
				    pst.setString(7,time);
				    pst.setString(8,null);
				    pst.setString(9,"���");
				    pst.executeUpdate();
				    JOptionPane.showMessageDialog(this, "���ĳɹ���");
				}
				}
				else{
					JOptionPane.showMessageDialog(this, "�����ڹ��ڿ���");
				}
				}
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
	private String format(Timestamp timeStamp) {
		// TODO Auto-generated method stub
		return null;
	}
	      }

class MyRender extends AbstractCellEditor implements TableCellRenderer,ActionListener, TableCellEditor{

	private static final long serialVersionUID = 1L;
	private JButton button =null;
	public MyRender(){
	    button = new JButton("�鿴");
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
	   new Dialog(ButtonT2.this,table);
	     
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value,
	        boolean isSelected, int row, int column) {
	    // TODO Auto-generated method stub
	    return button;
	}
	}
	}


