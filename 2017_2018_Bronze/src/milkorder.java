//Open 2
import java.util.*;
import java.io.*;

public class milkorder {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("milkorder.in"));
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkorder.out")));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int[] order = new int[n+1];
		int m = Integer.parseInt(st.nextToken());
		int[] social = new int[m];
		int k = Integer.parseInt(st.nextToken());
		int[][] position = new int[k][2];
		boolean oneCheck = false;
		int onePos = 0;
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; i++)	{
			social[i] = Integer.parseInt(st2.nextToken());
			if(social[i] == 1)	{
				oneCheck = true;
				onePos = i;
			}
		}
		for(int i = 0; i < k; i++)	{
			StringTokenizer st3 = new StringTokenizer(br.readLine());
			position[i][0] = Integer.parseInt(st3.nextToken());
			position[i][1] = Integer.parseInt(st3.nextToken());
			order[position[i][1]] = position[i][0];
		}
		System.out.println(Arrays.toString(order));
		if(oneCheck)	{
			one_order(order, social, onePos);
		}
		else	{
			social_order(order, social);
		}
		System.out.println(Arrays.toString(order));
		boolean check = false;
		for(int i = 1; i <= n; i++)	{
			if(order[i] == 1)	{
				out.println(i);
				out.close();
				check = true;
				break;
			}
		}
		if(!check)	{
			for(int i = 1; i <= n; i++)	{
				if(order[i] == 0)	{
					out.println(i);
					out.close();
					break;
				}
			}
		}
		br.close();
	}
	
	public static void social_order(int[] order, int[] social)	{
		int orderIndex = order.length-1;
		int socialIndex = 0;
		for(int i = 1; i < order.length; i++)	{
			for(int j = 0; j < social.length; j++)	{
				if(order[i] == social[j])	{
					orderIndex = i;
					socialIndex = j;
				}
			}
		}
		for(int i = 0; i <= socialIndex; i++)	{
			if(order[orderIndex-i] == 0 && socialIndex-i >= 0)	{
				order[orderIndex-i] = social[socialIndex-i];
			}
		}
		for(int i = 1; i < order.length-orderIndex; i++)	{
			if(order[order.length-i] == 0 && social.length-i > socialIndex)	{
				order[order.length-i] = social[social.length-i];
			}
		}
	}
	
	public static void one_order(int[] order, int[] social, int position)	{
		int orderIndex = order.length-1;
		int socialIndex = 0;
		boolean check = true;
		for(int i = 1; i < order.length; i++)	{
			for(int j = 0; j < social.length; j++)	{
				if(order[i] == social[j])	{
					orderIndex = i;
					socialIndex = j;
					check = false;
				}
			}
		}
		if(check)	{
			orderIndex = 1;
		}
		if(position < socialIndex)	{
			for(int i = 0; i <= socialIndex; i++)	{
				if(order[orderIndex-i] == 0 && socialIndex-i >= 0)	{
					order[orderIndex-i] = social[socialIndex-i];
				}
			}
			for(int i = 1; i < order.length-orderIndex; i++)	{
				if(order[order.length-i] == 0 && social.length-i > socialIndex)	{
					order[order.length-i] = social[social.length-i];
				}
			}
		}
		else	{
			for(int i = 0; i <= socialIndex; i++)	{
				if(order[orderIndex-i] == 0 && socialIndex-i >= 0)	{
					order[orderIndex-i] = social[socialIndex-i];
				}
			}
			for(int i = 1; i < social.length-socialIndex; i++)	{
				if(order[orderIndex+i] == 0 && socialIndex+i < social.length)	{
					order[orderIndex+i] = social[socialIndex+i];
				}
			}
		}
		
	}
}
