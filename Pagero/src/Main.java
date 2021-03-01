import java.util.*;

public class Main {
    static Map<String, Map<String, Integer>> relations;

    //Calculate the total happiness between two people
    static int edgeWeight(String node1, String node2) {
        return relations.get(node1).get(node2) + relations.get(node2).get(node1);
    }

    static int tsp(Set<String> visited, String startNode, String currNode, int n, int count, int happiness, int ans) {
        //Does this path give a higher happiness
        if(count == n) {
            ans = Math.max(ans, happiness + edgeWeight(startNode, currNode));
            return ans;
        }

        visited.add(currNode);
        for(String nextNode : relations.keySet()) {
            Set<String> copy = new HashSet<>(visited);
            if(!visited.contains(nextNode)) {
                ans = tsp(copy, startNode, nextNode, n, count + 1, happiness + edgeWeight(currNode, nextNode), ans);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        relations = new HashMap<>();

        //Read input
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                String row = sc.nextLine();
                row = row.substring(0, row.length() - 1);
                String[] split = row.split(" ");
                //[0] first person, [2] lose/gain, [3] value, [10] second person
                String person1 = split[0];
                if (!relations.containsKey(person1))
                    relations.put(person1, new HashMap<>());

                String gainLose = split[2];
                String tmpVal = split[3];
                Integer value = gainLose.equals("lose") ? -Integer.parseInt(tmpVal) : Integer.parseInt(tmpVal);

                String person2 = split[10];
                relations.get(person1).put(person2, value);
            }
        }

        //Get the start node
        String[] people = relations.keySet().toArray(new String[0]);
        //Call the travelling sales person algorithm
        int ans = tsp(new HashSet(), people[0], people[0], n, 1, 0, Integer.MIN_VALUE);
        System.out.println(ans);
    }
}
