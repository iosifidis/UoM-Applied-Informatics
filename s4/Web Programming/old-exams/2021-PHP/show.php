<?php
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "iis21027";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
  die("Connection failed: " . $conn->connect_error);
}

$sql = "SELECT id, names, website FROM iis21027";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
  // output data of each row
  while($row = $result->fetch_assoc()) {
    echo "id: " . $row["id"]. " - Names: " . $row["names"]. " - Website: " . $row["website"]. "<br>";
  }
} else {
  echo "0 results";
}
$conn->close();
?>

<!DOCTYPE html>
<html>
<head>
    <title>PHP Εξέταση</title>
	<link rel="stylesheet" href="iis21027.css"/>
	<meta charset="utf-8">

    <meta name="description" content="Web Development - September 20201 - PHP">

    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1.0, maximum-scale=1.0, minimal-ui">
</head>
<body>
<nav>

<button type="button" onclick="location.href = 'index.php'">Return to index.</button>



</body>
</html>
