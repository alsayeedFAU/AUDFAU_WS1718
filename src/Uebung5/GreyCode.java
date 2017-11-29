import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GreyCode {

    // append reverse of order n gray code to prefix string, and print
    public static void yarg(String prefix, int n) {
        if (n == 0) System.out.println(prefix);
        else {
            gray(prefix + "1", n - 1);
            yarg(prefix + "0", n - 1);
        }
    }  

    // append order n gray code to end of prefix string, and print
    public static void gray(String prefix, int n) {
        if (n == 0) System.out.println(prefix);
        else {
            gray(prefix + "0", n - 1);
            yarg(prefix + "1", n - 1);
        }
    }  

    
    
    public static  List<Integer> grayCode(int n) {
        if(n==0){
            List<Integer> result = new ArrayList<Integer>();
            result.add(0);
            return result;
        }
     
        List<Integer> result = grayCode(n-1);
        int numToAdd = 1<<(n-1);
     
        for(int i=result.size()-1; i>=0; i--){
            result.add(numToAdd+result.get(i));
        }
     
        return result;
    }

    public static void main(String[] args) {
        int n = 2;
       // gray("", n);
       
        System.out.println(grayCode(n));
        
    }

}
