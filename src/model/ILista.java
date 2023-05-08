package model;

public interface ILista {
	public boolean contains(int dado);
	public int size();
	public void add(int dado);
	public int get(int pos) throws Exception;
	public boolean isEmpty();
	public void removeFirst() throws Exception;
	public void removeLast() throws Exception;
	public void remove(int pos) throws Exception;
	void addLast(int valor) throws Exception;
	void add(int valor, int pos) throws Exception;
	void addFirst(int valor);

}
