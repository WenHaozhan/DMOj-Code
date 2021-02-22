import java.util.*;
import java.io.*;
public class MyClass {
    public static boolean corners(Integer[][] a){
        if(a[0][0]==null&&a[0][2]==null&&a[2][0]==null&&a[2][2]==null){
            return true;
        }
        return false;
    }
    public static int numNull(Integer [][] a){
        int count = 0;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(a[i][j]==null){
                    count++;
                }
            }
        }
        return count;
    }
    public static int numNull(Integer [] a){
        int count = 0;
        for(int i = 0; i < 3; i++){
                if(a[i]==null){
                    count++;
                }
        }
        return count;
    }
    public static void main(String args[]) throws IOException{
        Scanner input = new Scanner(System.in);
        Integer [][] arr = new Integer [3][3];
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                String s = input.next();
                if(s.equals("X")){
                    arr[i][j] = null;
                }else{
                    arr[i][j] = Integer.parseInt(s);
                }
            }
        }
        
        while(numNull(arr)!=0){
            if(numNull(arr)==9){
                for(int i = 0; i < 3; i++){
                    for(int j = 0; j < 3; j++){
                        arr[i][j] = 0;
                    }
                }
            }else if(numNull(arr)==8){
                int n = 0;
                for(int i = 0; i < 3; i++){
                    for(int j = 0; j < 3; j++){
                        if(arr[i][j] != null){
                            n = arr[i][j];
                        }
                    }
                }
                for(int i = 0; i < 3; i++){
                    for(int j = 0; j < 3; j++){
                        arr[i][j] = n;
                    }
                }
            }else{
                for(int i = 0; i < 3; i++){
                    if(numNull(arr[i])==1){
                        Integer f = arr[i][0]; Integer s = arr[i][1]; Integer t = arr[i][2];
                        if(f==null){
                            arr[i][0] = 2*s - t;
                        }else if(s==null){
                            arr[i][1] = f+(t-f)/2;
                        }else{
                            arr[i][2] = f+(s-f)*2;
                        }
                    }
                    Integer a [] = new Integer [3];
                    a[0] = arr[0][i]; a[1] = arr[1][i]; a[2] = arr[2][i];
                    if(numNull(a)==1){
                        Integer f = a[0]; Integer s = a[1]; Integer t = a[2];
                        if(f==null){
                            arr[0][i] = 2*s - t;
                        }else if(s==null){
                            arr[1][i] = f+(t-f)/2;
                        }else{
                            arr[2][i] = f+(s-f)*2;
                        }
                    }
                }
                if(arr[1][1]==null){
                        Integer n = arr[0][1];
                        if(arr[1][0]!=null){
                            n = arr[1][0];
                        }else if(arr[2][1]!=null){
                            n = arr[2][1];
                        }else if(arr[1][2]!=null){
                            n = arr[1][2];
                        }
                        arr[1][1] = n;
                }else if(arr[1][1]!=null&&numNull(arr)>3){
                    Integer n = arr[1][1];
                    if(arr[0][1]==null){
                        arr[0][1] = n;
                    }else if(arr[1][0]==null){
                        arr[1][0] = n;
                    }
                }
                if(corners(arr)){
                    arr[0][0]=0;
                }
                if(arr[1][1]==null){
                    arr[1][1] = 0;
                }
            }
        }
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println("");
        }
    }
}
