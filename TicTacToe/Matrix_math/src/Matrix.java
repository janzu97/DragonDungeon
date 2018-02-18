
public class Matrix {
	public static int[][] Multiply(int[][] y,int x){
		int[][] z=new int[y.length][y[0].length] ;
		for (int i=0; i<y.length; i++) {
			for(int k=0; k<y[0].length; k++) {
				z[i][k]=y[i][k]*x;
			}
			
		}
		return z;
	}
	public static int[][] Multiply(int[][] y,int[][] x){
		int[][] z=new int [x.length][y[0].length];
		int temp=0;
		for (int d=0; d<y.length; d++) {
			
			for (int i=0; i<x.length; i++) {
				temp=0;
				for(int k=0; k<y[0].length; k++) {
					temp+=x[k][d]*y[i][k];
				}

				z[i][d]=temp;
				
			}
			
		}
	

return z;



}
	public static int[][] addition(int[][] y,int[][] x) {
		int[][] z=new int[x.length][x[0].length] ;
		for (int i=0; i<x.length; i++) {
			for(int k=0; k<y[0].length; k++) {
				z[i][k]=x[i][k]+y[i][k];
			}
			
		}		
		return z;
	}

public static String MatrixToString(int[][] x) {
	String s="";
	for(int[] i: x) {
		for(int k:i) {
			s+=k+" ";

		}
		s+="\n";
	}
	return s;
}
}
