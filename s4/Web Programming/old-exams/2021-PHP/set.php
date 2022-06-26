<?php
		$servername = "localhost";
		$username = "root";
		$password = "";
        $dbname = 'iis21027';

		// Create connection
		$link = new mysqli($servername, $username, $password, $dbname);
		// Check connection
		if ($link->connect_error) {
			die("<br> Connection failed: " . $link->connect_error);
		} 


// Define variables and initialize with empty values
$names = $website = $id = "";
$names_err = $website_err = $id_err ="";
 
// Processing form data when form is submitted
if($_SERVER["REQUEST_METHOD"] == "POST"){

        // Validate names
        if(empty($_POST["names"])){
            $names_err = "Please enter a name.";
        } else{
            $names = $_POST["names"];
        }
    
        // Validate website
        if(empty($_POST["website"])){
            $website_err = "Please enter a website.";
        } else{
            $website = $_POST["website"];
        }

        // Validate website
        if(empty($_POST["website"])){
            $id_err = "Please enter an ID.";
        } else{
            $id = $_POST["id"];
        }
    }

    // Check input errors before inserting in database
    if(empty($names_err) && empty($website_err)){
        
        // Prepare an insert statement
        $sql = "INSERT INTO iis21027 (id, names, website) VALUES (?, ?, ?)";
         
        if($stmt = mysqli_prepare($link, $sql)){
            // Bind variables to the prepared statement as parameters
            mysqli_stmt_bind_param($stmt, "iss",$param_id, $param_names, $param_website);
            
            // Set parameters
            $param_id = $id;
            $param_names = $names;
            $param_website = $website;
            
            // Attempt to execute the prepared statement
            if(mysqli_stmt_execute($stmt)){
                echo "Successful.";
            } else{
                echo "Oops! Something went wrong. Please try again later.";
            }

            // Close statement
            mysqli_stmt_close($stmt);
        }
    }
    
    // Close connection
    mysqli_close($link);

?>

<!DOCTYPE html>>
<head>
    <meta charset="UTF-8">
    <title>iis21027</title>
    <style>
        body{ font: 16px sans-serif; }
        .form{
            padding: 20px; 
            float: left; 
            margin: auto;
            width: 360px;
            border-style: outset;
            padding-bottom: 75px;
        }  
        </style>
</head>
<body>
    <div class="form">
        <h2>Ονοματεπώνυμο -  Ιστοσελίδα - ID</h2>
        <p>Συμπληρώστε τα παρακάτω στοιχεία</p>
        <form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>" method="post">   
            <div class="form-group">
                <label><strong>Ονοματεπώνυμο</strong></label>
                <input type="names" name="names"  class="form-control <?php echo (!empty($names_err)) ? 'is-invalid' : ''; ?>" value="<?php echo $names; ?>">
                <span class="invalid-feedback"><?php echo $names_err; ?></span>
            </div>
            <br>
            <div class="form-group">
                <label><strong>Ιστοσελίδα</strong></label>
                <input type="website" name="website" class="form-control <?php echo (!empty($website_err)) ? 'is-invalid' : ''; ?>" value="<?php echo $website; ?>">
                <span class="invalid-feedback"><?php echo $website_err; ?></span>
            </div> 
            <br>
            <div class="form-group">
                <label><strong>ID</strong></label>
                <input type="id" name="id" class="form-control <?php echo (!empty($id_err)) ? 'is-invalid' : ''; ?>" value="<?php echo $id; ?>">
                <span class="invalid-feedback"><?php echo $id_err; ?></span>
            </div> 
            <div class="form-group">
                <input type="submit" class="btn btn-primary" value="Submit" style='float: right;'>
            </div>
            <br>
        </form>
        <button type="button" onclick="location.href = 'index.php'">Return to index.</button>
    </div>    
</body>
</html>
