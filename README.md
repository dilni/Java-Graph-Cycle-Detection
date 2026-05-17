# Graph Cycle Detector

A Java-based application designed to detect cycles in directed graphs using graph traversal algorithms. This project reads graph data from input files, processes the graph structure, and determines whether cycles exist.

## Features

- Detects cycles in directed graphs
- Supports multiple graph input files
- Organized modular Java structure
- Efficient graph traversal implementation
- Handles both cyclic and acyclic graph datasets

## Project Structure

```text
project-root/
│
├── input/
│   ├── acyclic/
│   └── cyclic/
│
├── src/
│   └── graphcycledetector/
│       ├── Main.java
│       ├── Graph.java
│       ├── GraphParser.java
│       └── CycleDetector.java
│
└── README.md
```

## Technologies Used

- Java
- Object-Oriented Programming (OOP)
- Depth First Search (DFS)
- File Handling

## How It Works

1. The program reads graph data from text files.
2. The graph is converted into an adjacency list structure.
3. A cycle detection algorithm traverses the graph.
4. The system outputs whether the graph contains cycles.

## Getting Started

### Prerequisites

- Java JDK 8 or higher
- Any Java IDE (IntelliJ IDEA, Eclipse, VS Code)

### Compile the Project

```bash
javac src/graphcycledetector/*.java
