import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CC_SoziolizingGameAroundPizza {
	public static void main(String[] args) throws IOException {
		boolean[]winner = new boolean[10001];
		winner[2] = true;
		winner[3] = true;
		winner[4] = true;
		winner[5] = false;
		for(int i = 6; i <=10000; i++){
			if(!winner[i-2]||!winner[i-3]){
				winner[i] = true;
			}
			else if((i-1)%4==0){
				winner[i] = false;
			}
			else if((i-2)%4==0){
				if(((i-2)/4)%2==0){
					winner[i] = false;
				}
				else{
					winner[i] = true;
				}
			}
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while(--T>=0){
			int n = Integer.parseInt(br.readLine());
			if(!winner[n]){
				System.out.println("Bhima");
			}
			else{
				System.out.println("Arjuna");
			}
		}
	}	
}