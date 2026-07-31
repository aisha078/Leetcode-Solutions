class LRUCache {

    private final int capacity;
    private LinkedHashMap<Integer, Integer> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<>(capacity, 0.75f, true);
    }

    public int get(int key) {
        return map.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.put(key, value);
            return;
        }

        if (map.size() == capacity) {
            int firstKey = map.keySet().iterator().next();
            map.remove(firstKey);
        }

        map.put(key, value);
    }
}