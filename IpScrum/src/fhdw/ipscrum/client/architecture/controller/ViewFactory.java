package fhdw.ipscrum.client.architecture.controller;

import com.google.gwt.user.client.ui.Widget;

import fhdw.ipscrum.client.architecture.widgets.BreadcrumbView;
import fhdw.ipscrum.client.architecture.widgets.IBreadcrumbView;
import fhdw.ipscrum.client.architecture.widgets.ILoginView;
import fhdw.ipscrum.client.architecture.widgets.INavigationView;
import fhdw.ipscrum.client.architecture.widgets.LoginView;
import fhdw.ipscrum.client.architecture.widgets.NavigationView;
import fhdw.ipscrum.client.architecture.widgets.RoleChooserView;
import fhdw.ipscrum.client.presenter.AddFieldsToTicketTypePresenter.IAddFieldsToTicketTypeView;
import fhdw.ipscrum.client.presenter.AddStatesToTicketTypePresenter.IAddStatesToTicketTypeView;
import fhdw.ipscrum.client.presenter.FieldTypeCreatePresenter.IFieldTypeCreateView;
import fhdw.ipscrum.client.presenter.IncidentTypeCreatePresenter.IIncidentTypeCreateView;
import fhdw.ipscrum.client.presenter.PersonCreatePresenter.IPersonCreateView;
import fhdw.ipscrum.client.presenter.PersonEditPresenter.IPersonEditView;
import fhdw.ipscrum.client.presenter.ProductBacklogItemCreatePresenter.IProductBacklogItemCreateView;
import fhdw.ipscrum.client.presenter.ProjectCreatePresenter.IProjectCreateView;
import fhdw.ipscrum.client.presenter.ProjectDisplayPresenter.IProjectDisplayView;
import fhdw.ipscrum.client.presenter.ProjectSelectSystemPresenter.ISelectSystemView;
import fhdw.ipscrum.client.presenter.ProjectSelectionPresenter.IProjectSelectionView;
import fhdw.ipscrum.client.presenter.ReleaseCreatePresenter.IReleaseCreateView;
import fhdw.ipscrum.client.presenter.RoleCreatePresenter.IRoleCreateView;
import fhdw.ipscrum.client.presenter.StateTransitionCreatePresenter.IStateTransitionCreateView;
import fhdw.ipscrum.client.presenter.StateTypeCreatePresenter.IStateCreateView;
import fhdw.ipscrum.client.presenter.SystemManagementPresenter.ISystemManagementView;
import fhdw.ipscrum.client.presenter.TeamCreatePresenter.ITeamCreateView;
import fhdw.ipscrum.client.presenter.TeamEditPresenter.ITeamEditView;
import fhdw.ipscrum.client.presenter.TicketTypeCreatePresenter.ITicketTypeCreateView;
import fhdw.ipscrum.client.presenter.TicketTypeSelectionPresenter.ITicketTypeSelectionView;
import fhdw.ipscrum.client.presenter.UserCreatePresenter.IUserCreateView;
import fhdw.ipscrum.client.presenter.UserManagementPresenter.IUserManagementView;
import fhdw.ipscrum.client.view.AddFieldsToTicketTypeView;
import fhdw.ipscrum.client.view.AddProjectToTeamView;
import fhdw.ipscrum.client.view.AddRightsToRoleView;
import fhdw.ipscrum.client.view.AddStatesToTicketTypeView;
import fhdw.ipscrum.client.view.CreateIncidentView;
import fhdw.ipscrum.client.view.CreateSprintView;
import fhdw.ipscrum.client.view.EditSprintView;
import fhdw.ipscrum.client.view.FieldTypeCreateView;
import fhdw.ipscrum.client.view.GenericTicketView;
import fhdw.ipscrum.client.view.IAddRightsToRoleView;
import fhdw.ipscrum.client.view.IncidentTypeCreateView;
import fhdw.ipscrum.client.view.PersonCreateView;
import fhdw.ipscrum.client.view.PersonEditView;
import fhdw.ipscrum.client.view.PersonRoleView;
import fhdw.ipscrum.client.view.ProductBacklogItemCreateView;
import fhdw.ipscrum.client.view.ProductBacklogView;
import fhdw.ipscrum.client.view.ProjectCreateView;
import fhdw.ipscrum.client.view.ProjectDisplayView;
import fhdw.ipscrum.client.view.ProjectHistoryView;
import fhdw.ipscrum.client.view.ProjectSelectionView;
import fhdw.ipscrum.client.view.ReleaseCreateView;
import fhdw.ipscrum.client.view.ReleaseEditView;
import fhdw.ipscrum.client.view.RevisionControlView;
import fhdw.ipscrum.client.view.RoleCreateView;
import fhdw.ipscrum.client.view.SearchAllView;
import fhdw.ipscrum.client.view.SearchResultView;
import fhdw.ipscrum.client.view.SearchView;
import fhdw.ipscrum.client.view.SearchesView;
import fhdw.ipscrum.client.view.SelectSystemView;
import fhdw.ipscrum.client.view.StateFieldAndTickettypeAdministrationView;
import fhdw.ipscrum.client.view.StateTransitionCreateView;
import fhdw.ipscrum.client.view.StateTypeCreateView;
import fhdw.ipscrum.client.view.SystemManagementView;
import fhdw.ipscrum.client.view.TaskCreateView;
import fhdw.ipscrum.client.view.TaskboardView;
import fhdw.ipscrum.client.view.TeamCreateView;
import fhdw.ipscrum.client.view.TeamEditView;
import fhdw.ipscrum.client.view.TeamView;
import fhdw.ipscrum.client.view.TicketTypeCreateView;
import fhdw.ipscrum.client.view.TicketTypeSelectionView;
import fhdw.ipscrum.client.view.TypeEditView;
import fhdw.ipscrum.client.view.UserCreateView;
import fhdw.ipscrum.client.view.UserManagementView;
import fhdw.ipscrum.client.view.WidgetView;
import fhdw.ipscrum.client.view.widgets.charts.ChartWidget;
import fhdw.ipscrum.client.viewinterfaces.IAddProjectToTeamView;
import fhdw.ipscrum.client.viewinterfaces.ICreateIncidentView;
import fhdw.ipscrum.client.viewinterfaces.ICreateSprintView;
import fhdw.ipscrum.client.viewinterfaces.IEditSprintView;
import fhdw.ipscrum.client.viewinterfaces.IGenericTicketView;
import fhdw.ipscrum.client.viewinterfaces.IPersonRoleView;
import fhdw.ipscrum.client.viewinterfaces.IProductBacklogView;
import fhdw.ipscrum.client.viewinterfaces.IProjectHistoryView;
import fhdw.ipscrum.client.viewinterfaces.IReleaseEditView;
import fhdw.ipscrum.client.viewinterfaces.IRevisionControlView;
import fhdw.ipscrum.client.viewinterfaces.ISearchAllView;
import fhdw.ipscrum.client.viewinterfaces.ISearchResultView;
import fhdw.ipscrum.client.viewinterfaces.ISearchView;
import fhdw.ipscrum.client.viewinterfaces.ISearchesView;
import fhdw.ipscrum.client.viewinterfaces.IStateFieldAndTickettypeAdministrationView;
import fhdw.ipscrum.client.viewinterfaces.ITaskCreateView;
import fhdw.ipscrum.client.viewinterfaces.ITaskboardView;
import fhdw.ipscrum.client.viewinterfaces.ITeamView;
import fhdw.ipscrum.client.viewinterfaces.IWidgetView;

/**
 * represent the view factory which is necessary to control the used views.
 */
public final class ViewFactory {

	/**
	 * returns the view used for the Loin.
	 * 
	 * @return the concrete view
	 */
	public ILoginView createLoginView() {
		return new LoginView();
	}

	/**
	 * returns the view used for the Navigation.
	 * 
	 * @return the concrete view
	 */
	public INavigationView createNavigationView() {
		return new NavigationView();
	}

	/**
	 * returns the view used for the Breadcrumb.
	 * 
	 * @return the concrete view
	 */
	public IBreadcrumbView createBreadcrumbView() {
		return new BreadcrumbView();
	}

	/**
	 * returns the view used for the project display.
	 * 
	 * @return the concrete view
	 */
	public IProjectDisplayView createProjectDisplayView() {
		return new ProjectDisplayView();
	}

	/**
	 * returns the view used for the project create.
	 * 
	 * @return the concrete view
	 */
	public IProjectCreateView createProjectCreateView() {
		return new ProjectCreateView();
	}

	/**
	 * returns the view used for the person and role administration.
	 * 
	 * @return the concrete view
	 */
	public IPersonRoleView createPersonRoleView() {
		return new PersonRoleView();
	}

	/**
	 * returns the view used for the role create.
	 * 
	 * @return the concrete view
	 */
	public IRoleCreateView createRoleCreateView() {
		return new RoleCreateView();
	}

	/**
	 * returns the view used for the person create.
	 * 
	 * @return the concrete view
	 */
	public IPersonCreateView createPersonCreateView() {
		return new PersonCreateView();
	}

	/**
	 * returns the view used for the team create.
	 * 
	 * @return the concrete view
	 */
	public ITeamCreateView createTeamCreateView() {
		return new TeamCreateView();
	}

	/**
	 * returns the view used for the team administration.
	 * 
	 * @return the concrete view
	 */
	public ITeamView createTeamView() {
		return new TeamView();
	}

	/**
	 * returns the view used for the selection of a system.
	 * 
	 * @return the concrete view
	 */
	public ISelectSystemView createSelectSystemView() {
		return new SelectSystemView();
	}

	/**
	 * returns the view used for the state create.
	 * 
	 * @return the concrete view
	 */
	public IStateCreateView createStateCreateView() {
		return new StateTypeCreateView();
	}

	/**
	 * returns the view used for the revision control.
	 * 
	 * @return the concrete view
	 */
	public IRevisionControlView createRevisionControlView() {
		return new RevisionControlView();
	}

	/**
	 * returns the view used for the system management.
	 * 
	 * @return the concrete view
	 */
	public ISystemManagementView createSystemManagementView() {
		return new SystemManagementView();
	}

	/**
	 * returns the view used for the field-, state-, ticket-type administration.
	 * 
	 * @return the concrete view
	 */
	public IStateFieldAndTickettypeAdministrationView createStateFieldAndTickettypeAdministrationView() {
		return new StateFieldAndTickettypeAdministrationView();
	}

	/**
	 * returns the view used for the search all.
	 * 
	 * @return the concrete view
	 */
	public ISearchAllView createSearchAllView() {
		return new SearchAllView();
	}

	/**
	 * returns the view used for the ticket-type create.
	 * 
	 * @return the concrete view
	 */
	public ITicketTypeCreateView createTicketTypeCreateView() {
		return new TicketTypeCreateView();
	}

	/**
	 * returns the view used for the field-type create.
	 * 
	 * @return the concrete view
	 */
	public IFieldTypeCreateView createFieldTypeCreateView() {
		return new FieldTypeCreateView();
	}

	/**
	 * returns the view used for the team edit.
	 * 
	 * @return the concrete view
	 */
	public ITeamEditView createTeamEditView() {
		return new TeamEditView();
	}

	/**
	 * returns the view used for the person edit.
	 * 
	 * @return the concrete view
	 */
	public IPersonEditView createPersonEditView() {
		return new PersonEditView();
	}

	/**
	 * returns the view used for the searches.
	 * 
	 * @return the concrete view
	 */
	public ISearchesView createSearchesView() {
		return new SearchesView();
	}

	/**
	 * returns the view used for the product backlog.
	 * 
	 * @return the concrete view
	 */
	public IProductBacklogView createProductBacklogView() {
		return new ProductBacklogView();
	}

	/**
	 * returns the view used for the search result.
	 * 
	 * @return the concrete view
	 */
	public ISearchResultView createSearchResultView() {
		return new SearchResultView();

	}

	/**
	 * returns the view used for the search create.
	 * 
	 * @return the concrete view
	 */
	public ISearchView createSearchView() {
		return new SearchView();
	}

	/**
	 * returns the view used for the user management.
	 * 
	 * @return the concrete view
	 */
	public IUserManagementView createUserManagementView() {
		return new UserManagementView();
	}

	/**
	 * returns the view used for the sprint create.
	 * 
	 * @return the concrete view
	 */
	public ICreateSprintView createCreateSprintView() {
		return new CreateSprintView();
	}

	/**
	 * returns the view used for the user create.
	 * 
	 * @return the concrete view
	 */
	public IUserCreateView createUserCreateView() {
		return new UserCreateView();
	}

	/**
	 * returns the view used for the sprint edit.
	 * 
	 * @return the concrete view
	 */
	public IEditSprintView createEditSprintView() {
		return new EditSprintView();
	}

	/**
	 * returns the view used for the widget create.
	 * 
	 * @param widget
	 *            to create
	 * @param title
	 *            of the widget
	 * @return the concrete view
	 */
	public IWidgetView createWidgetView(final ChartWidget widget, final String title) {
		return new WidgetView((Widget) widget, title);
	}

	/**
	 * returns the view used for the PBI create.
	 * 
	 * @return the concrete view
	 */
	public IProductBacklogItemCreateView createProductBacklogItemCreateView() {
		return new ProductBacklogItemCreateView();
	}

	/**
	 * returns the view used for the release create.
	 * 
	 * @return the concrete view
	 */
	public IReleaseCreateView createReleaseCreateView() {
		return new ReleaseCreateView();
	}

	/**
	 * returns the view used for the release edit.
	 * 
	 * @return the concrete view
	 */
	public IReleaseEditView createReleaseEditView() {
		return new ReleaseEditView();
	}

	/**
	 * returns the view used for the taskboard.
	 * 
	 * @return the concrete view
	 */
	public ITaskboardView createTaskboardView() {
		return new TaskboardView();
	}

	/**
	 * returns the view used for the task create.
	 * 
	 * @return the concrete view
	 */
	public ITaskCreateView createTaskCreateView() {
		return new TaskCreateView();
	}

	/**
	 * returns the view used for the project history.
	 * 
	 * @return the concrete view
	 */
	public IProjectHistoryView createProjectHistoryView() {
		return new ProjectHistoryView();
	}

	/**
	 * returns the view used for the incident type create.
	 * 
	 * @return the concrete view
	 */
	public IIncidentTypeCreateView createIncidentTypeCreateView() {
		return new IncidentTypeCreateView();
	}

	/**
	 * returns the view used for the incident create.
	 * 
	 * @return the concrete view
	 */
	public ICreateIncidentView createCreateIncidentView() {
		return new CreateIncidentView();
	}

	/**
	 * returns the view used for the generic ticket.
	 * 
	 * @return the concrete view
	 */
	public IGenericTicketView createGenericTicktView() {
		return new GenericTicketView();
	}

	/**
	 * returns the view used for the state transition create.
	 * 
	 * @return the concrete view
	 */
	public IStateTransitionCreateView createStateTransitionCreateView() {
		return new StateTransitionCreateView();
	}

	/**
	 * returns the view used for the type edit.
	 * 
	 * @return the concrete view
	 */
	public TypeEditView createTypeEditView() {
		return new TypeEditView();
	}

	/**
	 * returns the view used for the addition of states to a ticket type.
	 * 
	 * @return the concrete view
	 */
	public IAddStatesToTicketTypeView createAddStatesToTicketTypeView() {
		return new AddStatesToTicketTypeView();
	}

	/**
	 * returns the view used for the addition of fields to a ticket type.
	 * 
	 * @return the concrete view
	 */
	public IAddFieldsToTicketTypeView createAddFieldsToTicketTypeView() {
		return new AddFieldsToTicketTypeView();
	}

	/**
	 * returns the view used for the project selection.
	 * 
	 * @return the concrete view
	 */
	public IProjectSelectionView createProjectSelectionView() {
		return new ProjectSelectionView();
	}

	/**
	 * returns the view used for the ticket type selection.
	 * 
	 * @return the concrete view
	 */
	public ITicketTypeSelectionView createTicketTypeSelectionView() {
		return new TicketTypeSelectionView();
	}

	/**
	 * returns the view used for the addition of a project to a team.
	 * 
	 * @return the concrete view
	 */
	public IAddProjectToTeamView createAddProjectToTeamView() {
		return new AddProjectToTeamView();
	}

	/**
	 * returns the view used for the role choose.
	 * 
	 * @return the concrete view
	 */
	public RoleChooserView createRoleChoser() {
		return new RoleChooserView();
	}

	/**
	 * returns the view used for the addition of rights to a role.
	 * 
	 * @return the concrete view
	 */
	public IAddRightsToRoleView createAddRightsToRoleView() {
		return new AddRightsToRoleView();
	}
}
