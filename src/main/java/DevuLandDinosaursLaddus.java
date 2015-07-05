import java.util.Scanner;

public class DevuLandDinosaursLaddus {
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] location = new int[n];
            for (int i = 0; i < n; i++) {
                location[i] = sc.nextInt();
            }

            int dIdx = 0;
            int vIdx = 0;
            int res = 0;
            while (dIdx < location.length && vIdx < location.length) {
                while (dIdx < location.length && location[dIdx] >= 0) {
                    dIdx++;
                }
                while (vIdx < location.length && location[vIdx] <= 0) {
                    vIdx++;
                }

                if (dIdx >= location.length || vIdx >= location.length) {
                    break;
                }

                int fed = Math.min(-location[dIdx], location[vIdx]);
                res += fed * Math.abs(dIdx - vIdx);
                location[dIdx] += fed;
                location[vIdx] -= fed;
            }

            System.out.println(res);
        }
    }
}
