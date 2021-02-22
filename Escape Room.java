import java.io.*;
import java.util.*;
public class MyClass {
    public static boolean bfs(int [][] arr){
        boolean [][] isvisited = new boolean[arr.length][arr[0].length];
        Queue<Integer> r = new LinkedList();
        Queue<Integer> c = new LinkedList();
        r.add(0);
        c.add(0);
        isvisited[0][0] = true;
        boolean []calculated = new boolean[1000001];
        while(!r.isEmpty()){
            int R = r.poll();
            int C = c.poll();
            int X = arr[R][C];
            
            if(calculated[X]){
                continue;
            }
            calculated[X] = true;
            int max = (int)Math.sqrt(X);
            for(int i = max; i >0 ; i--){
                if(X%i==0){
                    int j = X/i;
                    if(i == arr.length && j == arr[0].length||j == arr.length && i == arr[0].length){
                        return true;
                    }
                    if(i<=arr.length&&j<=arr[0].length&&!isvisited[i-1][j-1]){
                        r.add(i-1);
                        c.add(j-1);
                        isvisited[i-1][j-1] = true;
                    }
                    if(i<=arr[0].length&&j<=arr.length&&!isvisited[j-1][i-1]){
                        r.add(j-1);
                        c.add(i-1);
                        isvisited[j-1][i-1] = true;
                    }
                }
            }
        }
        return false;
    }
    public static void main(String args[]) throws IOException{
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        String s = b.readLine();
        int n = Integer.parseInt(s);
        s = b.readLine();
        int m = Integer.parseInt(s);
        int [][] arr = new int[n][m];
        for(int i = 0; i < n; i++){
            s = b.readLine();
            String [] a = s.split(" ");
            for(int j = 0; j < m; j++){
                arr[i][j] = Integer.parseInt(a[j]);
            }
        }
        if(bfs(arr)){
            System.out.println("yes");
        }else{
            System.out.println("no");
        }     //System.out.println(bfs(arr,0,0)? "yes":"no");
    }
}
