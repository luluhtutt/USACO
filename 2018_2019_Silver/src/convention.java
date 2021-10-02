//December 1
import java.util.*;
import java.io.*;

public class convention {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("convention.in"));
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("convention.out")));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); //n cows
		int m = Integer.parseInt(st.nextToken()); //m buses
		int c = Integer.parseInt(st.nextToken()); //c cows per bus
		int[] arrival = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++)	{
			arrival[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arrival);
		
		int low = 0;
		int high = arrival[n-1]-arrival[0];
		int middle = (low+high)/2;
		while(low < high)	{
			middle = (low+high)/2;
			//System.out.println("low: " + low + " mid: " + middle + " high: " + high);
			if(low == high-1)	{
				middle = high;
				break;
			}
			//System.out.println("fill: " + fill(n, m, c, arrival, middle) + " n: " + n);
			if(fill(n, m, c, arrival, middle) < n)	{
				low = middle;
			} else	{
				high = middle;
			}
		}
		out.println(middle);
		out.close();
	}
	
	public static int fill(int n, int m, int c, int[] arrival, int space)	{
		int currentBusNum = 1;
		int currentCowNum = 0;
		while(currentBusNum <= m)	{
			int currentBus = 0;
			int startTime = arrival[currentCowNum];
			int endTime = startTime + space;
			//System.out.println("starting: " + startTime + " endTime: " + endTime);
			while(currentBus <= c)	{
				if(currentCowNum > n-1)	{
					return currentCowNum;
				}
				if(arrival[currentCowNum] > endTime || currentBus >= c)	{
					currentBusNum++;
					break;
				} else	{
					currentBus++;
					currentCowNum++;
				}
				//System.out.println("bus #" + currentBusNum + " cows: " + currentBus);
			}
		}
		return currentCowNum;
	}

}
