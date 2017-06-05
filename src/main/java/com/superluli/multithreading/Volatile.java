package com.superluli.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Volatile {

	static AtomicInteger v = new AtomicInteger();

	public static void main(String[] args) throws Exception{

		ExecutorService service = Executors.newFixedThreadPool(100);
		Object lock = new Object();

		for (int i = 0; i < 100000; i++) {
			service.submit(() -> {
					v.addAndGet(1);
			});
		}
		service.shutdown();
		service.awaitTermination(3000, TimeUnit.MILLISECONDS);
		System.err.println(v);
	}
}
