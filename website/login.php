<?php
   include("config.php");
   session_start();
   
   if($_SERVER["REQUEST_METHOD"] == "POST") {
      // username and password sent from form 
      
      $myusername = mysqli_real_escape_string($db,$_POST['username']);
      $mypassword = mysqli_real_escape_string($db,$_POST['password']); 
      
      $sql = "SELECT TYPE FROM Login WHERE USERNAME = '$myusername' AND PASSWORD = '$mypassword'";
      $result = mysqli_query($db,$sql);
      $row = mysqli_fetch_array($result,MYSQLI_ASSOC);
      $active = $row['active'];
      
      $count = mysqli_num_rows($result);
      
      // If result matched $myusername and $mypassword, table row must be 1 row
		
      if($count == 1) {
         session_register("myusername");
         $_SESSION['login_user'] = $myusername;
         
         header("location: customer.php");
      }else {
         $error = "Your Login Name or Password is invalid";
      }
   }
?>
<html lang='en'>

    <head>
        <meta charset='UTF-8'>
        <title>Portfolio Homepage</title>
        <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet">
        <link rel="stylesheet" href="styles.css">
    </head>
    <body>
        <form action="customer.php" method="post" style="border:1px solid #ccc">
            <div class="container">
                <h1>Insure-base</h1>
                <p>Please use this form to log into your account.</p>
                <hr>

                <label for="uname"><b>Username</b></label>
                <input type="text" placeholder="Enter Username" name="username" required>

                <label for="psw"><b>Password</b></label>
                <input type="password" placeholder="Enter Password" name="password" required>

                <div class="clearfix">
                    <button type="submit" class="signupbtn">Log In</button>
                </div>


            </div>
        </form>
        <div style="font-size:11px; color:#cc0000; margin-top:10px"><?php echo $error; ?></div>
    </body>
    </html>

