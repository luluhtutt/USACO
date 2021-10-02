/*
 ID: luluhtu1
 LANG: JAVA
 TASK: ride
 */
import java.io.*;

class ride {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("ride.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
        if (numConv(br.readLine()) == numConv(br.readLine())) {
            pw.println("GO");
        } else {
            pw.println("STAY");
        }
        pw.close();
    }
    
    public static int numConv(String s)	{
    	int v = 1;
    	for (int i = 0; i < s.length(); i++)	{
    		v *= (s.charAt(i) - 'A' + 1);
    	}
    	return v % 47;
    	
    }
}