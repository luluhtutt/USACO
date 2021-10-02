//December #1
import java.io.*;
import java.util.*;

class mixingmilk2 {

   public static void main(String[] args) throws IOException {
   		BufferedReader br = new BufferedReader(new FileReader("mixmilk.in"));
   		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mixmilk.out")));
   		
   		StringTokenizer st = new StringTokenizer(br.readLine());
       
        int b1lim = Integer.parseInt(st.nextToken());
	    int b1cur = Integer.parseInt(st.nextToken());
	    
	    st = new StringTokenizer(br.readLine());
	    int b2lim = Integer.parseInt(st.nextToken());
	    int b2cur = Integer.parseInt(st.nextToken());
	    
	    st = new StringTokenizer(br.readLine());
	    int b3lim = Integer.parseInt(st.nextToken());
	    int b3cur = Integer.parseInt(st.nextToken());
	    
	    int count = 1;
	    for(int i = 1; i <= 100; i++)	{
	    	if(count == 1)	{
	    		if(b1cur+b2cur > b2lim)	{
	    			b1cur = b1cur+b2cur-b2lim;
	    			b2cur = b2lim;
	    		}
	    		else	{
	    			b2cur = b1cur+b2cur;
	    			b1cur = 0;
	    		}
	    	} else if(count == 2)	{
	    		if(b2cur+b3cur > b3lim)	{
	    			b2cur = b2cur+b3cur-b3lim;
	    			b3cur = b3lim;
	    		}
	    		else	{
	    			b3cur = b2cur+b3cur;
	    			b2cur = 0;
	    		}
	    	} else if(count == 3)	{
	    		if(b3cur+b1cur > b1lim)	{
	    			b3cur = b3cur+b1cur-b1lim;
	    			b1cur = b1lim;
	    		}
	    		else	{
	    			b1cur = b3cur+b1cur;
	    			b3cur = 0;
	    		}
	    	}
	    	count++;
	    	if(count > 3) count = 1;
	    }
	    out.println(b1cur + "\n" + b2cur + "\n" + b3cur);
	    out.close();
   }
   
}
