            function validarFrequencia() {
                let frequencia = $('#frequencia').val();
                frequencia = parseFloat(frequencia);
                if (frequencia <= 0) {
                    $('#frequenciaErro').text('O número de vezes na semana deve ser maior do que zero');
                    return false;
                }
                else if (!Number.isInteger(frequencia)){
                    $('#frequenciaErro').text('O número deve ser inteiro');
                    return false;
                } else {
                    $('#frequenciaErro').text('');
                    return true;
                }
            }
            
            function validarNomeTreino(){
                let nomeTreino = $('#nomeTreino').val();
                nomeTamanho = nomeTreino.trim().length;
                if (nomeTamanho < 1){
                    $('#nomeErro').text('Informe um nome para o treino');
                    return false;
                }
                else {
                    $('#nomeErro').text('');
                    return true;
                }
            }
            
            function validarTipo(){
                let tipo = $('#tipo').val();
                tipoTamanho = tipo.trim().length;
                if (tipoTamanho < 1){
                    $('#tipoErro').text('Informe o tipo de treino (ex: braço)');
                    return false;
                }
                else {
                    $('#tipoErro').text('');
                    return true;
                }
            }
            
            $(document).ready(function() {
            if ($('input[class="dias"]:checked').length > 0){
                    $('input[name="informaDias"][value="true"]').prop('checked', true);
                    $('#dias-da-semana').show();
                    $('#diasErro').text('');
                }
            else{
                $('input[name="informaDias"][value="false"]').prop('checked', true);
            }
            // Dias da semana escondidos
            if ($('input[name="informaDias"]:checked').val() === "false") {
                $('#dias-da-semana').hide();
            }

            // Aparecem quando opção "sim" é marcada
            $('input[name="informaDias"]').on('change', function() {
                if ($('#sim').prop('checked')) {
                    $('#dias-da-semana').show();
                    $('#diasErro').text('Selecione ao menos um dia da semana');
                } else {
                    $('#dias-da-semana').hide();
                }
            });
            
            $('input[class="dias"]').on('change', function() {
                if ($('#sim').prop('checked')) {
                    if ($('input[class="dias"]:checked').length === 0) {
                        $('#diasErro').text('Selecione ao menos um dia da semana');
                    } else{
                        $('#diasErro').text('');
                    }
                }
            });
            
            

            $('#myForm').submit(function(e) {
                var isValid = true;
                
                if (!$('input[name="informaDias"]:checked').val()) {
                    isValid = false;
                }

                if ($('#sim').prop('checked')) {
                    if ($('input[name="dias"]:checked').length === 0) {
                        isValid = false;
                    }
                }
                if (!validarNomeTreino() || !validarTipo() || !validarFrequencia()){
                    isValid = false;
                }

                if (!isValid) {
                    e.preventDefault();
                    alert("O formulário não foi preenchido corretamente");
                }
            });
            
        });
        
        
        function validarNomeExercicio(){
                let nomeExercicio = $('#nomeExercicio').val();
                nomeTamanho = nomeExercicio.trim().length;
                if (nomeTamanho < 1){
                    $('#nomeErro').text('Informe o nome do exercício/máquina');
                    return false;
                }
                else {
                    $('#nomeErro').text('');
                    return true;
                }
            }
            
            function validarPeso(){
                let peso = $('#peso').val();
                 if (!/^\d+(\.\d+)?$/.test(peso)){
                    $('#pesoErro').text('Informe apenas números');
                    return false;
                }
                else {
                    $('#pesoErro').text('');
                    return true;
                }
            }
            
            function validarSeries() {
                let series = $('#series').val();
                series = parseFloat(series);
                if (series <= 0) {
                    $('#seriesErro').text('O número de séries deve ser maior do que zero');
                    return false;
                }
                else if (!Number.isInteger(series)){
                    $('#seriesErro').text('O número deve ser inteiro');
                    return false;
                } else {
                    $('#seriesErro').text('');
                    return true;
                }
            }
            
            function validarRepeticoes() {
                let repeticoes = $('#repeticoes').val();
                repeticoes = parseFloat(repeticoes);
                if (repeticoes <= 0) {
                    $('#repeticoesErro').text('O número de repetições deve ser maior do que zero');
                    return false;
                }
                else if (!Number.isInteger(repeticoes)){
                    $('#repeticoesErro').text('O número deve ser inteiro');
                    return false;
                } else {
                    $('#repeticoesErro').text('');
                    return true;
                }
            }
            
            $(document).ready(function() {
            $('#myForm2').submit(function(e) {
                var isValid = true;

                if (!validarNomeExercicio() || !validarPeso() || !validarSeries() || !validarRepeticoes()) {
                    isValid = false;
                }

                if (isValid==="false") {
                    console.log(isValid);
                    e.preventDefault();
                    alert("O formulário não foi preenchido corretamente");
                }
            });
        });

    





