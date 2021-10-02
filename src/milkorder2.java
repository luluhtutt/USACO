//Open 2
import java.util.*;
import java.io.*;

public class milkorder2 {

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
		int onePosition = 0;
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; i++)	{
			social[i] = Integer.parseInt(st2.nextToken());
			if(social[i] == 1)	{
				oneCheck = true;
				onePosition = i;
			}
		}
		for(int i = 0; i < k; i++)	{
			StringTokenizer st3 = new StringTokenizer(br.readLine());
			position[i][0] = Integer.parseInt(st3.nextToken());
			position[i][1] = Integer.parseInt(st3.nextToken());
			order[position[i][1]] = position[i][0];
		}
		
		if(oneCheck)	{
			one_order(order, social, onePosition);
			for(int i = 1; i < order.length; i++)	{
				if(order[i] == 1)	{
					out.println(i);
					break;
				}
			}
		}
		else	{
			reg_order(order, social);
			for(int i = 1; i < order.length; i++)	{
				if(order[i] == 0)	{
					out.println(i);
					break;
				}
			}
		}
		System.out.println(Arrays.toString(order));
		out.close();
		br.close();
	}
	
	public static void one_order(int[] order, int[] social, int onePosition)	{
		int prerankPos = 0;
		int prerankOPos = 0;
		int zeroCount = 0;
		int zeroPosition = 0;
		int oneCount = 0;
		boolean inOrder = false;
		for(int i = 1; i < order.length; i++)	{
			for(int j = 0; j < social.length; j++)	{
				if(order[i] == social[j])	{
					prerankPos = j;
					prerankOPos = i;
					inOrder = true;
				}
			}
			if(order[i] == 0)	{
				zeroCount++;
				zeroPosition = i;
			}
			if(order[i] == 1)	{
				oneCount++;
			}
		}
		if(zeroCount == 1 && oneCount == 0)	{
			order[zeroPosition] = 1;
		}
		else if(inOrder)	{
			if(onePosition < prerankPos)	{
				for(int i = 0; i <= social.length; i++)	{
					for(int j = 1; j < order.length; j++)	{
						if(order[j] == 0)	{
							order[j] = social[i];
							break;
						}
					}
				}
			}
			else	{
				for(int i = prerankPos+1; i < social.length; i++)	{
					for(int j = prerankOPos+1; j < order.length; j++)	{
						if(order[j] == 0)	{
							order[j] = social[i];
							break;
						}
					}
				}
			}
		}
		else	{
			for(int i = 0; i < social.length; i++)	{
				for(int j = 1; j < order.length; j++)	{
					if(order[j] == 0)	{
						order[j] = social[i];
						break;
					}
				}
			}
		}
		
	}
	
	public static void reg_order(int[] order, int[] social)	{
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
	
	
}
