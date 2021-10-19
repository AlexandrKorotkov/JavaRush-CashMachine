package task2613;

import java.util.HashMap;
import java.util.Map;

/*
Класс хранит информацию про выбранную валюту.
 */
public class CurrencyManipulator {
    private String currencyCode;
    private Map<Integer, Integer> denominations = new HashMap<>(); // <Номинал, количество>

    public CurrencyManipulator(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    /*
    Пополняет количество купюр с определенным номиналом.
     */
    public void addAmount(int denomination, int count) {
        if (denominations.containsKey(denomination)) {
            denominations.put(denomination, denominations.get(denomination) + count);
        } else {
            denominations.put(denomination, count);
        }
    }

    /*
    Считает общую сумму для указанной валюты.
     */
    public int getTotalAmount() {
        int sum=0;
        for (Map.Entry<Integer, Integer> pair : denominations.entrySet()) {
            sum+=pair.getKey()*pair.getValue();
        }
        return sum;
    }
}
