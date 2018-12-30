
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

	 public class TableUserID
	 {
	  static AbstractTableModel model;
	  static JTable table;
	  static Vector vect;
	  static JScrollPane jsp;
	   static Connection con=JavaCoSQL.getConnection();
		static Statement  st;
		static ResultSet  res;
		static PreparedStatement  pst;
		static JFrame jFrame;

       
		public TableUserID(String[] title,String sql,String s) {       
			try {                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          
				st=con.createStatement();
				res=st.executeQuery(sql);
				init(title);
	         show(title,s);                                                            
			} catch (SQLException e) {
				e.printStackTrace();
			}   
			 table.getColumnModel().getColumn(0).setPreferredWidth(300);
		}
	     
	     //�Ѵ����ݿ��л�ȡ��������ʾ����
	     static void show(String[] title,String s)
	     {
	      model.fireTableStructureChanged();
	         try
	         {
	          while(res.next())
	          {
	           Vector rec_vector = new Vector();
	           for(int i=1;i<=title.length;i++)
	           rec_vector.addElement(res.getString(i));
	           vect.addElement(rec_vector);
	          }
	          model.fireTableStructureChanged(); //���±��,��ʾ����vect������
	         }catch(Exception e){e.printStackTrace();}
	         buildFrame(s);
	     }
	     
	     static void init(String[] title)
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
	        return false;
	       }
	      };
	      //���Ʊ��
	       table = new JTable(model);
	       table.setToolTipText("��ʾ�û���Ϣ");
	       table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	       //���ñ������ߴ�ģʽ
	       table.setRowHeight(30);
	       table.setCellSelectionEnabled(true); //���õ�Ԫ�����ڷ�ʽ
	       table.setShowVerticalLines(true);  //�����Ƿ���ʾ��Ԫ���ķָ���
	       table.setShowHorizontalLines(true);
	       //table.setAutoResizeMode  (4);//�������������еĿ��
	       table.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//���ñ���е�ѡ��ģʽ��ֻ����ѡ��һ��
	       DefaultTableCellRenderer cr=new DefaultTableCellRenderer();
	       cr.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
	       table.setDefaultRenderer(Object.class, cr);
	      
	       jsp = new JScrollPane();
	       jsp.setViewportView(table);
	     
	     table.addMouseListener(new MouseAdapter(){ 
	    	  public void mouseClicked(MouseEvent e) { 
	    		  if(e.getButton() == 1) //ʵ�ֵ��� 
	    			  { int row =((JTable)e.getSource()).rowAtPoint(e.getPoint()); //�����λ�� 
	    			  int  col=((JTable)e.getSource()).columnAtPoint(e.getPoint()); //�����λ��
	    			  String UserID=(String)(model.getValueAt(row,col)); //��õ����Ԫ������
	    			  new ManagerCXUserInfX(UserID);
	    			  }
	    	  }
      });
	     }
	     static void buildFrame(String s)
	     {
	      JFrame jFrame = new JFrame(s);
	      Container c=jFrame.getContentPane();
	      c.setLayout(null);
	      c.add(jsp,BorderLayout.CENTER);
	      jsp.setBounds(50,0, 300, 500);
			//BackgroundPanel bgp;
			//bgp=new BackgroundPanel((new ImageIcon("back1.jpg")).getImage());
			//bgp.setBounds(0,0,500,700);
			//bgp.setLayout(null);
	      //jFrame.add(bgp);
	      jFrame.setBounds(400,0,400,700);
	      jFrame.show();
	      jFrame.setVisible(true);
	      jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	      JButton exitButton=new JButton("��  ��");
	      exitButton.setFont(new Font("��Բ",Font.PLAIN,18));
	      exitButton.setBounds(110,550,180, 40);
	      exitButton .setBackground(Color.white);
	      jFrame.add(exitButton);    
		   ImageIcon exit;
		   exit=new ImageIcon("��1.jpg");
		   Image temp1=exit.getImage().getScaledInstance(60,60,exit.getImage().SCALE_DEFAULT);
		   exit=new ImageIcon(temp1);
		   exitButton.setIcon(exit);//��Ӱ�ť

	       
	      
	      exitButton.addActionListener(new ActionListener() {
	    	  public void actionPerformed(ActionEvent e) {
	    		  jFrame.dispose();
	    	  }
	     });
	 }
	 }
	 


	 
