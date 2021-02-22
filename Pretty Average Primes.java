import java.io.*;
import java.util.*;

public class Main {
    public static Integer [] findPair(ArrayList<Integer> prime, int num){
        Integer [] pair = new Integer[2];
        for(int i = 0 ; i< prime.size();i++){
            int n = 2*num-prime.get(i);
            int index = Collections.binarySearch(prime,n);
            if(index>=0){
                pair[0]=prime.get(i);
                pair[1] = prime.get(index);
                return pair;
            }
        }
        return pair;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean arr[] = new boolean[2000001];
        for(int i = 2; i*i <= arr.length;i++){
            if(!arr[i]){
                for(int j = i*i; j<arr.length;j+=i){
                    arr[j] = true;
                }
            }
        }
        ArrayList<Integer> prime = new ArrayList();
        for(int i = 2; i < arr.length;i++){
            if(!arr[i]){
                prime.add(i);
            }
        }
        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(br.readLine());
            Integer [] pair = findPair(prime, num);
            System.out.println(pair[0]+" "+pair[1]);
        }
    }
}
