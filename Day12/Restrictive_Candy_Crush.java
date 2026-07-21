import java.util.*;
public class Restrictive_Candy_Crush {
    public static int candyCrush(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean found = true;
        while(found){
            found = false;
            boolean[][] crush = new boolean[n][m];
            for(int i=0;i<n;i++){
                for(int j=0;j<m-2;j++){
                    if(Math.abs(board[i][j]) == Math.abs(board[i][j+1]) && Math.abs(board[i][j]) == Math.abs(board[i][j+2]) && board[i][j] != 0){
                        crush[i][j] = true;
                        crush[i][j+1] = true;
                        crush[i][j+2] = true;
                        found = true;
                    }
                }
            }
            for(int j=0;j<m;j++){
                for(int i=0;i<n-2;i++){
                    if(Math.abs(board[i][j]) == Math.abs(board[i+1][j]) && Math.abs(board[i][j]) == Math.abs(board[i+2][j]) && board[i][j] != 0){
                        crush[i][j] = true;
                        crush[i+1][j] = true;
                        crush[i+2][j] = true;
                        found = true;
                    }
                }
            }
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(crush[i][j]){
                        board[i][j] = 0;
                    }
                }
            }
            for(int j=0;j<m;j++){
                int writeIndex = n-1;
                for(int i=n-1;i>=0;i--){
                    if(board[i][j] != 0){
                        board[writeIndex--][j] = board[i][j];
                    }
                }
                while(writeIndex >= 0){
                    board[writeIndex--][j] = 0;
                }
            }
        }
        return Arrays.stream(board).mapToInt(row -> Arrays.stream(row).sum()).sum();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(candyCrush(arr));
    }
}
