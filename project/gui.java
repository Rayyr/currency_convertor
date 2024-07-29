package currency_changer;
 
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
 

public class gui extends JFrame implements ActionListener, MouseMotionListener{

	JPanel one,two,three,four,five;
    JButton addcurrency,addrate,update,add,remove;
    JLabel sympol_label,currency_name_label,rate_to_update,new_rate,amount,Rate;
    JTextField sympol_textfield,currency_name_textfield,rate_value_textfield,new_rate_textfield,amount_textfield;
    JComboBox first_currency,seconed_currency,update_rate_combobox,amount_rate_combobox;
    JList added_options;
     
   
    Double w=0.0,x=0.0,amount_value=0.0;
    
    Set<String>currency_name_set;
    Vector<currency>currency_objs;
    
    Vector<rate>currency_2_rate;
    Set<String>currency_2_rate_set;
    
    
    JScrollPane scrollPane1;
    DefaultListModel<String> model ;
    
    final int o=10;
    int indx=0;
    
    
	public gui(){
		super("currency convertor");
		super.setSize(1000, 480);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setLayout(new FlowLayout(0,0,0));
	 
		
		currency_name_set=new HashSet<String>();
	    currency_2_rate_set=new HashSet<String>();
		
		currency_objs=new Vector<currency>();
		currency_2_rate=new Vector<rate>();
	 
		
	     
	    model = new DefaultListModel<String>();
	    
	    
	    one=new JPanel();
	    two=new JPanel();
	    three=new JPanel();
	    four=new JPanel();
	    five=new JPanel();
		
	    
	    one.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	    two.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	    three.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	    four.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	    five.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	    
	    
	    one.setPreferredSize(new Dimension(1000,85));
	    two.setPreferredSize(new Dimension(1000,85));
	    three.setPreferredSize(new Dimension(1000,85));
	    four.setPreferredSize(new Dimension(1000,85));
	    five.setPreferredSize(new Dimension(1000,100));
	    
	    
	    initialize_panel1();
	    initialize_panel2();
	    initialize_panel3();
	    initialize_panel4();
	    initialize_panel5();
	    
	   
	    super.add(one);
		super.add(two);
		super.add(three);
		super.add(four);
		super.add(five);
		
		 
		this.addMouseMotionListener(this);
		super.setResizable(false);
		super.setVisible(true);
	}
	
	public void initialize_panel1() {
		 
		one.setLayout(new FlowLayout(FlowLayout.CENTER,7,10));
		
		sympol_label=new JLabel("Sympol");
		sympol_textfield=new JTextField(10);
		currency_name_label=new JLabel("Currency Name");
		currency_name_textfield=new JTextField(10);
		addcurrency=new JButton("Add Currency");
		
		sympol_label.setFont(new Font("Serif",Font.ROMAN_BASELINE,26));
		currency_name_label.setFont(new Font("Serif",Font.ROMAN_BASELINE,26));
		
		sympol_textfield.setPreferredSize(new Dimension(15,33));
		sympol_textfield.setFont(new Font("Serif",Font.ROMAN_BASELINE,17));
		 
		currency_name_textfield.setPreferredSize(new Dimension(15,33));
		currency_name_textfield.setFont(new Font("Serif",Font.ROMAN_BASELINE,17));
		
		addcurrency.setFocusable(false);
		addcurrency.setFont(new Font("Serif",Font.ROMAN_BASELINE,17));
		
		//register the components to their suitable action listeners
		addcurrency.addActionListener(this);
		
		
		one.add(sympol_label);
		one.add(sympol_textfield );
		one.add(currency_name_label);
		one.add(currency_name_textfield);
		one.add(addcurrency);
		
		
		return;
	}
	
	
	public void initialize_panel2() {
		
		two.setLayout(new FlowLayout(FlowLayout.CENTER,7,10));
		
		addrate=new JButton("Add Rate");
		rate_value_textfield=new JTextField(7);
		first_currency=new JComboBox(currency_objs );
		seconed_currency=new JComboBox(currency_objs );
		first_currency.setPreferredSize(new Dimension(200,23));
		seconed_currency.setPreferredSize(new Dimension(200,23));
		
		addrate.setFocusable(false);
		addrate.setFont(new Font("Serif",Font.ROMAN_BASELINE,17));
	    addrate.setEnabled(false);
		
		first_currency.setFocusable(false);
		seconed_currency.setFocusable(false);
		first_currency.setFont(addrate.getFont());
		seconed_currency.setFont(addrate.getFont());
		
		rate_value_textfield.setPreferredSize(new Dimension(15,33));
		rate_value_textfield.setFont(new Font("Serif",Font.ROMAN_BASELINE,17));
		
		
		addrate.addActionListener(this);
		
		
		two.add(first_currency);
		two.add(rate_value_textfield);
		two.add(seconed_currency);
		two.add(addrate);
		
		
		return;
	}


	public void initialize_panel3() {
		
		three.setLayout(new FlowLayout(FlowLayout.CENTER,7,10));
		
	
		rate_to_update=new JLabel("Rate To Update");
		update_rate_combobox=new JComboBox(currency_2_rate);
		new_rate=new JLabel("New Rate");
		new_rate_textfield=new JTextField(7);
		update=new JButton("Update");
		

		update.setEnabled(false);
		update.setFocusable(false);
		update.setFont(new Font("Serif",Font.ROMAN_BASELINE,17));
		update.addActionListener(this);
		
		update_rate_combobox.setFont(update.getFont());
		update_rate_combobox.setPreferredSize(new Dimension(200,23));
		update_rate_combobox.setFocusable(false);
		
		rate_to_update.setFont(new Font("Serif",Font.ROMAN_BASELINE,26));
		new_rate.setFont(new Font("Serif",Font.ROMAN_BASELINE,26));
		
		new_rate_textfield.setPreferredSize(new Dimension(15,33));
		new_rate_textfield.setFont(new Font("Serif",Font.ROMAN_BASELINE,17));
		
		
		three.add(rate_to_update);
		three.add(update_rate_combobox);
		three.add(new_rate);
		three.add(new_rate_textfield);
		three.add(update);
		
		
		return;
	}


    public void initialize_panel4() {
    	
    	four.setLayout(new FlowLayout(FlowLayout.CENTER,7,10));
    	
    	add=new JButton("add");
    	amount=new JLabel("Amount");
    	Rate=new JLabel("Rate");
    	amount_textfield=new JTextField(7);
    	amount_rate_combobox=new JComboBox(this.currency_2_rate);
    	
    	
    	add.setEnabled(false);
    	add.setFocusable(false);
		add.setFont(new Font("Serif",Font.ROMAN_BASELINE,17));
		add.addActionListener(this);
		

    	amount_rate_combobox.setFont(add.getFont());
		amount_rate_combobox.setPreferredSize(new Dimension(200,23));
		amount_rate_combobox.setFocusable(false);
		
		
		amount_textfield.setPreferredSize(new Dimension(15,33));
		amount_textfield.setFont(new Font("Serif",Font.ROMAN_BASELINE,17));
		
		
		Rate.setFont(new Font("Serif",Font.ROMAN_BASELINE,26));
		Rate.setFont(new Font("Serif",Font.ROMAN_BASELINE,26));
		
		amount.setFont(new Font("Serif",Font.ROMAN_BASELINE,26));
		amount.setFont(new Font("Serif",Font.ROMAN_BASELINE,26));
		
		
		
    	four.add(amount);
    	four.add(amount_textfield);
    	four.add(Rate);
    	four.add(amount_rate_combobox);
    	four.add(add);
    	
    	
    	
    	return;
    }

    
    public void initialize_panel5() {
    	 
    	five.setLayout(new FlowLayout(FlowLayout.CENTER,7,10));
    	
    	remove =new JButton("Remove");
    	added_options=new JList<String>(model);
    	scrollPane1= new JScrollPane(added_options);
    	
    	remove.setFocusable(false);
		remove.setFont(new Font("Serif",Font.ROMAN_BASELINE,17));
		remove.setEnabled(false);
		remove.addActionListener(this);
	    
		added_options.setFont(new Font("Serif",Font.ROMAN_BASELINE,17));
		added_options.setFont(add.getFont());
		added_options.setFocusable(false);
	    added_options.setVisibleRowCount(4);
	   
		added_options.setFixedCellHeight(20);
		added_options.setFixedCellWidth(300);
		added_options.setSelectionMode(DefaultListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		 
		
		five.add(scrollPane1);
		five.add(remove);
    	
    	return;
    }
 
    
    
    @SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		 
    	if(e.getSource()==this.addcurrency) {
    		
    		int previous_size=this.currency_name_set.size();
    		currency_name_set.add(this.currency_name_textfield.getText());
    		previous_size++;
    		
    		if(this.currency_name_set.size()==previous_size) {
    			//different currency name
    		   	this.currency_objs.add(new currency(this.currency_name_textfield.getText(),this.sympol_textfield.getText().charAt(0)));
    			this.first_currency.setSelectedIndex(0);
    	 	    this.seconed_currency.setSelectedIndex(0);
    		  
    		    if(currency_objs.size()>1) 
    		    	this.addrate.setEnabled(true);
    		     
    		}
    		
    		else  
    			JOptionPane.showMessageDialog(null, "This Currency Already Exists","Currency Duplication " ,JOptionPane.ERROR_MESSAGE); 
    		   
    		
    	}
    	
    	
    	if(e.getSource()==this.addrate) {
    		 
    		
    		if(check(e)==true) {
    			
			int previous_size=this.currency_2_rate_set.size();
			this.currency_2_rate_set.add(this.first_currency.getSelectedItem().toString().concat(this.seconed_currency.getSelectedItem().toString()));
       		previous_size++;
       		
       		 
       	 	if(this.currency_2_rate_set.size()==previous_size) {
       	 		
	    	      String []first=this.first_currency.getSelectedItem().toString().split(" ");
	    	      String []seconed=this.seconed_currency.getSelectedItem().toString().split(" ");
    				
       	          this.currency_2_rate.add(new rate(new currency(first[0],first[2].charAt(0)),new currency(seconed[0],seconed[2].charAt(0)),w));
       			  
       	          
       	          this.update.setEnabled(true);
       	          this.update_rate_combobox.setSelectedIndex(0);
       	          
       	          this.add.setEnabled(true);
       	          this.amount_rate_combobox.setSelectedIndex(0);
    	            
       	 	}  
       			 
       	 	else 
       	 		JOptionPane.showMessageDialog(null, "This Rate Already Exists","Rate Duplication " ,JOptionPane.ERROR_MESSAGE);  
	     
    	}

    		
    }	
    	
   if(e.getSource()==this.update) {
	    
	  
	   if(check(e)==true) {
		   
		   int i= this.update_rate_combobox.getSelectedIndex();
		   double value=Double.parseDouble(this.new_rate_textfield.getText());
		   rate temp=new rate(this.currency_2_rate.get(i),value);
		  
		   // edit it to the vector of rates 
		   this.currency_2_rate.set(i, temp);
		    
		   // edit it in the combobox
		   this.update_rate_combobox.setSelectedIndex(i);
		   
		   
		   this.amount_rate_combobox.setSelectedIndex(0);
		  
		   
	   }
	    
	 
   }
   
   if(e.getSource()==this.add) {
	   
	   if(check(e)==true) {
		   
		 rate r=new rate(this.currency_2_rate.get(this.amount_rate_combobox.getSelectedIndex()));
		 
		 String am=this.amount_textfield.getText();
		 String res=String.format(am+" "+r.one+" = "+Double.parseDouble(am)*r.ratevalue+" "+r.two);
		 
	
		 this.model.addElement(res);
		 this.remove.setEnabled(true);
		  
		 
	   }
	   
	    
   }
   
   if(e.getSource()==this.remove) {
	   
	   for(Object t:added_options.getSelectedValues()) 
		   this.model.removeElement(t);
	   
	   if(model.getSize()==0)
		   this.remove.setEnabled(false);
		    
   }
   
}

 
    public boolean check(ActionEvent ev) {
	
	try {
		
		if(ev.getSource()==this.addrate)
		 w=Double.parseDouble(this.rate_value_textfield.getText());
		
		else if(ev.getSource()==this.update)
		 x=Double.parseDouble(this.new_rate_textfield.getText());
		
		else 
		 amount_value=Double.parseDouble(this.amount_textfield.getText());
		   
	}
	catch( Exception e) {
		if(ev.getSource()==this.add)
			JOptionPane.showMessageDialog(null, "Please Make Sure The Amount Is A Number","Invalid Input",JOptionPane.ERROR_MESSAGE);
		
		
		else 
			JOptionPane.showMessageDialog(null, "Please Make Sure The Rate Is A Number","Invalid Input",JOptionPane.ERROR_MESSAGE);
		 
	  return false;
	}
	
	return true;
}



   
    @Override
    public void mouseMoved(MouseEvent e) {
	   
	    int mouseX = e.getX();
        int mouseY = e.getY();

        
        int red = mouseX % 256;  
        int green = mouseY % 256;  

        
        Color newColor = new Color(red, green, 255);

         
        one.setBackground(newColor);
        two.setBackground(newColor);
        three.setBackground(newColor);
        four.setBackground(newColor);
        five.setBackground(newColor);
	  
	
	
	
   }

    
    @Override   
    //not used just for syntax
    public void mouseDragged(MouseEvent e) {
 	 
 	  return ;
    }
   

}
