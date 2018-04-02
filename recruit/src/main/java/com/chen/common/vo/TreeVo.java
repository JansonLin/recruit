package com.chen.common.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 树菜单数据封装类
 * @author ccd
 * @version 1.0 2017-4-22
 */
public class TreeVo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String text;    //显示名称
	private String state;   //open or close
	private String iconcls;  //节点图标
	private String  parentId; //父节点ID
	private boolean checked=false; //是否被选中
	private List<TreeVo> children; //子节点
	private Map<String, Object>  attributes; //节点的自定义属性
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getIconcls() {
		return iconcls;
	}
	public void setIconcls(String iconcls) {
		this.iconcls = iconcls;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	public List<TreeVo> getChildren() {
		return children;
	}
	public void setChildren(List<TreeVo> children) {
		this.children = children;
	}
	public Map<String, Object> getAttributes() {
		return attributes;
	}
	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}
	
	
 
}
