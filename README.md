# Graph Analysis

Program Java untuk menganalisis graf berarah berbobot menggunakan struktur data Adjacency List.

## Features
- Weighted Directed Graph
- Graph Visualization using Adjacency List
- Connected Components Analysis
- Cycle Detection using DFS (Three Color Method)
- Cycle Path Display

## Algorithms
- Depth First Search (DFS)
- Three Color Method

## How to Run

Compile:
```bash
javac GraphAnalysis.java
```

Run:
```bash
java GraphAnalysis
```

## Example Input

```text
Jumlah simpul: 4
Jumlah sisi: 4

0 1 5
1 2 3
2 0 2
2 3 4
```

## Example Output

```text
Graf:
0 -> (1, w:5)
1 -> (2, w:3)
2 -> (0, w:2) (3, w:4)
3 ->

Jumlah komponen terhubung: 1
Graph memiliki siklus.
Siklus ditemukan: 0 1 2 0
```

## Author
Arya Pratama Putra
