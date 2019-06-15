# Problem Introduction
An undirected graph is called bipartite if its vertices can be split into two parts such that each edge of the
graph joins to vertices from different parts. Bipartite graphs arise naturally in applications where a graph
is used to model connections between objects of two different types (say, boys and girls; or students and
dormitories).
An alternative definition is the following: a graph is bipartite if its vertices can be colored with two colors
(say, black and white) such that the endpoints of each edge have different colors.
<hr>

# Task
Given an undirected graph with 𝑛 vertices and 𝑚 edges, check whether it is bipartite.

# Input Format
A graph is given in the standard format. The next line contains two vertices 𝑢 and 𝑣.

# Constraints
1 ≤ 𝑛 ≤ 105, 0 ≤ 𝑚 ≤ 105.

# Output Format
Output 1 if the graph is bipartite and 0 otherwise.
<hr>

# Sample 1
  Input:<br>
  4 4<br>
  1 2<br>
  4 1<br>
  2 3<br>
  3 1<br>
  Output:<br>
  0<br>
  
<img src="example1.jpg" width="300" height="300">
 
<strong>Explanation:</strong><br>
This graph is not bipartite. To see this assume that the vertex 1 is colored white.
Then the vertices 2 and 3 should be colored black since the graph contains the edges
{1, 2} and {1, 3}. But then the edge {2, 3} has both endpoints of the same color.

# Sample 2
  Input:<br>
  5 4<br>
  5 2<br>
  4 2<br>
  3 4<br>
  1 4<br>
  Output:<br>
  1<br>
  
<img src="example2.jpg" width="400" height="300">
 
<strong>Explanation:</strong><br>
This graph is bipartite: assign the vertices 4 and 5 the white color, assign all the remaining vertices
the black color.
