public class DynamicArray {
    // Data-Members
    private static final int binBlockSize = 1;
    private int binLevel;
    private int binCapacity;
    private int [] dataBin;

    // Methods
    public DynamicArray() {
        this.binLevel    = 0;
        binCapacity = binBlockSize;
        dataBin     = new int[binCapacity];
    }

    public int[] getDataBin() {
        return dataBin;
    }

    public int search(int key)
    {
        //Voraussetzung: Array ist aufsteigend sortiert
        int li = 0;
        int re = binLevel-1;
        while (re >= li) {
            int mid = (li+re) / 2;
            if (key == dataBin[mid]) return mid;
            if (key < dataBin[mid]) re = mid - 1;
            else li = mid+1;
            }
            return  -1;
        }

    public boolean insert(int key)
    {
        if (binLevel == 0 || binLevel == 1) {   //ist array leer?
            dataBin[binLevel] = key;
            binLevel++;
            return true;
        }
        if (binLevel >= binCapacity) {          //reich die Kapazität
            enlarge();
        }
        if (search(key) >= 0 ) {                //Daten bereits vorhanden
            return false;
        }
        if (key > dataBin[binLevel - 1]) {      //Level Anpassen
            dataBin[binLevel++] = key;
        }

        int lt = 0;
        int rt = binLevel - 1;

        while (rt >= lt) {
            int md = (lt + rt) / 2;
            if (key < dataBin[md] && key < dataBin[md + 1]) {
                for (int i = binLevel; i > md; i--) {
                    dataBin[i] = dataBin[i - 1];
                }
                dataBin[md + 1] = key;
                binLevel++;
                return true;
            }
            if (key < dataBin[md]) {
                rt = md - 1;
            }
            else {
                lt = md + 1;
            }

        }
        return true;

        //noch nicht vollständig felt search und anpassen

    }

    public boolean remove(int key)
    {
        if (search(key) <= 0) {             //ist Key vorhanden?
            return false;
        }

        int numKey = search(key);           //Position Key

        for (int i = numKey + 1; i < binLevel; i++) {       //key entfernen
            dataBin[i - 1] = dataBin[i];
        }
        dataBin[binLevel - 1] = 0;
        binLevel--;
        if (binLevel < binCapacity - binBlockSize) {
            shrink();
        }
        return true;
    }

    private void enlarge()                          // Array wird enlarged
    {
        int[] newBin = new int[binCapacity + binBlockSize];
        for (int i = 0; i < binLevel; i++) {
            newBin[i] = dataBin[i];
        }
        dataBin = newBin;
        binCapacity += binBlockSize;
    }

    private void shrink()
    {
        if (binCapacity <= binBlockSize) return;                //Überprüfung min size
        int[] newBin = new int[binCapacity - binBlockSize];     //
        for (int i = 0; i < binLevel; i++) {
            newBin[i] = dataBin[i];
        }
        dataBin = newBin;
        binCapacity -= binBlockSize;
    }

}
