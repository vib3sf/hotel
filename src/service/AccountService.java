package service;

import models.Account;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class AccountService {

    private static final Map<String, Account> accounts = new HashMap<>();


    public AccountService(){
        accounts.put("1", new Account("1", "1", "1", "1"));
    }


    public static Account getAccount(String login){
        return accounts.get(login);
    }

    public static Collection<Account> getAllAccounts(){
        return accounts.values();
    }

    public static boolean accountIsExist(String login){
        return accounts.containsKey(login);
    }
    public static void addAccount(String login, String password, String firstName, String lastName){
        accounts.put(login, new Account(login, password, firstName, lastName));
    }
}
