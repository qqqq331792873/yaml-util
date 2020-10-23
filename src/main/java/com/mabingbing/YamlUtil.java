package com.mabingbing;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Map;

/**
 * Yaml工具包
 */
public class YamlUtil {
	static String path;
	static Map<String, Object> map;
	
	static {
		use("application.yaml");
	}
	
	/**
	 * 使用某个配置文件,默认路径为resources下面的application.yaml
	 */
	public static void use(String userpath) {
		if (userpath == null || userpath.length() == 0) {
			return;
		}
		path = userpath;
		Yaml yaml = new Yaml();
		InputStream inputStream = YamlUtil.class.getClassLoader().getResourceAsStream(path);
		map = yaml.load(inputStream);
	}
	
	/**
	 * 获取加载后的map(配置文件中的json转化的map)
	 */
	public static Map<String, Object> getMap() {
		return map;
	}
	
	/**
	 * 直接按照配置文件中的key获取value
	 */
	public static Object get(String searchString) {
		if (map == null || map.size() == 0) {
			return null;
		}
		String[] keys = searchString.split("\\.");
		if (keys.length == 0) {
			return null;
		} else if (keys.length == 1) {
			return map.get(keys[0]);
		}
		
		Object returnNow = map.get(keys[0]);
		if (returnNow == null) {
			return null;
		}
		int i = 0;
		int need2Search = keys.length - 1;
		for (; i < need2Search; i++) {
			String keyNow = keys[i + 1];
			returnNow = ((Map) returnNow).get(keyNow);
		}
		return returnNow;
	}
	
	/**
	 * 如果配置文件中途有更改,可以使用刷新功能.但是需要各个钩子函数来订阅,才可以接收
	 * todombb 这里可以设计一个钩子,当文档配置改变时,可以热替换参数
	 */
	public static void refresh(Object notification) {
	}
}
