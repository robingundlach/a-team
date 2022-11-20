// ---------------------------------------------------------------
//
//  Beispiel in der Vorlesung "Algorithmen und Datenstrukturen (WIN+BIT)"
//  WS 2022/23
//
// (c) 2022, Georg Umlauf
//
// ---------------------------------------------------------------

public class DynamicArray {
    // Data-Members
    private static final int binBlockSize = 1;
    private int binLevel;
    private int binCapacity;        // could be replaced by dataBin.length, but it is clearer to have it explicit
    private DummyData[] dataBin;

    // Methods
    public DynamicArray() {
        binLevel    = 0;
        binCapacity = binBlockSize;
        dataBin     = new DummyData[binCapacity];
    }


    public int search(DummyData x)          // search for data x in the array
    {
        for (int i = 0; i< binLevel; i++)
            if (dataBin[i].equals(x)) return i;
        return -1;                          // return-value -1 signals, that the sought data is NOT in the array
    }

    public boolean insert(DummyData x, int i)   // insert data x at position i to array; yields true, if successful
    {
        // check position --------------------------------------------------------------------------
        if (i<0||i> binLevel) return false;     // invalid position yields return-value false
        // check capacity --------------------------------------------------------------------------
        if (binLevel >= binCapacity) grow();    // no free space left in the array
        // insert new data --------------------------------------------------------------------------
        for (int j = binLevel; j > i; j--) dataBin[j] = dataBin[j-1];   // move data in array one position up
        dataBin[i] = x;                                                 // write data x to array at position i
        binLevel++;                                                     // increase level
        return true;
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

//    public DummyData get(int i)                 // yields data at position i and null if position is invalid
//    {
//        // check position -----------------------------------------------------------------
//        if (i<0||i> binLevel) return null;      // invalid position
//        // get data -----------------------------------------------------------------------
//        return dataBin[i];
//    }
//
//    public boolean set(DummyData x, int i)      // change data x at position i to array; yields true, if successful
//    {
//        // check position -----------------------------------------------------------------
//        if (i<0||i> binLevel) return false;      // invalid position
//        // change data --------------------------------------------------------------------
//        dataBin[i] = x;
//        return true;
//    }

    private void grow()
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

//    public void print(){
//        System.out.println("Array ( "+binLevel+", "+binCapacity+"):");
//        for (int i=0; i<binLevel; i++) System.out.println(dataBin[i].getContent());
//    }

}
