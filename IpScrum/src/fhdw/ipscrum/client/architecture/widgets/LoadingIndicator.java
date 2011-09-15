package fhdw.ipscrum.client.architecture.widgets;

import com.google.gwt.user.client.ui.PopupPanel;

import fhdw.ipscrum.client.resources.MyResources;

/**
 * represents the visualization of the loading process.
 */
public class LoadingIndicator extends PopupPanel {

	static {
		MyResources.INSTANCE.loadingDialog().ensureInjected();
	}

	/**
	 * constructor of the LoadingIndicator.
	 */
	public LoadingIndicator() {
		super(false);
		this.setStyleName(MyResources.INSTANCE.loadingDialog().loadingDialog());
		this.setModal(true);
		this.setPreviewingAllNativeEvents(true);
		this.setGlassEnabled(true);
	}
}
