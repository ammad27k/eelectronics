<%@ include file="/taglib/taglib.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

    <div class="box">
  <div class="box-heading"><h2>Categories</h2></div>
  <div class="category-content">
    <div class="box-category">
      	<ul>
      		<s:if test="#session.sidebarMenu != null">
		      <s:iterator value="#session.sidebarMenu" var="brands">
		 			     <li>
		 			     	<a href="${pageContext.request.contextPath}/phones/<s:property value="#brands.slug"/><s:property value="#brands.id"/>"><s:property value="#brands.title" /> <span class='dropdown'>+</span></a>
		 			     </li>
			  </s:iterator>
			</s:if>
        </ul>
    </div>
   
  </div>
</div>
    <div class="box">
  <div class="box-heading"><h2>Latest Products</h2></div>
  <div class="box-content">
    <ul class="box-product">
            <li>
                <div class="image"><a href="http://www.webiz.mu/themes/opencart/megastore/index.php?route=product/product&amp;product_id=49"><img src="http://www.webiz.mu/themes/opencart/megastore/image/cache/data/galaxy_tab_3-166x120.jpg" alt="Samsung Galaxy Tab 10.1" /></a></div>
                <div class="name"><a href="http://www.webiz.mu/themes/opencart/megastore/index.php?route=product/product&amp;product_id=49">Samsung Galaxy Tab 10.1</a></div>
                <div class="price">
                    $236.99                  </div>
                      </li>
            <li>
                <div class="image"><a href="http://www.webiz.mu/themes/opencart/megastore/index.php?route=product/product&amp;product_id=48"><img src="http://www.webiz.mu/themes/opencart/megastore/image/cache/data/demo/ipod_classic_1-166x120.jpg" alt="iPod Classic" /></a></div>
                <div class="name"><a href="http://www.webiz.mu/themes/opencart/megastore/index.php?route=product/product&amp;product_id=48">iPod Classic</a></div>
                <div class="price">
                    $119.50                  </div>
                      </li>
            <li>
                <div class="image"><a href="http://www.webiz.mu/themes/opencart/megastore/index.php?route=product/product&amp;product_id=47"><img src="http://www.webiz.mu/themes/opencart/megastore/image/cache/data/img1-166x120.jpg" alt="HP LP3065" /></a></div>
                <div class="name"><a href="http://www.webiz.mu/themes/opencart/megastore/index.php?route=product/product&amp;product_id=47">HP LP3065</a></div>
                <div class="price">
                    $119.50                  </div>
                      </li>
            <li>
                <div class="image"><a href="http://www.webiz.mu/themes/opencart/megastore/index.php?route=product/product&amp;product_id=46"><img src="http://www.webiz.mu/themes/opencart/megastore/image/cache/data/img2-166x120.jpg" alt="Sony VAIO" /></a></div>
                <div class="name"><a href="http://www.webiz.mu/themes/opencart/megastore/index.php?route=product/product&amp;product_id=46">Sony VAIO</a></div>
                <div class="price">
                    $1,177.00                  </div>
                      </li>
            <li>
                <div class="image"><a href="http://www.webiz.mu/themes/opencart/megastore/index.php?route=product/product&amp;product_id=45"><img src="http://www.webiz.mu/themes/opencart/megastore/image/cache/data/demo/macbook_pro_1-166x120.jpg" alt="MacBook Pro" /></a></div>
                <div class="name"><a href="http://www.webiz.mu/themes/opencart/megastore/index.php?route=product/product&amp;product_id=45">MacBook Pro</a></div>
                <div class="price">
                    $2,000.00                  </div>
                      </li>
          </ul>
  </div>

</div>
      
 
