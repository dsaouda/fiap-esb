package com.github.dsaouda.fiapesb.viacep.app

import com.github.dsaouda.fiapesb.viacep.service.ViaCepService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class CepController {

    @GetMapping(path=arrayOf("/v1/cep"))
    fun getCep(@RequestParam("codigo") codigo: String): ResponseEntity<Any?> {
        val service = ViaCepService.create()
        val response = service.getEndereco(codigo).execute()

        val statusCode = HttpStatus.valueOf(response.code())

        if (statusCode.value() >= 400) {
            return ResponseEntity("cep ($codigo) informado não é valido", statusCode)
        }

        return ResponseEntity(response.body(), statusCode)
    }


}
