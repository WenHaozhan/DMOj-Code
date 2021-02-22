import java.io.*;
import java.util.*;

public class Main {
    public static int minIndex(int [] dist, boolean [] isVisited){
        int index = -1;
        int value = Integer.MAX_VALUE;
        for(int i = 0; i < isVisited.length;i++){
            if(!isVisited[i]&&value>=dist[i]){
                index = i;
                value = dist[i];
            }
        }
        return index;
    }
    
    public static int dijekstra(int [][] arr, int start, int end){
        boolean []isVisited = new boolean[arr.length];
        int [] values = new int[arr.length];
        for(int i = 0; i < values.length;i++){
            values[i] = Integer.MAX_VALUE;
        }
        values[start] = 0;
        for(int i = 0; i < arr.length-1;i++){
            int current = minIndex(values, isVisited);
            isVisited[current] = true;
            for(int j = 0; j < 4; j++){
                int v=0;
                if(j==0&& 3*(current)<arr.length){
                    v = current*3;
                    if(!isVisited[v]&&arr[current][0]!=0&&values[v]>values[current]+arr[current][0]){
                    values[v] = values[current]+arr[current][0];
                }
                    
                }else if(j==1&&current-1>0){
                    v = current-1;
                    if(!isVisited[v]&&arr[current][1]!=0&&values[v]>values[current]+arr[current][1]){
                        values[v] = values[current]+arr[current][1];
                    }
                }else if(j==2&&current-3>0){
                    v = current-3;
                    if(!isVisited[v]&&arr[current][2]!=0&&values[v]>values[current]+arr[current][2]){
                        values[v] = values[current]+arr[current][2];
                    }
                }else if(j==3&&(current)%2==0&&(1+current)>0){
                    v = current /2;
                    if(!isVisited[v]&&arr[current][3]!=0&&values[v]>values[current]+arr[current][3]){
                        values[v] = values[current]+arr[current][3];
                    }
                }
                
            }
        }
        return values[end];
        
    }
    public static int bfs(int [][] arr, int start, int end){
        boolean isvisited [] = new boolean[arr.length];
        int values [] = new int[arr.length];
        for(int i = 0; i < values.length;i++){
            values[i] = Integer.MAX_VALUE;
        }
        
        Queue<Integer> q = new LinkedList();
        isvisited[start] = true;
        values[start] = 0;
        q.add(start);
        
        while(!q.isEmpty()){
            int current = q.poll();
            
            for(int j = 0; j < 4; j++){
                int v=0;
                if(j==0&&3*current<arr.length){
                    v = current*3;
                }else if(j==1&&current-1>1){
                    v = current-1;
                }else if(j==2&&current-3>1){
                    v = current -3;
                }else if(current%2==0){
                    v=current/2;
                }

                if(!isvisited[v]&&arr[current][j]!=0){
                    values[v] = values[current]+1;
                    isvisited[v] = true;
                    q.add(v);
                    if(v==end){
                        return values[v];
                    }
                }
                
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
      int n = input.nextInt();
      int m = input.nextInt();
      int max;
      if(n>=m){
          max = 3*n;
      }else{
          max = 3*m;
      }
      if(max>10000000){
          max = 10000000;
      }
      int [][] board = new int [max][4];
      for(int i = 1; i < max;i++){
          if(3*i<board.length){
              board[i][0]=1;
          }
          if(i-1>1){
              board[i][1]=1;
          }
          if(i-3>1){
              board[i][2]=1;
          }
          if(i%2==0&&i>0){
              board[i][3]=1;
          }
      }
      System.out.println(bfs(board,n,m));
    }
}
