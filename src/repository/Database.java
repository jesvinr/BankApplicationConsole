package repository;

import javax.xml.crypto.Data;
import java.sql.*;

public class Database {
    private String url = "jdbc:mysql://localhost:3307/bank_application";
    private String username = "root";
    private String password = "root";
    private Connection con = null;
    private static Database db = null;

    Database(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Database getInstance() {
        if (db == null) {
            db = new Database();
        }
        return db;
    }

    public void connectionClose() throws SQLException {
        con.close();
    }

    public AccountDto getAccountDb(String acNum) throws SQLException {
        String query = "Select * from accountdetails where uaccountnumber = ?;";
        PreparedStatement prepare = con.prepareStatement(query);
        prepare.setString(1,acNum);
        ResultSet rs = prepare.executeQuery();
        AccountDto userAccount = new AccountDto();
        if(rs.next()){
            userAccount.setAccountNumber(rs.getString("uaccountnumber"));
            userAccount.setAmount(rs.getInt("amount"));
            userAccount.setAge(rs.getInt("uage"));
            userAccount.setName(rs.getString("uname"));
            userAccount.setPhoneNumber(rs.getString("uphonenumber"));
            return userAccount;
        }
        // if no accounts found
        return null;
    }

    public void putAccountDb(AccountDto createAccountDTO) throws SQLException {
        String query = "insert into accountdetails(uname, upassword, uage, amount, " +
                "uphonenumber, uaccountnumber) values(?,?,?,?,?,?)";
        PreparedStatement prepare = con.prepareStatement(query);
        prepare.setString(1,createAccountDTO.getName());
        prepare.setString(2,createAccountDTO.getPassword());
        prepare.setInt(3,createAccountDTO.getAge());
        prepare.setInt(4,createAccountDTO.getAmount());
        prepare.setString(5,createAccountDTO.getPhoneNumber());
        prepare.setString(6,createAccountDTO.getAccountNumber());
        prepare.execute();
    }

    public boolean checkAccountAndPasswordDb(String acNum,String pass) throws SQLException {
        String query = "Select uaccountnumber, upassword from accountdetails " +
                "where uaccountnumber = ? and upassword = ?;";
        PreparedStatement preparedStatement = con.prepareStatement(query);
        preparedStatement.setString(1,acNum);
        preparedStatement.setString(2,pass);
        ResultSet rs = preparedStatement.executeQuery();
        if(rs.next()) return true;
        return false;
    }

    public boolean checkAmountDb(String acNum, int amount) throws SQLException {
        String query = "Select amount from accountdetails where uaccountnumber= ?;";
        PreparedStatement preparedStatement = con.prepareStatement(query);
        preparedStatement.setString(1,acNum);
        ResultSet rs = preparedStatement.executeQuery();
        if(rs.next()) {
            int userAmount = rs.getInt("amount");
            if (userAmount >= amount) return true;
        }
        return false;
    }

    public boolean checkAccountDb(String acNum) throws SQLException {
        String query = "Select uid from accountdetails where uaccountnumber = ?;";
        PreparedStatement preparedStatement = con.prepareStatement(query);
        preparedStatement.setString(1,acNum);
        ResultSet rs = preparedStatement.executeQuery();
        if(rs.next()) return true;
        return false;
    }

    public boolean exchangeAmountDb(String fromAcNum, String toAcNum,int amount) throws SQLException {
        if(!checkAmountDb(fromAcNum,amount) || !checkAccountDb(fromAcNum)
            || !checkAccountDb(toAcNum))
            return false;
        int fromAcNumAmount = getAmountDb(fromAcNum), toAcNumAmount = getAmountDb(toAcNum);
        fromAcNumAmount = fromAcNumAmount-amount;
        toAcNumAmount = toAcNumAmount+amount;
        System.out.println(fromAcNumAmount+" "+toAcNumAmount);
        String query = "update accountdetails set amount = ? " +
                "where uaccountnumber = ?;";
        PreparedStatement preparedStatement = con.prepareStatement(query);
        preparedStatement.setInt(1,fromAcNumAmount);
        preparedStatement.setString(2,fromAcNum);
        preparedStatement.execute();
        String queryTo = "update accountdetails set amount = ? " +
                "where uaccountnumber = ?;";
        PreparedStatement preparedStatement1 = con.prepareStatement(queryTo);
        preparedStatement1.setInt(1,toAcNumAmount);
        preparedStatement1.setString(2,toAcNum);
        preparedStatement1.execute();
        return true;
    }

    public boolean withdrawAmountDb(String acNum, int amount) throws SQLException {
        if(!checkAccountDb(acNum) && !checkAmountDb(acNum, amount))
            return false;
        int curAmount = getAmountDb(acNum);
        int finalAmount = curAmount - amount;
        String query = "update accountdetails set amount = ? " +
                "where uaccountnumber = ?;";
        PreparedStatement preparedStatement1 = con.prepareStatement(query);
        preparedStatement1.setInt(1,finalAmount);
        preparedStatement1.setString(2,acNum);
        preparedStatement1.execute();
        return true;
    }

    public boolean putAmount(String acNum,int amount) throws SQLException {
        if(!checkAccountDb(acNum)) return false;
        int curAmount = getAmountDb(acNum);
        int finalAmount = curAmount+amount;
        String query = "update accountdetails set amount = ? " +
                "where uaccountnumber = ?;";
        PreparedStatement preparedStatement1 = con.prepareStatement(query);
        preparedStatement1.setInt(1,finalAmount);
        preparedStatement1.setString(2,acNum);
        preparedStatement1.execute();
        return true;
    }

    private int getAmountDb(String acNum) throws SQLException {
        int amount =0;
        String query = "select amount from accountdetails where uaccountnumber = ?";
        PreparedStatement preparedStatement = con.prepareStatement(query);
        preparedStatement.setString(1,acNum);
        ResultSet rs = preparedStatement.executeQuery();
        if(rs.next()){
            amount = rs.getInt(1);
            return amount;
        }
        return amount;
    }

}
