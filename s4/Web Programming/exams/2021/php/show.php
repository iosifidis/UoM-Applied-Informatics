<!DOCTYPE html>
<html>
	<head>
	<title>Ευστάθιος Ιωσηφίδης - iis21027</title>
	<meta charset="utf-8">
    	<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1.0, maximum-scale=1.0, minimal-ui">
</head>
    <body>
		<h1>Ευστάθιος Ιωσηφίδης - iis21027</h1>
		<br>

<?php
	$servername = "localhost";
	$username = "root";
	$password = "";
	$dbname = "iis21027";
	$tabname = "iis21027";


    $conn = mysqli_connect($servername, $username, $password, $dbname);

    // Outputs all database entries for $tabname
	$sql = "SELECT * FROM $tabname";
	$result = mysqli_query($conn, $sql);

	echo "<br>";
	if (mysqli_num_rows($result) > 0) {
		while($row = mysqli_fetch_assoc($result)) {
			echo "id: " . $row["id"]. " - Name: " . $row["name"]. " - Website: " . $row["website"]. "<br>";
		}
	} else {
		echo "0 results <br>";
	} 

    mysqli_close($conn);
?> 

        <ul>
	<li><a href="index.php">Αρχική</a></li>
	<li><a href="set.php">Καταχώρηση</a></li>
    	<li><a href="pick.php">Διαλογή</a></li>
</ul>

    </body>
</html>
