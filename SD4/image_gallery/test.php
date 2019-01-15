<?php
	include 'formvarification.php';

	$delete_local = 'SELECT * FROM image_info WHERE image_id=23 and iowner="sakib19041996@gmail.com"';
	$delete_ifo = mysqli_query($link,$delete_local);
	$r = mysqli_fetch_array($delete_ifo,MYSQLI_ASSOC);
	$path = $r["ilocation"];

	if (!unlink($path)) {
		echo 'unsuccessfully to delete image physically';
	} else {
		echo  'Record deleted successfully';
	}	
?>