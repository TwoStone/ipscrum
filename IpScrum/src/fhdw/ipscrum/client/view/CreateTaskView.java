package fhdw.ipscrum.client.view;

import java.util.Vector;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;

import fhdw.ipscrum.client.events.Event;
import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.view.interfaces.ICreateTaskView;
import fhdw.ipscrum.shared.constants.TextConstants;
import fhdw.ipscrum.shared.model.interfaces.IPerson;

public class CreateTaskView extends Composite implements ICreateTaskView {
	
	//####### Events ###############
	private final Event<EventArgs> saveNewTaskEvent = new Event<EventArgs>();
	private final Event<EventArgs> cancelNewTaskEvent = new Event<EventArgs>();
	//##### Ende ##################
	
	private Button btnOK;
	private ListBox comboBox;
	private AbsolutePanel contentPanel;
	private Button btnAbort;
	private TextBox textBox;
	public CreateTaskView() {
		
		contentPanel = new AbsolutePanel();
		initWidget(contentPanel);
		contentPanel.setSize("331px", "174px");
		
		btnOK = new Button("O.K.");
		btnOK.setText("O.K.");
		contentPanel.add(btnOK, 10, 125);
		btnOK.setSize("100px", "28px");
		
		btnAbort = new Button("Abbrechen");
		contentPanel.add(btnAbort, 221, 136);
		btnAbort.setSize("100px", "28px");
		btnAbort.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				CreateTaskView.this.cancelNewTaskEvent.fire(CreateTaskView.this, new EventArgs());
			}
		});
		
		Label lblTaskname = new Label("Task-Name:");
		contentPanel.add(lblTaskname, 10, 40);
		
		textBox = new TextBox();
		contentPanel.add(textBox, 86, 40);
		
		Label lblBearbeitendePerson = new Label("Bearbeitende Person:");
		contentPanel.add(lblBearbeitendePerson, 10, 80);
		
		comboBox = new ListBox();
		contentPanel.add(comboBox, 141, 74);
		comboBox.setSize("160px", "22px");
	}
	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.ICreateTaskView#getBtnOK()
	 */
	@Override
	public Button getBtnOK() {
		return btnOK;
	}
	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.ICreateTaskView#getComboBox()
	 */
	@Override
	public ListBox getComboBox() {
		return comboBox;
	}
	
	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.ICreateTaskView#getBtnAbort()
	 */
	@Override
	public Button getBtnAbort() {
		return btnAbort;
	}
	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.ICreateTaskView#getTextBox()
	 */
	@Override
	public TextBox getTextBox() {
		return textBox;
	}
	
	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.ICreateTaskView#refreshNameBox(java.util.Vector)
	 */
	@Override
	public void refreshNameBox(Vector<IPerson> persons){
		for(int i = 0; i < persons.size(); i++){	
		this.getComboBox().addItem(persons.get(i).getFirstname() + TextConstants.SPACE + persons.get(i).getLastname());
		}		}
	
	@Override
	public void addSaveNewTaskEventHandler(EventHandler<EventArgs> arg) {
		saveNewTaskEvent.add(arg);
	}
	
	@Override
	public void addCancelNewTaskEventHandler(EventHandler<EventArgs> arg) {
		cancelNewTaskEvent.add(arg);
	}
}
