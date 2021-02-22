import java.util.*;

public class Question2 {
    public static void main(String[] args) {
        int sum [] = new int[101];
        sum[1] = 1;
        for(int i = 2; i < 101; i++){
            sum[i] = sum[i-1]+i;
        }
        Scanner input = new Scanner(System.in);
        for(int i = 0; i < 5;i++){
            int n = input.nextInt();
            int total = 0;
            for(int j = 0; j < n; j++){
                int temp = input.nextInt();
                total += temp;
            }
            System.out.println(sum[n+1]-total);
            
        }
    }
    
}
