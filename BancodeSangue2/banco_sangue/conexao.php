<?php
	$nomeBanco    = "banco_de_sangue";
	$loginBanco   = "root";
	$senhaBanco   = "";
	$nomeServidor = "localhost";
	
	$conexao = mysqli_connect ($nomeServidor, $loginBanco, $senhaBanco, $nomeBanco);
	
	if (!$conexao) {
	
		//echo "Erro na conexao: ".mysqli_connect_error ();
	}
	else {
		
		//echo "Conexao bem sucedida!";
	}
?> 