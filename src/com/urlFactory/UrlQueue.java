package com.urlFactory;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

public class UrlQueue {
	private LinkedBlockingQueue<Integer> queue;
	private PriorityBlockingQueue<Integer> priorityQueue;

	public void test() {

	}

	public void put(int url, boolean isFailedUrl) {
		if (isFailedUrl) {
			priorityQueue.put(url);
		} else {
			try {
				queue.put(url);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public Integer take() {
		Integer result = null;
		if (priorityQueue.size() == 0) {
			try {
				result = queue.poll(60, TimeUnit.SECONDS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			try {
				result = priorityQueue.take();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public LinkedBlockingQueue<Integer> getQueue() {
		return queue;
	}

	public void setQueue(LinkedBlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	public PriorityBlockingQueue<Integer> getPriorityQueue() {
		return priorityQueue;
	}

	public void setPriorityQueue(PriorityBlockingQueue<Integer> priorityQueue) {
		this.priorityQueue = priorityQueue;
	}

}
