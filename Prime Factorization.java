import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            int n = Integer.parseInt(br.readLine());
            while (n%2==0) 
        { 
            System.out.print(2 + " "); 
            n /= 2; 
        } 
        for (int j = 3; j <= Math.sqrt(n); j+= 2) 
        { 
            while (n%j == 0) 
            { 
                System.out.print(j + " "); 
                n /= j; 
            } 
        } 
        if (n > 2) 
            System.out.print(n); 
            
        System.out.println("");
        }
        
    }
}
