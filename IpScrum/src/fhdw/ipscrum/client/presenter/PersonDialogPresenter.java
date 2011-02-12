package fhdw.ipscrum.client.presenter;

import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.TwoStringArgs;
import fhdw.ipscrum.client.view.PersonDialogView;
import fhdw.ipscrum.client.view.interfaces.IPersonDialogView;
import fhdw.ipscrum.shared.SessionManager;
import fhdw.ipscrum.shared.model.Person;
import fhdw.ipscrum.shared.model.interfaces.IPerson;


/**
 */
public class PersonDialogPresenter extends Presenter<IPersonDialogView>  {

	private IPersonDialogView concreteView;
	private final IPerson person;

	/**
	 * Constructor for PersonDialogPresenter.
	 * @param parent Panel
	 */
	public PersonDialogPresenter(Panel parent) {
		this(parent, null);
	}

	/**
	 * Constructor for PersonDialogPresenter.
	 * @param parent Panel
	 * @param person IPerson
	 */
	public PersonDialogPresenter(Panel parent, IPerson person) {
		super(parent);
		this.person = person;
		initialize();
	}

	/**
	 * Method createView.
	 * @return IPersonDialogView
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
				if (PersonDialogPresenter.this.person == null) {
					SessionManager.getInstance().getModel().addPerson(new Person(eventArgs.getString1(), eventArgs.getString2()));
				} else {
					PersonDialogPresenter.this.person.setFirstname(eventArgs.getString1());
					PersonDialogPresenter.this.person.setLastname(eventArgs.getString2());
				}

				finish();
			}
		});

		return this.concreteView;
	}

	/**
	 * 
	 */
	private void initialize() {
		if (this.person != null) {
			this.concreteView.getVorname().setText(this.person.getFirstname());
			this.concreteView.getNachname().setText(this.person.getLastname());
		}
	}

}
