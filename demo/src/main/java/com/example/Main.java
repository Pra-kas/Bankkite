package com.example;

import com.example.CheckBalance;
import com.example.CreateAccount;
import com.example.Deposit;
import com.example.Login;
import java.util.Scanner;

class StartingPoint{
    StartingPoint(){
        System.out.println("\n");
        System.out.println("     BANKING APPLICATION     \n\n");
        System.out.println("1.LOGIN\n2.CREATE ACCOUNT\n3.CHECK BALANCE\n4.DEPOSIT\n5.WITHDRAW\n6TRANSFER");
    }
    void SwitchCase(int n){
        switch (n) {
            case 1:
                Login.login();
                break;

            case 2:
                CreateAccount.createAccount();
                break;

            case 3:
                CheckBalance.checkBalance();
                break;

            case 4:
                Deposit.deposit();
                break;

            case 5:
                WithDraw.withDraw();
                break;

            case 6:
                Transfer.transfer();
                break;
        
            default:
                break;
        }
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        StartingPoint s = new StartingPoint();
        try (Scanner inputScanner = new Scanner(System.in)) {
            while (true){
                System.out.print("Enter your choice : ");
                int n = inputScanner.nextInt();
                s.SwitchCase(n);
                // inputScanner.close();
            }
        }
    }
}