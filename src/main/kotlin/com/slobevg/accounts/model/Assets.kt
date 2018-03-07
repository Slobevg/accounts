package com.slobevg.accounts.model

import java.math.BigDecimal
import javax.persistence.*

@Table(name = "account_assets")
@Entity
class Assets {

    @get:Id
    @get:GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null

    @get:Column(nullable = false)
    var score: BigDecimal? = BigDecimal.ZERO
}