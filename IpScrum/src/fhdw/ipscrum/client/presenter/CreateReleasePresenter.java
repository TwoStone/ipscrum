package fhdw.ipscrum.client.presenter;

import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.utils.GwtUtils;
import fhdw.ipscrum.client.view.CreateReleaseView;
import fhdw.ipscrum.client.view.interfaces.ICreateReleaseView;
import fhdw.ipscrum.client.view.widgets.AbortDialog;
import fhdw.ipscrum.client.view.widgets.AbortDialog.OnOkayCommand;
import fhdw.ipscrum.shared.exceptions.DoubleDefinitionException;
import fhdw.ipscrum.shared.model.Project;
import fhdw.ipscrum.shared.model.Release;

/**
 * Presenter for creating a new {@link Release}
 * 
 * @author Manu
 * 
 */
public class CreateReleasePresenter extends Presenter<ICreateReleaseView> {

	Project project;

	/**
	 * Creates a new Instance of {@link CreateReleasePresenter}
	 * 
	 * @param parent
	 * @param project
	 */
	public CreateReleasePresenter(final Panel parent, final Project project) {
		super(parent);
		this.project = project;
	}

	@Override
	protected ICreateReleaseView createView() {
		// New instance of CreateReleaseView
		final ICreateReleaseView view = new CreateReleaseView();

		// Add a handler for the event which saves a new Release
		view.addSaveVersionHandler(new EventHandler<EventArgs>() {

			@Override
			public void onUpdate(final Object sender, final EventArgs eventArgs) {
				try {
					new Release(view.getReleaseVersion(), view.getDateBox()
							.getValue(), CreateReleasePresenter.this.project);
				} catch (final DoubleDefinitionException e) {
					GwtUtils.displayError(e.getMessage());
				}
				CreateReleasePresenter.this.finish();
			}

		});

		// Add a handler for the event which cancels creating of a new release
		view.addCancelCreateReleaseHandler(new EventHandler<EventArgs>() {

			@Override
			public void onUpdate(final Object sender, final EventArgs eventArgs) {
				new AbortDialog(new OnOkayCommand() {

					@Override
					public void onExecute() {
						CreateReleasePresenter.this.abort();
					}
				});

			}
		});

		return view;
	}
}
