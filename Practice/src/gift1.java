/*
ID: luluhtu1
LANG: JAVA
TASK: gift1
*/
import java.io.*;
import java.util.*;

class gift1	{
	public static void main(String args[]) throws IOException	{
		BufferedReader br = new BufferedReader(new FileReader("gift1.in"));
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		int[] money = new int[n];
		String[] names = new String[n];
		
		for (int i = 0; i < n; i++)	{
			names[i] = br.readLine();
		}
		
		for (int j = 0; j < n; j++)	{
			String giver = br.readLine();
			StringTokenizer a = new StringTokenizer(br.readLine());
			int givingMoney = Integer.parseInt(a.nextToken());
			int split = Integer.parseInt(a.nextToken());
			String[] receivers = new String[split];
			for (int f = 0; f < split; f++)	{
				receivers[f] = br.readLine();
			}
			int receivedMoney;
			if (givingMoney == 0 || split == 0)	{
				receivedMoney = 0;
			}
			else	{
				if(givingMoney%split != 0)	{
					while(givingMoney%split != 0)	{
						givingMoney --;
					}
				}
				receivedMoney = givingMoney/split;
			}
			for (int s = 0; s < n; s++)	{
				if (names[s].equals(giver))	{
					if (givingMoney == 0 || split == 0)	{
						money[s] += 0;
					}
					else	{
						money[s] = money[s] - givingMoney;
					}
				}
				for (int o = 0; o < split; o++)	{
					if (receivers[o].equals(names[s]))	{
						for (int b = 0; b < n; b++)	{
							if (names[b].equals(receivers[o]))	{
								money[b] = money[b] + receivedMoney;
							}
						}
					}
				}
			}
			
		}
		
		for (int v = 0; v < n; v++)	{
			out.print(names[v] + " ");
			out.println(money[v]);
		}
		out.close();
	}
}