<!DOCTYPE html>
<html>
	<head>
	<title>Ευστάθιος Ιωσηφίδης - iis21027</title>
</head>
    <body>
		<h1>Ευστάθιος Ιωσηφίδης - iis21027</h1>
		<br>
        <a href="showall.php"> Παρουσίαση </a><br>
        <a href="into.php"> Εισαγωγή </a><br>
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
	
	// Create database
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
		name VARCHAR(50) NOT NULL,
      		email VARCHAR(50)
	)";
	
	if (mysqli_query($conn, $sql)) {
		echo "Table $tabname created successfully <br>";
	} else {
	 	echo "Error creating table: " . mysqli_error($conn) . "<br>";
	}

	mysqli_close($conn);

	

?> 
