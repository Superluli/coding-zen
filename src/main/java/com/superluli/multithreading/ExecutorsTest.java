package com.superluli.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class ExecutorsTest {
	public static class MyTask implements Runnable {

		private int id;
		private final Semaphore semaphore;

		public MyTask(int id, Semaphore semaphore) {
			super();
			this.id = id;
			this.semaphore = semaphore;
		}

		@Override
		public void run() {

			try {
				semaphore.acquire();

				System.err.println(id + " got permit");
				Thread.sleep(500);

			} catch (InterruptedException e) {
				System.err.println(id + " interrupted");
				return;
			} finally {
				semaphore.release();
			}
		}

	}

	public static void main(String[] args) throws Exception {

		ExecutorService service = Executors.newFixedThreadPool(10);
		Semaphore semaphore = new Semaphore(2);
		for (int i = 0; i < 10; i++) {
			service.submit(new MyTask(i, semaphore));
		}
		service.shutdown();
		while (!service.awaitTermination(10, TimeUnit.SECONDS)) {
		}

		System.err.println("all done");
	}
}
