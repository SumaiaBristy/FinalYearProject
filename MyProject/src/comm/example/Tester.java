package comm.example;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Tester {
      
	  
	 static int i=0;
			
	     static float ff;
		static float sm_pos=0f;
		static float sm_neg=0f;
		static float avg;
		static float sm_p=0;
		static float sm_n=0;
		public void SentimentMatching()
		{
			
			
			float pos_avg=0f;
			float neg_avg=0f;
			
			 int a = 0,aa=0;
			
		     ArrayList<ArrayList<String>> listOfLists = new ArrayList<ArrayList<String>>();
			ArrayList pos_arr = new ArrayList();
			
			ArrayList neg_arr = new ArrayList();
			InsertIntoDatabase tt= new InsertIntoDatabase();
			get_lexicon gt=new get_lexicon();
			tot total =new tot();
			
			listOfLists=tt.return_corpus_words();
			pos_arr=gt.get_pos_lexicon();
			neg_arr=gt.get_neg_lexicon();
			
			
			//>>>>>>>>>>>find out sentiment consistency or polarity of documents >>>>>>>>>>>>>>>>>>>
			
			int[] tot = new int[100];
			int[] seq=new int[100];
			int[] pos_wrd=new int[100];
			int[] neg_wrd=new int[100];
	         int i=0,tot_row=total.getRowCount();
	       
			for(i=0;i<tot_row;i++)
			{
				
				//System.out.println(" "+i);
				int pos=0,neg=0,non_Sent=0;
				
				
				pos_wrd[0]=0;
				neg_wrd[0]=0;
				for(int itt=1;itt<90;itt++)
		         {
		        	 
		        	tot[itt]=0;
		        	 pos_wrd[itt]=0;
		        	 neg_wrd[itt]=0;
		         }
				
				
				
				for(int j=0;j<listOfLists.get(i).size();j++)
				{
					
					for(int k=0;k<pos_arr.size();k++)
					{
						if(listOfLists.get(i).get(j).equals(pos_arr.get(k)))
								{
							          pos++;
							          pos_wrd[j]=pos;
							         tot[j]=1;
							          
							
								}
						
						else pos_wrd[j]=pos;
						
					}
					// find neg document 
					for(int l=0;l<neg_arr.size();l++)
					{
						if(listOfLists.get(i).get(j).equals(neg_arr.get(l)))
								{
							          neg++;
							         tot[j]=-1;
							          neg_wrd[l]=neg;
							       
								}
						else neg_wrd[j]=neg;
						
						
					}
				
				
				}   //frst inner loop
				
				int ttt=pos+neg;
				
				int len=listOfLists.get(i).size();
				 sm_pos=0f;sm_neg=0f;
	 
				if(pos>neg)
				{
				
				  seq[i]=1;
					
				}
				else if(pos<neg)
					seq[i]=-1;
				
				else seq[i]=0;
				
				
				for(int pp=0;pp<len;pp++)
				{
					
					int p=pp+1;
					
					
					if(seq[i]==1)
					{
						if(tot[pp]==1)
						{
					      ff=(float)pos_wrd[pp]/p;
					      sm_pos=(float)sm_pos+ff;
						}
					
						
							
					}
					else if(seq[i]==-1)
					{
						
						if(tot[pp]==-1)
						{
							ff=(float)neg_wrd[pp]/p;
							sm_neg=(float)sm_neg+ff;
						}
						
					}
					
				} 
				
				
				if(seq[i]==1)
				  {
					   sm_p=(float)sm_p+sm_pos;
					   a++;
					   
				  }
				else if(seq[i]==-1)
				{
					 sm_n=(float)sm_n+sm_neg;aa++;
				}
				
			
			}//outer loop
			    
			
				if(a!=0)
				{
					pos_avg=(float)sm_p/a;
				}
					
				if(aa!=0)
				{
					neg_avg=(float)sm_n/aa;
				}
				System.out.println(" "+a+" "+aa+" "+sm_p+" "+sm_n);
				  avg=(float)(pos_avg+neg_avg)/2f;
				   System.out.println("\n\nSubjectivity : document is "+avg*100+"% subjective!!");
			        
				     System.out.println("\n\nPolarity: Document is "+pos_avg*100+"% positive"+" \n\t :Document is "+neg_avg*100+"% negative");
				        System.out.println("\n\nNumber of pos talk: "+a+"\n"+"Number of neg  talk: "+aa);
				        System.out.println("\n\nHighly frequent positive words: "+pos_arr.size()+"\n"+"Highly frequent negative words: "+neg_arr.size());
			
			
			
		}
		
	
	
	public static void  main(String[] args) {
		Tester tt=new Tester();
		
		tt.SentimentMatching();
		
	}



	
		
}

