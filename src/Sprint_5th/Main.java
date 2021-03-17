package Sprint_5th;



public class Main {
    public static void main(String... args) {
       int i = 0;

        System.out.println("I dont belive ");
    }
}

class TestClass {
    public static void one() throws Exception{
        throw new Exception();
    }

    public static void main(String... arg) throws Exception {
        try {
            one();
            System.out.println("I");
        }
        finally {
            System.out.println("T");
        }
        System.out.println("Academy");
    }
}