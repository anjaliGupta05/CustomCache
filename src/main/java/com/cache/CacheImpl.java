package com.cache;


import java.util.concurrent.ConcurrentHashMap;

import com.cache.POJO.Employee;
import com.cache.exception.CustomException;

public class CacheImpl implements Cache<Integer, Employee>{

	private ConcurrentHashMap<Integer, Employee> cacheMap=new ConcurrentHashMap<>();
	private Object simpleCacheLock = new Object();

	@Override
	public Employee get(Integer key) throws CustomException {

		if(key == null)
		{
			throw new CustomException("Cache Doesnot contain NULL key.");
		}
		Employee result=cacheMap.get(key);
		if(result == null)
		{
			return add(key,false);
		}
		return result;
	}

	public Employee add(Integer key,boolean flag) throws CustomException 
	{
		Employee result;
		if(key==null)
		{
			throw new CustomException("NULL Keys not allowed in cache.");
		}
		synchronized (simpleCacheLock) {
			result=cacheMap.get(key);
			if(result==null)
			{
				result=new Employee(key, flag);
				cacheMap.put(key, result);
			}
		}
		return result;
	}

}
