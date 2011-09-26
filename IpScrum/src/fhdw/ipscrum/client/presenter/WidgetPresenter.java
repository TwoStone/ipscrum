package fhdw.ipscrum.client.presenter;

import com.google.gwt.user.client.ui.Widget;

import fhdw.ipscrum.client.architecture.ClientContext;
import fhdw.ipscrum.client.architecture.events.DefaultEventHandler;
import fhdw.ipscrum.client.architecture.events.EventArgs;
import fhdw.ipscrum.client.architecture.presenter.ReadPresenter;
import fhdw.ipscrum.client.architecture.view.IView;
import fhdw.ipscrum.client.viewinterfaces.IWidgetView;
import fhdw.ipscrum.shared.constants.HelpResources;

/**
 * This class represents the presenter which controls the view of various widgets.
 */
public class WidgetPresenter extends ReadPresenter {

	/**
	 * represents the title of the presenter.
	 */
	private final String title;

	@Override
	public IView getView() {
		final IView conView = this.doGetView();
		conView.registerHelpHandler(new DefaultEventHandler() {
			@Override
			public void onUpdate(final Object sender, final EventArgs eventArgs) {

				// TODO Fallunterscheidung je nach WidgetType -> ChartWidgetVisitor
				WidgetPresenter.this.getContext().getHelpController().showHelp(HelpResources.RELEASEBURNDOWNCHART);
				WidgetPresenter.this.getContext().getHelpController().showHelp(HelpResources.SPRINTBURNDOWNCHART);
				WidgetPresenter.this.getContext().getHelpController().showHelp(HelpResources.VELOCITYANALYSE);
			}
		});

		return this.view;
	}

	/**
	 * represents the widget to handle trough this presenter.
	 */
	private final Widget widget;
	/**
	 * Represents the view which is related to and controlled from this presenter.
	 */
	private IWidgetView view;

	/**
	 * constructor of the ({@link} fhdw.ipscrum.client.presenter.WidgetPresenter).
	 * 
	 * @param context
	 *            is the ({@link} fhdw.ipscrum.client.architecture.ClientContext) which is needed to get the model and
	 *            other related classes.
	 * @param widget
	 *            is the related widget to handle through this presenter
	 * @param title
	 *            is the title of the related widget
	 */
	public WidgetPresenter(final ClientContext context, final Widget widget, final String title) {
		super(context);
		this.title = title;
		this.widget = widget;
	}

	@Override
	public String getName() {
		return this.title;
	}

	@Override
	public IView doGetView() {
		if (this.view == null) {
			this.view = this.getContext().getViewFactory().createWidgetView(this.widget, this.title);

			this.view.registerCloseEventHandler(new DefaultEventHandler() {
				@Override
				public void onUpdate(final Object sender, final EventArgs eventArgs) {
					WidgetPresenter.this.close();
				}
			});
		}

		return this.view;
	}

	@Override
	public void updateView() {
		// nothing to do at the moment..
	}

	@Override
	public void onModelUpdate() {
		this.updateView();
	}

}
