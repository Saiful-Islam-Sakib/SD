<?php
	include'formvarification.php';

	if (isset($_SESSION["session_eamil"])) {
		header("Location: http://localhost/image_gallery/myindex.php");
	}
?>
<!DOCTYPE html>
<html>
<head>
	<title>Photo_Gallery</title>
	<meta charset="utf-8">
  	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="css/mycss.css">
	<!-- Latest compiled and minified CSS & JS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

	<style>
		.affix {
			top: 0;
			width: 100%;
			z-index: 9999;
		}
		.well {
			border-color: black;
            background-color: rgba(0,0,0,0.5);
        }
	</style>

</head>
<body style="background-color: #2c3e50;">
	<!--navbar-->
	<!--<nav class="navbar navbar-inverse" data-spy="affix" style="background-color: rgba(0,0,0,0.8);">-->
	<nav class="navbar navbar-inverse" style="background-color: rgba(0,0,0,0.8); margin: 0%">
		<div class="container">
			<!--logo-->
    		<div class="navbar-header">
      			<a href="index.php"><img src="images/photo_galley_logo.png" class="navbar-brand" alt="PG_logo"></a>
    		</div>
    		<!--options-->
    		<div>
    			<ul class="nav navbar-nav">
		    		<li class="active"><a href="index.php">Home</a></li>
		    		<li><a href="#aboutsite">About</a></li>
		    		<li><a href="#devcontact">Contact</a></li>
    			</ul>
    		</div>
    		
    		<!--email & password for login-->
    		<form class="navbar-form navbar-right" action=""  method = "post">
    			<div class="form-group">
    				<input type="email" name="login_email" class="form-control" placeholder="email">
    				<input type="password" name="login_password" class="form-control" placeholder="password">
    				<input type="submit" name="login" value="Login" class="loginbutton">
    				<div style="color: red;">
    					<?php 
    						if ($error != '' && isset($_POST["login"])) {
    							echo '** '.$error;
    						} 
    					?>
    				</div>
    			</div>
    		</form>

    		<!--sign in-->
    		<div>
    			<ul class="nav navbar-nav navbar-right">
    				<li><a href="#register"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
		    	</ul>
    		</div>
  		</div>
	</nav>
	
	<!--image slide show-->
	<div class="container" style="width: 100%; padding: 0">
		<div id="myCarousel" class="carousel slide" data-ride="carousel" data-interval="3000">
			<!--dots-->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
				<li data-target="#myCarousel" data-slide-to="3"></li>
				<li data-target="#myCarousel" data-slide-to="4"></li>
				<li data-target="#myCarousel" data-slide-to="5"></li>
			</ol>
			
			<div class="carousel-inner">
				<div class="item active">
					<img src="images/homepage_slideshow/0.jpg" alt="0" style="width: 100%; height: 80%;">
					<div class="carousel-caption slideShow-caption" style="margin-bottom: 60px;">
						<h2><u><i>Photo Gallery</i></u></h2>
						<hr>
						<p>Your Moment, Our Collection</p>
					</div>
				</div>
				<div class="item">
					<img src="images/homepage_slideshow/1.jpg" alt="1" style="width: 100%; height: 80%;">
					<div class="carousel-caption slideShow-caption" style="margin-bottom: 60px">
						<h2><u><i>Photo Gallery</i></u></h2>
						<hr>
						<p>Your Moment, Our Collection</p>
					</div>
				</div>
				<div class="item">
					<img src="images/homepage_slideshow/2.jpg" alt="2" style="width: 100%; height: 80%;">
					<div class="carousel-caption slideShow-caption" style="margin-bottom: 60px">
						<h2><u><i>Photo Gallery</i></u></h2>
						<hr>
						<p>Your Moment, Our Collection</p>
					</div>
				</div>
				<div class="item">
					<img src="images/homepage_slideshow/3.jpg" alt="3" style="width: 100%; height: 80%;">
					<div class="carousel-caption slideShow-caption" style="margin-bottom: 60px">
						<h2><u><i>Photo Gallery</i></u></h2>
						<hr>
						<p>Your Moment, Our Collection</p>
					</div>
				</div>
				<div class="item">
					<img src="images/homepage_slideshow/4.jpg" alt="4" style="width: 100%; height: 80%;">
					<div class="carousel-caption slideShow-caption" style="margin-bottom: 60px">
						<h2><u><i>Photo Gallery</i></u></h2>
						<hr>
						<p>Your Moment, Our Collection</p>
					</div>
				</div>
				<div class="item">
					<img src="images/homepage_slideshow/5.jpg" alt="5" style="width: 100%; height: 80%;">
					<div class="carousel-caption slideShow-caption" style="margin-bottom: 60px">
						<h2><u><i>Photo Gallery</i></u></h2>
						<hr>
						<p>Your Moment, Our Collection</p>
					</div>
				</div>
			</div>
			<!--prev & nex-->
			<a class="left carousel-control" href="#myCarousel" data-slide="prev">
				<span class="glyphicon glyphicon-chevron-left"></span>
				<span class="sr-only">Previous</span>
			</a>
			<a class="right carousel-control" href="#myCarousel" data-slide="next">
				<span class="glyphicon glyphicon-chevron-right"></span>
				<span class="sr-only">Next</span>
			</a>
		</div>
	</div>
	
	<!--sign up-->
	<div id="register" class="container" style="background-image: url(images/sign_up.jpg); width: 100%; height: 600px; padding-top: 3%;">
		<form action="" method="post" class="container well well-sm signup-form" style="background-color:rgba(0, 0, 0, 0.5);color: white; width: 25%;">
			<div class="row" align="center">
				<h1>Sign Up</h1>
			</div>

			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<label for="first_name">First Name:</label>
						<div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
							<input type="text" name="first_name" class="form-control" placeholder="first nmae">
						</div>
					</div>
				</div>
				<div class="col-md-6">
					<div class="form-group">
						<label for="last_name">Last Name:</label>
						<div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
							<input type="text" name="last_name" class="form-control"  placeholder="last name">
						</div>
					</div>
				</div>
			</div>

			<div class="form-group">
				<label for="email">Email address:</label>
				<div class="input-group">
					<span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
					<input type="email" name="signup_email" class="form-control"  placeholder="email">
				</div>
			</div>
			<div class="form-group">
				<label for="password">Password:</label>
				<div class="input-group">
					<span class="input-group-addon"><i class="glyphicon glyphicon-pencil"></i></span>
					<input type="password" name="signup_password" class="form-control" placeholder="password">
				</div>
			</div>
			<div class="form-group">
				<label for="confirm_password">Confirm Password:</label>
				<div class="input-group">
					<span class="input-group-addon"><i class="glyphicon glyphicon-pencil"></i></span>
					<input type="password" name="signup_confirm_password" class="form-control" placeholder="retype password">
				</div>
			</div>
			<div class="form-group" align="right">
				<button type="submit" name="sign_up" class="btn btn-warning" style="color: black;">
					Sign up
					<span class="glyphicon glyphicon-send"></span>
				</button>
			</div>
			<div style="color: red;">
   				<?php if ($error != '' && isset($_POST["sign_up"])) {
    				echo '** '.$error;
    			} ?>
    		</div>
		</form>
	</div>
	<!--footer  & contact with us-->
	<div class="container text-left" style="width: 100%; color: white;">
		<div id="aboutsite" class="row well well-sm" style="padding: 1%;">
			<div class="col-md-4">
				<h3><i class="fa fa-angellist" style="font-size:36px"></i> About</h3>
				<hr align="left" width="50%">
				<p>
					The site contains various kind of <br>pictures from many places.
					<br>You can create your own collection also.
					<br>have fun.
				</p>
			</div>

			<div id="devcontact" class="col-md-4">
				<h3><i class="fa fa-address-book" style="font-size:36px"></i> Contact Info</h3>
				<hr align="left" width="50%">
				<ul class="list-unstyled">
					<li><p><i class="fa fa-home"></i>  Dhaka Cantonment, Dhaka-1206</p></li>
					<li><p><i class="fa fa-envelope"></i>  photogallery@gmail.com</p></li>
					<li><p><i class="fa fa-phone"></i>  + 88 017 XXX XXX XX</p></li>
					<li><p><i class="fa fa-print"></i>  + 88 017 XXX XXX XX</p></li>
				</ul>
			</div>
			<!--contact form-->
			<div class="col-md-4">
				<form action="" method="post" class="signup-form" style="color: white;">
					<div class="row" align="center">
						<h1>Contact</h1>
						<hr>
					</div>
					<div class="form-group">
						<label for="last_name">Name: </label>
						<div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
							<input type="text" class="form-control" name="contact_name"  placeholder="Name">
						</div>
					</div>
					<div class="form-group">
						<label for="email">Email address:</label>
						<div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
							<input type="email" class="form-control" name="contact_email" placeholder="email">
						</div>
					</div>
					<div class="form-group">
						<label for="comment">Comment:</label>
						<div class="input-group">
							<textarea class="form-control" name="comment" rows="5" cols="80" style="border-radius: 4px" placeholder="write here within 70 characters"></textarea>
						</div>
					</div>
					<div class="form-group" align="right">
						<button type="submit" class="btn btn-warning" name="contact_send" style="color: black;">
							Send
							<span class="glyphicon glyphicon-send"></span>
						</button>
					</div>
    				<?php
    					if ($error != '' && isset($_POST["contact_send"])) {
    						echo '<div style="color: red;">**'.$error.'</div>';
    					} else if (isset($_POST["contact_send"])){
    						echo '<div style="color: green;">** Thanks You.</div>';
    					} 
    				?>
				</form>
			</div>
			<hr class="footer-hr">
			<div class="row text-center" style="font-size: 1.5em;">
				&copy 2010-<?php echo date("Y");?>
				<a href="index.php">photogallery.com</a>
			</div>
		</div>
	</div>

	<!--javaQuer-->
	<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
	<!--javaScript-->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>