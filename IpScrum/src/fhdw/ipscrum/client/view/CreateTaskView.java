package fhdw.ipscrum.client.view;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;

import fhdw.ipscrum.client.events.Event;
import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.view.interfaces.ICreateTaskView;
import fhdw.ipscrum.shared.constants.TextConstants;

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
	private final Button btnOK;
	private final AbsolutePanel contentPanel;
	private final Button btnAbort;
	private final TextBox textBox;
	private final TextArea textArea;
	private final IntegerBox iBoxEffort;
	// ########## Ende View Elements ############


	public CreateTaskView() {

		contentPanel = new AbsolutePanel();
		initWidget(contentPanel);
		contentPanel.setSize("271px", "320px");

		btnOK = new Button(TextConstants.CREATE);
		btnOK.setStyleName("taskboardButton");
		contentPanel.add(btnOK, 10, 285);
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
		btnAbort.setStyleName("taskboardButton");
		contentPanel.add(btnAbort, 161, 285);
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
		lblTaskname.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		lblTaskname.setStyleName("taskboardLabel");
		contentPanel.add(lblTaskname, 10, 10);
		lblTaskname.setSize("90px", "16px");

		textBox = new TextBox();
		contentPanel.add(textBox, 116, 10);
		textBox.setSize("137px", "16px");

		Label lblDescription = new Label(TextConstants.DESCRIPTION);
		lblDescription.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		lblDescription.setStyleName("taskboardLabel");
		contentPanel.add(lblDescription, 10, 40);
		lblDescription.setSize("90px", "16px");

		textArea = new TextArea();
		contentPanel.add(textArea, 10, 70);
		textArea.setSize("243px", "143px");

		Label lblAufwandpersonenstunden = new Label(
				TextConstants.TIME_AND_EFFORT);
		lblAufwandpersonenstunden.setStyleName("taskboardLabel");
		contentPanel.add(lblAufwandpersonenstunden, 10, 227);

		iBoxEffort = new IntegerBox();
		contentPanel.add(iBoxEffort, 10, 257);
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
	public Integer getEffortInput() {
		return this.getIBoxEffort().getValue();
	}

}
