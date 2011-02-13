package fhdw.ipscrum.shared.model;

import java.util.Vector;

import fhdw.ipscrum.shared.bdas.BDACompare;
import fhdw.ipscrum.shared.bdas.BDAManyToMany;
import fhdw.ipscrum.shared.exceptions.ConsistencyException;
import fhdw.ipscrum.shared.exceptions.DoubleDefinitionException;
import fhdw.ipscrum.shared.exceptions.UserException;
import fhdw.ipscrum.shared.observer.Observable;

/**
 * Represents the ProductBacklog of a project. It manages the
 * ProductBacklogItems.
 */
public class ProductBacklog extends Observable implements BDACompare{

	private final ToPBIAssoc assoc;
	private final ToProjectAssoc projectAssoc;
	
	class ToPBIAssoc extends BDAManyToMany<ProductBacklogItem.ToBacklogAssoc, ProductBacklog>{
		public ToPBIAssoc(ProductBacklog element) {
			super(element);
		}
	}
	
	class ToProjectAssoc extends BDAManyToMany<Project.ToBacklogAssoc, ProductBacklog> {
		public ToProjectAssoc(ProductBacklog element) {
			super(element);
		}
	}
	
	protected ToPBIAssoc getAssoc() {
		return assoc;
	}
	
	protected ToProjectAssoc getProjectAssoc() {
		return projectAssoc;
	}

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
		this.projectAssoc = new ToProjectAssoc(this);
		this.assoc = new ToPBIAssoc(this);
	}
	
	public void isDoubleDefined(String pbiName) throws DoubleDefinitionException{
		for(ProductBacklogItem current : this.getItems()){
			if(current.getName()==pbiName){
				//TODO Textkonstante bauen!
				throw new DoubleDefinitionException("Ein PBI mit diesem Namen existiert bereits!");
			}
		}
	}

	/**
	 * Returns all ProductBacklogItems of the this Backlog. <br />
	 * <b>Attention</b><br />
	 * For adding and removing Items to/from the list please use the methods of
	 * the Backlog. Else we cannot guarantee the consistency!
	 */
	public Vector<ProductBacklogItem> getItems() {
		Vector<ProductBacklogItem> ret = new Vector<ProductBacklogItem>();
		for(ProductBacklogItem.ToBacklogAssoc current : this.getAssoc().getAssociations()){
			ret.add(current.getElement());
		}
		return ret;
	}

	/**
	 * TODO Kommentar
	 * 
	 * @param item
	 */
	public void moveTop(ProductBacklogItem item) {
		this.getAssoc().moveToTop(item.getBacklogAssoc());
		this.notifyObservers();
	}

	/**
	 * TODO Kommentar
	 * 
	 * @param item
	 */
	public void moveBottom(ProductBacklogItem item) {
		this.getAssoc().moveToBottom(item.getBacklogAssoc());
		this.notifyObservers();
	}

	/**
	 * TODO Kommentar
	 * 
	 * @param item
	 */
	public void moveUp(ProductBacklogItem item) {
		this.getAssoc().moveUp(item.getBacklogAssoc());
	}

	/**
	 * TODO Kommentar
	 * 
	 * @param item
	 */
	public void moveDown(ProductBacklogItem item) {
		this.getAssoc().moveDown(item.getBacklogAssoc());
	}

	/**
	 * Adds the item at the end of the list.
	 * 
	 * @param item to be add
	 */
	public void addItem(ProductBacklogItem item) throws ConsistencyException{
		if(item!=null){
			if(item.getBacklog()==this){
				this.getAssoc().add(item.getBacklogAssoc());
				this.notifyObservers();
			}else{
				throw new ConsistencyException("Das PBI kann dem Backlog nicht hinzugef�gt werden, " +
						"da es bereits einem anderen Backlog geh�rt");
			}
		}
	}

	public void removeItem(ProductBacklogItem item) throws UserException {
		item.setSprint(null);//Providing Consistency
		this.getAssoc().remove(item.getBacklogAssoc());
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
		if(this.getProjectAssoc().get()!=null){
			return this.getProjectAssoc().get().getElement();
		}else{
			return null;
		}
	}

	@Override
	public String toString() {
		return "ProductBacklog";
	}

	@Override
	public int indirectHashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result;
		return result;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((assoc == null) ? 0 : assoc.hashCode());
		result = prime * result + ((projectAssoc == null) ? 0 : projectAssoc.hashCode());
		return result;
	}

	@Override
	public boolean indirectEquals(Object obj) {
		return super.equals(obj);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!this.indirectEquals(obj)){
			return false;
		}else{
			ProductBacklog other = (ProductBacklog) obj;
			if (assoc == null) {
				if (other.assoc != null)
					return false;
			} else if (!assoc.equals(other.assoc))
				return false;
			if (projectAssoc == null) {
				if (other.projectAssoc != null)
					return false;
			} else if (!projectAssoc.equals(other.projectAssoc))
				return false;
			return true;
		}
	}

	/**
	 * Returns the position of the ProductBacklogItem within the list.
	 * 
	 * @param item
	 * @return Values between 0 ... n are valid positions Value -1 means that
	 *         the element is not in the list;
	 */
	public Integer getItemPositionInList(ProductBacklogItem item) {
		return this.getItems().indexOf(item);
	}

//	/**
//	 * TODO Kommentar
//	 * 
//	 * @param item
//	 * @return
//	 */
//	private boolean isItemInList(ProductBacklogItem item) {
//		for (ProductBacklogItem current : this.getItems()) {
//			if (current.equals(item)) {
//				return true;
//			}
//		}
//		return false;
//	}
}
