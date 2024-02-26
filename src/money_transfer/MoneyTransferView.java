package money_transfer;

import java.sql.SQLException;
import java.util.Scanner;

public class MoneyTransferView {
    public void init() throws SQLException {
        Scanner sc = new Scanner(System.in);
        MoneyTransferViewModel mtvm = new MoneyTransferViewModel();
        System.out.println("                Transfer options");
        boolean b = true;
        while (b){
            System.out.println("1. Transfer to another account");
            System.out.println("2. Putting money to your account");
            System.out.println("3. Back");
            int choice = sc.nextInt();
            switch (choice){
                case 1:{
                    String fromAcNum = "",pass="",toAcNum="";
                    int amount=0;

                    boolean transferLoop = true;
                    while(transferLoop) {
                        System.out.print("Enter your account number: ");
                        fromAcNum = sc.next();
                        System.out.print("Enter your password: ");
                        pass = sc.next();
                        if(!mtvm.checkFromAccountIsValid(fromAcNum, pass)) {
                            System.out.println("Enter valid user name and password");
                            continue;
                        }

                        System.out.print("Enter To account number: ");
                        toAcNum = sc.next();
                        if(!mtvm.checkToAccountIsValid(toAcNum)){
                            System.out.println("Please enter correct To account...");
                            continue;
                        }

                        System.out.print("Enter amount to be transferred: ");
                        amount = sc.nextInt();
                        if(!mtvm.checkAmountIsAvailable(fromAcNum, amount)){
                            System.out.println("Please enter valid amount...");
                            continue;
                        }
                        transferLoop = false;

                    }
                    if(mtvm.Exchange(fromAcNum,toAcNum,amount))
                        System.out.println("Amount transferred successfully...");
                    else
                        System.out.println("Transaction rejected!!!");
                    break;
                }
                case 2:{
                    String acNum="",pass="";
                    int amount=0;
                    boolean putMoneyLoop = true;
                    while (putMoneyLoop){
                        System.out.print("Enter your account number: ");
                        acNum = sc.next();

                        System.out.print("Enter your password: ");
                        pass = sc.next();

                        if (!mtvm.checkFromAccountIsValid(acNum, pass)) {
                            System.out.println("Please enter valid account number and password");
                            continue;
                        }

                        System.out.print("Enter the amount: ");
                        amount = sc.nextInt();
                        putMoneyLoop = false;
                    }
                    if(mtvm.putMoney(acNum,amount)){
                        System.out.println("Amount transferred successfully...");
                    }
                    else
                        System.out.println("Transaction rejected!!!");

                    break;
                }
                case 3: {
                    b=false;
                    break;
                }
                default:{
                    System.out.println("please enter valid choice...");
                }
            }

        }
    }
}
