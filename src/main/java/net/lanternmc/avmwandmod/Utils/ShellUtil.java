package net.lanternmc.avmwandmod.Utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
 
public class ShellUtil {
        //创建shell
	public static void createShell(String path, String... strs) throws Exception {
 
		if (strs == null) {
			System.out.println("strs is null");
			return;
		}
 
		File sh = new File(path);
		if (sh.exists()) {
			sh.delete();
		}
 
		sh.createNewFile();
		sh.setExecutable(true);
		FileWriter fw = new FileWriter(sh);
		BufferedWriter bf = new BufferedWriter(fw);
 
		for (int i = 0; i < strs.length; i++) {
			bf.write(strs[i]);
 
			if (i < strs.length - 1) {
				bf.newLine();
			}
		}
		bf.flush();
		bf.close();
	}
 
        //执行shell
	public static String runShell(String shpath) throws Exception {
 
		if (shpath == null || shpath.equals("")) {
			return "shpath is empty";
		}
		Process ps = Runtime.getRuntime().exec(shpath);
		ps.waitFor();
 
		BufferedReader br = new BufferedReader(new InputStreamReader(ps.getInputStream()));
		StringBuffer sb = new StringBuffer();
		String line;
		while ((line = br.readLine()) != null) {
			sb.append(line).append("\n");
		}
		String result = sb.toString();
		return result;
	}

}