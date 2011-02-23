package fhdw.ipscrum.shared.model.visitor;


/**
 *	Marker interface for implementing the tree-visitor.
 *	@see fhdw.ipscrum.shared.model.visitor.ITreeConstructionVisitor
 */
public interface ITreeVisitorRelevantElement {

	public void accept(ITreeConstructionVisitor treeVisitor);

}
