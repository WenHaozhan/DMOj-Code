import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        while(!s.equals("0")){
            String [] S = s.split(" ");
            ArrayList<String> list = new ArrayList();
            for(int i = 0; i < S.length;i++){
                list.add(S[i]);
            }
            for(int i = list.size()-1;i>=0;i--){
                if(list.get(i).equals("-")||list.get(i).equals("+")){
                    String temp = list.get(i+1)+" "+list.get(i+2)+" "+list.get(i)+" ";
                    list.set(i,temp);
                    list.remove(i+1);
                    list.remove(i+1);
                }
            }
            System.out.println(list.get(0).trim());
            s = br.readLine();
        }
    }
}
