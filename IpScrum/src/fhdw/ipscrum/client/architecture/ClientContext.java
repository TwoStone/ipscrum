package fhdw.ipscrum.client.architecture;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

import fhdw.ipscrum.client.IDGenerator;
import fhdw.ipscrum.client.architecture.controller.ApplicationController;
import fhdw.ipscrum.client.architecture.controller.BreadcrumbController;
import fhdw.ipscrum.client.architecture.controller.HeartBeatController;
import fhdw.ipscrum.client.architecture.controller.HistoryController;
import fhdw.ipscrum.client.architecture.controller.NavigationController;
import fhdw.ipscrum.client.architecture.controller.QuestionController;
import fhdw.ipscrum.client.architecture.controller.SessionController;
import fhdw.ipscrum.client.architecture.controller.ToastMessageController;
import fhdw.ipscrum.client.architecture.controller.TransactionController;
import fhdw.ipscrum.client.architecture.controller.ViewFactory;
import fhdw.ipscrum.client.architecture.controller.WindowTitleController;
import fhdw.ipscrum.client.architecture.events.eventbus.EventBus;
import fhdw.ipscrum.client.architecture.events.eventbus.EventBus.Handler;
import fhdw.ipscrum.client.architecture.events.eventbus.EventBus.SingleObjectEvent;
import fhdw.ipscrum.client.architecture.menu.NavigationMenu;
import fhdw.ipscrum.client.architecture.presenter.Presenter;
import fhdw.ipscrum.client.services.ReceiveModelService;
import fhdw.ipscrum.shared.exceptions.model.ConsistencyException;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.nonMeta.Role;
import fhdw.ipscrum.shared.session.User;

/**
 * This class holds all important manager for the client.
 * 
 * @author Niklas
 * 
 */
public class ClientContext {

	public static class ModelUpdateEvent extends SingleObjectEvent<Model> {

		public ModelUpdateEvent(final Model object) {
			super(object);
		}
	}

	public abstract static class ModelUpdateHandler
			implements Handler<ClientContext.ModelUpdateEvent> {
		@Override
		public void handle(final ModelUpdateEvent event) {
			this.handleModelUpdated(event);
		}

		public abstract void handleModelUpdated(ModelUpdateEvent event);
	}

	private ApplicationController applicationController;

	private ToastMessageController toastMessageController;

	private HeartBeatController heartBeatController;

	private Model model;

	private QuestionController questionController;

	private TransactionController transactionController;

	private final EventBus eventBus;

	private ViewFactory viewFactory;

	private SessionController sessionController;

	private NavigationController navigationController;

	private WindowTitleController windowTitleController;

	private HistoryController historyController;

	private BreadcrumbController breadcrumbController;

	protected void setNavigationController(
			final NavigationController navigationController) {
		this.navigationController = navigationController;
	}

	protected void setWindowTitleController(
			final WindowTitleController windowTitleController) {
		this.windowTitleController = windowTitleController;
	}

	protected void setHistoryController(final HistoryController historyController) {
		this.historyController = historyController;
	}

	protected void setBreadcrumbController(
			final BreadcrumbController breadcrumbController) {
		this.breadcrumbController = breadcrumbController;
	}

	public Model getModel() {
		return this.model;
	}

	protected void setApplicationController(
			final ApplicationController applicationController) {
		this.applicationController = applicationController;
	}

	protected void setToastMessageController(
			final ToastMessageController toastMessageController) {
		this.toastMessageController = toastMessageController;
	}

	protected void
			setHeartBeatController(final HeartBeatController heartBeatController) {
		this.heartBeatController = heartBeatController;
	}

	protected void setQuestionController(final QuestionController questionController) {
		this.questionController = questionController;
	}

	protected void setTransactionController(
			final TransactionController transactionController) {
		this.transactionController = transactionController;
	}

	protected void setSessionController(final SessionController sessionController) {
		this.sessionController = sessionController;
	}

	protected ClientContext(final EventBus eventBus) {
		super();
		this.eventBus = eventBus;
	}

	public void setModel(final Model model) {
		this.model = model;
		ClientContext.this.model.setUuidManager(new IDGenerator());
		ClientContext.this.eventBus.publish(new ModelUpdateEvent(model));
	}

	public ViewFactory getViewFactory() {
		return this.viewFactory;
	}

	protected void setViewFactory(final ViewFactory viewFactory) {
		this.viewFactory = viewFactory;
	}

	public ApplicationController getApplicationController() {
		return this.applicationController;
	}

	public ToastMessageController getToastMessageController() {
		return this.toastMessageController;
	}

	public HeartBeatController getHeartBeatController() {
		return this.heartBeatController;
	}

	public QuestionController getQuestionController() {
		return this.questionController;
	}

	public TransactionController getTransactionController() {
		return this.transactionController;
	}

	public BreadcrumbController getBreadcrumbController() {
		return this.breadcrumbController;
	}

	public HistoryController getHistoryController() {
		return this.historyController;
	}

	public NavigationController getNavigationController() {
		return this.navigationController;
	}

	public WindowTitleController getWindowTitleController() {
		return this.windowTitleController;
	}

	public EventBus getEventBus() {
		return this.eventBus;
	}

	public void updateModel() {
		this.updateModel(new AsyncCallback<Model>() {

			@Override
			public void onFailure(final Throwable caught) {

			}

			@Override
			public void onSuccess(final Model result) {

			}
		});
	}

	public void updateModel(final AsyncCallback<Model> callback) {
		GWT.log("[Context] Updating model");
		this.applicationController.showLoadingIndicator();
		ReceiveModelService.Util.getInstance().getCurrentModel(
				new AsyncCallback<Model>() {

					@Override
					public void onSuccess(final Model result) {
						GWT.log("[Context] Model updated");
						ClientContext.this.setModel(result);
						callback.onSuccess(result);
						ClientContext.this.applicationController.hideLoadingIndicator();
					}

					@Override
					public void onFailure(final Throwable caught) {
						GWT.log("[Context] Error on update", caught);
						callback.onFailure(caught);
						ClientContext.this.applicationController.hideLoadingIndicator();
					}
				});
		this.applicationController.updatePresenters();
	}

	/**
	 * Factory class for the ClientContext.
	 * 
	 * @author Niklas
	 * 
	 */
	public static class ClientContextBuilder {
		private final ClientContext context;

		public ClientContextBuilder(final ViewFactory viewFactory,
				final Presenter startPresenter, final NavigationMenu items,
				final SessionController sessionController, final EventBus eventBus) {
			this.context = new ClientContext(eventBus);

			startPresenter.setContext(this.context);

			this.context.setHeartBeatController(new HeartBeatController(eventBus));
			this.context.setTransactionController(new TransactionController(
					this.context));
			this.context.setViewFactory(viewFactory);

			this.context.setSessionController(sessionController);

			this.context.setApplicationController(new ApplicationController(
					this.context, startPresenter));
			this.context.setToastMessageController(new ToastMessageController());
			this.context.setQuestionController(new QuestionController());
			this.context.setHistoryController(new HistoryController(this.context));
			this.context.setNavigationController(new NavigationController(this.context,
					items));
			this.context.setWindowTitleController(new WindowTitleController(
					this.context));
			this.context
					.setBreadcrumbController(new BreadcrumbController(this.context));
		}

		public ClientContext getContext() {
			return this.context;
		}
	}

	public User getCurrentUser() {
		return this.applicationController.getCurrentUser();
	}

	/**
	 * Returns the active role of the current logged in user.
	 * 
	 * @return active {@link Role}
	 */
	public Role getActiveRole() {
		return this.getSessionController().getActiveRole();
	}

	/**
	 * Assigns the active role of the current user. Pre-condition: A current User is
	 * assigned (logged in).
	 * 
	 * @param activeRole
	 *            active role.
	 * @throws ConsistencyException
	 *             if the active role is not assigned to the current user.
	 */
	public void setActiveRole(final Role activeRole) throws ConsistencyException {
		this.getSessionController().setActiveRole(activeRole);
	}

	public SessionController getSessionController() {
		return this.sessionController;
	}

}
