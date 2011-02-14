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
import fhdw.ipscrum.shared.constants.TextConstants;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

/**
 * This class is used to create the {@link ProjectView}.
 * 
 * @author Phase II / Gruppe I
 */
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

		Label lblCreateProjet = new Label(TextConstants.NEW_PROJECT);
		lblCreateProjet.setStyleName(TextConstants.LABELELEMENT);
		lblCreateProjet
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		concreteCreateProjectPanel.add(lblCreateProjet, 10, 2);
		lblCreateProjet.setSize("219px", "38px");

		btnCreateProject = new Button(TextConstants.NEW_BUTTON);
		btnCreateProject.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				saveEvent.fire(CreateProjectView.this, new EventArgs());
			}
		});
		btnCreateProject.setText(TextConstants.CREATE_PROJECT);
	
		concreteCreateProjectPanel.add(btnCreateProject, 10, 93);
		btnCreateProject.setSize("148px", "28px");

		Label lblBezeichnung = new Label(TextConstants.PROJECT_TEXT);
		concreteCreateProjectPanel.add(lblBezeichnung, 10, 40);

		txtBoxBezeichnung = new TextBox();
		concreteCreateProjectPanel.add(txtBoxBezeichnung, 10, 62);
		
		Button btnCancel = new Button(TextConstants.NEW_BUTTON);
		btnCancel.setText(TextConstants.ABORT);
		
		btnCancel.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				cancelCreateProjectEvent.fire(CreateProjectView.this, new EventArgs());
				
			}
		});
		
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
