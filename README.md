# Pagero-Code-Test
Completion time around 6 hours

Looking at this problem it is really simillar to the travelling salesman problem (TSP). TSP seeks to find a path in a graph that visits every node exactly once (Hamiltonian Cycle), that has the minimum amount of weight. The only difference here is that we want to find the maximum instead.

The problem provides data that is used to build a fully connected graph where every edge has a weight. This graph is represented by a Hashmap in a Hashmap that contains integers, for example:
  "Alice would gain 54 happiness units by sitting next to Bob" is `["Alice"]["Bob"] = 54` and 
  "Bob would gain 83 happiness units by sitting next to Alice" is `["Bob"]["Alice"] = 83`

We can easily calculate the edge weight by adding these togheter.
