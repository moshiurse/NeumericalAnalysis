
public class FalsePosition {

	// f(x) = x^2-x-2;
	static double prev, pres;
	static double xr;
	static double xl = 1;
	static double xu = 3;
	

	static int counter = 1;

	public static void main(String[] args) {

		if (functionOfX(xl) * functionOfX(xu) < 0) {
			
			while(counter >0){
				
				
				xr = (xu * functionOfX(xl) - xl * functionOfX(xu)) / (functionOfX(xl) - functionOfX(xu));
				double fr = functionOfX(xr);	
				
				
			if(functionOfX(xl)*fr <0){
				System.out.println("Iteration "+counter);
				xu = xr;
				counter++;
				
			}else if(functionOfX(xl)*fr >0){
				System.out.println("Iteration "+counter);
				xl = xr;
				counter++;
			}else{
				System.out.println("Iteration "+counter);
				System.out.println("Root = "+xr);
				counter = 0;
				return;
			}
			
			prev = pres;
			pres = xr;
			
			
			if(counter >2){
				
				if(error(pres, prev) >4){
					System.out.println("Xl = "+xl);
					System.out.println("Xu = "+xu);
					System.out.println("Eror = "+error(pres, prev));
				}else {
					System.out.println("Root = "+xr);
					counter = 0;
					
				}
			}else{
				System.out.println("Xl = "+xl);
				System.out.println("Xu = "+xu);
			}
			
		}
		}
	}

	public static double functionOfX(double x) {
		return (Math.pow(x, 2) - x - 2);

	}
	
	public static double error(double pres, double prev){
		
	
		return ((pres-prev)/pres)*100;
		
	}

}