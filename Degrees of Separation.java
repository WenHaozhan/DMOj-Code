import java.io.*;
import java.util.*;

public class Main {
    public static int n(int x, int [][] arr){
        int count = 0;
        for(int i = 0; i < arr.length;i++){
            if(arr[x][i]==1){
                count++;
            }
        }
        return count;
    }
    public static int f(int x, int [][]arr){
        int count = 0;
        ArrayList<Integer> friends = new ArrayList();
        boolean isvisited []= new boolean[arr.length];
        for(int i = 0; i < arr.length;i++){
            if(arr[x][i]==1){
                friends.add(i);
                isvisited[i]=true;
            }
        }
        
        for(Integer i:friends){
            for(int j = 0;j<arr.length;j++){
                if(arr[i][j]==1&&j!=x){
                    isvisited[j]=true;
                }
            }
        }
        for(int i = 0; i < isvisited.length;i++){
            if(isvisited[i]){
                count++;
            }
        }
        return count-n(x,arr);
    }
    public static String s(int x,int y,int[][]arr){
        int [] dist = new int[arr.length];
        boolean [] isvisited = new boolean[arr.length];
        for(int i = 0; i < arr.length;i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[x] = 0;
        for(int i = 0; i < arr.length-1;i++){
            int u = mindistance(dist,isvisited);
            isvisited[u]=true;
            for(int j = 0; j<arr.length;j++){
                if(!isvisited[j]&&arr[u][j]!=0&&dist[u]!=Integer.MAX_VALUE&&dist[j]>dist[u]+arr[u][j]){
                    dist[j] = arr[u][j]+dist[u];
                }
            }
        }
        if(dist[y]==Integer.MAX_VALUE){
            return "Not connected";
        }
        return ""+dist[y];
    }
    public static int mindistance(int [] dist,boolean[] isvisited){
        int min = Integer.MAX_VALUE;
        int index = -1;
        for(int i = 0; i < isvisited.length;i++){
            if(!isvisited[i]&&dist[i]<=min){
                min = dist[i];
                index = i;
            }
        }
        return index;
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int [][] friendships = new int[50][50];
        friendships[1][6]=1;friendships[6][1]=1;friendships[2][6]=1;friendships[6][2]=1;friendships[6][7]=1;friendships[7][6]=1;
        friendships[3][6]=1;friendships[6][3]=1;friendships[4][6]=1;friendships[6][4]=1;friendships[5][6]=1;friendships[6][5]=1;
        friendships[3][5]=1;friendships[5][3]=1;friendships[7][8]=1;friendships[8][7]=1;friendships[8][9]=1;friendships[9][8]=1;
        friendships[9][10]=1;friendships[10][9]=1;friendships[9][12]=1;friendships[12][9]=1;friendships[3][15]=1;friendships[15][3]=1;
        friendships[10][11]=1;friendships[11][10]=1;friendships[11][12]=1;friendships[12][11]=1;friendships[12][13]=1;friendships[13][12]=1;
        friendships[13][14]=1;friendships[14][13]=1;friendships[13][15]=1;friendships[15][13]=1;friendships[16][17]=1;friendships[17][16]=1;
        friendships[17][18]=1;friendships[18][17]=1;friendships[16][18]=1;friendships[18][16]=1;friendships[3][4]=1;friendships[4][3]=1;
        friendships[4][5]=1;friendships[5][4]=1;
        String s = br.readLine();
        while(!s.equals("q")){
            if(s.equals("i")){
                int x = Integer.parseInt(br.readLine());
                int y = Integer.parseInt(br.readLine());
                friendships[x][y]=1;
                friendships[y][x]=1;
            }else if(s.equals("d")){
                int x = Integer.parseInt(br.readLine());
                int y = Integer.parseInt(br.readLine());
                friendships[x][y]=0;
                friendships[y][x]=0;
            } else if(s.equals("n")){
                int x = Integer.parseInt(br.readLine());
                System.out.println(n(x,friendships));
            }else if(s.equals("f")){
                int x = Integer.parseInt(br.readLine());
                System.out.println(f(x,friendships));
            }else if(s.equals("s")){
                int x = Integer.parseInt(br.readLine());
                int y = Integer.parseInt(br.readLine());
                System.out.println(s(x,y,friendships));
            }
            s= br.readLine();
        }
    }
}
