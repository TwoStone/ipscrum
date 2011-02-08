package fhdw.ipscrum.client.view;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;

import fhdw.ipscrum.client.view.interfaces.ICreateProjectView;
import fhdw.ipscrum.client.view.interfaces.IView;

public class CreateProjectView extends Composite implements ICreateProjectView{
	private Button btnCreateProject;
	private TextBox txtBoxBezeichnung;
	
	public static IView createView(){
		return new CreateProjectView();
	}
	
	public CreateProjectView() {
		
		AbsolutePanel concreteCreateProjectPanel = new AbsolutePanel();
		initWidget(concreteCreateProjectPanel);
		concreteCreateProjectPanel.setSize("200px", "200px");
		
		Label lblCreateProjet = new Label("Neues Projekt erstellen");
		lblCreateProjet.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		concreteCreateProjectPanel.add(lblCreateProjet);
		lblCreateProjet.setSize("200px", "16px");
		
		btnCreateProject = new Button("New button");
		btnCreateProject.setText("Projekt erstellen");
		concreteCreateProjectPanel.add(btnCreateProject, 33, 162);
		
		Label lblBezeichnung = new Label("Bezeichnung:");
		concreteCreateProjectPanel.add(lblBezeichnung, 10, 58);
		
		txtBoxBezeichnung = new TextBox();
		concreteCreateProjectPanel.add(txtBoxBezeichnung, 10, 80);
	}
	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.ICreateProjectView#getBtnCreateProject()
	 */
	@Override
	public HasClickHandlers getBtnCreateProject() {
		return btnCreateProject;
	}
	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.ICreateProjectView#getTxtBoxBezeichnung()
	 */
	@Override
	public HasText getTxtBoxBezeichnung() {
		return txtBoxBezeichnung;
	}
}
