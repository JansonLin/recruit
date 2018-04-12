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

import com.chen.common.util.Message;
import com.chen.common.util.Page;
import com.chen.common.vo.TreeVo;
import com.chen.system.entity.SysDepart;
import com.chen.system.entity.SysDepartExample;
import com.chen.system.entity.SysRole;
import com.chen.system.service.SysDepartService;
import com.github.pagehelper.PageInfo;

/**
 * @ClassName:  SysDepart   
 * @Description:TODO 内部用户组织架构查询、增加、修改、删除 
 * @author:chencundeng 
 * @date:   2018年4月2日 下午4:18:26       
 * @Copyright: 2018 www.chen.com Inc. All rights reserved.
 */
@Controller
@RequestMapping("/system/sysDepart")
public class SysDepartController {
   
	@Autowired
	private SysDepartService sysDepartService;
	
	@RequestMapping("/main")
	public String main() {
		return "system/depart/depart_main";
	}
	
	
	@RequestMapping("/page")
	@ResponseBody
	public Page<SysDepart> page(HttpServletRequest request, Integer page, Integer rows){
		
		String parentCode = request.getParameter("parentCode");
		SysDepartExample sysDepartExample = new SysDepartExample();
		sysDepartExample.or().andParentDepartCodeEqualTo(parentCode);
		PageInfo<SysDepart> departs = sysDepartService.page(page, rows, sysDepartExample);
        
		if(null==departs) {
			return null;
		}
		
		Page<SysDepart> departPage = new Page<>();
		departPage.setRows(departs.getList());
		departPage.setTotal(departs.getTotal());
		
		return departPage;
	
	}
    
	@RequestMapping("/rolePage")
	@ResponseBody
	public Page<SysRole> rolePage(HttpServletRequest request, Integer page, Integer rows){
		return null;
	}
	
	@RequestMapping("/tree")
	@ResponseBody
	public List<TreeVo> tree(String id){
		
		if(null==id) {  //初始化,记载第一第二组织
			List<TreeVo> treeList = new ArrayList<>();
			List<SysDepart> rList = sysDepartService.findByLevel((byte)1);	
			if(null!=rList) {
				rList.forEach(rDepart ->{
					TreeVo vo = new TreeVo();
					vo.setId(rDepart.getDepartCode());
					vo.setText(rDepart.getDepartName());
					vo.setState("open");
					Map<String, Object>  attributes = new HashMap<>();
					attributes.put("departId", rDepart.getId());
					vo.setAttributes(attributes);
					List<TreeVo> cTree = childTree(rDepart.getDepartCode());
					vo.setChildren(cTree);
					treeList.add(vo);
				});
			}
			return treeList;
		}
		
		List<TreeVo> treeList = new ArrayList<>();
		treeList = childTree(id);
		
		return treeList;
		
	}
	
	/**
	 * 根据父节点编码获子级组织信息列表
	 * @param parentCode
	 * @return
	 */
	public List<TreeVo> childTree(String parentCode){
		List<TreeVo> vos = new ArrayList<>();
		List<SysDepart> cList = sysDepartService.childByParentCode(parentCode);
		if(null!=cList&&cList.size()>0) {
			cList.forEach(depart ->{
				TreeVo vo = new TreeVo();
				vo.setId(depart.getDepartCode());
				vo.setText(depart.getDepartName());
				vo.setState("closed");
				Map<String, Object>  attributes = new HashMap<>();
				attributes.put("departId", depart.getId());
				vo.setAttributes(attributes);
				vos.add(vo);
			});
		}
		return vos;
	}
	
	
	@RequestMapping("/addip")
	public String addip(String parentCode,ModelMap map) {
		map.put("parentCode", parentCode);
		return "system/depart/depart_add";
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public Message add(SysDepart depart) throws SQLException {
		
		if(null==depart) {
			return Message.error("数据异常，请重新添加！");
		}
		
		SysDepart parentDepart = sysDepartService.findByCode(depart.getParentDepartCode());
        if(null==parentDepart) {
        	return Message.error("数据异常，请重新添加！");
        }
		
        //判断部门编码是否存在
        boolean flag = sysDepartService.existByCode(depart.getDepartCode()); 
		if(flag) {
			return Message.error("组织编码已经存在，请重新输入！");
		}
        
		depart.setParentDepartName(parentDepart.getDepartName());
		depart.setCreator("chen");
		depart.setCreateTime(new Date());
		depart.setUpdateTime(new Date());
		depart.setUpdator("chen");
		depart.setDepartLevel((byte)(parentDepart.getDepartLevel()+1));
		
		boolean saveFlag = sysDepartService.saveOrUpdate(depart);
		
		if(!saveFlag) {
			return Message.error("组织数据添加失败！");
		}
		
		return Message.success("组织数据添加成功！");
	}
	
	@RequestMapping("/empowerip")
	public String empowerip() {
		return "system/depart/role_empower";
	}
	
	
}










