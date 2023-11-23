package org.example;

public class Mammal extends Animal implements AnimalCharacteristics{
    @Override
    public String getBreathingOrgan() {
        return "Lungs";
    }

    @Override
    public String getSkinType() {
        return "Fur or Hair";
    }

    @Override
    public String description() {
        return this.getDescription()+"\nBreathes using" + this.getBreathingOrgan() + "and has a skin type, " + this.getSkinType();
    }


}
