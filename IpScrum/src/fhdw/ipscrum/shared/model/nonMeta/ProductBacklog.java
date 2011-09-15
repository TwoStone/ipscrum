package fhdw.ipscrum.shared.model.nonMeta;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import com.google.gwt.user.client.rpc.IsSerializable;

import fhdw.ipscrum.shared.constants.TextConstants;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.exceptions.model.ConsistencyException;
import fhdw.ipscrum.shared.exceptions.model.DoubleDefinitionException;
import fhdw.ipscrum.shared.exceptions.model.ForbiddenStateException;
import fhdw.ipscrum.shared.infrastructure.IdentifiableObject;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.messages.Message;
import fhdw.ipscrum.shared.model.messages.MessageStandardVisitor;
import fhdw.ipscrum.shared.model.messages.PBICompletionMessage;
import fhdw.ipscrum.shared.observer.Observable;
import fhdw.ipscrum.shared.observer.PersistentObserver;

/**
 * Represents the ProductBacklog of a project. It manages the ProductBacklogItems.
 */
public class ProductBacklog extends IdentifiableObject
		implements IsSerializable, PersistentObserver {

	/**
	 * Represents the serialVersionUID.
	 */
	private static final long serialVersionUID = -5276089275386947750L;

	/**
	 * associations to the pbis.
	 */
	private List<ProductBacklogItem> pbis;

	/**
	 * Bidirectional association to the project.
	 */
	private Project project;

	/**
	 * Default Constructor for GWT serialization.
	 */
	@SuppressWarnings("unused")
	private ProductBacklog() {
	}

	/**
	 * <b>It's not allowed</b> to create an PBL object out of the model because each
	 * project will create its own PBL. You will get inconsistency if you run this
	 * constructor!
	 * 
	 * @param model
	 *            : the ProductBacklog is inserted in the model
	 * @param project
	 *            Reverse association to the project!
	 */
	public ProductBacklog(final Model model, final Project project) {
		super(model);
		this.project = project;
		this.pbis = new ArrayList<ProductBacklogItem>();
		this.putToObjectStore();
	}

	/**
	 * Adds the given pbi at the end of the list.
	 * 
	 * @param item
	 *            For adding.
	 * @throws ConsistencyException
	 *             if the consistency is hurt
	 */
	public void addItem(final ProductBacklogItem item) throws ConsistencyException {
		if (item != null) {
			if (item.getBacklog() == null) {
				this.pbis.add(item);
				item.addObserver(this);
				this.notifyObservers();
				this.changed();
			} else if (item.getBacklog() == this) {
				this.pbis.add(item);
				item.addObserver(this);
				this.notifyObservers();
				this.changed();
			} else {
				// Needed because in this case a change is not alowed.
				throw new ConsistencyException(TextConstants.PBI_ERROR);
			}
		}
	}

	/**
	 * Returns the number of pbis within the product backlog.
	 * 
	 * @return the number items in the productBacklog
	 */
	public Integer countItems() {
		return this.getItems().size();
	}

	/**
	 * Returns the position of the ProductBacklogItem within the list.
	 * 
	 * @param item
	 *            selected in the ProductBacklog
	 * @return Values between 0 ... n are valid positions Value -1 means that the element
	 *         is not in the list;
	 */
	public Integer getItemPositionInList(final ProductBacklogItem item) {
		return this.getItems().indexOf(item);
	}

	/**
	 * Returns all ProductBacklogItems of the this Backlog. <br />
	 * <b>Attention</b><br />
	 * For adding and removing Items to/from the list please use the methods of the
	 * Backlog. Else we cannot guarantee the consistency!
	 * 
	 * @return the items of the ProductBacklog
	 */
	public List<ProductBacklogItem> getItems() {
		return this.pbis;
	}

	/**
	 * Return the releated project.
	 * 
	 * @return the project the ProductBacklog is related to
	 */
	public Project getProject() {
		return this.project;
	}

	/**
	 * Checks if an pbi with the given name already exist in the product backlog.
	 * 
	 * @param pbiName
	 *            Name of the PBI
	 * @throws DoubleDefinitionException
	 *             if a productbacklog with the same parameters already exists
	 */
	public void isDoubleDefined(final String pbiName) throws DoubleDefinitionException {
		for (final ProductBacklogItem current : this.getItems()) {
			if (current.getName().equals(pbiName)) {
				throw new DoubleDefinitionException(TextConstants.DOUBLE_DEFINITION_PBI);
			}
		}
	}

	/**
	 * Move the given pbi to the end of the list.
	 * 
	 * @param item
	 *            pbi for moving.
	 */
	public void moveBottom(final ProductBacklogItem item) {
		this.getItems().remove(item);
		this.getItems().add(item);
		this.notifyObservers();
		this.changed();
	}

	/**
	 * Move the given pbi one position in bottom direction of the list. Therefore another
	 * pbi will move one step up.
	 * 
	 * @param item
	 *            pbi for moving.
	 */
	public void moveDown(final ProductBacklogItem item) {
		final int oldIndex = this.pbis.indexOf(item);
		if (oldIndex != this.pbis.size() - 1) {
			this.pbis.remove(item);
			this.pbis.add(oldIndex + 1, item);
			this.changed();
		}
	}

	/**
	 * Move the given pbi to the top of the list.
	 * 
	 * @param item
	 *            pbi for moving.
	 */
	public void moveTop(final ProductBacklogItem item) {
		this.pbis.remove(item);
		this.pbis.add(0, item);
		this.notifyObservers();
		this.changed();
	}

	/**
	 * Move the given pbi one position in top direction of the list. Therefore another pbi
	 * will move one step down.
	 * 
	 * @param item
	 *            pbi for moving.
	 */
	public void moveUp(final ProductBacklogItem item) {
		final int oldIndex = this.pbis.indexOf(item);
		if (oldIndex > 0) {
			this.pbis.remove(item);
			this.pbis.add(oldIndex - 1, item);
			this.changed();
		}
	}

	/**
	 * Removes the given PBI from the product backlog and provides Consistency.
	 * 
	 * @param item
	 *            PBI which will be removed.
	 * @throws IPScrumGeneralException
	 *             if something fails
	 */
	public void removeItem(final ProductBacklogItem item)
			throws IPScrumGeneralException {
		this.removeFromDependentTasks(item); // Phase III
		item.setSprint(null); // Providing Consistency
		this.pbis.remove(item);
		item.deleteObserver(this);
		this.notifyObservers();
		this.changed();
	}

	/**
	 * removes item from tasks, which have a reference to the item. if dependent tasks are
	 * finished, the reference cannot be deleted and it will persist in the task as a
	 * string-value
	 * 
	 * @param item
	 *            item which shall be deleted
	 * @throws ConsistencyException
	 *             if the consistency is hurt
	 * @throws ForbiddenStateException
	 *             the task is in a forbidden state
	 */
	private void removeFromDependentTasks(final ProductBacklogItem item)
			throws ForbiddenStateException, ConsistencyException {
		Iterator<Sprint> sprintIterator = this.getProject().getSprints().iterator();
		final Vector<Sprint> mySprints = new Vector<Sprint>();
		while (sprintIterator.hasNext()) {
			final Sprint current = sprintIterator.next();
			if (current.hasPBI(item)) {
				mySprints.add(current);
			}
		}
		sprintIterator = mySprints.iterator();
		while (sprintIterator.hasNext()) {
			final Sprint current = sprintIterator.next();
			final SprintBacklog currentSprintBacklog = current.getSprintBacklog();
			if (currentSprintBacklog.hasPBI(item)) {
				currentSprintBacklog.removePBIFromTasks(item);
			}
		}
		this.changed();
	}

	@Override
	public String toString() {
		return TextConstants.PRODUCT_BACKLOG;
	}

	@Override
	public void update(final Observable observable, final Object argument) {
		if (!(argument instanceof Message)) {
			return;
		}
		((Message) argument).accept(new MessageStandardVisitor() {

			@Override
			public void handlePBICompletionMessage(final PBICompletionMessage message) {
				ProductBacklog.this.pbiUpdate(message);
			}

			@Override
			public void standardHandling() {
				// not interested in other messages
			}
		});

	}

	/**
	 * incident message that is thrown if a item is closed .
	 * 
	 * @param message
	 *            which item is closed at which time
	 */
	private void pbiUpdate(final PBICompletionMessage message) {
		this.notifyObservers(message);
	}
}
