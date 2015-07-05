import java.io.IOException;
import java.io.InputStream;

public class CC_COOK17_CIEL8STR {
	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		InputStream br = System.in;
		long res = 0;
		int ch = -1;
		String[]buf = new String[3];
		int cnt = 0;
		int num = 0;
		while(-1 != (ch = br.read())){
			num++;
			if(cnt>=3){				
				buf[0] = buf[1]; 
				buf[1] = buf[2];
				buf[2] = ch+"";
			} else {
				buf[cnt++] = ch+"";
			}
			String sCurr = buf[cnt-1];
			int curr = Integer.parseInt(sCurr);
			if (curr % 2 == 1)
				continue;
			if (curr % 8 == 0) {
				res++;
			} else {
				continue;
			}
			if (cnt >= 2) {
				sCurr = buf[cnt - 2] + sCurr;
				curr = Integer.parseInt(sCurr);
				if (curr % 8 == 0) {
					res++;
				} else {
					continue;
				}
			}
			if (cnt >= 3) {
				sCurr = buf[cnt - 3] + sCurr;
				curr = Integer.parseInt(sCurr);
				if (curr % 8 == 0) {
					res++;
					if (num >= 3) {
						res += num - 3;
					}
				} else {
					continue;
				}
			}
		}
		System.out.println(res);
	}
}
