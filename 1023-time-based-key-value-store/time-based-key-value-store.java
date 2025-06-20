class TimeMap {
    Map<String, TreeMap<Integer, String>> tracker;

    public TimeMap() {
        tracker = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(tracker.containsKey(key)){
            TreeMap<Integer, String> treeMap = tracker.get(key);
            treeMap.put(timestamp, value);
        }else{
            TreeMap<Integer, String> treeMap = new TreeMap<>();
            treeMap.put(timestamp, value);
            tracker.put(key, treeMap);
        }
    }
    
    public String get(String key, int timestamp) {
        if(tracker.containsKey(key)){
            TreeMap<Integer, String> treeMap = tracker.get(key);
            Integer floorKey = treeMap.floorKey(timestamp);
            if(floorKey == null)return "";
            return treeMap.get(floorKey);

        }
        return "";
    }
}
 

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */