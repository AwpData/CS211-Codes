// Name: Trevor Tang
// Course: CS 211
// Date: October 22, 2019
// Reason: Generic list interface implemented into ArrayListPlus with must have methods

// Generic List interface for ArrayListPlus

public interface List<E> {
	public void add(E value);

	public void add(int index, E value);

	public E get(int index);

	public int indexOf(E value);

	public boolean isEmpty();

	public void remove(int index);

	public void set(int index, E value);

	public int size();
}
