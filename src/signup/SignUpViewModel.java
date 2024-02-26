package signup;

import repository.AccountDto;
import repository.Database;

import java.sql.SQLException;

public class SignUpViewModel {
    private Database db = Database.getInstance();
    private AccountDto account = new AccountDto();


    boolean checkFromAccountIsValid(String accountNumber, String password) throws SQLException {
        if(db.checkAccountAndPasswordDb(accountNumber,password)) {
            account = db.getAccountDb(accountNumber);
            return true;
        }
        return false;
    }

    public String getNameVm(){
        return account.getName();
    }
    public int getAgeVm(){
        return account.getAge();
    }
    public String getPhoneNumberVm(){return account.getPhoneNumber();}
    public int getAmountVm(){return account.getAmount();}
    public String getAccountNumberVm(){return account.getAccountNumber();}
}
