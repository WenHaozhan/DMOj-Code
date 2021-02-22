import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean [] arr = new boolean[200];
        for(int i = 2; i< 15;i++){
            if(!arr[i]){
                for(int j = i*i;j<200;j+=i){
                    arr[j] = true;
                }
            }
        }
        for(int i = 0; i < 5; i++){
            int n = input.nextInt();
            int secHigh=0, secLow=0;
            int count = 0;
            for(int j = n-1 ; j>=2;j--){
                if(!arr[j]&&count==0){
                    count++;
                }else if(!arr[j]&&count==1){
                    secLow = j;
                    break;
                }
            }
            count = 0;
            for(int j = n+1 ; j<200;j++){
                if(!arr[j]&&count==0){
                    count++;
                }else if(!arr[j]&&count==1){
                    secHigh = j;
                    break;
                }
            }
            if(secHigh-n <= n-secLow){
                System.out.println(secHigh);
            }else{
                System.out.println(secLow);
            }
        }
    }
}
