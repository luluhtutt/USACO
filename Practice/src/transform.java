/*
 ID: luluhtu1
 LANG: JAVA
 TASK: transform
 */
import java.io.*;
import java.util.*;
public class transform {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("transform.in"));
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		char[][] before = new char[n][n];
		char[][] after = new char[n][n];
		
		for(int i = 0; i < n; i++)	{
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			String current = st2.nextToken();
			for(int j = 0; j < n; j++)	{
				before[i][j] = current.charAt(j);
			}
		}
		for(int i = 0; i < n; i++)	{
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			String current = st2.nextToken();
			for(int j = 0; j < n; j++)	{
				after[i][j] = current.charAt(j);
			}
		}
		if(check90(before, after))	{
			out.println(1);
		}
		else if(check180(before, after))	{
			out.println(2);
		}
		else if(check270(before, after))	{
			out.println(3);
		}
		else if(checkReflect(before, after))	{
			out.println(4);
		}
		else if(checkCombination(before, after))	{
			out.println(5);
		}
		else if(Arrays.deepEquals(before, after))	{
			out.println(6);
		}
		else	{
			out.println(7);
		}
		out.close();
	}
	
	public static char[][] ninetyDegree(char[][] before)	{
		int N = before.length;
		for (int i = 0; i < N / 2; i++)	{
	        for (int j = i; j < N - i - 1; j++)	{
	            char temp = before[i][j]; 
	            before[i][j] = before[N - 1 - j][i]; 
	            before[N - 1 - j][i] = before[N - 1 - i][N - 1 - j]; 
	            before[N - 1 - i][N - 1 - j] = before[j][N - 1 - i]; 
	            before[j][N - 1 - i] = temp; 
	        }
	    }
		return before;
	}
	
	public static char[][] reflect(char[][] before)	{
		for (int j = 0; j < before.length; ++j) {
			char[] row = before[j];
			for(int i = 0; i < (row.length/2); i++) {
				char temp = row[i];
				row[i] = before[j][row.length - i - 1];
				row[row.length - i - 1] = temp;
			}
		}
		return before;
	}
	
	public static boolean check90(char[][] before, char[][] after)	{
		char[][] beginning = new char[before.length][before[0].length];
		for(int i = 0; i < before.length; i++)	{
			for(int j = 0; j < before.length; j++)	{
				beginning[i][j] = before[i][j];
			}
		}
		ninetyDegree(beginning);
		if(Arrays.deepEquals(beginning, after))	{
			return true;
		}
		return false;
	}
	
	public static boolean check180(char[][] before, char[][] after)	{
		char[][] beginning = new char[before.length][before[0].length];
		for(int i = 0; i < before.length; i++)	{
			for(int j = 0; j < before.length; j++)	{
				beginning[i][j] = before[i][j];
			}
		}
		ninetyDegree(beginning);
		ninetyDegree(beginning);
		if(Arrays.deepEquals(beginning, after))	{
			return true;
		}
		return false;
	}
	
	public static boolean check270(char[][] before, char[][] after)	{
		char[][] beginning = new char[before.length][before[0].length];
		for(int i = 0; i < before.length; i++)	{
			for(int j = 0; j < before.length; j++)	{
				beginning[i][j] = before[i][j];
			}
		}
		ninetyDegree(beginning);
		ninetyDegree(beginning);
		ninetyDegree(beginning);
		if(Arrays.deepEquals(beginning, after))	{
			return true;
		}
		return false;
	}
	public static boolean checkReflect(char[][] before, char[][] after)	{
		char[][] beginning = new char[before.length][before[0].length];
		for(int i = 0; i < before.length; i++)	{
			for(int j = 0; j < before.length; j++)	{
				beginning[i][j] = before[i][j];
			}
		}
		reflect(beginning);
		if(Arrays.deepEquals(beginning, after))	{
			return true;
		}
		return false;
	}
	
	public static boolean checkCombination(char[][] before, char[][] after)	{
		char[][] beginning = new char[before.length][before[0].length];
		for(int i = 0; i < before.length; i++)	{
			for(int j = 0; j < before.length; j++)	{
				beginning[i][j] = before[i][j];
			}
		}
		reflect(beginning);
		ninetyDegree(beginning);
		if(Arrays.deepEquals(beginning, after))	{
			return true;
		}
		ninetyDegree(beginning);
		if(Arrays.deepEquals(beginning, after))	{
			return true;
		}
		ninetyDegree(beginning);
		if(Arrays.deepEquals(beginning, after))	{
			return true;
		}
		return false;
	}
}
