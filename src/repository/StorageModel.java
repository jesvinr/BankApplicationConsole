package repository;

import java.util.*;

public class StorageModel {

    private static StorageModel st;
    StorageModel(){
        // Empty Constructor
    }
    public static StorageModel getInstance() {
        if (st == null) {
            st = new StorageModel();
        }
        return st;
    }
    private List<AccountDto> accountList = new ArrayList<>();
    private Map<String,String> accountNumAndPass= new LinkedHashMap<>();
    public AccountDto getAccount(String acNum){
        int size = accountList.size();
        for(int i=0;i<size;i++){
            if(accountList.get(i).accountNumber.equals(acNum)){
                return accountList.get(i);
            }
        }
        //System.out.println("No accounts found");
        // if no account found
        return null;
    }

    public void putAccount(AccountDto createAccountDTO){

        accountList.add(createAccountDTO);
        accountNumAndPass.put(createAccountDTO.accountNumber,createAccountDTO.password);
    }

    public boolean checkAccountAndPassword(String acNum,String pass){
        for(Map.Entry<String,String> temp: accountNumAndPass.entrySet()){
            if(acNum.equals(temp.getKey()) && pass.equals(temp.getValue())){
                return true;
            }
        }
        return false;
    }

    public boolean checkAmount(String acNUm, int amount){
        for(int i=0;i<accountList.size();i++){
            if(acNUm.equals(accountList.get(i).accountNumber) && amount <= accountList.get(i).amount){
                AccountDto user = accountList.get(i);
                user.setAmount(user.getAmount()-amount);
                return true;
            }
        }
        return false;
    }

    public boolean checkAccount(String acNum) {
        for (Map.Entry<String, String> temp : accountNumAndPass.entrySet()) {
            if (acNum.equals(temp.getKey())) {
                return true;
            }
        }
        return false;
    }
}
