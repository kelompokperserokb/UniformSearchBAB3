import java.util.PriorityQueue;
        import java.util.HashSet;
        import java.util.Set;
        import java.util.Collections;
        import java.util.List;
        import java.util.ArrayList;
        import java.util.Arrays;

public class UniformCostSearch {

    Node startNode;
    Node goalNode;
    List<Node> finalPath;
    int finalCost;

    public UniformCostSearch(Node start, Node goalNode) {
        this.startNode = start;
        this.goalNode = goalNode;
    }

    public void compute() {
        System.out.println("Kota asal       : " + this.startNode);
        System.out.println("Kota tujuan     : " + this.goalNode);
        System.out.println("Langkah-langkah : ");
        startNode.pathCost = 0;
        PriorityQueue<Node> queue = new PriorityQueue<>(30, (Node first, Node second) -> {
            if (first.pathCost > second.pathCost) {
                return 1;
            } else if (first.pathCost < second.pathCost) {
                return -1;
            } else {
                return 0;
            }
        });

        queue.add(startNode);
        Set<Node> explored = new HashSet<>();
        boolean found = false;

        do {
            Node current = queue.poll();
            explored.add(current);

            if (current.stationName.equals(goalNode.stationName)) {
                found = true;
            }

            for (Edge temp : current.adjacencies) {
                Node child = temp.side;
                int cost = temp.cost;
                child.pathCost = current.pathCost + cost;

                if (!explored.contains(child) && !queue.contains(child)) {
                    child.parent = current;
                    queue.add(child);
                    System.out.print(child + " ");
                    System.out.println(queue);
                } else if ((queue.contains(child)) && (child.pathCost > current.pathCost)) {
                    child.parent = current;
                    queue.remove(child);
                    queue.add(child);
                }
            }
        } while (!queue.isEmpty());
        System.out.println();
    }

    public void showFinalPath() {
        List<Node> path = new ArrayList<>();
        for (Node node = goalNode; node != null; node = node.parent) {
            path.add(node);
        }
        this.finalPath = new ArrayList<>(path);
        Collections.reverse(path);
        System.out.println("Rute " + path);
    }

    public void showFinalCost() {
        this.finalCost = 0;
        for (int i = 0; i < finalPath.size() - 1; i++) {
            int index = Arrays.asList(finalPath.get(i).child).contains(finalPath.get(i).parent)
                    ? Arrays.asList(finalPath.get(i).child).indexOf(finalPath.get(i).parent) : -1;
            this.finalCost += finalPath.get(i).cost[index];
        }
        System.out.println("Jarak [" + this.finalCost + "]");
    }
}
