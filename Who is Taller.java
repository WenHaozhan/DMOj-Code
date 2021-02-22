import java.util.*;
import java.io.*;
public class MyClass {
    public static boolean all(boolean [] isvisited){
        for(int i = 0; i < isvisited.length;i++){
            if(!isvisited[i])return false;
        }
        return true;
    }
    public static boolean dfs(byte [][] arr, int u, boolean [] noisy){
        boolean isvisited [] = new boolean[arr.length];
        
        Stack<Integer> s = new Stack();
        
        s.push(u);
        while(!s.isEmpty()){
            int v = s.pop();
            noisy[v] = false;
            isvisited[v] = true;
            for(int i = 0; i < arr.length;i++){
                if(!isvisited[i]&&arr[v][i]==1){
                    s.push(i);
                    for(int j = 0; j < arr.length;j++){
                        if(arr[i][j]==1){
                            noisy[j] = true;
                        }
                    }
                }
            }
            if(s.isEmpty()&&!all(isvisited)){
                for(int i = 0; i < isvisited.length;i++){
                    if(!isvisited[i]){
                        s.push(i);
                        break;
                    }
                }
            }
        }
        for(int i = 0; i < noisy.length; i++){
            if(noisy[i]){
                return false;
            }
        }
        return true;
    }
    public static void main(String args[]) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String line = br.readLine();
        int n = Integer.parseInt(line);
        line = br.readLine();
        int m = Integer.parseInt(line);
        byte [][] arr = new byte[n][n];
        boolean [] noisy = new boolean [n];
        for(int i = 0; i < m; i++){
            line = br.readLine();
            String [] s = line.split(" ");
            int u = Integer.parseInt(s[0])-1;
            int v = Integer.parseInt(s[1])-1;
            arr[u][v] = 1;
        }
        if(dfs(arr,0,noisy)){
            System.out.println("Y");
        }else{
            System.out.println("N");
        }
      
    }
}
