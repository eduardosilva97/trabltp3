<?php
	
require "conexao.php";

$email = $_POST["email"];
$senha = $_POST["senha"];

$sqlQuery = "select nome from Doadores where email like '$email' and senha like '$senha';";

$result = mysqli_query ($conexao, $sqlQuery);

if (mysqli_num_rows ($result) > 0) {
	
	$row = mysqli_fetch_assoc ($result); 
	
	$nome = $row ["nome"];
	
	echo "Seja bem vindo, " . $nome . ".";
}
else {
	
	echo "Erro no login. Usuario ou senha invalidos.";
}	
?>