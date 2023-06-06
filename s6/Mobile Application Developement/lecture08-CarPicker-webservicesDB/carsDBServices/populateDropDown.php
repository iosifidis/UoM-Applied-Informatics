<?php
	$data = array();

	$host="localhost";
	$uname="root";
	$pass="";
	$dbname="cars";
	
	$dbh = mysqli_connect($host,$uname,$pass) or die("cannot connect");
	mysqli_select_db($dbh, $dbname);
			
	$sql = "SELECT brand, GROUP_CONCAT(model) AS grouped_models FROM models GROUP BY brand";
	$result = mysqli_query($dbh, $sql);
	while ($row = mysqli_fetch_array($result)) { 
		$data[$row['brand']] = $row['grouped_models'];
	}

	header("Content-Type: application/json");
	echo json_encode($data);
	mysqli_close($dbh);
?>