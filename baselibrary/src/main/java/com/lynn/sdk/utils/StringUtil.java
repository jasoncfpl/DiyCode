package com.lynn.sdk.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Stringutil 类
 * Created by lijia on 16/6/28.
 */
public class StringUtil {

    public static String parseEmpty(String str) {
        if (str == null || "null".equals(str.trim())) {
            str = "";
        }

        return str.trim();
    }

    public static boolean isEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static int chineseLength(String str) {
        int valueLength = 0;
        String chinese = "[Α-￥]";
        if (!isEmpty(str)) {
            for (int i = 0; i < str.length(); ++i) {
                String temp = str.substring(i, i + 1);
                if (temp.matches(chinese)) {
                    valueLength += 2;
                }
            }
        }

        return valueLength;
    }

    public static int strLength(String str) {
        int valueLength = 0;
        String chinese = "[Α-￥]";
        if (!isEmpty(str)) {
            for (int i = 0; i < str.length(); ++i) {
                String temp = str.substring(i, i + 1);
                if (temp.matches(chinese)) {
                    valueLength += 2;
                } else {
                    ++valueLength;
                }
            }
        }

        return valueLength;
    }

    public static int subStringLength(String str, int maxL) {
        int currentIndex = 0;
        int valueLength = 0;
        String chinese = "[Α-￥]";

        for (int i = 0; i < str.length(); ++i) {
            String temp = str.substring(i, i + 1);
            if (temp.matches(chinese)) {
                valueLength += 2;
            } else {
                ++valueLength;
            }

            if (valueLength >= maxL) {
                currentIndex = i;
                break;
            }
        }

        return currentIndex;
    }

    public static Boolean isMobileNo(String str) {
        Boolean isMobileNo = Boolean.valueOf(false);

        try {
            Pattern e = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
            Matcher m = e.matcher(str);
            isMobileNo = Boolean.valueOf(m.matches());
        } catch (Exception var4) {
            var4.printStackTrace();
        }

        return isMobileNo;
    }

    public static Boolean isNumberLetter(String str) {
        Boolean isNoLetter = Boolean.valueOf(false);
        String expr = "^[A-Za-z0-9]+$";
        if (str.matches(expr)) {
            isNoLetter = Boolean.valueOf(true);
        }

        return isNoLetter;
    }

    public static Boolean isNumber(String str) {
        Boolean isNumber = Boolean.valueOf(false);
        String expr = "^[0-9]+$";
        if (str.matches(expr)) {
            isNumber = Boolean.valueOf(true);
        }

        return isNumber;
    }

    public static Boolean isEmail(String str) {
        Boolean isEmail = Boolean.valueOf(false);
        String expr = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        if (str.matches(expr)) {
            isEmail = Boolean.valueOf(true);
        }

        return isEmail;
    }

    public static Boolean isChinese(String str) {
        Boolean isChinese = Boolean.valueOf(true);
        String chinese = "[Α-￥]";
        if (!isEmpty(str)) {
            for (int i = 0; i < str.length(); ++i) {
                String temp = str.substring(i, i + 1);
                if (!temp.matches(chinese)) {
                    isChinese = Boolean.valueOf(false);
                }
            }
        }

        return isChinese;
    }

    public static Boolean isContainChinese(String str) {
        Boolean isChinese = Boolean.valueOf(false);
        String chinese = "[Α-￥]";
        if (!isEmpty(str)) {
            for (int i = 0; i < str.length(); ++i) {
                String temp = str.substring(i, i + 1);
                if (temp.matches(chinese)) {
                    isChinese = Boolean.valueOf(true);
                }
            }
        }

        return isChinese;
    }

    public static String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line = null;

        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }

            if (sb.indexOf("\n") != -1 && sb.lastIndexOf("\n") == sb.length() - 1) {
                sb.delete(sb.lastIndexOf("\n"), sb.lastIndexOf("\n") + 1);
            }
        } catch (IOException var13) {
            var13.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException var12) {
                var12.printStackTrace();
            }

        }

        return sb.toString();
    }

    public static String dateTimeFormat(String dateTime) {
        StringBuilder sb = new StringBuilder();

        try {
            if (isEmpty(dateTime)) {
                return null;
            }

            String[] e = dateTime.split(" ");
            if (e.length > 0) {
                String[] var3 = e;
                int var4 = e.length;

                for (int var5 = 0; var5 < var4; ++var5) {
                    String str = var3[var5];
                    String[] date;
                    int i;
                    String str1;
                    if (str.indexOf("-") != -1) {
                        date = str.split("-");

                        for (i = 0; i < date.length; ++i) {
                            str1 = date[i];
                            sb.append(strFormat2(str1));
                            if (i < date.length - 1) {
                                sb.append("-");
                            }
                        }
                    } else if (str.indexOf(":") != -1) {
                        sb.append(" ");
                        date = str.split(":");

                        for (i = 0; i < date.length; ++i) {
                            str1 = date[i];
                            sb.append(strFormat2(str1));
                            if (i < date.length - 1) {
                                sb.append(":");
                            }
                        }
                    }
                }
            }
        } catch (Exception var10) {
            var10.printStackTrace();
            return null;
        }

        return sb.toString();
    }

    public static String strFormat2(String str) {
        try {
            if (str.length() <= 1) {
                str = "0" + str;
            }
        } catch (Exception var2) {
            var2.printStackTrace();
        }

        return str;
    }

    public static String cutString(String str, int length) {
        return cutString(str, length, "");
    }

    public static String cutString(String str, int length, String dot) {
        int strBLen = strlen(str, "GBK");
        if (strBLen <= length) {
            return str;
        } else {
            int temp = 0;
            StringBuffer sb = new StringBuffer(length);
            char[] ch = str.toCharArray();
            char[] var7 = ch;
            int var8 = ch.length;

            for (int var9 = 0; var9 < var8; ++var9) {
                char c = var7[var9];
                sb.append(c);
                if (c > 256) {
                    temp += 2;
                } else {
                    ++temp;
                }

                if (temp >= length) {
                    if (dot != null) {
                        sb.append(dot);
                    }
                    break;
                }
            }

            return sb.toString();
        }
    }

    public static String cutStringFromChar(String str1, String str2, int offset) {
        if (isEmpty(str1)) {
            return "";
        } else {
            int start = str1.indexOf(str2);
            return start != -1 && str1.length() > start + offset ? str1.substring(start + offset) : "";
        }
    }

    public static int strlen(String str, String charset) {
        if (str != null && str.length() != 0) {
            int length = 0;

            try {
                length = str.getBytes(charset).length;
            } catch (Exception var4) {
                var4.printStackTrace();
            }

            return length;
        } else {
            return 0;
        }
    }

    public static String getSizeDesc(long size) {
        String suffix = "B";
        if (size >= 1024L) {
            suffix = "K";
            size >>= 10;
            if (size >= 1024L) {
                suffix = "M";
                size >>= 10;
                if (size >= 1024L) {
                    suffix = "G";
                    size >>= 10;
                }
            }
        }

        return size + suffix;
    }

    public static long ip2int(String ip) {
        ip = ip.replace(".", ",");
        String[] items = ip.split(",");
        return Long.valueOf(items[0]).longValue() << 24 | Long.valueOf(items[1]).longValue() << 16 | Long.valueOf(items[2]).longValue() << 8 | Long.valueOf(items[3]).longValue();
    }

    public static void main(String[] args) {
        System.out.println(dateTimeFormat("2012-3-2 12:2:20"));
    }
}
