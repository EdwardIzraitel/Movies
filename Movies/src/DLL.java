
public class DLL {
	private static class Node<Movie> {
		private Movie movie;
		private Node<Movie> next;
		private Node<Movie> prev;

		public Node(Movie name, Node<Movie> nxt, Node<Movie> prv) {
			movie = name;
			next = nxt;
			prev = prv;
		}

		public Movie getElement() {
			return movie;
		}

		public Node<Movie> getPrev() {
			return prev;
		}

		public Node<Movie> getNext() {
			return next;
		}

		public void setPrev(Node<Movie> p) {
			prev = p;
		}

		public void setNext(Node<Movie> n) {
			next = n;
		}
	}

	private Node<Movie> head;
	private Node<Movie> tail;
	private int size = 0;

	public DLL() {
		head = new Node(null, null, null);
		tail = new Node(null, head, null);
		head.setNext(tail);
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int getSize() {
		return size;
	}

	public Movie first() {
		if (isEmpty()) {
			return null;
		}
		head.getElement().addCount();
		return head.getElement();
	}

	public Movie last() {
		if (isEmpty()) {
			return null;
		}
		tail.getElement().addCount();
		return tail.getElement();
	}

	public void addFirst(Movie e) {
		Node<Movie> newest = new Node<Movie>(e, head, null);
		if (head.getElement()!=null) {
			head.setPrev(newest);			
		}
		head = newest;
		size++;
	}

	public void addLast(Movie e) {
		Node<Movie> newest = new Node<Movie>(e, null, tail);
		if (tail.getElement()!=null) {
			tail.setNext(newest);			
		}
		tail = newest;
		size++;
	}

	public Movie removeFirst() {
		if (isEmpty()) {
			return null;
		}
		Node<Movie> temp= head;
		head=head.getNext();
		head.setPrev(null);
		size--;
		return temp.getElement();
	}

	public Movie removeLast() {
		if (isEmpty()) {
			return null;
		}
		Node<Movie> temp = tail;
		tail = tail.getPrev();
		tail.setNext(null);
		size--;
		return temp.getElement();
	}
	// searches and increments
	public boolean search(String e) {
		Node<Movie> current = head;
		while (current.getElement() != null) {
			if (current.getElement().element().equals(e)) {
				current.getElement().addCount();
				return true;
			}
			current = current.getNext();
		}

		return false;
	}

	// makes the string that we're looking for the head
	// with the correct count for it.
	public boolean makeHead(String s) {
		if (head.getElement().element().equals(s)) {
			head.getElement().addCount();
			return true;
		}
		Node<Movie> current = head;
		Node<Movie> prv = null;

		while (current.getElement() != null && !current.getElement().element().equals(s)) {
			prv = current;
			current = current.next;
		}
		if (current.getElement() != null) {
			int count = current.getElement().accessCount() + 1;
			prv.setNext(current.getNext());
			Movie newest = new Movie(s, count);
			addFirst(newest);
			size--;
			return true;
		}
		return false;
	}

	// removes m
	public String remove(Movie m) {
		if (head.getElement().equals(m)) {
			head = head.getNext();
			size--;
			return m.element();
		}
		Node<Movie> current = head;
		Node<Movie> prev = null;
		while (current.getElement() != null && !current.getElement().equals(m)) {
			prev = current;
			current = current.getNext();
		}
		if (current.getElement() != null) {
			prev.setNext(current.getNext());
			size--;
			return m.element();
		}
		return null;
	}
}
