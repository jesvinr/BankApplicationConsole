package money_transfer;

import repository.Database;

import java.sql.SQLException;

public class MoneyTransferViewModel {
    private Database db = Database.getInstance();

    boolean checkFromAccountIsValid(String accountNumber, String password) throws SQLException {
        if(db.checkAccountAndPasswordDb(accountNumber,password)) return true;
        return false;
    }

    boolean checkAmountIsAvailable(String accountNum,int amount) throws SQLException {
        return db.checkAmountDb(accountNum,amount);
    }

    boolean checkToAccountIsValid(String toAcNum) throws SQLException {
        return db.checkAccountDb(toAcNum);
    }

    // To put money from one account to another
    boolean Exchange(String fromAcNum, String toAcNum, int money) throws SQLException {
        return db.exchangeAmountDb(fromAcNum,toAcNum,money);
    }

    // To put money in citizens bank account
    public boolean putMoney(String acNum, int amount) throws SQLException {
        return db.putAmount(acNum,amount);
    }
}
