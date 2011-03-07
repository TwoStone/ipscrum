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
import fhdw.ipscrum.shared.constants.TextConstants;

import com.google.gwt.user.client.ui.IntegerBox;

/**
 * This class represents a view for creating a new task
 * 
 * @author Phase III / Group I
 * 
 */
public class CreateTaskView extends Composite implements ICreateTaskView {

	// ####### Events ###############
	private final Event<EventArgs> saveNewTaskEvent = new Event<EventArgs>();
	private final Event<EventArgs> cancelNewTaskEvent = new Event<EventArgs>();
	// ##### Ende ##################

	// ########### View Elements ############
	private Button btnOK;
	private AbsolutePanel contentPanel;
	private Button btnAbort;
	private TextBox textBox;
	private TextArea textArea;
	private IntegerBox iBoxEffort;
	// ########## Ende View Elements ############

	
	public CreateTaskView() {

		contentPanel = new AbsolutePanel();
		initWidget(contentPanel);
		contentPanel.setSize("251px", "333px");

		btnOK = new Button(TextConstants.CREATE);
		contentPanel.add(btnOK, 10, 295);
		btnOK.setSize("100px", "28px");

		// fireing saveNewTaskEvent
		btnOK.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				CreateTaskView.this.saveNewTaskEvent.fire(CreateTaskView.this,
						new EventArgs());
			}
		});

		btnAbort = new Button(TextConstants.ABORT);
		contentPanel.add(btnAbort, 141, 295);
		btnAbort.setSize("100px", "28px");

		// fireing cancelNewTaskEvent
		btnAbort.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				CreateTaskView.this.cancelNewTaskEvent.fire(
						CreateTaskView.this, new EventArgs());
			}
		});

		Label lblTaskname = new Label(TextConstants.TASK_NAME);
		contentPanel.add(lblTaskname, 10, 10);

		textBox = new TextBox();
		contentPanel.add(textBox, 86, 10);
		textBox.setSize("147px", "16px");

		Label lblDescription = new Label(TextConstants.DESCRIPTION);
		contentPanel.add(lblDescription, 10, 51);

		textArea = new TextArea();
		contentPanel.add(textArea, 10, 73);
		textArea.setSize("223px", "143px");

		Label lblAufwandpersonenstunden = new Label(
				TextConstants.TIME_AND_EFFORT);
		contentPanel.add(lblAufwandpersonenstunden, 10, 238);

		iBoxEffort = new IntegerBox();
		contentPanel.add(iBoxEffort, 10, 260);
	}

	// ### SETTER / GETTER methods ####
	// Private cause only using in this class
	// Presenters are using the methods from interface ITaskboardView
	private TextBox getTextBox() {
		return textBox;
	}

	private IntegerBox getIBoxEffort() {
		return iBoxEffort;
	}

	private TextArea getTextArea() {
		return textArea;
	}

	// ####### Here are coming the methods from ITaskboardView
	@Override
	public void addSaveNewTaskEventHandler(EventHandler<EventArgs> arg) {
		saveNewTaskEvent.add(arg);
	}

	@Override
	public void addCancelNewTaskEventHandler(EventHandler<EventArgs> arg) {
		cancelNewTaskEvent.add(arg);
	}

	@Override
	public String getName() {
		return this.getTextBox().getValue();
	}

	@Override
	public String getDescription() {
		return this.getTextArea().getValue();
	}

	@Override
	public Integer getEffort() {
		return this.getIBoxEffort().getValue();
	}

}
