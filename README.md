# Graph Analysis

Program Java untuk menganalisis graf berarah berbobot menggunakan struktur data Adjacency List.

## Fitur
- Graf Berarah Berbobot
- Visualisasi Graf menggunakan Adjacency List
- Analisis Komponen Terhubung
- Deteksi Siklus menggunakan DFS (Metode Tiga Warna)
- Menampilkan Jalur Siklus yang Ditemukan


## Algoritma yang Digunakan
- Depth First Search (DFS)
- Metode Tiga Warna (Three Color Method)

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

## Hasil Program
- Menampilkan struktur graf
- Menghitung jumlah komponen terhubung
- Mendeteksi keberadaan siklus pada graf
- Menampilkan jalur siklus jika ditemukan


## Author
APP
