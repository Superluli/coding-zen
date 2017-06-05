package com.superluli.multithreading;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * CouncurrentHashMap, BlockingQueue
 * 
 * @author Lu
 *
 */
public class ConcurrentDs {

	private static Random RND = new Random();

	public static void main(String[] args) {

		// blockingQueueTest();
		concurrentHashMapTest();
	}

	public static void blockingQueueTest() {

		AtomicInteger id = new AtomicInteger();
		BlockingQueue<Integer> q = new ArrayBlockingQueue<Integer>(5);
		ExecutorService service = Executors.newFixedThreadPool(100);

		for (int i = 0; i < 5; i++) {
			service.submit(() -> {
				for (int j = 0; j < 2; j++) {

					try {

						int newId = id.addAndGet(1);
						q.put(newId);
						Thread.sleep(RND.nextInt(100));
						System.err.println(Thread.currentThread().getName()
								+ " published " + newId);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

		for (int i = 0; i < 2; i++) {
			service.submit(() -> {

				try {
					while (true) {
						int v = q.take();
						try {
							Thread.sleep(RND.nextInt(100));
						} catch (Exception e) {
							e.printStackTrace();
						}
						System.err.println(Thread.currentThread().getName()
								+ " consumd " + v);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
		}
	}

	public static void concurrentHashMapTest(){

		ExecutorService service = Executors.newFixedThreadPool(100);
		ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<Integer, Integer>();

		long t1 = System.currentTimeMillis();
		
		for (int i = 0; i < 5000; i++) {
			service.submit(() -> {
				map.putIfAbsent(1, 0);
				boolean cas = false;
				while(!cas){
					int oldValue = map.get(1);
					cas = map.replace(1, oldValue, oldValue + 1);	
				}
			});
		}
		service.shutdown();
		try {
			service.awaitTermination(5000, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.err.println(System.currentTimeMillis() - t1);
		System.err.println(map);
	}
}
