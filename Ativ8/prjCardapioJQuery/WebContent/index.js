$(document).ready(function(){
  $("#btnEnviar").click(function(){
    
	let price, msg;
    let conv = $("#convenio option:selected").val();

    if ($('input:radio[id="customRadioInline1"]').is(':checked')){
    	price = 30;
    	msg = '<p>Prato principal: ' + $('input:radio[id="customRadioInline1"]').val();
    }
    else if ($('input:radio[id="customRadioInline2"]').is(':checked')){
    	price = 35;
    	msg = '<p>Prato principal: ' + $('input:radio[id="customRadioInline2"]').val();
    }	
    else if ($('input:radio[id="customRadioInline3"]').is(':checked')){
    	price = 32;
    	msg = '<p>Prato principal: ' + $('input:radio[id="customRadioInline3"]').val();
    }
    
    msg += '<p>Acompanhamento:';
	    
    if ($('input:checkbox[id="customCheck1"]').is(':checked')){
    	msg += '<br>- ' + $('input:checkbox[id="customCheck1"]').val();
    	price += 10;
    }
    if ($('input:checkbox[id="customCheck2"]').is(':checked')){
    	msg += '<br>- ' + $('input:checkbox[id="customCheck2"]').val();
    	price += 10;
    }
	if ($('input:checkbox[id="customCheck3"]').is(':checked')){
		msg += '<br>- ' + $('input:checkbox[id="customCheck3"]').val();
		price += 10;
	}
	if ($('input:checkbox[id="customCheck4"]').is(':checked')){
		msg += '<br>- ' + $('input:checkbox[id="customCheck4"]').val();
		price += 10;
	}

    if (conv == "Fatec") price *= 0.8;
    else if (conv == "Prefeitura")  price *= 0.85;
    else if (conv == "Google") price *= 0.9;
	else price *= 0.95;
    
	msg += '<p>Convênio: ' + conv;
	msg += '<p>Valor total: R$ ' + price.toFixed(2).replace('.', ',');
	$("#body-modal").html(msg);    
   });
});