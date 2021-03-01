# Pagero-Code-Test
Completion time around 6 hours

Looking at this problem it is really simillar to the travelling salesman problem (TSP). TSP seeks to find a path in a graph that visits every node exactly once (Hamiltonian Cycle), that has the minimum amount of weight. The only difference here is that we want to find the maximum instead.

The problem provides data that is used to build a fully connected graph where every edge has a weight. This graph is represented by a Hashmap in a Hashmap that contains a integer, for example:
  "Alice would gain 54 happiness units by sitting next to Bob" is `["Alice"]["Bob"] = 54` and 
  "Bob would gain 83 happiness units by sitting next to Alice" is `["Bob"]["Alice"] = 83`

We can easily calculate the edge weight by adding these togheter. Next we chose a starting node, which is done by just picking the first key in the hasmap keyset. After that we call the tsp function. Tsp is a recursive funciton that explores every path from the starting node that visits each node exactly once and returns to the starting node.

Lets say our starting node is Alice which we also set to the current node and the subset of nodes we want to visit are {Bob, Carol, David}. When we call tsp we add Alice to the visited list. Next we loop through the subset of nodes and for each node in the subset we call tsp again where we remove that node from the subset and set it to the current node. This will recursively call until we have one node left in the subset which is our end case. At the end case we look at our current best paths weight (set to -∞ at the start) and see if the new path we found has a higher weight and if it does return that value instead.

                        A      (How the recurssion tree would look) 
                   /    |    \
                 B      C      D
              /  |     / \     |  \
            C    D    B   D    B   C
           /     |    |   |    |    \
          D      C    D   B    C     B
    (end case #1)

Answer #1: 664
Answer #2: 640
