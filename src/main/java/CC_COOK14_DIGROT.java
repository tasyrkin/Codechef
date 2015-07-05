import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CC_COOK14_DIGROT {

	private static long max = Integer.MIN_VALUE;
	private static int len = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String init = br.readLine();
			max = Integer.MIN_VALUE;
			len = init.length();
			String work = init;
			rotate(work, true, 1);
			rotate(work, false, 1);
			System.out.println(max);
		}
	}

	private static void rotate(String work, boolean side, int j) {
		if (j > len)
			return;
		String rotated = null;
		if (side) {
			if (work.length() > 1)
				rotated = work.substring(1) + work.charAt(0);
			else
				rotated = work;
		} else {
			if (work.length() > 1)
				rotated = work.charAt(work.length() - 1)
						+ work.substring(0, work.length() - 1);
			else
				rotated = work;
		}
		Long currLong = Long.parseLong(rotated);
		if (max < currLong)
			max = currLong;
		rotate(currLong.toString(), true, j + 1);
		rotate(currLong.toString(), false, j + 1);
	}
}
