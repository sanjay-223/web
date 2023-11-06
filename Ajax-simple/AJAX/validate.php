<?php
$query=$_GET["q"];
$conn=new mysqli("localhost","root","31415","mydb");
if($conn->connect_error)
{
    die("connection failed");
}
$sql="Select * from DATA where name='$query'";
$rs=$conn->query($sql);
if($rs->num_rows>0)
{
    echo "UserName already Exists!!!";
}
else {
    echo "Available.";
}
?>