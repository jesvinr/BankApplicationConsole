package repository;

public class AccountDto {
    private String name;
    private String password;
    private int age;
    private int amount;
    private String phoneNumber;
    private String accountNumber;

    public String getName(){return name;}
    public String getPassword(){return password;}
    public int getAge(){return age;}
    public int getAmount() {return amount;}
    public String getPhoneNumber() {return phoneNumber;}
    public String getAccountNumber() {return accountNumber;}


    public void setName(String name){
        this.name = name;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setAccountNumber(String accountNumber){this.accountNumber = accountNumber;}

}

