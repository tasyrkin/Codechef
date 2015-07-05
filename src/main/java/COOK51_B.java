import java.util.Arrays;
import java.util.Scanner;

public class COOK51_B {
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long n = sc.nextInt();
            int m = sc.nextInt();
            int[] pos = new int[m];
            for (int i = 0; i < m; i++) {
                pos[i] = sc.nextInt();
            }

            Arrays.sort(pos);

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (sb.length() > 0) {
                    sb.append(" ");
                }

                int max = Math.max(Math.abs(i - pos[0]), Math.abs(i - pos[pos.length - 1]));
                sb.append(max);
            }

            System.out.println(sb.toString());
        }
    }
}
