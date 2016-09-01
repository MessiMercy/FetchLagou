package com.duplicate;

import java.util.HashSet;
import java.util.Set;

public class DuplicateRemover {
	private Set<Integer> items = new HashSet<>();

	public Set<Integer> getItem() {
		return items;
	}

	public void clear() {
		this.items.clear();
	}

	public int getSize() {
		return items.size();
	}

	public boolean isDuplicate(Integer id) {
		return !items.add(id);
	}
}
