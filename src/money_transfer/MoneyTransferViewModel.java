package money_transfer;

import repository.Database;

import java.sql.SQLException;

public class MoneyTransferViewModel {
    //private StorageModel storage = StorageModel.getInstance();
    private Database db = Database.getInstance();

    boolean checkFromAccountIsValid(String accountNumber, String password) throws SQLException {

//        if(storage.checkAccountAndPassword(accountNumber,password)){
//            return true;
//        }
        if(db.checkAccountAndPasswordDb(accountNumber,password)) return true;
        return false;
    }

    boolean checkAmountIsAvailable(String accountNum,int amount) throws SQLException {

        //return storage.checkAmount(accountNum,amount);
        return db.checkAmountDb(accountNum,amount);
    }

    boolean checkToAccountIsValid(String toAcNum) throws SQLException {
        //return storage.checkAccount(toAcNum);
        return db.checkAccountDb(toAcNum);
    }

    // to from money change
    boolean Exchange(String fromAcNum, String toAcNum, int money) throws SQLException {
        //AccountDto accountFrom = storage.
//        AccountDto toUser = storage.getAccount(toAcNum);
//        AccountDto fromUser = storage.getAccount(fromAcNum);
//        fromUser.setAmount(fromUser.getAmount()-money);
//        toUser.setAmount(toUser.getAmount()+money);
        return db.exchangeAmountDb(fromAcNum,toAcNum,money);
    }

    public boolean putMoney(String acNum, int amount) throws SQLException {
        //AccountDto user = storage.getAccount(acNum);
        //user.setAmount(user.getAmount()+amount);
        return db.putAmount(acNum,amount);
    }
}
