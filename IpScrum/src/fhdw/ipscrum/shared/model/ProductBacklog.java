package fhdw.ipscrum.shared.model;

import java.util.Vector;

public class ProductBacklog {

	private Vector<ProductBacklogItem> items;

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
		//TODO
	}

	public void moveDown(ProductBacklogItem item){
		//TODO
	}
	
	public void addItemAfter(ProductBacklogItem newItem, ProductBacklogItem itemBefore){
		//TODO
	}

	public void addItemBefore(ProductBacklogItem newItem, ProductBacklogItem itemAfter){
		//TODO
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

	@Override
	public String toString() {
		return "ProductBacklog [items=" + items + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((items == null) ? 0 : items.hashCode());
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
		if (items == null) {
			if (other.items != null)
				return false;
		} else if (!items.equals(other.items))
			return false;
		return true;
	}
}
