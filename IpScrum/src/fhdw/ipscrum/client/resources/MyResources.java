package fhdw.ipscrum.client.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

public interface MyResources extends ClientBundle {
	public static final MyResources INSTANCE = GWT.create(MyResources.class);

	@Source("images/Add-32.png")
	ImageResource featureIcon();

	@Source("images/bottomarrow.png")
	ImageResource bottomarrow();

	@Source("images/burndown.png")
	ImageResource burndown();

	@Source("images/delete.png")
	ImageResource delete();

	@Source("images/details.png")
	ImageResource details();

	@Source("images/downarrow.png")
	ImageResource downarrow();

	@Source("images/fhdw-logo.PNG")
	ImageResource fhdwLogo();

	@Source("images/icon_hilfe.gif")
	ImageResource icon_hilfe();

	@Source("images/ladybug_32.png")
	ImageResource bugIcon();

	@Source("images/Lock-32.png")
	ImageResource lockIcon();

	@Source("images/logoSmall.png")
	ImageResource logoSmall();

	@Source("images/newfile.png")
	ImageResource newfile();

	@Source("images/save.png")
	ImageResource save();

	@Source("images/Search-32.png")
	ImageResource searchIcon();

	@Source("images/toparrow.png")
	ImageResource toparrow();

	@Source("images/Unlock-32.png")
	ImageResource unlockIcon();

	@Source("images/uparrow.png")
	ImageResource uparrow();

}
