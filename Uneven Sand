import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int l = 1, r = 2000000000;
        int m = (l+r)/2;
        while(l<=r){
            m = l + (r-l)/2;
            System.out.println(m);
            System.out.flush();
            String s = br.readLine();
            if(s.equals("SINKS")){
                l = m+1;
            }else if(s.equals("FLOATS")){
                r = m-1;
            }else{
                break;
            }
        }
        System.out.println(2000000000);
    }
}
