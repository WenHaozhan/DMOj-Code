import java.util.*;
import java.util.Arrays;
public class MyClass {
    public static boolean isequal(int a1 [] , int a2[]){
        for(int i = 0; i < 26; i++){
            if(a1[i]!=a2[i]){
                return false;
            }
        }
        return true;
    }
    public static void main(String args[]) {
      Scanner input = new Scanner(System.in);
      String N = input.nextLine();
      String H = input.nextLine();

      int count = 0;
      
      TreeSet <Long> s = new TreeSet();

      int [] n = new int[26];

        for(int i = 0; i < N.length();i++){
            n[N.charAt(i)-'a']++;
        }
        int[] f = new int[26];
        int start = 0;
          int end = N.length()-1;
          if(N.length()>H.length()){
              System.out.println(0);
              System.exit(0);
          }
          for(int i = 0;i<N.length();i++){
              f[H.charAt(i)-'a']++;
          }
          Long  mod = (long)(Math.pow(2,48))-59,temp = H.charAt(0)*31%mod;

          for(int j = 1; j < N.length()-1;j++){
              temp = (temp+H.charAt(j))%mod*31%mod;

          }
          temp = (temp+H.charAt(N.length()-1))%mod;

          if(isequal(f,n)&&!s.contains(temp)){
              s.add(temp);

              count++;
          }
          Long offset = 1L;
          for(int i = 0;i<N.length()-1;i++){
              offset = (offset*31)%mod;

          }
      for(int i = 1; i <= H.length()-N.length(); i++){
          f[H.charAt(start)-'a']--;
          end++;
          start++;
          f[H.charAt(end)-'a']++;
          
          temp = ((temp+mod- H.charAt(start-1)*offset%mod)%mod*31+H.charAt(end))%mod;
          if(isequal(f,n)&&!s.contains(temp)){
              s.add(temp);

              count++;
              //System.out.println(H.substring(start,end+1));
              
          }
      }
      System.out.println(count);
    }
    
}
