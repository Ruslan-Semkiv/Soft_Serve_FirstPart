package Sprint_6th;

import java.util.ArrayList;
import java.util.List;

class Person {
    String name;

    Person(String name) {
        this.name = name;
    }

    public DecisionMethod goShopping = (one,sec) -> (one.equals("product1") && sec>10);
}
    @FunctionalInterface
    interface DecisionMethod{
       boolean decide(String name,int discount);
    }

class Shop {
    public List<DecisionMethod> clients = new ArrayList<>();

    public int sale(String product, int percent) {
        int counter = 0;
        for(int i =0; i< clients.size();i++){
            if(clients.get(i).decide(product, percent)){
                counter++;
            }
        }
        return counter;
    }
}

