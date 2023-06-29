package org.regisrty.pet

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication

@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"])

@SpringBootApplication(scanBasePackages = ["org.regisrty.pet", "org.regisrty.config"])
@EntityScan(value = ["org.regisrty.pet.domain", "org.regisrty.domain"])
class PetApplication

@Suppress("SpreadOperator")
fun main(args: Array<String>) {
    runApplication<PetApplication>(*args)
}
