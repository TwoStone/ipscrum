package fhdw.ipscrum.shared.constants;

import junit.framework.Assert;

import org.junit.Test;

import fhdw.ipscrum.client.architecture.presenter.Presenter;
import fhdw.ipscrum.client.architecture.view.IView;
import fhdw.ipscrum.client.presenter.PersonRolePresenter;
import fhdw.ipscrum.client.presenter.StateFieldAndTickettypeAdministrationPresenter;
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

	/**
	 * Tests getPresenterHelp with a Presenter with a class name greater than 32 characters.
	 */
	@Test
	public void testGetPresenterHelpGT32() {
		final Presenter presenter = new StateFieldAndTickettypeAdministrationPresenter(null);

		final String result = HelpResources.getPresenterHelp(presenter);

		Assert.assertEquals(HelpResources.STATEFIELDANDTICKETTYPEADMINISTR, result);
	}

	/**
	 * Tests getPresenterHelp with a Presenter with a class name lower than 32 characters.
	 */
	@Test
	public void testGetPresenterHelpLT32() {
		final Presenter presenter = new PersonRolePresenter(null);

		final String result = HelpResources.getPresenterHelp(presenter);

		Assert.assertEquals(HelpResources.PERSONROLEPRESENTER, result);

	}

	/**
	 * Tests getPresenterHelp with a Presenter which hasn't a assigned Help file.
	 */
	@Test
	public void testGetPresenterHelp404() {
		final Presenter presenter = new Presenter(null) {

			@Override
			public void updateView() {
				// TODO Auto-generated method stub

			}

			@Override
			public void onModelUpdate() {
				// TODO Auto-generated method stub

			}

			@Override
			public String getName() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public IView doGetView() {
				// TODO Auto-generated method stub
				return null;
			}
		};

		final String result = HelpResources.getPresenterHelp(presenter);

		// Assert.assertEquals(HelpResources., result);
	}

}
