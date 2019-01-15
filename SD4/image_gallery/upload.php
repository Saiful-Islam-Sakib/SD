<?php 
	include 'login_user_check.php';
	
	date_default_timezone_set( "Asia/Dhaka" );

	$uploader = $_SESSION["session_eamil"];
	$privacy = '0';
	$upload_error = '';
	$uploadOk = 0;

	if(isset($_POST["upload_send"]) && $_POST["image_name"] != '' && !empty($_FILES["file_location"])) {
		$file_name = clean_text($_POST["image_name"]);
		$target_dir = "uploads/";
		$target_file = $target_dir .$file_name. basename($_FILES["file_location"]["name"]);
		$temp_target = $_FILES["file_location"]["tmp_name"];

		$imageFileType = strtolower(pathinfo($target_file,PATHINFO_EXTENSION));
		// Check if image file is a actual image or fake image
		$check = getimagesize($temp_target);
		if($check !== false) {
			$uploadOk = 1;
		} else {
			$upload_error .= "File is not an image.<br>";
			$uploadOk = 0;
		}
		// Check if file already exists
		if (file_exists($target_file)) {
			$upload_error .= "Sorry, file already exists.<br>";
			$uploadOk = 0;
		}
		// Check file size
		if ($_FILES["file_location"]["size"] > 10000000) {
			$upload_error .= "Sorry, your file is too large.<br>";
			$uploadOk = 0;
		}
		// Allow certain file formats
		if($imageFileType != "jpg" && $imageFileType != "png" && $imageFileType != "jpeg" ) {
			$upload_error .= "Sorry, only JPG, JPEG, PNG files are allowed.<br>";
			$uploadOk = 0;
		}
		// Check if $uploadOk is set to 0 by an error
		if ($uploadOk == 0) {
			$upload_error .= "Sorry, your file was not uploaded.<br>";
		// if everything is ok, try to upload file
		} else if (move_uploaded_file($temp_target, $target_file)) {
			//status of the image
			if (isset($_POST["privacy_option"]) && $_POST["privacy_option"] == 'private') {
				$privacy = '1';
			}
			
			//insert onto database
			$sqlinsertquery = 'INSERT INTO image_info (iname, ilocation, iowner, istatus) VALUES("'.$file_name.'","'.$target_file.'","'.$uploader.'","'.$privacy.'")';
			$link = mysqli_connect($host,$database_username,$database_password,$database_name);
			$sqlinsert = mysqli_query($link, $sqlinsertquery) or die(mysqli_error($link));

			$upload_error .= "The file has been uploaded.<br>";
		} else {
			$upload_error .= "Sorry, there was an error uploading your file.<br>";
		}
	} else {
		$upload_error .= 'fill all the information in the form<br>';
		$uploadOk = 0;
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
	
	<!--upload-->
	<div class="container" style="background-color: white; margin-bottom: 20px; border-radius: 5px;">
		<form method="post" enctype="multipart/form-data" style="margin: 0 auto; width: 500px;">
			<div class="row" align="center">
				<h1>Upload your Image</h1>
				<hr>
			</div>
			<div class="form-group">
				<label for="image_name">Image File Name: </label>
				<div class="input-group">
					<span class="input-group-addon"><i class="glyphicon glyphicon-italic"></i></span>
					<input type="text" class="form-control" name="image_name"  placeholder="image title">
				</div>
			</div>
			<div class="form-group">
				<label for="flocation">Browse image :</label>
				<div class="input-group">
					<span class="input-group-addon"><i class="glyphicon glyphicon-picture"></i></span>
					<input type="file" class="form-control" name="file_location">
				</div>
			</div>
			<div class="form-group">
				<label>Privacy : (** you can change it latter)</label>
				<div class="radio">
					<label><input type="radio" name="privacy_option" value="public" checked>Public</label>
				</div>
				<div></div>
				<div class="radio">
					<label><input type="radio" name="privacy_option" value="private">Private</label>
				</div>
			</div>
			<?php 
				if (isset($_POST["upload_send"])) {
					if ($uploadOk == 1) {
						echo '<div style="color: green;">** '.$upload_error.'</div>';
						echo '<a href="album.php">My collection</a>';
					} else if ($uploadOk == 0) {
						echo '<div style="color: red;">** '.$upload_error.'</div>';
					}
				}
			?>
			<div class="form-group" align="right">
				<button type="submit" class="btn btn-warning" name="upload_send" style="color: black;">
					Upload
					<span class="glyphicon glyphicon-upload"></span>
				</button>
			</div>
		</form>
	</div>
	
	<!--footer-->
	<?php include 'footer.php'; ?>

	<!--javaQuer-->
	<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
	<!--javaScript-->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>