package fhdw.ipscrum.shared.utils;

import org.junit.Assert;
import org.junit.Test;

import fhdw.ipscrum.client.presenter.ProductBacklogItemCreatePresenter;
import fhdw.ipscrum.client.view.ProductBacklogItemCreateView;

/**
 * This is to test the util-operations.
 */
public class ClassUtilsTest {

	/**
	 * tests the Method "getClassName" with a normal Class.
	 */
	@Test
	public void testGetClassName1() {
		final String className = ClassUtils.getClassName(String.class);

		final String cl = String.class.toString();
		final int i = cl.lastIndexOf(".");
		final String expected = cl.substring(i + 1, cl.length());

		Assert.assertEquals(expected, className);
	}

	/**
	 * tests the Method "getClassName" with a Presenter-Class.
	 */
	public void testGetClassName2() {
		final String className = ClassUtils.getClassName(ProductBacklogItemCreatePresenter.class);

		final String cl = ProductBacklogItemCreatePresenter.class.toString();
		final int i = cl.lastIndexOf(".");
		final String expected = cl.substring(i + 1, cl.length());

		Assert.assertEquals(expected, className);
	}

	/**
	 * tests the Method "getClassName" with a View-Class.
	 */
	public void testGetClassName3() {
		final String className = ClassUtils.getClassName(ProductBacklogItemCreateView.class);

		final String cl = ProductBacklogItemCreateView.class.toString();
		final int i = cl.lastIndexOf(".");
		final String expected = cl.substring(i + 1, cl.length());

		Assert.assertEquals(expected, className);
	}
}
