import java.util.*;
import java.io.*;
public class MyClass {
    public static boolean isright(int [][] arr){
        for(int i = 0; i < arr.length;i++){
            int temp1 = arr[i][0];
            int temp2 = arr[0][i];
            for(int j = 1; j < arr.length;j++){
                if(temp1>arr[i][j]||temp2>arr[j][i]){
                    return false;
                }else{
                    temp1 = arr[i][j];
                    temp2 = arr[j][i];
                }
            }
        }
        return true;
    }
    public static void main(String args[]) throws IOException {
      BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
      String s = b.readLine();
      int n = Integer.parseInt(s);
      int arr[][] = new int[n][n];
      int arr1[] = new int[n*n];
      
      for(int i = 0; i < n;i++){
          s = b.readLine();
          String [] a = s.split(" ");
          for(int j = 0; j < n; j++){
              arr[i][j] = Integer.parseInt(a[j]);
          }
      }
      while(!isright(arr)){
          int temp [][] = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                temp[i][j] = arr[arr.length-j-1][i];
            }
        }
        arr = temp;
        
      }
      for(int i = 0; i < n; i++){
          for(int j = 0; j < n; j++){
              System.out.print(arr[i][j]+" ");
          }
          System.out.println("");
      }
      
    }
}
