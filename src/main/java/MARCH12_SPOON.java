import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


//MARCH12_SPOON
public class MARCH12_SPOON {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer t = Integer.parseInt(br.readLine());
		char[]sp = {'s','p','o','o','n'};
		main: while(t-->0){
			String[]parts = br.readLine().split("\\s+");
			int rows = Integer.parseInt(parts[0]); 
			int cols = Integer.parseInt(parts[1]);
			char[][]mat = new char[rows][cols];
			for(int i = 0; i < rows; i++){
				mat[i] = br.readLine().toCharArray();
//				for(int j = 0; j < cols; j++){
//					mat[i][j] = Character.toLowerCase(mat[i][j]);
//				}
			}
			formain: for(int i = 0; i < rows; i++){
				for(int j = 0; j < cols; j++){
					if(rows-i<sp.length&&cols-j<sp.length){
						continue formain;
					}
					int matched = 0;
					for(int k = j; k < j+sp.length && cols-j >= sp.length; k++){
						if(Character.toLowerCase(mat[i][k]) == sp[k-j]){
							matched++;
						}
					}
					if(matched==sp.length){
						System.out.println("There is a spoon!");
						continue main;
					}
					matched = 0;
					for(int k = i; k < i+sp.length && rows-i >= sp.length; k++){
						if(Character.toLowerCase(mat[k][j]) == sp[k-i]){
							matched++;
						}
					}
					if(matched==sp.length){
						System.out.println("There is a spoon!");
						continue main;
					}
				}
			}
			System.out.println("There is indeed no spoon!");
		}
	}

}
