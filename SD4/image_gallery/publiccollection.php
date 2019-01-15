<?php 
	include 'login_user_check.php';

	$per_page = 8;

	$sqlquery = 'SELECT * FROM image_info WHERE iowner="'.$_SESSION["session_eamil"].'" and istatus="0"';
	$result = mysqli_query($link,$sqlquery) or die(mysqli_error());
	$total_number_of_images = mysqli_num_rows($result);

	$page_num = ceil($total_number_of_images / $per_page);

	$first = 0;
	$last = 0;
	$current_page = 0;

	if (isset($_GET['page'])) {
		$current_page = $_GET['page'];
		$last = $current_page * $per_page;
		$first = $last - $per_page;
	}

	function activate($i){
		if (isset($_GET['page']) and $i == $_GET['page']) {
			return "active";
		}else {
			return "";
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
	<?php include 'header.php'; ?>
	
	<!--sidebar option-->
	<div>
		<div class="row">
			<div class="col-md-2">
				<div class="sidenav">
					<a href="album.php">All Photos</a>
					<hr>
					<a href="publiccollection.php">Public Photos</a>
					<hr>
					<a href="privatecollection.php">Private Photos</a>
					<hr>
					<a href="deleteimg.php">Delete / Update Photo</a>
				</div>
			</div>
			<div class="col-md-10">
				<!--paging-->
				<div class="container" style="text-align: center;">
					<div class="pagination">
						<?php
							echo '<a href="publiccollection.php?page=1"><<</a>';
							for ($i=1; $i <= $page_num; $i++) { 
								echo '<a class="'.activate($i).'" href="publiccollection.php?page='.$i.'">'.$i.'</a>';
							}
							echo '<a href="publiccollection.php?page='.$page_num.'">>></a>';
						?>
					</div>
				</div>

				<!--showing image-->
				<div style="margin-left: 2%; margin-right: 2%;">
					<div class="row">
						<?php
							$sqlquery = 'SELECT * FROM image_info WHERE iowner="'.$_SESSION["session_eamil"].'" and istatus="0"'.'LIMIT '.$first.','.$per_page;
							if (mysqli_query($link,$sqlquery)) {
								$result = mysqli_query($link,$sqlquery);
							} else {
								echo '
								<h1> NO IMAGE UPLOADED YET</h1>
								';
							}

							while ($row = mysqli_fetch_assoc($result)) {
								echo '
								<div class="col-md-3">
									<a class="thumbnail" href="#">
										<img class="img-responsive" src="'.$row["ilocation"].'" style="height:250px; width:100%;">
										<div class="caption" align="center">
											<i><b>'.$row["image_id"].'.'.$row["iname"].'</b></i>
										</div>
									</a>
								</div>
								';
							}
						?>
					</div>
				</div>
				<div class="modal fade" role ="dialog" id="zoom">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-body">
								<img src="" id="model-img" height = "100%" width ="100%">
							</div>
						</div>
					</div>
				</div>
				
				<!--paging-->
				<div class="container" style="text-align: center;">
					<div class="pagination">
						<?php
							echo '<a href="publiccollection.php?page=1"><<</a>';
							for ($i=1; $i <= $page_num; $i++) { 
								echo '<a class="'.activate($i).'" href="publiccollection.php?page='.$i.'">'.$i.'</a>';
							}
							echo '<a href="publiccollection.php?page='.$page_num.'">>></a>';
						?>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--footer-->
	<?php include 'footer.php'; ?>
	<!--javaQuer-->
	<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
	<!--javaScript-->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<!--my script-->
	<script>
		$(document).ready( function(){
			$('img').on('click',function(){
				var src=$(this).attr('src');
    			$("#model-img").attr('src',src);
    			$("#zoom").modal('show');
			});
		});
	</script>
</body>
</html>