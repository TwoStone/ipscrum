/**
 * 
 */
package fhdw.ipscrum.server.utils;

import java.io.File;

/**
 * Utility class for file Operations.
 */
public final class FileUtils {
	/**
	 * 
	 */
	private FileUtils() {
	}

	/**
	 * Concatenates all segments to one string using {@link File#separator} as glue.
	 * 
	 * @param segments
	 *            path segments
	 * @return path
	 */
	public static String buildPath(final String... segments) {
		final StringBuilder builder = new StringBuilder();
		for (final String segment : segments) {
			builder.append(segment);
			builder.append(File.separator);
		}
		return builder.toString();
	}

	/**
	 * Concatenates the path and the filename using {@link File#separator} as glue when not existent at the end of path.
	 * 
	 * @param path
	 *            the system path
	 * @param filename
	 *            the filename
	 * @return path + filename
	 */
	public static String buildPath(final String path, final String filename) {
		final StringBuilder builder = new StringBuilder(path);
		if (!path.endsWith(File.separator)) {
			builder.append(File.separator);
		}
		return builder.append(filename).toString();
	}
}
