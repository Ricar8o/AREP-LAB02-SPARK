var apiclient = (function () {
    var numeros = [];
    var mediaValue;
    var deviationValue;
return{
    
    addData: function () {
        
        var num = document.getElementById("numero").value;
        if ( !isNaN(num)){
            var fila = '<tr><td>' + num  + '</td></tr>';
            var tabla = document.getElementById("datos");
            tabla.innerHTML += fila;
            numeros.push(parseFloat(num));
        }
        
    },
    getMean: function (callback) {
        jQuery.ajax({
            url: "/getMean",
            type: "POST",
            data: JSON.stringify({
            'lista' : numeros
            }),
            success: function (respuesta) {
                callback(respuesta);
            }
        });
    },
    getDeviation: function (callback) {
        jQuery.ajax({
            url: "/getDeviation",
            type: "POST",
            data: JSON.stringify({
            'lista' : numeros,
            'media' : mediaValue
            }),
            success: function (respuesta) {
                callback(respuesta);
            }
        });
    },

    showDeviation: function(valor){
        var outputMedia = document.getElementById("desviacion");
        outputMedia.innerHTML = valor;
        deviationValue = valor;
    },

    
    showMean: function(valor){
        var outputMedia = document.getElementById("media");
        outputMedia.innerHTML = valor;
        mediaValue = valor;
    },

    showResults: function(){
        
        this.getMean(this.showMean);
        
    }
    
};
})();