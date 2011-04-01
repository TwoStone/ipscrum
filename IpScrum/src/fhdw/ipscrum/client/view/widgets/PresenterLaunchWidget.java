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

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.EventRegistration;
import fhdw.ipscrum.client.presenter.Presenter;

/**
 * Widget launch presenters. From out of business logic.
 * 
 * @author NW
 * 
 */
public class PresenterLaunchWidget extends DialogBox {
	private DialogBox dialogBox;
	private ListDataProvider<Presenter<?>> presenters;

	public PresenterLaunchWidget(Collection<Presenter<?>> presenters) {
		this();
		this.presenters.setList(new ArrayList<Presenter<?>>(presenters));
	}

	/**
	 * @wbp.parser.constructor
	 */
	public PresenterLaunchWidget() {
		super(true);
		if (!GWT.isProdMode()) {
			Label launcher = new Label("Presenter Launcher");
			launcher.addClickHandler(new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {
					show();
				}
			});
			RootPanel.get("adminPanel").add(launcher);
		}

		this.presenters = new ListDataProvider<Presenter<?>>();

		this.setText("Presenter Launcher");
		this.setModal(false);

		dialogBox = new DialogBox(true);
		dialogBox.setGlassEnabled(true);
		dialogBox.setModal(true);

		CellTable<Presenter<?>> cellTable = new CellTable<Presenter<?>>();
		add(cellTable);
		cellTable.setSize("100%", "100%");

		TextColumn<Presenter<?>> presenterName = new TextColumn<Presenter<?>>() {

			@Override
			public String getValue(Presenter<?> object) {
				return object.getClass().getName();
			}
		};

		Cell<Presenter<?>> launchCell = new ActionCell<Presenter<?>>("starten",
				new ActionCell.Delegate<Presenter<?>>() {

					@Override
					public void execute(Presenter<?> object) {
						dialogBox.clear();
						dialogBox.add(object.getView());
						dialogBox.center();
						final List<EventRegistration> regs = new ArrayList<EventRegistration>();

						class CloseHanlder implements EventHandler<EventArgs> {

							@Override
							public void onUpdate(Object sender,
									EventArgs eventArgs) {
								dialogBox.hide();
								dialogBox.clear();
								for (EventRegistration eventRegistration : regs) {
									eventRegistration.removeHandler();
								}
							}

						}
						CloseHanlder handler = new CloseHanlder();
						regs.add(object.getAborted().add(handler));
						regs.add(object.getFinished().add(handler));
					}
				});

		Column<Presenter<?>, Presenter<?>> launchCol = new Column<Presenter<?>, Presenter<?>>(
				launchCell) {

			@Override
			public Presenter<?> getValue(Presenter<?> object) {
				return object;
			}
		};

		cellTable.addColumn(presenterName);
		cellTable.addColumn(launchCol);

		this.presenters.addDataDisplay(cellTable);

	}

	public void addPresenter(Presenter<?> presenter) {
		this.presenters.getList().add(presenter);
	}
}
