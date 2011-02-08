package fhdw.ipscrum.client.view;

import java.util.Vector;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;

import fhdw.ipscrum.client.view.interfaces.IReleaseView;
import fhdw.ipscrum.shared.model.Release;

public class ReleaseView extends Composite implements IReleaseView{
	private Image imgNewFile;
	private Image imgDetails;
	private Image imgDelete;
	private CellTable<Release> tableRelease;
	public ReleaseView() {
		
		FlowPanel verticalPanel = new FlowPanel();
		initWidget(verticalPanel);
		verticalPanel.setSize("500", "300");
		
		FlowPanel ReleaseMenuPanel = new FlowPanel();
		verticalPanel.add(ReleaseMenuPanel);
		ReleaseMenuPanel.setSize("500", "25");
		
		imgNewFile = new Image("images/newfile.png");
		ReleaseMenuPanel.add(imgNewFile);
		
		imgDetails = new Image("images/details.png");
		ReleaseMenuPanel.add(imgDetails);
		
		imgDelete = new Image("images/delete.png");
		ReleaseMenuPanel.add(imgDelete);
		
		tableRelease = new CellTable<Release>();
		
		TextColumn<Release> release = new TextColumn<Release>() {
			@Override
			public String getValue(Release object) {
				return object.toString();
			}
		};
		tableRelease.addColumn(release, "Release");
		verticalPanel.add(tableRelease);
		tableRelease.setSize("480", "250px");
	}

	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.IReleaseView#getImgNewFile()
	 */
	@Override
	public HasClickHandlers getImgNewFile() {
		return imgNewFile;
	}
	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.IReleaseView#getImgDetails()
	 */
	@Override
	public HasClickHandlers getImgDetails() {
		return imgDetails;
	}
	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.IReleaseView#getImgDelete()
	 */
	@Override
	public HasClickHandlers getImgDelete() {
		return imgDelete;
	}
	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.IReleaseView#getReleaseTable()
	 */
	@Override
	public CellTable<Release> getReleaseTable() {
		return tableRelease;
	}
	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.IReleaseView#getSelectedRelease()
	 */
	@Override
	public CellTable<Release> getSelectedRelease(){
		return tableRelease;
	}
	
	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.IReleaseView#refreshProjects(java.util.Vector)
	 */
	@Override
	public void refreshProjects(Vector<Release> Release) {
		this.getReleaseTable().setRowData(Release);
	}
}
