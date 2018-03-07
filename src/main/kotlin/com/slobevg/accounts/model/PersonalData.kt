package com.slobevg.accounts.model

import javax.persistence.*

@Table(name = "account_personal_data")
@Entity
class PersonalData {

    @get:Id
    @get:GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null

    @get:Column(nullable = false)
    var email: String? = null
}
