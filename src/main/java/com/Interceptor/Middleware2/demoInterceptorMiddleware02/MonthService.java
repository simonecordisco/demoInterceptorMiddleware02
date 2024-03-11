package com.Interceptor.Middleware2.demoInterceptorMiddleware02;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MonthService {

    // Lista di mesi predefiniti
    private List<Month> months;

    // Costruttore per inizializzare la lista di mesi
    public MonthService() {
        months = new ArrayList<>();
        // Aggiungi i mesi predefiniti alla lista
        months.add(new Month(1, "January", "Gennaio", "Januar"));
        months.add(new Month(2, "February", "Febbraio", "Februar"));
        months.add(new Month(3, "March", "Marzo", "März"));
        months.add(new Month(4, "April", "Aprile", "April"));
        months.add(new Month(5, "May", "Maggio", "Mai"));
        months.add(new Month(6, "June", "Giugno", "Juni"));
        months.add(new Month(7, "July", "Luglio", "Juli"));
        months.add(new Month(8, "August", "Agosto", "August"));
        months.add(new Month(9, "September", "Settembre", "September"));
        months.add(new Month(10, "October", "Ottobre", "Oktober"));
        months.add(new Month(11, "November", "Novembre", "November"));
        months.add(new Month(12, "December", "Dicembre", "Dezember"));

    }

    // Metodo per ottenere un mese in base al numero
    public Month getMonthByNumber(int monthNumber) {
        for (Month month : months) {
            if (month.getMonthNumber() == monthNumber) {
                return month;
            }
        }
        // Se il mese non è trovato, restituisce un mese vuoto
        return new Month();
    }
}

