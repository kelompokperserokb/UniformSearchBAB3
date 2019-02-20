
public class bab_3 {

    public static void main(String[] args) {
        Node a = new Node("A", 4);
        Node b = new Node("B", 2);
        Node c = new Node("C", 2);
        Node d = new Node("D", 3);
        Node e = new Node("E", 5);
        Node f = new Node("F", 2);
        Node g = new Node("G", 2);
        Node h = new Node("H", 1);
        Node i = new Node("I", 3);
        Node j = new Node("J", 2);
        Node k = new Node("K", 2);
        Node l = new Node("L", 1);
        Node m = new Node("M", 1);
        Node n = new Node("N", 3);
        Node o = new Node("O", 1);
        Node p = new Node("P", 1);
        Node q = new Node("Q", 2);
        Node r = new Node("R", 2);
        Node s = new Node("S", 2);
        Node t = new Node("T", 3);
        Node u = new Node("U", 2);
        Node v = new Node("V", 3);
        Node x = new Node("X", 3);
        a.setAdjacencies(b, i, x, v, 145, 148, 55, 167);
        b.setAdjacencies(a, c, 145, 98);
        c.setAdjacencies(b, d, 98, 212);
        d.setAdjacencies(c, e, k, 212, 102, 102);
        e.setAdjacencies(d, l, f, m, n, 102, 95, 152, 73, 97);
        f.setAdjacencies(e, g, 152, 83);
        g.setAdjacencies(f, h, 83, 75);
        h.setAdjacencies(g, 75);
        i.setAdjacencies(a, j, q, 148, 75, 25);
        j.setAdjacencies(i, k, 75, 95);
        k.setAdjacencies(d, j, 102, 95);
        l.setAdjacencies(e, 95);
        m.setAdjacencies(e, 73);
        n.setAdjacencies(e, o, p, 97, 25, 65);
        o.setAdjacencies(n, 25);
        p.setAdjacencies(n, 65);
        q.setAdjacencies(i, x, 25, 30);
        r.setAdjacencies(s, x, 93, 57);
        s.setAdjacencies(r, t, 93, 112);
        t.setAdjacencies(s, u, v, 112, 75, 25);
        u.setAdjacencies(t, v, 75, 85);
        v.setAdjacencies(a, t, u, 167, 25, 85);
        x.setAdjacencies(a, r, q, 55, 57, 30);

        UniformCostSearch ucs = new UniformCostSearch(i, a);
        ucs.compute();
        ucs.showFinalPath();
        ucs.showFinalCost();
    }
}
