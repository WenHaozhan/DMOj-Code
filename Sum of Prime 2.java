import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean [] arr = new boolean[100001];
        for(int i = 2;i*i<=100000;i++){
            if(arr[i]==false){
                for(int j = i*i;j<=100000;j+=i){
                    arr[j]=true;
                }
            }
        }
        ArrayList<Integer> prime = new ArrayList();
        for(int i = 2;i<=100000;i++){
            if(!arr[i]){
                prime.add(i);
            }
        }
        int cumsum []= new int[prime.size()+2];
        for(int i = 2;i<cumsum.length;i++){
            cumsum[i] = cumsum[i-1]+prime.get(i-2);
        }
        for(int i = 0; i < n;i++){
            String s = br.readLine();
            String S [] = s.split(" ");
            int a = Integer.parseInt(S[0]);
            int b = Integer.parseInt(S[1]);
            int indexl = Collections.binarySearch(prime,a);
            int indexr = Collections.binarySearch(prime,b);
            if(indexl<0){
                indexl = -indexl-1;
            }
            if(indexr<0){
                indexr = -indexr-2;
            }
            indexl+=2;
            indexr+=2;
            System.out.println(cumsum[indexr]-cumsum[indexl-1]);
        }
    }
}
