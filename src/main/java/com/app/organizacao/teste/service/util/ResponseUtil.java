package com.app.organizacao.teste.service.util;

import java.util.HashMap;

/**
 *
 * Joãozim Mil Grau
 */
public class ResponseUtil {

    public static HashMap<String, Object> response (Object message, Object object) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("message", message);
        result.put("object", object);
        return result;
    }

}
