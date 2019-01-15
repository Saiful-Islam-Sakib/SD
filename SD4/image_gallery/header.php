<?php
	echo '
		<nav class="navbar navbar-inverse" style="background-color: rgba(0,0,0,0.8);">
		<!--header-->
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
			
			<!--droup down menue-->
    		<div>
    			<ul class="nav navbar-nav navbar-right">
    				<li class="dropdown dropdown-menu-right dropd">
    					<a class="dropdown-toggle" data-toggle="dropdown" href="#option"><span class="	fa fa-user-circle" style="font-size:24px;"></span> '.$logedin_user.' <span class="caret"></span></a>
   						<ul class="dropdown-menu">
    						<li><a href="myprofile.php">My Profile</a></li>
    						<li><a href="album.php">My collection</a></li>
    						<li><a href="upload.php">Upload</a></li>
    						<li class="divider"></li>
    						<li><a href="?4" name="link1">Log out</a></li>
    					</ul>
    				</li>
    			</ul>
    		</div>
  		</div>
	</nav>
	';
?>