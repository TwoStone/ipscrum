package fhdw.ipscrum.shared.model;

import java.util.Vector;

import fhdw.ipscrum.shared.exceptions.ConsistencyException;
import fhdw.ipscrum.shared.observer.Observable;

/**
 * Represents the ProductBacklog of a project. It manages the
 * ProductBacklogItems.
 */
public class ProductBacklog extends Observable {
	private Vector<ProductBacklogItem> items;
	private final Project project;

	/**
	 * <b>It's not allowed</b> to create an PBL object out of the model because
	 * each project will create its own PBL.
	 * You will get inconsistency if you run this constructor!
	 * 
	 * @param project
	 * Reverse association to the project!
	 */
	protected ProductBacklog(Project project) {
		super();
		this.project = project;
	}

	/**
	 * Returns all ProductBacklogItems of the this Backlog. <br />
	 * <b>Attention</b><br />
	 * For adding and removing Items to/from the list please use the methods of
	 * the Backlog. Else we cannot guarantee the consistency!
	 */
	public Vector<ProductBacklogItem> getItems() {
		if (this.items == null) {
			this.items = new Vector<ProductBacklogItem>();
		}
		return items;
	}

	/**
	 * TODO Kommentar
	 * 
	 * @param item
	 */
	public void moveTop(ProductBacklogItem item) {
		this.getItems().remove(item);
		this.getItems().insertElementAt(item, 0);
		this.notifyObservers();
	}

	/**
	 * TODO Kommentar
	 * 
	 * @param item
	 */
	public void moveBottom(ProductBacklogItem item) {
		this.getItems().remove(item);
		this.getItems().insertElementAt(item, this.countItems());
		this.notifyObservers();
	}

	/**
	 * TODO Kommentar
	 * 
	 * @param item
	 */
	public void moveUp(ProductBacklogItem item) {
		Integer position = this.getItemPositionInList(item);
		if (position > 0) {
			this.getItems().remove(item);
			this.getItems().insertElementAt(item, position - 1);
			this.notifyObservers();
		}
	}

	/**
	 * TODO Kommentar
	 * 
	 * @param item
	 */
	public void moveDown(ProductBacklogItem item) {
		Integer position = this.getItemPositionInList(item);
		if (position > -1 && position < (this.countItems() - 1)) {
			this.getItems().remove(item);
			this.getItems().insertElementAt(item, position + 1);
			this.notifyObservers();
		}
	}



	/**
	 * Adds the item at the end of the list.
	 * 
	 * @param item to be add
	 */
	public void addItem(ProductBacklogItem item) throws ConsistencyException{
		if (!this.isItemInList(item)) {
			if(item.getBacklog()==this){
				this.getItems().add(item);
				this.notifyObservers();
			}else{
				//TODO Textkonstante bauen
				throw new ConsistencyException("Das PBI kann dem Backlog nicht hinzugef�gt werden, " +
						"da es bereits einem anderen Backlog geh�rt");
			}
		}
	}

	/**
	 * TODO Kommentar
	 * 
	 * @param item
	 */
	public void removeItem(ProductBacklogItem item) {
		this.getItems().remove(item);
		this.notifyObservers();
	}

	/**
	 * TODO Kommentar
	 * 
	 * @return
	 */
	public Integer countItems() {
		return this.getItems().size();
	}

	public Project getProject() {
		return project;
	}

	@Override
	public String toString() {
		return "ProductBacklog [items=" + items + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((this.getItems() == null) ? 0 : this.getItems().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductBacklog other = (ProductBacklog) obj;
		if (this.getItems() == null) {
			if (other.getItems() != null)
				return false;
		} else if (!this.getItems().equals(other.getItems()))
			return false;
		return true;
	}

	/**
	 * Returns the position of the ProductBacklogItem within the list.
	 * 
	 * @param item
	 * @return Values between 0 ... n are valid positions Value -1 means that
	 *         the element is not in the list;
	 */
	public Integer getItemPositionInList(ProductBacklogItem item) {
		int count = 0;
		for (ProductBacklogItem current : this.getItems()) {
			if (current.equals(item)) {
				return count;
			}
			count++;
		}

		return -1;
	}

	/**
	 * TODO Kommentar
	 * 
	 * @param item
	 * @return
	 */
	private boolean isItemInList(ProductBacklogItem item) {
		for (ProductBacklogItem current : this.items) {
			if (current.equals(item)) {
				return true;
			}
		}
		return false;
	}
}
