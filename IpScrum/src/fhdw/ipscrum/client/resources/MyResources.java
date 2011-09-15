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

public interface MyResources extends ClientBundle {
	MyResources INSTANCE = GWT.create(MyResources.class);

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

	@Source("images/product_32.png")
	ImageResource product();

	@Source("images/closeToast.png")
	ImageResource closeToast_active();

	@Source("images/closeToast_gray.png")
	ImageResource closeToast_inactive();

	@Source("fhdw/ipscrum/client/resources/css/architecture.css")
	@CssResource.NotStrict
	Architecture architecture();

	@Source("fhdw/ipscrum/client/resources/css/login.css")
	@CssResource.NotStrict
	Login login();

	@Source("fhdw/ipscrum/client/resources/css/navigation.css")
	@CssResource.NotStrict
	Navigation navigation();

	@Source("fhdw/ipscrum/client/resources/css/questionWidget.css")
	@CssResource.NotStrict
	QuestionWidget questionWidget();

	@Source("fhdw/ipscrum/client/resources/css/toast.css")
	@CssResource.NotStrict
	Toast toast();

	@Source("fhdw/ipscrum/client/resources/css/loadingDialog.css")
	@CssResource.NotStrict
	LoadingDialog loadingDialog();

	@ImageOptions(height = 32, width = 32)
	@Source("fhdw/ipscrum/client/resources/images/User.png")
	ImageResource user();

}
