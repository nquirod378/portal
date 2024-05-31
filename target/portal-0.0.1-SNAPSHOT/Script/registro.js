/**
*
*/
document.addEventListener('DOMContentLoaded', function() {
   cargarPrimerDesplegable();
});
 
function cargarPrimerDesplegable() {
   fetch('/portal/centroservlet')
       .then(response => {
           if (!response.ok) {
               throw new Error('Network response was not ok');
           }
           return response.json();
       })
       .then(data => {
           let primerDesplegable = document.getElementById('centro');
           data.forEach(item => {
               let option = document.createElement('option');
               option.value = item.id;
               option.text = item.nombre;
               primerDesplegable.add(option);
           });
       })
       .catch(error => console.error('Error al cargar el primer desplegable:', error));
}
function cargarSegundoDesplegable() {
   let primerDesplegable = document.getElementById('centro');
   let valorSeleccionado = primerDesplegable.value;
   fetch(`/portal/cursoservlet?value=${encodeURIComponent(valorSeleccionado)}`)
       .then(response => {
           if (!response.ok) {
               throw new Error('Network response was not ok');
           }
           return response.json();
       })
       .then(data => {
           let segundoDesplegable = document.getElementById('curso');
           segundoDesplegable.innerHTML = '<option value="">Selecciona una opción</option>';
           data.forEach(item => {
               let option = document.createElement('option');
               option.value = item.id;
               option.text = item.nombre;
               segundoDesplegable.add(option);
           });
       })
       .catch(error => console.error('Error al cargar el segundo desplegable:', error));
}