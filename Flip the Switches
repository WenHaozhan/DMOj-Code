import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        int num = 0;
        int lastnum = 0;
        if(s.charAt(n-1)=='1'){
            num++;
            lastnum = 1;
        }
        for(int i = n-2;i>=0;i--){
            if(s.charAt(i)-'0'!=lastnum){
                num++;
                lastnum = s.charAt(i)-'0';
            }
        }
        System.out.println(num);
    }    
}
