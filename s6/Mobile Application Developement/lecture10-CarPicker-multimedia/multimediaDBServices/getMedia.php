<?php
	$data = array();

	$host="localhost";
	$uname="root";
	$pass="";
	$dbname="cars";
	
	$dbh = mysqli_connect($host,$uname,$pass) or die("cannot connect");
	mysqli_select_db($dbh, $dbname);
			
	$sql = "SELECT brand, GROUP_CONCAT(model) AS grouped_models, GROUP_CONCAT(image) as images FROM models GROUP BY brand";
	$result = mysqli_query($dbh, $sql);
	while ($row = mysqli_fetch_array($result)) { 
		$nested_data = array();
		$nested_data['grouped_models']= $row['grouped_models'];
		$nested_data['images']= $row['images'];
		$data[$row['brand']] = $nested_data;
	}

	header("Content-Type: application/json");
	echo json_encode($data);
	mysqli_close($dbh);
?>