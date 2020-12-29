package io.swagger.service;

import io.swagger.dao.AccountRepository;
import io.swagger.dao.TransactionRepository;
import io.swagger.model.Account;
import io.swagger.model.Transaction;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class TransactionService {
    private TransactionRepository transactionRepository;
    private AccountRepository accountRepository;
    private AccountService accountService;
    private static final Logger logger = Logger.getLogger(TransactionService.class.getName());


    public TransactionService(TransactionRepository transactionRepository, AccountRepository accountRepository, AccountService accountService) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
        this.accountService = accountService;
    }

    public Transaction createTransaction(Transaction transaction) {
        try {
            //this ensures that only the accounts that are within the repository are used otherwise they will be null
            Account accountSender = accountRepository.getAccountByIBAN(transaction.getSender());
            Account accountReceiver = accountRepository.getAccountByIBAN(transaction.getReceiver());

            //checking if the accounts even exist & checking if they're not the same accounts
            if (accountSender != null && accountReceiver != null && accountSender != accountReceiver) {
                //checking if the account from where the money is being sent or to sent is a savings account
                if (accountSender.getType() == Account.TypeEnum.SAVING || accountReceiver.getType() == Account.TypeEnum.SAVING) {
                    // then checking if accounts is of the same customer
                    if (accountSender.getOwnerId().equals(accountReceiver.getOwnerId())) {
                        return makeTransaction(accountSender, accountReceiver, transaction);
                    }
                } else {
                    return makeTransaction(accountSender, accountReceiver, transaction);
                }
            }
        } catch (Exception e) {
            logger.warning("Transaction not successful. Please check that the accounts exist and or your account limitations" + e.getMessage());
        }
        return null;
    }

    public List<Transaction> getTransactions(String iBan) {
        List<Transaction> transactionList = new ArrayList<>();
        try {
            transactionRepository.findAll().forEach(transaction -> {
                if (transaction.getSender().equals(iBan) || transaction.getReceiver().equals(iBan)) {
                    transactionList.add(transaction);
                }
            });
            return transactionList;
        } catch (Exception e) {
            logger.warning("Could not get Transactions." + e.getMessage());
        }
        return transactionList;
    }

    private Transaction makeTransaction(Account accountSender, Account accountReceiver, Transaction transaction) {
        boolean successfulTransaction;
        try {
            successfulTransaction = accountSender.withdrawAmount(transaction.getAmount()); // withdraw from sender

            //check if transaction was successful
            if (successfulTransaction == true) {
                accountReceiver.insertAmount(transaction.getAmount()); // add funds to receiver account
                transactionRepository.save(transaction);
                return transaction;
            }
        } catch (Exception e) {
            logger.warning("Can not make transaction,please check your accounts and account limits" + e.getMessage());
        }
        return null;
    }
}
