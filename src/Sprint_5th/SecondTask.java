package Sprint_5th;

import java.util.Objects;

public class SecondTask {
}

class Plant2{
    private final String name;
    private  Color2 color;
    private  Type2 type;

    public Plant2(String type,String color,String name) throws TypeException2, ColorException2 {
      try{
             this.type = Type2.valueOf(type.toUpperCase());
      } catch (IllegalArgumentException exception){
             throw new TypeException2("Invalid value "+ type +" for field type");
      }
      try {
          this.color = Color2.valueOf(color.toUpperCase());
      }catch (IllegalArgumentException colorest){
          throw new ColorException2("Invalid value " + color +" for field color");
      }
      this.name = name;
    }

    public String getName(){
        return name;
    }
    public Color2 getColor(){
        return color;
    }
    public Type2 getType(){
        return type;
    }
    @Override
    public String toString(){
        return "{type: "+type+", color: "+ color+", name: " + name + "}";
    }
}

enum Color2{
    WHITE,RED,BLUE
}
enum Type2{
    RARE,ORDINARY
}

class ColorException2 extends Exception{
    public ColorException2(String message){
        super(message);
    }
}
class TypeException2 extends Exception{
    public TypeException2(String message){
        super(message);
    }

}