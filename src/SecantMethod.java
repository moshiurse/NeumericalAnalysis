
public class SecantMethod {

    // x^4-x-10

   double x0 = 1;
   double x1 = 2;
   double x2;
   int countx = 2;

   int counter = 5;

    public static void main(String[] args){
        SecantMethod sm = new SecantMethod();

        for(int i = 1; i<sm.counter;i++){
            System.out.println("**************Iteration "+i+"*************");
            sm.x2 = sm.iteration();

            System.out.println("X"+sm.countx+" = "+sm.x2);
            sm.x0 = sm.x1;
            sm.x1 = sm.x2;
            sm.countx++;

        }

    }

    public double functionOfX(double x){
        double fx = Math.pow(x, 4)-x-10;

        return fx;
    }

    public double iteration(){
        double x2 = x1-((functionOfX(x1)*(x1-x0)/functionOfX(x1)-functionOfX(x0)));
        return x2;
    }


}