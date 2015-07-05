import java.io.IOException;

import java.util.Scanner;

public class ChefAndGround {
    public static void main(final String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] heights = new int[n];
            for (int i = 0; i < n; i++) {
                heights[i] = sc.nextInt();
            }

            boolean canEqual = canEqual(n, m, heights);
            if (canEqual) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    private static boolean canEqual(final int n, final int m, final int[] heights) {

        int min = 0;
        int max = 1000000;

        while (min <= max) {
            int restm = m;
            boolean hasHigherCols = false;
            int level = min + (max - min) / 2;
            for (int i = 0; i < n; i++) {
                if (heights[i] <= level) {
                    restm -= level - heights[i];
                } else {
                    hasHigherCols = true;
                    break;
                }
            }

            if (hasHigherCols) {
                min = level + 1;
            } else if (restm > 0) {
                min = level + 1;
            } else if (restm < 0) {
                max = level - 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
