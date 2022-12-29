package net.lanternmc.avmwandmod.Utils;

/**
 * 操作系统类：
 * 获取System.getProperty("os.name")对应的操作系统
 * @author isea533
 */
public class OSinfo {
	
	private static String OS = System.getProperty("os.name").toLowerCase();
	
	private static OSinfo _instance = new OSinfo();
	
	private OSinfo(){}
	
	public static boolean isLinux(){
		return OS.contains("linux");
	}
	
	public static boolean isMacOS(){
		return OS.contains("mac") &&OS.indexOf("os")>0&& !OS.contains("x");
	}
	
	public static boolean isMacOSX(){
		return OS.contains("mac") &&OS.indexOf("os")>0&&OS.indexOf("x")>0;
	}
	
	public static boolean isWindows(){
		return OS.contains("windows");
	}
	
	public static boolean isOS2(){
		return OS.contains("os/2");
	}
	
	public static boolean isSolaris(){
		return OS.contains("solaris");
	}
	
	public static boolean isSunOS(){
		return OS.contains("sunos");
	}
	
	public static boolean isMPEiX(){
		return OS.contains("mpe/ix");
	}
	
	public static boolean isHPUX(){
		return OS.contains("hp-ux");
	}
	
	public static boolean isAix(){
		return OS.contains("aix");
	}
	
	public static boolean isOS390(){
		return OS.contains("os/390");
	}
	
	public static boolean isFreeBSD(){
		return OS.contains("freebsd");
	}
	
	public static boolean isIrix(){
		return OS.contains("irix");
	}
	
	public static boolean isDigitalUnix(){
		return OS.contains("digital") &&OS.indexOf("unix")>0;
	}
	
	public static boolean isNetWare(){
		return OS.contains("netware");
	}
	
	public static boolean isOSF1(){
		return OS.contains("osf1");
	}
	
	public static boolean isOpenVMS(){
		return OS.contains("openvms");
	}

}