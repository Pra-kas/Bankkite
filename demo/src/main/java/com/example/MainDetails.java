package com.example;

import java.sql.SQLException;

public class MainDetails {

    static void Mswitch() throws SQLException{
        System.out.println("1.Deposit\n2.Withdraw\n3.TransactionHistory\n4.Balance\n\n");
        System.out.print("Enter your choice : ");
        int n = InputHandler.inputInt();
        switch(n){
            case 1:
                Deposit.deposit();
                break;

            case 2:
                WithDraw.withDraw();
                break;

            case 3:
                Transfer.transfer();
                break;

            case 4:
                CheckBalance.checkBalance();
                break;
        }
    }
}
