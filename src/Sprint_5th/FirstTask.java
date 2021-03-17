package Sprint_5th;

public class FirstTask {
}

class Operation{
    public static  int squareRectangle (int a, int b) {
        int sum = 0;
        if(a<=0 && b<=0){
            sum = -1;
        }
        else if(a<=0 || b<=0){
            throw new IllegalArgumentException("both arguments should be more than zero");
        }
        else{ sum = a*b; }

        return sum;
    }

    public static int trySquareRectangle(int a, int b) {
        int catcher = 0;
        try{
            catcher = squareRectangle(a,b);
        }  catch (IllegalArgumentException e){
            catcher = -1;
        }
        return catcher;
    }
}

