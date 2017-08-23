package com.expenses.webservices.controller;

import com.expenses.business.model.Condo;
import com.expenses.business.services.CondoService;
import com.expenses.webservices.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

@RestController
@ComponentScan("com.expenses.business.services")
@RequestMapping("/condos")
public class RestCondoController implements CondoController {

    @Autowired
    private CondoService condoService;

    @Override
    public Response<Condo> registerCondo(@RequestBody(
            required = true) Condo condo) {
        Response<Condo> response = new Response();
        response.addResult(condoService.registerCondo(condo));
        return response;
    }

}
