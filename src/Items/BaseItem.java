package Items;

public abstract class BaseItem {
    String damageType;
    int diceDamage;
    int minimumDamage;
    boolean inverse;

    public BaseItem(String damageType, int diceDamage, int minimumDamage, boolean inverse) {
        this.damageType = damageType;
        this.diceDamage = diceDamage;
        this.minimumDamage = minimumDamage;
        this.inverse = inverse;
    }

    public String getType() {
        return damageType;
    }

    public void setType(String type) {
        damageType = type;
    }

    public int getDiceDamage() {
        return diceDamage;
    }

    public void setDiceDamage(int diceDamage) {
        this.diceDamage = diceDamage;
    }

    public int getMinimumDamage() {
        return minimumDamage;
    }

    public void setMinimumDamage(int minimumDamage) {
        this.minimumDamage = minimumDamage;
    }

    public boolean isInverse() {
        return inverse;
    }

    public void setInverse(boolean inverse) {
        this.inverse = inverse;
    }
}
