<!DOCTYPE html>
<html>
	<head>
	<title>Ευστάθιος Ιωσηφίδης - iis21027</title>
</head>
    <body>
		<h1>Ευστάθιος Ιωσηφίδης - iis21027</h1>
		<br>

<?php
	$servername = "localhost";
	$username = "root";
	$password = "";
	$dbname = "test";
	$tabname = "iis21027";


    $conn = mysqli_connect($servername, $username, $password, $dbname);

    // Outputs all database entries for $tabname
	$sql = "SELECT name, website FROM $tabname";
	$result = mysqli_query($conn, $sql);

	echo "<br>";
	if (mysqli_num_rows($result) > 0) {
		while($row = mysqli_fetch_assoc($result)) {
			echo "Name: " . $row["name"]. "<br>";
		}
	} else {
		echo "0 results <br>";
	} 

    mysqli_close($conn);
?> 

        <a href="index.php"> Αρχική </a><br>
        <a href="vale.php"> Εισαγωγή </a><br>

    </body>
</html>
