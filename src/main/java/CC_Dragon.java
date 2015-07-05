import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class CC_Dragon {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] parts = null;
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			parts = br.readLine().split("\\s+");
			int num = Integer.parseInt(parts[0]);
			int a = Integer.parseInt(parts[1]);
			int b = Integer.parseInt(parts[2]);
			int tmp = a;
			a = a > b ? a : b;
			b = a > b ? b : tmp;
			int a_new = 0;
			int b_new = 0;
			int a_cnt = 0;
			int b_cnt = 0;
			boolean[] a_arr = new boolean[num];
			boolean[] b_arr = new boolean[num];
			for (int j = 0; j < num; j++) {
				if ((a & (1 << j)) >> j == 1) {
					// a_new|=(1<<(num-1-a_cnt));
					a_arr[num - a_cnt - 1] = true;
					a_cnt++;
				}
				if ((b & (1 << j)) >> j == 1) {
					// b_new|=(1<<(b_cnt));
					b_arr[b_cnt] = true;
					b_cnt++;
				}
			}
			// System.out.println("0 ^ 0:" + (0 ^ 0));
			// System.out.println("a_new:" + a_new + ",b_new:" + b_new);
			// for(int j = 0; j < num; j++){
			// System.out.print((((a_new&(1<<j))>>j)^((b_new&(1<<j))>>j)) +
			// " ");
			// res |= (((a_new&(1<<j))>>j)^((b_new&(1<<j))>>j))<<j;
			// // res = a_new ^ b_new;
			// }
			if (a_arr[a_arr.length - 1] == b_arr[b_arr.length - 1]) {
				System.out.println(0);
			} else {
				boolean[] res_arr = new boolean[num];
				int a_ones = 0;
				for (int j = 0; j < res_arr.length; j++) {
					if (a_arr[res_arr.length - 1 - j] != b_arr[res_arr.length
							- 1 - j]) {
						res_arr[res_arr.length - 1 - j] = true;
						a_cnt--;
					} else {
						if (!a_arr[res_arr.length - 1 - j]) {
							res_arr[res_arr.length - 1 - j] = false;
						} else {
							if (a_cnt > 0) {
								res_arr[a_ones++] = false;
								a_cnt--;
							} else {
								res_arr[res_arr.length - 1 - j] = true;
							}
						}
					}
				}
				int res = 0;
				for (int j = 0; j < res_arr.length; j++) {
					if (res_arr[j]) {
						res |= (1 << j);
					}
				}
				System.out.println(res);
			}
		}
	}
}
