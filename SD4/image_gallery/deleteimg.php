<?php 
	include 'login_user_check.php';
	//info generator
	$info_username = 'SELECT * FROM userinfo WHERE email ="'.$_SESSION["session_eamil"].'"';
	$info_username_result = mysqli_query($link,$info_username) or die(mysqli_error());
	$row = mysqli_fetch_assoc($info_username_result);

	$fname = $row["fname"];
	$lname = $row["lname"];
	$email = $row["email"];

	$updatestat = 0;
	$updateerror = '';
	$id = 0;
	$iname = '';
	$imgstatus = 0;

	if (isset($_POST["delete"]) || isset($_POST["save"])) {
		if (empty($_POST["image_id"])) {
			$updateerror .= 'enter an image id<br>';
			$updatestat = 0;
		} else {
			if (is_numeric($_POST["image_id"]) && is_int($_POST["image_id"])) {
				$id = (int)clean_text($_POST["image_id"]);
			} else {
				$updateerror .= 'Id is noninteger, enter a valid one<br>';
				$updatestat = 0;
			}
		}
		
		if (empty($_POST["image_name"])) {
			$updateerror .= 'enter an image name<br>';
			$updatestat = 0;
		} else {
			$iname = clean_text($_POST["image_name"]);
		}

		if (isset($_POST["privacy_option"]) && $_POST["privacy_option"] == 'private') {
			$imgstatus = '1';
		}

		if ($updateerror == '') {
			/*delete file from database*/
			if (isset($_POST["delete"])) {
				$sql = 'DELETE FROM image_info WHERE image_id='.$id.' and iname="'.$iname.'" and iowner="'.$_SESSION["session_eamil"].'"';
				if (mysqli_query($link, $sql)) {
					/*delete img from local folder */
					/*$sql2 = 'SELECT * FROM image_info WHERE image_id='.$id.' and iowner="'.$_SESSION["session_eamil"].'"';
					$rslt2 = mysqli_query($link,$sql2);
					$row2 = mysqli_fetch_array($rslt2,MYSQLI_ASSOC);
					$path = $row2["ilocation"];

					if (!unlink($path)) {
						$updateerror .= 'unsuccessfully to delete image physically';
					} else {
						$updateerror .= 'Record deleted successfully';
						$updatestat = 1;
					}*/
					$updateerror .= 'Record deleted successfully<br>';
					$updatestat = 1;
				} else {
					$updateerror .= 'unsuccessfully to delete image<br>';
				}
			}

			if (isset($_POST["save"])) {
				$sql = 'UPDATE image_info SET istatus="'.$imgstatus.'" WHERE image_id='.$id.' and iname="'.$iname.'" and iowner ="'.$_SESSION["session_eamil"].'"';
				if (mysqli_query($link, $sql)) {
					$updateerror .= 'Record update successfully<br>';
					$updatestat = 1;
				} else {
					$updateerror .= 'update unsuccessfully<br>';
				}
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
	<div class="container" style="margin-bottom: 50px;">
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
			<div class="col-md-8" style="background-color: white; margin: 1%; border-radius: 5px; height: 410px;">
				<form action="" method="post" class="signup-form" style="margin: 10px 150px 10px 150px;">
					<div class="row" align="center">
						<h1>Delete or Update Image</h1>
					</div>

					<div class="form-group">
						<label for="iamge_id">Id:</label>
						<div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-pencil"></i></span>
							<input type="text" name="image_id" class="form-control" placeholder="number before '.' from image caption">
						</div>
					</div>
					<div class="form-group">
						<label for="image_name">Image Name:</label>
						<div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-pencil"></i></span>
							<input type="text" name="image_name" class="form-control"  placeholder="name after '.' from image caption">
						</div>
					</div>

					<div class="form-group" align="right">
						<button type="submit" name="delete" class="btn btn-warning" style="color: black;">
							Delete
							<span class="glyphicon glyphicon glyphicon-erase"></span>
						</button>
					</div>
					
					<div class="form-group">
						<div class="radio">
							<label><input type="radio" name="privacy_option" value="public" checked>Public</label>
						</div>
						<div class="radio">
							<label><input type="radio" name="privacy_option" value="private">Private</label>
						</div>
					</div>

					<div class="form-group" align="right">
						<button type="submit" name="save" class="btn btn-warning" style="color: black;">
							Save
							<span class="glyphicon glyphicon-send"></span>
						</button>
					</div>

					<?php 
					if (isset($_POST["delete"]) || isset($_POST["save"])) {
						if ($updatestat == 1) {
							echo '<div style="color: green;">** '.$updateerror.'</div>';
							echo '<a href="album.php">My collection</a>';
						} else if ($updatestat == 0) {
							echo '<div style="color: red;">** '.$updateerror.'</div>';
						}
					}
					?>
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
