import java.util.NoSuchElementException;

public class DLinkedList<T> {
    protected Node<T> head;
    protected Node<T> tail;
    protected long size;

    public DLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Verifica o tamanho da lista
     *
     * @return o tamanho da lista
     */
    public long size() {
        return size;
    }

    /**
     * Verifica se a lista está vazia
     *
     * @return true se estiver vazia. Caso contrário, false
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Remove todos os elementos da lista
     */
    public void clear() {
        size = 0;
        head = null;
        tail = null;
    }

    /**
     * Retorna o primeiro elemento da lista
     *
     * @return O primeiro elemento da lista
     * @throws NoSuchElementException Se a lista estiver vazia
     */
    public T getFirst() {
        if (isEmpty()) throw new NoSuchElementException("DLinkedList is empty");
        return head.getValue();
    }

    /**
     * Retorna o último elemento da lista.
     *
     * @return O último elemento da lista
     * @throws NoSuchElementException Se a lista estiver vazia
     */
    public T getLast() {
        if (isEmpty()) throw new NoSuchElementException("DLinkedList is empty");
        return tail.getValue();
    }
    /**
     * Adiciona um elemento na cabeça da lista
     * @param value
     */
    public void addFirst(T value) {
        Node<T> first = new Node<T>();
        first.setValue
                (value);
        first.setNext
                (head);
        if
        (head == null) {
            tail = first;
        }
        head = first;
        size++;
    }
    /**
     * Adiciona um elemento na cauda da lista
     * @param value
     */
    public void addLast(T value) {
        if(head == null) { // Ainda não possui head
            addFirst(value);
        }else {
            Node<T> last = new Node<T>();
            last.setValue(value);
            tail.setNext(last);
            tail = last;
            size++;
        }
    }
    /** complexidade?
     * Remove e retorna o primeiro elemento da lista
     * @return value
     * @throws NoSuchElementException Se a lista estiver vazia
     */
    public T removeFirst() {
        if(isEmpty()) throw new NoSuchElementException("DLinkedList is empty");
        T value = head.getValue();
        head = head.getNext();
        size--;
        return value;
    }
    /**
     * Remove e retorna o último elemento da lista
     * @return value
     * @throws NoSuchElementException Se a lista estiver vazia
     */
    public T removeLast() {
        if(isEmpty()) throw new NoSuchElementException("DLinkedList is empty");
        T value = tail.getValue();
        Node<T> temp = head;
// Verifica se possui o próximo elemento
// E verifica se o próximo elemento nao é a cauda
        while(temp.getNext() != null && temp.getNext() != tail) {
            temp = temp.getNext();
        }
        temp.setNext(null);
// Penultimo elemento, se torna o ultimo elemento
        tail = temp;
        tail.setNext(null); // ultimo elemento aponta para nulo
        size--;
        return value;
    }
    /**
     * Verifica se a lista contém o valor
     * @param value
     * @return true se o elemento estiver na lista. caso contrário, false
     */
    public boolean contains(T value) {
        Node<T> temp = head;
        while(temp != null) {
            if(temp.getValue().equals(value)) {
                return true;
            }
            temp = temp.getNext();
        }
        return false;
    }
    /**
     * Retorna uma lista de objetos com todos os elementos da lista
     * @return
     */
    public Object[] toArray() {
        Object[] array = new Object[(int) size];
        Node<T> temp = head;
        for(int i = 0; i < size; i++) {
            array[i] = temp.getValue();
            temp = temp.getNext();
        }
        return array;
    }

}