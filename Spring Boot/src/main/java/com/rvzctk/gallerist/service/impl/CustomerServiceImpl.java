package com.rvzctk.gallerist.service.impl;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rvzctk.gallerist.dto.DtoAccount;
import com.rvzctk.gallerist.dto.DtoAddress;
import com.rvzctk.gallerist.dto.DtoCustomer;
import com.rvzctk.gallerist.dto.DtoCustomerIU;
import com.rvzctk.gallerist.exception.BaseException;
import com.rvzctk.gallerist.exception.ErrorMessage;
import com.rvzctk.gallerist.exception.MessageType;
import com.rvzctk.gallerist.model.Account;
import com.rvzctk.gallerist.model.Address;
import com.rvzctk.gallerist.model.Customer;
import com.rvzctk.gallerist.repository.AccountRepository;
import com.rvzctk.gallerist.repository.AddressRepository;
import com.rvzctk.gallerist.repository.CustomerRepository;
import com.rvzctk.gallerist.service.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private AccountRepository accountRepository;

    private Customer createCustomer(DtoCustomerIU dtoCustomerIU) {
        Optional<Address> optAddress = addressRepository.findById(dtoCustomerIU.getAddressId());
        if(optAddress.isEmpty()) {
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, dtoCustomerIU.getAddressId().toString()));
        }

        Optional<Account> optAccount = accountRepository.findById(dtoCustomerIU.getAccountId());
        if(optAccount.isEmpty()) {
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, dtoCustomerIU.getAccountId().toString()));
        }


        Customer customer = new Customer();
        customer.setCreatedDate(new Date());
        BeanUtils.copyProperties(dtoCustomerIU, customer);

        customer.setAddress(optAddress.get());
        customer.setAccount(optAccount.get());

        return customer;
    }

    @Override
    public DtoCustomer saveCustomer(DtoCustomerIU dtoCustomerIU) {
        DtoCustomer dtoCustomer = new DtoCustomer();
        DtoAddress dtoAddress = new DtoAddress();
        DtoAccount dtoAccount = new DtoAccount();

        Customer savedCustomer = customerRepository.save(createCustomer(dtoCustomerIU));

        BeanUtils.copyProperties(savedCustomer, dtoCustomer);
        BeanUtils.copyProperties(savedCustomer.getAddress(), dtoAddress);
        BeanUtils.copyProperties(savedCustomer.getAccount(), dtoAccount);

        dtoCustomer.setAddress(dtoAddress);
        dtoCustomer.setAccount(dtoAccount);

        return dtoCustomer;
    }


}