package com.fruit.controller;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hanlei6 on 2016/12/22.
 */
public class BaseController {
    protected Map<String, Object> success() {
        Map<String, Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("message", "操作成功");
        return result;
    }

    protected Map<String, Object> success(String code, String message) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", code);
        result.put("message", message);
        return result;
    }

    protected Map<String, Object> failure() {
        Map<String, Object> result = new HashMap<>();
        result.put("code", 500);
        result.put("message", "操作失败");
        return result;
    }

    protected Map<String, Object> failure(String code, String message) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", code);
        result.put("message", message);
        return result;
    }
}
