//January 3
import java.util.*;
import java.io.*;

public class outofplace {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("outofplace.in"));
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("outofplace.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[] nums = new int[n];

		int outNum = 0;
		int outIndex = 0;
		boolean goBack = false;
		for(int i = 0; i < n; i++)	{
			st = new StringTokenizer(br.readLine());
			nums[i] = Integer.parseInt(st.nextToken());
		}
		if(nums[0] > nums[1])	{
			goBack = true;
			outNum = nums[0];
			outIndex = 0;
		} else if(nums[n-1] < nums[n-2])	{
			outNum = nums[n-1];
			outIndex = n-1;
		} else	{
			for(int i = 1; i < n-1; i++)	{
				if(nums[i] >= nums[i-1] && nums[i] <= nums[i+1])	{
					
				}
				else if(nums[i-1] > nums[i+1])	{
					
				}
				else if(nums[i] > nums[i-1] && nums[i] > nums[i+1])	{
					goBack = true;
					outNum = nums[i];
					outIndex = i;
					break;
				}
				else if(nums[i] < nums[i-1] && nums[i] < nums[i+1])	{
					outNum = nums[i];
					outIndex = i;
					break;
				}
			}
		}
		System.out.println(Arrays.toString(nums) + " " + outIndex + " " + outNum);
		System.out.println(goBack);
		if(goBack)	{
			out.println(goBackwards(nums, outNum, outIndex));
			out.close();
		}
		else	{
			out.println(goForwards(nums, outNum, outIndex));
			out.close();
		}
	}
	
	public static int goBackwards(int[] arr, int outNum, int outIndex)	{
		int solution = 0;
		for(int i = outIndex; i < arr.length; i++)	{
			int current = arr[i];
			if(outNum > arr[i+1])	{
				if(arr[i+1] != current)	{
					solution++;
				}
			} else	{
				break;
			}
		}
		return solution;
	}
	
	public static int goForwards(int[] arr, int outNum, int outIndex)	{
		int solution = 0;
		for(int i = outIndex-1; i >= 0; i--)	{
			int current = arr[i+1];
			if(outNum < arr[i])	{
				if(arr[i] != current)	{
					solution++;
				}
			} else	{
				break;
			}
		}
		return solution;
	}

}
