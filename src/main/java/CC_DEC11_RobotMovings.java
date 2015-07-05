import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class CC_DEC11_RobotMovings {

	public static class Node{
		int i,j,step;
		public Node(int i, int j, int step){
			this.i = i;
			this.j = j;
			this.step = step;
		}
	}
	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] parts = br.readLine().split("\\s+");
		int[][]arr = new int[5000][5000];
		
		int n = Integer.parseInt(parts[0]);
		int k = Integer.parseInt(parts[1]);
		while (n != 0 && k != 0) {
			n = Integer.parseInt(parts[0]);
			k = Integer.parseInt(parts[1]);			
		}
	}

}
