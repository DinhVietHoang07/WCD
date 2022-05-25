package com.t2010a.hellot2010aagain.model;

import com.t2010a.hellot2010aagain.entity.Account;
import com.t2010a.hellot2010aagain.entity.Product;

import java.util.List;

public interface AccountModel {
    Account save(Account obj);

    List<Account> findAll();

    Account findById(int id);

    Account findByUsername(String username);

    Account findByEmail(String email);

    Account update(int id, Account updateObj);

    boolean delete(int id);
}
