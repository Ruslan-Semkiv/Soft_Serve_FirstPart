package Sprint_5th;

import java.util.Objects;


class Person {
    private String firstName;
    private String lastName;
    private String idCode;

    public void setFirstName(String firstName) throws NameException{
        if(!firstName.matches("[A-Z][a-z\\-, ]*")){
            throw new NameException("Incorrect value "+firstName +" for firstName (should start from upper " +
                    "case and contains only alphabetic characters and symbols -, _); ");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) throws NameException{
       if(!lastName.matches("[A-Z][a-z\\-, ]*")){
           throw new NameException("Incorrect value "+lastName +" for lastName (should start from upper case and "+
                   " contains only alphabetic characters and -, _); ");
       }
        this.lastName = lastName;
    }

    public void setIdCode(String idCode) throws CodeException{
        if(!idCode.matches("[0-9]{10}")){
            throw new CodeException("Incorrect value "+idCode+" for code (should contains exactly 10 digits) ");
        }
        this.idCode = idCode;
    }

    public static Person buildPerson(String firstName, String lastName, String idCode) throws IllegalArgumentException{
        Person person = new Person();
        StringBuilder bob = new StringBuilder();
        try{
            try{
                 try {
                    person.setFirstName(firstName);
                 }catch (NameException ex){
                     bob.append(ex.getMessage());
                 }
                 person.setLastName(lastName);
            }catch (NameException exception){
                 bob.append(exception.getMessage());
            }
            person.setIdCode(idCode);
        }catch (CodeException e){
            bob.append(e.getMessage());
         }
        if(!(bob.length() ==0)){
            throw new IllegalArgumentException(bob.substring(0,bob.length()-2));
        }
        return person;
    }

    @Override
    public String toString() {
        return
                firstName +" " + lastName + ": "+ idCode ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, idCode);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return idCode == person.idCode && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName);
    }
}


class NameException extends RuntimeException{
     public NameException(String message){
         super(message);
     }
}
class CodeException extends RuntimeException{
     public CodeException(String message){
         super(message);
     }
}