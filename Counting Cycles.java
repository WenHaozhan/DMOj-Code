import java.io.*;
import java.util.*;

public class Main {
    static int n,cycle;
    static boolean [][] arr;
    static boolean[] vis;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr= new boolean [n][n];
        cycle=0;
        vis = new boolean[n];
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            String [] S = s.split(" ");
            for(int j = 0;j<n;j++){
                if(S[j].charAt(0)=='1'){
                    arr[i][j]=true;
                }
            }
        }
        for(int i = 0; i < n;i++){
            dfs(i,i);
        }
        System.out.println(cycle);
        
    }
    
    public static void dfs(int start, int cur){
        vis[cur] = true;
        for(int i = 0;i<n;i++){
            if(arr[cur][i]){
                if(i==start){
                    cycle++;
                }
                if(!vis[i]&&i>start){
                    dfs(start,i);
                }
            }
        }
        vis[cur]=false;
    }
}
