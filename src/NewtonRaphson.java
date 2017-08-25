/**
 * @Author Moshiur Rahman
 * @Subject Numerical Analysis
 * @Topic Newton Raphson Method
 * @Date 08-05-2017
 */

public class NewtonRaphson{
	
	// our f(x) = x^3-0.165x^2+3.990*10^-4=0

     public static void main(String []args){
         double x = 0.05;
         double x1;
         int counter = 1;

        System.out.println("X0 = "+x);

        while(1==1){
            System.out.println("******Iteration "+(counter++)+" *****\n");
            x1 = x-functionOfX(x)/functionOfDerivative(x);


            float firstValue  = Float.valueOf(String.format("%.3f", x));
            float secondValue  = Float.valueOf(String.format("%.3f", x1));

            System.out.println("Previous Root = "+x);
            System.out.println("Present  Root = "+x1);

            if(firstValue == secondValue){
                System.out.println("Root corrected after 3 decimal places");
                return;
            }
            x = x1;

        }
     }

     public static double functionOfX(double x){
         
         return Math.pow(x,3)-0.165*Math.pow(x,2)+3.990*Math.pow(10,-4);
     }

     public static double functionOfDerivative(double x){
         return 3*Math.pow(x,2)-0.33*x;
     }
}
