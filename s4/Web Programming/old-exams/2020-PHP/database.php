
<?php
	$servername = "localhost";
	$username = "root";
	$password = "";
	$dbname = "dbtest";
	$tabname = "Persons";

	$name = $_POST['name'];
	$e_mail = $_POST['email'];


	echo "Δώσατε: <br><br>";
	echo $name . "<br>";
	echo $e_mail . "<br>";
	echo "<br>";

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

	$conn = mysqli_connect($servername, $username, $password, $dbname);

	
	// sql to create table
	$sql = "CREATE TABLE IF NOT EXISTS $tabname (
	id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	P_name VARCHAR(30) NOT NULL,
	email VARCHAR(50)
	)";

	if (mysqli_query($conn, $sql)) {
		echo "Table $tabname created successfully <br>";
	} else {
	 	echo "Error creating table: " . mysqli_error($conn) . "<br>";
	} 

    $sql = "INSERT INTO $tabname (P_name, email)
	VALUES ('$name', '$email')";


	if (mysqli_query($conn, $sql)) {
		echo "New record created successfully <br>";
	} else {
	 	echo "Error: " . $sql . "<br>" . mysqli_error($conn) . "<br>";
	} 

	$last_id = mysqli_insert_id($conn);

	$sql = "SELECT id, P_name, email FROM $tabname";
	$result = mysqli_query($conn, $sql);
	
	
	if (mysqli_num_rows($result) > 0) {
		// output data of each row
		while($row = mysqli_fetch_assoc($result)) {
			echo "id: " . $row["id"]. " - Name: " . $row["P_name"]. " " . $row["email"].
			"<br>";
		}
	} else {
		echo "0 results";
	} 

	mysqli_close($conn);
    ?>