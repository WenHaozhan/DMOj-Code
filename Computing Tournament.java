import java.io.*;
import java.util.*;

public class Main {
    public static class Participant{
        int num;
        int first, second;
        public Participant(int n, int f, int s){
            num = n;
            first = f;
            second = s;
        }
    }
    public static class Firstcompare implements Comparator<Participant>{
        public int compare(Participant p1, Participant p2){
            if(p1.first>p2.first){
                return -1;
            }else{
                return 1;
            }
        }
    }
    public static class Secondcompare implements Comparator<Participant>{
        public int compare(Participant p1, Participant p2){
            if(p1.second>p2.second){
                return -1;
            }else{
                return 1;
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String S[] = s.split(" ");
        int n = Integer.parseInt(S[0]);
        int k = Integer.parseInt(S[1]);
        Participant[] arr = new Participant[n];
        for(int i = 0; i < n; i++){
            s = br.readLine();
            S = s.split(" ");
            int f = Integer.parseInt(S[0]);
            int se = Integer.parseInt(S[1]);
            arr[i] = new Participant(i+1,f,se);
        }
        Arrays.sort(arr,new Firstcompare());
        Participant [] newarr = Arrays.copyOfRange(arr,0,k);
        Arrays.sort(newarr, new Secondcompare());
        System.out.println(newarr[0].num);
    }
}
