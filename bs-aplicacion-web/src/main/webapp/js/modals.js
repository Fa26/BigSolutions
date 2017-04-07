$(function(){
  function hideModal(modalwindow){
    $(modalwindow).modal('hide');
      document.getElementById("#comentario").value = "";
  }
  
  $('#okwin01').on('click', function(e){//boton calificar
    e.preventDefault();
    hideModal('#EmergenteCalificar');
  });
  
  $('#okwin02').on('click', function(e){//boton publicar
    e.preventDefault();
    hideModal('#EmergenteComentar');  
  });
  
  $('#closewin02').on('click', function(e){//boton cancelar
    e.preventDefault();
    hideModal('#EmergenteComentar');
  });

});

function borrarTexto() {
    document.getElementById("comentario").value = "";
}

function getwords() {
    var c1 = document.getElementById('comentario').value;
    var d1 = document.getElementById('as');
    d1.innerHTML = c1;
    document.getElementById("comentario").value = "";
}