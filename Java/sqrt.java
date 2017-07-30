//Implement double sqrt(double a) and x >= 0
public class Solution {
    /**
     * @param x a double
     * @return the square root of x
     */
    public double sqrt(double a) {
        if (a == 0){
            return 0;
        }
        //find initial x0
        double low=0;
        double high=a/2+1;
        double middle = 0;
        while (low <= high){
            middle = (low + high)/2;
            if (middle*middle == a){
                return a;
            }
            else if (middle*middle < a){
                low=middle+1;
            }
            else if (middle*middle > a){
                high = middle-1;
            }
        }
        //Newton method
        double x = middle;
        double y = function(x,a);
        double diff = 1;//precision
        while (diff>0.0000001){
            double temp = x;
            x = x - y/slope(x);
            y = function(x,a);
            diff= x - temp;
            if (diff < 0){
                diff = -diff;
            }
        }
        return x;
    }
    //
    private double function(double x, double a){
        return x*x-a;
    }
    private double slope(double x){
        return 2*x;
    }
}
