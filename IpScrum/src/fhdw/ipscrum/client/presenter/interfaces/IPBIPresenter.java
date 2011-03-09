package fhdw.ipscrum.client.presenter.interfaces;

public interface IPBIPresenter {
	/**
	 * Registers the presenter to all events of the view.
	 */
	void registerViewEvents();

	/**
	 * /** Sets the values of the loaded feature in the view.
	 */
	void setupView();

	/**
	 * Updates the view with the values of the feature. Does not set name and description. Call setupView to set them.
	 */
	void updateView();
}
