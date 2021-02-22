import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int numfact [] = new int[100001];
        ArrayList<Integer> faclist [] = new ArrayList[100000]; 
        for(int i = 0 ;i < faclist.length;i++){
            faclist[i] = new ArrayList();
        }
        
        for(int i = 1; i<=100000;i++){
                numfact[i]++;
                for (int j = 2*i;j<=100000;j+=i){
                    numfact[j]++;
                }
        }
        for(int i = 1; i <=100000;i++){
            faclist[numfact[i]].add(i);
        }
        for(int i =0; i<t;i++){
            String s = br.readLine();
            String [] S = s.split(" ");
            int k = Integer.parseInt(S[0]);
            int a = Integer.parseInt(S[1]);
            int b = Integer.parseInt(S[2]);
            int total;
            int higher = Collections.binarySearch(faclist[k],b);
            int lower = Collections.binarySearch(faclist[k],a);
            if(higher<0){
                higher = -higher -2;
            }
            if(lower<0){
                lower = -lower -1;
            }
            total = higher-lower+1;
            System.out.println(total);
        }
    }
}
