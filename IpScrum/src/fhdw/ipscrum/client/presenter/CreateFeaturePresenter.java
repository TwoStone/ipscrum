package fhdw.ipscrum.client.presenter;

import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.utils.GwtUtils;
import fhdw.ipscrum.client.view.CreateFeatureView;
import fhdw.ipscrum.client.view.interfaces.ICreateFeatureView;
import fhdw.ipscrum.shared.exceptions.DoubleDefinitionException;
import fhdw.ipscrum.shared.exceptions.NoFeatureSelectedException;
import fhdw.ipscrum.shared.exceptions.NoValidValueException;
import fhdw.ipscrum.shared.model.Feature;
import fhdw.ipscrum.shared.model.ProductBacklog;
import fhdw.ipscrum.shared.observer.Observer;

/**
 * @author Niklas
 * @version $Revision: 1.0 $
 */
public class CreateFeaturePresenter extends
		FeaturePresenter<ICreateFeatureView> implements Observer {

	/**
	 * Method createNewFeature.
	 * 
	 * @param backlog
	 *            ProductBacklog
	 * 
	 * 
	 * @return Feature
	 */
	private static Feature createNewFeature(final ProductBacklog backlog){
		try {
			//TODO Das geht so nicht, da bei der Erzeugung geprüft wird, ob ein
			//Feature mit diesem Namen bereits exisitiert! Wenn hier eine
			//selsamer Name angegeben wird, funktioniert die prüfung nicht!
			return new Feature(NEWFTRNAME, "", backlog);
		} catch (final NoValidValueException e) {
			GwtUtils.displayError(e.getMessage());
		} catch (final DoubleDefinitionException e){
			GwtUtils.displayError(e.getMessage());
		}
		return null;
	}

	/**
	 * Creates a new instance of {@link CreateFeaturePresenter} with an empty
	 * feature.
	 * 
	 * @param parent
	 * @param backlog
	 * @throws NoFeatureSelectedException
	 */
	public CreateFeaturePresenter(final Panel parent,
			final ProductBacklog backlog) throws NoFeatureSelectedException {
		super(parent, createNewFeature(backlog));
	}

	/**
	 * Method createView.
	 * 
	 * 
	 * @return ICreateFeatureView
	 */
	@Override
	protected ICreateFeatureView createView() {
		return new CreateFeatureView();
	}

}
