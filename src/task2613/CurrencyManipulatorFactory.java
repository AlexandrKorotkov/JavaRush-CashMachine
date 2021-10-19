package task2613;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/*
Фабрика создает и хранит манипуляторы.
 */
public class CurrencyManipulatorFactory {
    // хранилище для манипуляторов
    private static Map<String, CurrencyManipulator> map = new HashMap<>();// <Код валюты, манипулятор>

    /*
    Возвращает CurrencyManipulator на основании запрошенного currencyCode (регистр не учитывается).
    Создает новые манипуляторы, если их нет в хранилище манипуляторов map.
     */
    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode) {
        String code = currencyCode.toUpperCase();
        if (!map.containsKey(code)) {
            map.put(code, new CurrencyManipulator(code));
        }
        return map.get(code);
    }

    private CurrencyManipulatorFactory() {
    }
    /*
    Возвращает массив всех манипуляторов из существубщих валют.
     */
    public static Collection<CurrencyManipulator> getAllCurrencyManipulators(){
        return map.values();
    }
}
