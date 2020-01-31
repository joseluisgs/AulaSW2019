<?php 
require_once("encabezado.php");
require_once("navbaron.php");
?>
<?php   
    session_start();
    $id = 0;
    if (isset($_SESSION["id"])) {
        $id = (int) $_SESSION["id"];
    }
?>
<!-- Comenzamos a programar cada sección --> 
<div class="jumbotron">
    <h1 class="display text-center">Tarjeta de Coordenadas</h1>
</div>

<div class="wrapper">
    <div class="container-fluid">
        <div class="row no-print">
            <div class="col-md-12">
                    <?php
                    try {
                         // TODO initialize WS operation arguments here
                        //int id = 0;
                        // TODO process result here
                        $std = new stdClass;
                        $std->id =$id;
                        $params = objectToArray($std);
                        // Llamo al servicio
                        $result =$cliente->tarjeta($params);
                        $tar= json_decode($result->return);
                        //print_r($tar);
                        if (count($tar) != 0) {
                            echo ("<h2>Mi Tarjeta de Coordenadas:</h2>");
                            echo("<table class='table table-bordered table-striped'>");
                            echo("<thead>");
                            echo("<tr>");
                            echo("<td>Posición</td>");
                            echo("<td>Valor</td>");
                            echo("</tr>");
                            echo("</thead>");
                        echo("<tbody>");
                        // Para cada elemento
                        foreach($tar as $t){
                            echo("<tr>");
                                    echo ("<td>".$t->clave."</td>");
                                    echo("<td>".$t->valor."</td>");
                            echo ("</tr>");
                        }
                       echo("</tbody>");
                    echo("</table>");
                } else {
                    echo("<p class='lead'><em>No se ha encontrado datos de tarjeta.</em></p>");
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
    </div>
</div>



<br><br>
<!-- Final de la página -->
<?php require_once("footer.php");?>
