<?php
	
require "conexao.php";
	
$nome           = $_POST["nome"];
$CPF            = $_POST["CPF"];
$RG             = $_POST["RG"];
$endereco       = $_POST["endereco"];
$bairro         = $_POST["bairro"];
$cidade         = $_POST["cidade"];
$estado         = $_POST["estado"];
$telPes         = $_POST["telPes"];
$telRes         = $_POST["telRes"];
$telCom         = $_POST["telCom"];
$senha          = $_POST["senha"];
$grupoSanguineo = $_POST["grupoSanguineo"];
$dataNascimento = $_POST["dataNascimento"];
$email          = $_POST["email"];

$sqlQuery = "insert into Doadores values ('$nome', '$CPF', '$RG', '$endereco', '$bairro', '$cidade', '$estado', '$telPes', '$telRes', '$telCom', '$senha', '$grupoSanguineo', '$dataNascimento', '$email');";

if (mysqli_query ($conexao, $sqlQuery)) {
	
	//echo "Dados inseridos com sucesso!";
}
else {
	
	//echo "Erro ao registrar dados: " . mysqli_error ($conexao);
}

	


	
?>