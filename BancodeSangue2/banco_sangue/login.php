<?php
	
require "conexao.php";

$email = "bibo@bibo.com";
$senha = "uerleis";

$sqlQuery = "select nome from Doadores where email like '$email' and senha like '$senha';";

$result = mysqli_query ($conexao, $sqlQuery);

if (mysqli_num_rows ($result) > 0) {
	
	$row = mysqli_fetch_assoc ($result); 
	
	$nome = $row ["nome"];
	
	echo "Olá, bem vindo, " . $nome;
}
else {
	
	echo "Erro no login. Usuário ou senha inválidos.";
}	
?>