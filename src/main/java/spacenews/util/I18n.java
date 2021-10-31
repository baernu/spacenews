package spacenews.util;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class I18n {
	private static final String BASE_NAME = "labels";
	private static ResourceBundle bundle;

	public static ResourceBundle getResourceBundle(Locale locale) {
		bundle = ResourceBundle.getBundle(BASE_NAME, locale);
		return bundle;
	}

	public static String getString(String key) {
		try {
			return bundle.getString(key);
		} catch (MissingResourceException e) {
			return " ! " + key + " ! ";
		}
	}

	public static String getString(String key, Object... params) {
		try {
			return MessageFormat.format(bundle.getString(key), params);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}
