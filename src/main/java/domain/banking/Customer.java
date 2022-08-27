package domain.banking;

import java.util.List;

public class Customer {

    private List<BankAccount> bankAccounts;

    private Address address;

    private long uuid;
    public Customer(long uuid,List<BankAccount> bankAccounts, Address address) {
        this.uuid = uuid;
        this.bankAccounts = bankAccounts;
        this.address = address;
    }

    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void updateAddress(Address newAddress){
        this.address =newAddress;
        bankAccounts.forEach(bankAccount -> { bankAccount.updateAddress(newAddress);});
    }
}
