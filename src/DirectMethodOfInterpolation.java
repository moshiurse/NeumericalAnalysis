import java.util.Arrays;

/**
 * @Author Moshiur Rahman
 * @Topic Direct Method Of Interpolation
 * @Date 08-05-2017
 */
public class DirectMethodOfInterpolation {
	

	public static void main(String[] args) {
		Interpolation interpolation = new Interpolation();
		 double second = interpolation.secondOrder();
		 double third = interpolation.thirdOrder();
		 double error = third-second;
		 System.out.println("Second order value : "+second);
		 System.out.println("Third order value : "+third);
		 System.out.println("Error : " +error);
	}

}

class Interpolation {

	double a0,a1,a2,a3;
	public int[] year = { 1951, 1961, 1971, 1981, 1991, 2001, 2010 };
	public double[] fa = { 2.8, 3.2, 4.5, 5.35, 6.3, 7.8, 8.2 };
	

	public double secondOrder() {
		
		System.out.println("**********Second Order**************");
		double[][] matrix = { { 1.0, 1951.0, 3806401.0}, { 1.0, 1961.0, 3845521.0},
				{ 1.0, 1971.0, 3884841.0} };
		double[][] temp = new double[1][3];
		// formula = f(x) = a0 + a1x + a2x2
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println("\n");
		}

		temp[0][0] = matrix[1][0] - matrix[0][0];
		temp[0][1] = matrix[1][1] - matrix[0][1];
		temp[0][2] = matrix[1][2] - matrix[0][2];

		matrix[1][0] = temp[0][0];
		matrix[1][1] = temp[0][1];
		matrix[1][2] = temp[0][2];

		temp[0][0] = matrix[2][0] - matrix[0][0];
		temp[0][1] = matrix[2][1] - matrix[0][1];
		temp[0][2] = matrix[2][2] - matrix[0][2];
		
		matrix[2][0] = temp[0][0];
		matrix[2][1] = temp[0][1];
		matrix[2][2] = temp[0][2];
			
		matrix[1][1] = matrix[1][1]*2;
		matrix[1][2] = matrix[1][2]*2;
			
		temp[0][1] = matrix[2][1] - matrix[1][1];
		temp[0][2] = matrix[2][2] - matrix[1][2];
		
		matrix[2][1] = temp[0][1];
		matrix[2][2] = temp[0][2];
		
		a2 = fa[2]/matrix[2][2];
		a1 = (fa[1]-(matrix[1][2]*a2))/matrix[1][1];
		a0 = (fa[0]-(matrix[0][2]*a2)-(matrix[0][1]*a1));
		
		double result = a0+(a1*1966)+(a2*3865156);
		
		System.out.println("Second order value = "+result);
		return result;

	}

	public double thirdOrder() {
		System.out.println("***************Third Order****************");
		// formula = f(x) = a0 + a1x + a2x2 + a3x3
		
		double[][] matrix = { { 1.0, 1951.0, 3806401.0 ,7426288351.0}, { 1.0, 1961.0, 3845521.0,7541066681.0 },
				{ 1.0, 1971.0, 3884841.0,7657021611.0 }, {1.0,1981.0,3924361.0,7774159141.0} };
		double[][] temp = new double[2][4];
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println("\n");
		}
		
		
		temp[0][0] = matrix[1][0] - matrix[0][0];
		temp[0][1] = matrix[1][1] - matrix[0][1];
		temp[0][2] = matrix[1][2] - matrix[0][2];
		temp[0][3] = matrix[1][3] - matrix[0][3];
		
		matrix[1][0] = temp[0][0];
		matrix[1][1] = temp[0][1];
		matrix[1][2] = temp[0][2];
		matrix[1][3] = temp[0][3];

		temp[0][0] = matrix[2][0] - matrix[0][0];
		temp[0][1] = matrix[2][1] - matrix[0][1];
		temp[0][2] = matrix[2][2] - matrix[0][2];
		temp[0][3] = matrix[2][3] - matrix[0][3];
		
		matrix[2][0] = temp[0][0];
		matrix[2][1] = temp[0][1];
		matrix[2][2] = temp[0][2];
		matrix[2][3] = temp[0][3];
		
		matrix[1][1] = matrix[1][1]*2;
		matrix[1][2] = matrix[1][2]*2;
		matrix[1][3] = matrix[1][3]*2;
				
		temp[0][1] = matrix[2][1] - matrix[1][1];
		temp[0][2] = matrix[2][2] - matrix[1][2];
		temp[0][3] = matrix[2][3] - matrix[1][3];
		
		matrix[2][1] = temp[0][1];
		matrix[2][2] = temp[0][2];
		matrix[2][3] = temp[0][3];
		
		temp[0][0] = matrix[3][0] - matrix[0][0];
		temp[0][1] = matrix[3][1] - matrix[0][1];
		temp[0][2] = matrix[3][2] - matrix[0][2];
		temp[0][3] = matrix[3][3] - matrix[0][3];
		
		matrix[1][0] = temp[0][0];
		matrix[1][1] = temp[0][1];
		matrix[1][2] = temp[0][2];
		matrix[1][3] = temp[0][3];
		
		temp[0][1] = (matrix[3][1]*2) - (matrix[0][1]*2);
		temp[0][2] = (matrix[3][2]*2) - (matrix[0][2]*2);
		temp[0][3] = (matrix[3][3]*2) - (matrix[0][3]*2);
		
		matrix[3][1] = temp[0][1];
		matrix[3][2] = temp[0][2];
		matrix[3][3] = temp[0][3];
				
		temp[0][2] = matrix[3][2] - (matrix[2][2]*1179.6);
		temp[0][3] = matrix[3][3] - (matrix[2][3]*1179.6);
		
		a3 = fa[3]/matrix[3][3];
		a2 = (fa[2]-(matrix[2][3]*a3))/matrix[2][2];
		a1 = (fa[1]-(matrix[1][3]*a3)-(matrix[1][2]*a2))/matrix[1][1];
		a0 = (fa[0]-(matrix[0][3]*a3)-(matrix[0][2]*a2)-matrix[0][1]);
		
		double result = a0+(a1*1966)+(a2*3865156)+(a3*7598896696.0);
		
		System.out.println("Third order value = "+result);
		return result;
		
	}

}