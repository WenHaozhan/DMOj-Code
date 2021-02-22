import java.io.*;
import java.util.*;

public class Main {
    public static int bfs(int r,int c, char[][]rooms,boolean[][]isvisited){
        int count = 0;
        isvisited[r][c] = true;
        Queue<Integer> row = new LinkedList();
        Queue<Integer> col = new LinkedList();
        row.add(r);col.add(c);
        while(!row.isEmpty()){
            int i = row.poll();int j = col.poll();
            count++;
            if(j+1<rooms[i].length&&rooms[i][j+1]=='.'&&!isvisited[i][j+1]){
                isvisited[i][j+1]=true;
                row.add(i);col.add(j+1);
            }
            if(j-1>=0&&rooms[i][j-1]=='.'&&!isvisited[i][j-1]){
                isvisited[i][j-1]=true;
                row.add(i);col.add(j-1);
            }
            if(i-1>=0&&rooms[i-1][j]=='.'&&!isvisited[i-1][j]){
                isvisited[i-1][j]=true;
                row.add(i-1);col.add(j);
            }
            if(i+1<rooms.length&&rooms[i+1][j]=='.'&&!isvisited[i+1][j]){
                isvisited[i+1][j]=true;
                row.add(i+1);col.add(j);
            }
        }
        return count;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int floor = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        char[][] rooms= new char[n][m];
        for(int i = 0; i < n; i++){
            rooms[i] = br.readLine().toCharArray();
        }
        boolean isvisited[][] = new boolean[n][m];
        ArrayList<Integer> roomsize = new ArrayList();
        for(int i = 0; i<n;i++){
            for(int j = 0; j < m;j++){
                if(rooms[i][j]=='.'&&!isvisited[i][j]){
                    int size = bfs(i,j,rooms,isvisited);
                    roomsize.add(size);
                }
            }
        }
        Collections.sort(roomsize);
        int count = 0;
        for(int i = roomsize.size()-1;i>=0;i--){
            if(floor>=roomsize.get(i)){
                count++;
                floor-=roomsize.get(i);
            }else{
                break;
            }
        }
        if(count==1){
            System.out.println(count+" room, "+floor+" square metre(s) left over");
        }else{
            System.out.println(count+" rooms, "+floor+" square metre(s) left over");
        }
    }
}
