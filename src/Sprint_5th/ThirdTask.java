package Sprint_5th;

public class ThirdTask {
}

class Plant{
    private String name;
    private  Color color;
    private  Type type;

    public Plant(String type,String color,String name) throws TypeException, ColorException {
        try{
            this.type = Type.valueOf(type.toUpperCase());
        } catch (IllegalArgumentException exception){
            throw new TypeException("Invalid value "+ type +" for field type");
        }
        try {
            this.color = Color.valueOf(color.toUpperCase());
        }catch (IllegalArgumentException colorest){
            throw new ColorException("Invalid value " + color +" for field color");
        }
        this.name = name;
    }

    public static Plant tryCreatePlant(String typer,String colorer,String namer) throws TypeException, ColorException {
        Plant planter = null;
        try {
           try{ planter = new Plant(typer,colorer,namer);}
               catch (TypeException typeException){
                   planter = new Plant("ORDINARY",colorer,namer);
               }catch (ColorException cp){
                   planter = new Plant(typer,"RED",namer);}
        }catch (Exception ex){
            planter = new Plant("ORDINARY","RED",namer);
        }
        return planter;
    }

    public String getName(){
        return name;
    }
    public Color getColor(){
        return color;
    }
    public Type getType(){
        return type;
    }
    @Override
    public String toString(){
        return "{type: "+type+", color: "+ color+", name: " + name + "}";
    }
}

enum Color{
    WHITE,RED,BLUE
}
enum Type{
    RARE,ORDINARY
}

class ColorException extends Exception{
    public ColorException(String message){
        super(message);
    }
}
class TypeException extends Exception{
    public TypeException(String message){
        super(message);
    }
}