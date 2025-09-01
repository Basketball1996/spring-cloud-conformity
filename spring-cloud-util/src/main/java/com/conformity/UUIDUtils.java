package com.conformity;

/**
 * @author guolei
 * @since 2025/9/1 10:21
 */
public class UUIDUtils {
    public static String getUuId() {
        return java.util.UUID.randomUUID().toString().replace("-", "");
    }
}
