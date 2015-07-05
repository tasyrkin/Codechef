import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class COOK51_C {
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            Map<Long, Integer> map = new HashMap<Long, Integer>();
            for (int i = 0; i < 1 << n; i++) {
                Long curr = sc.nextLong();
                Integer cnt = map.get(curr);
                if (cnt == null) {
                    cnt = 0;
                }

                map.put(curr, cnt + 1);
            }

            Long[] vals = map.keySet().toArray(new Long[0]);
            Arrays.sort(vals);
            map.remove(0L);

            LinkedList<Long> elems = new LinkedList<Long>();
            LinkedList<Long> generated = new LinkedList<Long>();

            elems.add(vals[1]);
            generated.add(0L);
            generated.add(vals[1]);

            remove(map, vals[1]);

            main:
            for (int i = 1; i < vals.length; i++) {
                while (true) {
                    Integer curr = map.get(vals[i]);
                    if (curr == null || curr == 0) {
                        break;
                    }

                    elems.add(vals[i]);
                    if (elems.size() == n) {
                        break main;
                    }

                    LinkedList<Long> newGenerated = new LinkedList<Long>();
                    newGenerated.addAll(generated);
                    for (Long gen : generated) {
                        Long newVal = gen + vals[i];
                        remove(map, newVal);
                        newGenerated.add(newVal);
                    }

                    generated = newGenerated;
                }

            }

            Long[] elemArr = elems.toArray(new Long[0]);
            Arrays.sort(elemArr);

            StringBuilder sb = new StringBuilder();
            for (Long el : elemArr) {
                if (sb.length() > 0) {
                    sb.append(" ");
                }

                sb.append(el);
            }

            System.out.println(sb.toString());
        }
    }

    private static void remove(final Map<Long, Integer> map, final Long val) {
        map.put(val, map.get(val) - 1);
    }
}
