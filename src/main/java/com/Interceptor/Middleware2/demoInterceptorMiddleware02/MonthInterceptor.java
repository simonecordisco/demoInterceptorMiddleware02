package com.Interceptor.Middleware2.demoInterceptorMiddleware02;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;


import java.util.ArrayList;
import java.util.List;

public class MonthInterceptor implements HandlerInterceptor {

    private List<Month> months = new ArrayList<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // Ottiene il valore del mese dal header della richiesta
        String monthNumberHeader = request.getHeader("monthNumber");

        // Se il valore del mese è vuoto o nullo, restituisce un errore Bad Request
        if (monthNumberHeader == null || monthNumberHeader.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return false;
        }

        // Converte il valore del mese in un intero
        int monthNumber = Integer.parseInt(monthNumberHeader);

        // Cerca il mese corrispondente nella lista dei mesi
        for (Month month : months) {
            if (month.getMonthNumber() == monthNumber) {
                // Se il mese è presente nella lista, lo aggiunge come attributo della richiesta e restituisce true
                request.setAttribute("month", month);
                return true;
            }
        }

        // Se il mese non è presente nella lista, restituisce un mese vuoto e uno status OK
        Month emptyMonth = new Month();
        emptyMonth.setEnglishName("nope");
        emptyMonth.setItalianName("nope");
        emptyMonth.setGermanName("nope");
        request.setAttribute("month", emptyMonth);
        response.setStatus(HttpServletResponse.SC_OK);
        return true;
    }
}
