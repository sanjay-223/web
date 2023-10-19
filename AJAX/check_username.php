<?php
$existingUsernames = ['user1', 'user2', 'user3','sanjay'];

if (isset($_POST['username'])) {
    $username = $_POST['username'];
    if (in_array($username, $existingUsernames)) {
        echo 'not_available';
    } else {
        echo  'available';
    }
}
?>
