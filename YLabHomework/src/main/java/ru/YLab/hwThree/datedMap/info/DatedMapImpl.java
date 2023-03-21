package ru.YLab.hwThree.datedMap.info;

import java.util.*;

public class DatedMapImpl implements DatedMap{
    Map<String, String> map = new HashMap<>();
    Map<String, Date> timeMap = new HashMap<>();

    @Override
    public void put(String key, String value) {
        map.put(key, value);
        timeMap.put(value, new Date());
    }

    @Override
    public String get(String key) {
        if (!map.containsKey(key)) {
            return null;
        }
        String result = null;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey().equals(key)){
                result =  entry.getValue();
            }
        }
        return result;
    }

    @Override
    public boolean containsKey(String key) {
        return map.containsKey(key);
    }

    @Override
    public void remove(String key) {
        map.remove(key);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey().equals(key)){
                timeMap.remove(entry.getValue());
            }
        }
    }

    @Override
    public Set<String> keySet() {
        return map.keySet();
    }

    @Override
    public Date getKeyLastInsertionDate(String key) {
        Date date = null;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey().equals(key)){
                for (Map.Entry<String, Date> dateEntry : timeMap.entrySet()) {
                    if (entry.getValue().equals(dateEntry.getKey())){
                        date = dateEntry.getValue();
                    }
                }
            }
        }
        return date;
    }
}
