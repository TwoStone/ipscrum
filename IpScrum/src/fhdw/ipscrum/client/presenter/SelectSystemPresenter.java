package fhdw.ipscrum.client.presenter;

import java.util.Collection;

import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.SystemArgs;
import fhdw.ipscrum.client.view.SelectSystemView;
import fhdw.ipscrum.client.view.interfaces.ISelectSystemView;
import fhdw.ipscrum.client.view.widgets.AbortDialog;
import fhdw.ipscrum.client.view.widgets.AbortDialog.OnOkayCommand;
import fhdw.ipscrum.shared.model.System;

/**
 * presenter class for systems. this view is used to select systems of an amount of available systems.
 */
public class SelectSystemPresenter extends Presenter<ISelectSystemView> {

	private ISelectSystemView concreteView;
	private final Collection<System> availableSystems;
	private final Collection<System> selectedSystems;

	/**
	 * Constructor for SelectSystemPresenter.
	 * 
	 * @param parent Panel
	 * @param parentPresenter
	 * @param availableSystems
	 * @param selectedSystems
	 */
	public SelectSystemPresenter(final Panel parent, final Presenter<?> parentPresenter, final Collection<System> selectedSystems, final Collection<System> availableSystems) {
		super(parent, parentPresenter);
		this.availableSystems = availableSystems;
		this.selectedSystems = selectedSystems;
		this.updateGuiData();
		this.setupEventHandlers();
	}

	/**
	 * Method createView.
	 * 
	 * @return ISelectSystemView
	 */
	@Override
	protected ISelectSystemView createView() {
		this.concreteView = new SelectSystemView();
		return this.concreteView;
	}

	/**
	 * this is called to set up the behavior of all interaction widgets of this view.
	 */
	private void setupEventHandlers() {

		this.concreteView.defineRemoveSelectedSystemEvent(new EventHandler<SystemArgs>() {
			@Override
			public void onUpdate(Object sender, SystemArgs eventArgs) {
				SelectSystemPresenter.this.concreteView.meldung("Presenter: defineRemoveSelectedSystemEvent onUpdate");
				SelectSystemPresenter.this.selectedSystems.remove(eventArgs.getSystem());
				SelectSystemPresenter.this.updateGuiData();
			}

		});

		this.concreteView.defineAddSelectedSystemEvent(new EventHandler<SystemArgs>() {

			@Override
			public void onUpdate(Object sender, SystemArgs eventArgs) {
				SelectSystemPresenter.this.selectedSystems.add(eventArgs.getSystem());
				SelectSystemPresenter.this.updateGuiData();
			}
		});

		this.getView().getSave().add(new EventHandler<EventArgs>() {

			@Override
			public void onUpdate(final Object sender, final EventArgs eventArgs) {
				SelectSystemPresenter.this.finish();
			}
		});
		this.getView().getAborted().add(new EventHandler<EventArgs>() {

			@Override
			public void onUpdate(final Object sender, final EventArgs eventArgs) {
				new AbortDialog(new OnOkayCommand() {

					@Override
					public void onExecute() {
						SelectSystemPresenter.this.abort();
					}
				});
			}
		});
	}

	/**
	 * this is called to update or fill the entries in the gui-tables/tree-display.
	 */
	private void updateGuiData() {
		this.concreteView.updateAvailableSystemData(this.availableSystems, this.selectedSystems);
		this.concreteView.updateSelectedSystemData(this.selectedSystems);
	}

	public Collection<System> getSelectedSystems() {
		return this.selectedSystems;
	}
}
