package com.slobevg.accounts.model

import javax.persistence.*

@Table(name = "accounts")
@Entity
class Account {

    @get:Id
    @get:GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null

    @get:OneToOne
    @get:JoinColumn(nullable = false)
    var personalData: PersonalData? = null

    @get:OneToOne
    @get:JoinColumn(nullable = false)
    var assets: Assets? = null
}