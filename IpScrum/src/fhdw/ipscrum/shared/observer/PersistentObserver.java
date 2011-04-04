package fhdw.ipscrum.shared.observer;

import java.io.Serializable;

/**
 * <p>
 * A class can implement the Observer interface when it wants to be informed of
 * changes in observable objects.
 * </p>
 */
public interface PersistentObserver extends Serializable, Observer {
}