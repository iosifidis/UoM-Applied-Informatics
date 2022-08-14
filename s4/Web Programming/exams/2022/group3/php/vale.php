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
$nameErr = $websiteErr = "";
$name = $website = "";

if ($_SERVER["REQUEST_METHOD"] == "POST") {

  
  /* Στην εκφώνηση ζητάει κανόνα εγκυρότητας (μόνο) για το πεδίο website. 
  Λογικά αν αφήσετε κενό το πεδίο name θα το πάρει στην βάση. Στην εμφάνιση όμως, θα εμφανίζει
  κενό όνομα (που δεν βγάζει νόημα). Όμως αυτό ζητάει η εκφώνηση.
  Επίσης η βάση δεν έχει κλειδί.
  */ 
     $name = test_input($_POST["name"]);
  
   
   if (empty($_POST["website"])) {
     
     $websiteErr = "Website is required";
   } else {
     $website = test_input($_POST["website"]);
     // check if URL address syntax is valid (this regular expression also allows dashes in the URL)
     if (!preg_match("/\b(?:(?:https?|ftp):\/\/|www\.)[-a-z0-9+&@#\/%?=~_|!:,.;]*[-a-z0-9+&@#\/%=~_|]/i",$website)) {
       $websiteErr = "Invalid URL";
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

       if(!empty($website) && empty($websiteErr)){
            // Inserts user info to database
            $sql = "INSERT INTO $tabname (name, website) VALUES ('$name', '$website')";

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
      Website: <input type="text" name="website" value="<?php echo $website;?>">
   <span class="error">* <?php echo $websiteErr;?></span>
   <br><br>
   <input type="submit" name="submit" value="Submit">
</form>

<a href="index.php"> Αρχική </a><br>
<a href="show.php"> Παρουσίαση </a><br>

</body>
</html>

