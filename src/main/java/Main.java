import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class Main {

	public static class Pair implements Comparable<Object>{
		int i = 0;
		int j = 0;
		Integer sum = 0;
		public Pair(int i, int j, int []a){
			this.i = i;
			this.j = j;
			for(int cnt = i; cnt <= j; cnt++){
				sum += a[cnt]; 
			}
		}
		@Override
		public boolean equals(Object o){
			if(o != null && o instanceof Pair){
				Pair p = (Pair)o;
				return this.sum == p.sum;
			}
			return false;
		}
		@Override
		public int compareTo(Object arg0) {
			if(arg0 instanceof Pair){
				Pair p1 = (Pair)arg0;
				return this.sum.compareTo(p1.sum);
			}
			return 0;
		}
		public String toString(){
			return "i="+i + ",j="+j+",sum="+sum;
		}
	}
	
	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
			String[]parts = br.readLine().split("\\s+");
			int n = Integer.parseInt(parts[0]);
			int k1 = Integer.parseInt(parts[1]);
			int k2 = Integer.parseInt(parts[2]);
			int k3 = Integer.parseInt(parts[3]);
			parts = br.readLine().split("\\s+");
			int[]a = new int[n];
			for(int i = 0; i < a.length; i++){
				a[i] = Integer.parseInt(parts[i]);
			}
			List<Pair> res = algo(a, k3);
//			Pair[]resP = res.toArray(new Pair[res.size()]);
//			System.out.println(Arrays.toString(resP));
			System.out.println(res.get(k1-1).sum + " " + res.get(k2-1).sum + " " + res.get(k3-1).sum);
		}
	}
	
	public static List<Pair> algo(int[]a, int k){
		List<Pair> K = new ArrayList<Pair>();
		int n = a.length;
		int ns = n;
		int l = 0;
		List<Integer>Q = new ArrayList<Integer>();
		for(int i = 1; i <= n; i++){
			Q.add(i);
		}
		int cnt = 10;
		do{
			l = 2*((k/ns)+((k%ns==0)?0:1));
			if(l > n){
				l = n;
			}
			List<Pair> list = new ArrayList<Main.Pair>();
			for(int i : Q){
				list.addAll(compute(a, i, l));
			}
			list.addAll(K);
			Collections.sort(list);
			Pair[]arr = list.toArray(new Pair[list.size()]);
			int kcurr = k;
			K = new ArrayList<Pair>();
			Q = new ArrayList<Integer>();
			Set<Integer> set = new HashSet<Integer>();
			for(int i = arr.length-1; i >=0 && kcurr > 0; i--, kcurr--){
				K.add(arr[i]);
				set.add(arr[i].j);
			}
			Q.addAll(set);
			ns = Q.size();
		} while(ns>0 && l != n && --cnt > 0);
		return K;
	}

	public static List<Pair> compute(int[]a, int endExclude, int largest){
		Map<Integer, Pair> map = new HashMap<Integer, Pair>();
		for(int start = 0; start < endExclude; start++){
			Pair p = new Pair(start, endExclude-1, a);
			map.put(p.sum, p);
		}
		Integer[]keys = map.keySet().toArray(new Integer[map.keySet().size()]);
		Arrays.sort(keys);
		List<Pair>ret = new ArrayList<Main.Pair>();
		for(int i = keys.length-1; i >= 0 && largest>0; i--, largest--){
			ret.add(map.get(keys[i]));
		}
		return ret;
	}
}
