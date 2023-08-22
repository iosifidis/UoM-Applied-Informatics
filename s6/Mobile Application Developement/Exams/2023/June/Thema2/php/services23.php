<?php
$data = array();
$host = "localhost";
$uname = "root";
$pass = "";
$dbname = "services23";

$conn = new mysqli($host, $uname, $pass, $dbname);
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

$sql = "SELECT * FROM Multis";
$result = mysqli_query($conn, $sql);

while ($row = mysqli_fetch_array($result)) {
    $nested_data = array();
    $nested_data['image1'] = $row['image1'];
    $nested_data['image2'] = $row['image2'];
    $nested_data['oper1'] = $row['oper1'];
    $nested_data['oper2'] = $row['oper2'];
    $nested_data['res'] = $row['res'];
    $data[] = $nested_data;
}

mysqli_close($conn);

header("Content-Type: application/json");
echo json_encode($data);
?>
