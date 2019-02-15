package maqyTest.myPartition;

/**
 * Function to implement a custom partition assignment for keys.
 *
 * @param <K> The type of the key to be partitioned.
 */

public interface Partitioner<K> extends java.io.Serializable{

    /**
     * Computes the partition for the given key.
     *
     * @param key The key.
     * @param numPartitions The number of partitions to partition into.
     * @return The partition index.
     */
    int partition(K key, int numPartitions);
}
