package task2613;

import task2613.exception.NotEnoughMoneyException;

import java.util.*;

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
        int sum = 0;
        for (Map.Entry<Integer, Integer> pair : denominations.entrySet()) {
            sum += pair.getKey() * pair.getValue();
        }
        return sum;
    }

    public boolean hasMoney() {
        return !denominations.isEmpty();
    }

    public boolean isAmountAvailable(int expectedAmount) {
        return getTotalAmount() >= expectedAmount;
    }
/*
Снятие со счета жадным алгоритмом.
 */
    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException {
        int sum = expectedAmount;//будет хранить оставшуюся сумму, которую надо довыдать.
        Map<Integer, Integer> denominationsCopy = new HashMap<>(denominations);
        List<Integer> keys = new ArrayList<>(denominationsCopy.keySet());
        Collections.sort(keys);
        Collections.reverse(keys);//теперь номиналы идут по убыванию
        Map<Integer, Integer> res = new TreeMap<>(Comparator.reverseOrder());
        for (Integer den : keys) {
            int key = den;
            int value = denominationsCopy.get(key);
            while (true) {
                if (sum < key || value == 0) {
                    denominationsCopy.put(key, value);
                    break;
                }
                sum -= key;
                value--;
                if (res.containsKey(key)) res.put(key, res.get(key) + 1);
                else res.put(key, 1);
            }
        }
        if (sum > 0) throw new NotEnoughMoneyException();
        else denominations = denominationsCopy;
        return res;
    }
}
