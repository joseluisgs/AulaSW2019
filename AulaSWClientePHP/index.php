<?php 
// Recupero la sesión
session_start();
if(isset($_SESSION["nombre"])){
  header( "Location: principal.php" );
}
require_once("encabezado.php");
require_once("navbar.php");
?>

<!-- Comenzamos a programar cada sección --> 
<div class="jumbotron">
  <h1 class="display text-center">Cliente AULA SW Cliente PHP</h1>
  <p class="lead text-center">Cliente PHP para la calificación de alumnos</p>
</div>


<br><br>
<!-- Final de la página -->
<?php require_once("footer.php");?>


