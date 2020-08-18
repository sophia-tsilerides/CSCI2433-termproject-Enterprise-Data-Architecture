
<?php

define('DB_SERVER', 'tsilerides-patel-database-systems.c7yvomvayohd.us-east-1.rds.amazonaws.com:3306');
define('DB_USERNAME', 'admin');
define('DB_PASSWORD', 'fanmap-Hidtaq-3parte');
define('DB_NAME', 'Project_Part_2');
 
/* Attempt to connect to MySQL database */
$link = mysqli_connect(DB_SERVER, DB_USERNAME, DB_PASSWORD, DB_NAME);
 
// Check connection
if($link === false){
    die("ERROR: Could not connect. " . mysqli_connect_error());
}
?>