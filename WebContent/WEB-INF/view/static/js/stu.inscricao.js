var ajaxLoader = "<img src='../static/img/icons/ajax-loader.gif' />";

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

var fadeTime = 500;

$(document).ready(function(){
    
    //Máscaras
	
	$('input[name|="data_pgto"],#data_nascimento').mask("39/19/Y999");
	$('#cep').mask("99999-999");
	$('#telefone,#telefone2,#celular').mask("(99) 9999-9999");
		
	// Formatando os botões de envio e cancelar
	$("input:submit, a, button, input:reset", ".opcao").button();
	$("a", ".opcao").click(function() {
		return true;
	});
	
	//Dados do pagamento Behavior
	//escondendo o campo
	$('#grupo-pgto-tipo').addClass('hidden');
	// desmarcando o campo. Util para o Firefox
	$('input:radio[name=tipo_pgto]').prop('checked', false);
	// escondendo a imagem
	$('img[name=comprovante_pagamento]').addClass('hidden');
	
	$('input:radio[name=tipo_pgto]').click(function(){
		
		$('#grupo-pgto-tipo').removeClass('hidden');
		
		if($(this).val()==1){
			$('label[for=comprovante_pgto]').html("*Qual o NÚMERO DA AGÊNCIA do responsável pela transferência?");
			$('img[name=comprovante_pagamento]').fadeOut(fadeTime);
		} else if($(this).val()==2){
			$('label[for=comprovante_pgto]').html("*Qual o CTR presente em <br />seu comprovante impresso?");
			$('img[name=comprovante_pagamento]').fadeIn(fadeTime);
			$('img[name=comprovante_pagamento]').attr('src','/mamute/static/img/ITAU-autodeposito.gif');			
		} else if($(this).val()==3){				
			$('label[for=comprovante_pgto]').html("*Qual o número de<br />seu comprovante impresso?");
			$('img[name=comprovante_pagamento]').fadeIn(fadeTime);
			$('img[name=comprovante_pagamento]').attr('src','/mamute/static/img/ITAU-comprovante-diretocaix.gif');
		}
	 });
	
	// Funcao que resta os selects
	function initSelect(nome){
		var select = jQuery(nome);		 
		select.val(jQuery('options:first', select).val());		
	}
	
	
	
	//Pos-Graduacao Behavior
	$('#grupo-pos').addClass('hidden');
	
	initSelect('#pos_tipo');
	
	$('#pos_tipo').change(function(){
		
		var selectedIndex = $('option:selected', $(this)).index();
		
		//console.log(selectedIndex);
		
        //0- selecione 1- nao
		if(selectedIndex > 1)
        {
			$('#grupo-pos').fadeIn(fadeTime);
        } else {
        	$('#grupo-pos').fadeOut(fadeTime);
        }
	 });
	
	//Experiencia Behavior
	$('#grupo-experiencia-docencia').addClass('hidden');
	
	initSelect('#trab_experiencia');
	
	$('#trab_experiencia').change(function(){
		
		var selectedIndex = $('option:selected', $(this)).index();
		
		//console.log(selectedIndex);
		
        //0 - selecione 1 - nao
		if(selectedIndex > 1)
        {
			$('#grupo-experiencia-docencia').fadeIn(fadeTime);
        } else {
        	$('#grupo-experiencia-docencia').fadeOut(fadeTime);
        }
	 });
	
	//Trabalho em Pré-Vestibulares Behavior
	$('#grupo-experiencia-pre-vest').addClass('hidden');
	
	initSelect('#trab_pvs');
	
	$('#trab_pvs').change(function(){
		
		var selectedIndex = $('option:selected', $(this)).index();
		
		//console.log(selectedIndex);
		
        //0- selecione 1- nao
		if(selectedIndex > 1)
        {
			$('#grupo-experiencia-pre-vest').fadeIn(fadeTime);
        } else {
        	$('#grupo-experiencia-pre-vest').fadeOut(fadeTime);
        }
	 });
	
	
	//Validações
	$("#inscricao-form").validate({
		rules: /**
		 * 
		 */
		{
			disciplina: 					{ required:true	},
			polo:							{ required:true	},
			motivo_inscricao: 				{ required:true, minlength: 10	},
			
			tipo_pgto:						{ required:true	},
			comprovante_pgto:	    		{ required:true	},
			data_pgto: 						{ required:true, dateDE: true	},
			
			/*cpf:							{ required:true	},*/
			ident_numero: 					{ required:true, minlength: 2	},
			ident_orgao:					{ required:true, minlength: 2	},
			ident_uf: 						{ required:true	},
			
			nome: 							{ required:true, minlength: 5 	},
			endereco: 						{ required:true, minlength: 5	},
			bairro: 						{ required:true, minlength: 2	},
			estado: 						{ required:true	},
			cidade: 						{ required:true	},
			cep: 							{ required:true, minlength: 9	},
			telefone: 						{ required:true, minlength: 14	},
		/**/data_nascimento:				{ required:true, minlength: 10	, dateDE: true	},
			email: 							{ required:true, minlength: 4	, email: true	},
			confirma_email: 				{ required:true, minlength: 4	, email: true,	equalTo: "#email" },
			
			grad_tipo: 						{ required:true	},
			grad_area: 						{ required:true	},
			grad_curso: 					{ required:true	},
		/**/grad_universidade_sigla:		{ required:true	},
		/**/grad_universidade_nome:	 		{ required:true	},
			grad_instituto: 				{ required:true	},
		/**/grad_natureza_instituicao:		{ required:true	},
			grad_periodo: 					{ required:true	},
			grad_ano: 						{ required:true	},
			
			pos_tipo: 					{ required:true	},
			pos_area: 					{ required:true	},
			pos_curso: 					{ required:true	},
			pos_universidade_sigla:		{ required:true	},
			pos_universidade: 			{ required:true	},
			pos_universidade_instituto: { required:true	},
			pos_ano: 					{ required:true	},
			
			trab_experiencia: 			{ required:true	},
			trab_exercicio: 			{ required:true	},
			trab_escola_nome: 			{ required:true	},
			trab_escola_municipio: 		{ required:true	},
			trab_escola_tipo: 			{ required:true	},
			trab_nivel_ensino: 			{ required:true	},
			trab_disc_principal: 		{ required:true	},
			
			trab_pvs: 					{ required:true	},
			trab_pvs_nome: 				{ required:true	},
			trab_pvs_local: 			{ required:true	},
			trab_pvs_anos: 				{ required:true	},
		
			quest_usa_comp: 			{ required:true	},
			quest_tipo_trab: 			{ required:true	},
			quest_tem_comp: 			{ required:true	},
			quest_internet: 			{ required:true	},
			termo_compromisso: 			{ required:true	},
	/*		lastname: "required",
			username: {
				required: true,
				minlength: 2
			},
			password: {
				required: true,
				minlength: 5
			},
			confirm_password: {
				required: true,
				minlength: 5,
				equalTo: "#password"
			},
			email: {
				required: true,
				email: true
			},
			topic: {
				required: "#newsletter:checked",
				minlength: 2
			},
			agree: "required"*/
		},
		messages: {
			
			
			/*	lastname: "Please enter your lastname",
			username: {
				required: "Please enter a username",
				minlength: "Your username must consist of at least 2 characters"
			},
			password: {
				required: "Please provide a password",
				minlength: "Your password must be at least 5 characters long"
			},
			confirm_password: {
				required: "Please provide a password",
				minlength: "Your password must be at least 5 characters long",
				equalTo: "Please enter the same password as above"
			},
			email: "Please enter a valid email address",
			agree: "Please accept our policy"*/
		}
	});
	
	/*
    $("#inscricao-form").validate({
            rules: {
               ident_numero: "required",
                ident_orgao: "required",
                   ident_uf: "required",
                       nome: "required",
                   endereco: "required",
                     bairro: "required",
                     cidade: "required",
                        cep: "required",
                         uf: "required",
                   telefone: "required",
                  data_nasc: "required",
                email:{
                        required: true,
                        email: true
                },
                confirma_email: {equalTo: "#email"},
          motivo_inscricao: "required",
                      polo: "required",
                disciplina: "required",
     comprovante_pagamento: "required",
                  grad_ano: "required",
                 grad_tipo: "required",
                 grad_area: "required",
                grad_curso: "required",
                 grad_univ: "required",
                grad_univ2: "required",
            grad_instituto: "required",
      grad_natureza_instit: "required",
                  pos_tipo: "required",
          trab_experiencia: "required",
                  trab_pvs: "required"
            },
            messages:{
                grad_univ: {required: ""}                
            }
    });    
    
    
    $('#grad_univ').focus(function(){
        $(this).val('');
    });

    $('#grad_univ').blur(function(){
        if($(this).val() == ""){
            $(this).val('SIGLA');
        }
    });

    $('#grad_univ2').focus(function(){
        $(this).val('');
    });

    $('#grad_univ2').blur(function(){
        if($(this).val() == ""){
            $(this).val('NOME');
        }
    });

    $('#pos_universidade_sigla').focus(function(){
        $(this).val('');

    $('#pos_universidade_sigla').blur(function(){
        if($(this).val() == ""){
            $(this).val('SIGLA');
        }
    });

    });
    $('#pos_universidade').focus(function(){
        $(this).val('');
    });

    $('#pos_universidade').blur(function(){
        if($(this).val() == ""){
            $(this).val('NOME');
        }
    });

    $('#btn_confirmar').click(function(){
        coletaAnosAtuacao();
    });

    function coletaAnosAtuacao()
    {
        var files = '';
        // Procura em todos os elementos com a classe lista_anos na página.
        $(".lista_anos:checked").each(function(){
        //Verifica se input checkbox esta marcado        
            // Adiciona valor do checkbox
            files = files + '' + this.value + ',';        
        });
        //remove a última vírgula da string
        files = files.substr(0, files.length - 1);

        //atribui string ao campo hidden
        $('#trab_pvs_tempo').val(files);
    }

    $('#trab_pvs').change(function(){
        if($(this).val() == 'S')
        {
            $('.bloco-experiencia-pre-vest').fadeIn(300);
            $('#trab_pvs_nome').addClass('required');
            $('#trab_pvs_local').addClass('required').val('3587');
        }
        else
        {
            $('.bloco-experiencia-pre-vest').fadeOut(300);
            $('#trab_pvs_nome').removeClass('required').val('');
            $('#trab_pvs_local').removeClass('required').val('');
        }
    });

    $('#trab_experiencia').change(function(){
        if($(this).attr('selectedIndex') > 1)
        {
            $('.bloco-experiencia-docencia').fadeIn(300);
            $('#trab_exercicio').addClass('required');
        }
        else
        {            
            $('.bloco-experiencia-docencia').fadeOut(300);
            $('#trab_exercicio').removeClass('required').val('');
        }
    });

    $('#trab_exercicio').change(function(){
        if($(this).attr('selectedIndex') > 1)
        {
            $('.bloco-em-exercicio').fadeIn(300);
            $('#trab_escola_nome').addClass('required');
            $('#trab_escola_municipio').addClass('required').val('3587');;
            $('#trab_escola_tipo').addClass('required');
            $('#trab_nivel_ensino').addClass('required');
            $('#trab_disc_principal').addClass('required');
        }
        else
        {
            $('.bloco-em-exercicio').fadeOut(300);
            $('#trab_escola_tipo').removeClass('required').val('');
            $('#trab_escola_nome').removeClass('required').val('');
            $('#trab_escola_municipio').removeClass('required').val('');
            $('#trab_nivel_ensino').removeClass('required').val('');
            $('#trab_disc_principal').removeClass('required').val('');
        }
    });

    $('#grad_tipo').change(function(){
        if($('#grad_tipo').val() == 'GND')
        {
            $('#grad_periodo').addClass('required');
            $('#periodo-concluido').fadeIn(300);
        }
        else
        {
            $('#periodo-concluido').fadeOut(300);
            $('#grad_periodo').removeClass('required').val('');
        }
    });
    
    //tipo de pos graduacao
    $('#pos_tipo').change(function(){
        if($(this).attr('selectedIndex') > 1)
        {
            $('.grupo-pos').fadeIn(300);
            $('#pos_area').addClass('required');
            $('#pos_curso').addClass('required');
            $('#pos_universidade_sigla').addClass('required');
            $('#pos_universidade').addClass('required');
            $('#pos_universidade_instituto').addClass('required');
            $('#pos_ano').addClass('required');
        }
        else
        {            
            $('.grupo-pos').fadeOut(300);
            $('#pos_area').removeClass('required').val('');
            $('#pos_curso').removeClass('required').val('');
            $('#pos_universidade_sigla').removeClass('required').val('');
            $('#pos_universidade').removeClass('required').val('');
            $('#pos_universidade_instituto').removeClass('required').val('');
            $('#pos_ano').removeClass('required').val('');
        }        
    });*/

	carregarPolos = function(idDisciplina){
			
		$('#carregamentoPolo #disciplina').attr('disabled', 'disabled');
		$('#carregamentoPolo').html(ajaxLoader + " Carregando...");
		
		$.ajax({
								  
			  url: "selectPolosDisponiveis",		   
			  data: "idDisciplina="+idDisciplina,			  
			  type: 'POST',
			  
			  success: function(data){
				 $('#carregamentoPolo').html(data);
			  },
			  error: function(){
				  $('#carregamentoPolo').html("Ocorreu um erro ao carregar os polos. Selecione a disciplina novamente");
			  }
		
		});
	};
	
	carregarCidades = function(idEstado){
						
		$('#carregamentoCidade #cidade').attr('disabled', 'disabled');
		$('#carregamentoCidade').html(ajaxLoader + " Carregando...");
		
		$.ajax({
								  
			  url: "selectCidades",		   
			  data: "idEstado="+idEstado,			  
			  type: 'POST',
			  
			  success: function(data){
				 $('#carregamentoCidade').html(data);
			  },
			  error: function(){
				  $('#carregamentoCidade').html("Ocorreu um erro ao listar as cidades.");
			  }
		
		});
	};
	
	carregarMunicipiosEscola = function(idEstado){
		
		$('#carregamentoMunicipio #trab_escola_municipio').attr('disabled', 'disabled');
		$('#carregamentoMunicipio').html(ajaxLoader + " Carregando...");
		
		$.ajax({
								  
			  url: "selectMunicipiosEscola",		   
			  data: "idEstado="+idEstado,			  
			  type: 'POST',
			  
			  success: function(data){
				 $('#carregamentoMunicipio').html(data);
			  },
			  error: function(){
				  $('#carregamentoMunicipio').html("Ocorreu um erro ao listar os municípios");
			  }
		
		});
	};	
	
	carregarMunicipiosCurso = function(idEstado){
		
		$('#carregamentoLocalCurso #trab_pvs_local').attr('disabled', 'disabled');
		$('#carregamentoLocalCurso').html(ajaxLoader + " Carregando...");
		
		$.ajax({
								  
			  url: "selectMunicipiosCurso",		   
			  data: "idEstado="+idEstado,			  
			  type: 'POST',
			  
			  success: function(data){
				 $('#carregamentoLocalCurso').html(data);
			  },
			  error: function(){
				  $('#carregamentoLocalCurso').html("Ocorreu um erro ao listar os municípios");
			  }
		
		});
	};	
	
});