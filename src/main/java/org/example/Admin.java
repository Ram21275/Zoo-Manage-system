package org.example;
import java.util.*;
public class Admin{
    static FastReader scan = new FastReader();
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "pass";
    private static int revenue;

    private static ArrayList<Attraction> attractions = new ArrayList<>();
    private static ArrayList<Animal> animals = new ArrayList<>();
    private static ArrayList<Event> events = new ArrayList<>();
    private static ArrayList<Discount> discounts = new ArrayList<>();
    private static ArrayList<Feedback> feedbacks = new ArrayList<>();
    private static ArrayList<Visitor> visitor = new ArrayList<>();
    private static ArrayList<String> sd = new ArrayList<>();

    public static ArrayList<Attraction> getAttractions() {
        return attractions;
    }

    public static ArrayList<Event> getEvents() {
        return events;
    }

    public static ArrayList<Feedback> getFeedbacks() {
        return feedbacks;
    }

    public static ArrayList<String> getSd() {
        return sd;
    }

    //
//    public static void setAttractions(List<Attraction> attractions) {
//        this.attractions = attractions;
//    }
//
    public static ArrayList<Animal> getAnimals() {
        return animals;
    }
    public static void incrementRev(int n){
        revenue+=n;
    }

    public static int getRevenue() {
        return revenue;
    }

    public static void setRevenue(int revenue) {
        Admin.revenue = revenue;
    }

    public static ArrayList<Discount> getDiscounts() {
        return discounts;
    }
    //
//    public void setAnimals(List<Animal> animals) {
//        this.animals = animals;
//    }
//
//    public List<Event> getEvents() {
//        return events;
//    }
//
//    public void setEvents(List<Event> events) {
//        this.events = events;
//    }
//
//    public List<Feedback> getFeedbacks() {
//        return feedbacks;
//    }
//
//    public void setFeedbacks(List<Feedback> feedbacks) {
//        this.feedbacks = feedbacks;
//    }


    public static ArrayList<Visitor> getVisitor() {
        return visitor;
    }

    public Admin() {}

    public static void addVisitor(Visitor v){
        visitor.add(v);
    }
    public static void addAnimal(Animal a){
        animals.add(a);
    }
    public static void addAtt(Attraction a){
        attractions.add(a);
    }
    public static void removeVisitor(Visitor v){
        visitor.remove(v);
    }
    public static void addFeedback(Feedback f){
        feedbacks.add(f);
    }
    private static int choosing(){
        FastReader scan = new FastReader();
        System.out.print("Enter your choice: ");
        int choice = scan.nextInt();
        return choice;
    }
    public static boolean login(String name, String password){
        if(name.equals(USERNAME) && password.equals(PASSWORD)){
            return true;
        }
        else{
            return false;
        }
    }

    public static void ManageAttractions(){
        System.out.println("Manage Attractions");
        System.out.println("1. Add Attraction\n2. View Attractions\n3. Modify Attraction\n4. Remove Attraction\n5. Exit");
        int ch = choosing();
        if(ch == 5) Admin.AdminMode(null);
        else if (ch == 1) {
            System.out.print("Enter Attraction Name: ");
            String n = scan.nextLine();
            System.out.print("Enter Attraction Description: ");
            String description = scan.nextLine();
            Attraction a = new Attraction(n,description);
            attractions.add(a);
            System.out.println();
            ManageAttractions();
        }
        else if (ch == 2) {
            int i = 0;
            for(Attraction a : attractions){
                System.out.print(a.getID());
                System.out.println("."+a.getName());
            }
            System.out.println();
            ManageAttractions();
        }
        else if (ch == 3) {
            System.out.println("What do you wanna update in Attraction Name/Description(1 for name, 2 for Description): ");
            int r = scan.nextInt();
            if(r==1){
                System.out.print("Enter ID: ");
                int n = scan.nextInt();
                Attraction a = getAttractionByID(n);
                System.out.print("Enter New Attraction Name: ");
                String newn = scan.nextLine();
                a.setName(newn);
            }
            else if(r==2){
                System.out.print("Enter ID: ");
                int n = scan.nextInt();
                Attraction a = getAttractionByID(n);
                System.out.print("Enter New Attraction Description: ");
                String newn = scan.nextLine();
                a.setDescription(newn);
            }
            ManageAttractions();
        }
        else if (ch == 4) {
            System.out.print("Enter Attraction Name: ");
            String n = scan.nextLine();
            removeAtt(n);
            ManageAttractions();
        }
    }
    private static void removeAtt(String name) {
        for (int i = 0; i < attractions.size(); i++) {
            Attraction att = attractions.get(i);

            if (att.getName().equals(name)) {
                attractions.remove(i);
                System.out.println("Attraction removed successfully.");
                return;
            }
        }

        System.out.println("No attraction found with the given name.");
    }
    public static Attraction getAttractionByID(int n) {
        for (Attraction attraction : attractions) {
            if (attraction.getID()==n) {
                return attraction;
            }
        }

        return null;
    }
    public static Animal choosingClass(String n){
        String type = scan.nextLine();
        Animal anml = null;
        switch (type) {
            case "Mammal":
                anml = new Mammal();
                break;
            case "Amphibian":
                anml = new Amphibian();
                break;
            case "Reptile":
                anml = new Reptile();
                break;
            default:
                System.out.println("Invalid animal type. Please enter Mammal, Amphibian, or Reptile.");
//                    ManageAnimals();
        }
        if(anml!=null)
        {
            anml.setName(n);
            animals.add(anml);
            System.out.println("Animal added to Zoo...");
        }
        return anml;
    }
    public static void ManageAnimals(){
        System.out.println("1. Add Animal");
        System.out.println("2. Update Animal Details");
        System.out.println("3. Remove Animal");
        System.out.println("4. Exit");
        int ch = choosing();
        if(ch == 4) Admin.AdminMode(null);
        else if(ch == 1){
            System.out.println("Enter Animal Name: ");
            String n = scan.nextLine();
            System.out.println("Enter Animal Type(Mammal, Amphibian, Reptile): ");
            Animal anml = choosingClass(n);
            System.out.println("Enter Animal sound: ");
            String sound = scan.nextLine();
            System.out.println("Enter Animal Description: ");
            String des = scan.nextLine();
            if(anml!=null){
                anml.setSound(sound);
                anml.setDescription(des);
            }
            ManageAnimals();
        }else if(ch == 2){
            System.out.println("Enter Animal Name: ");
            String name = scan.nextLine();
            System.out.println("What do you wanna update: ");
            System.out.println("1. Name");
            System.out.println("2. Type");
            Animal aa = null;
            for(Animal a: animals){
                if(a.getName().equals(name)) {
                    aa = a;
                    break;
                }
            }
            int choo = choosing();
            if(choo==1){
                System.out.println("Enter new name: ");
                String nname = scan.nextLine();
                aa.setName(nname);
            } else if (choo==2) {
                System.out.println("Enter new type(Mammal, Amphibian, or Reptile): ");
                String n = aa.getName();
                animals.remove(aa);
                choosingClass(n);
            }
            else{
                System.out.println("Wrong Option....");
            }
            ManageAnimals();

        }else if(ch == 3){
            System.out.print("Enter Animal Name: ");
            String n = scan.nextLine();
            removeAnimal(n);
            ManageAnimals();
        }
        else{
            System.out.println("Invalid Input..");
            ManageAnimals();
        }

    }

    private static void removeAnimal(String name) {
        for (int i = 0; i < animals.size(); i++) {
            Animal animal = animals.get(i);

            if (animal.getName().equals(name)) {
                animals.remove(i);
                System.out.println("Animal removed successfully.");
                return;
            }
        }

        System.out.println("No animal found with the given name.");
    }


    public static void ScheduleEvents(){

    }

    public static void setDiscounts(){
        System.out.println("1. Add Discount");
        System.out.println("2. Modify Discount");
        System.out.println("3. Remove Discount");
        System.out.println("4. Exit");
        int ch = choosing();
        if(ch == 4) Admin.AdminMode(null);
        else if (ch==1) {
            System.out.print("Enter Discount Category: ");
            String cat = scan.nextLine();
            System.out.print("Enter Discount Percentage(<20): ");
            double percentage = scan.nextDouble();
            Discount d = new Discount(cat,percentage);
            discounts.add(d);
            System.out.println("Discount added successfully...\n");
            setDiscounts();
        } else if (ch==2) {
            System.out.println("Enter category: ");
            String cat = scan.nextLine();
            Discount d  = getDiscountByName(cat);
            System.out.println("What do you wanna change Category/Percentage");
            System.out.println("press 1 for category and 2 for percentage");
            int chh = scan.nextInt();
            if (chh==1){
                System.out.println("enter new name:");
                String cat2 = scan.nextLine();
                d.setCategory(cat2);
                System.out.println("modified successfully");
            } else if (chh==2) {
                System.out.println("enter new percentage:");
                double per = scan.nextDouble();
                d.setPercentage(per);
                System.out.println("modified successfully");

            }
            setDiscounts();
        } else if (ch==3) {
            System.out.print("Enter Discount Category: ");
            String cat = scan.nextLine();
            removeDiscount(cat);
            setDiscounts();
        }

    }
    public static Discount getDiscountByName(String name) {
        for (Discount attraction : discounts) {
            if (attraction.getCategory().equals(name)) {
                return attraction;
            }
        }
        return null;
    }
    private static void removeDiscount(String name){
        for (int i = 0; i < discounts.size(); i++) {
            Discount dis = discounts.get(i);

            if (dis.getCategory().equals(name)) {
                discounts.remove(i);
                System.out.println("Discount removed successfully.");
                return;
            }
        }

        System.out.println("No Discount found with the given Category.");
    }

    public static void setSpecialDeals(){
        System.out.println("1. Add Special Deals");
        System.out.println("2. Remove Special Deals");
        System.out.println("3. Exit");
        int ch = choosing();
        if(ch==3) Admin.AdminMode(null);
        else if(ch==1){
            System.out.println("Add Special Deal-");
            String s = scan.nextLine();
            sd.add(s);
            setSpecialDeals();
        } else if (ch==2) {
            int i = 0;
            for(String s: sd){
                System.out.println(++i);
                System.out.println(s);
            }
            System.out.println("Enter your choice to be removed-");
            int chh = choosing();
            sd.remove(chh-1);
            setSpecialDeals();
        }
    }

    private static void viewFeedback(){
        for(Feedback f: feedbacks){
            System.out.println(f.getV().getName()+":");
            System.out.println(f.getMessage());
        }
    }

    public static void start(){
        System.out.print("Enter Name: ");
        String name  = scan.nextLine();
        System.out.print("Enter Password: ");
        String password = scan.nextLine();
        boolean log = login(name,password);
        if(!log) {
            System.out.println("Username and Password are incorrect. Try Again.");
            Main.main(null);
        }
        else{
            System.out.println("Successfully Logged In!!\n");
            AdminMode(null);
        }
    }
    public static void AdminMode(String[] args){
        System.out.println("Admin Menu:");
        System.out.println("1. Manage Attractions");
        System.out.println("2. Manage Animals");
        System.out.println("3. Schedule Events");
        System.out.println("4. Set Discounts");
        System.out.println("5. Set Special Deals");
        System.out.println("6. View Visitor Stats");
        System.out.println("7. View Feedback");
        System.out.println("8. Exit");
        System.out.print("Enter your choice: ");
        int choice = scan.nextInt();
        System.out.println();

        if(choice == 8) Main.main(null);
        else if (choice == 1) {
            ManageAttractions();
        }
        else if (choice == 2) {
            ManageAnimals();
        }
        else if (choice == 3) {

        }
        else if (choice == 4) {
            setDiscounts();
        }
        else if (choice == 5) {
            setSpecialDeals();
        }
        else if (choice == 6) {
            System.out.println("-Total Visitors- "+ visitor.size());
            System.out.println("-Total Revenue- "+ revenue);
            Attraction max = attractions.get(0);
            for(Attraction at: attractions){
                if(at.getVisits()>max.getVisits()) max = at;
            }
            System.out.println("- Most Popular Attraction- "+max.getName());
            Admin.AdminMode(null);
        }
        else if (choice == 7) {
            viewFeedback();
        }
        else{
            System.out.println("Invalid Choice, Try again");
            Admin.AdminMode(null);
        }
    }
}
