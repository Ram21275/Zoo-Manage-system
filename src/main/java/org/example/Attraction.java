package org.example;
import java.util.*;
public class Attraction {
    private static int nextid = 1;
    private int visits = 0;
    private int id;
    private String name;
    private String description;
    private int price;

    public void incVisits(){
        this.visits++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public Attraction(String name, String description) {
        this.id = nextid++;
        this.name = name;
        this.description = description;
        Random rand = new Random();
        int lowerBound = 10;
        int upperBound = 25;
        int randomNum = rand.nextInt((upperBound - lowerBound) + 1) + lowerBound;
        this.price = randomNum;
    }

    public int getID() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public int getVisits() {
        return visits;
    }
}
