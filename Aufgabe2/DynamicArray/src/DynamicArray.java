public class DynamicArray {
    // Data-Members
    private static final int binBlockSize = 10;
    private int binLevel;       //Füllstand
    private int binCapacity;    //maximale Füllung
    private int [] dataBin;     //Datentyp des Bin ist int

    // Methods
    public DynamicArray() {
        this.binLevel       = 0;
        binCapacity         = binBlockSize;             //initiale größe
        dataBin             = new int[binCapacity];
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
        if (binLevel == 0 || binLevel == 1) {
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
            if (key > dataBin[md] && key < dataBin[md + 1]) {
                for (int i = binLevel; i > md; i--) {
                    dataBin[i] = dataBin[i - 1];
                }
                binLevel++;
                dataBin[md + 1] = key;
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
    }

    public boolean remove(int key) {
        int numKey = search(key);
        if (search(key) <= 0) {             //ist Key vorhanden?
            return false;                   //invalid position
        }

        if (binLevel < binCapacity - binBlockSize) {
            shrink();                       //array is under-full and shrink
        }

        for (int i = numKey + 1; i < binLevel; i++) {   //move data in array down
            dataBin[i] = dataBin[i + 1];
        }
        dataBin[binLevel - 1] = 0;                      // set last index to empty
        binLevel--;                                     // decrease level
        return true;

    }

    private void enlarge() {
        int[] newBin = new int[binCapacity + binBlockSize];
        for (int i = 0; i < binLevel; i++) {
            newBin[i] = dataBin[i];
        }
        dataBin = newBin;
        binCapacity += binBlockSize;
    }

    private void shrink() {
        if (binCapacity <= binBlockSize) return;
        int[] newBin = new int[binCapacity - binBlockSize];
        for (int i = 0; i < binLevel; i++) {
            newBin[i] = dataBin[i];
        }
        dataBin = newBin;
        binCapacity -= binBlockSize;
    }

}
