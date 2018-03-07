package com.slobevg.accounts.jpa

import com.slobevg.accounts.model.Account
import org.springframework.data.jpa.repository.JpaRepository

interface AccountRepository : JpaRepository<Account, Long>
