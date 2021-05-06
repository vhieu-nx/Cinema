package controller;

import CheckInfor.CheckAcount;
import model.Account;

import java.util.ArrayList;
import java.util.Scanner;

public class AccountManager {
    Scanner scanner = new Scanner(System.in);
    private Account account;
    private ArrayList<Account> listAccount = new ArrayList<Account>();
    private static AccountManager INSTANCE;
    private AccountManager(){

    }
    public String getInformation(){
        return account.toString();
    }
    public static AccountManager getINSTANCE(){
        if (INSTANCE == null) INSTANCE = new AccountManager();
        return INSTANCE;
    }
    private String enterNameAccount(){
        String name = "";
        do{
            System.out.println("Enter your name account");
            name = new Scanner(System.in).nextLine();
        }while (!name.matches(CheckAcount.CHECK_ACCOUNT));
        return name;
    }
    private String enterPassword(){
        System.out.println("Enter your password account");
        String password = new Scanner(System.in).nextLine();
        return password;
    }
    private String enterEmail(){
        String email = "";
        do {
            System.out.println("Enter your Email account");
            email = new Scanner(System.in).nextLine();
        }while (!email.matches(String.valueOf(CheckAcount.CHECK_GMAIL)));
        return email;
    }
    public void createAccount(){
        Account account = new Account();
        account.setUsername(enterNameAccount());
        account.setPassword(enterPassword());
        account.setEmail(enterEmail());
        String result = checkInfor(enterNameAccount(),enterPassword(),enterEmail());
        if (result.equals("Save successfully")){
            System.out.println(result);
            listAccount.add(account);
        }
//        listAccount.add(account);
    }
    public boolean loginAccount (){
        String username = enterNameAccount();
        String password = enterPassword();
        for (Account account: listAccount
        ) {
            if(account.getUsername().equals(username)&&account.getPassword().equals(password)){
                this.account = account;
                return true;
            }
        }
        return false;
    }
    public String checkInfor(String username,String password,String email){
        String result = "";
        if (username.equals("")||password.equals("")||email.equals("")){
            result = "Dont leave information blank";
        }else if (!CheckAcount.checkAccount(username)){
            result = "Your input wrong username format";

        }else if (!CheckAcount.checkEmail(email)){
            result = "Your input wrong email format";
        }else {
            result = "Save successfully";
        }
        return result;
    }

}
