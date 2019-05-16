/**
 * 2019年5月11日下午2:20:27
 * @author 许威
 * @Desc
 */
package com.jt.lawfirm.bean.system;

/**
 * 2019年5月11日下午2:20:27
 * @author 许威
 * @Desc 
 */
public class System_Role_Permission {
	private Integer id;
	private Integer roleId;
	private Integer permissionId;
	public System_Role_Permission(Integer roleId, Integer permissionId) {
		super();
		this.roleId = roleId;
		this.permissionId = permissionId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public Integer getPermissionId() {
		return permissionId;
	}
	public void setPermissionId(Integer permissionId) {
		this.permissionId = permissionId;
	}
	@Override
	public String toString() {
		return "System_Role_Permission [id=" + id + ", roleId=" + roleId + ", permissionId=" + permissionId + "]";
	}
}
