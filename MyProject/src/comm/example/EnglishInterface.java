package comm.example;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import comm.example.ConTest;
public class EnglishInterface extends JFrame{
	
	
	public EnglishInterface()
	{
		super();
		this.setSize(400,400);
		//JLabel l1=new JLabel("Sentiment Analysis for ");
		JLabel l10=new JLabel("Enter floder location");
		JLabel l2,l3,l4,l5,l6,l7,l8,l9,l11,ll;
		JTextField t1=null;
		t1=new JTextField(20);
		//l11=new JLabel();
		  JButton b=new JButton("Submit");
		 
		l2=new JLabel();
		l3=new JLabel();
		l4=new JLabel();
		l5=new JLabel();
		l6=new JLabel();
		l7=new JLabel();
		l8=new JLabel();
		l9=new JLabel();
		ll=new JLabel();
		JCheckBox sub,pos_pol,neg_pol,pos_talk,neg_talk,no_of_pos_word,no_of_neg_word;
		sub=new JCheckBox("Test subjectivity");
		pos_pol=new JCheckBox("Analyze positive polarity");
		neg_pol=new JCheckBox("Analyze negative polarity");
		pos_talk=new JCheckBox("Get number of positive talk");
		neg_talk=new JCheckBox("Get number of negative talk");
		no_of_pos_word=new JCheckBox("High Frequency pos words");
		no_of_neg_word=new JCheckBox("High Frequency neg words");
		//this.add(l1);
		this.add(l10);
		//this.add(l11);
		this.add(t1);
		this.add(l2);
		this.add(sub);
		this.add(l3);
		this.add(pos_pol);
		this.add(l4);
		this.add(neg_pol);
		this.add(l5);
		this.add(pos_talk);
		this.add(l6);
		this.add(neg_talk);
		this.add(l7);
		this.add(no_of_pos_word);
		this.add(l8);
		this.add(no_of_neg_word);
		this.add(l9);
		this.add(b);
		this.add(ll);
	    b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Tester t=new Tester();
				t.SentimentMatching();
				
			}
		});
	    this.setLayout(new GridLayout(11,1));
	    
	    this.setVisible(true);
	    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		
	}
	public static void main(String[] args) {
		
		
		EnglishInterface e=new EnglishInterface();
	}
	

}
