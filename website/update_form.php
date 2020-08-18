<?php
include("config.php");
   session_start();
   
   if($_SERVER["REQUEST_METHOD"] == "POST") {
     
      
      $usr = $_SESSION['username'];
      $last_name = mysqli_real_escape_string($db,$_POST['lastname']);
      $email = mysqli_real_escape_string($db,$_POST['pemail']);
      $num = mysqli_real_escape_string($db,$_POST['pnum']);
      $street = mysqli_real_escape_string($db,$_POST['pstreet']);
      $city = mysqli_real_escape_string($db,$_POST['pcity']);
      $state = mysqli_real_escape_string($db,$_POST['pstate']);
      $weight = mysqli_real_escape_string($db,$_POST['pweight']);
      $diabetes = mysqli_real_escape_string($db,$_POST['DIABETES_MELLITUS']);
      $cirr = mysqli_real_escape_string($db,$_POST['CIRRHOSIS']);
      $pneu = mysqli_real_escape_string($db,$_POST['PNEUMONIA']);
      $alz = mysqli_real_escape_string($db,$_POST['ALZHEIMERS_DISEASE']);
      $hiv = mysqli_real_escape_string($db,$_POST['HIV_DISEASE']);
      $cardio = mysqli_real_escape_string($db,$_POST['CARDIOVASCULAR_DISEASE']);
      $hyper = mysqli_real_escape_string($db,$_POST['HYPERTENSION']);

      if($last_name != null){
        $sql = "UPDATE Customers CU SET CU.CUSTLASTNAME = '$last_name' WHERE CU.CUSTID = (SELECT L.CUSTID FROM Login L WHERE L.USERNAME = '$usr');";
        $result = mysqli_query($db,$sql);
        $row = mysqli_fetch_array($result,MYSQLI_ASSOC);
        $active = $row['active'];
        
      }
      if($email != null){
        $sql = "UPDATE Customers CU SET CU.EMAILADDRESS = '$email' WHERE CU.CUSTID = (SELECT L.CUSTID FROM Login L WHERE L.USERNAME = '$usr');";
        $result = mysqli_query($db,$sql);
        $row = mysqli_fetch_array($result,MYSQLI_ASSOC);
        $active = $row['active'];
        
      }
      if($num != null){
        $sql = "UPDATE Customers CU SET CU.CONTACTNUMBER = '$num' WHERE CU.CUSTID = (SELECT L.CUSTID FROM Login L WHERE L.USERNAME = '$usr');";
        $result = mysqli_query($db,$sql);
        $row = mysqli_fetch_array($result,MYSQLI_ASSOC);
        $active = $row['active'];
        
      }
      if($street != null){
        $sql = "UPDATE Customers CU SET CU.STREET = '$street' WHERE CU.CUSTID = (SELECT L.CUSTID FROM Login L WHERE L.USERNAME = '$usr');";
        $result = mysqli_query($db,$sql);
        $row = mysqli_fetch_array($result,MYSQLI_ASSOC);
        $active = $row['active'];
        
      }
      if($city != null){
        $sql = "UPDATE Customers CU SET CU.CITY = '$city' WHERE CU.CUSTID = (SELECT L.CUSTID FROM Login L WHERE L.USERNAME = '$usr');";
        $result = mysqli_query($db,$sql);
        $row = mysqli_fetch_array($result,MYSQLI_ASSOC);
        $active = $row['active'];
        
      }
      if($state != null){
        $sql = "UPDATE Customers CU SET CU.STATE = '$state' WHERE CU.CUSTID = (SELECT L.CUSTID FROM Login L WHERE L.USERNAME = '$usr');";
        $result = mysqli_query($db,$sql);
        $row = mysqli_fetch_array($result,MYSQLI_ASSOC);
        $active = $row['active'];
        
      }
      if($weight != null){
        $sql = "UPDATE Customers CU SET CU.WEIGHT_LBS = '$weight' WHERE CU.CUSTID = (SELECT L.CUSTID FROM Login L WHERE L.USERNAME = '$usr');";
        $result = mysqli_query($db,$sql);
        $row = mysqli_fetch_array($result,MYSQLI_ASSOC);
        $active = $row['active'];
        
      }
      if($diabetes != null){
        $sql = "UPDATE Customers CU SET CU.DIABETES_MELLITUS = '$diabetes' WHERE CU.CUSTID = (SELECT L.CUSTID FROM Login L WHERE L.USERNAME = '$usr');";
        $result = mysqli_query($db,$sql);
        $row = mysqli_fetch_array($result,MYSQLI_ASSOC);
        $active = $row['active'];
        
      }
      if($cirr != null){
        $sql = "UPDATE Customers CU SET CU.CIRRHOSIS = '$cirr' WHERE CU.CUSTID = (SELECT L.CUSTID FROM Login L WHERE L.USERNAME = '$usr');";
        $result = mysqli_query($db,$sql);
        $row = mysqli_fetch_array($result,MYSQLI_ASSOC);
        $active = $row['active'];
        
      }
      if($pneu != null){
        $sql = "UPDATE Customers CU SET CU.PNEUMONIA = '$pneu' WHERE CU.CUSTID = (SELECT L.CUSTID FROM Login L WHERE L.USERNAME = '$usr');";
        $result = mysqli_query($db,$sql);
        $row = mysqli_fetch_array($result,MYSQLI_ASSOC);
        $active = $row['active'];
        
      }
      if($alz != null){
        $sql = "UPDATE Customers CU SET CU.ALZHEIMERS_DISEASE = '$alz' WHERE CU.CUSTID = (SELECT L.CUSTID FROM Login L WHERE L.USERNAME = '$usr');";
        $result = mysqli_query($db,$sql);
        $row = mysqli_fetch_array($result,MYSQLI_ASSOC);
        $active = $row['active'];
        
      }
      if($hiv != null){
        $sql = "UPDATE Customers CU SET CU.HIV_DISEASE = '$hiv' WHERE CU.CUSTID = (SELECT L.CUSTID FROM Login L WHERE L.USERNAME = '$usr');";
        $result = mysqli_query($db,$sql);
        $row = mysqli_fetch_array($result,MYSQLI_ASSOC);
        $active = $row['active'];
        
      }
      if($cardio != null){
        $sql = "UPDATE Customers CU SET CU.CARDIOVASCULAR_DISEASE = '$cardio' WHERE CU.CUSTID = (SELECT L.CUSTID FROM Login L WHERE L.USERNAME = '$usr');";
        $result = mysqli_query($db,$sql);
        $row = mysqli_fetch_array($result,MYSQLI_ASSOC);
        $active = $row['active'];
        
      }
      if($hyper != null){
        $sql = "UPDATE Customers CU SET CU.HYPERTENSION = '$hyper' WHERE CU.CUSTID = (SELECT L.CUSTID FROM Login L WHERE L.USERNAME = '$usr');";
        $result = mysqli_query($db,$sql);
        $row = mysqli_fetch_array($result,MYSQLI_ASSOC);
        $active = $row['active'];
        
      }

      echo "<script>alert("Details have been saved successfully. Our Agent will get in touch with you for verification purposes.");</script>";
   }
?>
<!DOCTYPE html>
<html lang='en'>

<head>
    <meta charset='UTF-8'>
    <title>Portfolio Update Information Page</title>
    <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet">
    <link rel="stylesheet" href="styles.css">

</head>
<body>
    <div class="container">
        <div class="nav-wrapper">

            <div class="right-side">
                <div class="brand">
                    Insurance Company: Update Personal Information Form
                </div>
            </div>

            <div class="right-side">
                <div class="brand">
                    Please use this form to update any previous information you have saved to your account.
                </div>
            </div>
        </div>

        <br>

        <form action="" method="post">

            <label for="lname">New Last Name</label>
            <input type="text" id="lname" name="lastname" placeholder="Your new last name..">

            <label for="email">New Email</label>
            <input type="text" id="email" name="pemail" placeholder="Your new email address..">

            <label for="num">New Contact Number</label>
            <input type="text" id="num" name="pnum" placeholder="Your new number..">

            <label for="address">New Street</label>
            <input type="text" id="street" name="pstreet" placeholder="Your new street..">

            <label for="address">New City</label>
            <input type="text" id="city" name="pcity" placeholder="Your new city..">

            <label for="address">New State</label>
            <input type="text" id="state" name="pstate" placeholder="Your new state..">

            <label for="weight">New Weight (in lbs.)</label>
            <input type="text" id="weight" name="pweight" placeholder="Your new weight..">

            <p>I developed a new condition:</p>

            <div>
                <input type="checkbox" id="DIABETES_MELLITUS" name="DIABETES_MELLITUS"
                       checked>
                <label for="DIABETES_MELLITUS">DIABETES_MELLITUS</label>
            </div>

            <div>
                <input type="checkbox" id="CIRRHOSIS" name="CIRRHOSIS">
                <label for="CIRRHOSIS">CIRRHOSIS</label>
            </div>

            <div>
                <input type="checkbox" id="PNEUMONIA" name="PNEUMONIA">
                <label for="PNEUMONIA">PNEUMONIA</label>
            </div>

            <div>
                <input type="checkbox" id="ALZHEIMERS_DISEASE" name="ALZHEIMERS_DISEASE">
                <label for="ALZHEIMERS_DISEASE">ALZHEIMERS_DISEASE</label>
            </div>

            <div>
                <input type="checkbox" id="HIV_DISEASE" name="HIV_DISEASE">
                <label for="HIV_DISEASE">HIV_DISEASE</label>
            </div>

            <div>
                <input type="checkbox" id="CARDIOVASCULAR_DISEASE" name="CARDIOVASCULAR_DISEASE">
                <label for="CARDIOVASCULAR_DISEASE">CARDIOVASCULAR_DISEASE</label>
            </div>

            <div>
                <input type="checkbox" id="HYPERTENSION" name="HYPERTENSION">
                <label for="HYPERTENSION">HYPERTENSION</label>
            </div>

            <input type="submit"  value="Submit">
        </form>
    </div>
</body>
</html>