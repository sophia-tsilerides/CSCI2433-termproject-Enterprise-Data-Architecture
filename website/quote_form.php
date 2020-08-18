<?php
include("config.php");
   session_start();
   
   if($_SERVER["REQUEST_METHOD"] == "POST") {
     
      
      $usr = $_SESSION['username'];
      $pln = mysqli_real_escape_string($db,$_POST['plan']); 
        echo "<script>alert("The renewal quote for your suggested plan is $2000.");</script>"; 
      if($pln == null){
        $sql = "SELECT P.RENEWALRATE FROM Product P, Suggested_Product S_P, Login L WHERE L.USERNAME = '$usr' AND L.CUSTID = S_P.CUSTID AND S_P.PRODUCT_NO = P.PRODUCT_NO";
        $result = mysqli_query($db,$sql);
        $row = mysqli_fetch_array($result,MYSQLI_ASSOC);
        $active = $row['active'];
        $quote = $result['RENEWALRATE'];
        echo "<script>alert("The renewal quote for your suggested plan is $".'$quote'.".");</script>"; 
        
      }
      else{
        $sql = "SELECT P.RENEWALRATE FROM Product P WHERE P.PLANNAME = '$pln'";
        $result = mysqli_query($db,$sql);
        $row = mysqli_fetch_array($result,MYSQLI_ASSOC);
        $quote = $result['RENEWALRATE'];
        $active = $row['active'];
        echo "<script>alert("The renewal quote for your chosen plan is $".'$quote'.".");</script>";   
      }

      $count = mysqli_num_rows($result);
      $count = 1;
      
   }
?>
<!DOCTYPE html>
<html lang='en'>

<head>
    <meta charset='UTF-8'>
    <title>New Portfolio Page</title>
    <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet">
    <link rel="stylesheet" href="styles.css">

</head>

<body>
<form align="right" name="form2" method="post" action="customer.php">
  <label class="homepage">
  <input name="submit2" type="submit" id="submit2" value="Home">
  </label>
</form>
    <div class="container">
        <div class="nav-wrapper">

            <div class="right-side">
                <div class="brand">
                    Insurance Company: Personal Information Form
                </div>
            </div>

            <div class="right-side">
                <div class="brand">
                    Welcome new user!
                    Please use this form to either allows us to generate a quote for you or select your preferred plan.
                </div>
            </div>
        </div>

        <br>

        <form action="" method="post">

            <label for="plan">Allow us to select the best plan for you. We will calculate a premium based on suggested product information from your profile</label>
            <input type="submit"  value="Generate a Quote of me Automatically!">

            <br>

            <label for="plan">Select a plan from the below options for yourself and we will show you the associated premium.</label>
            <select id="plan" name="plan">
                <option value="sugar">Sugar Rush Coverage Plan</option>
                <option value="peace">Peace of Mind Coverage Plan</option>
                <option value="lifestyle">Lifestyle Plus Coverage Plan</option>
                <option value="heart">Heart Plus Coverage Plan</option>
                <option value="choice">Choice Coverage Plan</option>
                <option value="basic">Basic Coverage Plan</option>
            </select>

            <input type="submit"  value="Submit">
        </form>
    </div>
</body>
</html>