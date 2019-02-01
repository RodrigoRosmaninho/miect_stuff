package aula11.ex1;

public class VetorDinamico<T> {
	private T[] array;
	private int size;
	
	@SuppressWarnings("unchecked")
	public VetorDinamico() {
		array = (T[]) new Object[0];
		size = 0;
	}
	
	@SuppressWarnings("unchecked")
	public void add(T t) {
		T[] tmp = (T[]) new Object[size + 1];
		System.arraycopy(array, 0, tmp, 0, size);
		tmp[size] = t;
		array = tmp;
		size++;
	}
	
	public T get(int i) {
		return array[i];
	}
	
	public int size() {
		return size;
	}
	
	public void check_index(int i) throws Exception{
		if(i < 0 || i >= size) throw new Exception("IndexOutOfArrayBounds. This index does nnot exist!");
	}
	
	public boolean contains(T t) {
		for(T element : array) if(element.equals(t)) return true;
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public T[] array(T[] tmp) {
		System.arraycopy(array, 0, tmp, 0, size);
		return tmp;
	}
	
	@SuppressWarnings("unchecked")
	public T remove(int index) {
		T[] tmp = (T[]) new Object[size - 1];
		T obj = null;
		int k = 0;
		for(int i = 0; i < size; i++) {
			if(i != index) tmp[k++] = array[i];
			else obj = array[i];
		}
		array = tmp;
		size--;
		return obj;
	}
	
	@SuppressWarnings("unchecked")
	public boolean remove(T t) {
		T[] tmp = (T[]) new Object[size - 1];
		int k = 0;
		boolean existed = false;
		for(T element : array) {
			if(!t.equals(element)) tmp[k++] = element;
			else existed = true;
		}
		array = tmp;
		size--;
		return existed;
	}
}
