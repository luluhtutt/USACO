//December #1
import java.io.*;
import java.util.*;

class mixingmilk {

   public static void main(String[] args) throws IOException {
   		BufferedReader br = new BufferedReader(new FileReader("mixmilk.in"));
   		int count;
       
   		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mixmilk.out")));
       
   		StringTokenizer st = new StringTokenizer(br.readLine());
       
        int B1L = Integer.parseInt(st.nextToken());
	    int B1C = Integer.parseInt(st.nextToken());
	    
	    StringTokenizer st2 = new StringTokenizer(br.readLine());
	    int B2L = Integer.parseInt(st2.nextToken());
	    int B2C = Integer.parseInt(st2.nextToken());
	    
	    StringTokenizer st3 = new StringTokenizer(br.readLine());
	    int B3L = Integer.parseInt(st3.nextToken());
	    int B3C = Integer.parseInt(st3.nextToken());
       
       count = 0;
       for (count = 0; count < 1; count++) {
           
           if (B1C + B2C < B2L || B1C + B2C == B2L)   {
               B2C = B2C + B1C;
               B1C = 0;
           }
           else    {
               B1C = (B1C + B2C) - B2L;
               B2C = B2L;
           }
           count++;
           
           if (B2C + B3C < B3L || B2C + B3C == B3L)   {
               B3C = B3C + B2C;
               B2C = 0;
           }
           else    {
               B2C = (B2C + B3C) - B3L;
               B3C = B3L;
           }
           count++;
           
           if (B3C + B1C < B1L || B3C + B1C == B1L)   {
               B1C = B1C + B3C;
               B3C = 0;
           }
           else    {
               B3C = (B3C + B1C) - B1L;
               B1C = B1L;
           }
           count++;
           count--;
       }
       if (B1C + B2C < B2L || B1C + B2C == B2L)   {
               B2C = B2C + B1C;
               B1C = 0;
           }
       else    {
           B1C = (B1C + B2C) - B2L;
           B2C = B2L;
       }
       out.println(B1C);
       out.println(B2C);
       out.println(B3C);
 	   out.close();
   }
   
}
