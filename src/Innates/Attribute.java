package Innates;

public class Attribute extends AbilityScore{
    String name;
    int regenerate;

    public Attribute(){
        super();
        this.regenerate = 1;
        this.name = "Unnamed Attribute";
    }
    public Attribute(int AbilityScore, int regenerate, String name){
        super(AbilityScore);
        this.regenerate = regenerate;
        this.name = name;
    }

    /*
    Getters & Setters
     */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRegenerate() {
        return regenerate;
    }

    public void setRegenerate(int regenerate) {
        this.regenerate = regenerate;
    }

    /*
    In-Game Methods
    Stat changes
     */
    public void adjustRegenerate(int changeAmount){
        setRegenerate(getRegenerate() + changeAmount);
    }
}
