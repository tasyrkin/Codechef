import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

/**
 * @author: tasyrkin
 * @since: 2013/12/29
 */
public class LTIME07_MIKE1 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[]ps = br.readLine().split("\\s+");
        int n = Integer.parseInt(ps[0]);
        int m = Integer.parseInt(ps[1]);
        int[][]mat = new int[n][m];
        
        for(int i = 0; i < n; i++){
            ps = br.readLine().split("\\s+");
            for(int j = 0; j < m; j++){
                mat[i][j] = Integer.parseInt(ps[j]);
            }
        }
        int l = Integer.parseInt(br.readLine());
        long e1 = 0, e2 = 0;
        for(int i = 0; i < l; i++){
            ps = br.readLine().split("\\s+");
            int x = Integer.parseInt(ps[0])-1;
            int y = Integer.parseInt(ps[1])-1;
            if(x < n && y < m){
                if(e1 != -1){
                    e1 += mat[x][y];
                }
            } else {
                e1 = -1;
            }
            
            if(x < m && y < n){
                if(e2 != -1){
                    e2 += mat[y][x];
                }
            } else {
                e2 = -1;
            }
        }
        System.out.println(Math.max(e1, e2));
    }
}
