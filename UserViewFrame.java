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

	 public class UserViewFrame
	 {
	  static AbstractTableModel model;
	  static JTable table;
	  static Vector vect;

	  static JScrollPane jsp;
	   static Connection con=Conn.getConnection();
		static Statement  st;
		static ResultSet  res;
		static PreparedStatement  pst;
		static JFrame jFrame;
		static String name;
		public UserViewFrame(String[] title,String sql,String s,String s1) {
			try {
				st=con.createStatement();
				res=st.executeQuery(sql);
				init(title);
	         show(title,s);
	         name=s1;
			} catch (SQLException e) {
				e.printStackTrace();
			}   
		}
	     
	     //把从数据库中获取的数据显示出来
	     static void show(String[] title,String s) throws HeadlessException, SQLException
	     {
	      model.fireTableStructureChanged();
	      if(!res.next())
	        	 {
	        		 JOptionPane.showMessageDialog(null, "暂无借阅记录！");
	        		 
	        	 }
	       else{  
	    	   try
	         {
	    		   do{	        			    			   
	    			     Vector rec_vector = new Vector();
	        			 for(int i=1;i<=title.length;i++)
	        			 rec_vector.addElement(res.getString(i));
	        		  	 vect.addElement(rec_vector);
	        			 }while(res.next());
	          model.fireTableStructureChanged(); //更新表格,显示向量vect的内容
	         }catch(Exception e){e.printStackTrace();}
	         buildFrame(s);
	         }
	     }
	     

		static void init(final String[] title)
	     {
	      vect = new Vector();
	      
	      vect.removeAllElements();
	      //实现抽象类AbstractTableModel对象model中的方法
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
	      //定制表格
	       table = new JTable(model);
	       table.setToolTipText("显示全部查询结果");
	       table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	       //设置表格调整尺寸模式
	       table.setCellSelectionEnabled(true); //设置单元格现在方式
	       table.setShowVerticalLines(true);  //设置是否显示单元格间的分隔线
	       table.setShowHorizontalLines(true);
	       //table.setAutoResizeMode(4);//调整表中所有列的宽度
	       table.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//设置表格行的选择模式，只允许选择一个
	       DefaultTableCellRenderer cr=new DefaultTableCellRenderer();
	       cr.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
	       table.setDefaultRenderer(Object.class, cr);
	       jsp = new JScrollPane();
	       jsp.setViewportView(table);
	     }
	      
	     @SuppressWarnings("deprecation")
		static void buildFrame(String s)
	     {
	      final JFrame jFrame = new JFrame(s);
	      Container c=jFrame.getContentPane();
	      c.setLayout(null);
	      c.add(jsp);
	      jsp.setBounds(0,0,500,300);
	      jFrame.setBounds(300,100,500,450);
	      
	      JButton returnButton=new JButton("归还");
	      returnButton.setFont(new Font("幼圆",Font.PLAIN,18));
	      returnButton.setBackground(Color.white);
	      returnButton.setBounds(120, 320, 80, 30);

		   jsp.add(returnButton);
		 
	      returnButton.addActionListener(new ActionListener() {
	    	  public void actionPerformed(ActionEvent e) {
	    		  new UserJYQDFrame(name);
	    		  jFrame.dispose();
	    		 
	    	  }
	      });
	      JButton exitButton=new JButton("退出");
	      exitButton.setBounds(250,320, 80, 30);
	      exitButton.setFont(new Font("幼圆", Font.PLAIN, 18));
	      exitButton.setBackground(Color.white);

		   jsp.add(exitButton);
	      exitButton.addActionListener(new ActionListener() {
	    	  public void actionPerformed(ActionEvent e) {
	    		  jFrame.dispose();
	    	  }
	      });
	      jFrame.add(returnButton); jFrame.add(exitButton);
	      jFrame.show();
	      jFrame.setVisible(true);
	      jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	     }

		private static void add(BackgroundPanel bgp) {
			// TODO Auto-generated method stub
			
		}
	 }
	 
	
	 


