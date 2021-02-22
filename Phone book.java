import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<Integer,String> names = new HashMap();
        for(int i = 0; i < n;i++){
            String s = br.readLine();
            String [] S = s.split(" ");
            int num = Integer.parseInt(S[1]);
            String name = S[0];
            names.put(num,name);
        }
        n = Integer.parseInt(br.readLine());
        Map<Integer,Integer> count= new HashMap();
        for(int i = 0; i < n; i++){
            int temp = Integer.parseInt(br.readLine());
            if(!count.containsKey(temp)){
                count.put(temp,1);
            }else{
                count.replace(temp,count.get(temp)+1);
            }
        }
        int highest = Integer.MIN_VALUE;
        int key = 0;
        for(Integer k : count.keySet()){
            if(count.get(k)>highest){
                highest = count.get(k);
                key = k;
            }else if(count.get(k)==highest&&k<key){
                key = k;
            }
        }
        System.out.println(names.get(key));
    }
}
