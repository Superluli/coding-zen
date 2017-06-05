package com.superluli.multithreading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * About Semaphore, CountdownLatch, CyclicBarrier, etc...
 * 
 * @author Lu
 *
 */
public class SyncUtils {

	public static void main(String[] args) throws Exception {
		//semaphoreTest();
		//countDownLatchTest();
		cyclicBarrierTest();
	}
	
	public static class SemaphoreTask implements Runnable {

		private int id;
		private final Semaphore semaphore;

		public SemaphoreTask(int id, Semaphore semaphore) {
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

	public static void semaphoreTest() {

		ExecutorService service = Executors.newFixedThreadPool(10);
		Semaphore semaphore = new Semaphore(2);
		System.err.println("Semaphore test");
		for (int i = 0; i < 10; i++) {
			service.submit(new SemaphoreTask(i, semaphore));
		}
		service.shutdown();
		try {
			service.awaitTermination(10, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.err.println("Semaphore test done");
	}

	public static class CountDownLatchTask implements Runnable {

		CountDownLatch latch;
		boolean finishFirst;

		public CountDownLatchTask(CountDownLatch latch, boolean finishFirst) {
			this.latch = latch;
			this.finishFirst = finishFirst;
		}

		@Override
		public void run() {

			if (finishFirst) {
				System.err.println("1st job done, count : " + latch.getCount());
				latch.countDown();
			} else {
				try {
					System.err.println("2nd job wait...");
					latch.await();
					System.err.println("2nd job done");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void countDownLatchTest(){
		
		ExecutorService service = Executors.newFixedThreadPool(100);
		CountDownLatch latch = new CountDownLatch(3);
		
		System.err.println("CountDownLatch test");
		for (int i = 0; i < 3; i++) {
			service.submit(new CountDownLatchTask(latch, false));
		}
		
		for (int i = 0; i < 3; i++) {
			service.submit(new CountDownLatchTask(latch, true));
		}
		
		service.shutdown();
		try {
			service.awaitTermination(10, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.err.println("CountDownLatch test done");
	}

	public static class CyclicBarrierTask implements Runnable{

		private CyclicBarrier barrier;
		
		public CyclicBarrierTask(CyclicBarrier barrier) {
			this.barrier = barrier;
		}
		
		@Override
		public void run() {
			try {
				System.err.println("phase 1 done");
				barrier.await();
				System.err.println("phase 2 done");
				barrier.await();
				System.err.println("phase 3 done");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private static void cyclicBarrierTest() {
		
		ExecutorService service = Executors.newFixedThreadPool(100);
		CyclicBarrier barrier = new CyclicBarrier(5);
		
		System.err.println("CyclicBarrierTest");
		
		for (int i = 0; i < 5; i++) {
			service.submit(new CyclicBarrierTask(barrier));
		}
		
		service.shutdown();
		try {
			service.awaitTermination(10, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.err.println("CyclicBarrierTest done");
	}
}
