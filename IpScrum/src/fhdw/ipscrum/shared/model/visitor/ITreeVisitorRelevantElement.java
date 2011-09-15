package fhdw.ipscrum.shared.model.visitor;

/**
 * Marker interface for implementing the tree-visitor.
 * 
 * @see fhdw.ipscrum.shared.model.visitor.ITreeConstructionVisitor
 */
public interface ITreeVisitorRelevantElement {

	/**
	 * Needed to use the TreeConstructionVisitor.
	 * 
	 * @param treeVisitor
	 *            used Visitor
	 */
	void accept(ITreeConstructionVisitor treeVisitor);

}
