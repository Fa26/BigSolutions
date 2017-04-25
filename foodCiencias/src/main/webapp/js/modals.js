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
// Get the modal
var modal = document.getElementById('myModal');

// Get the button that opens the modal
var btn = document.getElementById("myBtn");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks the button, open the modal 
btn.onclick = function() {
    modal.style.display = "block";
};

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
    modal.style.display = "none";
};

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target === modal) {
        modal.style.display = "none";
    };
};
