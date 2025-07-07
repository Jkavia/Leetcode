class FileSystem {
    // Other way to do this is, store all paths on the same map, 
    // and check the parent existence by checking if the path before last "/" already exists in map. 
    Map<String,Integer> paths;

    public FileSystem() {
        paths = new HashMap<>();
    }
    
    public boolean createPath(String path, int value) {
        // lets do some basic checks here and prevent overwriting 
        if(path.isEmpty() || path==null || path.indexOf("/") == -1 || (path.length() == 1 && path.equals("/")) || paths.containsKey(path)){
                  
            return false;
        }

        int indexOfLastSlash = path.lastIndexOf("/");
        if(indexOfLastSlash > 0){
        String parent = path.substring(0,indexOfLastSlash);
        // parent doent exist
        if(!paths.containsKey(parent)){
            return false;
        }
        }

        paths.put(path, value);
        return true;
    }
    
    public int get(String path) {
        return paths.getOrDefault(path,-1);
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */