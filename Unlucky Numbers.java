import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        String [] S = s.split(" ");
        int [] unlucky = new int [n];
        for(int i = 0; i < n; i++){
            unlucky[i] = Integer.parseInt(S[i]);
        }
        Arrays.sort(unlucky);
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i <n;i++){
            int f =  Integer.parseInt(br.readLine());
            int index = Arrays.binarySearch(unlucky, f);
            index = -index-1;
            System.out.println(f-index);
        }
    }
}
