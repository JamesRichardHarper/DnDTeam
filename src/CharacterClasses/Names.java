package CharacterClasses;

public enum Names {
    ABEL("Abel"),
    BEATRICE("Beatrice"),
    CARLY("Carly"),
    DAVE("Dave"),
    ZACKARIAH("Zackariah"),
    JAMES("James"),
    YELENA("Yelena"),
    XI("Xi"),
    MACK("Mack"),
    LUCILLE("Lucille"),
    TASHA("Tasha");

    private final String name;

    Names(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
