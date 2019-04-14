class MyHashMap {

    /** Initialize your data structure here. */
    
    int buckets = 1000; // the number modulus this will be stored here.
    int nobuckets = 1001; // to store more values.
    int[][]  no = null;
    
    public MyHashMap() {
        no = new int[buckets][];
    }
    
     public int hash(int key)
    {
        return key% buckets;
    }
    
    public int postn(int key)
    {
        return key/buckets;
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        if(no[hash(key)] ==  null)
        {
            no[hash(key)] = new int[nobuckets];
            Arrays.fill(no[hash(key)],-1);
        }
        no[hash(key)][postn(key)] = value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        if(no[hash(key)] == null || no[hash(key)][postn(key)] < 0)
        {
            return -1;
        }
        if(no[hash(key)][postn(key)]>=0)
        {
            return no[hash(key)][postn(key)];
        }
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        if(no[hash(key)] != null && no[hash(key)][postn(key)]>-1)
        {
            no[hash(key)][postn(key)] = -1;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
