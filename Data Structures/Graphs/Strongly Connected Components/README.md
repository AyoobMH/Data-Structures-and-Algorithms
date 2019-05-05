# Problem Introduction
The police department of a city has made all streets one-way. You would like
to check whether it is still possible to drive legally from any intersection to
any other intersection. For this, you construct a directed graph: vertices are
intersections, there is an edge (𝑢, 𝑣) whenever there is a (one-way) street from
𝑢 to 𝑣 in the city. Then, it suffices to check whether all the vertices in the
graph lie in the same strongly connected component.
<hr>

# Task
Compute the number of strongly connected components of a given directed graph with 𝑛 vertices and
𝑚 edges.

# Input Format
A graph is given in the standard format.

# Constraints
1 ≤ 𝑛 ≤ 10<sup>4</sup>, 0 ≤ 𝑚 ≤ 10<sup>4</sup>.

# Output Format
Output the number of strongly connected components.
<hr>

# Sample 1
  Input:<br>
  4 4<br>
  1 2<br>
  4 1<br>
  2 3<br>
  3 1<br>
  Output:<br>
  2<br>
  
<img src="img.jpg" width="300" height="300">
 
 <strong>Explanation:</strong><br>
This graph has two strongly connected components: {1, 3, 2}, {4}.
