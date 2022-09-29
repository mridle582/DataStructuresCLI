import java.util.UUID;

public class Node {

    public static final int MAX_LINKS = 10;

    private final String NODE_ID;
    private String data;
    private Node[] links;
    private int numLinks;

    public Node() {
        NODE_ID = UUID.randomUUID().toString();
        data = "";
        links = new Node[MAX_LINKS];
        numLinks = 0;
    }

    public Node(String initData) {
        NODE_ID = UUID.randomUUID().toString();
        data = initData;
        links = new Node[MAX_LINKS];
        numLinks = 0;
    }

    public String getNodeID() {
        return NODE_ID;
    }

    public String getData() {
        return data;
    }

    public Node[] getLinks() {
        return links;
    }

    public int getNumLinks(){
        return numLinks;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setLinks(Node[] links) {
        this.links = links;
    }

    public void setNumLinks(int numLinks) {
        this.numLinks = numLinks;
    }
    
    public boolean equals(Object obj) {
        if (!(obj instanceof Node otherNode))
            return false;
        if (otherNode.links != this.links)
            return false;
        for (int i = 0; i < MAX_LINKS; i++) 
            if (this.links[i] != otherNode.links[i])
                return false;
        return this.data.equals(otherNode.data);
    }

    @Override
    public String toString() {
        String fourSpaces = OutputHelper.createSpaces(4);
        String eightSpaces = OutputHelper.createSpaces(8);
        String twelveSpaces = OutputHelper.createSpaces(12);
        if (numLinks == 0)
            return String.format("""
                            {
                            %sid: "%s",
                            %sData: "%s",\s
                            %sLinks: None
                            %s}""", eightSpaces, NODE_ID, eightSpaces,
                    data, eightSpaces, fourSpaces);
        StringBuilder output = new StringBuilder(String.format("{\n%sData: \"%s\", \n%sLinks: {", eightSpaces, data, eightSpaces));
        int i = 0;
        while(i < numLinks) {
            output.append(String.format("\n%sID: \"%s\"", twelveSpaces, links[i].getNodeID()));
            output.append((i != numLinks - 1) ? "," : "");
            i++;
        }
        return output + "\n";
    }
}
