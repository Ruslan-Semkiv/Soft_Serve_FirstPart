package Sprint_3th;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

public class SixthTask {
}


//////////////////////////////////////////////////////

class AddressBook implements Iterable{
    private int counter =0;
    private NameAddressPair [] addressBook;

    public AddressBook (int capacity){
        addressBook = new NameAddressPair[capacity];
    }

    public boolean create(String firstName,String lastName,String address){
        boolean statusAdd = false;
        NameAddressPair temporary = new NameAddressPair(new NameAddressPair.Person(firstName, lastName),address);

        if(counter==0) {
            addressBook[counter++] = temporary;
            return  true;
        }
        else{
            for(int i = 0;i< counter;i++){
                if(addressBook[i].person.firstName.equals(temporary.person.firstName) && addressBook[i].person.lastName.equals(temporary.person.lastName)){
                    return false;
                }
                else{
                    statusAdd = true;
                }
           }
        }
        if(statusAdd){
            if (counter == addressBook.length-1) {
                addressBook[counter] = temporary;
                NameAddressPair[] template = new NameAddressPair[addressBook.length * 2];
                System.arraycopy(addressBook,0,template,0,addressBook.length);
                addressBook = template;
                counter++;
                return true;
            }else if (counter< addressBook.length-1){
                addressBook[counter++] = temporary;
                return true;
            }
        }
        return statusAdd;
    }

    public String read(String firstName,String lastName){
        boolean isItTrue = false;
        NameAddressPair.Person personNew = new NameAddressPair.Person(firstName, lastName);
        for(int i =0; i<counter;i++){
            if (addressBook[i].person.firstName.equalsIgnoreCase(firstName) && addressBook[i].person.lastName.equalsIgnoreCase(lastName)) {
                return addressBook[i].address;
            }
        }
        return  null;
    }
    ////////////////////////////////////////////////////////
    public boolean update (String firstName ,String lastName,String address){
        for(int i =0;i<counter;i++){
            if (addressBook[i].person.firstName.equals(firstName) && addressBook[i].person.lastName.equals(lastName)) {
               addressBook[i].address = address;
                return true;
            }
        }
        return false;
    }

    public boolean delete (String firstName, String lastName){
       boolean flag = false;
        if(counter!=0) {
            for (int i = 0; i < counter; i++) {
                if (addressBook[i].person.firstName.equals(firstName) && addressBook[i].person.lastName.equals(lastName)) {
                   flag = true;
                }

                if (flag && i + 1 != counter) {
                    addressBook[i] = null;
                    addressBook[i] = addressBook[i + 1];
               }
            }
            counter--;
        }else{
            return false;
        }

        return flag;
    }

    public int size(){
        return counter;
    }


    public void sortedBy(SortOrder sortOrder){
        if(counter == 0){ return;}

        NameAddressPair [] temporary = new NameAddressPair[counter];
        for(int i =0;i<counter;i++){
            temporary[i] = addressBook[i];
        }
        addressBook= temporary;
        if(sortOrder == SortOrder.ASC){
            Arrays.sort(addressBook ,(s1, s2) ->{
                int count = String.CASE_INSENSITIVE_ORDER.compare(s1.person.firstName,s2.person.firstName);
                if(count==0){
                    return String.CASE_INSENSITIVE_ORDER.compare(s1.person.lastName,s2.person.lastName);
                }else{
                    return count;}
           });
        }
        else if(sortOrder==SortOrder.DESC){
            Arrays.sort(addressBook, (s1,s2) -> {
                int count = String.CASE_INSENSITIVE_ORDER.reversed().compare(s1.person.firstName,s2.person.firstName);
                if(count ==0){
                    count = String.CASE_INSENSITIVE_ORDER.reversed().compare(s1.person.lastName,s2.person.lastName);
                }return count;
            });
        }
    }



    public Iterator iterator (){
        return new AddressBookIterator();
    }

    private class AddressBookIterator implements Iterator {

        private int counter  = 0;

        @Override
        public boolean hasNext() {
            return this.counter < size();
        }

        @Override
        public String next() {
            int nums = this.counter;
            this.counter++;
            return "First name: " + addressBook[nums].person.firstName +", Last name: "+ addressBook[nums].person.lastName+", Address: " + addressBook[nums].address;
        }
    }




    private static class NameAddressPair{
        private final Person person;
        private String address;

        private NameAddressPair(Person person,String address){
            this.person = person;
            this.address = address;
       }

        private static class Person implements Comparable{
            private final String firstName;
            private final String lastName;

            private Person(String firstName,String lastName){
                this.firstName = firstName;
                this.lastName = lastName;
            }


            @Override
            public boolean equals(Object obj) {
                return super.equals(obj);
            }

            @Override
            public int hashCode() {
                return Objects.hash(firstName, lastName);
            }

            @Override
           public String toString() {
                return "Person{" +
                        "firstName='" + firstName + '\'' +
                        ", lastName='" + lastName + '\'' +
                        '}';
            }

            @Override
            public int compareTo(Object o) {
                return 0;
            }
        }
        public boolean equals(NameAddressPair name){
            return person.firstName.equals(name.person.firstName) && person.lastName.equals(name.person.lastName);
        }

        @Override
        public String toString() {
            return "First name: "+ person.firstName + ", Last name: "+person.lastName+", Address: " + address;
        }
    }

}
enum SortOrder {
    ASC,DESC;
}
