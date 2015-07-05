import java.util.Scanner;

public class COOK51_A {
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long n = sc.nextInt();
            System.out.println(2 * n + ((n - 1) * n) / 2);
        }
    }
}
