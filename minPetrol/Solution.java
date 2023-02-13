package minPetrol;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;


public class Solution {

	int[] par;
	public long minimumFuelCost(int[][] roads, int seats) {
        /*
         * make the tree first
         */
		if(roads.length == 0) return 0;
		List<List<Integer>> adjList = new ArrayList<>();
		int n = roads.length + 1;
		
		for(int i = 0; i < n; i++) {
			adjList.add(new ArrayList<>());
		}
		par = new int[n];
		Arrays.fill(par, -1);
		par[0] = Integer.MIN_VALUE;
		int[] noOfUnexploredChildren = new int[n];
		Queue<Integer> pool = new LinkedList<>();
		for(int[] x : roads) {
			adjList.get(x[0]).add(x[1]);
			adjList.get(x[1]).add(x[0]);
			if(x[0] == 0) {
				par[x[1]] = 0;
				noOfUnexploredChildren[0]++;
				pool.offer(x[1]);
			}
			else if(x[1] == 0) {
				par[x[0]] = 0;
				noOfUnexploredChildren[0]++;
				pool.offer(x[0]);
			}
		}
		int v;
		System.out.println("pool = "+pool);
		
		while(!pool.isEmpty()) {
			v = pool.poll();
			for(int y : adjList.get(v)) {
				if(par[y] == -1) {
					par[y] = v;
					noOfUnexploredChildren[v]++;
					pool.offer(y);
				}
				
			}
		}
		System.out.println(Arrays.toString(par));
		System.out.println(Arrays.toString(noOfUnexploredChildren));
		Queue<Integer> currSet = new PriorityQueue<>(new Comparator<>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				
				return noOfUnexploredChildren[o1] - noOfUnexploredChildren[o2];
			}
			
		});
		int[] cars = new int[n];
		int[] occ = new int[n];
		long petrol = 0;
		boolean[] visited = new boolean[n];
		for(int i = 0; i < n; i++) {
			if(noOfUnexploredChildren[i] == 0) currSet.offer(i);
				
		}
		int currNode, parent;
		
		while(!currSet.isEmpty()) {
			currNode = currSet.poll();
			noOfUnexploredChildren[par[currNode]]--;
			System.out.println("at node "+currNode);
			if(cars[currNode] == 0) {
				/*
				 * no cars at this node
				 * therefore get a new car
				 */
				cars[currNode] = 1;
				/*
				 * now sit in this car
				 */
				occ[currNode] = 1;
				/*
				 * now travel to its parent
				 */
				petrol++;
				parent = par[currNode];
				if(parent != 0) {
					cars[parent]++;
					occ[parent]++;
					if(!visited[parent]) {
						currSet.offer(parent);
						visited[parent] = true;
					}
					
				}
			}
			else {
				/*
				 * we already have car(s) here
				 */
				System.out.println("cars at "+currNode+" = "+cars[currNode]);
				occ[currNode]++;
				
				int totalCapacity = cars[currNode]*seats;
				if(occ[currNode] > totalCapacity) {
					/*
					 * need to have another car
					 */
					cars[currNode]++;
					/*
					 * now sit in this car
					 */
					/*
					 * now travel to its parent
					 */				
					
				}
				else {
					cars[currNode] = (int)Math.ceil((double)occ[currNode]/seats);
				}
				petrol += cars[currNode];
				parent = par[currNode];
				if(parent != 0) {
					cars[parent] += cars[currNode];
					occ[parent] += occ[currNode];
					if(!visited[parent]) {
						currSet.offer(parent);
						visited[parent] = true;
					}
					
				}
				
				
			}
			//visited[currNode] = true;
		}
		return petrol;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		//int[][] roads = {{0,1},{1,2},{1,3},{4,2},{5,3},{6,3},{6,7},{8,6},{9,0},{5,10},{11,9},{12,5},{5,13},{8,14},{11,15},{8,16},{17,0},{18,7}};
		int[][] roads = 
			{{0,1},{2,0},{3,2},{3,4},{2,5},{6,4},{6,7},{8,2},{9,0},{3,10},{1,11},{5,12},{6,13},{6,14},{15,10},{16,0},{14,17},{12,18},{19,6},{20,17},{14,21},{12,22},{23,20},{24,11},{25,15},{26,7},{17,27},{15,28},{5,29},{30,8},{31,1},{32,12},{33,29},{34,5},{35,27},{36,30},{37,31},{20,38},{16,39},{40,6},{28,41},{42,30},{43,2},{12,44},{45,17},{5,46},{47,6}};
		
		System.out.println(s.minimumFuelCost(roads, 26));

	}

}
