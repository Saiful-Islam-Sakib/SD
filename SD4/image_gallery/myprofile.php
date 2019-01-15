<?php 
	include 'login_user_check.php';

	//info generator
	$info_username = 'SELECT * FROM userinfo WHERE email ="'.$_SESSION["session_eamil"].'"';
	$info_username_result = mysqli_query($link,$info_username) or die(mysqli_error());
	$row = mysqli_fetch_assoc($info_username_result);

	$fname = $row["fname"];
	$lname = $row["lname"];
	$email = $row["email"];

	$error1 = '';
	$error2 = '';

	if (isset($_POST["save_info"])) {
		clean_view();

		if(empty($_POST["first_name"])) {
			$error1 .= 'Please Enter your Name.<br>';
		} else {
			$fname = clean_text($_POST["first_name"]);
		 	if(!preg_match("/^[a-zA-Z_ ]*$/",$fname)) {
				$error1 .= 'Only letters , white	space and underscore allowed in name.<br>';
			}
		}

		//last name field check
		if(empty($_POST["last_name"])) {
			$error1 .= 'Please Enter your Name.<br>';
		} else {
			$lname = clean_text($_POST["last_name"]);
		 	if(!preg_match("/^[a-zA-Z_ ]*$/",$lname)) {
				$error1 .= 'Only letters , white	space and underscore allowed in name.<br>';
			}
		}

		//login email field chek
		if(empty($_POST["signup_email"])) {
			$error1 .= 'Please Enter your Email.<br>';
		} else {
			$email = clean_text($_POST["signup_email"]);

			if(!filter_var($email, FILTER_VALIDATE_EMAIL)) {
				$error1 .= 'Invalid email.<br>';
			}
		}

		if ($error1 == '') {
			$sql = 'UPDATE userinfo SET fname="'.$fname.'", lname="'.$lname.'", email="'.$email.'" WHERE email="'.$_SESSION["session_eamil"].'"';

			if (mysqli_query($link, $sql)) {
				$error1 = 'Thank you';
			}
			else {
				$error1 .= mysqli_error($link).'<br>';
			}
		}
	} else if (isset($_POST["save_pass"])) {
		if(empty($_POST["signup_password"]) || empty($_POST["signup_confirm_password"]))
		{
			$error2 .= 'Please enter all password.<br>';
		} else {
			$password = clean_text($_POST["signup_password"]);
			$confirm_password = clean_text($_POST["signup_confirm_password"]);
		}

		if ($error2 == '') {
			$sql = 'SELECT * FROM userinfo WHERE email="'.$_SESSION["session_eamil"].'"';
			$row_pass = mysqli_query($link, $sql) or die(mysqli_error());
			$result_array = mysqli_fetch_assoc($row_pass);
			if (md5($_POST["signup_password"]) == $result_array["password"]) {
				$sql = 'UPDATE userinfo SET password ="'.md5($_POST["signup_confirm_password"]).'" WHERE email="'.$_SESSION["session_eamil"].'"';

				if (mysqli_query($link, $sql)) {
					$error2 = 'Thank you';
				}
				else {
					$error2 .= mysqli_error($link).'<br>';
				}
			} else {
				$error2 .= 'Retype old password<br>';
			}
		}
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
		.well {
			border-color: black;
            background-color: rgba(0,0,0,0.5);
        }
	</style>
</head>
<body style="background-color:#2c3e50;">
	<!--header-->
	<?php include 'header.php'; ?>

	<!--sidebar-->
	<div class="container">
		<div class="row">
			<!--information-->
			<div class="col-md-3" style="background-color: white; margin: 1%; border-radius: 5px;">
				<h1 align="center">My Profile</h1>
				<p align="center">
					<img src="images/user_image/1.png" class="img-circle img-thumbnail" alt="user image" style="width: 40%; height: 100px;">
				</p>
				<hr>
				<p>
					<h5>
						<i class="glyphicon glyphicon-user"></i> 
						<?php echo $row["fname"]. ' '. $row["lname"]; ?> 
					</h5>
				</p>
				<p>
					<h5>
						<i class="glyphicon glyphicon-envelope"></i>
						<?php echo $row["email"]; ?>
					</h5>
				</p>
				<hr>
				<p>	
					<h4><i class="glyphicon glyphicon-picture"></i> Collection info : </h4>
					<p>
						<h5><i class="glyphicon glyphicon-share-alt"></i> Total Uploaded: <span class="label label-info">
							<?php 
								$total = 'SELECT COUNT(image_id) FROM image_info WHERE iowner ="'.$_SESSION["session_eamil"].'"';
								$collection_query = mysqli_query($link, $total) or die(mysqli_error());
								$row = mysqli_fetch_assoc($collection_query);
								echo $row["COUNT(image_id)"];
							?>
						</span></h5>
					</p>
					<p>
						<h5><i class="glyphicon glyphicon-share-alt"></i> Shared: <span class="label label-info">
							<?php 
								$shared = 'SELECT COUNT(image_id) FROM image_info WHERE iowner ="'.$_SESSION["session_eamil"].'"'.'and istatus ='.'0';
								$collection_query = mysqli_query($link, $shared) or die(mysqli_error());
								$row = mysqli_fetch_assoc($collection_query);
								echo $row["COUNT(image_id)"];
							?>
						</span></h5>
					</p>
					<p>
						<h5><i class="glyphicon glyphicon-share-alt"></i> Private: <span class="label label-info">
							<?php 
								$personal = 'SELECT COUNT(image_id) FROM image_info WHERE iowner ="'.$_SESSION["session_eamil"].'"'.'and istatus ='.'1';
								$collection_query = mysqli_query($link, $personal) or die(mysqli_error());
								$row = mysqli_fetch_assoc($collection_query);
								echo $row["COUNT(image_id)"];
							?>
						</span></h5>
					</p>
				</p>
			</div>
			
			<!--edit information-->
			<div class="col-md-8" style="background-color: white; margin: 1%; border-radius: 5px;">
				<form action="" method="post" class="signup-form" style="margin: 10px 150px 10px 150px;">
					<div class="row" align="center">
						<h1>Edit information</h1>
						<h6>**Chnage the field you want and keep the rest as it is</h6>
					</div>

					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label for="first_name">First Name:</label>
								<div class="input-group">
									<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
									<input type="text" name="first_name" class="form-control" placeholder="first nmae" value="<?php echo $fname ?>">
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label for="last_name">Last Name:</label>
								<div class="input-group">
									<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
									<input type="text" name="last_name" class="form-control"  placeholder="last name" value="<?php echo $lname ?>">
								</div>
							</div>
						</div>
					</div>

					<div class="form-group">
						<label for="email">Email address:</label>
						<div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
							<input type="email" name="signup_email" class="form-control"  placeholder="email" value="<?php echo $email ?>">
						</div>
					</div>
					<div class="form-group" align="right">
						<button type="submit" name="save_info" class="btn btn-warning" style="color: black;">
							Save
							<span class="glyphicon glyphicon-send"></span>
						</button>
					</div>
					
					<div class="row" align="center">
						<h1>Change Password : </h1>
					</div>
					
					<div class="form-group">
						<label for="password">Old Passworde:</label>
						<div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-pencil"></i></span>
							<input type="password" name="signup_password" class="form-control" placeholder="old password">
						</div>
					</div>
					<div class="form-group">
						<label for="confirm_password">New Password:</label>
						<div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-pencil"></i></span>
							<input type="password" name="signup_confirm_password" class="form-control" placeholder="new password">
						</div>
					</div>
					<div class="form-group" align="right">
						<button type="submit" name="save_pass" class="btn btn-warning" style="color: black;">
							Save
							<span class="glyphicon glyphicon-send"></span>
						</button>
					</div>
					<div style="color: red;">
						<?php 
							if ($error1 != '' && isset($_POST["save_info"])) {
								echo '** '.$error1;
							} else if ($error2 != '' && isset($_POST["save_pass"])) {
								echo '** '.$error2;
							}
						?>
					</div>
				</form>
			</div>
		</div>
	</div>
	
	<!--footer-->
	<?php include 'footer.php'; ?>

	<!--javaQuer-->
	<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
	<!--javaScript-->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
