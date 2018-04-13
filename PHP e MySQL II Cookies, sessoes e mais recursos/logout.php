<?php 
include "logica-usuario.php";

deslogarUsuario();

header("Location: index.php?logout=1");
die();