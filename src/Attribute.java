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
        return "This is " + (getAttributeName().charAt(0)=='a' ||
                            getAttributeName().charAt(0)=='e' ||
                            getAttributeName().charAt(0)=='i' ||
                            getAttributeName().charAt(0)=='o' ||
                            getAttributeName().charAt(0)=='u'? "an" : "a")
                + " " + getAttributeName() + " attribute. \n" +
                "It has a modifier of " + String.valueOf(getModifiedAbilityModifier()) +
                ", and an ability score of " + String.valueOf(getModifiedAbilityScore()) + ".";
    }
}
