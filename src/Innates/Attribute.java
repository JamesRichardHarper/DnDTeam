package Innates;

public class Attribute extends AbilityModifier{

    String attributeName;
    boolean isMental;

    public Attribute(int baseAbilityScore, String attributeName, boolean isMental) {
        super(baseAbilityScore);
        this.attributeName = attributeName;
        this.isMental = isMental;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public boolean isMental() {
        return isMental;
    }

    public void setMental(boolean mental) {
        isMental = mental;
    }

    public String toString(){
        return "Innates.Attribute: Modifier - " + String.valueOf(getModifiedAbilityModifier()) + ", " +
                "Ability score of " + String.valueOf(getModifiedAbilityScore()) + ".";
    }
}
