package com.example;

public class MainDetails {

    static void Mswitch() throws Exception{
        System.out.println("1.Deposit\n2.Withdraw\n3.Transfer\n4.Balance\n5.Exit\n\n");
        System.out.print("Enter your choice : ");
        int n = InputHandler.inputInt();
        switch(n){
            case 1:
                SessionManager.session(Deposit.deposit());
                break;

            case 2:
                SessionManager.session(WithDraw.withDraw());
                break;

            case 3:
                Transfer.transfer();
                break;

            case 4:
                SessionManager.session(CheckBalance.checkBalance());
                break;

            case 5:
                SessionManager.LogOut();
                System.exit(0);
        }
    }
}
