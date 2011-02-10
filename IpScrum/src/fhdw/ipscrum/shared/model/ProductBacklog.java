package fhdw.ipscrum.shared.model;

import java.util.Vector;

public class ProductBacklog {
// TODO: Gruppe 1: Product Backlog extends fhdw.ipscrum.shared.observer.Observable
	private Vector<ProductBacklogItem> items;
	private Project project;

	/**
	 * Es muss direkt nach der Erzeugung der Setter f�r Projekt gesetzt
	 * werden.
	 */
	public ProductBacklog() {
		super();
	}
	
	public Vector<ProductBacklogItem> getItems() {
		if(this.items==null){
			this.items = new Vector<ProductBacklogItem>();
		}
		return items;
	}
	
	public void moveTop(ProductBacklogItem item){
		this.getItems().remove(item);
		this.getItems().insertElementAt(item, 0);
	}

	public void moveBottom(ProductBacklogItem item){
		this.getItems().remove(item);
		this.getItems().insertElementAt(item, this.countItems());
	}
	
	public void moveUp(ProductBacklogItem item){
		Integer position = this.getItemPositionInList(item);
		if(position>0){
			this.getItems().remove(item);
			this.getItems().insertElementAt(item, position-1);
		}
	}

	public void moveDown(ProductBacklogItem item){
		Integer position = this.getItemPositionInList(item);
		if(position>-1 && position<(this.countItems()-1)){
			this.getItems().remove(item);
			this.getItems().insertElementAt(item, position+1);
		}
	}
	
	public void addItemAfter(ProductBacklogItem newItem, ProductBacklogItem itemBefore){
		Integer position = this.getItemPositionInList(itemBefore);
		if(position>-1 && position<(this.countItems()-1)){
			this.getItems().insertElementAt(newItem, position+1);
		}else{
			this.addItem(newItem);
		}
	}

	public void addItemBefore(ProductBacklogItem newItem, ProductBacklogItem itemAfter){
		Integer position = this.getItemPositionInList(itemAfter);
		if(position>=0){
			if(position==0){
				this.addItemOnTop(newItem);
			}else{
				this.getItems().insertElementAt(newItem, position-1);
			}
		}else{
			this.addItem(newItem);
		}
	}

	public void addItemOnTop(ProductBacklogItem item){
		this.getItems().insertElementAt(item, 0);
	}
	
	/**
	 * Adds the item at the end of the list.
	 * @param item to be add
	 */
	public void addItem(ProductBacklogItem item){
		this.getItems().add(item);
	}
	
	public void removeItem(ProductBacklogItem item){
		this.getItems().remove(item);
	}
	
	public Integer countItems(){
		return this.getItems().size();
	}

	public Project getProject() {
		return project;
	}
	
	/**
	 * Initialisiert nur einmalig!
	 * @param project
	 */
	public void setProject(Project project) {
		if(this.project==null){
			this.project = project;
		}
	}
	
	@Override
	public String toString() {
		return "ProductBacklog [items=" + items + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.getItems() == null) ? 0 : this.getItems().hashCode());
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
	 * Returns the position of the ProductBacklogItem within
	 * the list.
	 * @param item
	 * @return
	 * Values between 0 ... n are valid positions
	 * Value -1 means that the element is not in the list;
	 */
	public Integer getItemPositionInList(ProductBacklogItem item){
		int count = 0;
		for(ProductBacklogItem current : this.getItems()){
			if(current.equals(item)){
				return count;
			}
			count++;
		}
		
		return -1;
	}
}
