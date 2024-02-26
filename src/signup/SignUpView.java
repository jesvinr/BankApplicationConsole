package signup;

import java.sql.SQLException;
import java.util.Scanner;

public class SignUpView {
    public void init() throws SQLException {
        Scanner sc = new Scanner(System.in);
        SignUpViewModel suvm = new SignUpViewModel();
        boolean loop = true;

        String acNum="";
        String pass = "";

        while(loop) {
            System.out.print("Enter account number: ");
            acNum = sc.next();
            System.out.print("Enter account password: ");
            pass = sc.next();
            if(!suvm.checkFromAccountIsValid(acNum,pass)){
                System.out.println("Please enter valid account number and password...");
                continue;
            }
            loop = false;
        }
        System.out.println();
        System.out.println("################## Account Details ##################");
        System.out.println("Account holder name: "+suvm.getNameVm());
        System.out.println("Account number: "+suvm.getAccountNumberVm());
        System.out.println("Phone number: "+suvm.getPhoneNumberVm());
        System.out.println("Age: "+suvm.getAgeVm());
        System.out.println("Bank balance: "+suvm.getAmountVm());
        System.out.println();

    }
}
