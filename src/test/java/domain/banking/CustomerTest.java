package domain.banking;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
    @Test
    void shouldUpdateCustomerAddress() {
        BankAccount account = new BankAccount(111l,new Address("Mumbai"));
        BankAccount anotherAccount = new BankAccount(112l,new Address("Mumbai"));
        List<BankAccount> accounts = new ArrayList<>();
        accounts.add(account);
        accounts.add(anotherAccount);
        Customer customer = new Customer(1l, accounts, new Address("Mumbai"));

        customer.updateAddress(new Address("Chennai"));

        assertEquals(customer.getBankAccounts().get(0).getAddress().getCity(), "Chennai");
        assertEquals(customer.getBankAccounts().get(1).getAddress().getCity(), "Chennai");
    }
}