package org.example;
import java.sql.SQLOutput;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();

    static void VisitorMode(){
        System.out.println("1. Register");
        System.out.println("2. Login");

        System.out.println("Enter you choice: ");
        int ch = scan.nextInt();
        if(ch==1){
            System.out.print("Enter Visitor Name: ");
            String name = scan.nextLine();
            System.out.print("Enter Visitor Age: ");
            int age = scan.nextInt();
            System.out.print("Enter Visitor Phone Number: ");
            int phn = scan.nextInt();
            System.out.print("Enter Visitor Balance: ");
            int bal = scan.nextInt();
            System.out.print("Enter Visitor Email: ");
            String ema = scan.nextLine();
            System.out.print("Enter Visitor Password: ");
            String pass = scan.nextLine();

            Visitor v = new Visitor(name, pass, age,phn,bal,ema);
            Admin.addVisitor(v);
            System.out.println();
            VisitorMode();
        }
        else if(ch==2){
            System.out.print("Enter Visitor Name: ");
            String name = scan.nextLine();
            System.out.print("Enter Visitor Password: ");
            String pass = scan.nextLine();
            login(name,pass);
//            if (login(name,pass)==1){
//                mainVisitorMode();
//            }
        }
        else{
            System.out.println("Wrong Option");
            VisitorMode();
        }

    }
    public static void login(String name, String pass){
        int flag = 0;
        for(int i = 0; i < Admin.getVisitor().size(); i++) {
            Visitor v = Admin.getVisitor().get(i);
            if (name.equals(v.getName()) && pass.equals(v.getPassword())) {
                flag = 1;
                System.out.println("Welcome " + v.getName() + "\n");
                mainVisitorMode(v);
            }

        }
        if (flag==0) System.out.println("user doesn't exist try again..");

    }

    static void mainVisitorMode(Visitor v){
        System.out.println("Visitor menu:");
        System.out.println("1. Explore Zoo");
        System.out.println("2. Buy Membership");
        System.out.println("3. Buy Tickets");
        System.out.println("4. View Discounts");
        System.out.println("5. View Special Deals");
        System.out.println("6. Visit Animals");
        System.out.println("7. Visit Attractions");
        System.out.println("8. Leave Feedback");
        System.out.print("Enter your choice: ");
        int choice = scan.nextInt();
        if (choice==9){
            System.out.println("Looged Out");
            main(null);
        } else if (choice==1) {
            System.out.println("Explore the Zoo");
            v.expZoo(v);
        }
        else if (choice==2) {
            Visitor v2 = v.UpgradeStatus();
            mainVisitorMode(v2);
        }
        else if (choice==3) {
            v.buyTicket();
        }
        else if (choice==4) {
            v.GetDiscounts();
            mainVisitorMode(v);
        }
        else if (choice==5) {
            int j=0;
            for(String i:Admin.getSd()){
                System.out.print(++j);
                System.out.println(i);
            }
            mainVisitorMode(v);
        }
        else if (choice==6) {
            v.visitAnimal();
            mainVisitorMode(v);
        }
        else if (choice==7) {
            v.visitAtt();
            mainVisitorMode(v);
        }
        else if (choice==8) {
            System.out.println("Leave Feedback");
            v.leaveFeedback(v);
        }
        else{
            System.out.println("Wrong option..");
        }
    }


    public static void main(String[] args) {
        System.out.println("Welcome to ZOOtopia!");
        System.out.println("1. Enter as Admin");
        System.out.println("2. Enter as a Visitor");
        System.out.println("3. View Special Deals");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");

        int choice = scan.nextInt();
        if (choice == 4) {
            System.out.println("Thanks For Using Our Services....");
            System.exit(0);
        } else if (choice == 1) {
            Admin.start();
        } else if (choice == 2) {
            VisitorMode();
        } else if (choice == 3) {

        } else {
            System.out.println("Invalid choice. Please try again.\n");
            main(null);
        }
        int m = 0;
        m++;
        if(m==1){
            Attraction a = new Attraction("Jungle Safari","Safari yeah animals are fun");
            Attraction a2 = new Attraction("Botanical Garden","Garden yeah plants are fun");
            Attraction a3 = new Attraction("Dinosaur Adventure","Safari yeah dinosaur are fun");
            Admin.addAtt(a); Admin.addAtt(a2); Admin.addAtt(a3);

            Animal an = new Mammal();
            Animal an2 = new Amphibian();
            Animal an3 = new Mammal();
            Animal an4 = new Reptile();

            an.setName("Lion");
            an.setSound("Roar");
            an.setDescription(" Known as the ‘King of the Jungle’, lions are large felines that are traditionally depicted as the apex predator in various cultures around the world.");

            an3.setName("Elephant");
            an3.setSound("Trumpet");
            an3.setDescription("Elephants are the largest land animals currently living. They are known for their long trunks and large ears.");

            an4.setName("Snake");
            an4.setSound("Hiss");
            an4.setDescription("Snakes are elongated, legless reptiles known for their variety of species, some of which are venomous.");

            an2.setName("Frog");
            an2.setSound("Croak");
            an2.setDescription("Frogs are widely known for their distinctive sound and ability to jump far. They have semi-aquatic lifestyles and undergo metamorphosis from tadpole to adult.");
            Admin.addAnimal(an); Admin.addAnimal(an2); Admin.addAnimal(an3); Admin.addAnimal(an4);
        }

    }
}