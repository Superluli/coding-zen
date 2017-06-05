package com.superluli.multithreading;

public class Singleton {
	
	private Singleton(){
		
	}
	
	public static Singleton getInstance(){
		return SingletonHolder.INSTANCE;
	}
	
	private static class SingletonHolder{
		private static Singleton INSTANCE = new Singleton();
	} 
}
