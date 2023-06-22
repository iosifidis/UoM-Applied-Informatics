<?php
	 $data = array();
	 $host="localhost";
	 $uname="root";
	 $pass="";
	 $dbname="Animals";
	 
	 $dbh = mysqli_connect($host,$uname,$pass) or die("cannot connect");
	 mysqli_select_db($dbh, $dbname);
	 
	 $sql = "SELECT name, GROUP_CONCAT(type) AS grouped_types,GROUP_CONCAT(voice) AS grouped_voices,GROUP_CONCAT(image) as images FROM animals GROUP BY name";
	 
	 $result = mysqli_query($dbh, $sql);
	 while ($row = mysqli_fetch_array($result)) {
	 $nested_data = array();
	 $nested_data['grouped_types']= $row['grouped_types'];
	 $nested_data['grouped_voices'] = $row['grouped_voices'];
	 $nested_data['images']= $row['images'];
	 $data[$row['name']] = $nested_data;
	 }
	 
	 mysqli_close($dbh);
	 header("Content-Type: application/json");
	 echo json_encode($data);
?>
