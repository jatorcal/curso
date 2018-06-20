package com.ceac.campus.utilities;

public class OSValidator {

	public enum OSType {
		WINDOWS, MAC, LINUX, NOT_SUPPORTED
	}

	public OSType checkOS() throws Exception {

		String os = System.getProperty("os.name").toLowerCase();

		if (isWindows(os)) {
			return OSType.WINDOWS;
		} else if (isMac(os)) {
			return OSType.MAC;
		} else if (isUnix(os)) {
			return OSType.LINUX;
		} else {
			throw new Exception("SO not supported");
		}
	}

	private boolean isWindows(String os) {

		return (os.indexOf("win") >= 0);

	}

	private boolean isMac(String os) {

		return (os.indexOf("mac") >= 0);

	}

	private boolean isUnix(String os) {

		return (os.indexOf("nix") >= 0 || os.indexOf("nux") >= 0 || os.indexOf("aix") > 0);

	}

}
