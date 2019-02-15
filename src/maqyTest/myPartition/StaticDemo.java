package maqyTest.myPartition;

import java.util.ArrayList;
import java.util.Arrays;

public class StaticDemo {
    int a=1;
    public static ArrayList arrayList;

    public static ArrayList getArrayList() {
        return arrayList;
    }

    public static void setArrayList(ArrayList b) {
        arrayList = null;
        arrayList = new ArrayList(Arrays.asList(b));
    }
}
