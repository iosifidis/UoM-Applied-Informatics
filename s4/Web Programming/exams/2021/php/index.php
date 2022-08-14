<!DOCTYPE html>
<html>
<head>
	<head>
	<title>Ευστάθιος Ιωσηφίδης - iis21027</title>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1.0, maximum-scale=1.0, minimal-ui">
</head>
    <body>
		<h1>Ευστάθιος Ιωσηφίδης - iis21027</h1>
		<br>
	

<ul>
	<li><a href="show.php">Εμφάνιση</a></li>
	<li><a href="set.php">Καταχώρηση</a></li>
    	<li><a href="pick.php">Διαλογή</a></li>
</ul>


</body>
</html>

<?php

		$servername = "localhost";
		$username = "root";
		$password = "";
		$dbname = "iis21027";
		$tabname = "iis21027";

		// Create connection
		$conn = mysqli_connect($servername, $username, $password);
		 
		// Check connection
		if (!$conn) {
    			die("Connection failed: " . mysqli_connect_error());
		}
		 
		// Attempt create database query execution
		$sql = "CREATE DATABASE IF NOT EXISTS $dbname";

	 	if (mysqli_query($conn, $sql)) {
	 		echo "Database created successfully <br>";
	 	} else {
	 		echo "Error creating database: " . mysqli_error($conn) . "<br>";

		}

		mysqli_close($conn);
	
		$conn = mysqli_connect($servername, $username, $password, $dbname);


	// Check connection
	if (!$conn) {
		die("Connection failed: " . mysqli_connect_error());
	}

	// sql to create table
	$sql = "CREATE TABLE IF NOT EXISTS $tabname (
		id INT(5), 
		name VARCHAR(50) NOT NULL,
      		website VARCHAR(50) NOT NULL
	)";
	
	if (mysqli_query($conn, $sql)) {
		echo "Table $tabname created successfully <br>";
	} else {
	 	echo "Error creating table: " . mysqli_error($conn) . "<br>";
	}

	mysqli_close($conn);
		 

		?>

