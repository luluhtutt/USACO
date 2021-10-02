//December 3
import java.util.*;
import java.io.*;

public class backforth2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("backforth.in"));
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("backforth.out")));
		int[] check = new int[2000];
		int[][] bkt_arr = new int[6][11];
		int[] n_bkt = new int[6];
		n_bkt[2] = 10;
		n_bkt[3] = 11;
		n_bkt[4] = 11;
		n_bkt[5] = 11;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 10; i++)	{
			bkt_arr[2][i] = Integer.parseInt(st.nextToken()); // barn 1, Tue
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 10; i++)	{
			bkt_arr[3][i] = Integer.parseInt(st.nextToken()); // Wed
		}
		
		tuesday(1000, 1000, bkt_arr, n_bkt, check);
		
		int counter = 0;
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
	
	public static void tuesday(int stor1, int stor2, int[][] bkt_arr, int[] n_bkt, int[] check)	{
		for(int i = 0; i < n_bkt[2]; i++)	{
			int b2 = bkt_arr[2][i];
			if (b2 == 0) continue;
			bkt_arr[2][i] = 0;
			bkt_arr[3][n_bkt[3]-1] = b2;
			wednesday(stor1-b2, stor2+b2, bkt_arr, n_bkt, check);
			bkt_arr[2][i] = b2;
		}
	}
	public static void wednesday(int stor1, int stor2, int[][] bkt_arr, int[] n_bkt, int[] check)	{
		for(int i = 0; i < n_bkt[3]; i++)	{
			int b3 = bkt_arr[3][i];
			if(b3 == 0) continue;
			bkt_arr[3][i] = 0;
			bkt_arr[4][n_bkt[4]-1] = b3;
			for(int j = 0; j < 10; j++)	{
				bkt_arr[4][j] = bkt_arr[2][j];
			}
			thursday(stor1+b3, stor2-b3, bkt_arr, n_bkt, check);
			bkt_arr[3][i] = b3;
		}
	}
	public static void thursday(int stor1, int stor2, int[][] bkt_arr, int[] n_bkt, int[] check)	{
		for(int i = 0; i < n_bkt[4]; i++)	{
			int b4 = bkt_arr[4][i];
			if(b4 == 0) continue;
			bkt_arr[4][i] = 0;
			bkt_arr[5][n_bkt[5]-1] = b4;
			for(int j = 0; j < 10; j++)	{
				bkt_arr[5][j] = bkt_arr[3][j];
			}
			friday(stor1-b4, stor2+b4, bkt_arr, n_bkt, check);
			bkt_arr[4][i] = b4;
		}
	}
	public static void friday(int stor1, int stor2, int[][] bkt_arr, int[] n_bkt, int[] check)	{
		for(int i = 0; i < n_bkt[5]; i++)	{
			int b5 = bkt_arr[5][i];
			if(b5 == 0) continue;
			check[stor1+b5] = 1;
		}
	}
}
