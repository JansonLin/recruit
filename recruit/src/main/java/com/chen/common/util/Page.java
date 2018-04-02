package com.chen.common.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * easyui分页数据封装
 * @author chencundeng
 * @version 1.0v 2017年11月1日
 *
 */
public class Page<T> implements Serializable {

	private static final long serialVersionUID = 1L;
    
	/** 内容 */
	private  List<T> rows = new ArrayList<T>();

	/** 总记录数 */
	private  long total=0L;

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}
	
	
	
	
}
