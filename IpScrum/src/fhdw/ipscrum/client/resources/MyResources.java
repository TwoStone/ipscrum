package fhdw.ipscrum.client.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.ImageResource.ImageOptions;

import fhdw.ipscrum.client.resources.css.Architecture;
import fhdw.ipscrum.client.resources.css.LoadingDialog;
import fhdw.ipscrum.client.resources.css.Login;
import fhdw.ipscrum.client.resources.css.Navigation;
import fhdw.ipscrum.client.resources.css.QuestionWidget;
import fhdw.ipscrum.client.resources.css.Toast;
import fhdw.ipscrum.shared.constants.TextConstants;

/**
 * Represents a container of all images used in the IPScrum.
 */
public interface MyResources extends ClientBundle {
	/**
	 * Represents the instance of the MyResources.
	 */
	MyResources INSTANCE = GWT.create(MyResources.class);

	/**
	 * @return the add icon.
	 */
	@Source("images/Add-32.png")
	ImageResource featureIcon();

	/**
	 * @return the bottom arrow icon.
	 */
	@Source("images/bottomarrow.png")
	ImageResource bottomarrow();

	/**
	 * @return the burndown icon.
	 */
	@Source("images/burndown.png")
	ImageResource burndown();

	/**
	 * @return the delete icon.
	 */
	@Source("images/delete.png")
	ImageResource delete();

	/**
	 * @return the details icon.
	 */
	@Source("images/details.png")
	ImageResource details();

	/**
	 * @return the down arrow icon.
	 */
	@Source("images/downarrow.png")
	ImageResource downarrow();

	/**
	 * @return the fhdw logo as an image.
	 */
	@Source("images/fhdw-logo.PNG")
	ImageResource fhdwLogo();

	/**
	 * @return the help icon.
	 */
	@Source("images/icon_hilfe.gif")
	ImageResource iconHilfe();

	/**
	 * @return the bug icon.
	 */
	@Source("images/ladybug_32.png")
	ImageResource bugIcon();

	/**
	 * @return the lock icon.
	 */
	@Source("images/Lock-32.png")
	ImageResource lockIcon();

	/**
	 * @return the small logo of the IPScrum.
	 */
	@Source("images/logoSmall.png")
	ImageResource logoSmall();

	/**
	 * @return the new file icon.
	 */
	@Source("images/newfile.png")
	ImageResource newfile();

	/**
	 * @return the save icon.
	 */
	@Source("images/save.png")
	ImageResource save();

	/**
	 * @return the search icon.
	 */
	@Source("images/Search-32.png")
	ImageResource searchIcon();

	/**
	 * @return the top arrow icon.
	 */
	@Source("images/toparrow.png")
	ImageResource toparrow();

	/**
	 * @return the unlock icon.
	 */
	@Source("images/Unlock-32.png")
	ImageResource unlockIcon();

	/**
	 * @return the up arrow icon.
	 */
	@Source("images/uparrow.png")
	ImageResource uparrow();

	/**
	 * @return the product icon.
	 */
	@Source("images/product_32.png")
	ImageResource product();

	/**
	 * @return the image of the closed toast in active mode.
	 */
	@Source("images/closeToast.png")
	ImageResource closeToastActive();

	/**
	 * @return the image of the closed toast in inactive mode.
	 */
	@Source("images/closeToast_gray.png")
	ImageResource closeToastInactive();

	/**
	 * @return the .css for the architecture.
	 */
	@Source("fhdw/ipscrum/client/resources/css/architecture.css")
	@CssResource.NotStrict
	Architecture architecture();

	/**
	 * @return the .css for the login.
	 */
	@Source("fhdw/ipscrum/client/resources/css/login.css")
	@CssResource.NotStrict
	Login login();

	/**
	 * @return the .css for the navigation.
	 */
	@Source("fhdw/ipscrum/client/resources/css/navigation.css")
	@CssResource.NotStrict
	Navigation navigation();

	/**
	 * @return the .css for the questionWidget.
	 */
	@Source("fhdw/ipscrum/client/resources/css/questionWidget.css")
	@CssResource.NotStrict
	QuestionWidget questionWidget();

	/**
	 * @return the .css for the toast.
	 */
	@Source("fhdw/ipscrum/client/resources/css/toast.css")
	@CssResource.NotStrict
	Toast toast();

	/**
	 * @return the .css for the loadingDialog.
	 */
	@Source("fhdw/ipscrum/client/resources/css/loadingDialog.css")
	@CssResource.NotStrict
	LoadingDialog loadingDialog();

	/**
	 * @return the icon for the user.
	 */
	@ImageOptions(height = TextConstants.THIRTYTWO, width = TextConstants.THIRTYTWO)
	@Source("fhdw/ipscrum/client/resources/images/User.png")
	ImageResource user();

}
