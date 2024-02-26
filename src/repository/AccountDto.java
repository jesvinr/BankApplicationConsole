package repository;

public class AccountDto {
    String name,password;
    int age,amount;
    String phoneNumber;
    String accountNumber;
    // String name, int age, String phoneNUmber, String password, int amount
//    public CreateAccountModel(){
//        this.name = name;
//        this.age = age;
//        this.phoneNumber = phoneNUmber;
//        this.password = password;
//        this.amount = amount;
//        accountNumber = name+age;
//    }

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


//    void printDetails(){
//        System.out.println("Account number: "+accountNumber);
//        System.out.println("Account Holder name: "+name);
//        System.out.println("Password: "+password);
//        System.out.println("Age: "+age);
//        System.out.println("Amount: "+amount);
//        System.out.println("Phone number: "+ phoneNumber);
//    }
}

