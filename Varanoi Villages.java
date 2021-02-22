import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int [] pos = new int[n];
        for(int i = 0; i < n; i++){
            pos[i] = in.nextInt();
        }
        Arrays.sort(pos);
        double min = (double)Integer.MAX_VALUE;
        for(int i = 1; i < n-1;i++){
            double temp = ((double)pos[i+1]-pos[i-1])/2;
            if(temp<min){
                min = temp;
            }
        }
        System.out.format("%.1f", min);
    }
}
