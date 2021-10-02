//December 3
import java.util.*;
import java.io.*;

public class backforth {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("backforth.in"));
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("backforth.out")));
		int[] first  = new int[31];
		int[] second = new int[31];
		int n1 = 10;
		int n2 = 10;
		int stor1 = 1000;
		int stor2 = 1000;
		int[] check = new int[2000];
		int counter = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 10; i++)	{
			first[i] = Integer.parseInt(st.nextToken());
		}
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for(int i = 0; i < 10; i++)	{
			second[i] = Integer.parseInt(st2.nextToken());
		}
		
		for(int i = 0; i < n1; i++)	{ //Tue
			int b = first[i];
			stor1 -= b;
			stor2 += b;
			second[n2] = b;
			n2++;
			int[] th = new int[n1+1];
			for (int k2 = 0; k2 < n1; k2++) {
				if (k2 != i) th[k2] = first[k2];
			}
			for(int k = 0; k < n2; k++)	{ //Wed
				int b3 = second[k];
				stor1 += b3;
				stor2 -= b3;
				int n3 = n1;
				th[n3] = b3;
				n3++;
				int[] fr = new int[n2+1];
				for(int h2 = 0; h2 < n2; h2++) {
					if (h2 != k) fr[h2] = second[h2];
				}
				for(int h = 0; h < n3; h++)	{ //Thurs
					int b4 = th[h];
					if (b4 == 0) continue;
					stor1 -= b4;
					stor2 += b4;
					int n4 = n2;
					fr[n4] = b4;
					n4++;
					for(int v = 0; v < n4; v++)	{//Fri
						int b5 = fr[v];
						if (b5 == 0) continue;
						stor1 += b5;
						stor2 -= b5;
						
						check[stor1] = 1;
						stor2 += b5;
						stor1 -= b5;
					}
					n4--;
					stor1 += b4;
					stor2 -= b4;
				}
				n3--;
				stor1 -= b3;
				stor2 += b3;
			}
			n2--;
			stor1 += b;
			stor2 -= b;
		}
		
		for(int i = 0; i < 2000; i++)	{
			if(check[i] == 1)	{
				//System.out.println(i);
				counter++;
			}
		}
		out.println(counter);
		out.close();
		br.close();
	}

}
