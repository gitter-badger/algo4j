package org.ice1000.bit;

import org.ice1000.error.BinaryIndexedTreeException;

/**
 * Created by ice1000 on 2016/11/15.
 *
 * @author ice1000
 */
@SuppressWarnings("WeakerAccess")
public final class IntervalUpdatePointQuery extends BinaryIndexedTree {

	public IntervalUpdatePointQuery(int length) {
		super(length);
	}

	/**
	 * O(n) = 2 * log(n)
	 * update all values in [begin, end]
	 * begin >= 1, end <= length
	 *
	 * @param begin left bound of [begin, end], >= 1
	 * @param end   right bound of [begin, end] <= length
	 * @param value every element in [begin, end] will 'plus assign' value.
	 */
	public void update(int begin, int end, int value) {
		if (end < begin) throw new BinaryIndexedTreeException("end should be smaller than begin!");
		add(begin, value);
		add(end + 1, -value);
	}

	/**
	 * O(n) = log(n)
	 * query the value at one position.
	 *
	 * @param index position
	 * @return value
	 */
	public long query(int index) {
		return sum(index);
	}
}
