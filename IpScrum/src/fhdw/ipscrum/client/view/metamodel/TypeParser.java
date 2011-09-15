package fhdw.ipscrum.client.view.metamodel;

public interface TypeParser<T, I> {
	T parse(I value);
}
