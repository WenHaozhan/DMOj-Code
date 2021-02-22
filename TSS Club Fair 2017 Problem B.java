import java.io.*;
import java.util.*;

public class Main {
    public static void mergesort(long [] arr){
        mergesort(arr,0,arr.length);
    }
    public static void mergesort(long[]arr, int start, int end){
        if(end-start>1){
            int mid = (start+end)/2;
            mergesort(arr,start,mid);
            mergesort(arr,mid,end);
            merge(arr,start,mid,end);
        }
    }
    public static void merge(long [] arr, int s,int m,int e){
        int a = 0, b = 0;
        long [] A = Arrays.copyOfRange(arr,s,m);
        long [] B = Arrays.copyOfRange(arr,m,e);
        for(int i = s;i<e;i++){
            if(b==B.length||a!=A.length&&A[a]<B[b]){
                arr[i] = A[a];
                a++;
            }else{
                arr[i] = B[b];
                b++;
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String [] S = s.split(" ");
        int n = Integer.parseInt(S[0]);
        int q = Integer.parseInt(S[1]);
        long [] dist = new long[n];
        for(int i = 0; i < n;i++){
            s = br.readLine();
            S = s.split(" ");
            int x = Integer.parseInt(S[0]);
            int y = Integer.parseInt(S[1]);
            dist[i] = (long)x*(long)x + (long)y*(long)y;
        }
        mergesort(dist);
        long [] range = new long[q];
        for(int i = 0;i<q;i++){
            int r = Integer.parseInt(br.readLine());
            range[i] = (long)r*(long)r;
        }
        
        for(int i=0;i < q; i++){
            int l = 0, r = n-1;
            int index = -1;
            while(l<=r){
                int m = (l+r)/2;
                if(dist[m]<=range[i]){
                    l = m+1;
                }else{
                    index = m;
                    r = m-1;
                }
            }
            if(index == -1){
                index = n;
            }
            System.out.println(index);
        }
    }
}
