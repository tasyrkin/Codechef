import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class CC_COOK20_CielNumbers2 {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int cnt = 0;
		main: for(int i = 0; i < n; i++){
			String[]parts = br.readLine().split("\\s+");
			char [] a = parts[parts.length-1].toCharArray();
			int[]ints = new int[3];
			for(int j = 0; j < a.length; j++){
				if(a[j]=='8')ints[0]++;
				else if(a[j]=='5')ints[1]++;
				else if(a[j]=='3')ints[2]++;
				else continue main;
			}
			if(ints[0]>=ints[1]&&ints[1]>=ints[2]){
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}
