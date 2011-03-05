package fhdw.ipscrum.client.view;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;

import fhdw.ipscrum.client.events.Event;
import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.view.interfaces.ICreateTaskView;

public class CreateTaskView extends Composite implements ICreateTaskView {
	
	//####### Events ###############
	private final Event<EventArgs> saveNewTaskEvent = new Event<EventArgs>();
	private final Event<EventArgs> cancelNewTaskEvent = new Event<EventArgs>();
	//##### Ende ##################
	
	private Button btnOK;
	private AbsolutePanel contentPanel;
	private Button btnAbort;
	private TextBox textBox;
	private TextArea textArea;
	public CreateTaskView() {
		
		contentPanel = new AbsolutePanel();
		initWidget(contentPanel);
		contentPanel.setSize("251px", "267px");
		
		btnOK = new Button("Anlegen");
		contentPanel.add(btnOK, 10, 230);
		btnOK.setSize("100px", "28px");
		btnOK.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				CreateTaskView.this.saveNewTaskEvent.fire(CreateTaskView.this, new EventArgs());
			}
		});
		
		btnAbort = new Button("Abbrechen");
		contentPanel.add(btnAbort, 141, 230);
		btnAbort.setSize("100px", "28px");
		btnAbort.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				CreateTaskView.this.cancelNewTaskEvent.fire(CreateTaskView.this, new EventArgs());
			}
		});
		
		Label lblTaskname = new Label("Task-Name:");
		contentPanel.add(lblTaskname, 10, 10);
		
		textBox = new TextBox();
		contentPanel.add(textBox, 86, 10);
		textBox.setSize("147px", "16px");
		
		Label lblDescription = new Label("Beschreibung");
		contentPanel.add(lblDescription, 10, 51);
		
		textArea = new TextArea();
		contentPanel.add(textArea, 10, 73);
		textArea.setSize("223px", "143px");
	}

	private TextBox getTextBox() {
		return textBox;
	}
	
	@Override
	public void addSaveNewTaskEventHandler(EventHandler<EventArgs> arg) {
		saveNewTaskEvent.add(arg);
	}
	
	@Override
	public void addCancelNewTaskEventHandler(EventHandler<EventArgs> arg) {
		cancelNewTaskEvent.add(arg);
	}
	private TextArea getTextArea() {
		return textArea;
	}
	
	@Override
	public String getName() {
		return	this.getTextBox().getValue();
	}
	@Override
	public String getDescription() {
	return this.getTextArea().getValue();
	}
}
