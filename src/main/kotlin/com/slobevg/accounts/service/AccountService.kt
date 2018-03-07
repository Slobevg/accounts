package com.slobevg.accounts.service

import com.slobevg.accounts.jpa.AccountRepository
import com.slobevg.accounts.model.Account
import com.slobevg.accounts.model.Assets
import com.slobevg.accounts.model.PersonalData
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AccountService
@Autowired
constructor(private val accountRepository: AccountRepository) {

    @Transactional(readOnly = true)
    fun findAll(): List<Account> {
        return accountRepository.findAll()
    }

    @Transactional
    fun create(email: String) {
        val account = Account()
        val personalData = PersonalData()
        personalData.email = email
        account.personalData = personalData
        account.assets = Assets()
        accountRepository.save(account)
    }
}
