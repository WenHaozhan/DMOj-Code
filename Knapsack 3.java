import java.io.*;
import java.util.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] S = br.readLine().split(" ");
        long [] dp = new long[5001];
        int N = Integer.parseInt(S[0]);
        int M = Integer.parseInt(S[1]);
        for(int i = 0;i<N;i++){
            S = br.readLine().split(" ");
            long n = Integer.parseInt(S[0]);
            long v = Integer.parseInt(S[1]);
            long p = Integer.parseInt(S[2]);
            int j = 1;long tempv = v,tempp = p;
            for(;j<n&&tempv<=5000;j*=2,tempv*=2,tempp*=2){
                n-=j;
                
                for(int k = 5000;k>=tempv;k--){
                    dp[k] = Math.max(dp[k],dp[k-(int)tempv]+tempp);
                }
            }
            if(n*v<=5000){
                for(int k = 5000;k>=(int)(n*v);k--){
                dp[k] = Math.max(dp[k],dp[k-(int)(n*v)]+(n)*p);
                }
            }
        }
        long max = Long.MIN_VALUE;
        for(int i = 0;i<M;i++){
            S = br.readLine().split(" ");
            int c = Integer.parseInt(S[0]);
            int f = Integer.parseInt(S[1]);
            max = Math.max(max,dp[c]-f);
        }
        System.out.println(max);
        
    }
}
