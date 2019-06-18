# Problem Introduction
Now, you are interested in minimizing not the number of segments, but the total cost of a flight. For this
you construct a weighted graph: the weight of an edge from one city to another one is the cost of the
corresponding flight.
<hr>

# Task
Given an directed graph with positive edge weights and with 𝑛 vertices and 𝑚 edges as well as two
vertices 𝑢 and 𝑣, compute the weight of a shortest path between 𝑢 and 𝑣 (that is, the minimum total
weight of a path from 𝑢 to 𝑣).

# Input Format
A graph is given in the standard format. The next line contains two vertices 𝑢 and 𝑣.

# Constraints
1 ≤ 𝑛 ≤ 104, 0 ≤ 𝑚 ≤ 105, 𝑢 ̸= 𝑣, 1 ≤ 𝑢, 𝑣 ≤ 𝑛, edge weights are non-negative integers not
exceeding 103.

# Output Format
Output the minimum weight of a path from 𝑢 to 𝑣, or −1 if there is no path.
<hr>

# Sample 1
  Input:<br>
  4 4<br>
  1 2 1<br>
  4 1 2<br>
  2 3 2<br>
  1 3 5<br>
  1 3<br>
  Output:<br>
  3<br>
  
<img src="example1.jpg" width="300" height="300">
 
<strong>Explanation:</strong><br>
There is a unique shortest path from vertex 1 to vertex 3 in this graph (1 → 2 → 3), and it has weight 3.

# Sample 2
  Input:<br>
  5 9<br>
  1 2 4<br>
  1 3 2<br>
  2 3 2<br>
  3 2 1<br>
  2 4 2<br>
  3 5 4<br>
  5 4 1<br>
  2 5 3<br>
  3 4 4<br>
  1 5<br>
  Output:<br>
  6<br>
  
<img src="example2.jpg" width="400" height="300">
 
<strong>Explanation:</strong><br>
There are two paths from 1 to 5 of total weight 6: 1 → 3 → 5 and 1 → 3 → 2 → 5.

# Sample 3
  Input:<br>
  3 3<br>
  1 2 7<br>
  1 3 5<br>
  2 3 2<br>
  3 2<br>
  Output:<br>
  -1<br>
  
<img src="example3.jpg" width="300" height="300">
 
<strong>Explanation:</strong><br>
There is no path from 3 to 2.
