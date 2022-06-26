<?php
		/* Attempt MySQL server connection. Assuming you are running MySQL
		server with default setting (user 'root' with no password) */
		$servername = "localhost";
		$username = "root";
		$password = "";

		$link = mysqli_connect($servername, $username, $password);
		 
		// Check connection
		if($link === false){
			die("ERROR: Could not connect. " . mysqli_connect_error());
		}
		 
		// Attempt create database query execution
		$sql = "CREATE DATABASE iis21027";
		if(mysqli_query($link, $sql)){
			echo "Database created successfully <br>";
		} else{
			echo "ERROR: Could not able to execute $sql. " . mysqli_error($link);
		}

		$dbname = "iis21027";
		// Create connection
		$link = new mysqli($servername, $username, $password, $dbname);
		// Check connection
		if ($link->connect_error) {
			die("<br> Connection failed: " . $link->connect_error);
		} 

		 // sql to create table
		$sql1 = "CREATE TABLE iis21027 (
			id INT(50) NOT NULL, 
			names VARCHAR(50) NOT NULL,
      		website VARCHAR(50)
		)";

		if ($link->query($sql1) === TRUE) {
			echo "<br> Table iis21027 created successfully";
		} else {
			echo " <br> Error creating table: " . $link->error;
		}


		// Close connection
		mysqli_close($link);


		 

		?>

<!DOCTYPE html>
<html>
<head>
    <title>iis21027</title>
	<link rel="stylesheet" href="iis21027.css"/>
	<meta charset="utf-8">
    <meta name="description" content="Web Development - September 2021 - PHP">

    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1.0, maximum-scale=1.0, minimal-ui">
</head>
<body>
<nav>
<ul class="myPages">
		<li class="page"><a href="show.php">Εμφάνιση</a></li>
		<li class="page"><a href="set.php">Καταχώρηση</a></li>
    	<li class="page"><a href="pick.php">Διαλογή</a></li>
		</ul>
</nav>


</body>
</html>
