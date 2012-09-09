package fhdw.ipscrum.shared.utils;

import com.google.gwt.regexp.shared.RegExp;
import com.google.gwt.regexp.shared.SplitResult;

/**
 * A collection of help-operations for working with Strings.
 */
public final class StringUtils {

	/**
	 * constructor of this class.
	 */
	private StringUtils() {
	}

	/**
	 * This is a simple replacement for <code>String.format()</code>.
	 * 
	 * @param format
	 *            string to be formatted
	 * @param args
	 *            replacement-objects
	 * @return formatted string
	 */
	public static String format(final String format, final Object... args) {
		final RegExp regex = RegExp.compile("%[a-z]");
		final SplitResult split = regex.split(format);
		final StringBuffer msg = new StringBuffer();
		for (int pos = 0; pos < split.length() - 1; pos += 1) {
			msg.append(split.get(pos));
			final Object obj = args[pos];
			if (obj != null) {
				msg.append(args[pos].toString());
			} else {
				msg.append("[null]");
			}
		}
		msg.append(split.get(split.length() - 1));
		return msg.toString();
	}
}
