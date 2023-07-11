package Settings;

public enum StatNames {
    STRENGTH("Strength"),
    KNOWLEDGE("Knowledge"),
    WILLPOWER("Willpower");

    private final String stat;

    StatNames(String stat){
        this.stat = stat;
    }

    public String getName(){
        return this.stat;
    }
}
