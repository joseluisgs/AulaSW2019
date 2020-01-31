<?php
    error_reporting(E_ERROR | E_WARNING | E_PARSE);
    // Iniciamos el servicio
    $servicio = "http://localhost:8080/aulaservicio/aulaservicio?WSDL";
    $cliente  = new SoapClient($servicio);
    
    // Atención estas funciones son importantes
    // La necesitamos para convertir un objeto en un array
    // Lo usaremos con los parámetros de entradam sobre todo si
    // Son del tipo complejo o usamos dos parámetros (tambien con 1 si quremos)
    function objectToArray($d)
	{
		if (is_object($d))
		{
			$d = get_object_vars($d);
		}
 
		if (is_array($d))
		{
			return array_map(__FUNCTION__, $d);
		}
		else
		{
			return $d;
		}
    }
    // convierte un array en object
    // Importante si devolvemos un objeto del tipo complejo o estructurado
    function array2Object($d)
	{
		if (is_array($d))
		{
			return (object) array_map(__FUNCTION__, $d);
		}
		else
		{
			return $d;
		}
    }
    // Saco un Alert JS
    function alerta($texto) {
        echo '<script type="text/javascript">alert("' . $texto . '")</script>';
    }


?>

<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <title>Cliente Aula WS-PHP v1.1 2DAM/DAW</title>
        <!--
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="css/estilos.css">
        <script src="script/jquery.min.js"></script>
        <script src="script/bootstrap.js"></script>
        -->
        <link rel="icon" type="image/png" href="http://www.sacschool.com/wp-content/uploads/sites/4/2014/01/form-icon.png">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.js"></script>
        <style>
          /* Para que el contenido de la página renderice en un 80% */
        .wrapper{
            width: 80%;
            margin: 0 auto;
        }
        .page-header h2{
            margin-top: 0;
        }


        #logo {
            align-items: center;
            color: red;
            display: flex;
        }
         /* Fondo completo */
        body {
            margin: 0;
           background: url('https://wallpapertag.com/wallpaper/full/a/a/4/102788-light-grey-background-1920x1200-desktop.jpg');
            background-size:     cover;
            background-repeat:yes-repeat;
            display: compact;
        }
        </style>
        <!-- Para imprimir -->
        <style type="text/css" media="print">
            @media print {
                .nover{
                    visibility:hidden
            }
        }
        </style>

        <script type="text/javascript">
            $(document).ready(function () {
                $('[data-toggle="tooltip"]').tooltip();
            });
        </script>
    </head>
    <body>
<!-- Cabecera de las páginas web común a todos -->