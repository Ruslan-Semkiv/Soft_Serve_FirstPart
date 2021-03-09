package Sprint_4th;


public class FifthTask {
    public static void main(String[] args) {
        Array<Integer> one = new Array<>(new Integer[]{1,2,4,5});
        double average = ArrayUtil.averageValue(one);
        System.out.println(average);

    }
}

class Array<T> {
    private T[] array;

    public Array (T[] array){
        this.array = array;
    }
    public T get(int index){
        return array[index];
    }
    public int length(){
        return  array.length;
    }
}

class ArrayUtil {
    public static <T extends Number> double averageValue(Array <T> array){
        double sum = 0.0;
        for(int i =0;i< array.length();i++){
            sum += array.get(i).doubleValue();
        }
        sum = sum/ array.length();
        return sum;
    }
}

