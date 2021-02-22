import java.util.*;
import java.io.*;
public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        String s= b.readLine();
        String [] a = s.split(" ");
        int n = Integer.parseInt(a[0]);
        int m = Integer.parseInt(a[1]);
        char [][] f = new char[n][m];
        int [][] v = new int[n][m];
        Queue<Integer> r = new LinkedList();
        Queue<Integer> c = new LinkedList();
        for(int i = 0; i < n; i++){
            s = b.readLine();
            char [] temp = s.toCharArray();
            f[i] = temp;
            for(int j = 0; j < m; j++){
                if(f[i][j]=='W'){
                    v[i][j] = Integer.MAX_VALUE;
                }else if(f[i][j]=='C'){
                    v[i][j] = Integer.MIN_VALUE;
                }else if(f[i][j]=='S'){
                    r.add(i);
                    c.add(j);
                }
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(f[i][j] == 'C'){
                int R = i;
                    int C = j;
                    
                    while(true){
                        R++;
                        if(R<f.length&&R>=0&&C<f[0].length&&C>=0){
                            if(f[R][C]=='.'||f[R][C]=='S'){
                                v[R][C] = Integer.MAX_VALUE;
                            }else if(f[R][C]=='W'){
                                break;
                            }
                        }else{
                            break;
                        }
                        
                    }
                    R=i;C=j;
                    while(true){
                        R--;
                        if(R<f.length&&R>=0&&C<f[0].length&&C>=0){
                            if(f[R][C]=='.'||f[R][C]=='S'){
                                v[R][C] = Integer.MAX_VALUE;
                            }else if(f[R][C]=='W'){
                                break;
                            }
                        }else{
                            break;
                        }
                        
                    }
                    R=i;C=j;
                    while(true){
                        C++;
                        if(R<f.length&&R>=0&&C<f[0].length&&C>=0){
                            if(f[R][C]=='.'||f[R][C]=='S'){
                                v[R][C] = Integer.MAX_VALUE;
                            }else if(f[R][C]=='W'){
                                break;
                            }
                        }else{
                            break;
                        }
                        
                    }
                    R=i;C=j;
                    while(true){
                        C--;
                        if(R<f.length&&R>=0&&C<f[0].length&&C>=0){
                            if(f[R][C]=='.'||f[R][C]=='S'){
                                v[R][C] = Integer.MAX_VALUE;
                            }else if(f[R][C]=='W'){
                                break;
                            }
                        }else{
                            break;
                        }
                        
                    }
                }
            }
        }
        boolean [][] isvisited = new boolean[n][m];
        isvisited[r.peek()][c.peek()] = true;
        while(!r.isEmpty()){
            int R = r.poll();
            int C = c.poll();
            ArrayList<Integer []> temp = new ArrayList<>();
            temp.add(move(R-1,C,f,v));
            temp.add(move(R+1,C,f,v));
            temp.add(move(R,C-1,f,v));
            temp.add(move(R,C+1,f,v));
            
            for(int i = 0; i < 4;i++){
                if(temp.get(i)[0]!=-1){
                    int R1 = temp.get(i)[0];
                    int C1 = temp.get(i)[1];
                    if(!isvisited[R1][C1]&&v[R1][C1]!=Integer.MAX_VALUE&&v[R][C]!=Integer.MAX_VALUE){
                        r.add(R1);
                        c.add(C1);
                        isvisited[R1][C1]=true;
                        v[R1][C1] = v[R][C]+1;
                    }
                    
                }
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(f[i][j]=='.'&&v[i][j]==0){
                    v[i][j]=-1;
                }else if(f[i][j]=='.'&&v[i][j]==Integer.MAX_VALUE){
                    v[i][j]=-1;
                }
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(f[i][j]=='.'){
                    System.out.println(v[i][j]);
                }
            }
        }

    }
    public static Integer [] move(int r, int c, char[][]f,int [][]v){
        Integer [] temp = new Integer[2];
        temp[0] = -1;
        if(r<f.length&&r>=0&&c<f[0].length&&c>=0){
            if(f[r][c]=='.'&&v[r][c]==-1||f[r][c] == 'W'){
                return temp;
            }else if(f[r][c]=='.'&&v[r][c]==0){
                temp[0] = r;
                temp[1] = c;
                return temp;
            }else{
                while(true){
                    if(f[r][c]=='W'||f[r][c]=='.'||f[r][c]=='C'||f[r][c]=='S'){
                        break;
                    }
                    if(r<f.length&&r>=0&&c<f[0].length&&c>=0){
                        if(f[r][c] == 'L'){
                            c--;
                            if(f[r][c]=='R'){
                              break;
                            }
                        }else if(f[r][c]=='R'){
                            c++;
                            if(f[r][c]=='L'){
                              break;
                            }
                        }else if(f[r][c]=='U'){
                            r--;
                            if(f[r][c]=='D'){
                              break;
                            }
                        }else if(f[r][c] == 'D'){
                            r++;
                            if(f[r][c]=='U'){
                              break;
                            }
                        }
                    }
                }
                if(f[r][c] =='.'){
                    temp[0]=r;
                    temp[1]=c;
                }
                return temp;
            } 
        }
        return temp;
    }
    
}
