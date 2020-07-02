<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<aside class="main-sidebar">
	<!-- sidebar: style can be found in sidebar.less -->
	<section class="sidebar">
		<!-- Sidebar user panel -->
		<div class="user-panel">
			<div class="pull-left image">
				<img src="${pageContext.request.contextPath}/img/user2-160x160.jpg"
					class="img-circle" alt="User Image">
			</div>
			<div class="pull-left info">
				<p>${loginName}</p>
				<a href="#"><i class="fa fa-circle text-success"></i> 员工</a>
			</div>
		</div>

		<!-- sidebar menu: : style can be found in sidebar.less -->
		<ul class="sidebar-menu">
			<li class="header">菜单</li>
			<li id="admin-index"><a
				href="${pageContext.request.contextPath}/pages1/staff-main.jsp"><i
					class="fa fa-dashboard"></i> <span>首页</span></a></li>

			<li class="treeview"><a href="#"> <i class="fa fa-cogs"></i>
					<span>员工管理</span> <span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>


			</a>
				<ul class="treeview-menu">

					<li id="system-setting"><a
						href="${pageContext.request.contextPath}/staffTaskListServlet"> <i
							class="fa fa-circle-o"></i> 计划管理
					</a></li>
					<li id="system-setting"><a
						href="${pageContext.request.contextPath}/staffLookBeforeServlet"> <i
							class="fa fa-circle-o"></i> 查询计划
					</a></li>
					<li id="system-setting"><a
							href="${pageContext.request.contextPath}/staffPlanListServlet"> <i
							class="fa fa-circle-o"></i> 计划列表
					</a></li>
				</ul></li>
		</ul>
	</section>
	<!-- /.sidebar -->
</aside>