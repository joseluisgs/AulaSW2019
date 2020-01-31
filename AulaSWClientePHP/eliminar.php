<?php 
require_once("encabezado.php");
require_once("navbaron.php");
?>

<?php    
    // Variables que voy a usar
    $clave = (int)0;
    $valor = "";
    $id = (int)0;
    $usuario_id = (int)0;
    $nombre = "";
    $nota = (float)0.0;
?>

<?php
    // Sesión
    session_start();
    if (isset($_SESSION["id"])) {
        $usuario_id = (int)$_SESSION["id"];
    }
?>

<?php
    // Procesamos el propio formulario Para validar la firma
    // Procesamos el propio formulario Para validar la firma
    if (isset($_POST["id"])
            && isset($_POST["nombre"])
            && isset($_POST["nota"])
            && isset($_POST["clave"])
            && isset($_POST["valor"])) {


        // Vamos a validarlo, recogiendo los parámetros por si g¡hubiesen cambiando, que no lo han hecho
        // Lo sé, pero lo hago en cualquier manera
         // Vamos a validarlo, recogiendo los parámetros
         $id = (int)trim($_POST["id"]);
         $nombre = trim($_POST["nombre"]);
         $nota = (float)trim($_POST["nota"]);
         $clave = (int)trim($_POST["clave"]);
         $valor= trim($_POST["valor"]);

        try {
             // Parámetros
             $std = new stdClass;
             $std->id =$usuario_id;
             $std->clave =$clave;
             $std->valor =$valor;
             $params = objectToArray($std);
             // Servicio
             $result = $cliente->validar($params);

             if ($result->return === 1) {

                // Eliminamos
                try {
                    // Parámetros
                    $std = new stdClass;
                    $std->usuario_id =$usuario_id;
                    $std->alumno_id =$id;
                    $params = objectToArray($std);
                    // Servicio
                    $result = $cliente->eliminar($params);
                    if ($result->return === 1) {
                        //out.println("OK");
                        header('Location: principal.php');
                        exit();
                    } else {
                         //out.println("KO1");
                        header('Location: error_eliminar.php');
                         exit();
                    }
                } catch (Exception $ex) {
                    //out.println("KO2");
                    header('Location: error_eliminar.php');
                    exit();
                }

            } else {
                //out.println("KO3");
                header('Location: error_eliminar.php');
                exit();
            }

        } catch (Exception $ex) {
            header('Location: error_eliminar.php');
            exit();
        }

    }

?>

<?php    
    // Datos del formulario Si venimos de Principal
    if (isset($_POST["id"])
            && isset($_POST["nombre"])
            && isset($_POST["nota"])) {
        $id= (int)trim($_POST["id"]);
        $nombre = trim($_POST["nombre"]);
        $nota = (float)trim($_POST["nota"]);
    }

?>

<?php       
    // Obtenemos la coordenada 
    try {
        // Parámetros
        $std = new stdClass;
        $std->id =$id;
        $params = objectToArray($std);
        // Llamamos al servicio
        $result = $cliente->firmar($params);
        $clave = (int)$result->return;
        //out.println("Result = "+result);
    } catch (Exception $ex) {
        // TODO handle custom exceptions here
    }
?>



<div class="jumbotron">
    <h1 class="display text-center">Eliminar Alumno/a</h1>
</div>
<!-- Cuerpo de la página web -->
<div class="wrapper">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">
                <div class="page-header">
                    <h2>Validación de firma</h2>
                </div>
                <!-- Formulario-->
                <form class="form" action="eliminar.php" method="post">
                    <div class="form-group">
                        <div class="form-group col-sm-1">
                            <label>ID:</label>
                            <input type="number" class="form-control" readonly placeholder=" <?php echo($id); ?>">
                        </div>
                        <div class="form-group col-sm-4">
                            <label>Nombre:</label>
                            <input type="text" class="form-control" readonly placeholder=" <?php echo($nombre); ?>">
                        </div>
                        <div class="form-group col-sm-2">
                            <label>    Nota:</label>
                            <input type="number" class="form-control" readonly placeholder=" <?php echo($nota); ?>">
                        </div>
                        <div class="form-group col-sm-3">
                            <?php echo("<label> Posición de Tarjeta: ".$clave."</label>");?>    
                            <input type="text" class="form-control" required name="valor" maxlength="4">
                        </div>
                    </div>
                    <div class="form-group col-sm-12">
                        <?php echo("<input type='hidden' name='id' value='" .$id. "'>");?>  
                        <?php echo("<input type='hidden' name='nombre' value='" .$nombre. "'>");?>
                        <?php echo("<input type='hidden' name='nota' value='" .$nota. "'>");?>
                        <?php echo("<input type='hidden' name='clave' value='" .$clave. "'>");?>
                        <button type="submit" class="btn btn-primary mb-2"> <span class="glyphicon glyphicon-thumbs-up"></span>  Firmar</button>
                    </div> 
                </form>
            </div>
        </div>        
    </div>
</div>
<!-- Final de la página -->
<?php require_once("footer.php");?>

