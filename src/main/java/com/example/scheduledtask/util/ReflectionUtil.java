package com.example.scheduledtask.util;

public class ReflectionUtil {
	public static String getSimpleClassName() {
		String[] className = Thread.currentThread().getStackTrace()[2].getClassName().split("\\.");
		return className[className.length -1];
	}

	public static String getMethodName() {
		return Thread.currentThread().getStackTrace()[2].getMethodName();
	}

	public static String getClassAndMethodName() {
		StackTraceElement elem = Thread.currentThread().getStackTrace()[2];
		String[] className = elem.getClassName().split("\\.");
		String simpleClassName = className[className.length - 1];
		return simpleClassName + "#" + elem.getMethodName();
	}
}
