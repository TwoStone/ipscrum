package fhdw.ipscrum.client.view;

import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import fhdw.ipscrum.client.architecture.events.DefaultEvent;
import fhdw.ipscrum.client.architecture.events.DefaultEventHandler;
import fhdw.ipscrum.client.architecture.events.Event;
import fhdw.ipscrum.client.architecture.events.EventHandler;
import fhdw.ipscrum.client.architecture.events.EventRegistration;
import fhdw.ipscrum.client.architecture.widgets.TypedListBox;
import fhdw.ipscrum.client.architecture.widgets.TypedListBox.TypeRendere;
import fhdw.ipscrum.client.presenter.ProductBacklogItemCreatePresenter.CreateBugEvent;
import fhdw.ipscrum.client.presenter.ProductBacklogItemCreatePresenter.CreateFeatureEvent;
import fhdw.ipscrum.client.presenter.ProductBacklogItemCreatePresenter.CreateTicketEvent;
import fhdw.ipscrum.client.presenter.ProductBacklogItemCreatePresenter.IProductBacklogItemCreateView;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.BugTicketType;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.FeatureTicketType;
import fhdw.ipscrum.shared.model.nonMeta.Release;

/**
 * represents the view to create PBIs.
 */
public class ProductBacklogItemCreateView extends Composite
		implements IProductBacklogItemCreateView {

	/**
	 * represents the state of the view if the PBI to create is a bug.
	 */
	private class BugState extends ViewState {

		private Label lblRelease;
		private final TypedListBox<Release> releaseListBox = new TypedListBox<Release>(
				new TypeRendere<Release>() {

					@Override
					public String render(final Release object) {
						return object.getVersion();
					}
				});

		private final TypedListBox<BugTicketType> typeListBox =
				new TypedListBox<BugTicketType>(new TypeRendere<BugTicketType>() {

					@Override
					public String render(final BugTicketType object) {
						return object.getTypeName();
					}
				});

		@Override
		public void onSetup() {
			this.typeListBox.setVisibleItemCount(1);
			ProductBacklogItemCreateView.this.flexTable.setWidget(4, 1,
					this.typeListBox);
			this.typeListBox.setWidth("100%");

			this.lblRelease = new Label("Version");
			ProductBacklogItemCreateView.this.flexTable
					.setWidget(5, 0, this.lblRelease);

			this.releaseListBox.setVisibleItemCount(1);
			ProductBacklogItemCreateView.this.flexTable.setWidget(5, 1,
					this.releaseListBox);
			this.releaseListBox.setWidth("100%");
		}

		@Override
		public void onTearDown() {
			ProductBacklogItemCreateView.this.flexTable.removeCell(4, 1);
			ProductBacklogItemCreateView.this.flexTable.removeRow(5);
		}

		@Override
		public void save() {
			final String name = ProductBacklogItemCreateView.this.nameTextBox.getText();
			final String description =
					ProductBacklogItemCreateView.this.descriptionText.getText();

			final Release release = this.releaseListBox.getSelectedItemOrNull();
			final BugTicketType type = this.typeListBox.getSelectedItemOrNull();
			ProductBacklogItemCreateView.this.createTicketEvent.fire(
					ProductBacklogItemCreateView.this, new CreateBugEvent(name,
							description, type, release));
		}

		public void setBugTypes(final List<BugTicketType> bugTicketTypes) {
			this.typeListBox.clear();
			this.typeListBox.addItems(bugTicketTypes);
		}

		public void setReleases(final List<Release> releases) {
			this.releaseListBox.clear();
			this.releaseListBox.addItems(releases);
		}

	}

	/**
	 * represents the feature state.
	 */
	private class FeatureState extends ViewState {

		private final TypedListBox<FeatureTicketType> typeListBox =
				new TypedListBox<FeatureTicketType>(
						new TypeRendere<FeatureTicketType>() {

							@Override
							public String render(final FeatureTicketType object) {
								return object.getTypeName();
							}
						});

		@Override
		public void onSetup() {
			this.typeListBox.setVisibleItemCount(1);
			ProductBacklogItemCreateView.this.flexTable.setWidget(4, 1,
					this.typeListBox);
			this.typeListBox.setWidth("100%");
		}

		@Override
		public void onTearDown() {
			ProductBacklogItemCreateView.this.flexTable.removeCell(4, 1);
		}

		@Override
		public void save() {
			final String name = ProductBacklogItemCreateView.this.nameTextBox.getText();
			final String description =
					ProductBacklogItemCreateView.this.descriptionText.getText();

			final FeatureTicketType type = this.typeListBox.getSelectedItemOrNull();
			ProductBacklogItemCreateView.this.createTicketEvent.fire(
					ProductBacklogItemCreateView.this, new CreateFeatureEvent(name,
							description, type));

		}

		public void setFeatureTypes(final List<FeatureTicketType> types) {
			this.typeListBox.clear();
			this.typeListBox.addItems(types);
		}

	}

	/**
	 * represents the state of the view.
	 */
	private abstract class ViewState {
		private HandlerRegistration handler;

		public abstract void onSetup();

		public abstract void onTearDown();

		public abstract void save();

		public void setup() {
			this.handler =
					ProductBacklogItemCreateView.this.btnSpeichern
							.addClickHandler(new ClickHandler() {

								@Override
								public void onClick(final ClickEvent event) {
									ProductBacklogItemCreateView.ViewState.this.save();
								}
							});
			this.onSetup();
			FlexTableHelper.fixRowSpan(ProductBacklogItemCreateView.this.flexTable);
		}

		public void tearDown() {
			this.handler.removeHandler();
			this.onTearDown();
		}

	}

	private final DefaultEvent abortEvent = new DefaultEvent();

	private ViewState activeState;

	private final Button btnSpeichern;
	private final BugState bugState = new BugState();

	private final Event<CreateTicketEvent> createTicketEvent =
			new Event<CreateTicketEvent>();
	private final TextArea descriptionText;
	private final FeatureState featureState = new FeatureState();
	private final FlexTable flexTable;

	private final TextBox nameTextBox;

	/**
	 * constructor of the ProductBacklogItemCreateView.
	 */
	public ProductBacklogItemCreateView() {

		final VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		verticalPanel.setSpacing(10);
		this.initWidget(verticalPanel);

		final HTML htmlNewHtml =
				new HTML("<h3>ProductBacklog Eintrag erstellen</h3>", true);
		verticalPanel.add(htmlNewHtml);

		this.flexTable = new FlexTable();
		this.flexTable.setCellPadding(5);
		verticalPanel.add(this.flexTable);

		final Label lblName = new Label("Name");
		this.flexTable.setWidget(0, 0, lblName);

		this.nameTextBox = new TextBox();
		this.flexTable.setWidget(0, 1, this.nameTextBox);

		final Label lblBeschreibung = new Label("Beschreibung");
		this.flexTable.setWidget(1, 0, lblBeschreibung);

		this.descriptionText = new TextArea();
		this.flexTable.setWidget(1, 1, this.descriptionText);

		final Label lblTyp = new Label("Typ");
		this.flexTable.setWidget(2, 0, lblTyp);

		final RadioButton rdbtnFeature = new RadioButton("new name", "Feature");
		rdbtnFeature.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				ProductBacklogItemCreateView.this
						.setState(ProductBacklogItemCreateView.this.featureState);
			}
		});
		rdbtnFeature.setValue(true, false);
		this.flexTable.setWidget(2, 1, rdbtnFeature);

		final RadioButton rdbtnBug = new RadioButton("new name", "Bug");
		rdbtnBug.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(final ClickEvent event) {
				ProductBacklogItemCreateView.this
						.setState(ProductBacklogItemCreateView.this.bugState);
			}
		});
		this.flexTable.setWidget(3, 1, rdbtnBug);

		final Label lblUntertyp = new Label("Untertyp");
		this.flexTable.setWidget(4, 0, lblUntertyp);

		FlexTableHelper.fixRowSpan(this.flexTable);

		final HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setSpacing(5);
		verticalPanel.add(horizontalPanel);
		verticalPanel.setCellHorizontalAlignment(horizontalPanel,
				HasHorizontalAlignment.ALIGN_RIGHT);

		this.btnSpeichern = new Button("Speichern");
		horizontalPanel.add(this.btnSpeichern);

		final Button btnAbbrechen = new Button("Abbrechen");
		btnAbbrechen.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				ProductBacklogItemCreateView.this.abortEvent
						.fire(ProductBacklogItemCreateView.this);
			}
		});
		horizontalPanel.add(btnAbbrechen);
		this.setState(this.featureState);
	}

	@Override
	public void close() {
		this.createTicketEvent.removeAllHandler();
		this.abortEvent.removeAllHandler();
	}

	@Override
	public EventRegistration registerAbortHandler(final DefaultEventHandler handler) {
		return this.abortEvent.add(handler);
	}

	@Override
	public EventRegistration registerSaveHandler(
			final EventHandler<CreateTicketEvent> handler) {
		return this.createTicketEvent.add(handler);
	}

	@Override
	public void setBugType(final List<BugTicketType> types) {
		this.bugState.setBugTypes(types);
	}

	@Override
	public void setFeatureTypes(final List<FeatureTicketType> types) {
		this.featureState.setFeatureTypes(types);
	}

	@Override
	public void setReleases(final List<Release> releases) {
		this.bugState.setReleases(releases);
	}

	protected void setState(final ViewState viewState) {
		if (this.activeState != null) {
			this.activeState.tearDown();
		}
		this.activeState = viewState;
		this.activeState.setup();
	}

	@Override
	public void setRightVisibility(final Boolean value) {
		// No widgets to hide

	}

}
