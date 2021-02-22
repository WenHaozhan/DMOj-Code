import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        String [] S = s.split(" ");
        int [] t = new int [n];
        for(int i = 0; i < n; i++){
            t[i] = Integer.parseInt(S[i]);
        }
        Arrays.sort(t);
        int m;
        if(t.length%2==0){
            for(int i = t.length/2-1;i>=0;i--){
                System.out.print(t[i]+" ");
                System.out.print(t[t.length-1-i]+" ");
            }
        }else{
            for(int i = t.length/2;i>0;i--){
                System.out.print(t[i]+" ");
                System.out.print(t[t.length-i]+" ");
            }
            System.out.println(t[0]);
        }
        

            
        
    }
}
