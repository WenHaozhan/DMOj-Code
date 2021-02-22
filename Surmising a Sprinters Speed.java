import java.util.*;
import java.io.*;
public class HelloWorld{
    public static void mergesort(int [] d, int[] t, int l, int r){
        if(l<r){
            int mid = (l+r)/2;
            mergesort(d,t,l,mid);
            mergesort(d,t,mid+1,r);
            merge(d,t,l,mid,r);
        }
    }
    public static void merge(int [] d,int[]t,int l, int m, int r ){
        int ad [] = Arrays.copyOfRange(d,l,m+1);
        int bd[] = Arrays.copyOfRange(d,m+1,r+1);
        int at [] = Arrays.copyOfRange(t,l,m+1);
        int bt[] = Arrays.copyOfRange(t,m+1,r+1);
        
        int a = 0, b=0;
        
        for(int i = l; i <=r; i++ ){
            if(a==ad.length || b<bd.length && bd[b]<ad[a]){
                d[i] = bd[b];
                t[i] = bt[b];
                b++;
            }else{
                d[i] = ad[a];
                t[i] = at[a];
                a++;
            }
        }
    }
     public static void main(String []args)throws IOException{
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        String s = b.readLine();
        int n = Integer.parseInt(s);
        int [] dist = new int[n];
        int [] time = new int[n];
        for(int i = 0; i < n; i++){
            s = b.readLine();
            String [] a = s.split(" ");
            time[i] = Integer.parseInt(a[0]);
            dist[i] = Integer.parseInt(a[1]);
        }
        mergesort(time,dist,0,n-1);
        double X = 0;
        
        for(int i = 0; i < n-1; i++){
            int t = time[i+1]-time[i];
            int d = Math.abs(dist[i+1]-dist[i]);
            double temp = (double)d/t;
            
            if(temp>X){
                X = temp;
            }
        }
        System.out.printf("%.5f",X);
     }
}
