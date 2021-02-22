import java.util.Scanner;
/**
 *
 * @author WenHao
 */

public class Ccc13s3 {

    /**
     * @param games
     * @param args the command line arguments
     */
    public static int outcomes(int games, int favourite, int t1, int t2,int win, int [] t, int w[][]){
        int arr[] = new int[4];
            for(int i = 0; i< 4; i++){
                arr[i] = t[i];
            }
            if(win == t1){
                arr[t1]+=3;
            }else if(win == t2){
                arr[t2] +=3;
            }else{
                arr[t1]++;
                arr[t2]++;
            }
            int wins[][] = new int[4][4];
            for(int i = 0; i < 4; i++){
                for(int j = 0; j < 4; j++){
                    wins[i][j] = w[i][j];
                }
            }
        if(games == 6){
            for(int i = 0; i <4; i++){
                if(i != favourite){
                    if(arr[favourite]<= arr[i]){
                        return 0;
                    }
                }
            }
            return 1;
        }else{
            
            int team1 = 0, team2=0;
            for(int i = 0; i < 3; i++){
                for(int j = 1; j < 4; j++){
                    if(wins[i][j]==0&& i!=j){
                        team1 = i;
                        team2 = j;
                    }
                }
            }
            wins[team1][team2] = -1;
            wins[team2][team1] = -1;
            return (outcomes(games+1, favourite,team1, team2,team1, arr, wins) + outcomes(games+1, favourite, team1, 
                    team2,team2, arr, wins)+outcomes(games+1,favourite,team1, team2,-1, arr,wins ));
        }
        
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int fav = input.nextInt()-1;
        int played = input.nextInt();
        int [] score = new int[4];
        int winner[][] = new int [4][4];
        for(int i = 0; i < played; i++){
            int t1 = input.nextInt() -1;
            int t2 = input.nextInt() -1;
            int s1 = input.nextInt();
            int s2 = input.nextInt();
            
            if(s1>s2){
                score[t1]+=3;
                winner[t1][t2]= t1;
                winner[t2][t1] = t1;
            }else if(s2>s1){
                score[t2]+=3;
                winner[t1][t2] = t2;
                winner[t2][t1] = t2;
            }else{
                score[t1]++;
                score[t2]++;
                winner[t1][t2] = -1;
                winner[t2][t1] = -1;
            }
        }
        int t1 = 0, t2 = 0;
        for(int i = 0; i < 4; i++){
                for(int j = 0; j < 4; j++){
                    if(winner[i][j]==0&&i!=j){
                        t1 = i;
                        t2 = j;
                    }
                }
            }
        winner[t1][t2] = -1;
        winner[t2][t1] = -1;
        System.out.println(outcomes(played+1, fav, t1,t2,t1,score, winner)+
                outcomes(played+1, fav, t1,t2,t2,score, winner)+
                outcomes(played+1, fav, t1,t2,-1,score, winner));
 
        
    }
    
}
