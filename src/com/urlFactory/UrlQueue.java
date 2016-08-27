package com.urlFactory;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

public class UrlQueue {
	private LinkedBlockingQueue<String> queue;
	private PriorityBlockingQueue<String> priorityQueue;

	public void test() {

	}

	public void put(String url, boolean isFailedUrl) {
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

	public String take() {
		String result = null;
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

	public LinkedBlockingQueue<String> getQueue() {
		return queue;
	}

	public void setQueue(LinkedBlockingQueue<String> queue) {
		this.queue = queue;
	}

	public PriorityBlockingQueue<String> getPriorityQueue() {
		return priorityQueue;
	}

	public void setPriorityQueue(PriorityBlockingQueue<String> priorityQueue) {
		this.priorityQueue = priorityQueue;
	}

}
