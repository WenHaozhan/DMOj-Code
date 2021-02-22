import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String [] S = s.split(" ");
        int n = Integer.parseInt(S[0]);
        int q = Integer.parseInt(S[1]);
        int [] episode = new int[n];
        s = br.readLine();
        S = s.split(" ");
        for(int i = 0; i < n; i++){
            episode[i] = Integer.parseInt(S[i]);
        }
        int [] maxleft , maxright, freqleft,freqright;
        maxleft = new int[n]; maxright=new int[n]; freqleft = new int[n]; freqright = new int[n];
        maxleft[0] = episode[0];
        maxright[n-1] = episode[n-1];
        for(int i = 1; i < n; i++){
            maxleft[i] = Math.max(maxleft[i-1],episode[i]);
        }
        for(int i = episode.length-2; i>=0;i--){
            maxright[i] = Math.max(maxright[i+1],episode[i]);
        }
        int highest = 0;
        int count = 1;
        for(int i = 0 ;i<n;i++){
            if(episode[i]>highest){
                highest = episode[i];
                count = 1;
            }else if(episode[i]==highest){
                count++;
            }
            freqleft[i]=count;
        }
        highest = 0;
        count = 1;
        for(int i = episode.length-1 ;i>=0;i--){
            if(episode[i]>highest){
                highest = episode[i];
                count = 1;
            }else if(episode[i]==highest){
                count++;
            }
            freqright[i]=count;
        }
        for(int i = 0; i < q;i++){
            s = br.readLine();
            S = s.split(" ");
            int l = Integer.parseInt(S[0])-1;
            int r = Integer.parseInt(S[1])-1;
            int left = 0,right = 0;
            int countleft=0,countright=0;
            if(l-1>=0){
                left = maxleft[l-1];
                countleft = freqleft[l-1];
            }
            if(r+1<episode.length){
                right = maxright[r+1];
                countright = freqright[r+1];
            }
            int rating = Math.max(left,right);
            int num;
            if(left>right){
                num=countleft;
            }else if(left<right){
                num=countright;
            }else{
                num=countleft+countright;
            }
            
            System.out.println(rating+" "+num);
        }
    }
}
