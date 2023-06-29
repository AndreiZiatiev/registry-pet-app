package org.regisrty.pet.service

import org.regisrty.pet.domain.Pet
import org.regisrty.pet.repository.PetRepository
import org.regisrty.service.AbstractService
import org.springframework.stereotype.Service

@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"])

@Service
class PetService(
    repository: PetRepository
) : AbstractService<Pet, PetRepository>(repository)
