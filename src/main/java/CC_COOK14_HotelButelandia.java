import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CC_COOK14_HotelButelandia {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			String[] parts = br.readLine().split("\\s+");
			for (int i = 0; i < parts.length; i++) {
				arr[i] = Integer.parseInt(parts[i]);
			}
			int[] dep = new int[n];
			parts = br.readLine().split("\\s+");
			for (int i = 0; i < parts.length; i++) {
				dep[i] = Integer.parseInt(parts[i]);
			}
			int max = Integer.MIN_VALUE;
			for(int i = 0; i <= 1000; i++){
				boolean[]visited = new boolean[n];
				int currMax = 0;
				for(int j = 0; j < n; j++){
					if(arr[j]<=i&&dep[j]>i&&!visited[j]){
						visited[j] = true;
						currMax++;
					}
				}
				if(max<currMax)max=currMax;
			}
			System.out.println(max);
		}
	}
}
