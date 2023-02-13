public abstract class AbilityScore {
    int abilityScore;

    public AbilityScore(int abilityScore) {
        this.abilityScore = abilityScore;
    }

    public int getAbilityScore() {
        return abilityScore;
    }

    public void setAbilityScore(int abilityScore) {
        this.abilityScore = abilityScore;
    }

    public void modifyScore(int modifier){
        this.abilityScore = abilityScore + modifier;
    }
}
