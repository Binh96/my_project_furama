package services;

import modules.Customer;

public interface ICustomerService extends IServices<Customer>{
    String typeOfCustomer();
    String chooseCustomerType(int num);
    void displayIdCustomer();
}
