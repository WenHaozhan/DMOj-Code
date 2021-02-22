import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        for(int i = 0; i < 5 ; i++){
            String s = input.nextLine();
            s +=' ';
            int count = 0;
            int len = 0;
            for(int j = 0; j < s.length();j++){
                if((s.charAt(j)>='A'&&s.charAt(j)<='Z')||(s.charAt(j)>='a'&&s.charAt(j)<='z')){
                    len++;
                }else{
                    if(len>=4){
                        count++;
                    }
                    len = 0;
                }
            }
            System.out.println(count);
        }
    }
}
