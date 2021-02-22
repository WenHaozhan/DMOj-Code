import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] arr = new int[10000001];
        for(int i = 2; i<arr.length;i++){
            if(arr[i]==0){
                for(int j = i;j<arr.length;j+=i){
                    arr[j]++;
                }
            }
        }
        for(int i = 1; i <=n; i++){
            String s = br.readLine();
            String [] S = s.split(" ");
            int a = Integer.parseInt(S[0]);
            int b = Integer.parseInt(S[1]);
            int k = Integer.parseInt(S[2]);
            int count = 0;
            for(int j = a; j<=b;j++){
                if(arr[j]==k){
                    count++;
                }
            }
            System.out.println("Case #"+i+": "+count);
        }
    }
}
