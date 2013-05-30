<%@ include file="/taglib/taglib.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

	<!--<meta name="viewport" content="initial-scale=1.0, width=device-width"/>-->
	<!--<base href="http://www.webiz.mu/themes/opencart/megastore/" /> -->
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="images/cart.png" rel="icon" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/stylesheet.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/jqpagination.css" />
	
 	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bvalidator.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bvalidator.theme.red.css" />


	<%--  <script src="${pageContext.request.contextPath}/js/jquery-1.7.1.min.js"></script>  --%>

	 <script src="${pageContext.request.contextPath}/js/jquery-1.9.1.min.js"></script> 
	<%-- <script src="${pageContext.request.contextPath}/js/jquery-ui-1.8.16.custom.min.js"></script> --%>
	 
	 
	  
 	<script src="${pageContext.request.contextPath}/js/jquery.bvalidator.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery.bvalidator-yc.js"></script> 
	
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery-ui-1.8.16.custom.css" />
	<script src="${pageContext.request.contextPath}/js/jquery.cookie.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery.colorbox.js"></script>
	<script src="${pageContext.request.contextPath}/js/cycle.js"></script>
	 <script src="${pageContext.request.contextPath}/js/flexslider.js"></script>
	<script src="${pageContext.request.contextPath}/js/custom.js"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/flexslider.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/colorbox.css" />
	
	<!--[if lt IE 9]>
	<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->
	
	<script src="${pageContext.request.contextPath}/js/common.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery.blockUI.js"></script>
	
	<script src="${pageContext.request.contextPath}/js/jquery.jqpagination.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery.jqpagination.min.js"></script>
	
	<style type="text/css">
	</style>
	<script type="text/javascript">
		var slideSpeed = 4000;
		var slideAnim = "slide"; 
	</script>
</head>

<body class="home">
<div id="fb-root"></div>
	<script>(function(d, s, id) {
		  var js, fjs = d.getElementsByTagName(s)[0];
		  if (d.getElementById(id)) return;
		  js = d.createElement(s); js.id = id;
		  js.src = "//connect.facebook.net/en_GB/all.js#xfbml=1";
		  fjs.parentNode.insertBefore(js, fjs);
		}(document, 'script', 'facebook-jssdk'));
	</script>

	<div id="container">
	   <tiles:insertAttribute name="header" />
	   
	   <tiles:insertAttribute name="menu" />
	   
	   
	<div id="notification"></div>
	   <div id="column-left">
	   			<tiles:insertAttribute name="sidebar" />
	   </div>
	   <div id="content"> 
	   		<tiles:insertAttribute name="body" />
	   </div>
	   	
	  
	   
	   <tiles:insertAttribute name="footer" />
	   
	</div>
	

</body>
</html>

