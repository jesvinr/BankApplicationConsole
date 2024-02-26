package withdraw;
import repository.Database;
import java.sql.SQLException;

public class WithdrawViewModel {
    //StorageModel storage = StorageModel.getInstance();
    Database db = Database.getInstance();


    boolean checkFromAccountIsValid(String accountNumber, String password) throws SQLException {
//        if(storage.checkAccountAndPassword(accountNumber,password)){
//            return true;
//        }
        if(db.checkAccountAndPasswordDb(accountNumber,password))
            return true;
        return false;
    }

    boolean checkAmountIsAvailable(String accountNumber,int amount) throws SQLException {

        //return storage.checkAmount(accountNum,amount);
        return db.withdrawAmountDb(accountNumber,amount);
    }
}
