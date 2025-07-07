// A file system will have a map that will have root address of all the folders 
// and value associated with them will be the folder object and inside that object we'll have a map 
// of its children and its value. 
class FileSystem {

    Map<String, Folder> folders;

    public FileSystem() {
        folders = new HashMap<>();
    }

    public boolean createPath(String inputpath, int value) {
        String[] pathlist = inputpath.split("/");
        Map<String, Folder> currFolders = folders;
        for (int i = 1; i < pathlist.length; i++) {
            String path = pathlist[i];
            //System.out.println(path);
            if (currFolders.containsKey(path)) {
                // path already exists 
                if (i == pathlist.length - 1) {
                    return false;
                } else {
                    // we need to go to inner folders. 
                    currFolders = currFolders.get(path).children;
                }
            } else {
                //check if its the last spot only then create a new path.
                if (i == pathlist.length - 1) {
                    Folder folder = new Folder(path, value);
                    currFolders.put(path, folder);
                    return true;
                } else {
                    //parent path is not present. 
                    return false;
                }
            }
        }
        return false;
    }

    public int get(String inputpath) {
        String[] pathlist = inputpath.split("/");
        Map<String, Folder> currFolders = folders;
        for (int i = 1; i < pathlist.length; i++) {
            String path = pathlist[i];
            if (currFolders.containsKey(path)) {
                // path exists 
                if (i == pathlist.length - 1) {
                    return currFolders.get(path).val;
                } else {
                    // we need to go to inner folders. 
                    currFolders = currFolders.get(path).children;
                }
            } else {
                //path doesn't exist.
                return -1;

            }
        }
        return -1;
    }
}

//have a folder class that will have its path value, its content and its children folders. 
class Folder {
    String fpath;
    int val;
    Map<String, Folder> children;

    public Folder(String fpath, int val) {
        this.fpath = fpath;
        this.val = val;
        children = new HashMap<>();

    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */