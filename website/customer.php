<?php
   
   session_start();
   
?>
<!DOCTYPE html>
<html lang='en'>

<head>
  <meta charset='UTF-8'>
  <title>Welcome!</title>
  <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet">
  <link rel="stylesheet" href="styles.css">
</head>

<body>
<form align="right" name="form2" method="post" action="logout.php">
  <label class="logoutLblPos">
  <input name="submit2" type="submit" id="submit2" value="Log out">
  </label>
</form>



<h1>Welcome!</h1>
    
    <p>Please select from the below menu what you would like to do today.</p>
    <hr>

    <p>I would like to:</p>

<form action="quote_form.php">
  <div class="container">
    
    
    <button type="newquote" class="registerbtn">Get a new quote.</button>
    
  </div>

</form>

    <form action="update_form.php">
  <div class="container">
 
    
    <button type="updatepage" class="registerbtn">Update my profile.</button>
  </div>

</form>


</body>
</html>