package com.example;

class StartingPoint{
    StartingPoint(){
        System.out.println("\n");
        System.out.println("     BANKING APPLICATION     \n\n");
        System.out.println("1.LOGIN\n2.CREATE ACCOUNT\n3.CHECK BALANCE\n4.DEPOSIT\n5.WITHDRAW\n6TRANSFER");
    }
    void SwitchCase(int n){
        switch (n) {
            case 1:
                login();
                break;

            case 2:
                createAccount();
                break;

            case 3:
                checkBalance();
                break;

            case 4:
                deposit();
                break;

            case 5:
                withDraw();
                break;

            case 6:
                transfer();
                break;
        
            default:
                break;
        }
    }
    private void transfer() {
    }
    private void withDraw() {
    }
    private void deposit() {
    }
    private void checkBalance() {
    }
    private void login() {
    }
    private void createAccount() {
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        StartingPoint s = new StartingPoint();
    }
}