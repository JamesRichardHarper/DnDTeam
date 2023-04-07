public enum Names {
    ABEL("Abel"),
    BEATRICE("Beatrice"),
    CARLY("Carly"),
    DAVE("Dave");

    private final String name;

    Names(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
