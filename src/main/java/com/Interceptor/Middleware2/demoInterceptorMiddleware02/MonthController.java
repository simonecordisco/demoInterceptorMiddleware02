package com.Interceptor.Middleware2.demoInterceptorMiddleware02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MonthController {
    @Autowired
    private MonthService monthService; // Assume che ci sia un servizio che gestisce le operazioni sui mesi

    @GetMapping("/months")
    public Month getMonth(@RequestHeader(name = "monthNumber", required = false) Integer monthNumber) {
        if (monthNumber == null) {
            // Se monthNumber è nullo, restituisci un mese vuoto o gestisci l'errore in base ai requisiti
            return new Month();
        } else {
            // Altrimenti, utilizza il servizio per ottenere il mese corrispondente al numero
            return monthService.getMonthByNumber(monthNumber);
        }
    }
}



