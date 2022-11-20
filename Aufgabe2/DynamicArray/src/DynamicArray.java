public class DynamicArray {
    // Data-Members
    private static final int binBlockSize = 1;
    private int binLevel;
    private int binCapacity;
    private DummyData[] dataBin;

    // Methods
    public DynamicArray() {
        binLevel    = 0;
        binCapacity = binBlockSize;
        dataBin     = new DummyData[binCapacity];
    }

    public int search(DummyData key)          // search for data key in the array
    {
        // Aus Vorlesung
        int li = 0;
        int re = binLevel-1;

        while (re >= li) {
            int mid = (li+re) / 2;
            if (key == a[mid]) {
                return mid;
            } else if (key < a[mid]) {
                re = mid - 1;
            } else {
                li = mid+1;
            }
            return  -1;
        }

    }

    public boolean insert(DummyData x, int i)   // insert data x at position i to array; yields true, if successful
    {
        //Aus Vorlesung



//        // check position --------------------------------------------------------------------------
//        if (i<0||i> binLevel) return false;     // invalid position yields return-value false
//        // check capacity --------------------------------------------------------------------------
//        if (binLevel >= binCapacity) enlarge();    // no free space left in the array
//        // insert new data --------------------------------------------------------------------------
//        for (int j = binLevel; j > i; j--) dataBin[j] = dataBin[j-1];   // move data in array one position up
//        dataBin[i] = x;                                                 // write data x to array at position i
//        binLevel++;                                                     // increase level
//        return true;
    }

    public boolean remove(DummyData d)  // remove data d from array; yields true, if successful
    {
        // check data --------------------------------------------------------------------------
        int i = search(d);
        if (i<0) return false;          // data not contained in the array, yields return-value false
        // check capacity ---------------------------------------------------------------------
        if (binLevel < binCapacity- binBlockSize) shrink();             // waste in array too large
        // remove data ------------------------------------------------------------------------
        for (int j = i; j< binLevel-1; j++) dataBin[j] = dataBin[j+1];  // advance data one position
        binLevel--;                                                     // decrease level
        return true;
    }

    private void enlarge()
    {
        DummyData[] newBin = new DummyData[binCapacity+ binBlockSize];  // allocate larger array
        for (int j = 0; j < binCapacity; j++) newBin[j] = dataBin[j];   // copy old data to new array
        dataBin   = newBin;                                             // assign new array to data-member
        binCapacity += binBlockSize;                                    // increase capacity
    }

    private void shrink()
    {
        if ( binCapacity<=binBlockSize ) return;                          // do nothing, if too small
        DummyData[] newBin = new DummyData[binCapacity- binBlockSize];  // allocate smaller array
        for (int j = 0; j < binLevel; j++) newBin[j] = dataBin[j];      // copy old data to new array
        dataBin   = newBin;                                             // assign new array to data-member
        binCapacity -= binBlockSize;                                    // decrease capacity
    }


}
