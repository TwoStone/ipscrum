package fhdw.ipscrum.client.architecture.events.eventbus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gwt.core.client.GWT;

/**
 * The eventbus class is a centralized hub for event forwarding. Other objects can publish
 * {@link Event} via the {@link EventBus#publish(Event)} method. Interested objects can
 * register {@link Handler} for event notification via the
 * {@link EventBus#registerHandler(Class, Handler)} method.
 * 
 */
public class EventBus {

	/**
	 * The {@link Event} class is the base class for Events handled by the eventbus.
	 */
	public abstract static class Event {

	}

	/**
	 * Base class for events that have exactly one argument.
	 * 
	 * @param <T>
	 *            Type of the argument
	 */
	public static class SingleObjectEvent<T> extends EventBus.Event {
		/**
		 * The object wrapped by this event.
		 */
		private final T object;

		/**
		 * Creates a new instance.
		 * 
		 * @param object
		 *            The object to be wrapped by the event.
		 */
		public SingleObjectEvent(final T object) {
			super();
			this.object = object;
		}

		/**
		 * Returns the wrapped object.
		 * 
		 * @return The wrapped object.
		 */
		public T getObject() {
			return this.object;
		}
	}

	/**
	 * Interface for Handler that can be registered at the eventbus.
	 * 
	 * @param <T>
	 */
	public static interface Handler<T extends EventBus.Event> {
		/**
		 * This operation handles incoming events.
		 * 
		 * @param event
		 *            Event that has been published at the event bus.
		 */
		void handle(final T event);
	}

	/**
	 * Registry that holds the mapping between EventTypes and Handlers.
	 */
	private final Map<Class<? extends EventBus.Event>, List<EventBus.Handler<? extends EventBus.Event>>> registrations;

	/**
	 * Creates a new {@link EventBus} instance.
	 */
	public EventBus() {
		this.registrations =
				new HashMap<Class<? extends EventBus.Event>, List<EventBus.Handler<? extends EventBus.Event>>>();
	}

	/**
	 * Registers a handler for the specific type of events.
	 * 
	 * @param clazz
	 *            Class literal of the event.
	 * @param handler
	 *            The handler to be registered.
	 * @param <T>
	 *            Type of the event.
	 */
	public <T extends EventBus.Event> void registerHandler(final Class<T> clazz,
			final Handler<T> handler) {
		if (!this.registrations.containsKey(clazz)) {
			this.registrations.put(clazz,
					new ArrayList<EventBus.Handler<? extends EventBus.Event>>());
		}

		this.registrations.get(clazz).add(handler);
	}

	/**
	 * Publishes an event at the event bus.
	 * 
	 * @param event
	 *            The event to be published.
	 * @param <T>
	 *            The type of the event object.
	 */
	@SuppressWarnings("unchecked")
	public <T extends EventBus.Event> void publish(final T event) {
		GWT.log("[EventBus] Publishing event " + event.getClass().getName());
		final Class<? extends EventBus.Event> clazz = event.getClass();
		if (this.registrations.containsKey(clazz)) {
			final List<EventBus.Handler<? extends EventBus.Event>> list =
					new ArrayList<EventBus.Handler<? extends EventBus.Event>>(
							this.registrations.get(clazz));
			for (final EventBus.Handler<? extends EventBus.Event> handler : list) {
				((EventBus.Handler<T>) handler).handle(event);
			}
		}
	}

	/**
	 * Removes a handler registration.
	 * 
	 * @param clazz
	 *            Type for that the handler was registered.
	 * @param handler
	 *            The handler that should be unregistered.
	 * @param <T>
	 *            Type of the event.
	 */
	public <T extends EventBus.Event> void remove(final Class<T> clazz,
			final Handler<T> handler) {
		if (this.registrations.containsKey(clazz)) {
			this.registrations.get(clazz).remove(handler);
		}
	}
}
