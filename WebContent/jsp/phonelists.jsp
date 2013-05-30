<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/taglib/taglib.jsp" %>

 
  <div class="box-heading"><h1><s:property value="#attr.brand"/></h1></div>
    <div class="category-info">
        <div class="image"><img alt="Desktops" src="http://www.webiz.mu/themes/opencart/megastore/image/cache/data/demo/compaq_presario-170x118.jpg"></div>
            <p>
				Example of category description text
			</p>
      </div>
      <div class="refine-search">
  <h2>Refine Search</h2>
  <div class="category-list">
        <ul>
            <li><a href="http://www.webiz.mu/themes/opencart/megastore/index.php?route=product/category&amp;path=20_26">PC</a></li>
            <li><a href="http://www.webiz.mu/themes/opencart/megastore/index.php?route=product/category&amp;path=20_27">Mac</a></li>
          </ul>
      </div>
  </div>
  

	
      <div class="product-filter">
    <div class="display"><b>Display:</b> List <b>/</b> <a onclick="display('grid');">Grid</a></div>
    
    <div class="gigantic pagination">
			    <a href="#" class="first" data-action="first">&laquo;</a>
			    <a href="#" class="previous" data-action="previous">&lsaquo;</a>
			    <input type="text" readonly="readonly" />
			    <a href="#" class="last" data-action="last">&raquo;</a>
			    <a href="#" class="next" data-action="next">&rsaquo;</a>
	</div>
	
    <div class="limit"><b>Show:</b>
      <select onchange="getMobilePhoneById('${pageContext.request.contextPath}/phonesByAjax/<s:property value='#attr.fancyurl'/>',this.value)" id="slimit">
                        <option selected="selected" value="5">5</option>
                                <option value="10">10</option>
                                <option value="20">20</option>
                                <option value="30">30</option>
                                <option value="40">40</option>
                      </select>
    </div>
    <div class="sort"><b>Sort By:</b>
      <select onchange="location = this.value;">
                        <option selected="selected" value="http://www.webiz.mu/themes/opencart/megastore/index.php?route=product/category&amp;path=20&amp;sort=p.sort_order&amp;order=ASC">Default</option>
                                <option value="http://www.webiz.mu/themes/opencart/megastore/index.php?route=product/category&amp;path=20&amp;sort=pd.name&amp;order=ASC">Name (A - Z)</option>
                                <option value="http://www.webiz.mu/themes/opencart/megastore/index.php?route=product/category&amp;path=20&amp;sort=pd.name&amp;order=DESC">Name (Z - A)</option>
                                <option value="http://www.webiz.mu/themes/opencart/megastore/index.php?route=product/category&amp;path=20&amp;sort=p.price&amp;order=ASC">Price (Low &gt; High)</option>
                                <option value="http://www.webiz.mu/themes/opencart/megastore/index.php?route=product/category&amp;path=20&amp;sort=p.price&amp;order=DESC">Price (High &gt; Low)</option>
                                <option value="http://www.webiz.mu/themes/opencart/megastore/index.php?route=product/category&amp;path=20&amp;sort=rating&amp;order=DESC">Rating (Highest)</option>
                                <option value="http://www.webiz.mu/themes/opencart/megastore/index.php?route=product/category&amp;path=20&amp;sort=rating&amp;order=ASC">Rating (Lowest)</option>
                                <option value="http://www.webiz.mu/themes/opencart/megastore/index.php?route=product/category&amp;path=20&amp;sort=p.model&amp;order=ASC">Model (A - Z)</option>
                                <option value="http://www.webiz.mu/themes/opencart/megastore/index.php?route=product/category&amp;path=20&amp;sort=p.model&amp;order=DESC">Model (Z - A)</option>
                      </select>
    </div>
    <!-- <div class="product-compare" ><a id="compare-total" href="http://www.webiz.mu/themes/opencart/megastore/index.php?route=product/compare">Product Compare (0)</a></div> -->
  </div>
  	<div class='product'>
		<jsp:include page="product.jsp"></jsp:include>
   	</div>
 
    
 <script type="text/javascript"><!--
 
 var jpag ;
function display(view) {
	if (view == 'list') {
		$('.product-grid').attr('class', 'product-list');
		
		$('.product-list > li').each(function(index, element) {
			html  = '<div class="right">';
			html += '</div>';			
			
			html += '<div class="left">';
			
			var image = $(element).find('.image').html();
			
			if (image != null) { 
				html += '<div class="image">' + image + '</div>';
			}
			
			var price = $(element).find('.price').html();
			
			if (price != null) {
				html += '<div class="price">' + price  + '</div>';
			}
					
			html += '  <div class="name">' + $(element).find('.name').html() + '</div>';
			html += '  <div class="description">' + $(element).find('.description').html() + '</div>';
			
			var rating = $(element).find('.rating').html();
			
			if (rating != null) {
				html += '<div class="rating">' + rating + '</div>';
			}
				
			html += '</div>';	
						
			$(element).html(html);
		});		
		
		$('.display').html('<b>Display:</b> List <b>/</b> <a onclick="display(\'grid\');">Grid</a>');
		
		$.cookie('display', 'list'); 
	} else {
		$('.product-list').attr('class', 'product-grid');
		
		$('.product-grid > li').each(function(index, element) {
			html = '';
			
			var image = $(element).find('.image').html();
			
			if (image != null) {
				html += '<div class="image">' + image + '</div>';
			}
			
			html += '<div class="name">' + $(element).find('.name').html() + '</div>';
			html += '<div class="description">' + $(element).find('.description').html() + '</div>';
			
			var price = $(element).find('.price').html();
			
			if (price != null) {
				html += '<div class="price">' + price  + '</div>';
			}
			
			var rating = $(element).find('.rating').html();
			
			if (rating != null) {
				html += '<div class="rating">' + rating + '</div>';
			}
			
			$(element).html(html);
		});	
					
		$('.display').html('<b>Display:</b> <a onclick="display(\'list\');">List</a> <b>/</b> Grid');
		
		$.cookie('display', 'grid');
	}
}

view = $.cookie('display');

if (view) {
	display(view);
} else {
	display('list');
}
//-->

$(document).ready(function() {
	    var pages = '<s:property value="noOfPages" escape="false"/>';
	    var noOfPages = pages/ $('#slimit option:selected').val();
	    $('.pagination').jqPagination({
			link_string	: '/?page={page_number}',
			max_page	: Math.ceil(noOfPages),
			paged		: function(page) {
				
				var link = '${pageContext.request.contextPath}/phonesByPagination/<s:property value='#attr.fancyurl'/>';
				var limit = $('#slimit option:selected').val();
				
				var start = page == 1 ? 0:(page * $('#slimit option:selected').val())-$('#slimit option:selected').val();
				var end  = page * 10;
				
				if(!block){
				$('.product').block({ message: null}); 
				$.post(link,{'limit':limit,'start':start,'end':end},function(data,status){
					$('.product').unblock();
					$('.product').html(data);

					view = $.cookie('display');
					if (view) {
						display(view);
					} else {
						display('list');
					}
					
				 
				}); }
			}
		});
	   
	});
	

function getMobilePhoneById(url,limit) {
	
	$('#slimit option:selected').removeAttr('selected');
	 	$('.product').block({ message: null }); 
		$.post(url,{'limit':limit},function(data,status){
			
			$('.product').unblock(); 
			
			$('.product').html(data);
			$("#slimit option[value=" + limit +"]").attr("selected","selected") ;
			
			pages = '<s:property value="noOfPages" escape="false"/>';
			noOfPages = pages/ $('#slimit option:selected').val();
			
			view = $.cookie('display');
			if (view) {
				display(view);
			} else {
				display('list');
			}
			block = true;
			jObj.setMaxPages(Math.ceil(noOfPages));
			
		});
}

</script>      