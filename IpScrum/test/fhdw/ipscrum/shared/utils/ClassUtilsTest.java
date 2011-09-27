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
		Assert.assertEquals("String", className);
	}

	/**
	 * tests the Method "getClassName" with a Presenter-Class.
	 */
	public void testGetClassName2() {
		final String className = ClassUtils.getClassName(ProductBacklogItemCreatePresenter.class);
		Assert.assertEquals("ProductBacklogItemCreatePresenter", className);
	}

	/**
	 * tests the Method "getClassName" with a View-Class.
	 */
	public void testGetClassName3() {
		final String className = ClassUtils.getClassName(ProductBacklogItemCreateView.class);
		Assert.assertEquals("ProductBacklogItemCreateView", className);
	}
}
