<?php
	
require "conexao.php";

//mysql_select_db("banco_de_sangue") or die(mysql_error());

$cidade = $_POST["cidade"];

$sqlQuery = "select * from Doadores where cidade like 'POA';";

$result = mysqli_query ($conexao, $sqlQuery);

while ($row = mysqli_fetch_array($result)) {

	echo $row["nome"];
}
?>