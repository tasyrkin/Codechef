import java.math.BigInteger;

public class QuadraticLaw {
    public long getTime(final long d) {

        long min = 0;
        long max = d;

        BigInteger dBig = new BigInteger(d + "");
        long myres = 0;

        while (min <= max) {
            long t = min + (max - min) / 2;
            BigInteger tbig = new BigInteger(t + "");
            BigInteger tsquare = tbig.multiply(tbig);
            BigInteger res = tsquare.add(tbig);
            int cmp = res.compareTo(dBig);
            if (cmp < 0) {
                long lv = t;
                if (myres < lv) {
                    myres = lv;
                }

                min = t + 1;
            } else if (cmp > 0) {
                max = t - 1;
            } else {
                return t;
            }
        }

        return myres;
    }

    public static void main(final String[] args) {
        long res = new QuadraticLaw().getTime(5);
        System.out.println(res);
    }
}
