/*
 * Copyright (c) 2022. 最终解释权 制作者： 小玄易(葛宝檀)
 */

package net.lanternmc.avmwandmod.Utils;

import java.util.Properties;

public class WhatIsSystemInfo {
    /*看你是啥系统*/
    public static boolean isOSLinux() {
        Properties prop = System.getProperties();
        String os = prop.getProperty("os.name");
        return os != null && os.toLowerCase().contains("linux");
    }

    /*看你是啥系统*/
    public static boolean isWindows() {
        Properties prop = System.getProperties();
        String os = prop.getProperty("os.name");
        return os != null && !os.toLowerCase().contains("linux");
    }

    public static String getSystemInfo() {
        Properties prop = System.getProperties();
        return prop.getProperty("os.name");
    }
}
