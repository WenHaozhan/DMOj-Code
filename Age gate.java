import java.util.*;
import java.io.*;

public class Question1 {
    public static void main(String [] args) throws IOException{
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 5; i++){
            String s = b.readLine();
            String [] S = s.split(" ");
            int day = Integer.parseInt(S[0]);
            int month = Integer.parseInt(S[1]);
            int year = Integer.parseInt(S[2]);
            if(2010-year>13){
                System.out.println("old enough");
            }else if(2010-year==13){
                if(month-10<0){
                    System.out.println("old enough");
                }else if (month==10){
                    if(day<=27){
                        System.out.println("old enough");
                    }else{
                         System.out.println("too young");
                    }
                }else{
                    System.out.println("too young");
                }
            }else{
                System.out.println("too young");
            }
        }
    }
}
