import java.util.*;
public class GraphAnalysis {

    private int vertices;

    // adjacency list berbobot
    private LinkedList<Edge>[] adjList;

    // class edge
    static class Edge {

        int dest;
        int weight;

        Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    @SuppressWarnings("unchecked")
    public GraphAnalysis(int v) {

        vertices = v;

        adjList = new LinkedList[v];

        for (int i = 0; i < v; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    // tambah edge BERARAH berbobot
    public void addEdge(int u, int v, int w) {

        adjList[u].add(new Edge(v, w));
    }

    // DETEKSI SIKLUS GRAF BERARAH
    // METODE TIGA WARNA
    // 0 = UNVISITED
    // 1 = VISITING
    // 2 = VISITED

    private boolean dfsCycle(int node,
                             int[] color,
                             int[] parent,
                             List<Integer> cycle) {

        color[node] = 1; // VISITING

        for (Edge e : adjList[node]) {

            int neighbor = e.dest;

            // belum dikunjungi
            if (color[neighbor] == 0) {

                parent[neighbor] = node;

                if (dfsCycle(neighbor, color, parent, cycle)) {
                    return true;
                }
            }

            // ditemukan back edge
            else if (color[neighbor] == 1) {

                // membentuk siklus
                cycle.add(neighbor);

                int current = node;

                while (current != neighbor) {

                    cycle.add(current);

                    current = parent[current];
                }

                cycle.add(neighbor);

                Collections.reverse(cycle);

                return true;
            }
        }

        color[node] = 2; // VISITED

        return false;
    }

    // cek apakah ada siklus
    public boolean hasCycle(List<Integer> cycle) {

        int[] color = new int[vertices];

        int[] parent = new int[vertices];

        Arrays.fill(parent, -1);

        for (int i = 0; i < vertices; i++) {

            if (color[i] == 0) {

                if (dfsCycle(i, color, parent, cycle)) {
                    return true;
                }
            }
        }

        return false;
    }

    // HITUNG KOMPONEN TERHUBUNG
    private void DFSComponent(int v,
                              boolean[] visited) {

        visited[v] = true;

        for (Edge e : adjList[v]) {

            int neighbor = e.dest;

            if (!visited[neighbor]) {

                DFSComponent(neighbor, visited);
            }
        }
    }

    public int countComponents() {

        boolean[] visited = new boolean[vertices];

        int count = 0;

        for (int i = 0; i < vertices; i++) {

            if (!visited[i]) {

                DFSComponent(i, visited);

                count++;
            }
        }

        return count;
    }
    // DISPLAY 
    public void display() {

        System.out.println("Graf:");

        for (int i = 0; i < vertices; i++) {

            System.out.print(i + " -> ");

            for (Edge e : adjList[i]) {

                System.out.print("(" +
                        e.dest +
                        ", w:" +
                        e.weight +
                        ") ");
            }

            System.out.println();
        }
    }

    // MAIN
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Jumlah simpul: ");
        int v = sc.nextInt();

        GraphAnalysis g = new GraphAnalysis(v);

        System.out.print("Jumlah sisi: ");
        int e = sc.nextInt();

        System.out.println(
                "Masukkan sisi (src dest weight):");

        for (int i = 0; i < e; i++) {

            int u = sc.nextInt();

            int w = sc.nextInt();

            int weight = sc.nextInt();

            g.addEdge(u, w, weight);
        }

        System.out.println();

        g.display();

        // hitung komponen
        int components = g.countComponents();

        System.out.println("\nJumlah komponen terhubung: "+ components);

        // deteksi siklus
        List<Integer> cycle = new ArrayList<>();

        if (g.hasCycle(cycle)) {

            System.out.println(
                    "Graph memiliki siklus.");

            System.out.print("Siklus ditemukan: ");

            for (int node : cycle) {
                System.out.print(node + " ");
            }

            System.out.println();

        } else {

            System.out.println(
                    "Graph tidak memiliki siklus.");
        }

        sc.close();
    }
}