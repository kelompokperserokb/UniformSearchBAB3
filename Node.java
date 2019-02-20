public class Node {
    public String stationName;
    int pathCost;
    public Node parent;
    public Edge[] adjacencies;
    public Node[] child;
    public int[] cost;
    
    public Node(String stationName, int child){
        this.stationName = stationName;
        this.child = new Node[child];
        this.cost = new int[child];
        this.adjacencies = new Edge[child];
    }
    
    public void setAdjacencies(Object...values){
        int length = values.length/2;
        for (int i = 0; i < length; i++) {
            this.child[i] = (Node) values[i];
        }
        for (int i = length, j = 0; i < values.length; i++, j++) {
            this.cost[j] = (int) values[i];
        }
        for (int i = 0; i < child.length; i++) {
            this.adjacencies[i] = new Edge(this.child[i],this.cost[i]);
        }
    }
    
    @Override
    public String toString(){
        return this.stationName;
    }
}

class Edge {
    public int cost;
    public Node side;
    public Edge(Node targetNode, int value) {
        this.cost = value;
        this.side = targetNode;
    }
}