package fhdw.ipscrum.client.view;

import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;

import fhdw.ipscrum.client.events.Event;
import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.view.interfaces.ICreateProjectView;
import fhdw.ipscrum.client.view.interfaces.IView;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

public class CreateProjectView extends Composite implements ICreateProjectView {

	// ####### Events #######
	private final Event<EventArgs> saveEvent = new Event<EventArgs>();
	// ####### Ende ######

	private Button btnCreateProject;
	private TextBox txtBoxBezeichnung;

	public static IView createView() {
		return new CreateProjectView();
	}

	public CreateProjectView() {

		AbsolutePanel concreteCreateProjectPanel = new AbsolutePanel();
		initWidget(concreteCreateProjectPanel);
		concreteCreateProjectPanel.setSize("200px", "200px");

		Label lblCreateProjet = new Label("Neues Projekt erstellen");
		lblCreateProjet
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		concreteCreateProjectPanel.add(lblCreateProjet);
		lblCreateProjet.setSize("200px", "16px");

		btnCreateProject = new Button("New button");
		btnCreateProject.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				saveEvent.fire(CreateProjectView.this, new EventArgs());
			}
		});
		btnCreateProject.setText("Projekt erstellen");
		concreteCreateProjectPanel.add(btnCreateProject, 33, 162);

		Label lblBezeichnung = new Label("Bezeichnung:");
		concreteCreateProjectPanel.add(lblBezeichnung, 10, 58);

		txtBoxBezeichnung = new TextBox();
		concreteCreateProjectPanel.add(txtBoxBezeichnung, 10, 80);
	}

	@Override
	public void addSaveProjectHandler(EventHandler<EventArgs> args) {
		saveEvent.add(args);
	}

	@Override
	public String getProjectName() {
		return txtBoxBezeichnung.getText();
	}
	
	@Override
	public void setProjectName(String name) {
		txtBoxBezeichnung.setText(name);
	}
}
