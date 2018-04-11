package com.chen.system.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chen.common.util.Message;
import com.chen.common.util.Page;
import com.chen.common.vo.TreeVo;
import com.chen.system.entity.SysResource;
import com.chen.system.entity.SysRole;
import com.chen.system.entity.SysRoleExample;
import com.chen.system.entity.SysUser;
import com.chen.system.service.SysResourceService;
import com.chen.system.service.SysRoleService;
import com.github.pagehelper.PageInfo;

/**
 * @ClassName: SysRoleController
 * @Description:TODO 角色信息controller类
 * @author:chencundeng
 * @date: 2018年4月9日 下午4:56:38
 * @Copyright: 2018 www.chen.com Inc. All rights reserved.
 */
@RequestMapping("/system/sysRole")
@Controller
public class SysRoleController extends BaseController {

	@Autowired
	private SysRoleService sysRoleService;

	@Autowired
	private SysResourceService sysResourceService;

	@RequestMapping("/main")
	public String main() {
		return "system/role/role_main";
	}

	@RequestMapping("/page")
	@ResponseBody
	public Page<SysRole> page(HttpServletRequest request, Integer page, Integer rows) {

		SysRoleExample example = new SysRoleExample();
		if (null != request.getParameter("roleName") && !"".equals(request.getParameter("roleName"))) {
			example.or().andRoleNameLike(request.getParameter("roleName"));
		}
		if (null != request.getParameter("status") && !"".equals(request.getParameter("status"))) {
			example.or().andStatusEqualTo(Byte.parseByte(request.getParameter("status")));
		}

		Page<SysRole> rolePages = new Page<>();
		PageInfo<SysRole> roles = sysRoleService.page(page, rows, example);
		if (null != roles) {
			rolePages.setRows(roles.getList());
			rolePages.setTotal(roles.getTotal());
		}

		return rolePages;

	}

	@RequestMapping("/addip")
	public String addip() {
		return "system/role/role_add";
	}

	@RequestMapping("/add")
	@ResponseBody
	public Message add(HttpServletRequest request, SysRole sysRole) {

		if (null == sysRole) {
			return Message.error("数据异常，请重新提交");
		}

		SysUser user = admin(request);
		sysRole.setCreateTime(new Date());
		sysRole.setCreator(user.getUserName());
		sysRole.setUpdateTime(new Date());
		sysRole.setUpdator(user.getUserName());
		boolean flag = sysRoleService.saveOrUpdate(sysRole);
		if (!flag) {
			return Message.error("角色信息添加失败！");
		}

		return Message.success("角色信息添加成功！");

	}

	@RequestMapping("/editip")
	public String editip(Long id, ModelMap map) {
		SysRole sysRole = sysRoleService.find(id);
		map.put("sysRole", sysRole);
		return "system/role/role_edit";
	}

	@RequestMapping("/edit")
	@ResponseBody
	public Message edit(HttpServletRequest request, SysRole sysRole) {

		if (null == sysRole) {
			return Message.error("数据异常，请重新提交");
		}

		SysUser user = admin(request);
		sysRole.setUpdator(user.getUserName());
		sysRole.setUpdateTime(user.getUpdateTime());
		boolean flag = sysRoleService.saveOrUpdate(sysRole);
		if (!flag) {
			return Message.error("角色信息修改失败！");
		}

		return Message.success("角色信息修改成功！");

	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public Message delete(Long[] ids) {
		
		if(null==ids||ids.length<1) {
			return Message.error("数据异常，请重新提交！");
		}
		List<Long> idList = new ArrayList<>();
		for(int i=0;i<ids.length;i++) {
			idList.add(ids[i]);
		}
		boolean flag = sysRoleService.deletes(idList);
		if(!flag) {
			return Message.error("角色信息删除失败！");
		}
		return Message.success("角色信息删除成功！");
		
	}
	

	/**
	 * 权限树同步加载
	 * 
	 * @param id
	 * @param roleId
	 * @return
	 */
	@RequestMapping("/limitTree")
	@ResponseBody
	public List<TreeVo> limitTree(Long roleId) {

		List<TreeVo> treeList = new ArrayList<TreeVo>();

		if (null != roleId) {

			SysRole sysRole = sysRoleService.find(roleId);
			String limits = sysRole.getLimits();

			TreeVo rVo = new TreeVo();
			rVo.setId(0 + "");
			rVo.setText("蜗牛人才");
			rVo.setState("open");
			List<SysResource> rootList = sysResourceService.rootTree();
			List<TreeVo> cVos = new ArrayList<>();
			if (null != rootList && rootList.size() > 0) {
				rootList.forEach(resource -> {
					TreeVo vo = new TreeVo();
					vo.setId(resource.getId() + "");
					vo.setText(resource.getResourceName());
					vo.setState("open");
					vo.setChecked(compareLimit(limits, resource.getId()));
					List<TreeVo> chilidList = childTree(limits, resource.getId());
					if (null != chilidList && chilidList.size() > 0) {
						vo.setChildren(chilidList);
					}
					cVos.add(vo);
				});
			}
			rVo.setChildren(cVos);
			treeList.add(rVo);
			return treeList;
		}

		TreeVo rVo = new TreeVo();
		rVo.setId(0 + "");
		rVo.setText("蜗牛人才");
		rVo.setState("open");
		List<SysResource> rootList = sysResourceService.rootTree();
		List<TreeVo> cVos = new ArrayList<>();
		if (null != rootList && rootList.size() > 0) {
			rootList.forEach(resource -> {
				TreeVo vo = new TreeVo();
				vo.setId(resource.getId() + "");
				vo.setText(resource.getResourceName());
				vo.setState("open");
				List<TreeVo> chilidList = childTree(null, resource.getId());
				if (null != chilidList && chilidList.size() > 0) {
					vo.setChildren(chilidList);
				}
				cVos.add(vo);
			});
		}
		rVo.setChildren(cVos);
		treeList.add(rVo);
		return treeList;

	}

	public List<TreeVo> childTree(String limits, Long parentId) {
		List<TreeVo> treeList = new ArrayList<TreeVo>();
		List<SysResource> list = sysResourceService.childByParentId(parentId);
		if (null != list && list.size() > 0) {
			list.forEach(resource -> {
				TreeVo vo = new TreeVo();
				vo.setId(resource.getId() + "");
				vo.setText(resource.getResourceName());
				if (null != limits) {
					vo.setChecked(compareLimit(limits, resource.getId()));
				}
				vo.setState("open");
				List<TreeVo> chilidList = childTree(limits, resource.getId());
				if (null != chilidList && chilidList.size() > 0) {
					vo.setChildren(chilidList);
				}
				treeList.add(vo);
			});
		}
		return treeList;
	}

	/**
	 * 判断是否有某菜单权限
	 * 
	 * @param limit
	 * @param resourceId
	 * @return
	 */
	public boolean compareLimit(String limits, Long resourceId) {

		boolean flag = false;

		String[] limit = null;
		if (null == limits || limits.length() < 1) {
			return flag;
		}
		limit = limits.split(",");
		if (null != limit && null != resourceId) {
			for (int i = 0; i < limit.length; i++) {
				if (limit[i].equals(resourceId.toString())) {
					flag = true;
				}
			}
		}

		return flag;

	}

}
