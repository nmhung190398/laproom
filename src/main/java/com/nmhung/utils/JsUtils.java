package com.nmhung.utils;

public class JsUtils {
	public static String html(String key, String value) {
		return "$('" + key + "').html('" + value + "');";
	}

	public static String val(String key, String value) {
		return "$('" + key + "').val('" + value + "');";
	}
}
