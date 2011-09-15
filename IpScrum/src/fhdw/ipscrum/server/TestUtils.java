package fhdw.ipscrum.server;

import java.io.File;

/**
 * This class represents the TestUtils.
 */
public final class TestUtils {

	/**
	 * represents the constructor of the TestUtils.
	 */
	private TestUtils() {
	}

	/**
	 * deletes the contents of a folder.
	 * 
	 * @param dir
	 *            is the file to delete
	 */
	public static void deleteFolderContent(final File dir) {

		final File[] files = dir.listFiles();
		if (files != null) {
			for (final File file : files) {
				if (file.isDirectory()) {
					TestUtils.deleteFolderContent(file);
				} else {
					try {
						file.delete();
					} catch (final SecurityException e) {
						System.out.println(e);
					}
				}
			}
		}
	}

}
