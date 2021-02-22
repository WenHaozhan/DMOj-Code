import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        String [] S = s.split(" ");
        int [] sw = new int[n];
        int [] se = new int[n];
        for(int i = 0; i < n; i++){
            sw[i] = Integer.parseInt(S[i]);
        }
        s = br.readLine();
        S = s.split(" ");
        for(int i = 0; i < n;i++){
            se[i] = Integer.parseInt(S[i]);
        }
        int s1 = 0, s2=0;
        int k = 0;
        for(int i = 0; i < n;i++){
            s1+=sw[i];
            s2+=se[i];
            if(s1==s2){
                k = i+1;
            }
        }
        System.out.println(k);
        
    }
}
