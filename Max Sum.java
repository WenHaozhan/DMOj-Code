import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        String [] S = s.split(" ");
        int [] a = new int [n];
        for(int i = 0; i < n;i++){
            a[i] = Integer.parseInt(S[i]);
        }
        
        int negative = 0;
        for(int i = 0; i < n; i++){
            if(a[i]<0){
                negative++;
            }
        }
        
        for(int i = 0; i < n; i++){
            a[i] = Math.abs(a[i]);
        }
        long total = 0L;
        for(int i = 0; i < n; i++){
            total+=a[i];
        }
        if(negative%2==1){
            Arrays.sort(a);
            total-= 2*a[0];
        }
        System.out.println(total);
    }
}
