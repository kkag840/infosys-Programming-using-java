package com.business.sellingapp.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class CommonUtil {

    // for find all fields name  they are  null
    public static String[] getNullFields(Object source) {
        List<String> nullPropertyNames = new ArrayList<>();

        Field[] fields = source.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true); // Access private fields
            try {
                if (field.get(source) == null) {
                    nullPropertyNames.add(field.getName());
                }
            } catch (IllegalAccessException e) {

            }
        }
        return nullPropertyNames.toArray(new String[0]);
    }
}
