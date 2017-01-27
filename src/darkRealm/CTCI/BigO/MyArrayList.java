package darkRealm.CTCI.BigO;

/**
 * Created by Jayam on 9/30/2016.
 */
public class MyArrayList {
    int _limit;
    int[] _container;
    int _size;

    public MyArrayList(int n) {
        _limit = n;
        _container = new int[_limit];
    }

    public void add(int n) {
        if (_size == _limit) {
            //copy to new array
            expandAndCopy();
        }
        _container[_size++] = n;
    }

    private void expandAndCopy() {
        int[] temp = new int[_limit * 2];
        _limit = _limit * 2;
        System.arraycopy(_container, 0, temp, 0, _size);
        _container = temp;
    }
}
