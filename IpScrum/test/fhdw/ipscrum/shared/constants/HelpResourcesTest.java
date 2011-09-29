package fhdw.ipscrum.shared.constants;

import junit.framework.Assert;

import org.junit.Test;

import fhdw.ipscrum.client.architecture.presenter.Presenter;
import fhdw.ipscrum.client.presenter.TaskboardPresenter;

/**
 * This is to test the util-operations.
 */
public class HelpResourcesTest {

	/**
	 * tests the Method "getPresenterHelp".
	 */
	@Test
	public void testGetPresenterHelp1() {

		final Presenter presenter = new TaskboardPresenter(null, null, null);

		final String result = HelpResources.getPresenterHelp(presenter);

		Assert.assertEquals(HelpResources.TASKBOARDPRESENTER, result);
	}
}
