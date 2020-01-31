<?php 
require_once("encabezado.php");
require_once("navbar.php");
    // Procesamos el formulario
    // Si existen los parámetros vía POST
    if (isset($_POST["email"])
        && isset($_POST["password"])) {

            $email = trim($_POST["email"]);
            $password = trim($_POST["password"]);
            $password = hash('sha256', $password);

       try {
             // Creamos los parámetros
             $std = new stdClass;
             $std->email =$email;
             $std->password =$password;
             $params = objectToArray($std);
              // Llamamos al serviico 
            $result = $cliente->indetificar($params);
            if ($result->return >= 1) {
                // Vamos a meter al usuario en la sesión
                try {
                    $id = $result->return;
                    $std = new stdClass;
                    $std->id =$id;
                    $params = objectToArray($std);
                    // Llamo al servicio
                    $json =$cliente->usuario($params);
                    
                    // Parseamos sus resultados
                    $parser = json_decode($json->return);
                    //print_r($parser);
                    $id= $parser->id;
                    $nombre = $parser->nombre;
                    $email = $parser->email;
                    $momento = $parser->momento;

                    // Nos guardamos en la sesion
                    session_destroy();
                    session_start();
                    $_SESSION["id"] = $id;
                    $_SESSION["nombre"] = $nombre;
                    $_SESSION["email"] = $email;
                    $_SESSION["momento"] = $momento;
                } catch (Exception $ex) {
                    // TODO handle custom exceptions here
                }
                header('Location: principal.php');
                exit();
                
            } else {
                header('Location: error_identificacion.php');
                exit();
            }
        } catch (Exception $ex) {
            header('Location: error_identificacion.php');
           exit();
        }
    }

?>
<div class="wrapper">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">
                <div class="page-header">
                    <h2>Identificación de Usuario/a:</h2>
                </div>
                <!-- Formulario-->
                <form action="identificar.php" method="post">
                    <!-- Nombre-->
                    <div class="form-group">
                        <label>Email:</label>
                        <input type="email" required name="email" class="form-control">
                    </div>
                    <!-- Contraseña -->
                    <div class="form-group">
                        <label>Contraseña:</label>
                        <input type="password" required name="password" class="form-control">
                    </div>
                    <button type="submit" class="btn btn-primary"> <span class="glyphicon glyphicon-log-in"></span>  Entrar</button>
                    <a href="index.php" class="btn btn-danger"><span class="glyphicon glyphicon-remove"></span> Cancelar</a>
                </form>
            </div>
        </div>        
    </div>
</div>

<br><br>
<!-- Final de la página -->
<?php require_once("footer.php");?>