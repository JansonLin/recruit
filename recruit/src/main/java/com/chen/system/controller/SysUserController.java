package com.chen.system.controller;

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
import com.chen.system.entity.SysRole;
import com.chen.system.entity.SysUser;
import com.chen.system.entity.SysUserRole;
import com.chen.system.entity.SysUserRoleExample;
import com.chen.system.service.SysRoleService;
import com.chen.system.service.SysUserRoleService;
import com.chen.system.service.SysUserService;
import com.github.pagehelper.PageInfo;

/**
 * 系统用户控制类
 * @author chencundeng
 * @version 1.0v 2018年3月14日
 */
@Controller
@RequestMapping("/system/sysUser")
public class SysUserController extends BaseController{
    
	@Autowired
	private SysUserService sysUserService;
	
	@Autowired
	private SysRoleService sysRoleService;
	
	@Autowired
	private SysUserRoleService sysUserRoleService;
	
	@RequestMapping("/main")
	public String main() {
		return "system/user/user_main";
	}
	
	@RequestMapping("/page")
	@ResponseBody
	public Page<SysUser> page(HttpServletRequest request, Integer page, Integer rows){
		
		Map<String, Object> map = new HashMap<>();
		if (null == page) {
			page = ConstantUtil.PAGE_NUMBER;
		}
		if (null == rows) {
			rows = ConstantUtil.PAGE_SIZE;
		}
		if(null!=request.getParameter("departId")) {
			map.put("departId", request.getParameter("departId"));
		}
		if(null!=request.getParameter("phone")) {
			map.put("phone", request.getParameter("phone"));
		}
		if(null!=request.getParameter("status")) {
			map.put("status", request.getParameter("status"));
		}
		if(null!=request.getParameter("userName")) {
			map.put("userName", request.getParameter("userName"));
		}
		
        Page<SysUser> userPage = new Page<>(); 		
		PageInfo<SysUser> users = sysUserService.page(page, rows, map);
		if(null!=users) {
			userPage.setRows(users.getList());
			userPage.setTotal(users.getTotal());
		}
		
		return userPage;
		
	}
	
	/**
	 * 用户所属角色列表
	 * @param userId
	 * @return
	 */
	@RequestMapping("/rolePage")
	@ResponseBody
	public Page<SysRole> rolePage(long userId){
		
		List<SysRole> list = sysRoleService.getUserRole(userId);
		if(null==list) {
			return null;
		}
		Page<SysRole> rolePage = new Page<>();
		rolePage.setRows(list);
		rolePage.setTotal(list.size());
		
		return rolePage;
		
	}
	
	
	@RequestMapping("/addip")
	public String addip(String departId,ModelMap map) {
		map.put("departId", departId);
		return "system/user/user_add";
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public Message add(HttpServletRequest request,long departId,Long[] roleIds,SysUser sysUser) {
		if(null==sysUser) {
			return Message.error("数据异常!");
		}
		SysUser user = admin(request);
		sysUser.setCreateTime(new Date());
		sysUser.setCreator(user.getUserName());
		sysUser.setUpdateTime(new Date());
		sysUser.setUpdator(user.getUserName());
		boolean flag = sysUserService.saveUserByDepartId(departId, sysUser,roleIds);
		if(!flag) {
			return Message.error("用户信息添加成功！");
		}
		return Message.success("用户信息添加成功！");
	}
	
	@RequestMapping("/editip")
	public String editip(long id,ModelMap map) {
		SysUser sysUser = sysUserService.find(id);
		map.put("sysUser", sysUser);
		return "system/user/user_edit";
	}
	
	@RequestMapping("/edit")
	@ResponseBody
	public Message edit(HttpServletRequest request,SysUser sysUser) {
		
		if(null==sysUser) {
			Message.error("数据异常，请重新提交！");
		}
		
		SysUser user = admin(request);
		sysUser.setUpdateTime(new Date());
		sysUser.setUpdator(user.getUserName());
		boolean flag = sysUserService.saveOrUpdate(sysUser);
		if(!flag) {
			Message.error("用户信息修改失败！");
		}
		
		return Message.success("用户信息修改成功！");
		
	}
	
	@RequestMapping("/userRoleEditip")
	public String userRoleEditip(String userId,String roleIds,ModelMap map) {
		map.put("roleIds", roleIds);
		map.put("userId", userId);
		return "system/user/user_role_edit";
	}
	
	@RequestMapping("/userRoleSave")
	@ResponseBody
	public Message userRoleSave(HttpServletRequest request,Long userId,Long[] roleIds) {
		
		if(null==userId||null==roleIds||roleIds.length<1) {
			return Message.error("数据异常，请重新提交！");
		}
		
		SysUser user = admin(request);
		
		for(int i=0;i<roleIds.length;i++) {
			SysUserRole sysUserRole = new SysUserRole();
			sysUserRole.setSysRoleId(roleIds[i]);
			sysUserRole.setSysUserId(userId);
			sysUserRole.setCreateTime(new Date());
			sysUserRole.setCreator(user.getUserName());
			sysUserRole.setUpdateTime(new Date());
			sysUserRole.setUpdator(user.getUserName());
		    sysUserRoleService.save(sysUserRole);
		}
	
		return Message.success("用户角色授权成功！");
		
	}
	
	@RequestMapping("/userRoleDelete")
	@ResponseBody
	public Message userRoleDelete(long userId,Long[] roleIds ) {
		
		if(null==roleIds||roleIds.length<1) {
			return Message.error("数据异常，请重新提交！");
		}
		
		List<Long> roleList = new ArrayList<Long>();
		for(int i=0;i<roleIds.length;i++) {
			roleList.add(roleIds[i]);
		}
		
		SysUserRoleExample example = new SysUserRoleExample();
		example.or().andSysUserIdEqualTo(userId).andSysRoleIdIn(roleList);
		boolean flag = sysUserRoleService.deletes(example);
		
		if(!flag) {
			Message.error("角色授权取消失败！");
		}
		
		return Message.success("角色授权取消成功！");
		
	}
	
}






