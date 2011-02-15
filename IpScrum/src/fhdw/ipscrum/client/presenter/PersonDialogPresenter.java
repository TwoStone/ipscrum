package fhdw.ipscrum.client.presenter;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.TwoStringArgs;
import fhdw.ipscrum.client.view.PersonDialogView;
import fhdw.ipscrum.client.view.interfaces.IPersonDialogView;
import fhdw.ipscrum.shared.SessionManager;
import fhdw.ipscrum.shared.exceptions.DoubleDefinitionException;
import fhdw.ipscrum.shared.exceptions.NoValidValueException;
import fhdw.ipscrum.shared.model.Person;
import fhdw.ipscrum.shared.model.interfaces.IPerson;

/**
 * Represents the presenter of the view with which the user could make new
 * persons or change persons.
 * 
 */
public class PersonDialogPresenter extends Presenter<IPersonDialogView> {

	private IPersonDialogView concreteView;
	private final IPerson person;

	/**
	 * Constructor for PersonDialogPresenter.
	 * 
	 * Required for making new persons.
	 * 
	 * @param parent
	 *            Panel
	 * 
	 */
	public PersonDialogPresenter(Panel parent) {
		this(parent, null);
	}

	/**
	 * Constructor for PersonDialogPresenter.
	 * 
	 * Required for changing persons.
	 * 
	 * @param parent
	 *            Panel
	 * @param person
	 *            IPerson
	 * 
	 */
	public PersonDialogPresenter(Panel parent, IPerson person) {
		super(parent);
		this.person = person;
		initialize();
	}

	/**
	 * Method createView.
	 * 
	 * Creates the view in which the user could make a new person or change a
	 * person and defines what happens when the user pushes the cancel- or
	 * OK-button.
	 * 
	 * @return IPersonDialogView
	 * 
	 */
	@Override
	protected IPersonDialogView createView() {

		this.concreteView = new PersonDialogView();

		this.concreteView.defineCancelEventHandler(new EventHandler<EventArgs>() {
			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {
				abort();
			}
		});

		this.concreteView.defineCommitEventHandler(new EventHandler<TwoStringArgs>() {
			@Override
			public void onUpdate(Object sender, TwoStringArgs eventArgs) {
				try {
					if (PersonDialogPresenter.this.person == null) {
						SessionManager.getInstance().getModel().addPerson(new Person(eventArgs.getString1(), eventArgs.getString2()));
					} else {
						PersonDialogPresenter.this.person.setFirstname(eventArgs.getString1());
						PersonDialogPresenter.this.person.setLastname(eventArgs.getString2());
					}
					finish();
				} catch (NoValidValueException e) {
					Window.alert(e.getMessage());
				} catch (DoubleDefinitionException e) {
					Window.alert(e.getMessage());
				}
			}
		});

		return this.concreteView;
	}

	/**
	 * Initializes the view with the values of the person chosen to change.
	 */
	private void initialize() {
		if (this.person != null) {
			this.concreteView.setVorname(this.person.getFirstname());
			this.concreteView.setNachname(this.person.getLastname());
		}
	}

}
