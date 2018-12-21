package maqyTest;

/**
 * Test for linked dot, like Dataset().add().multiply();
 *
 * @author maqy
 * @date 2018.12.15
 */

public class DataSetDemo {
    public static void main(String[] args) {
        DataSet dataSet =new DataSet();
        DataSet result = dataSet.add().multiply();
        System.out.println(result.i);
    }
}
