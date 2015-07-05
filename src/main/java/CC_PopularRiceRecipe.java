import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;


public class CC_PopularRiceRecipe {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while(--T>=0){
			int n = Integer.parseInt(br.readLine());
			HashSet<String> set = new HashSet<String>();
			int res = 0;
			ArrayList<String> list = new ArrayList<String>();
			while(--n>=0){
				list.add(br.readLine());
			}
			for(int i = list.size()-1; i>=0; i--){
				String[]parts = list.get(i).split("\\s+");
				if(!set.contains(parts[0])){
					set.add(parts[0]);
					if(parts[1].startsWith("+")){
						res++;
					}
					else{
						res--;
					}
				}				
			}
			System.out.println(res);
		}
	}	

}
