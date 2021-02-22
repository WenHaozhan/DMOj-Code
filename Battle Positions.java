import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int min = Integer.parseInt(br.readLine());
        int j = Integer.parseInt(br.readLine());
        int [] diffarr = new int[n];
        for(int i = 0; i < j; i++){
            String s = br.readLine();
            String [] S = s.split(" ");
            int change = Integer.parseInt(S[2]);
            diffarr[Integer.parseInt(S[0])-1] += change;
            if(Integer.parseInt(S[1])<n){
                diffarr[Integer.parseInt(S[1])] -= change;
            }
        }
        for(int i = 1; i < n; i++){
            diffarr[i] = diffarr[i-1]+diffarr[i];
        }
        int count = 0;
        for(int i = 0;i < n;i++){
            if(diffarr[i]<min){
                count++;
            }
        }
        System.out.println(count);
    }
}
