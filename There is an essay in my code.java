import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        for(int i = 0; i < 5; i++){
            String s = in.nextLine();
            String temp = "";
            for(int j = 0; j < s.length();j++){
                char c = s.charAt(j);
                if(c=='\"'){
                    temp+= s.substring(j+1,s.indexOf(c,j+1))+" ";
                    j = s.indexOf(c,j+1)+1;
                }else if(c=='\''){
                    temp+= s.substring(j+1,s.indexOf(c,j+1))+" ";
                    j = s.indexOf(c,j+1)+1;
                }else if(c=='/'){
                    if(s.charAt(j+1)=='/'){
                        temp+= s.substring(j+2);
                        break;
                    }else if(s.charAt(j+1)=='*'){
                        temp += s.substring(j+2, s.indexOf("*/",j+1))+" ";
                        j = s.indexOf("*/",j+1)+2;
                    }
                }
            }
            temp = temp.trim();
            System.out.println(temp);
        }
    }
}
