package fhdw.ipscrum.client.view.widgets;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.google.gwt.cell.client.ActionCell;
import com.google.gwt.cell.client.Cell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.view.client.ListDataProvider;

import fhdw.ipscrum.client.architecture.events.EventArgs;
import fhdw.ipscrum.client.architecture.events.EventHandler;
import fhdw.ipscrum.client.architecture.events.EventRegistration;
import fhdw.ipscrum.client.architecture.presenter.Presenter;

/**
 * Widget launch presenters. From out of business logic.
 * 
 * @author NW
 * 
 */
public class PresenterLaunchWidget extends DialogBox {
	private DialogBox dialogBox;
	private ListDataProvider<Presenter> presenters;

	/**
	 * Constructor of the PresenterLaunchWidget.
	 * 
	 * @param presenters
	 *            to be launched
	 */
	public PresenterLaunchWidget(final Collection<Presenter> presenters) {
		this();
		this.presenters.setList(new ArrayList<Presenter>(presenters));
	}

	/**
	 * @wbp.parser.constructor
	 */
	public PresenterLaunchWidget() {
		super(true);
		if (!GWT.isProdMode()) {
			final Label launcher = new Label("Presenter Launcher");
			launcher.addClickHandler(new ClickHandler() {

				@Override
				public void onClick(final ClickEvent event) {
					PresenterLaunchWidget.this.show();
				}
			});
			RootPanel.get("adminPanel").add(launcher);
		}

		this.presenters = new ListDataProvider<Presenter>();

		this.setText("Presenter Launcher");
		this.setModal(false);

		this.dialogBox = new DialogBox(true);
		this.dialogBox.setGlassEnabled(true);
		this.dialogBox.setModal(true);

		final CellTable<Presenter> cellTable = new CellTable<Presenter>();
		this.add(cellTable);
		cellTable.setSize("100%", "100%");

		final TextColumn<Presenter> presenterName = new TextColumn<Presenter>() {

			@Override
			public String getValue(final Presenter object) {
				return object.getName();
			}
		};

		final Cell<Presenter> launchCell = new ActionCell<Presenter>("starten", new ActionCell.Delegate<Presenter>() {

			@Override
			public void execute(final Presenter object) {
				PresenterLaunchWidget.this.dialogBox.clear();
				PresenterLaunchWidget.this.dialogBox.add(object.getView());
				PresenterLaunchWidget.this.dialogBox.center();
				final List<EventRegistration> regs = new ArrayList<EventRegistration>();

				class CloseHanlder implements EventHandler<EventArgs> {

					@Override
					public void onUpdate(final Object sender, final EventArgs eventArgs) {
						PresenterLaunchWidget.this.dialogBox.hide();
						PresenterLaunchWidget.this.dialogBox.clear();
						for (final EventRegistration eventRegistration : regs) {
							eventRegistration.removeHandler();
						}
					}

				}
				final CloseHanlder handler = new CloseHanlder();
				regs.add(object.registerCloseHandler(handler));
			}
		});

		final Column<Presenter, Presenter> launchCol = new Column<Presenter, Presenter>(launchCell) {

			@Override
			public Presenter getValue(final Presenter object) {
				return object;
			}
		};

		cellTable.addColumn(presenterName);
		cellTable.addColumn(launchCol);

		this.presenters.addDataDisplay(cellTable);

	}

	/**
	 * Adds a presenter.
	 * 
	 * @param presenter
	 *            to be added
	 */
	public void addPresenter(final Presenter presenter) {
		this.presenters.getList().add(presenter);
	}
}
