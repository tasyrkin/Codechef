import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

//HDELIVER
public class MARCH12_HDELIVER {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer t = Integer.parseInt(br.readLine());
		while(t-->0){
			String[]parts = br.readLine().split("\\s+");
			int n = Integer.parseInt(parts[0]);
			int m = Integer.parseInt(parts[1]);
			List<Integer>[]graph = new ArrayList[n];
			for(int i = 0; i < m; i++){
				parts = br.readLine().split("\\s+");
				int v1 = Integer.parseInt(parts[0]);
				int v2 = Integer.parseInt(parts[1]);
				if(v1==v2)continue;
				if(graph[v1]==null){
					graph[v1] = new ArrayList<Integer>();
				}
				if(!graph[v1].contains(v2)){
					graph[v1].add(v2);
				}
				if(graph[v2]==null){
					graph[v2] = new ArrayList<Integer>();
				}
				if(!graph[v2].contains(v1)){
					graph[v2].add(v1);
				}				
			}
			Map<Integer, HashSet<Integer>> connMap = new HashMap<Integer, HashSet<Integer>>();  
			int[]color = new int[n];
			for(int v = 0; v < n; v++){
				if(color[v]!=0)continue;
				Queue<Integer> queue = new LinkedList<Integer>();
				HashSet<Integer> connCmp = new HashSet<Integer>();				
				connCmp.add(v);
				queue.add(v);
				while(!queue.isEmpty()){
					int vert = queue.poll();
					connMap.put(vert, connCmp);
					connCmp.add(vert);
					if(color[vert]!=2){
						List<Integer> list = graph[vert];
						if(list!=null){
							for(int vert1 : list){
								if(color[vert1]==0){
									queue.add(vert1);
								}
							}
						}
					}				
					color[vert] = 2;
				}
			}
			
			int q = Integer.parseInt(br.readLine());			
			query: while(q-->0){
				parts = br.readLine().split("\\s+");
				int x = Integer.parseInt(parts[0]);
				int y = Integer.parseInt(parts[1]);
				if(x==y){
					System.out.println("YO");
					continue;
				}
				HashSet<Integer> set = connMap.get(x);
				if(set!=null&&set.contains(y)){
					System.out.println("YO");
					continue query;						
					
				}
				System.out.println("NO");
			}
		}
	}


}
