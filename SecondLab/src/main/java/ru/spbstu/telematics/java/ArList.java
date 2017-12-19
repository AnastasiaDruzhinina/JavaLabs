package ru.spbstu.telematics.java;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class ArList<T> implements Iterable<T>
{
    private int _maxSize;
    private int _size;
    private T[] _data;

    ArList()
    {
        _maxSize = 10;
        _size = 0;
        _data = (T[])new Object[_maxSize];
    }

    ArList(int initialCapacity)
    {
        if (initialCapacity < 0)
            throw new IllegalArgumentException();

        _maxSize = initialCapacity;
        _size = 0;
        _data = (T[])new Object[initialCapacity];
    }

    public
    int size()
    {
        return _size;
    }

    public
    boolean contains(Object o)
    {
        for (int i = 0; i < _size; i++)
        {
            if(o==null ? _data[i]==null : o.equals(_data[i]))
            {
                return true;
            }
        }

        return false;
    }

    public
    boolean add(T element)
    {
        if (_size + 1 == _maxSize)
            upCapacity();

        _data[_size] = element;
        _size++;

        return true;
    }

    public
    void add(int index, T element)
    {
        if (index < 0 || index > _size)
            throw new IndexOutOfBoundsException();

        if (_size + 1 == _maxSize)
            upCapacity();

        for (int i = _size; i > index; i--)
            _data[i] = _data[i-1];

        _data[index] = element;
        _size++;
    }

    T remove(int index)
    {
        if (index < 0 || index >= _size)
            throw new IndexOutOfBoundsException();

        T ret = _data[index];

        _size--;
        for (int i = index; i < _size; i++)
        {
            _data[i] = _data[i + 1];
        }

        if (_maxSize - _size > 10)
            downCapacity();

        return ret;
    }

    boolean remove(Object o)
    {
        int i = 0;
        while (!(o==null ? _data[i]==null : o.equals(_data[i])) && i < _size)
            i++;

        if (i < _size)
        {
            this.remove(i);
            return true;
        }

        return false;
    }

    T get(int index)
    {
        if (index < 0 || index >= _size)
            throw new IndexOutOfBoundsException();

        return _data[index];
    }

    void upCapacity()
    {
        int newMaxSize = _maxSize + 10;
        T[] data = (T[]) new Object[newMaxSize];
        System.arraycopy(_data, 0, data, 0, _size);

        _data = data;
        _maxSize = newMaxSize;
    }

    void downCapacity()
    {
        int newMaxSize = _maxSize - 5;
        T[] data = (T[]) new Object[newMaxSize];
        System.arraycopy(_data, 0, data, 0, _size);

        _data = data;
        _maxSize = newMaxSize;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null)
            return false;

        if (obj.getClass().getName().equals(this.getClass().getName()))
        {
            ArList<T> comp = (ArList<T>)obj;

            if (comp.size() != this.size())
                return false;

            for (int i = 0; i < _size; i++)
                if (!comp.get(i).equals(this.get(i)))
                    return false;

            return true;
        }

        if (obj.getClass().getName().equals(ArrayList.class.getName()))
        {
            ArrayList<T> comp = (ArrayList<T>)obj;

            if (comp.size() != this.size())
                return false;

            for (int i = 0; i < _size; i++)
                if (!comp.get(i).equals(this.get(i)))
                    return false;

            return true;
        }

        return false;
    }

    @Override
    public ListIterator<T> iterator()
    {
        return new ArListIterator<T>();
    }

    class ArListIterator<T> implements ListIterator<T>
    {
        private int _index;

        ArListIterator()
        {
            _index = -1;
        }

        @Override
        public void add(T t)
        {
            throw new UnsupportedOperationException();
        }

        @Override
        public void remove()
        {
            throw new UnsupportedOperationException();
        }

        @Override
        public void set(T t)
        {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean hasNext()
        {
            return _index + 1 < _size;
        }

        @Override
        public T next()
        {
            if (!hasNext())
                throw new NoSuchElementException();

            _index++;
            return (T) _data[_index];
        }

        @Override
        public boolean hasPrevious()
        {
            return _index > 0;
        }

        @Override
        public T previous()
        {
            if (!hasPrevious())
                throw new NoSuchElementException();

            _index--;
            return (T) _data[_index];
        }

        @Override
        public int nextIndex()
        {
            return (hasNext() ? _index + 1 : _size);
        }

        @Override
        public int previousIndex()
        {
            return (hasPrevious() ? _index: -1);
        }
    }
}
