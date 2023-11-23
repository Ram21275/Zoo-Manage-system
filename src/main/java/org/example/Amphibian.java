package org.example;

public class Amphibian extends Animal implements AnimalCharacteristics{
    @Override
    public String getBreathingOrgan() {
        return "Lungs and Skin";
    }

    @Override
    public String getSkinType() {
        return "Moist and Glandular";
    }

    @Override
    public String description() {
        return this.getDescription()+"\nBreathes using" + this.getBreathingOrgan() + "and has a skin type, " + this.getSkinType();
    }

}
