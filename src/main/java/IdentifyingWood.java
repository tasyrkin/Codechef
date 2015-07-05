public class IdentifyingWood {
    public String check(final String s, final String t) {
        char[] sc = s.toCharArray();
        char[] ts = t.toCharArray();

        int matched = 0;
        int cnt = 0;
        main:
        for (int i = 0; i < ts.length; i++) {
            for (int j = cnt; j < sc.length; j++) {
                if (ts[i] == sc[j]) {
                    matched++;
                    cnt = j;
                    continue main;
                }
            }
        }

        return matched == ts.length ? "Yep, it's wood." : "Nope";
    }
}
