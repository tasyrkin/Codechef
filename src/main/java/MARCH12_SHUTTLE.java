import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


//SHUTTLE
public class MARCH12_SHUTTLE {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer t = Integer.parseInt(br.readLine());
		while(t-->0){
			int n = Integer.parseInt(br.readLine());
			int num = 1;
			for(int j = 2; j < n; j++){
				if(n%j==0)continue;
				if(gcd(n,j)==1)num++;
			}			
			System.out.println(num);
		}
	}
	
	public static int gcd(int a, int b){
		if(a<b)return gcd(b,a);
		if(b == 0)return a;
		return gcd(b, a%b);
	}

}
