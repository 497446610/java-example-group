package com.kuangxf.concurrent.demo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {

	public AppTest(String testName) {

		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	/**
	 * 测试AtomicInteger操作的原子性<br/>
	 * 如果输出的value没有重复，说明AtomicInteger是原子操作
	 * 
	 */
	public void testAtomicInteger() {
		LockData lockData = new LockData();

		for (int i = 0; i < 1000; i++) {
			Thread thread = new Thread(new Runnable() {
				@Override
				public void run() {
					Thread.yield();
					int value = lockData.lockCount.incrementAndGet();
					System.out.println(value);
				}
			});
			thread.start();
		}
		Thread.currentThread().notifyAll();
	}

	public void testReentrantLock() throws Exception {
		LockData lockData = new LockData();
		ExecutorService executor = Executors.newFixedThreadPool(100);
		CountDownLatch countDown = new CountDownLatch(100);
		ReentrantLock lock = new ReentrantLock();
		for (int i = 0; i < 100; i++) {
			Runnable runable = new Runnable() {
				@Override
				public void run() {
					for (int i = 0; i < 100; i++) {
						lock.lock();
						System.out.println(lockData.doInc());
						lock.unlock();
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}

					countDown.countDown();
				}
			};
			executor.submit(runable);
		}
		countDown.await();
		executor.shutdown();
	}

	public void testInterProcessMutex() throws Exception {
		RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
		CuratorFramework client = CuratorFrameworkFactory.newClient("localhost:2181", retryPolicy);
		client.start();

		ExecutorService executor = Executors.newFixedThreadPool(100);
		CountDownLatch countDown = new CountDownLatch(100);

		LockData lockData = new LockData();
		for (int i = 0; i < 100; i++) {
			Runnable runable = new Runnable() {
				@Override
				public void run() {
					InterProcessMutex mutex = new InterProcessMutex(client, "/curator/lock");
					for (int i = 0; i < 100; i++) {
						try {
							mutex.acquire();
							System.out.println(lockData.doInc());
							mutex.release();
							Thread.sleep(100);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					countDown.countDown();
				}
			};
			executor.submit(runable);
		}

		countDown.await();
		executor.shutdown();

		// 关闭客户端
		client.close();
	}
}
