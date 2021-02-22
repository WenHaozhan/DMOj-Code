import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int w = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int [] arr = new int[n+3];
        for(int i = 3;i<3+n;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        int count = 0;
        for(int i = 0;i<n;i++){
            int weight = arr[i]+arr[i+1]+arr[i+2]+arr[i+3];
            if(weight>w){
                break;
            }else{
                count++;
            }
        }
        System.out.println(count);
    }
}
