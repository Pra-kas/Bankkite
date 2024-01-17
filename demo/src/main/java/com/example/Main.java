package com.example;

import java.io.IOError;

class StartingPoint{
    StartingPoint(){
        System.out.println("\n");
        System.out.println("     BANKING APPLICATION     \n\n");
        System.out.println("1.LOGIN\n2.CREATE ACCOUNT\n3.EXIT\n");
    }
    void SwitchCase(int n) throws Exception{
        switch (n) {
            case 1:
                Login.login();
                break;

            case 2:
                CreateAccount.createAccount();
                break;

            case 3:
                System.exit(0);
        
            default:
                break;
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOError, Exception {
        StartingPoint s = new StartingPoint();
        while(true){
            System.out.print("Enter your choice : ");
            int n = InputHandler.inputInt();
            s.SwitchCase(n);  
        }
    }
}