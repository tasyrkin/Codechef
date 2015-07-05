import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class CC_COOK18_COLLIDE {
	
	private static class Pos{
		float x = 0;
		float y = 0;
		String d = "";
		public Pos(int x, int y, String d){
			this.x = x;
			this.y = y;
			this.d = d;
		}
		public void move(){
			if("U".equals(d)){
				y+=0.5;
			} 
			if("D".equals(d)){
				y-=0.5;
			}
			if("L".equals(d)){
				x-=0.5;
			}
			if("R".equals(d)){
				x+=0.5;
			}
		}
		public boolean equals(Object o){
			if(o !=null && o instanceof Pos){
				Pos p = (Pos)o;
				return this.x == p.x && this.y == p.y;
			}
			return false;
		}

	}
	
	public static void main(String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		big: while(t-->0){
			String[]parts = br.readLine().split("\\s+");
			Pos earth = new Pos(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), parts[2]);	
			int n = Integer.parseInt(br.readLine());
			Pos[]ast = new Pos[n];
			for(int i = 0; i < n; i++){
				parts = br.readLine().split("\\s+");
				ast[i] = new Pos(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), parts[2]);				
			}
			for(int i = 1; i <= 500; i++){
				earth.move();
				for(int j = 0; j < n; j++){
					ast[j].move();
					if(earth.equals(ast[j])){
						System.out.println((float)i/2);
						continue big;
					}
				}
			}
			System.out.println("SAFE");
		}
		
	}
}
