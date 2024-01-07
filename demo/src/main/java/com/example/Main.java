package com.example;

import java.io.IOError;
import java.sql.SQLException;

class StartingPoint{
    StartingPoint(){
        System.out.println("\n");
        System.out.println("     BANKING APPLICATION     \n\n");
        System.out.println("1.LOGIN\n2.CREATE ACCOUNT\n");
    }
    void SwitchCase(int n) throws SQLException{
        switch (n) {
            case 1:
                Login.login();
                break;

            case 2:
                CreateAccount.createAccount();
                break;
        
            default:
                break;
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOError, SQLException {
        StartingPoint s = new StartingPoint();
        while(true){
            System.out.print("Enter your choice : ");
            int n = InputHandler.inputInt();
            s.SwitchCase(n);  
        }
    }
}