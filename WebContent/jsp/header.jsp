
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<div id="top">
	<div id="welcome">
		<p>
			Welcome visitor you can <a
				href="http://www.webiz.mu/themes/opencart/megastore/index.php?route=account/login">login</a>
			or <a
				href="http://www.webiz.mu/themes/opencart/megastore/index.php?route=account/register">create
				an account</a>.
		</p>
	</div>
	<ul class="links">
		<li class="phone"><span></span><a href="tel:123-456-789">123-456-789</a></li>
		<li><a
			href="http://www.webiz.mu/themes/opencart/megastore/index.php?route=account/account">My
				Account</a>
			<ul>
				<li><a
					href="http://www.webiz.mu/themes/opencart/megastore/index.php?route=account/wishlist"
					id="wishlist-total">Wish List (0)</a></li>
				<li><a
					href="http://www.webiz.mu/themes/opencart/megastore/index.php?route=checkout/cart">Shopping
						Cart</a></li>
				<li><a
					href="http://www.webiz.mu/themes/opencart/megastore/index.php?route=checkout/checkout">Checkout</a></li>
			</ul></li>
		<li class="lang"></li>
		<li class="curr"><a href="javascript:void(0);">Currency</a>
			<ul id="currency">
			</ul></li>
	</ul>
	<div class="clear"></div>
</div>


<header>
	<h1 id="logo">
		<a href="'${pageContext.request.contextPath}'/home.action"><img
			src="http://www.webiz.mu/themes/opencart/megastore/image/data/logo.jpg"
			title="MegaStore" alt="MegaStore" /></a>
	</h1>
	<div class="hshare">
		<span>Share:</span>
		<div class="fb-like"
			data-href="http://www.webiz.mu/themes/opencart/megastore"
			data-layout="button_count" data-width="350" data-show-faces="false"
			data-font="lucida grande"></div>

		<a href="https://twitter.com/share" class="twitter-share-button"
			data-url="http://www.webiz.mu/themes/opencart/megastore"
			data-dnt="true">Tweet</a>
		<script>!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0];if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src="//platform.twitter.com/widgets.js";fjs.parentNode.insertBefore(js,fjs);}}(document,"script","twitter-wjs");</script>

		<div class="pin-it-button">
			<a
				href="http://pinterest.com/pin/create/button/?url=http://www.webiz.mu/themes/opencart/megastore&media=http://www.webiz.mu/themes/opencart/megastore/image/data/logo.jpg&description=My Store"
				class="pin-it-button" count-layout="horizontal"><img border="0"
				src="//assets.pinterest.com/images/PinExt.png" title="Pin It" /></a>
		</div>
		<div class="clear"></div>
	</div>
	
	<div class="clear"></div>
</header>