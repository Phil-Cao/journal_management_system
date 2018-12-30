import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;


import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

	 public class MyFrame
	 {
	  static AbstractTableModel model;
	  static JTable table;
	  static Vector vect;
	  static JScrollPane jsp;
	   Connection con=Conn.getConnection();
		static Statement  st;
		static ResultSet  res;
		static PreparedStatement  pst;
		static JFrame jFrame;
		public MyFrame(String[] title,String sql,String s) {
			try {
				st=con.createStatement();
				res=st.executeQuery(sql);
				init(title);
		         show(title,s);
			} catch (SQLException e) {
				e.printStackTrace();
			}   
			
		}
	     
	     //把从数据库中获取的数据显示出来
	     static void show(String[] title,String s)
	     {
	      model.fireTableStructureChanged();
	         try
	         {
	          while(res.next())
	          {
	           Vector rec_vector = new Vector();
	           for(int i=1;i<=title.length;i++) {
	        	    if(res.getString(i)==null)
	        	    	 rec_vector.addElement("null");
	        	    else
	                   rec_vector.addElement(res.getString(i));
	           }
	           vect.addElement(rec_vector);
	          }
	          model.fireTableStructureChanged(); //更新表格,显示向量vect的内容
	         }catch(Exception e){e.printStackTrace();}
	         buildFrame(s);
	     }
	     
	     static void init(String[] title)
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
	      // table.setCellSelectionEnabled(true); //设置单元格现在方式
	       table.setShowVerticalLines(true);  //设置是否显示单元格间的分隔线
	       table.setShowHorizontalLines(true);
	       table.setAutoResizeMode(4);//调整表中所有列的宽度
	       //table.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//设置表格行的选择模式，只允许选择一个
	       jsp = new JScrollPane();
	       jsp.setViewportView(table);
	     }
	      
	     static void buildFrame(String s)
	     {
	      JFrame jFrame = new JFrame(s);
	      jFrame.getContentPane().add(jsp);
	      jFrame.setBounds(200,200,800,500);
	      jFrame.show();
	      jFrame.setVisible(true);
	      jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	     }
	 }
	 


