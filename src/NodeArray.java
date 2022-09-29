public class NodeArray {

    public static final int MAX_NODES = 10;
    
    private Node[] contents;
    private int size;

    public NodeArray() {
        contents = new Node[MAX_NODES];
        size = 0;
    }

    public NodeArray(Node[] initContents) {
        contents = initContents;
        size = 0;
    }

    public Node[] getContents() {
        return contents;
    }

    public void setContents(Node[] contents) {
       this.contents = contents; 
    }

    public int size() {
        return size;
    }

    public void append(Node nNode) throws ArrayIndexOutOfBoundsException {
        if (size == MAX_NODES) 
            throw new ArrayIndexOutOfBoundsException();
        contents[size] = nNode;
        size++;
    }

    public void insert(Node nNode, int index) throws ArrayIndexOutOfBoundsException {
        if (size == MAX_NODES)
            throw new ArrayIndexOutOfBoundsException("NodeArray - Insert: Full Array");
        if (index < 0 || index > size)
            throw new ArrayIndexOutOfBoundsException("NodeArray - Insert: Invalid Index");
        for (int i = size; i > index; i--)
            contents[i] = contents[i-1];
        contents[index] = nNode;
        size++;
    }

    public Node replace(Node nNode, int index) throws ArrayIndexOutOfBoundsException {
        if (size <= 0) 
            throw new ArrayIndexOutOfBoundsException("NodeArray - Replace: Empty Array");
        if (index < 0 || index > size)
            throw new ArrayIndexOutOfBoundsException("NodeArray - Replace: Invalid Index");
        Node oldNode = contents[index];
        contents[index] = nNode;
        return oldNode;
    }

    public Node delete(int index) throws ArrayIndexOutOfBoundsException {
        if (size <= 0) 
            throw new ArrayIndexOutOfBoundsException("NodeArray - Delete: Empty Array");
        if (index < 0 || index > size)
            throw new ArrayIndexOutOfBoundsException("NodeArray - Delete: Invalid Index");
        Node oldNode = contents[index];
        for (int i = index; i < size-2; i++)
            contents[i] = contents[i+1];
        size--;
        return oldNode;
    }

    @Override
    public String toString() {
        String fourSpaces = OutputHelper.createSpaces(4);
        StringBuilder output = new StringBuilder("\n\n{\n" + fourSpaces);
        for (int i = 0; i < size; i++) {
            output.append(contents[i].toString());
            output.append((i < size - 1) ? ",\n" + fourSpaces : "\n");
        }
        return output + "}";
    }
    
}
