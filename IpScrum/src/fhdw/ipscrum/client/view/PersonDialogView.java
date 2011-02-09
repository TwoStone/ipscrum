package fhdw.ipscrum.client.view;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Button;

import fhdw.ipscrum.client.view.interfaces.IPersonDialogView;


public class PersonDialogView extends Composite implements IPersonDialogView {

	private Button abb_button;
	private VerticalPanel verticalPanel;
	private VerticalPanel topPanel;
	private VerticalPanel vNamePanel;
	private Label lblVorname;
	private TextBox vorname;
	private VerticalPanel nNamePanel;
	private Label lblNachname;
	private TextBox nachname;
	private VerticalPanel bottomPanel;
	private HorizontalPanel buttonPanel;
	private Button ok_button;

	public PersonDialogView() {
		
		verticalPanel = new VerticalPanel();
		initWidget(verticalPanel);
		verticalPanel.setSize("320px", "170px");
		
		topPanel = new VerticalPanel();
		verticalPanel.add(topPanel);
		topPanel.setSize("320px", "100px");
		
		vNamePanel = new VerticalPanel();
		topPanel.add(vNamePanel);
		vNamePanel.setSize("185px", "50px");
		
		lblVorname = new Label("Vorname");
		vNamePanel.add(lblVorname);
		
		vorname = new TextBox();
		vNamePanel.add(vorname);
		
		nNamePanel = new VerticalPanel();
		topPanel.add(nNamePanel);
		nNamePanel.setSize("185px", "50px");
		
		lblNachname = new Label("Nachname");
		nNamePanel.add(lblNachname);
		
		nachname = new TextBox();
		nNamePanel.add(nachname);
		
		bottomPanel = new VerticalPanel();
		bottomPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		bottomPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_BOTTOM);
		verticalPanel.add(bottomPanel);
		bottomPanel.setSize("320px", "70px");
		
		buttonPanel = new HorizontalPanel();
		buttonPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_BOTTOM);
		buttonPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		bottomPanel.add(buttonPanel);
		buttonPanel.setSize("219px", "36px");
		
		ok_button = new Button("New button");
		ok_button.setText("OK");
		buttonPanel.add(ok_button);
		ok_button.setSize("100px", "28px");
		
		abb_button = new Button("New button");
		abb_button.setText("Abberchen");
		buttonPanel.add(abb_button);
		abb_button.setSize("100px", "28px");
	}

	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.IPersonDialogView#getAbb_button()
	 */
	@Override
	public HasClickHandlers getAbb_button() {
		return abb_button;
	}

	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.IPersonDialogView#getVorname()
	 */
	@Override
	public HasText getVorname() {
		return vorname;
	}

	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.IPersonDialogView#getNachname()
	 */
	@Override
	public HasText getNachname() {
		return nachname;
	}

	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.IPersonDialogView#getOk_button()
	 */
	@Override
	public HasClickHandlers getOk_button() {
		return ok_button;
	}
	
	
}
