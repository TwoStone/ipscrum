package fhdw.ipscrum.server.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * Stores T in a pipeline, so that an active object can get / put T from / on it asynchronously.
 * 
 * @param <T>
 *            Type of the element
 * 
 */
public class Pipeline<T> {

	/**
	 * represents the elements in the pipeline with they're types.
	 */
	private final List<T> elements;
	/**
	 * represents the mutex of the pipeline.
	 */
	private final Semaphore mutex = new Semaphore(1);
	/**
	 * represents the empty semaphire.
	 */
	private final Semaphore empty = new Semaphore(0);

	/**
	 * constructor of the pipeline.
	 */
	public Pipeline() {
		this.elements = new ArrayList<T>();
	}

	/**
	 * stores a new element into the pipeline and notifies waiting threads.
	 * 
	 * @param e
	 *            element to put in the pipeline
	 * @throws InterruptedException
	 *             if the put is interrupted
	 */
	public void put(final T e) throws InterruptedException {
		this.mutex.acquire();
		this.elements.add(e);
		System.out.println("Pipeline: got new input!");
		this.empty.release();
		this.mutex.release();
	}

	/**
	 * removes an element from the pipeline and returns the removed instance to the caller. If the pipeline is empty,
	 * the entering thread has to wait for new entries.
	 * 
	 * @return the element from the pipeline
	 * @throws InterruptedException
	 *             if the getter is interrupted
	 */
	public T get() throws InterruptedException {
		this.empty.acquire();
		this.mutex.acquire();
		final T result = this.elements.get(0);
		this.elements.remove(0);
		System.out.println("Pipeline: item removed!");
		this.mutex.release();
		return result;
	}
}
