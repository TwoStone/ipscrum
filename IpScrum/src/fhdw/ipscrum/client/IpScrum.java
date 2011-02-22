package fhdw.ipscrum.client;

import java.util.Date;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.datepicker.client.CalendarUtil;

import fhdw.ipscrum.client.presenter.RootPresenter;
import fhdw.ipscrum.shared.SessionManager;
import fhdw.ipscrum.shared.exceptions.ConsistencyException;
import fhdw.ipscrum.shared.exceptions.DoubleDefinitionException;
import fhdw.ipscrum.shared.exceptions.NoValidValueException;
import fhdw.ipscrum.shared.exceptions.UserException;
import fhdw.ipscrum.shared.model.Feature;
import fhdw.ipscrum.shared.model.Person;
import fhdw.ipscrum.shared.model.Project;
import fhdw.ipscrum.shared.model.RelationType;
import fhdw.ipscrum.shared.model.Release;
import fhdw.ipscrum.shared.model.Role;
import fhdw.ipscrum.shared.model.Sprint;
import fhdw.ipscrum.shared.model.Team;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class IpScrum implements EntryPoint {

	/**
	 * This method is used to populate the model with demo-data.
	 */
	private void initDemodate() {

		// Initial Roles
		Role roleTSUser;
		try {
			roleTSUser = new Role("Ticketsystem-Benutzer");

			final Role roleScrummaster = new Role("Scrum-Master");
			final Role roleProductOwner = new Role("Product-Owner");
			final Role roleDeveloper = new Role("Entwickler");
			final Role roleTester = new Role("Tester");
			final Role roleGUIWiz = new Role("GUI-Wizard");
			SessionManager.getInstance().getModel().addRole(roleTSUser);
			SessionManager.getInstance().getModel().addRole(roleScrummaster);
			SessionManager.getInstance().getModel().addRole(roleProductOwner);
			SessionManager.getInstance().getModel().addRole(roleDeveloper);
			SessionManager.getInstance().getModel().addRole(roleTester);
			SessionManager.getInstance().getModel().addRole(roleGUIWiz);

			// Initial Persons
			final Person pSarah = new Person("Sarah", "Gottwald");
			pSarah.addRole(roleScrummaster);
			pSarah.addRole(roleTSUser);

			final Person pWilken = new Person("Wilken", "Hustedt");
			pWilken.addRole(roleDeveloper);
			pWilken.addRole(roleGUIWiz);
			pWilken.addRole(roleTSUser);

			final Person pChristin = new Person("Christin", "Weckbrod");
			pChristin.addRole(roleProductOwner);
			pChristin.addRole(roleDeveloper);
			pChristin.addRole(roleTSUser);

			final Person pNils = new Person("Nils", "Vincent");
			pNils.addRole(roleTester);
			pNils.addRole(roleTSUser);

			try {
				SessionManager.getInstance().getModel().addPerson(pSarah);

				SessionManager.getInstance().getModel().addPerson(pWilken);
				SessionManager.getInstance().getModel().addPerson(pChristin);
				SessionManager.getInstance().getModel().addPerson(pNils);
			} catch (DoubleDefinitionException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}

			// Initial Teams
			final Team t1 = new Team("Frontend");
			t1.addMember(pSarah);
			t1.addMember(pWilken);

			final Team t2 = new Team("Backend");
			t2.addMember(pChristin);
			t2.addMember(pNils);

			try {
				SessionManager.getInstance().getModel().addTeam(t1);

				SessionManager.getInstance().getModel().addTeam(t2);
			} catch (DoubleDefinitionException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			// Initial Projects
			try {
				final Project project1 = new Project("Testprojekt 4");
				final Project project2 = new Project("Testprojekt 5");
				try {
					final Release release1 = new Release("1.1", new Date(), project1);
					final Release release2 = new Release("1.2", new Date(), project1);
					final Release release3 = new Release("1.3", new Date(), project1);
					final Release release4 = new Release("2.0", new Date(), project1);
					final Release release5 = new Release("2.1", new Date(), project1);
					try {
						final Feature f1 = new Feature("Feature 1", "Beschreibung Feature 1", project1.getBacklog());
						final Feature f2 = new Feature("Feature 2", "Beschreibung Feature 2", project1.getBacklog());
						final Feature f3 = new Feature("Feature 3", "Beschreibung Feature 3", project1.getBacklog());
						project1.getBacklog().addItem(f1);
						project1.getBacklog().addItem(f2);
						project1.getBacklog().addItem(f3);
					} catch (final UserException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					Date sprint1BeginDate = this.getRandomDateOfThisMonth();
					Date sprint2BeginDate = this.getRandomDateOfThisMonth();
					Date sprint3BeginDate = this.getRandomDateOfThisMonth();
					Date sprint4BeginDate = this.getRandomDateOfThisMonth();
					Date sprint5BeginDate = this.getRandomDateOfThisMonth();

					final Sprint sprint1 = new Sprint("Sprint1", "Beschreibung Sprint 1", sprint1BeginDate, this.getRandomSprintEnddate(sprint1BeginDate), t1);
					final Sprint sprint2 = new Sprint("Sprint2", "Beschreibung Sprint 2", sprint2BeginDate, this.getRandomSprintEnddate(sprint2BeginDate), t2);
					final Sprint sprint3 = new Sprint("Sprint3", "Beschreibung Sprint 3", sprint3BeginDate, this.getRandomSprintEnddate(sprint3BeginDate), t1);
					final Sprint sprint4 = new Sprint("Sprint4", "Beschreibung Sprint 4", sprint4BeginDate, this.getRandomSprintEnddate(sprint4BeginDate), t1);
					final Sprint sprint5 = new Sprint("Sprint5", "Beschreibung Sprint 5", sprint5BeginDate, this.getRandomSprintEnddate(sprint5BeginDate), t2);
					project1.addSprint(sprint1);
					project1.addSprint(sprint2);
					project1.addSprint(sprint3);
					project2.addSprint(sprint4);
					project2.addSprint(sprint5);

					try {
						release2.addSprint(sprint1);
						release2.addSprint(sprint2);
						release5.addSprint(sprint3);
					} catch (final UserException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				} catch (final DoubleDefinitionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				SessionManager.getInstance().getModel().addProject(new Project("Testprojekt 1"));
				SessionManager.getInstance().getModel().addProject(new Project("Testprojekt 2"));
				SessionManager.getInstance().getModel().addProject(new Project("Testprojekt 3"));
				SessionManager.getInstance().getModel().addProject(project1);
				SessionManager.getInstance().getModel().addProject(project2);

				RelationType.create("Abhängig von");
				RelationType.create("Siehe auch");

			} catch (final NoValidValueException e) {
				// Da sp��ter entfernt wird, wird diese Meldung zun�chst nicht
				// beachtet!
			} catch (final ConsistencyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (final DoubleDefinitionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (final NoValidValueException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (final ConsistencyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DoubleDefinitionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Generates a random date of the current month.
	 * @return random date of this month
	 */
	private Date getRandomDateOfThisMonth() {
		Date date = new Date();
		CalendarUtil.setToFirstDayOfMonth(date);
		CalendarUtil.addDaysToDate(date, (int) (Math.random()*28));
		return date;
	}

	/**
	 * Generates a random enddate to the given begindate.
	 * The duration is set to a random value between 5 and 26.
	 * @param sprintBeginDate a begindate
	 * @return a random enddate (begindate+(5--26))
	 */
	private Date getRandomSprintEnddate(Date sprintBeginDate) {
		Date endDate = CalendarUtil.copyDate(sprintBeginDate);
		CalendarUtil.addDaysToDate(endDate, (int) (Math.random() * 21 + 5));
		return endDate;
	}

	/**
	 * This is the entry point method.
	 */
	@Override
	public void onModuleLoad() {
		if (SessionManager.getInstance().getModel().countRoles() == 0) {
			this.initDemodate();
		}

		new RootPresenter(RootPanel.get("mainPanel"));
	}
}
