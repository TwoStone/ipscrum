package fhdw.ipscrum.client.architecture.presenter;

import fhdw.ipscrum.client.architecture.ClientContext;

/**
 * represents a presenter in which nothing could be changed but only read.
 */
public abstract class ReadPresenter extends Presenter {

	/**
	 * constructor of the ReadPresenter.
	 * 
	 * @param context
	 *            of the presenter
	 */
	public ReadPresenter(final ClientContext context) {
		super(context);
	}
}
