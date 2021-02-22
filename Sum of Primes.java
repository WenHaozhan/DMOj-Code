import java.io.*;
import java.util.*;

public class  SumofPrime{
    public static ArrayList<Integer> findSum(boolean arr[], int num, ArrayList<Integer> prime){
        ArrayList<Integer> sums = new ArrayList();
        if(!arr[num]){
            sums.add(num);
            return sums;
        }
        int a = Collections.binarySearch(prime,num/2);
        if(a<0){
            a = -a -2;
        }
        for(int i = a; i >=0;i--){
            int temp = num - prime.get(i);
            if(!arr[temp]){
                sums.add(prime.get(i));
                sums.add(temp);
                return sums;
            }
        }
        a = Collections.binarySearch(prime, num/3);
        if(a<0){
            a = -a-2;
        }
        for(int i = a; i >=0;i--){
            int tempb = num -prime.get(i);
            int b = Collections.binarySearch(prime,tempb/2);
            if(b<0){
                b = -b -2;
            }
            for(int j = b; j >=i ; j--){
                int temp = num - prime.get(i)-prime.get(j);
                if(!arr[temp]){
                    sums.add(prime.get(i));
                    sums.add(prime.get(j));
                    sums.add(temp);
                    return sums;
                }
            }
        }
        return sums;
    }
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean arr[] = new boolean[10000001];
        for(int i = 2; i*i <= arr.length;i++){
            if(!arr[i]){
                for(int j = i*i; j<arr.length;j+=i){
                    arr[j] = true;
                }
            }
        }
        arr[2] = true;
        ArrayList<Integer> prime = new ArrayList();
        for(int i = 2; i < arr.length;i++){
            if(!arr[i]){
                prime.add(i);
            }
        }
        for(int i = 0; i < 5; i++){
            int num = Integer.parseInt(br.readLine());
            ArrayList<Integer> sums = findSum(arr,num,prime);
            String s = num +" = ";
            for(int j = 0; j < sums.size() -1;j++){
                s += sums.get(j)+" + ";
            }
            s+= sums.get(sums.size()-1);
            System.out.println(s);
        }        
    }
}
