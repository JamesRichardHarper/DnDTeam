package Innates;

public abstract class AbilityModifier extends AbilityScore{

    int baseAbilityModifier = 0;
    int modifiedAbilityModifier = 0;

    public AbilityModifier(int baseAbilityScore) {
        super(baseAbilityScore);
        this.baseAbilityModifier = (baseAbilityScore-10)/2;
        this.modifiedAbilityModifier = baseAbilityModifier;
    }

    public int getBaseAbilityModifier() {
        return baseAbilityModifier;
    }

    public void setBaseAbilityModifier(int baseAbilityModifier) {
        this.baseAbilityModifier = baseAbilityModifier;
    }

    public int getModifiedAbilityModifier() {
        return modifiedAbilityModifier;
    }

    public void setModifiedAbilityModifier(int modifiedAbilityModifier) {
        this.modifiedAbilityModifier = modifiedAbilityModifier;
    }

    public void modifyModifier(int modifier){
        setModifiedAbilityModifier(getModifiedAbilityModifier() + modifier);
    }

    public void resetAbilityModifer(){
        setBaseAbilityModifier(getModifiedAbilityModifier());
    }
}

