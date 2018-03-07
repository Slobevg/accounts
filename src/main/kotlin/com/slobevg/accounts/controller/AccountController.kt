package com.slobevg.accounts.controller

import com.slobevg.accounts.feign.Spin
import com.slobevg.accounts.feign.SpinService
import com.slobevg.accounts.service.AccountService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.oauth2.provider.OAuth2Authentication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.security.Principal

@RestController
@RequestMapping("/api")
class AccountController
@Autowired
constructor(private val accountService: AccountService
            , private val spinService: SpinService) {

    private val logger = LoggerFactory.getLogger(AccountController::class.java)

    @PostMapping
    fun create(email: String) {
        accountService.create(email)
    }

    @GetMapping("/spin")
    fun spin(principal: OAuth2Authentication?): Spin? {
        @Suppress("UNCHECKED_CAST")
        val email = (principal?.userAuthentication?.details as LinkedHashMap<String, String>)["email"] as String
        logger.info("{}", email)
        accountService.create(email)
        return spinService.spin()
    }

}
