import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for(int i = n; i <= Integer.MAX_VALUE;i++){
            int temp = i;
            if(i==1){
                continue;
            }else if(i==2){
                System.out.println(2);
                break;
            }
            if(temp%2==0){
                temp/=2;
            }
            for(int j = 3; j<=Math.sqrt(i);j+=2){
                if(temp%j==0){
                    temp/=j;
                }
            }
            if(temp == i){
                System.out.println(i);
                break;
            }
        }
    }
}
