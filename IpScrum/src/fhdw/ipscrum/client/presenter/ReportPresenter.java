package fhdw.ipscrum.client.presenter;

import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.view.ReportView;

/**
 * presenter class of the report interface. this interface is to inspect
 * statistical data regarding the sprint-/release progress (burn-down-charts)
 */
public class ReportPresenter extends Presenter<ReportView> {

	private ReportView concreteView;

	public ReportPresenter(Panel parent) {
		super(parent);
	}

	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.presenter.Presenter#createView()
	 */
	@Override
	protected ReportView createView() {
		this.concreteView = new ReportView();
		this.setupEventHandlers();
		return this.concreteView;
	}

	/**
	 * This is used to set up individual event actions.
	 */
	private void setupEventHandlers() {
		// Eventhandling goes here..
	}

}
