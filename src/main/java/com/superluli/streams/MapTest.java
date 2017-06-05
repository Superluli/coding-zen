package com.superluli.streams;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class MapTest {

	public static void main(String[] args) throws Exception {
		mapTest();
		listTest();

	}

	public static void mapTest() {
		/*
		 * key : student id value : score
		 */
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(1, 70);
		map.put(2, 75);
		map.put(3, 80);
		map.put(4, 85);

		/*
		 * print out all
		 */
		map.forEach((k, v) -> {
			System.err.printf("%s : %s\n", k, v);
		});

		/*
		 * add 10 to score of id, if id not found return -1
		 */
		System.err.println(map.compute(3, (k, v) -> {
			return v == null ? -1 : v + 10;
		}));
	}

	public static void listTest() {

		List<Integer> list = Arrays.asList(1, 2, 3);

		int sumAll = list.stream().collect(Collectors.summingInt(i -> i));
		Long count = list.stream().collect(Collectors.counting());

		System.err.println(sumAll);
		System.err.println(count);

		System.err.println(list.stream().map(v -> v * 2)
				.reduce((v1, v2) -> v1 + v2));

		System.err.println(list);
	}
}
