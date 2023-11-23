package org.example;

public class Reptile extends Animal implements AnimalCharacteristics{

    @Override
    public String getBreathingOrgan() {
        return "Lungs";
    }

    @Override
    public String getSkinType() {
        return "Scales";
    }

    @Override
    public String description() {
        return this.getDescription()+"\nBreathes using" + this.getBreathingOrgan() + "and has a skin type, " + this.getSkinType();
    }
}
