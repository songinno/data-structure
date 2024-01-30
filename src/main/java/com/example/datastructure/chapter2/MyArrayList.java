package com.example.datastructure.chapter2;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class MyArrayList<E> implements List<E> {
    int size; // 요소의 개수 추적
    private E[] array; // 요소 저장

    public MyArrayList() {
        array = (E[]) new Object[10];
        size = 0;
    }

    // 리스트에 요소를 추가하는 메서드
    @Override
    public boolean add(E element) {
        if (size >= array.length) {
            // 더 큰 배열을 만들고 요소들을 복사
            E[] bigger = (E[]) new Object[array.length * 2];
            System.arraycopy(array, 0, bigger, 0, array.length);
            array = bigger;
        }
        array[size] = element;
        size++;
        return true;
    }

    // add(int index, E element) : 지정한 index에 요소를 추가
    @Override
    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        // add the element to get the resizing
        add(element);

        // shift the elements
        for (int i = size-1; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = element;
        /*
        * < 세팅 >
        * [a, b, c], index=1, element="d" => 기댓값: [a,d,b,c]
        *
        * < 값 >
        * i = 4 - 1 = 3
        * i > 1
        *
        * < 반복문 시작 >
        * 0) [a,b,c,d]
        * 1) array[3] = array[2] => [a,b,d,c]
        * 2) array[2] = array[1] => [a,d,b,c]
        * */
    }

    // get 메서드
    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    // set 메서드 : List 내 특정 요소 변경
    // List.set(변경할 요소의 인덱스, 변경할 값)
    @Override
    public E set(int index, E element) {
        if (!(element instanceof E)) {
            throw new ClassCastException();
        }

        if (element == null) {
            throw new NullPointerException();
        }

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        E old = get(index);

        array[index] = element;
        return old;
    }

    // indexOf()
    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals((E) o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public E remove(int index) {
        E element = get(index);
        for (int i = index; i < size-1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        System.out.println("current size: " + getSize());
        array[size] = null;
        return element;
    }

    // 현재 요소 개수 반환
    public int getSize() {
        return this.size;
    }

    // 배열 출력
    public void printArray() {
        System.out.print("[");
        Stream<E> stream = Arrays.stream(array);
        stream.forEach(e -> System.out.print(e + ", "));
        System.out.println("]");
    }

    public static void main(String[] args) {
        MyArrayList<Integer> mal = new MyArrayList<>();
        mal.add(1);
        mal.add(2);
        mal.add(3);
        mal.add(1, 999);
        mal.printArray();

        int result = mal.indexOf(3);
        System.out.println("indexOf(): " + result);
        System.out.println("remove");
        Integer removed = mal.remove(1);
        System.out.println("removed number: " + removed.intValue());
        mal.printArray();
    }

    ////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void replaceAll(UnaryOperator<E> operator) {
        List.super.replaceAll(operator);
    }

    @Override
    public void sort(Comparator<? super E> c) {
        List.super.sort(c);
    }

    @Override
    public Spliterator<E> spliterator() {
        return List.super.spliterator();
    }

    @Override
    public <T> T[] toArray(IntFunction<T[]> generator) {
        return List.super.toArray(generator);
    }

    @Override
    public boolean removeIf(Predicate<? super E> filter) {
        return List.super.removeIf(filter);
    }

    @Override
    public Stream<E> stream() {
        return List.super.stream();
    }

    @Override
    public Stream<E> parallelStream() {
        return List.super.parallelStream();
    }

    @Override
    public void forEach(Consumer<? super E> action) {
        List.super.forEach(action);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }
}
