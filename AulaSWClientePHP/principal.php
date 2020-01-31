<?php 
require_once("encabezado.php");
require_once("navbaron.php");
?>
<?
    session_start();
    $id = (int)$_SESSION["id"];
?>
<!-- Comenzamos a programar cada sección --> 
<div class="jumbotron">
    <h1 class="display text-center">Aula SW</h1>
</div>

<div class="wrapper">
    <div class="container-fluid">
        <div class="row no-print nover">
            <div class="col-md-12">
                <form class="form-inline" action="calificar.php" method="post">
                    <div class="form-group">
                        <label for="usuario" class="sr-only">Nombre:</label> 

                        <input type="text" class="form-control" id="buscar" name="nombre" placeholder="Nombre de Alumno/a">
                        <label for="usuario" class="sr-only">Nota:</label>
                        <input type="number" class="form-control" id="buscar" name="nota" max="10" min="0" step="0.05" placeholder="Nota">
                    </div>
                    <button type="submit" class="btn btn-primary mb-2"> <span class="glyphicon glyphicon-pencil"></span>  Calificar</button>
                </form>
            </div>
        </div>  
    <div class="page-header">
        <h2>Estadísticas:</h2>
    <?php
    try {
        $std = new stdClass;
        $std->id =$id;
        $params = objectToArray($std);
        $result = $cliente->estadisticas($params);
        $res= json_decode($result->return);
         
        echo("<li>Total: ".$res->total."</li>");
        echo("<li>Aprobados: ".$res->aprobados." - ".$res->aprobados100."% </li>");
        echo("<li>Suspensos: ".$res->suspensos." - ".$res->suspensos100."% </li>");
        echo("<li>Media de Nota: ".$res->media."</li>");
         
    } catch (Exception $ex) {
	// TODO handle custom exceptions here
    }
    ?>
    </div>
        <?php
            try {
                $std = new stdClass;
                $std->id =$id;
                $params = objectToArray($std);
                $result = $cliente->listar($params);
                $res= json_decode($result->return);

                if (count($res) != 0) {
                    echo("<h2>Listado:</h2>");
                    echo("<table class='table table-bordered table-striped'>");
                    echo("<thead>");
                        echo("<tr>");
                            echo("<td>Nº</td>");
                            echo("<td>Nombre</td>");
                            echo("<td>Nota</td>");
                            echo("<td class='text-center no-print nover'>Acción</td>");
                        echo("</tr>");
                    echo("</thead>");
                        echo("<tbody>");
                        // Para cada elemento
                        foreach ($res as $r) {
                            echo("<tr>");
                                 echo("<td>".$r->id."</td>");
                                 echo("<td>".$r->nombre."</td>");
                                 echo("<td>".$r->nota."</td>");
                                 echo("<td class='text-center no-print nover'>".
                                        "<form action='eliminar.php' method='post'>".
                                        "<button class='btn btn-danger' type='submit' title='Borar Producto' data-toggle='tooltip'".
                                        "onclick='return confirm('¿Seguro que desea borrar a este producto?')>".
                                        "<span class='glyphicon glyphicon-trash'></span>".
                                        "</button>");
                                echo("<input type='hidden' name='id' value='".$r->id."'>");
                                echo("<input type='hidden' name='nombre' value='".$r->nombre."'>");
                                echo("<input type='hidden' name='nota' value='".$r->nota."'>");
                                echo("</form></td>");
                                      
                            echo("</tr>");
                        }
                        echo("</tbody>");
                    echo("</table>");
                } else {
                    echo("<p class='lead'><em>No se ha encontrado datos de usuarios/as.</em></p>");
                }

            } catch (Exception $ex) {
                // TODO handle custom exceptions here
            }
        ?>

        <div class="row no-print nover">
            <div class="col-xs-12">
               <a class="btn btn-success pull-right" href="#" style= "margin-right: 5px" title="Imprimir" onclick="window.print()" data-toggle='tooltip'><span class='glyphicon glyphicon-print'></span> Imprimir</a>
            </div>
        </div>
    </div>
       
</div>

        

<br><br>
<?php            
    date_default_timezone_set('Europe/Madrid');
    session_start();
    $timestamp = strtotime($_SESSION["momento"]);
    //SimpleDateFormat formateador = new SimpleDateFormat("dd'/'MM'/'yyyy 'a las' H':'m':'s", new Locale("es_ES"));
    //Date fechaDate = new Date(sesion.getAttribute("momento").toString());
    echo("<h6>Conectado como: ".$_SESSION["nombre"]." - Acceso: ".strftime("%d/%m/%Y a las %H:%M:%S", $timestamp)."</h6>");

?>
<br>
<!-- Final de la página -->
<?php require_once("footer.php");?>
