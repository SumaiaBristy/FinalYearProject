package comm.example;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.JTextComponent;

public class Interface extends JFrame{
	
	String str;
	JComboBox combo;
	  JTextField txt;
	
	public Interface()
	{
		
		 String course[] = {"English","Bangla"};
		    JButton b=null;
		   JLabel l1=null,l2=null,l3=null;
		    JFrame frame = new JFrame("Bilingual Sentiment Analysis System");
		    l3=new JLabel("<html>******Bilingual Sentiment Analysis System</br></br></br></br></br></br>******</html>",SwingConstants.CENTER);
		    l1=new JLabel("Select language:                        ");
		    l2=new JLabel();
		    b=new JButton("submit");
		    //frame.add(l1);
		    JPanel panel = new JPanel();
		    JPanel panel1 = new JPanel();
		    combo = new JComboBox(course);
		    combo.setBackground(Color.white);
		    combo.setForeground(Color.black);
		    txt = new JTextField(15);
		    panel.add(l3);
		    panel.add(l1);
		    panel.add(combo);
		    panel.add(txt);
		   // panel.add(l2);
		   panel.add(b);
		   // panel.add(l2,b);
		  
		    
		 //  panel.add(b);
		    frame.add(panel);
		   
		 //   frame.add(p);
		   // l1.add(combo);
		   // frame.add(l1);
		    combo.addItemListener(new ItemListener(){
			      public void itemStateChanged(ItemEvent ie){
			         str = (String)combo.getSelectedItem();
			         txt.setText(str);
			       /* if(str.equals("English"))
					{
						
					}
			       // txt.setText(str);*/
			      }
			    });
		    
		    b.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					if(str.equals("Bangla"))
					{
                         BanglaInterface e=new BanglaInterface();
						
					}
					else if(str.equals("English"))
					{
						
						EnglishInterface e1=new EnglishInterface();
					}
					
					
					
			       
					
				}
			});
		    
		  //  b.addActionListener(this);
		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    frame.setSize(400,200);
		    frame.setVisible(true);
		
		
	} 
	
	
		
		
		
		
	
	
	public static void main(String[] args) {
		Interface ii=new Interface();
		
	}


}
