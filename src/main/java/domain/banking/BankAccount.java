package domain.banking;

public class BankAccount {

    private Address address;

    private long uuid;

    public BankAccount(long uuid, Address address) {
        this.uuid = uuid;
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    protected void updateAddress(Address newAddress){
        this.address = newAddress;
    }
}
