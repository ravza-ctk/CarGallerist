package com.rvzctk.gallerist.service.impl;

import java.util.Date;

import com.rvzctk.gallerist.attribute.AttributeValue;
import com.rvzctk.gallerist.repository.AttributeValueRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rvzctk.gallerist.dto.DtoAccount;
import com.rvzctk.gallerist.dto.DtoAccountIU;
import com.rvzctk.gallerist.model.Account;
import com.rvzctk.gallerist.repository.AccountRepository;
import com.rvzctk.gallerist.service.IAccountService;

@Service
public class AccountServiceImpl implements IAccountService{

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AttributeValueRepository attributeValueRepository;



    private Account createAccount(DtoAccountIU dtoAccountIU) {
            Account account = new Account();
            account.setCreatedDate(new Date());

            BeanUtils.copyProperties(dtoAccountIU, account, "currencyTypeId");


            AttributeValue currency = attributeValueRepository
                    .findById(dtoAccountIU.getCurrencyTypeId())
                    .orElseThrow(() -> new RuntimeException("Currency type not found"));

            account.setCurrencyType(currency);

            return account;
    }


    @Override
    public DtoAccount saveAccount(DtoAccountIU dtoAccountIU) {
        DtoAccount dtoAccount = new DtoAccount();

        Account savedAccount = accountRepository.save(createAccount(dtoAccountIU));
        BeanUtils.copyProperties(savedAccount, dtoAccount);

        if (savedAccount.getCurrencyType() != null) {
            dtoAccount.setCurrencyTypeId(savedAccount.getCurrencyType().getId());
        }

        return dtoAccount;
    }


}
