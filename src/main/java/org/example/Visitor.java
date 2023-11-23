package org.example;
import java.util.*;
public class Visitor {
    private String name;
    private static String email;
    private int age;
    private String password;
    private int phoneNumbers;
    private int balance;
    private String status;
    private FastReader scan = new FastReader();

    public String getStatus() {
        return status;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        Visitor.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public static String getEmial() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getPhoneNumbers() {
        return phoneNumbers;
    }

    public int getBalance() {
        return balance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void setEmial(String emial) {
        Visitor.email = emial;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNumbers(int phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Visitor(String name, String password,int age, int phoneNumbers, int balance,String em) {
        this.name = name;
        this.password = password;
        this.phoneNumbers = phoneNumbers;
        this.balance = balance;
        this.email = em;
        this.status = "Normal";
        this.age = age;
    }
    private int choosing(){
        FastReader scan = new FastReader();
        System.out.print("Enter your choice: ");
        int choice = scan.nextInt();
        System.out.println();
        return choice;
    }
    public void expZoo(Visitor v){
        System.out.println("1. View Attractions");
        System.out.println("2. View Animals");
        System.out.println("3. Exit");
        int ch = choosing();
        if (ch==3) Main.mainVisitorMode(v);
        else if (ch==1) {
            for(int i=0;i<Admin.getAttractions().size();i++ ){
                System.out.print(i+1);
                System.out.println(" "+Admin.getAttractions().get(i).getName());
            }
            int chh = choosing();
            if(chh<Admin.getAttractions().size()) System.out.println(Admin.getAttractions().get(chh).getDescription());
            else System.out.println("try again..");

            expZoo(v);

        } else if (ch==2) {
            for(Animal a:Admin.getAnimals() ){
                System.out.println("Name - "+a.getName());
                System.out.println("Type - "+a.getClass().getSimpleName());
                if (a instanceof Mammal) {
                    Mammal m = (Mammal) a;
                    System.out.println("Breathing organ - "+m.getBreathingOrgan());
                    System.out.println("Skin type - "+m.getSkinType());
                } else if (a instanceof Amphibian) {
                    Amphibian m = (Amphibian) a;
                    System.out.println("Breathing organ - "+m.getBreathingOrgan());
                    System.out.println("Skin type - "+m.getSkinType());
                }
                else if (a instanceof Reptile) {
                    Reptile m = (Reptile) a;
                    System.out.println("Breathing organ - "+m.getBreathingOrgan());
                    System.out.println("Skin type - "+m.getSkinType());
                }
                System.out.println();
            }
            expZoo(v);
        }
    }

    public void leaveFeedback(Visitor v) {
        System.out.println("Enter your feedback (max 50 words):");
        String message = scan.nextLine();

        String[] words = message.split("\\s+");
        if (words.length > 50) {
            System.out.println("Your feedback is too long. Please limit it to 50 words.");
            leaveFeedback(v);
        } else {
            Feedback f = new Feedback(message,v);
            Admin.addFeedback(f);
            System.out.println("Thank you for your feedback.\n");
            Main.mainVisitorMode(v);
        }
    }

    public int WalletDeductions(int x){
        if((this.balance-x)>=0){
            this.balance-=x;
            Admin.incrementRev(x);
            return 1;
        }
        else{
            System.out.println("Request can't be completed due to insufficient balance");
            return 0;
        }
    }

    public Visitor UpgradeStatus(){
        System.out.println("Your current status is: "+this.status);
        Scanner sc=new Scanner(System.in);
        System.out.print("Choose new status: ");
        String newstat=sc.next();
        if(this.status.equals("Basic") && newstat.equals("Premium")){
            if(this.WalletDeductions(30)==1){
                //this.status="Elite";
                PremiumVisitor cust=new PremiumVisitor(this);
                Admin.addVisitor(cust);
                Admin.removeVisitor(this);
                System.out.println("Basic Membership purchased successfully. Your balance is now Rs."+this.balance);
                return cust;
            }

        }
        if(newstat.equals("Premium")){
            if(this.WalletDeductions(50)==1){

                PremiumVisitor cust=new PremiumVisitor(this);
                Admin.addVisitor(cust);
                Admin.removeVisitor(this);
                System.out.println("Basic Membership purchased successfully. Your balance is now Rs."+this.balance);
                return cust;

            }

        }
        if(newstat.equals("Basic")){
            if(this.WalletDeductions(20)==1){
                BasicVisitor cust=new BasicVisitor(this);
                Admin.addVisitor(cust);
                Admin.removeVisitor(this);
                System.out.println("Basic Membership purchased successfully. Your balance is now Rs."+this.balance);
                return cust;
            }

        }
        return this;
    }

    public void GetDiscounts(){
        int i = 1;
        System.out.println("View Discounts");
        for(Discount d: Admin.getDiscounts()){
            i++;
            System.out.println(i+". "+d.getCategory()+"("+d.getPercentage()+"% discount) - "+d.getCategory().toUpperCase()+d.getPercentage());
        }
        Main.mainVisitorMode(this);
    }

    public void buyTicket(){
        Attraction a = null;
        for(Attraction at: Admin.getAttractions()){
            System.out.println(at.getID());
            System.out.println(at.getName());
        }
        int ch = choosing();
        a = Admin.getAttractionByID(ch);
        if(this.WalletDeductions(a.getPrice())==1) {
            balance-=a.getPrice();
            Admin.incrementRev(a.getPrice());
        }
        a.incVisits();
        Main.mainVisitorMode(this);
    }

    public void visitAnimal(){
        System.out.println("1. Feed the animal");
        System.out.println("2. Read about the animal");
        System.out.println("3. Exit");
        int ch = choosing();
        if(ch==3) Main.mainVisitorMode(this);
        else if(ch==1) {
            for(Animal a:Admin.getAnimals() ){
                System.out.println("Name - "+a.getName());
                System.out.println("Type - "+a.getClass().getSimpleName());
                System.out.println();
            }
            System.out.println("Enter animal name you wanna feed: ");
            String name = scan.nextLine();
            Animal aa = null;
            for(Animal a:Admin.getAnimals() ){
                if(a.getName().equals(name)) aa = a;
            }
            if (aa!=null){
                aa.getSound();
                visitAnimal();
            }
            else{
                System.out.println("Such animal doesn't exist");
                visitAnimal();
            }

        }
        else if(ch==2){
            for(Animal a:Admin.getAnimals() ){
                System.out.println("Name - "+a.getName());
                System.out.println("Type - "+a.getClass().getSimpleName());
                System.out.println();
            }
            System.out.println("Enter animal name you wanna feed: ");
            String name = scan.nextLine();
            Animal aa = null;
            for(Animal a:Admin.getAnimals() ){
                if(a.getName().equals(name)) aa = a;
            }
            if (aa!=null){
                if (aa instanceof Mammal) {
                    Mammal m = (Mammal) aa;
                    m.description();
                } else if (aa instanceof Amphibian) {
                    Amphibian m = (Amphibian) aa;
                    m.description();
                }
                else if (aa instanceof Reptile) {
                    Reptile m = (Reptile) aa;
                    m.description();
                }
                visitAnimal();
            }
            else{
                System.out.println("Such animal doesn't exist");
                visitAnimal();
            }
        }
    }

    public void visitAtt(){
        for(int i=0;i<Admin.getAttractions().size();i++ ){
            System.out.print(i+1);
            System.out.println(" "+Admin.getAttractions().get(i).getName());
        }
        int chh = choosing();
        if(chh<Admin.getAttractions().size()) System.out.println(Admin.getAttractions().get(chh).getDescription());
        else System.out.println("try again..");

    }
}
