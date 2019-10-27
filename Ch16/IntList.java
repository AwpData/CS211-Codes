/* Name: Trevor Tang
 * Course: CS 211
 * Date: October 27, 2019
 * Reason: Given interface that was implemented in LinkedIntList.java
 */

/*
 * This is the interface definition for the IntList data type
 */

public interface IntList {
	public int size();

	public int get(int index);

	public String toString();

	public int indexOf(int value);

	public void add(int value);

	public void add(int index, int value);

	public void remove(int index);
}
