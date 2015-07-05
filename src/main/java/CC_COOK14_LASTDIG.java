import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CC_COOK14_LASTDIG {

	// public static long[] cols = new long[10];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String[] parts = br.readLine().split("\\s+");
			Integer a = Integer.parseInt(parts[0]);
			Integer b = Integer.parseInt(parts[1]);
			a--;
			if (a < 0)
				a = 0;
			long sumTmp1 = 0;
			for (int i = (a / 10) * 10; i <= a; i++) {
				sumTmp1 += bruteForce(i);
			}
			long sumTmp2 = 0;
			for (int i = (b / 10) * 10; i <= b; i++) {
				sumTmp2 += bruteForce(i);
			}
			long sum1 = (a / 10) * 45 + sumTmp1;
			long sum2 = (b / 10) * 45 + sumTmp2;
			System.out.println(sum2 - sum1);
		}
	}

	private static int calc(int a) {
		int sum = 0;
		for (int i = 0; i <= a; i++) {
			int currSum = (i % 2 == 0) ? i * 2 : i;
			sum += currSum % 10;
		}
		return sum;
	}

	private static long bruteForce(int n) {
		long sum = 0;
		char[] arr = new Integer(n).toString().toCharArray();
		for (int j = 0; j < arr.length; j++) {
			int currInt = Integer.parseInt(arr[j] + "");
			if (currInt % 2 == 0) {
				currInt += currInt;
			}
			sum += currInt;
		}
		return sum % 10;
	}

	private static void bruteForce() {
		for (int i = 0; i < 11; i++) {
			char[] arr = new Integer(i).toString().toCharArray();
			long sum = 0;
			for (int j = 0; j < arr.length; j++) {
				int currInt = Integer.parseInt(arr[j] + "");
				if (currInt % 2 == 0) {
					currInt += currInt;
				}
				sum += currInt;
			}
			System.out.println(i + ":" + sum % 10);
		}
		// System.out.println(sum);
	}
}
