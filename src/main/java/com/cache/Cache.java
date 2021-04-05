package com.cache;

import com.cache.exception.CustomException;

public interface Cache<K,V>
{
	V get(K key) throws CustomException;
}