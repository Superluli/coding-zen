package com.superluli.multithreading;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.StampedLock;

/**
 * locks in java.util.concurrent.locks
 * @author Lu
 *
 */
public class Locks {

	public static void main(String[] args) {
		
		StampedLock sLock = new StampedLock();
		ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
		
	}
}
