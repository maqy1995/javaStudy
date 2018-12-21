package maqyTest;

/**
 * Test for linked dot, like Dataset().add().multiply();
 *
 * @author maqy
 * @date 2018.12.15
 */

public class DataSet {
    int i=0;
    public DataSet add(){
        this.i++;
        return this;
    }
    public DataSet multiply(){
        this.i=i*2;
        return this;
    }
}
