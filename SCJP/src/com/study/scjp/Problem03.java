package com.study.scjp;

import java.util.PriorityQueue;

public class Problem03 {
	public static void main(String[] args) {
		PriorityQueue<String> pq = new PriorityQueue<String>();
		pq.add("carrot");
		pq.add("apple");
		pq.add("bananan");
		System.out.println(pq.poll() + ":" + pq.peek());
	}

}
