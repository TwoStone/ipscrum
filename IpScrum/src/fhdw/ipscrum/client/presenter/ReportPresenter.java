package fhdw.ipscrum.client.presenter;

import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.ProjectEventArgs;
import fhdw.ipscrum.client.view.ReportView;
import fhdw.ipscrum.client.view.interfaces.IReportView;

/**
 * presenter class of the report interface. this interface is to inspect
 * statistical data regarding the sprint-/release progress (burn-down-charts)
 */
public class ReportPresenter extends Presenter<IReportView> {

	private IReportView concreteView;

	public ReportPresenter(final Panel parent, final Presenter<?> parentPresenter) {
		super(parent, parentPresenter);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.client.presenter.Presenter#createView()
	 */
	@Override
	protected IReportView createView() {
		this.concreteView = new ReportView();
		this.setupEventHandlers();
		return this.concreteView;
	}

	/**
	 * This is used to set up individual event actions.
	 */
	private void setupEventHandlers() {
		
		this.concreteView.addSelectProjectEventHandler(new EventHandler<ProjectEventArgs>() {
			@Override
			public void onUpdate(Object sender, ProjectEventArgs eventArgs) {
				new ProjectHistoryPresenter(ReportPresenter.this.getView().getContentPanel(), ReportPresenter.this, eventArgs.getProject());
			}
		});
	}

}
