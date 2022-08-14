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
	<li><a href="home.php">Αρχική</a></li>
	<li><a href="show.php">Εμφάνιση</a></li>
	<li><a href="set.php">Καταχώρηση</a></li>
</ul>

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
  	// output data of each row
  	while($row = mysqli_fetch_assoc($result)) {
    		if (str_contains($row["id"], '21027')) {
        		echo "ID (ends with ID " . $row["id"] .") : " . " - Name: " . $row["name"]. " - Website: " . $row["website"]. "<br>";
    }
  }
} else {
  echo "0 results";
}
$conn->close();
?>

