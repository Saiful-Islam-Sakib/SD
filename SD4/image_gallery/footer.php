<?php
	echo '
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
							<input type="text" class="form-control" name="contact_name"  placeholder="Name" value="'.$logedin_user.'">
						</div>
					</div>
					<div class="form-group">
						<label for="email">Email address:</label>
						<div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
							<input type="email" class="form-control" name="contact_email" placeholder="email" value="'.$_SESSION["session_eamil"].'">
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
					</div>';
    				
					if ($error != '' && isset($_POST["contact_send"])) {
						echo '<div style="color: red;">**'.$error.'</div>';
					} else if (isset($_POST["contact_send"])){
						echo '<div style="color: green;">** Thanks You.</div>';
					} 
    echo '
				</form>
			</div>
			<hr class="footer-hr">
			<div class="row text-center" style="font-size: 1.5em;">
				&copy 2010-'.date("Y").'
				<a href="index.php">photogallery.com</a>
			</div>
		</div>
	</div>
	';
?>