package com.utp.ventasMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {
    @GetMapping("/acceso-denegado")
    public String accesoDeengado()
    {
        return"acceso-denegado";
    }
}
