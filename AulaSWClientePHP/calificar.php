
<?php 
require_once("encabezado.php");
require_once("navbaron.php");
?>
<?php    
    // Variables que voy a usar
    $clave = (int)0;
    $valor = "";
    $id = (int)0;
    $nombre = "";
    $nota = (float)0.0;
?>

<?php
    // Sesión
    session_start();
    if (isset($_SESSION["id"])) {
        $id = (int)$_SESSION["id"];
    }
?>

<?php
    // Procesamos el propio formulario Para validar la firma
    if (isset($_POST["nombre"])
            && isset($_POST["nota"])
            && isset($_POST["clave"])
            && isset($_POST["valor"])) {

        // Vamos a validarlo, recogiendo los parámetros
        $nombre = trim($_POST["nombre"]);
        $nota = (float)trim($_POST["nota"]);
        $clave = (int)trim($_POST["clave"]);
        $valor= trim($_POST["valor"]);

        try {
            // Parámetros
            $std = new stdClass;
            $std->id =$id;
            $std->clave =$clave;
            $std->valor =$valor;
            $params = objectToArray($std);
            // Servicio
            $result = $cliente->validar($params);

            if ($result->return === 1) {
   
                try {
                    // Parámetros
                    $std = new stdClass;
                    $std->id =$id;
                    $std->nombre =$nombre;
                    $std->nota =round($nota,2);
                    $params = objectToArray($std);
                    // Servicio
                    $result = $cliente->insertar($params);
                    if ($result->return === 1) {
                        header('Location: principal.php');
                        exit();

                    } else {
                        header('Location: error_calificar.php');
                        exit();
                    }
                } catch (Exception $ex) {
                    header('Location: error_calificar.php');
                    exit();
                }

            } else {
                header('Location: error_calificar.php');
                exit();
            }

        } catch (Exception $ex) {
            header('Location: error_calificar.php');
            exit();
        }

    }

?>

<?php    
    // Datos del formulario Si venimos de Principal
    if (isset($_POST["nombre"])
            && isset($_POST["nota"])) {
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
    <h1 class="display text-center">Insertar Alumno/a</h1>
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
                <form class="form" action="calificar.php" method="post">
                    <div class="form-group">
                        <div class="form-group col-sm-4">
                            <label>Nombre:</label>
                            <input type="text" class="form-control" readonly placeholder=" <?php echo($nombre); ?>">
                        </div>
                        <div class="form-group col-sm-4">
                            <label>    Nota:</label>
                            <input type="number" class="form-control" readonly placeholder=" <?php echo($nota); ?>">
                        </div>
                        <div class="form-group col-sm-4">
                            <?php echo("<label> Posición de Tarjeta: ".$clave."</label>");?>
                            <input type="text" class="form-control" required name="valor" maxlength="4">
                        </div>
                    </div>
                    <div class="form-group col-sm-4">
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
<br><br>
<!-- Final de la página -->
<?php require_once("footer.php");?>

