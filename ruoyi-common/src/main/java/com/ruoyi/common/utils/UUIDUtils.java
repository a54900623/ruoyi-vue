package com.ruoyi.common.utils;

import java.util.UUID;

/**
 * @author wenqiang.luo date:16/4/12
 */
public final class UUIDUtils {

    /**
     * 私有构造方法
     */
    private UUIDUtils() {
    }

    /**
     * 生成随机UUID序列
     *
     * @return UUID字符串
     */
    public static String generateRandomUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * @param source 原字符串
     * @return boolean 判断结果 true/false
     * @Author yifeng
     * @Description 判断字符串是否为UUID
     * @Date 15:26 2018/12/26
     **/
    public static boolean isUUID(String source) {
        if (StringUtils.isEmpty(source)) {
            return false;
        }
        try {
            String newInitiatorName = source.substring(0, 8) + "-" + source.substring(9, 13) + "-" +
                    source.substring(14, 18) + "-" + source.substring(19, 23) + "-" +
                    source.substring(24);
            UUID.fromString(newInitiatorName);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
