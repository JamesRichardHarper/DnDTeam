package CharacterInnates;

public abstract class AbilityScore {
    int baseAbilityScore = 0;
    int modifiedAbilityScore= 0;

    public AbilityScore(){
        this.baseAbilityScore = 10;
        this.modifiedAbilityScore = 10;
    }

    public AbilityScore(int baseAbilityScore) {
        this.baseAbilityScore = baseAbilityScore;
        this.modifiedAbilityScore = baseAbilityScore;
    }

    public int getModifiedAbilityScore() {
        return modifiedAbilityScore;
    }

    public void setModifiedAbilityScore(int modifiedAbilityScore) {
        this.modifiedAbilityScore = modifiedAbilityScore;
    }

    public int getBaseAbilityScore() {
        return baseAbilityScore;
    }

    public void setBaseAbilityScore(int baseAbilityScore) {
        this.baseAbilityScore = baseAbilityScore;
    }

    public void resetScore(){
        setModifiedAbilityScore(getBaseAbilityScore());
    }

    public Boolean modifyAbility(int changeAmount, Boolean improve){
        if (improve){
            setModifiedAbilityScore(Math.min((changeAmount + getModifiedAbilityScore()), (getBaseAbilityScore())));
            return true;
        }
        else{
            setModifiedAbilityScore(getModifiedAbilityScore() - changeAmount);
            if (getModifiedAbilityScore() > 0) {
                return true;
            }
            else {
                return false;
            }
        }
    }
}
