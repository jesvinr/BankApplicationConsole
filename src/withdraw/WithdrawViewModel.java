package withdraw;
import repository.Database;
import java.sql.SQLException;

public class WithdrawViewModel {
    Database db = Database.getInstance();


    boolean checkFromAccountIsValid(String accountNumber, String password) throws SQLException {
        if(db.checkAccountAndPasswordDb(accountNumber,password))
            return true;
        return false;
    }

    boolean checkAmountIsAvailable(String accountNumber,int amount) throws SQLException {
        return db.withdrawAmountDb(accountNumber,amount);
    }
}
