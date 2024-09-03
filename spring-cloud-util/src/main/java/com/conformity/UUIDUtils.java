package com.conformity;

/**
 * @author guolei
 * @since 2024/9/3 10:13
 */
public class UUIDUtils {
    public static String getUUID() {
        return java.util.UUID.randomUUID().toString().replace("-", "");
    }
}
