import java.io.*;
import java.io.*;
import java.util.*;

public class Main {

    public static int stress(int [] floor, int [] weight, int n,int lastfloor,int baggage){
        if(n==floor.length-1){
            
            return (Math.abs(lastfloor-floor[n])+1)*(baggage);
        }
        int minstress = Integer.MAX_VALUE;
        for(int i = n; i < floor.length;i++){
            int tempfloor = floor[n];
            int tempweight = weight[n];
            floor[n] = floor[i];
            weight[n] = weight[i];
            weight[i] = tempweight;
            floor[i] = tempfloor;
            int tempstress = (Math.abs(lastfloor-floor[n])+1)*(baggage)+stress(floor,weight,n+1,floor[n],baggage-weight[n]);
            if(tempstress<minstress){
                minstress = tempstress;
            }
            tempfloor = floor[n];
            tempweight = weight[n];
            floor[n] = floor[i];
            weight[n] = weight[i];
            weight[i] = tempweight;
            floor[i] = tempfloor;
        }
        return minstress;
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] floor = new int[n];
        int [] weight = new int[n];
        int baggage = 0;
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            String [] S = s.split(" ");
            floor[i] = Integer.parseInt(S[0]);
            weight[i] = Integer.parseInt(S[1]);
            baggage+=weight[i];
        }
        System.out.println(stress(floor,weight,0,101,baggage));
    }
}
