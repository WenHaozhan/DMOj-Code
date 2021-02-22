import java.io.*;
import java.util.*;

public class Main {
    public static boolean isPrime(int n){
        for(int i = 2; i <= n/2;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        for(int j = 0; j < 5; j++){
            int n = in.nextInt();
            int num = 0;
            while(n>1){
                for(int i = 2; i <= n;i++){
                    if(n%i==0&&isPrime(i)){
                        if(i!=n){
                            num++;
                        }
                        n/=i;
                    }
                }
            }
            if(num!=0){
                num++;
            }
            System.out.println(num);
        }
    }
}
