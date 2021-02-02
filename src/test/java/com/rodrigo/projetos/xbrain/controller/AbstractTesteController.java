package com.rodrigo.projetos.xbrain.controller;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("test")
public abstract class AbstractTesteController {

    public String urlBase = "http://localhost:8080/api/";
}
