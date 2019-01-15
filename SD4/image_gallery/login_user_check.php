<?php 
	include 'formvarification.php';

	$logedin_user = '';

	if (isset($_SESSION["session_eamil"])) {
		$sqlusernamequery = 'SELECT lname FROM userinfo WHERE email="'.$_SESSION["session_eamil"].'"';
		$sqlusername = mysqli_query($link,$sqlusernamequery) or die(mysqli_error());
		
		$row = mysqli_fetch_assoc($sqlusername);
		$logedin_user = $row["lname"];
	} else {
		header("Location: http://localhost/image_gallery/index.php");
	}

	if ($_SERVER['QUERY_STRING'] == 4){
        session_destroy();
        header("Location: http://localhost/image_gallery/index.php");
    }
?>