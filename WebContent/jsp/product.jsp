<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/taglib/taglib.jsp" %>
 
 <ul class="product-list">
 		<s:iterator value="mobilePhones" var="phones">
			<li><div class="right">
					
				</div>
				<div class="left">
					<div class="image">
						<a
							href="${pageContext.request.contextPath}/<s:property value ="#phones.slug"/>"><img
							alt="Apple Cinema 30&quot;" title="Apple Cinema 30&quot;"
							src="${pageContext.request.contextPath}/images<s:property value='#phones.photoUrl.replace("\\\\","/")'/>"
							style="opacity: 1;"></a>
					</div>
					<div class="price">
						<span class="price-old">$119.50</span> <span class="price-new">$107.75</span>
						<br> <span class="price-tax">Ex Tax: $90.00</span>
					</div>
					<div class="name">
						<a href="${pageContext.request.contextPath}/phonedetail/<s:property value ="#phones.slug"/>">
							<s:property value="#phones.title"/>
						</a>
					</div>
					<div class="description"><s:property value="#phones.shortDesc"/></div>
				</div></li>

		</s:iterator> 
       
</ul>