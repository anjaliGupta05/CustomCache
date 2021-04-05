package com.cache.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.cache.CacheImpl;
import com.cache.exception.CustomException;


public class CacheImplTest {

	@Test
	public void testThreadingIssue() throws CustomException, InterruptedException{
		//CacheImpl impl = mock(CacheImpl.class);
		CacheImpl impl=new CacheImpl();
		Runnable task = () -> { try {
			impl.add(4,false);
		} catch (CustomException e) {
			e.printStackTrace();
		} };
		
		Runnable task2 = () -> { try {
			impl.add(4,true);
		} catch (CustomException e) {
			e.printStackTrace();
		} };
		new Thread(task).start()  ;
		new Thread(task2).start()  ;
		Thread.sleep(600);
		
		assertEquals(impl.get(4).isExisting(), false);
		//verify(impl, times(1)).add(4);
	}
	
	
	@Test(expected = CustomException.class)
	public void testException() throws CustomException {
		CacheImpl impl=new CacheImpl();
		impl.add(null,false);
	}
}

