package com.driver;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public BankAccount(String name, double balance, double minBalance) {
        this.name = name;
        this.balance = balance;
        this.minBalance = minBalance;
    }
    public double getBalance(){
        return balance;
    }
    public void setBalance(Double balance){
        this.balance = balance;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
        for(int i = (int)Math.pow(10,digits-1) ; i<(int)Math.pow(10,digits) ; ++i)
            if(checkSum(i,sum)) return String.valueOf(i);
        return "Account Number can not be generated";
    }
    boolean checkSum(int number,int actualSum){
        int sum = 0;
        while(number!=0){
            int digit = number%10;
            sum+=digit;
            number = number/10;
        }
        return sum==actualSum;
    }

    public void deposit(double amount) {
        //add amount to balance
        balance+=amount;
    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
        if(balance<minBalance) throw new Exception("Insufficient Balance");
        double remainingBalance = balance - amount;
        if(remainingBalance<minBalance) throw new Exception("Insufficient Balance");
        balance-=amount;
    }

}