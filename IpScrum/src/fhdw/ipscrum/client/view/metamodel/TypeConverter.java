package fhdw.ipscrum.client.view.metamodel;

public interface TypeConverter<T, R> {

	T parse(R value);

	R render(T value);

}
