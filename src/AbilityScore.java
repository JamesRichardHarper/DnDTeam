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

    public void modifyScore(int modifier){
        setModifiedAbilityScore(getModifiedAbilityScore() + modifier);
    }

    public void resetScore(){
        setModifiedAbilityScore(getBaseAbilityScore());
    }
}
