package com.kuangxf.concurrent.demo;

import java.util.concurrent.atomic.AtomicInteger;

public class LockData {

	final AtomicInteger lockCount = new AtomicInteger(1);

	int inc = 0;

	public int doInc() {
		return ++inc;
	}
}
