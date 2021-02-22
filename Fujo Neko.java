import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String S [] = s.split(" ");
        int R = Integer.parseInt(S[0]);
        int C = Integer.parseInt(S[1]);
        char [][] f = new char[R][C];
        for(int i = 0; i < R; i++){
            s = br.readLine();
            for(int j = 0; j <s.length();j++){
                f[i] = s.toCharArray();
            }
        }
        
        int q = Integer.parseInt(br.readLine());
        for(int i = 0; i < q; i++){
            s = br.readLine();
            S = s.split(" ");
            int x = Integer.parseInt(S[0])-1;
            int y = Integer.parseInt(S[1])-1;
            boolean b = false;
            for(int j = 0; j<f.length;j++){
                if(f[j][x]=='X'){
                    b = true;
                    break;
                }
            }
            for(int j = 0; j < f[0].length;j++){
                if(f[y][j]=='X'){
                    b = true;
                    break;
                }
            }
            if(b){
                System.out.println("Y");
            }else{
                System.out.println("N");
            }
        }
        
    }
}
