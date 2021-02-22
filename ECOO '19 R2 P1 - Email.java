import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 10;i++){
            int n = Integer.parseInt(br.readLine());
            String [] arr = new String[n];
            for(int j = 0; j < n;j++){
                String s = br.readLine();
                boolean at = false;
                boolean plus = false;
                s = s.toLowerCase();
                String temp = "";
                for(int k = 0;k<s.length();k++){
                    if(s.charAt(k)=='+'){
                        plus = true;
                    }    else if (s.charAt(k)=='@'){
                        at = true;
                    }
                    if(s.charAt(k)=='.'&&!at||plus&&!at){
                        continue;
                    }
                    temp+=s.charAt(k);
                    
                }
                arr[j]=temp;
                
            }
            Arrays.sort(arr);
                int count = 0;
                String last = "";
                for(int j = 0; j < arr.length;j++){
                    if(!arr[j].equals(last)){
                        count++;
                        last = arr[j];
                    }
                }
            System.out.println(count);
        }
    }
}
