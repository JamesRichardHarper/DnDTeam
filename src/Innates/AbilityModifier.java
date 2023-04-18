package Innates;

public abstract class AbilityModifier extends AbilityScore{

    int baseAbilityModifier = 0;
    int modifiedAbilityModifier = 0;

    public AbilityModifier(){
        super();
    }

    public AbilityModifier(int baseAbilityScore) {
        super(baseAbilityScore);
        this.baseAbilityModifier = dndModifier(baseAbilityScore);
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
        setModifiedAbilityModifier(getBaseAbilityModifier());
    }

    public int dndModifier(int score){
        return (score-10)/2;
    }

    /*
    Overrides for the Abilityscore modifications to change the modifiers too

    This ideally needs finishing but the branch is for fighting so *shrug*

    @Override
    public void setModifiedAbilityScore(int modifiedAbilityScore) {
        this.modifiedAbilityScore = modifiedAbilityScore;
        setBaseAbilityModifier();
    }

    @Override
    public void setBaseAbilityScore(int baseAbilityScore) {
        this.baseAbilityScore = baseAbilityScore;
    }
    */

    @Override
    public Boolean modifyAbility(int changeAmount, Boolean improve){
        if (improve){
            setModifiedAbilityScore(getModifiedAbilityScore() + changeAmount);
            return true;
        }
        else{
            if (getModifiedAbilityScore() > changeAmount) {
                setModifiedAbilityScore(getModifiedAbilityScore() + changeAmount);
                return true;
            }
            else {
                return false;
            }
        }
    }
}

