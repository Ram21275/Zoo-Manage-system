package org.example;

abstract class Animal {
    private String name;
    private String sound;
    private String description;

    public void setSound(String sound) {
        this.sound = sound;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSound() {
        return sound;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
