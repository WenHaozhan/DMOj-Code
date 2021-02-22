import java.io.*;
import java.util.*;

public class Main {
    public static class Point{
        int x,y;
        public Point(int a,int b){
            x=a;
            y=b;
        }
    }    
    
    public static class CompareX implements Comparator<Point>{
        public int compare(Point p1, Point p2){
            if(p1.x<p2.x){
                return -1;
            }else{
                return 1;
            }
        }
    }
    public static class CompareY implements Comparator<Point>{
        public int compare(Point p1, Point p2){
            if(p1.y<p2.y){
                return -1;
            }else{
                return 1;
            }
        }
    }
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Point arr[] = new Point[n];
        
        for(int i = 0;i<n;i++){
            String S[] = br.readLine().split(",");
            int x = Integer.parseInt(S[0]);
            int y = Integer.parseInt(S[1]);
            arr[i] = new Point(x,y);
        }
        
        int xmin,xmax;
        int ymin,ymax;
        
        Arrays.sort(arr,new CompareX());
        
        xmin = arr[0].x-1;
        xmax = arr[n-1].x+1;
        
        Arrays.sort(arr,new CompareY());
        try{
        ymin = arr[0].y-1;
        ymax = arr[n-1].y+1;
        
        System.out.println(xmin+","+ymin);
        System.out.println(xmax+","+ymax);
        }catch(IllegalArgumentException e){
            System.out.println(n);
        }
    }
}
