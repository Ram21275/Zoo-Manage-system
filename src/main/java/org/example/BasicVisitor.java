package org.example;

public class BasicVisitor extends Visitor{
    public BasicVisitor(Visitor v) {
        super(v.getName(),v.getPassword(),v.getAge(),v.getPhoneNumbers(),v.getBalance(),v.getEmail());
    }

}
