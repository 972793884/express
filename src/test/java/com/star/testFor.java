package com.star;

public class testFor {
    public static void main(String[] args) {
        new son().aa();
    }
}
class father {
    static {
        System.out.println("A");
    }
}
class son extends father{
    static {
        System.out.println("B");
    }
    public final static String C="C";
    void aa(){
        System.out.println("D");
    }
}