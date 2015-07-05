import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//CC_COOK20_CielNumbers1
public class CC_COOK20_CielNumbers1 {

	private static Set<String> nums = new HashSet<String>();
	private static int[] check = new int[3];
	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		long start = System.currentTimeMillis();
		nums.add("8");
		int max = 1;
		int cnt = 0;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		while(true){			
			String[] numsArr = nums.toArray(new String[nums.size()]);
			Arrays.sort(numsArr);	
			StringBuffer sb = new StringBuffer();
			for(String i : numsArr){
				sb.append(i + "\n");
				if(++cnt>=50000){
					System.out.print(sb.toString());
//					System.out.println(numsArr.length);
 
					System.out.println(""+(System.currentTimeMillis()-start));
					return;
				}
			}
			bw.write(sb.toString());
			System.out.print(sb.toString());
//			System.out.println(numsArr.length);
			Set<String> nums1 = new HashSet<String>();
			for(String l : nums){				
				char[]a = l.toCharArray();
				if(max-a.length>=2)continue;
				max = Math.max(max, a.length+1);
				summary(a);
				if(check[0]+1>=check[1]&&check[1]>=check[2]){
					for(int i = 0; i <= a.length; i++){
						String nextNum = l.substring(0,i) + "8" + (i<a.length?l.substring(i,a.length):"");
						if(!nums1.contains(nextNum)){
							nums1.add(nextNum);
						}
					}
				}
				if(check[0]>=check[1]+1&&check[1]+1>=check[2]){
					for(int i = 0; i <= a.length; i++){
						String nextNum = l.substring(0,i) + "5" + (i<a.length?l.substring(i,a.length):"");
						if(!nums1.contains(nextNum)){
							nums1.add(nextNum);
						}
					}
				}
				if(check[0]>=check[1]&&check[1]>=check[2]+1){
					for(int i = 0; i <= a.length; i++){
						String nextNum = l.substring(0,i) + "3" + (i<a.length?l.substring(i,a.length):"");
						if(!nums1.contains(nextNum)){
							nums1.add(nextNum);
						}
					}
				}
			}
			nums = nums1;
		}		
	}
	private static void summary(char[]a) {
		Arrays.fill(check, 0);
		for(int i = 0; i < a.length; i++){
			if(a[i]=='8')check[0]++;
			else if(a[i]=='5')check[1]++;
			else if(a[i]=='3')check[2]++;
		}
	}

}
