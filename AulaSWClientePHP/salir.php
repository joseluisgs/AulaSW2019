<?php
require_once("encabezado.php");
    try {
         // TODO initialize WS operation arguments here
         // Obtengo el id del usuario de la sesion
         session_start();
         $id = (int)$_SESSION["id"];
           // Creamos los parámetros
           $std = new stdClass;
           $std->id =$id;
           $params = objectToArray($std);
           //print_r($params);
           // Llamamos al serviico 
	        // TODO process result here
	        $result = $cliente->salir($params);
        // Me cargo la sesion y redireciono
        session_destroy();
        header('Location: index.php');
        exit();
    } catch (Exception $ex) {
        header('Location: index.php');
        exit();
    }
?>


