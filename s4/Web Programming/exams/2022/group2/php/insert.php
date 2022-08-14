<!DOCTYPE html>
<html>
<head>
	<title>Ευστάθιος Ιωσηφίδης - iis21027</title>
	<style>
	.error {
		color: #FF0000;
		}
	</style>
</head>
<body>
<h1>Ευστάθιος Ιωσηφίδης - iis21027</h1>
		<br>

<?php
// define variables and set to empty values
$nameErr = "";
$name = "";

if ($_SERVER["REQUEST_METHOD"] == "POST") {

  
   if (empty($_POST["name"])) {
     $nameErr = "Name is required";
   } else {
     $name = test_input($_POST["name"]);
     $nameErr = "";
     // check if e-mail address is well-formed
     if (!preg_match("/^[a-zA-Z ]*$/",$name)) {
       $nameErr = "Only letters and white space allowed";
     }
   }
   }
   // Insert to table 
    $servername = "localhost";
    $username = "root";
    $password = "";
    $dbname = "test";
    $tabname = "iis21027";
    

    $conn = mysqli_connect($servername, $username, $password, $dbname);

       if(!empty($name) && empty($nameErr)){
            // Inserts user info to database
            $sql = "INSERT INTO $tabname (name) VALUES ('$name')";

            if (mysqli_query($conn, $sql)) {
                echo "New record created successfully <br>";
            } else {
                echo "Error: " . $sql . "<br>" . mysqli_error($conn) . "<br>";
            } 
	}
            mysqli_close($conn);


function test_input($data) {
   $data = trim($data);
   $data = stripslashes($data);
   $data = htmlspecialchars($data);
   return $data;
}

?>

<p><span class="error">* required field.</span></p>
<form method="post" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>">

   Name: <input type="text" name="name" value="<?php echo $name;?>">
   <span class="error">* <?php echo $nameErr;?></span>
   <br><br>
   <input type="submit" name="submit" value="Submit">
</form>


<a href="index.php"> Αρχική </a><br>
<a href="view.php"> Εμφάνιση </a><br>

</body>
</html>

