package com.cfyj.weilan.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.cfyj.weilan.domain.IpCache;

@Component
public class IpCacheClient {

	private Map<String,IpCache> ipCacheMap = new HashMap<String,IpCache>();
	
	private Long default_CacheTime =  (1000l*60);
	

	/**
	 * 根据ip取出访问次数，如果不存在则自动加入cache中,访问次数加1
	 * @param ip
	 * @return
	 */
	public int getIpCache(String ip) {
		
		IpCache ipCache = ipCacheMap.get(ip);
		if(ipCache==null) {	//没有
			ipCache = new IpCache(System.currentTimeMillis()+default_CacheTime,1);
		}else if(ipCache.getTime()<System.currentTimeMillis()) {//过期
			ipCache = new IpCache(System.currentTimeMillis()+default_CacheTime,1);
		}else {
			ipCache.incrementNum();
		}		
		return ipCache.getNum();
	}


	public Map<String, IpCache> getIpCacheMap() {
		return ipCacheMap;
	}
	
	//TODO定时清理这个cacheMap的缓存.
	
}
