

<!-- �Barra de navegacion -->
<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Cliente Aula WS-PHP</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="principal.php">Inicio</a></li>
    </ul>
      <ul class="nav navbar-nav navbar-right">
        <?php
        // Recupero la sesión
          session_start();
          if(isset($_SESSION["nombre"])){
            echo("<li><p class='navbar-text'>".$_SESSION["nombre"]."</p></li>");
          }
        ?>
          <li><a href="tarjeta.php">Mi Tarjeta</a></li>
        <li><a href="salir.php"><span class="glyphicon glyphicon-log-out"></span> Salir</a></li>
    </ul>
  </div>
</nav>
<br><br>
