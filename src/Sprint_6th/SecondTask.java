package Sprint_6th;

import java.util.function.Consumer;

class App {
     static Consumer<? extends Double[]> cons = new Consumer<Double[]>() {
         @Override
         public void accept(Double[] doubles) {
                 for(int i =0;i< doubles.length;i++){
                     if(doubles[i]>2){
                         doubles[i] = doubles[i]*0.8;
                     }else {
                         doubles[i]= doubles[i]*0.9;
                     }
                 }
             }
     };

    public static double[] getChanged(double[] initialArray, Consumer<Double[]> consumer) {
        Double[] sumDouble = Double.valueOf(initialArray.clone());
        consumer.accept(sumDouble);
        return sumDouble;
    }
}
