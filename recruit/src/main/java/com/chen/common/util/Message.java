package com.chen.common.util;


/**
 * 消息工具类，向view层提供成功、警告、失败等标准化消息
 * @author chencundeng
 * @version 1.0v 2017年11月2日
 *
 */
public class Message {
    
	/**消息类型*/
	public enum Type{
		success,warn,error
	}
    
	private Type type;
	
	private String content;
	
    public Message() {
    	
    }
    
    public Message(Type type,String content) {
    	this.type = type;
    	this.content = content;
    }
    
    /**
	 * 返回成功消息
	 * 
	 * @param content
	 *            内容
	 * @param args
	 *            参数
	 * @return 成功消息
	 */
	public static Message success(String content) {
		return new Message(Type.success, content);
	}

	/**
	 * 返回警告消息
	 * 
	 * @param content
	 *            内容
	 * @param args
	 *            参数
	 * @return 警告消息
	 */
	public static Message warn(String content) {
		return new Message(Type.warn, content);
	}

	/**
	 * 返回错误消息
	 * 
	 * @param content
	 *            内容
	 * @param args
	 *            参数
	 * @return 错误消息
	 */
	public static Message error(String content) {
		return new Message(Type.error, content);
	}

    
	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
    
    
    
}
