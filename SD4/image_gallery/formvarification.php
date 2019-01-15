<?php
	//session
	session_start();
	//vul likhsilam pore r change kora hoy nai > session_eamil )
	//sql connect
	$host = 'localhost';
	$database_username = 'root';
	$database_password = '';
	$database_name = 'photo_gallery';
	$link = mysqli_connect($host,$database_username,$database_password,$database_name);

	$error = '';
	$email = '';
	$password = '';

	$fname = '';
	$lname = '';
	$confirm_password = '';

	$contact_name = '';
	$contact_email = '';
	$comment = '';

	function clean_text($string) {
		$string = trim($string);
		$string = stripslashes($string);
		$string = htmlspecialchars($string);
		return $string;
	}

	function clean_view(){
		$error = '';
		$email = '';
		$password = '';
		$fname = '';
		$lname = '';
		$confirm_password = '';
		$contact_name = '';
		$contact_email = '';
		$comment = '';
	}

	//login check
	if(isset($_POST["login"])) {
		//login email field chek
		clean_view();

		if(empty($_POST["login_email"])) {
			$error .= 'Enter your Email.<br>';
		} else {
			$email = clean_text($_POST["login_email"]);

			if(!filter_var($email, FILTER_VALIDATE_EMAIL)) {
				$error .= 'Invalid email.<br>';
			}
		}

		//login password field
		if(empty($_POST["login_password"]))
		{
			$error .= 'Enter password.<br>';
		} else {
			$password = clean_text($_POST["login_password"]);
		}

		//if no error
		if($error == '') {

			$password = md5($password);
			
			$sqlfetchquery = 'SELECT * FROM userinfo WHERE email="'.$email.'" AND password="'.$password.'"';

			$result = mysqli_query($link,$sqlfetchquery) or die(mysqli_error());

			$noOfData = mysqli_num_rows($result);

			if ($noOfData == 1){
				
				$_SESSION["session_eamil"] = $email;
				header("Location: http://localhost/image_gallery/myindex.php");
				clean_view();
			}
			else
				$error .= 'user nmae or password does not matche.<br>';
		}
	}

	//sign up
	if (isset($_POST["sign_up"])) {
		//first name field check
		clean_view();

		if(empty($_POST["first_name"])) {
			$error .= 'Please Enter your Name.<br>';
		} else {
			$fname = clean_text($_POST["first_name"]);
		 	if(!preg_match("/^[a-zA-Z_ ]*$/",$fname)) {
				$error .= 'Only letters , white	space and underscore allowed in name.<br>';
			}
		}

		//last name field check
		if(empty($_POST["last_name"])) {
			$error .= 'Please Enter your Name.<br>';
		} else {
			$lname = clean_text($_POST["last_name"]);
		 	if(!preg_match("/^[a-zA-Z_ ]*$/",$lname)) {
				$error .= 'Only letters , white	space and underscore allowed in name.<br>';
			}
		}

		//login email field chek
		if(empty($_POST["signup_email"])) {
			$error .= 'Please Enter your Email.<br>';
		} else {
			$email = clean_text($_POST["signup_email"]);

			if(!filter_var($email, FILTER_VALIDATE_EMAIL)) {
				$error .= 'Invalid email.<br>';
			}
		}

		//login password field
		if(empty($_POST["signup_password"]) || empty($_POST["signup_confirm_password"]))
		{
			$error .= 'Please enter all password.<br>';
		} else {
			$password = clean_text($_POST["signup_password"]);
			$confirm_password = clean_text($_POST["signup_confirm_password"]);
		}

		//if no error and pass matches
		if ($error == '' && $password == $confirm_password) {
			$_SESSION["session_eamil"] = $email;

			$password = md5(clean_text($_POST["signup_password"]));
			$sqlinsertquery = 'INSERT INTO userinfo (fname, lname, email, password)
							VALUES("'.$fname.'","'.$lname.'","'.$email.'","'.$password.'")';
			
			$sqlinsert = mysqli_query($link, $sqlinsertquery) or die(mysqli_error());
			clean_view();
			header("Location: http://localhost/image_gallery/myindex.php");
		} else if (!empty($_POST["signup_password"]) && !empty($_POST["signup_confirm_password"])){
			$error .= 'password does not match.<br>';
		}
	}

	//contact
	if (isset($_POST["contact_send"])) {
		//contact name field chek
		clean_view();
		
		if(empty($_POST["contact_name"])) {
			$error .= 'Please Enter your Name.<br>';
		} else {
			$contact_name = clean_text($_POST["contact_name"]);
		 	if(!preg_match("/^[a-zA-Z_ ]*$/",$contact_name)) {
				$error .= 'Only letters , white	space and underscore allowed in name.<br>';
			}
		}

		//contact email field chek
		if(empty($_POST["contact_email"])) {
			$error .= 'Please Enter your Email.<br>';
		} else {
			$contact_email = clean_text($_POST["contact_email"]);

			if(!filter_var($contact_email, FILTER_VALIDATE_EMAIL)) {
				$error .= 'Invalid email.<br>';
			}
		}

		// contact comment
		if (empty($_POST["comment"])) {
			$error .= 'Type your comment.<br>';
		} else {
			$comment = clean_text($_POST["comment"]);

			$sqlinsertquery = 'INSERT INTO report (name,email, comments)
							VALUES("'.$contact_name.'","'.$contact_email.'","'.$comment.'")';
			
			$sqlinsert = mysqli_query($link, $sqlinsertquery) or die(mysql_error());
			clean_view();
		}
	}
	//sql connection ends
	//mysqli_close($link);
?>