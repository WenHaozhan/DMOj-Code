import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            String [] S = s.split(" ");
            Arrays.sort(S);
            String temp = "";
            int count = 0;
            for(int j=0;j<=S.length;j++){
                if(count==2){
                    System.out.println(temp);
                    break;
                }
                if(j==S.length){
                    System.out.println("???");
                    break;
                }
                if(S[j].equals(temp)){
                    count++;
                }else{
                    temp = S[j];
                    count=1;
                }
            }
        }
    }
}
