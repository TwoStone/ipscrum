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
	private final Event<EventArgs> cancelCreateProjectEvent = new Event<EventArgs>();
	// ####### Ende ######

	private Button btnCreateProject;
	private TextBox txtBoxBezeichnung;
	
	public static IView createView() {
		return new CreateProjectView();
	}

	public CreateProjectView() {

		AbsolutePanel concreteCreateProjectPanel = new AbsolutePanel();
		initWidget(concreteCreateProjectPanel);
		concreteCreateProjectPanel.setSize("285px", "129px");

		Label lblCreateProjet = new Label("Neues Projekt erstellen");
		lblCreateProjet.setStyleName("LabelElement");
		lblCreateProjet
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		concreteCreateProjectPanel.add(lblCreateProjet, 10, 2);
		lblCreateProjet.setSize("177px", "38px");

		btnCreateProject = new Button("New button");
		btnCreateProject.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				saveEvent.fire(CreateProjectView.this, new EventArgs());
			}
		});
		btnCreateProject.setText("Projekt erstellen");
		btnCreateProject.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				cancelCreateProjectEvent.fire(CreateProjectView.this, new EventArgs());
				
			}
		});
		concreteCreateProjectPanel.add(btnCreateProject, 10, 93);

		Label lblBezeichnung = new Label("Bezeichnung:");
		lblBezeichnung.setStyleName("LabelElement");
		concreteCreateProjectPanel.add(lblBezeichnung, 10, 40);

		txtBoxBezeichnung = new TextBox();
		concreteCreateProjectPanel.add(txtBoxBezeichnung, 10, 62);
		
		Button btnCancel = new Button("New button");
		btnCancel.setText("Verwerfen");
		concreteCreateProjectPanel.add(btnCancel, 173, 93);
		btnCancel.setSize("100px", "28px");
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

	@Override
	public void addCancelCreateProjectHandler(EventHandler<EventArgs> args) {
		cancelCreateProjectEvent.add(args);
		
	}
}
