import java.io.*;
import java.util.*;

public class Main {
    public static void scramble(String s, int l){
        if(l==1){
            System.out.println(s);
            return;
        }
        for(int i = s.length()-l;i<s.length();i++){
            String temp = s.substring(0,s.length()-l)+s.charAt(i)+s.substring(s.length()-l,i)+s.substring(i+1);
            scramble(temp,l-1);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().toLowerCase();
        char [] c = s.toCharArray();
        Arrays.sort(c);
        s = new String(c);
        scramble(s,s.length());
        
    }
}
