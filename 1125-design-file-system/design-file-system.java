// we will create a map of paths and values, to check for parent we will see if the substring before last '/' exist ? if
// it doesnt then we skip it. 
// if path alredy exists return false;
class FileSystem {
    Map<String, Integer> paths;

    

    public FileSystem() {
        paths = new HashMap<>();
    }
    
    public boolean createPath(String path, int value) {
        if(path.isEmpty() || path == null || (path.length() == 1 && path.equals("/")) || paths.containsKey(path))return false;

        int lastIdx = path.lastIndexOf("/");

        if(lastIdx > 0){
            String parent = path.substring(0,lastIdx);
            if(!paths.containsKey(parent))return false;
        }

        paths.put(path,value);
        return true;
    }
    
    public int get(String path) {
        return paths.getOrDefault(path, -1);
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */