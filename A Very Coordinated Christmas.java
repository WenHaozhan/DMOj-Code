import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String [] S = s.split(" ");
        int n = Integer.parseInt(S[0]);
        int m = Integer.parseInt(S[1]);
        char [][] arr = new char[n][m];
        int rp=0,cp=0;
        int rs=0,cs=0;
        int rx=0,cx=0;
        for(int i = 0; i < n; i++){
            s = br.readLine();
            arr[i] = s.toCharArray();
            if(s.indexOf("O")>-1){
                rs = i;
                cs = s.indexOf("O");
            }
            if(s.indexOf("P")>-1){
                rp = i;
                cp = s.indexOf("P");
            }
            if(s.indexOf("X")>-1){
                rx = i;
                cx = s.indexOf("X");
            }
        }
        boolean isvisited[][] = new boolean[n][m];
        Queue<Integer> row = new LinkedList();
        Queue<Integer> col = new LinkedList();
        isvisited[rs][cs]=true;
        int [][] dist = new int[n][m];
        row.add(rs);col.add(cs);
        while(!row.isEmpty()){
            int r = row.poll();
            int c = col.poll();
            if(r==rp&&c==cp){
                break;
            }
            if(!isvisited[r][c+1]&&arr[r][c+1]!='#'){
                row.add(r);
                col.add(c+1);
                isvisited[r][c+1]=true;
                dist[r][c+1] = dist[r][c]+1;
            }
            if(!isvisited[r][c-1]&&arr[r][c-1]!='#'){
                row.add(r);
                col.add(c-1);
                isvisited[r][c-1]=true;
                dist[r][c-1] = dist[r][c]+1;
            }
            if(!isvisited[r+1][c]&&arr[r+1][c]!='#'){
                row.add(r+1);
                col.add(c);
                isvisited[r+1][c]=true;
                dist[r+1][c] = dist[r][c]+1;
            }
            if(!isvisited[r-1][c]&&arr[r-1][c]!='#'){
                row.add(r-1);
                col.add(c);
                isvisited[r-1][c]=true;
                dist[r-1][c] = dist[r][c]+1;
            }
        }
        boolean [][]isvisitedx = new boolean[n][m];
        int [][] distx = new int[n][m];
        row = new LinkedList();
        col = new LinkedList();
        isvisited[rp][cp]=true;
        row.add(rp);col.add(cp);
        while(!row.isEmpty()){
            int r = row.poll();
            int c = col.poll();
            if(r==rx&&c==cx){
                break;
            }
            if(!isvisitedx[r][c+1]&&arr[r][c+1]!='#'){
                row.add(r);
                col.add(c+1);
                isvisitedx[r][c+1]=true;
                distx[r][c+1] = distx[r][c]+1;
            }
            if(!isvisitedx[r][c-1]&&arr[r][c-1]!='#'){
                row.add(r);
                col.add(c-1);
                isvisitedx[r][c-1]=true;
                distx[r][c-1] = distx[r][c]+1;
            }
            if(!isvisitedx[r+1][c]&&arr[r+1][c]!='#'){
                row.add(r+1);
                col.add(c);
                isvisitedx[r+1][c]=true;
                distx[r+1][c] = distx[r][c]+1;
            }
            if(!isvisitedx[r-1][c]&&arr[r-1][c]!='#'){
                row.add(r-1);
                col.add(c);
                isvisitedx[r-1][c]=true;
                distx[r-1][c] = distx[r][c]+1;
            }
        }
        if(isvisited[rp][cp]&&isvisitedx[rx][cx]){
            System.out.println(dist[rp][cp]+distx[rx][cx]);
        }else{
            System.out.println(-1);
        }
    }
}
