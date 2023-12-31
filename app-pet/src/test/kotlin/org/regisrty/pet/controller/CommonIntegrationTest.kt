package org.regisrty.pet.controller

import org.regisrty.domain.BaseResource
import org.springframework.test.web.servlet.MvcResult
import org.springframework.util.MultiValueMap
import java.util.*

interface CommonIntegrationTest<E : BaseResource> {

	fun getById(urlTemplate: String, id: String): MvcResult

	fun create(urlTemplate: String, entity: E): MvcResult

	fun update(urlTemplate: String, id: String, entity: E): MvcResult

	fun delete(urlTemplate: String, id: String): MvcResult

	fun deleteAll(urlTemplate: String, ids: List<String?>): MvcResult

	fun findAll(urlTemplate: String, params: MultiValueMap<String, String>): MvcResult

	fun createAll(urlTemplate: String, entities: List<E>): MvcResult

    fun findById(urlTemplate: String, id: String): MvcResult

    fun modify(urlTemplate: String, id: String, entity: E): MvcResult

    fun updateAll(urlTemplate: String, ids: List<String>, entities: List<E>): MvcResult

}
