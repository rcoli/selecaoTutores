// Documentação : http://docs.jquery.com/Plugins/Validation
// Colocando as classes de highlight
$.validator.setDefaults({
	//submitHandler: function() { alert("submitted!"); },
	highlight: function(input) {
		$(input).addClass("ui-state-highlight");
	},
	unhighlight: function(input) {
		$(input).removeClass("ui-state-highlight");
	}
});

$(document).ready(function(){
    
	// Formatando os botões de envio e cancelar
	$("input:submit, a, button, input:reset", ".opcao").button();
	$("input:submit", ".opcao").click(function() {
		return true;
	});
	
	//Validações
	$("#dados_bancarios").validate({
		rules: {
			banco_nome: 	{ required:true, minlength: 2	},
			banco_numero:	{ required:true, minlength: 2	},
			banco_agencia: 	{ required:true, minlength: 2	},
			banco_conta:	{ required:true, minlength: 2	}
		}	
	});	
	
});