class TimeMap {

    Map<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> innerMap = map.getOrDefault(key, new TreeMap<>());
        innerMap.put(timestamp, value);
        map.put(key,innerMap);
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key))return "";

        TreeMap<Integer, String> innerMap = map.get(key);
        if(innerMap.floorKey(timestamp) != null){
            int tkey = innerMap.floorKey(timestamp);
             return innerMap.get(tkey);
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