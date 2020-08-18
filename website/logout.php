<?php
   session_start();
    echo "<script>alert("You have been successfully logged out.");</script>";
   
   if(session_destroy()) {
      header("Location: login.php");
   }
?>