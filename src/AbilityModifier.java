public abstract class AbilityModifier extends AbilityScore{

    int abilityModifier;

    public AbilityModifier(int abilityScore, int abilityModifier) {
        super(abilityScore);
        this.abilityModifier = (abilityModifier-10)/2;
    }
}
