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
$emailErr = "";
$name = $email = "";

if ($_SERVER["REQUEST_METHOD"] == "POST") {

  
  /* Στην εκφώνηση ζητάει κανόνα εγκυρότητας (μόνο) για το πεδίο email. 
  Λογικά αν αφήσετε κενό το πεδίο name θα το πάρει στην βάση. Στην εμφάνιση όμως, θα εμφανίζει
  κενό όνομα (που δεν βγάζει νόημα). Όμως αυτό ζητάει η εκφώνηση.
  Επίσης η βάση δεν έχει κλειδί.
  */ 
     $name = test_input($_POST["name"]);
  
     if (empty($_POST["email"])) {
     $emailErr = "Email is required";
   } else {
     $email = test_input($_POST["email"]);
     // check if e-mail address is well-formed
     if (!filter_var($email, FILTER_VALIDATE_EMAIL)) {
       $emailErr = "Invalid email format";
     }
   }
 
   
   }
   // Insert to table 
    	$servername = "localhost";
	$username = "root";
	$password = "";
	$dbname = "iis21027";
	$tabname = "iis21027";
    

    $conn = mysqli_connect($servername, $username, $password, $dbname);

       if(!empty($email) && empty($emailErr)){
            // Inserts user info to database
            $sql = "INSERT INTO $tabname (name, email) VALUES ('$name', '$email')";

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
   <br><br>
      E-mail: <input type="text" name="email" value="<?php echo $email;?>">
   <span class="error">* <?php echo $emailErr;?></span>
   <br><br>
   <input type="submit" name="submit" value="Submit">
</form>

<a href="index.php"> Αρχική </a><br>
<a href="showall.php"> Παρουσίαση </a><br>

</body>
</html>

