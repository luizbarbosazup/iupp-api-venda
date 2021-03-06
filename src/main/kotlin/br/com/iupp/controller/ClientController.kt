package br.com.iupp.controller

import br.com.iupp.controller.dto.ClientRequest
import br.com.iupp.controller.dto.ClientResponse
import br.com.iupp.model.Client
import br.com.iupp.service.ClientService
import br.com.iupp.service.ClientServiceImp
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*
import io.micronaut.validation.Validated
import javax.validation.Valid

@Validated
@Controller("/api/v1/clientes")
class ClientController(val serviceImp: ClientService) {

    @Post("/{cep}")
    fun  cadastraUsuario(@Body @Valid clientRequest: ClientRequest,
                         @PathVariable cep:String): HttpResponse<ClientResponse> {
        return HttpResponse.ok(serviceImp.create(clientRequest,cep))
    }

    @Get("/{id}")
    fun findClientById(@PathVariable id:Long):HttpResponse<ClientResponse>{
        return HttpResponse.ok(serviceImp.findById(id))
    }

}