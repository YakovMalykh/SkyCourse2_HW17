import Exceptions.NotFoundElement;
import Exceptions.PassingNullToParameterException;
import Exceptions.IntOutOfBoundException;

import java.util.Arrays;
import java.util.Objects;

public class IntListImpl implements IntList {

    private int[] arrayInt;
    private int size;

    public void setSize(int size) {
        this.size = size;
    }

    public IntListImpl(int size) {
        this.arrayInt = new int[size];
        this.size = size;
    }

    @Override
    public int[] getArrayInt() {
        return arrayInt;
    }

    @Override
    public int getSize() {
        return size();
    }


    private void sort(int[] arr) {
        SortMethods.quickSort(arr,0,arr.length-1);
    }

    public static boolean binarySearch(int[] arr, int el) {
        int min = 0;
        int max = arr.length - 1;
        while (min <= max) {
            int mid = (min + max) / 2;
            if (el == arr[mid]) {
                return true;
            }
            if (el < arr[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }


    private void checkIndex(int index) {
        if (index < 0 || index >= arrayInt.length) {
            throw new PassingNullToParameterException("в качестве параметра передано отрицательное " +
                    "число или индекс за пределами массива");
        }
    }

    private void grow() {
        int[] newArrayString = new int[(int) (size * 1.5 + 1)];
        for (int i = 0; i < arrayInt.length; i++) {
            if (arrayInt[i] != 0) {
                newArrayString[i] = arrayInt[i];
            }
        }
        size = size();
        arrayInt = newArrayString;
    }


    @Override//шаг2 из ДЗ реализовал в предыдущей домашней работе
    public int add(int item) {
        if (size == 0) {
            grow();
        }
        for (int i = 0; i < arrayInt.length; i++) {
            if (arrayInt[arrayInt.length - 1] != 0) {
                grow();
            } else if (arrayInt[i] == 0) {
                arrayInt[i] = item;
                return item;
            }
        }
        return -1;
    }

    @Override
    public int add(int index, int item) {
        if (size == 0) {
            grow();
        }
        checkIndex(index);
        if (arrayInt[index] == 0) {
            arrayInt[index] = item;
            return item;
        } else if (arrayInt[index] != 0) {
            grow();
            for (int i = arrayInt.length - 1; i > index; i--) {
                arrayInt[i] = arrayInt[i - 1];
//                }
            }
            arrayInt[index] = item;
            return item;
        }
        return 0;
    }

    @Override
    public int set(int index, int item) {
        checkIndex(index);
        arrayInt[index] = item;
        return arrayInt[index];
    }

    @Override
    //пришлось поменять название метода, т.к. перегрузить метод с таким же параметром нельзя
    public int removeValue(int item) {
        int index = indexOf(item);
        if (index < 0) {
            throw new NotFoundElement("такого элемента не существует");
        }
        return remove(index);
    }

    @Override
    public int remove(int index) {
        checkIndex(index);
        if (arrayInt[index] != 0) {
            int result = arrayInt[index];
            arrayInt[index] = 0;
            for (int i = index; i < arrayInt.length - 1; i++) {
                arrayInt[i] = arrayInt[i + 1];
            }
            arrayInt[arrayInt.length - 1] = 0;
            size = size;
            int[] newArray = new int[size];
            for (int j = 0; j < size; j++) {
                if (arrayInt[j] != 0) {
                    newArray[j] = arrayInt[j];
                }
            }
            arrayInt = newArray;
            return result;
        }
        throw new IntOutOfBoundException("элемент по индексу " + index + " пуст");
    }

    @Override
    public boolean contains(int item) {
        int[] result = Arrays.copyOf(arrayInt, arrayInt.length);
        sort(result);
        return binarySearch(result, item);
    }

    @Override
    public int indexOf(int item) {
        for (int i = 0; i < arrayInt.length; i++) {
            if (arrayInt[i] == item) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(int item) {
        for (int i = arrayInt.length - 1; i >= 0; i--) {
            if (arrayInt[i] == item) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int get(int index) {
        checkIndex(index);
        if (arrayInt[index] != 0) {
            return arrayInt[index];
        }
        throw new IntOutOfBoundException("элемент по индексу " + index + " пуст");
    }

    @Override
    public boolean equals(IntList otherList) {
        if (otherList == null) {
            throw new PassingNullToParameterException("в качестве параметра передан null");
        }
        if (size() == otherList.getSize()) {
            for (int i = 0; i < size(); i++) {
                if (arrayInt[i] != (otherList.getArrayInt()[i])) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        int counter = 0;
        for (int i = 0; i < arrayInt.length; i++) {
            if (arrayInt[i] != 0) {
                counter++;
            }
        }
        return counter;
    }

    @Override
    public boolean isEmpty() {
        for (int i = 0; i < arrayInt.length; i++) {
            if (arrayInt[i] != 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void clear() {
        for (int i = 0; i < arrayInt.length; i++) {
            arrayInt[i] = 0;
        }
        setSize(size());
    }

    @Override
    public int[] toArray() {
        int[] newArray = new int[arrayInt.length];
        for (int i = 0; i < arrayInt.length; i++) {
            newArray[i] = arrayInt[i];
        }
        return newArray;
    }

    @Override
    public String toString() {
        return "IntListImpl" +
                "arrayInt=" + Arrays.toString(arrayInt) +
                ", size=" + size() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntListImpl intList = (IntListImpl) o;
        return size == intList.size && Arrays.equals(arrayInt, intList.arrayInt);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(arrayInt);
        return result;
    }

}
