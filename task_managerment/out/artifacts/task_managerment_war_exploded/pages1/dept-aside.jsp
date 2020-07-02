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
				<a href="#"><i class="fa fa-circle text-success"></i> 主管</a>
			</div>
		</div>

		<!-- sidebar menu: : style can be found in sidebar.less -->
		<ul class="sidebar-menu">
			<li class="header">菜单</li>
			<li id="admin-index"><a
				href="${pageContext.request.contextPath}/pages1/dept-main.jsp"><i
					class="fa fa-dashboard"></i> <span>首页</span></a></li>

			<li class="treeview"><a href="#"> <i class="fa fa-cogs"></i>
					<span>任务管理</span> <span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>


			</a>
				<ul class="treeview-menu">

					<li id="system-setting"><a
						href="${pageContext.request.contextPath}/deptTaskListServlet"> <i
							class="fa fa-circle-o"></i> 查看任务
					</a></li>
					<li id="system-setting"><a
						href="${pageContext.request.contextPath}/deptTaskAddBeforeServlet"> <i
							class="fa fa-circle-o"></i> 制订任务
					</a></li>
					<li id="system-setting"><a
						href="${pageContext.request.contextPath}/deptAdjustListServlet">
							<i class="fa fa-circle-o"></i> 调整任务
					</a></li>
					
					<li id="system-setting"><a
						href="${pageContext.request.contextPath}/deptTaskFollowListServlet">
							<i class="fa fa-circle-o"></i> 跟踪任务
					</a></li>
				</ul></li>
				<li id="admin-index"><a
				href="${pageContext.request.contextPath}/deptUserServlet"><i
					class="fa fa-dashboard"></i> <span>查询员工</span></a></li>
		</ul>
	</section>
	<!-- /.sidebar -->
</aside>