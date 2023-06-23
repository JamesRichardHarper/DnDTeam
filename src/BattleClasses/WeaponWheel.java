package BattleClasses;

import Settings.StatNames;

public class WeaponWheel {
    public double getMultiplier(String attackedAbility, String attackerAbility){
        double effectiveAttack = 1.5;
        double ineffectiveAttack = 0.5;

        switch(attackerAbility){
            case "Strength":
                if(attackedAbility.equalsIgnoreCase("Knowledge")){
                    return effectiveAttack;
                } else if (attackedAbility.equalsIgnoreCase("Wisdom")) {
                    return  ineffectiveAttack;
                }
                break;
            case "Knowledge":
                if(attackedAbility.equalsIgnoreCase("Wisdom")){
                    return effectiveAttack;
                } else if (attackedAbility.equalsIgnoreCase("Strength")){
                    return  ineffectiveAttack;
                }
                break;
            case "Willpower":
                if(attackedAbility.equalsIgnoreCase("Strength")){
                    return effectiveAttack;
                } else if (attackedAbility.equalsIgnoreCase("Knowledge")){
                    return  ineffectiveAttack;
                }
                break;
        }
        return 1.0;
    }
}
