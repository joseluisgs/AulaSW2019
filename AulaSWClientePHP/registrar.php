<?php 
require_once("encabezado.php");
require_once("navbar.php");

    // Procesamos el formulario
    // Si existen los parámetros vía POST
    if (isset($_POST["nombre"])
            && isset($_POST["email"])
            && isset($_POST["password"])) {

        $nombre = trim($_POST["nombre"]);
        $email = trim($_POST["email"]);
        $password = trim($_POST["password"]);
        $password = hash('sha256', $password);

        // Llamamos al servicio de insertar.
        // start web service invocation
        try {
            // Creamos los parámetros
            $std = new stdClass;
            $std->nombre =$nombre;
            $std->email =$email;
            $std->password =$password;
            $params = objectToArray($std);
            //print_r($params);
            // Llamamos al serviico 
            $result = $cliente->registrar($params);
            //out.println("Result = "+result);
            if ($result->return === 1) {
                // Nos movemos a una nueva dirección, que somos nosotros mismos
                header('Location: identificar.php');
                exit();
            } else {
                 // Nos movemos a una nueva dirección, que somos nosotros mismos
                header('Location: error_registro.php');
                exit();
            }
        } catch (Exception $ex) {
            // Nos movemos a una nueva dirección, que somos nosotros mismos
                header('Location: error_registro.php');
                exit();
        }

    }

?>

<!-- Cuerpo de la página web -->
<div class="wrapper">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">
                <div class="page-header">
                    <h2>Registro de usuario/a:</h2>
                </div>
                <p>Por favor rellene este formulario para poder comprar en la tienda.</p>
                <!-- Formulario-->
                <form action="registrar.php" method="post">
                    <!-- Nombre-->
                    <div class="form-group">
                        <label>Nombre:</label>
                        <input type="text" required name="nombre" class="form-control" value="">
                    </div>
                    <!-- Email -->
                    <div class="form-group">
                        <label>E-Mail:</label>
                        <input type="email" required name="email" class="form-control" value="">
                    </div>
                    <!-- Password -->
                    <div class="form-group">
                        <label>Password:</label>
                        <input type="password" required name="password" class="form-control" value="">
                    </div>
                    <button type="submit" class="btn btn-primary"> <span class="glyphicon glyphicon-ok"></span>  Aceptar</button>
                    <a href="index.php" class="btn btn-danger"><span class="glyphicon glyphicon-remove"></span> Cancelar</a>
                </form>
            </div>
        </div>        
    </div>
</div>

<br><br>
<!-- Final de la página -->
<?php require_once("footer.php");?>

