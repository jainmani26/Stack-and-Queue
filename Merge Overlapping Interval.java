import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            arr[j][0] = Integer.parseInt(line.split(" ")[0]);
            arr[j][1] = Integer.parseInt(line.split(" ")[1]);
        }

        mergeOverlappingIntervals(arr);
    }

    public static void mergeOverlappingIntervals(int[][] arr) 
    {
        Pair[] Pairs = new Pair[arr.length];
        for(int i=0;i<arr.length;i++)
        {
            Pairs[i] = new Pair(arr[i][0], arr[i][1]); //startTime,endTime
        }
        Arrays.sort(Pairs); 
        
        Stack<Pair> stk = new Stack<>();
        
        for(int i = 0; i < arr.length; i++)
        {
            if(i == 0)
            {
                stk.push(Pairs[i]);
            }
            else 
            {
                Pair top = stk.peek();
                
                if(top.endTime >= Pairs[i].startTime)
                {
                    if(top.endTime < Pairs[i].endTime)
                    {
                        top.endTime = Pairs[i].endTime;
                    }
                }
                else
                {
                   Pair ans= stk.pop();
                  System.out.println(ans.startTime+ " " + ans.endTime);
                  stk.push(Pairs[i]);
                }
            }
        }
        
        if(stk.size () > 0)
        {
             Pair ans= stk.pop();
             System.out.println(ans.startTime+ " " + ans.endTime);
        }
    }
    
    public static class Pair implements  Comparable<Pair>
    {
        int startTime;
        int endTime;
        
        Pair(int startTime , int endTime)
        {
            this.startTime= startTime;
            this.endTime = endTime;
        }
        
        public int compareTo(Pair O2)
        {
            if(this.startTime != O2.startTime)
            {
                return this.startTime - O2.startTime;
            }
            else
            {
                return this.endTime - O2.endTime;   
            }
            
        }
    }
}
