package fhdw.ipscrum.client.architecture;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

import fhdw.ipscrum.client.IDGenerator;
import fhdw.ipscrum.client.architecture.controller.ApplicationController;
import fhdw.ipscrum.client.architecture.controller.BreadcrumbController;
import fhdw.ipscrum.client.architecture.controller.HeartBeatController;
import fhdw.ipscrum.client.architecture.controller.HelpController;
import fhdw.ipscrum.client.architecture.controller.HistoryController;
import fhdw.ipscrum.client.architecture.controller.NavigationController;
import fhdw.ipscrum.client.architecture.controller.QuestionController;
import fhdw.ipscrum.client.architecture.controller.SessionController;
import fhdw.ipscrum.client.architecture.controller.ToastMessageController;
import fhdw.ipscrum.client.architecture.controller.TransactionController;
import fhdw.ipscrum.client.architecture.controller.WindowTitleController;
import fhdw.ipscrum.client.architecture.events.eventbus.EventBus;
import fhdw.ipscrum.client.architecture.events.eventbus.EventBus.Handler;
import fhdw.ipscrum.client.architecture.events.eventbus.EventBus.SingleObjectEvent;
import fhdw.ipscrum.client.architecture.menu.NavigationMenu;
import fhdw.ipscrum.client.architecture.presenter.Presenter;
import fhdw.ipscrum.client.services.ReceiveModelService;
import fhdw.ipscrum.client.view.ViewFactory;
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

	/**
	 * Represents the inner class which represents the event needed to update the model.
	 */
	public static class ModelUpdateEvent extends SingleObjectEvent<Model> {

		/**
		 * Constructor of the ModelUpdateEvent.
		 * 
		 * @param object
		 *            is the model to update
		 */
		public ModelUpdateEvent(final Model object) {
			super(object);
		}
	}

	/**
	 * Represents the handler needed to handle the modelUpdateEvent.
	 */
	public abstract static class ModelUpdateHandler implements Handler<ClientContext.ModelUpdateEvent> {
		@Override
		public void handle(final ModelUpdateEvent event) {
			this.handleModelUpdated(event);
		}

		/**
		 * Needed for handling the modelUpdateEvent.
		 * 
		 * @param event
		 *            to handle
		 */
		public abstract void handleModelUpdated(ModelUpdateEvent event);
	}

	/**
	 * Represents the ApplicationController related to the ClientContext.
	 */
	private ApplicationController applicationController;

	/**
	 * Represents the ToastMessageController related to the ClientContext.
	 */
	private ToastMessageController toastMessageController;

	/**
	 * Setter.
	 * 
	 * @param helpController
	 *            HelpController
	 */
	public void setHelpController(final HelpController helpController) {
		this.helpController = helpController;
	}

	/**
	 * Represents the HelpController related to the ClientContext.
	 */
	private HelpController helpController;

	/**
	 * Represents the HeartBeatController related to the ClientContext.
	 */
	private HeartBeatController heartBeatController;

	/**
	 * Represents the Model related to the ClientContext.
	 */
	private Model model;

	/**
	 * Represents the QuestionController related to the ClientContext.
	 */
	private QuestionController questionController;

	/**
	 * Represents the TransactionController related to the ClientContext.
	 */
	private TransactionController transactionController;

	/**
	 * Represents the EventBus related to the ClientContext.
	 */
	private final EventBus eventBus;

	/**
	 * Represents the ViewFactory related to the ClientContext.
	 */
	private ViewFactory viewFactory;

	/**
	 * Represents the SessionController related to the ClientContext.
	 */
	private SessionController sessionController;

	/**
	 * Represents the NavigationController related to the ClientContext.
	 */
	private NavigationController navigationController;

	/**
	 * Represents the WindowTitleController related to the ClientContext.
	 */
	private WindowTitleController windowTitleController;

	/**
	 * Represents the HistoryController related to the ClientContext.
	 */
	private HistoryController historyController;

	/**
	 * Represents the BreadcrumbController related to the ClientContext.
	 */
	private BreadcrumbController breadcrumbController;

	/**
	 * Sets the navigationController of the ClientContext.
	 * 
	 * @param navigationController
	 *            to set
	 */
	protected void setNavigationController(final NavigationController navigationController) {
		this.navigationController = navigationController;
	}

	/**
	 * Sets the windowTitleController of the ClientContext.
	 * 
	 * @param windowTitleController
	 *            to set
	 */
	protected void setWindowTitleController(final WindowTitleController windowTitleController) {
		this.windowTitleController = windowTitleController;
	}

	/**
	 * Sets the historyController of the ClientCOntext.
	 * 
	 * @param historyController
	 *            to set
	 */
	protected void setHistoryController(final HistoryController historyController) {
		this.historyController = historyController;
	}

	/**
	 * Sets the breadcrumbController of the ClientContext.
	 * 
	 * @param breadcrumbController
	 *            to set
	 */
	protected void setBreadcrumbController(final BreadcrumbController breadcrumbController) {
		this.breadcrumbController = breadcrumbController;
	}

	/**
	 * @return the model related to the ClientContext.
	 */
	public Model getModel() {
		return this.model;
	}

	/**
	 * Sets the applicationController of the ClientContext.
	 * 
	 * @param applicationController
	 *            to set
	 */
	protected void setApplicationController(final ApplicationController applicationController) {
		this.applicationController = applicationController;
	}

	/**
	 * Sets the toastMessageController of the ClientContext.
	 * 
	 * @param toastMessageController
	 *            to set
	 */
	protected void setToastMessageController(final ToastMessageController toastMessageController) {
		this.toastMessageController = toastMessageController;
	}

	/**
	 * Sets the heartBeatController of the ClientContext.
	 * 
	 * @param heartBeatController
	 *            to set
	 */
	protected void setHeartBeatController(final HeartBeatController heartBeatController) {
		this.heartBeatController = heartBeatController;
	}

	/**
	 * Sets the questionController of the ClientContext.
	 * 
	 * @param questionController
	 *            to set
	 */
	protected void setQuestionController(final QuestionController questionController) {
		this.questionController = questionController;
	}

	/**
	 * Sets the transactionController of the ClientContext.
	 * 
	 * @param transactionController
	 *            to set
	 */
	protected void setTransactionController(final TransactionController transactionController) {
		this.transactionController = transactionController;
	}

	/**
	 * Sets the sessionController of the ClientContext.
	 * 
	 * @param sessionController
	 *            to set.
	 */
	protected void setSessionController(final SessionController sessionController) {
		this.sessionController = sessionController;
	}

	/**
	 * Constructor of the ClientContext.
	 * 
	 * @param eventBus
	 *            is the related eventBus
	 */
	protected ClientContext(final EventBus eventBus) {
		super();
		this.eventBus = eventBus;
	}

	/**
	 * Setter of the model in the ClientContext.
	 * 
	 * @param model
	 *            to set
	 */
	public void setModel(final Model model) {
		this.model = model;
		ClientContext.this.model.setUuidManager(new IDGenerator());
		ClientContext.this.eventBus.publish(new ModelUpdateEvent(model));
	}

	/**
	 * @return the viewFactory.
	 */
	public ViewFactory getViewFactory() {
		return this.viewFactory;
	}

	/**
	 * Setter of the viewFacroty.
	 * 
	 * @param viewFactory
	 *            to set
	 */
	protected void setViewFactory(final ViewFactory viewFactory) {
		this.viewFactory = viewFactory;
	}

	/**
	 * @return the ApllicationController.
	 */
	public ApplicationController getApplicationController() {
		return this.applicationController;
	}

	/**
	 * @return the ToastMessageController.
	 */
	public ToastMessageController getToastMessageController() {
		return this.toastMessageController;
	}

	/**
	 * Getter.
	 * 
	 * @return HelpController
	 */
	public HelpController getHelpController() {
		return this.helpController;
	}

	/**
	 * @return the HeartBeatController.
	 */
	public HeartBeatController getHeartBeatController() {
		return this.heartBeatController;
	}

	/**
	 * @return the QuestionController.
	 */
	public QuestionController getQuestionController() {
		return this.questionController;
	}

	/**
	 * @return the TransactionController.
	 */
	public TransactionController getTransactionController() {
		return this.transactionController;
	}

	/**
	 * @return the BreadcrumbController.
	 */
	public BreadcrumbController getBreadcrumbController() {
		return this.breadcrumbController;
	}

	/**
	 * @return the HistoryController.
	 */
	public HistoryController getHistoryController() {
		return this.historyController;
	}

	/**
	 * @return the NavigationController.
	 */
	public NavigationController getNavigationController() {
		return this.navigationController;
	}

	/**
	 * @return the WundowTitleController.
	 */
	public WindowTitleController getWindowTitleController() {
		return this.windowTitleController;
	}

	/**
	 * @return the current eventBus.
	 */
	public EventBus getEventBus() {
		return this.eventBus;
	}

	/**
	 * Needed to update the current model of the client.
	 */
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

	/**
	 * Needed for updating the current model asynchrony.
	 * 
	 * @param callback
	 *            needed for doing thinsd asynchrony
	 */
	public void updateModel(final AsyncCallback<Model> callback) {
		GWT.log("[Context] Updating model");
		this.applicationController.showLoadingIndicator();
		ReceiveModelService.Util.getInstance().getCurrentModel(new AsyncCallback<Model>() {

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
		/**
		 * Represents the ClientContext which should be build.
		 */
		private final ClientContext context;

		/**
		 * Needed for building the clientContext.
		 * 
		 * @param viewFactory
		 *            is the viewFacroty related to the clientContext which is needed to control the views
		 * @param startPresenter
		 *            is the presenter related to the clientContext with which the IPScrum starts
		 * @param items
		 *            are the items in the navigation menu related to the clientContext
		 * @param sessionController
		 *            is the controller related to this session and clientContext
		 * @param eventBus
		 *            is the eventBus needed to controle events
		 */
		public ClientContextBuilder(final ViewFactory viewFactory, final Presenter startPresenter,
				final NavigationMenu items, final SessionController sessionController, final EventBus eventBus) {
			this.context = new ClientContext(eventBus);

			startPresenter.setContext(this.context);

			this.context.setHeartBeatController(new HeartBeatController(eventBus));
			this.context.setTransactionController(new TransactionController(this.context));
			this.context.setViewFactory(viewFactory);

			this.context.setSessionController(sessionController);

			this.context.setApplicationController(new ApplicationController(this.context, startPresenter));
			this.context.setToastMessageController(new ToastMessageController());
			this.context.setHelpController(new HelpController());
			this.context.setQuestionController(new QuestionController());
			this.context.setHistoryController(new HistoryController(this.context));
			this.context.setNavigationController(new NavigationController(this.context, items));
			this.context.setWindowTitleController(new WindowTitleController(this.context));
			this.context.setBreadcrumbController(new BreadcrumbController(this.context));
		}

		/**
		 * @return the current clientContext.
		 */
		public ClientContext getContext() {
			return this.context;
		}
	}

	/**
	 * @return the current user.
	 */
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
	 * Assigns the active role of the current user. Pre-condition: A current User is assigned (logged in).
	 * 
	 * @param activeRole
	 *            active role.
	 * @throws ConsistencyException
	 *             if the active role is not assigned to the current user.
	 */
	public void setActiveRole(final Role activeRole) throws ConsistencyException {
		this.getSessionController().setActiveRole(activeRole);
	}

	/**
	 * @return the current sessionController.
	 */
	public SessionController getSessionController() {
		return this.sessionController;
	}

}
