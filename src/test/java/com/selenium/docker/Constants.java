/**
 * 
 */
package com.selenium.docker;

public class Constants {
	
	public static long timeOutInSeconds = 90; //1.5 minute
	
	public static final String DATE_FORMATE1 = "yyyy-MM-dd";
	public static final String DATE_FORMATE2 = "yyyy-MM-dd HH:mm:ss";
	
	// General
	public static String OS = System.getProperty("os.name").toLowerCase();
	public static boolean isDisableFirefoxLog = false; // If this is true then will now show firefox logs otherwise will show.
	public static boolean isHeadlessRequired = false; // Please true if headless is required
	public static boolean isProduction = true;
	

	public static final String LOGIN_TEXT = "Login";
	
	
	public static final String LOGIN_URL = "http://localhost:7080/login";
	public static final String TEST_CHECKBOX = "http://localhost:7080/checkboxes";
	public static final String CONTEXT_MENU = "http://localhost:7080/context_menu";
	public static final String DRAG_DROP = "http://localhost:7080/drag_and_drop";
	public static final String DROP_DOWN = "http://localhost:7080/dropdown";
	public static final String DYNAMIC_CONTENT = "http://localhost:7080/dynamic_content";
	public static final String DYNAMIC_CONTROL = "http://localhost:7080/dynamic_controls";
	public static final String DYNAMIC_LOADING = "http://localhost:7080/dynamic_loading/2";
	public static final String DOWNLOAD = "http://localhost:7080/download";
	public static final String UPLOAD = "http://localhost:7080/upload";
	public static final String FLOATING_MENU = "http://localhost:7080/floating_menu";
	public static final String IFRAME = "http://localhost:7080/iframe";
	public static final String HOVER = "http://localhost:7080/hovers";
	public static final String JSAlert = "http://localhost:7080/javascript_alerts";
	public static final String JSError = "http://localhost:7080/javascript_error";
	public static final String TestLinkOpen = "http://localhost:7080/windows";
	public static final String NotificationMessage = "http://localhost:7080/notification_message_rendered";
	
	
	public static final String EMAIL = "tomsmith";
	public static final String PASSWORD = "SuperSecretPassword!";

	
	
}
