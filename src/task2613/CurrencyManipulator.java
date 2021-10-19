package task2613;

import java.util.Map;

/*
Класс хранит информацию про выбранную валюту.
 */
public class CurrencyManipulator {
    private String currencyCode;
    private Map<Integer,Integer> denominations; // <Номинал, количество>

    public CurrencyManipulator(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

}
