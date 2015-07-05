import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MARCH12_LWS {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			char[] str = ("#"+br.readLine()).toCharArray();
			int[][][] dp = new int[str.length][27][27];
			int x = (int)str[0]-(int)'a';
//			for(int i = 0; i < 27; i++){
//				for(int j = 0; j < 27; j++){
//					if(i <= x || j >= x){					
//						dp[0][i][j] = 1;
//					}
//				}
//			}
			for(int k = 1; k < str.length; k++){
				x = (int)str[k]-(int)'a';
				for(int i = 0; i < 27; i++){
					for(int j = 0; j < 27; j++){
						dp[k][i][j] = Math.max(dp[k][i][j], dp[k-1][i][j]); 
						if(i<=x){
							dp[k][x][j] = Math.max(dp[k][x][j], dp[k-1][i][j]+1);
						}
						if(j>=x){
							dp[k][i][x] = Math.max(dp[k][i][x], dp[k-1][i][j]+1);
						}
					}
				}
			}
			int res = 0;
			for(int i = 0; i < 27; i++){
				for(int j = 0; j < 27; j++){
					res = Math.max(res, dp[str.length-1][i][j]);
				}
			}
			System.out.println(res);
		}
	}

}
