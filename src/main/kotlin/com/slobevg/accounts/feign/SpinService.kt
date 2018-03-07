package com.slobevg.accounts.feign

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@FeignClient(name = "spin")
interface SpinService {

    @RequestMapping(method = [(RequestMethod.GET)], value = ["/api/symbols"])
    fun spin(): Spin
}
