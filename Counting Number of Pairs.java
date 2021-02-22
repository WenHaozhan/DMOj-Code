import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String S [] = s.split(" ");
        int n = Integer.parseInt(S[0]);
        int m = Integer.parseInt(S[1]);
        s = br.readLine();
        S = s.split(" ");
        int [] num = new int [n];
        for(int i = 0; i < n; i++){
            num[i] = Integer.parseInt(S[i]);
        }
        Arrays.sort(num);
        long count = 0L;
        for(int i = 0; i < n;i++){
            int index = Arrays.binarySearch(num, m-num[i]);
            if(index<0){
                index = -index-1;
            }else{
                int temp = num[index];
                for(int j = index; j<n;j++){
                    if(num[j]!=temp){
                        break;
                    }else{
                        index++;
                    }
                }
            }
            if(index>i){
                count += index-i-1;
            }

        }
        System.out.println(count);
    }
}
