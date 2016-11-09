package com.lynn.sdk.utils;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import com.lynn.sdk.base.BaseApplication;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lijia on 16/6/28.
 */
public class LogUtil {

    public static void e(String tag, String message) {
        if (AppConfig.DEBUG) {
            if (StringUtil.isEmpty(message)) {
                message = "null";
            }
            Log.e(tag, message);
        }

    }

    public static void i(String tag, String message) {
        if (AppConfig.DEBUG) {
            if (!StringUtil.isEmpty(message)) {
                Log.i(tag, message);
            }
        }
    }

    public static void d(String tag, String message) {
        if (AppConfig.DEBUG) {
            if (StringUtil.isEmpty(message)) {
                message = "null";
            }
            Log.d(tag, message);
        }
    }

    public static void v(String tag, String message) {
        if (AppConfig.DEBUG) {
            if (StringUtil.isEmpty(message)) {
                message = "null";
            }
            Log.v(tag, message);
        }
    }

    public static void w(String tag, String message) {
        if (AppConfig.DEBUG) {
            if (StringUtil.isEmpty(message)) {
                message = "null";
            }
            Log.w(tag, message);
        }
    }

    public static void wtf(String tag, String message) {
        if (AppConfig.DEBUG) {
            if (StringUtil.isEmpty(message)) {
                message = "null";
            }
            Log.wtf(tag, message);
        }
    }

    public static void saveCatchInfo2File(Throwable ex, Exception error, String content, Context context) {
        StringBuffer sb = new StringBuffer();
        Writer writer = new StringWriter();
        PrintWriter printWriter = new PrintWriter(writer);
        if (ex != null) {
            ex.printStackTrace(printWriter);
            Throwable cause = ex.getCause();
            while (cause != null) {
                cause.printStackTrace(printWriter);
                cause = cause.getCause();
            }
            printWriter.close();
            String result = writer.toString();
            sb.append(result);
        }
        if (error != null) {
            PrintWriter printWriter1 = new PrintWriter(writer);
            error.printStackTrace(printWriter1);
            Throwable cause = error.getCause();
            while (cause != null) {
                cause.printStackTrace(printWriter1);
                cause = cause.getCause();
            }
            printWriter1.close();
            String result = writer.toString();
            sb.append(result);
        }
        if (!StringUtil.isEmpty(content)) {
            sb.append(content);
        }
        if (context == null) {
            context = BaseApplication.getApplicationInstance().getApplicationContext();
        }
        try {
            long timestamp = System.currentTimeMillis();
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH-mmssSSS");
            String time = formatter.format(new Date());
            // String fileName = "crash_" + time + ".log";
            String fileName = "crash_" + time + ".txt";
            if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/com.baojia.crash.Log/";
                File dir = new File(path);
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                FileOutputStream fos = new FileOutputStream(path + fileName);
                fos.write(sb.toString().getBytes());
                // 发送给开发人员
                fos.close();
            } else {
                FileOutputStream fos = context.openFileOutput(fileName,
                        Context.MODE_WORLD_READABLE + Context.MODE_WORLD_WRITEABLE);
                fos.write(content.getBytes());
                fos.close();
                // fos.write(sb.toString().getBytes());
                // // 发送给开发人员
                // fos.close();
            }
        } catch (Exception e) {
            //LogPushUtil.commitCrashLog(context, e);
        }
    }

    public static void logE(String tag, String content) {
        int p = 2048;
        long length = content.length();
        if (length < p || length == p)
            Log.e(tag, content);
        else {
            while (content.length() > p) {
                String logContent = content.substring(0, p);
                content = content.replace(logContent, "");
                Log.e(tag, logContent);
            }
            Log.e(tag, content);
        }
    }
}
