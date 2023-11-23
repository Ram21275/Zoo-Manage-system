package org.example;

public class PremiumVisitor extends Visitor{
    public PremiumVisitor(Visitor v) {
        super(v.getName(),v.getPassword(),v.getAge(),v.getPhoneNumbers(),v.getBalance(),v.getEmail());
    }

    @Override
    public void buyTicket(){
        System.out.println("No need to buy tickets you're a premium member and can visit any attraction with your membership card");
    }

    @Override
    public void visitAtt(){

    }
}
