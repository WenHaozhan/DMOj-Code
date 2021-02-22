import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        ArrayList<Integer> diff = new ArrayList();
        for(int i = 1; i < arr.length;i++){
            if(arr[i]-arr[i-1]>0){
            diff.add(arr[i]-arr[i-1]);
            }else{
                diff.add(arr[i]);
            }
        }
        int gcd = Integer.MAX_VALUE;
        diff.add(diff.get(diff.size()-1));
        for(int i = 1; i < diff.size();i++){
            int x = diff.get(i);
            int y = diff.get(i-1);
            int temp = x%y;
            while(temp!=0){
                x = y;
                y = temp;
                temp = x%y;
            }
            if(y<gcd){
                gcd=y;
            }
        }
        String s ="";
        int end = (int)Math.sqrt(gcd);
        for(int i = 2;i<=end;i++){
            if(gcd%i==0){
                s+= i+" ";
                if(i!=gcd/i){
                    s+= gcd/i +" ";
                }
            }
        }
        if(gcd>1){
            s+=gcd;
        }
        System.out.println(s);
    }
}
