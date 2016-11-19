package com.partneration.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Timer;
import java.util.TimerTask;

import com.partneration.entity.User;

/**
 * @author John
 *
 */
public class UserCache {

	private static Map<String, User> userCache = new HashMap<>();
	
	private static Map<String, Long> keyTime = new HashMap<>();
	
	private static final long START = 0;
	
	private static final long EXPIRATIONTIME = 1000 * 60 * 60; //30min * 60s * 1000ms
	
	private static final int INTERVAL=1000 * 60 * 10;//10min * 60s * 1000ms
	
	/**
	 * @param accessKey
	 * @return
	 */
	public static User get(String accessKey){
		return userCache.get(accessKey);
	}
	
	/**
	 * @param accessKey ∑√Œ key
	 * @param user
	 */
	public static void put(String accessKey, User user){
		userCache.put(accessKey, user);
		keyTime.put(accessKey, new Date().getTime());
	}
	
	static {
		Timer timer = new Timer(); 
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				long systemTime = new Date().getTime();
				Iterator<Entry<String, Long>> entries = keyTime.entrySet().iterator();    
                while (entries.hasNext()) {    
                    @SuppressWarnings({ "unchecked", "rawtypes" })
					Map.Entry<String,Object> entry = (Map.Entry) entries.next();     
                    String key = (String)entry.getKey(); //key    
                    long value = (Long)entry.getValue(); //value  
                    long rt = systemTime - value;
                    if(rt>EXPIRATIONTIME){
                        userCache.put(key, null);  
                        entries.remove();  
                        System.out.println("Key:"+key+"π˝ ±");  
                    }  
                }  
			}
		}, START, INTERVAL);
	}
}
