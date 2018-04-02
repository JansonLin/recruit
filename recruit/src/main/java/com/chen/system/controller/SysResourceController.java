package com.chen.system.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chen.common.util.ConstantUtil;
import com.chen.common.util.Message;
import com.chen.common.util.Page;
import com.chen.common.vo.TreeVo;
import com.chen.system.entity.SysResource;
import com.chen.system.service.SysResourceService;
import com.github.pagehelper.PageInfo;

/**
 * @ClassName: SysResourceController
 * @Description:TODO 系统菜单管理类
 * @author:chencundeng
 * @date: 2018年3月28日 下午4:52:37
 * @Copyright: 2018 www.chen.com Inc. All rights reserved.
 */
@RequestMapping("/system/sysResource")
@Controller
public class SysResourceController {

	@Autowired
	private SysResourceService sysResourceService;
    
	@RequestMapping("/main")
	public String main() {
		return "system/resource/resource_main";
	}
	
	@RequestMapping("/page")
	@ResponseBody
	public Page<SysResource> page(HttpServletRequest request, Integer page, Integer rows,Long pid){
		if (null == page) {
			page = ConstantUtil.PAGE_NUMBER;
		}
		if (null == rows) {
			rows = ConstantUtil.PAGE_SIZE;
		}
		Page<SysResource> resourcePage = new Page<>();
		PageInfo<SysResource> resources = sysResourceService.page(page, rows, pid);
		resourcePage.setRows(resources.getList());
		resourcePage.setTotal(resources.getTotal());
		return resourcePage;
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public List<SysResource> list(Long pid){
		if(null==pid||"".equals(pid)) {
			pid=0L;
		}
		List<SysResource> list = sysResourceService.childByParentId(pid);
		return list;
	}
	
	
	@RequestMapping("/rootTree")
	@ResponseBody
	public List<SysResource> rootTree() {
		List<SysResource> rootList = sysResourceService.rootTree();
		return rootList;
	}

	/**
	 * 返回树形菜单下面2级菜单数据
	 * 
	 * @param id
	 *            树节点ID
	 * @param model
	 * @return
	 */
	@RequestMapping("/tree")
	@ResponseBody
	public List<TreeVo> tree(Long id, ModelMap model) {
		List<TreeVo> treeList = new ArrayList<TreeVo>();
		List<SysResource> menus = sysResourceService.childByParentId(id);
		if (null == menus || menus.size() < 1) {
			return null;
		}
		List<TreeVo> ctreeList = new ArrayList<TreeVo>();
		for (SysResource cmenu : menus) {
			TreeVo cvo = new TreeVo();
			Map<String, Object> cattributes = new HashMap<>();
			cvo.setId(cmenu.getId().toString());
			cvo.setParentId(id.toString());
			cvo.setText(cmenu.getResourceName());
			cvo.setIconcls(cmenu.getResourceLogo());
			cattributes.put("url", cmenu.getResourceUrl());
			cvo.setAttributes(cattributes);
			ctreeList.add(cvo);
			treeList.add(cvo);
		}

		return treeList;
	}
	
	@RequestMapping("/allTree")
	@ResponseBody
	public List<TreeVo> allTree(Integer id){
		
		
		List<TreeVo> treeList = new ArrayList<TreeVo>();
		
		if(null==id) {
			TreeVo rVo = new TreeVo();
			rVo.setId(0+"");
			rVo.setText("菜单管理");
			rVo.setState("open");
			List<SysResource> rootList = sysResourceService.rootTree();
			List<TreeVo> cVos = new ArrayList<>();
			if(null!=rootList&&rootList.size()>0) {
				rootList.forEach(resource ->{
					TreeVo vo = new TreeVo();
					vo.setId(resource.getId()+"");
					vo.setText(resource.getResourceName());
					vo.setState("closed");
					cVos.add(vo);
				});
			}
			rVo.setChildren(cVos);
			treeList.add(rVo);
			return treeList;
		}
		List<SysResource> childList = sysResourceService.childByParentId(Long.parseLong(id+""));
		if(null!=childList&&childList.size()>0) {
			childList.forEach(resource ->{
				TreeVo vo = new TreeVo();
				vo.setId(resource.getId()+"");
				vo.setText(resource.getResourceName());
				vo.setState("closed");
				treeList.add(vo);
			});
		}
		
		return treeList;
		
	}
	
	/**
	 * 添加导航
	 * @return
	 */
	@RequestMapping("/addip")
    public String addip(Long pid,ModelMap map) {
    	map.put("pid", pid);
    	return "system/resource/resource_add";
    }
	
	
	@RequestMapping("/add")
	@ResponseBody
	public Message add(SysResource sysResource) throws SQLException {
		if(null==sysResource) {
			return Message.error("数据异常，请重新提交！");
		}
		sysResource.setCreateTime(new Date());
		sysResource.setCreator("chen");
		sysResource.setUpdateTime(new Date());
		boolean flag  = sysResourceService.saveOrUpdate(sysResource);
		if(!flag) {
			return Message.error("菜单信息添加失败！");
		}
		return Message.success("菜单信息添加成功！");
	}
	
	
}








