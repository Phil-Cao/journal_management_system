import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.*;
public class ButtonT extends JFrame{
    private static final long serialVersionUID = 1L;
    private static JTable table = null;
    private JScrollPane js=null ;
    static AbstractTableModel model;
	  static Vector vect;
	   static Connection con=Conn.getConnection();
		static Statement  st;
		static ResultSet  res;
		static PreparedStatement  pst;
    public ButtonT(String[] title,String sql){
    	try {
			st=con.createStatement();
			res=st.executeQuery(sql);
			init(title);
         show(title);
		} catch (Exception e) {
			e.printStackTrace();
		} 
    	  table.getColumnModel().getColumn(0).setPreferredWidth(200);
    	    // table.setFont(new Font("幼圆",Font.PLAIN,14));
    	 table.getColumnModel().getColumn(6).setCellEditor(new MyRender());//设置编辑器
         table.getColumnModel().getColumn(6).setCellRenderer(new MyRender() );
        js = new JScrollPane(table);
        this.add(js);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.setSize(660, 500);
        this.setLocationRelativeTo(null);
    }
    
    //把从数据库中获取的数据显示出来
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
         model.fireTableStructureChanged(); //更新表格,显示向量vect的内容
        
        }catch(Exception e){e.printStackTrace();}
    }
 
   void init(String[] title)
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
    	  if(column==title.length-1)
    		  return true;
    	  else   return false;
      }
     };
     table = new JTable(model);
     //定制表格
     table = new JTable(model);
     table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
     //设置表格调整尺寸模式
    // table.setCellSelectionEnabled(true); //设置单元格现在方式
     //table.setShowVerticalLines(true);  //设置是否显示单元格间的分隔线
   //  table.setShowHorizontalLines(true);
     //table.setAutoResizeMode(4);//调整表中所有列的宽度
   
}


class Dialog extends JDialog implements ActionListener{
	BackgroundPanel bgp,bgp1;
	JLabel jl1,jl2,jl3,jl4,jl5,jl6;
	Container c;
	Vector<Vector<Object>> vect1;
	public Dialog(ButtonT  jf, JTable table) {
	super(jf,"期刊详情信息");
	c=this.getContentPane();
	c.setLayout(null);
	setBounds(300, 100,550, 500);
	init1();
	setVisible(true);
	 }
	void init1() {
		 bgp=new BackgroundPanel((new ImageIcon("3.jpg")).getImage());
		 c.add(bgp); 
		 bgp.setLayout(null);
		 bgp.setBounds(0,0,550, 450);
		int index = table.getSelectedRow();
		 int column = table.getColumnCount();
		 if(table.getValueAt(index,2).equals("计算机学报"))
		 {
			 bgp1=new BackgroundPanel((new ImageIcon("计算机学报.jpg")).getImage());
			 bgp.add(bgp1); 
			 bgp1.setLayout(null);
			 bgp1.setBounds(50,130,90, 100);
		 }
		 else   if(table.getValueAt(index,2).equals("软件学报"))
		 {
			 bgp1=new BackgroundPanel((new ImageIcon("软件学报.jpg")).getImage());
			 bgp.add(bgp1); 
			 bgp1.setLayout(null);
			 bgp1.setBounds(50,130, 90, 100);
		 }
		 else    if(table.getValueAt(index,2).equals("读者"))
		 {
			 bgp1=new BackgroundPanel((new ImageIcon("读者.jpg")).getImage());
			 bgp.add(bgp1); 
			 bgp1.setLayout(null);
			 bgp1.setBounds(50,130, 90, 150);
		 }
		 else if(table.getValueAt(index,2).equals("意林"))
		 {
			 bgp1=new BackgroundPanel((new ImageIcon("意林.jpg")).getImage());
			 bgp.add(bgp1); 
			 bgp1.setLayout(null);
			 bgp1.setBounds(50,130, 90, 150);
		 }
		 jl1=new JLabel("文章题目："+table.getValueAt(index,0));
		 jl1.setFont(new Font("幼圆",Font.PLAIN,18));
		 jl1.setBounds(200,50,400,40);
		 
		 jl2=new JLabel("作者："+table.getValueAt(index,1));
		 jl2.setFont(new Font("幼圆",Font.PLAIN,18));
		 jl2.setBounds(200,100,200,40);
		 
		 jl3=new JLabel("期刊名："+table.getValueAt(index,2));
		 jl3.setFont(new Font("幼圆",Font.PLAIN,18));
		 jl3.setBounds(200,150,200,40);
		 
		 jl4=new JLabel("年号："+table.getValueAt(index,3));
		 jl4.setFont(new Font("幼圆",Font.PLAIN,18));
		 jl4.setBounds(200,200,200,40);
		 
		 jl5=new JLabel("卷号："+table.getValueAt(index,4));
		 jl5.setFont(new Font("幼圆",Font.PLAIN,18));
		 jl5.setBounds(200,250,200,40);
		 
		 jl6=new JLabel("期号："+table.getValueAt(index,5));
		 jl6.setFont(new Font("幼圆",Font.PLAIN,18));
		 jl6.setBounds(200,300,200,40);	
		 bgp.add(jl1); bgp.add(jl2); bgp.add(jl3); bgp.add(jl4); bgp.add(jl5); bgp.add(jl6);
}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
//渲染 器  编辑器
class MyRender extends AbstractCellEditor implements TableCellRenderer,ActionListener, TableCellEditor{

private static final long serialVersionUID = 1L;
private JButton button =null;
public MyRender(){
    button = new JButton("查看");
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
   new Dialog(ButtonT.this,table);
     
}

@Override
public Component getTableCellEditorComponent(JTable table, Object value,
        boolean isSelected, int row, int column) {
    // TODO Auto-generated method stub
    return button;
}
}
}


