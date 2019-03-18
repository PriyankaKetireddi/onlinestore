<div class="container">
	<!--bread crumb  -->
	<div class="row">

		<div class="col-xs-12">
			<ol class="breadcrumb">
				<li><a href="${contextRoot}/home">Home</a></li>
				<li><a href="${contextRoot}/show/all/products">Products</a></li>
				<li><a href="active">${product.name}</li>

			</ol>
		</div>
	</div>



	<div class="row">
		<!--Display product image  -->
		<div class="col-xs-12 col-sm-4">

			<div class="thumnail">

				<img src="${images}/${product.code}.png" class="img img-responsive" />
			</div>
		</div>

		<!--Display product description  -->

		<div class="col-xs-12 col-sm-8">

			<h3>${product.name}</h3>
			</hr>

			<p>${product.description}</p>
			</hr>
			<h4>
				Price:<strong>&#8377; ${product.unitPrice } /-</strong>
			</h4>
			<h6>Qty. Available: ${product.quantity}</h6>
			<c:choose>
				<c:when test="${product.quantity < 1}">

					<h6>
						Qty. Available: <span style="color: red">Out of Stock!!</span>
					</h6>
				</c:when>

				<c:otherwise>
					<h6>Qty. Available: ${product.quantity}</h6>
				</c:otherwise>
			</c:choose>

			<c:choose>
				<c:when test="${product.quantity < 1}">
					<p>
						<a href="javascript:void(0)" class="btn btn-success disabled"><strike><span
								class="glyphicon glyphicon-shopping-cart">AddToCart</span></strike></a>
					</p>
				</c:when>
				<c:otherwise>
					<p>
						<a href="${contextRoot}/cart/add/${product.id}/product"
							class="btn btn-warning"><span
							class="glyphicon glyphicon-shopping-cart">AddToCart</span></a>
					</p>
				</c:otherwise>
			</c:choose>

			<p>
				<a href="${contextRoot}/show/all/products" class="btn btn-success">Back</a>
			</p>



		</div>
	</div>

</div>
