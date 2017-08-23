package com.expenses.webservices.controller;

import com.expenses.business.model.Condo;
import com.expenses.webservices.model.Response;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

public interface CondoController {

    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    Response<Condo> registerCondo(@RequestBody( required = true) Condo condo);

}
