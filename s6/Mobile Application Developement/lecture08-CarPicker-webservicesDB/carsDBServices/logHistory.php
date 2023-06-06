<?php
	$data = array();
	$brand = $_GET["brand"];
	$model = $_GET["model"];
	$timestamp = $_GET["timestamp"];

	$host="localhost";
	$uname="root";
	$pass="";
	$dbname="cars";
	
	$dbh = mysqli_connect($host,$uname,$pass) or die("cannot connect");
	mysqli_select_db($dbh, $dbname);
			
	$sql = "INSERT into history values('" . $brand . "','" . $model . "','" . $timestamp . "')";
	echo $sql;
	mysqli_query($dbh, $sql);
	mysqli_close($dbh);


?>