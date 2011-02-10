package fhdw.ipscrum.client.presenter;

import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.args.PersonArgs;

import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.view.PersonDialogView;
import fhdw.ipscrum.client.view.interfaces.IPersonDialogView;
import fhdw.ipscrum.shared.SessionManager;
import fhdw.ipscrum.shared.model.Person;
import fhdw.ipscrum.shared.model.interfaces.IPerson;


public class PersonDialogPresenter extends Presenter<IPersonDialogView>  {

	private PersonDialogView concreteView;
	private IPerson person;

	public PersonDialogPresenter(Panel parent) {
		this(parent, null);
	}

	public PersonDialogPresenter(Panel parent, IPerson person) {
		super(parent);
		this.person = person;
	}

	@Override
	protected IPersonDialogView createView() {
		this.concreteView = new PersonDialogView();
		
		if (this.person != null) {
			this.concreteView.getVorname().setText(this.person.getFirstname());
			this.concreteView.getNachname().setText(this.person.getLastname());
		} else {
			this.person = new Person("","");
		}
		
		this.concreteView.defineCancelEventHandler(new EventHandler<EventArgs>() {
			public void onUpdate(Object sender, EventArgs eventArgs) {
				abort();
			}
		});
		
		this.concreteView.defineCommitEventHandler(new EventHandler<PersonArgs>() {
			public void onUpdate(Object sender, PersonArgs eventArgs) {
				SessionManager.getInstance().getModel().addPerson(eventArgs.getPerson());
				finish();
			}
		});
		
		return this.concreteView;
	}

}
