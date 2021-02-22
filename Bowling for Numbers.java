import java.io.*;
import java.util.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int q = 0;q<t;q++){
            String [] S = br.readLine().split(" ");
            int n = Integer.parseInt(S[0]);
            int k = Integer.parseInt(S[1]);
            int w = Integer.parseInt(S[2]);
            int dp [][] = new int[k+1][n+1];
            int sumarr [] = new int[n+1];
            for(int i = 1;i<=n;i++){
                sumarr[i]=Integer.parseInt(br.readLine());
            }
            for(int i = 1;i<=n;i++){
                sumarr[i]+=sumarr[i-1];
            }
            for(int i = 1;i<=k;i++){
                for(int j = 1;j<=n;j++){
                    if(j<w) dp[i][j] = dp[i][j-1];
                    else dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j-w]+sumarr[j]-sumarr[j-w]);
                }
            }
            System.out.println(dp[k][n]);
        }
    }
}
