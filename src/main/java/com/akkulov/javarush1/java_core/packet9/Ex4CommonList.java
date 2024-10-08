package com.akkulov.javarush1.java_core.packet9;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * https://javarush.com/quests/lectures/questcore.level07.lecture10; Общий список
 */
public class Ex4CommonList implements List<Long> {

  private final ArrayList<Long> original = new ArrayList<>();

  public static void main(String[] args) {

  }

  @Override
  public int size() {
    synchronized (original) {
      return original.size();
    }
  }

  @Override
  public boolean isEmpty() {
    synchronized (original) {
      return original.isEmpty();
    }
  }

  @Override
  public boolean contains(Object o) {
    synchronized (original) {
      return original.contains(o);
    }
  }

  @Override
  public Iterator<Long> iterator() {
    synchronized (original) {
      return original.iterator();
    }
  }

  @Override
  public Object[] toArray() {
    synchronized (original) {
      return original.toArray();
    }
  }

  @Override
  public <T> T[] toArray(T[] a) {
    synchronized (original) {
      return original.toArray(a);
    }
  }

  @Override
  public boolean add(Long aLong) {
    synchronized (original) {
      return original.add(aLong);
    }
  }

  @Override
  public boolean remove(Object o) {
    synchronized (original) {
      return original.remove(o);
    }
  }

  @Override
  public boolean containsAll(Collection<?> c) {
    synchronized (original) {
      return original.containsAll(c);
    }
  }

  @Override
  public boolean addAll(Collection<? extends Long> c) {
    synchronized (original) {
      return original.addAll(c);
    }
  }

  @Override
  public boolean addAll(int index, Collection<? extends Long> c) {
    synchronized (original) {
      return original.addAll(index, c);
    }
  }

  @Override
  public boolean removeAll(Collection<?> c) {
    synchronized (original) {
      return original.removeAll(c);
    }
  }

  @Override
  public boolean retainAll(Collection<?> c) {
    synchronized (original) {
      return original.retainAll(c);
    }
  }

  @Override
  public void clear() {
    synchronized (original) {
      original.clear();
    }
  }

  @Override
  public Long get(int index) {
    synchronized (original) {
      return original.get(index);
    }
  }

  @Override
  public Long set(int index, Long element) {
    synchronized (original) {
      return original.set(index, element);
    }
  }

  @Override
  public void add(int index, Long element) {
    synchronized (original) {
      original.add(index, element);
    }
  }

  @Override
  public Long remove(int index) {
    synchronized (original) {
      return original.remove(index);
    }
  }

  @Override
  public int indexOf(Object o) {
    synchronized (original) {
      return original.indexOf(o);
    }
  }

  @Override
  public int lastIndexOf(Object o) {
    synchronized (original) {
      return original.lastIndexOf(o);
    }
  }

  @Override
  public ListIterator<Long> listIterator() {
    synchronized (original) {
      return original.listIterator();
    }
  }

  @Override
  public ListIterator<Long> listIterator(int index) {
    synchronized (original) {
      return original.listIterator(index);
    }
  }

  @Override
  public List<Long> subList(int fromIndex, int toIndex) {
    synchronized (original) {
      return original.subList(fromIndex, toIndex);
    }
  }
}
