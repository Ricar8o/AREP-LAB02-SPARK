var apiclient = (function () {
return{
    
    getMean: function (numeros,callback) {
        jQuery.ajax({
            url: "/getMean-Deviation",
            type: "POST",
            data: JSON.stringify({
            'lista' : numeros
            }),
            success: function (respuesta) {
                callback(respuesta);
            }
        });
    }
    
};
})();