import java.io.*;
import java.util.*;

public class Main {
    public static class Num{
        int n;
        public Num(int x){
            n = x;
        }
    }
    public static class C implements Comparator<Num>{
        public int compare(Num a, Num b){
            long l1 = 0l;
            long l2 = 0l;
            String A = a.n+"";
            String B = b.n+"";
            l1 += a.n;
            for(int i = 0; i < B.length();i++ ){
                l1*=10;
            }
            l1+=b.n;
            l2 +=b.n;
            for(int i = 0; i < A.length();i++ ){
                l2*=10;
            }
            l2+=a.n;
            if(l1>l2){
                return -1;
            }else{
                return 1;
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Num [] arr = new Num[n];
        for(int i = 0; i < n; i++){
            int temp = Integer.parseInt(br.readLine());
            arr[i] = new Num(temp);
        }
        Arrays.sort(arr, new C());
        String S = "";
        for(int i = 0; i < arr.length;i++){
            S+=arr[i].n;
        }
        System.out.println(S);
    }
}
