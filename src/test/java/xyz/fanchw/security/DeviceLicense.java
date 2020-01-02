package xyz.fanchw.security;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class DeviceLicense {

    /**
     * 获取linux或windows CPU序列号
     *
     * @return 返回CPU序列号
     */
    public static String getCPUSerial() {
        String os = System.getProperty("os.name").toUpperCase();
        if ("LINUX".equals(os)) return getLinuxCPUSerial();
        return getWindowsCPUSerial();
    }

    /**
     * @return 返回windows CPU序列号
     */
    private static String getWindowsCPUSerial() {
        String serial = null;
        try {
            Process process = Runtime.getRuntime().exec(
                    new String[]{"wmic", "cpu", "get", "ProcessorId"});
            process.getOutputStream().close();
            Scanner sc = new Scanner(process.getInputStream());
            sc.next();
            serial = sc.next();
            System.out.println(serial);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return serial;
    }

    /**
     * 获取linux CPU序列号
     *
     * @return 返回CPU序列号
     */
    private static String getLinuxCPUSerial() {
        return getSerialNumber("dmidecode -t processor | grep 'ID'", "ID", ":");
    }


    /**
     * @param cmd linux命令
     * @return 命令执行结果
     */
    private static String executeLinuxCmd(String cmd) {
        try {
            System.out.println("got cmd job : " + cmd);
            Runtime run = Runtime.getRuntime();
            Process process;
            process = run.exec(cmd);
            InputStream in = process.getInputStream();
            StringBuilder out = new StringBuilder();
            byte[] b = new byte[8192];
            for (int n; (n = in.read(b)) != -1; ) {
                out.append(new String(b, 0, n));
            }

            in.close();
            process.destroy();
            return out.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param cmd    命令语句
     * @param record 要查看的字段
     * @param symbol 分隔符
     * @return 返回对应设备序列号
     */
    private static String getSerialNumber(String cmd, String record, String symbol) {
        String execResult = executeLinuxCmd(cmd);
        String[] infos = Objects.requireNonNull(execResult).split("\n");

        for (String info : infos) {
            info = info.trim();
            if (info.indexOf(record) != -1) {
                info.replace(" ", "");
                String[] sn = info.split(symbol);
                return sn[1];
            }
        }

        return null;
    }

    /**
     * 获取CPU ID、硬盘序列号、MAC地址、主板序列号
     *
     * @return 返回设置序号map集合
     */
    private static Map<String, String> getAllSn() {
        String os = System.getProperty("os.name").toUpperCase();
        Map<String, String> snVo = new HashMap<>();

        if ("LINUX".equals(os)) {
            String cpuid = getSerialNumber("dmidecode -t processor | grep 'ID'", "ID", ":");
            String mainboardNumber = getSerialNumber("dmidecode |grep 'Serial Number'", "Serial Number", ":");
            String diskNumber = getSerialNumber("fdisk -l", "Disk identifier", ":");
            String mac = getSerialNumber("ifconfig -a", "ether", " ");

            snVo.put("cpuid", Objects.requireNonNull(cpuid).toUpperCase().replace(" ", ""));
            snVo.put("diskid", Objects.requireNonNull(diskNumber).toUpperCase().replace(" ", ""));
            snVo.put("mac", Objects.requireNonNull(mac).toUpperCase().replace(" ", ""));
            snVo.put("mainboard", Objects.requireNonNull(mainboardNumber).toUpperCase().replace(" ", ""));
        }
        return snVo;
    }
}
