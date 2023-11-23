package org.example;

public class Discount {
    private String category;
    private double percentage;

    public Discount(String category, double percentage) {
        this.category = category;
        this.percentage = percentage;
    }

    public String getCategory() {
        return category;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
}
