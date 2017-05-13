package comm.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

public class ConTest {
	
	private int pos_d;
	private int neg_d;
	private float pos_pol;
	private float neg_pol;
	
	
	static int i=0;
	
    static float ff;
	static float sm_pos=0f;
	static float sm_neg=0f;
	static float avg;
	static float sm_p=0;
	static float sm_n=0;
	
	
	 public float getPos_pol() {
		return pos_pol;
	}


	public static float getAvg() {
		return avg;
	}


	public static void setAvg(float avg) {
		ConTest.avg = avg;
	}


	public void setPos_pol(float pos_pol) {
		this.pos_pol = pos_pol;
	}


	public float getNeg_pol() {
		return neg_pol;
	}


	public void setNeg_pol(float neg_pol) {
		this.neg_pol = neg_pol;
	}


	public int getPos_d() {
		return pos_d;
	}


	public void setPos_d(int pos_d) {
		this.pos_d = pos_d;
	}


	public int getNeg_d() {
		return neg_d;
	}


	public void setNeg_d(int neg_d) {
		this.neg_d = neg_d;
	}
   
	

	 
	
	
	public void SentimentMatchingBangla()
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
		
		listOfLists=tt.return_bangla_corpus_words();
		pos_arr=gt.get_bangla_pos_lexicon();
		neg_arr=gt.get_bangla_neg_lexicon();
		
		
		//>>>>>>>>>>>find out sentiment consistency or polarity of documents >>>>>>>>>>>>>>>>>>>
		
		int[] tot = new int[100];
		int[] seq=new int[100];
		int[] pos_wrd=new int[100];
		int[] neg_wrd=new int[100];
         int i=0,tot_row=total.getRowCountBangla();
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
				/* find neg document */
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
			
			pos_d=a;
			neg_d=aa;
			
		    
			
	         avg=(float)(pos_avg+neg_avg)/2f;
	         
	         pos_pol=(float)pos_avg*100;
		     neg_pol=(float)neg_avg*100;
	        
	         
	        System.out.println("\n\nSubjectivity : document is "+avg*100+"% subjective!!");
	        
	     System.out.println("\n\nPolarity: Document is "+pos_avg*100+"% positive"+" \n\t :Document is "+neg_avg*100+"% negative");
	        System.out.println("\n\nNumber of pos talk: "+a+"\n"+"Number of neg  talk: "+aa);
	        System.out.println("\n\nHighly frequent positive words: "+pos_arr.size()+"\n"+"Highly frequent negative words: "+neg_arr.size());
	       
	        /*for(i=0;i<pos_arr.size();i++)
	        {
	        	System.out.println(pos_arr.get(i));
	        	
	        }
	        System.out.println("First Ranked negative words:\n");
	        for(i=0;i<neg_arr.size();i++)
	        {
	        	System.out.println(neg_arr.get(i));
	        	
	        }*/
		
		//ConTest c=new ConTest();
		/*setNeg_d(neg_d);
		setPos_d(pos_d);
		setAvg(avg);
		setPos_pol(pos_pol);
		setNeg_pol(neg_pol);*/
		
		
	}
	public static void main(String[] args) {
		
		
		ConTest c=new ConTest();
		c.SentimentMatchingBangla();
		
	}

}
