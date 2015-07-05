import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The problem is was not solved
 * @author Compaq_Cq
 */

public class CC_DEMENTIA_1 {
	public static void main(String[] args) throws IOException {
		Integer[] primes = primes(985440000);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] parts = br.readLine().split("\\s+");
		int t = Integer.parseInt(parts[0]);
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			System.out.println(primes[n-1]);
		}
	}

	public static Integer[] primes(int n) {
		boolean[] prime = new boolean[n + 1];
		Arrays.fill(prime, true);
		prime[0] = prime[1] = false;
		List<Integer> resList = new ArrayList<Integer>();
		int prevPrev = -1;
		int prev = -1;
		for (int i = 2; i * i <= n; ++i) {
			if (prime[i]) {
				if(prevPrev == -1) {
					prevPrev = i;
				} else if (prev == -1){
					prev = i;
				}
				else {
					if(2*prev == prevPrev + i){
						resList.add(prev);
					}
					prevPrev = prev;
					prev = i;
				}
				for (int j = i * i; j <= n; j += i)
					prime[j] = false;
			}
		}
		return resList.toArray(new Integer[resList.size()]);
	}
}
