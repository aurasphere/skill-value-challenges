# Code Trail

## Difficulty
Advanced

## Time
40 minutes

## Problem
Consider an MxN matrix that represents a mountain trail with MxN stops, having the following properties:
- Each stop is connected with each neighboring stop (except diagonals).
- To get from one point to another you spend a certain amount of energy and each stop has a value assigned indicating the level of energy you need to visit that stop.

Starting from the A(0,0) point, the aim is to reach B(M-1, N-1) point by taking the shortest route and under the constraint that you have at most E energy to burn.
The shortest route is represented by the smallest sum of all the visited stops. This sum should be <= E.

## Rules:
- You must keep in mind that you have a finite amount of energy.
- You can only move up, down, left, right.
- If there is no available route or your energy is depleted, the output will be -1.

Can you find such a way? And within the given amount of energy?
If so, you must display the directions to reach B(M-1, N-1).
The directions are coded like this:
Direction East 0
Direction North 1
Direction West 2
Direction South 3

### Input
E – your energy, M >= 0, N >= 0, A[M,N] – a matrix where each element (stop) gives the energy that is spent for reaching that stop.
### Output
R - an array represented by the directions to reach B.

### Example:

For the following input:
E = 15 
M = 4 
N = 4
A = 
<pre><code>
      0  9  3  4
      5  1  2  1
      6  9  12 3
      4  3  3  0
</code></pre>
The output will be: 3 0 0 0 3 3.

## Link

https://skillvalue.com/en/algoplay/test/90/QrBhizyGsz

## Certificate/Score

