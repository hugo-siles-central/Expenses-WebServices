package com.expenses.webservices.controller;

import com.expenses.business.model.Condo;
import com.expenses.business.service.CondoService;
import com.expenses.webservices.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/condos")
public class RestCondoController implements CondoController {

    @Autowired
    private CondoService condoService;


    @Override
    public Response<Condo> registerCondo(@RequestBody Condo condo) {
        Response response = new Response();
        response.addResult(condoService.registerCondo(condo));
        return response;
    }

}
