<!DOCTYPE html>
<html>
	<head>
	<title>Ευστάθιος Ιωσηφίδης - iis21027</title>
</head>
    <body>

<?php
	$servername = "localhost";
	$username = "root";
	$password = "";
	$dbname = "test";
	$tabname = "iis21027";


    $conn = mysqli_connect($servername, $username, $password, $dbname);

    // Outputs all database entries for $tabname
	$sql = "SELECT id, email FROM $tabname";
	$result = mysqli_query($conn, $sql);

	echo "<br>";
	if (mysqli_num_rows($result) > 0) {
		while($row = mysqli_fetch_assoc($result)) {
			echo "id: " . $row["id"]. " - Email: " . $row["email"]. "<br>";
		}
	} else {
		echo "0 results <br>";
	} 

    mysqli_close($conn);
?> 

<a href="index.php"> Αρχική </a><br>
        <a href="insert.php"> Καταχώριση </a><br><br><br>

		<h1>Ευστάθιος Ιωσηφίδης - iis21027</h1>
    </body>
</html>
