
//MUDA OLHOS
function mudaOlho_1(){
  if($('#olho1_ic').attr('src') == '/images/olhos/1Light.png'){
    $('#olho1_ic').attr('src','/images/olhos/1.png');
    $('#olho2_ic').attr('src','/images/olhos/2Light.png');
      $('#olho3_ic').attr('src','/images/olhos/3Light.png');
    $('#olho4_ic').attr('src','/images/olhos/4Light.png');

  }else{
    $('#olho1_ic').attr('src','/images/olhos/1Light.png');
  }
}


function mudaOlho_2(){
  if($('#olho2_ic').attr('src') == '/images/olhos/2Light.png'){
    $('#olho2_ic').attr('src','/images/olhos/2.png');
    $('#olho1_ic').attr('src','/images/olhos/1Light.png');
      $('#olho3_ic').attr('src','/images/olhos/3Light.png');
    $('#olho4_ic').attr('src','/images/olhos/4Light.png');

  }else{
    $('#olho2_ic').attr('src','/images/olhos/2Light.png');
  }
}


function mudaOlho_3(){
  if($('#olho3_ic').attr('src') == '/images/olhos/3Light.png'){
    $('#olho3_ic').attr('src','/images/olhos/3.png');
    $('#olho1_ic').attr('src','/images/olhos/1Light.png');
      $('#olho2_ic').attr('src','/images/olhos/2Light.png');
    $('#olho4_ic').attr('src','/images/olhos/4Light.png');
  }else{
    $('#olho3_ic').attr('src','/images/olhos/3Light.png');
  }
}


function mudaOlho_4(){
  if($('#olho4_ic').attr('src') == '/images/olhos/4Light.png'){
    $('#olho4_ic').attr('src','/images/olhos/4.png');
    $('#olho1_ic').attr('src','/images/olhos/1Light.png');
      $('#olho2_ic').attr('src','/images/olhos/2Light.png');
    $('#olho3_ic').attr('src','/images/olhos/3Light.png');

  }else{
    $('#olho4_ic').attr('src','/images/olhos/4Light.png');
  }
}

//MUDA GENERO

function mudaF(){
  if($('#femenino_ic').attr('src') == '/images/femeninoLight.png'){
    $('#femenino_ic').attr('src','/images/femenino.png');
        $('#masculino_ic').attr('src','/images/masculinoLight.png');
  }else{
    $('#femenino_ic').attr('src','/images/femeninoLight.png');
  }
//  console.log($('#carro_ic').val());
}


function mudaM(){
  if($('#masculino_ic').attr('src') == '/images/masculinoLight.png'){
    $('#masculino_ic').attr('src','/images/masculino.png');
      $('#femenino_ic').attr('src','/images/femeninoLight.png');
  }else{
    $('#masculino_ic').attr('src','/images/masculinoLight.png');
  }
//  console.log($('#carro_ic').val());
}

//MUDA VIATURA

      function mudaCarro(){
        if($('#carro_ic').attr('src') == '/images/icon_viatura/carroLight.png'){
          $('#carro_ic').attr('src','/images/icon_viatura/carroDark.png');
          $('#helicoptro_ic').attr('src','/images/icon_viatura/heliLight.png');
          $('#ambulancia_ic').attr('src','/images/icon_viatura/ambulanciaLight.png');
          $('#mota_ic').attr('src','/images/icon_viatura/motoLight.png');

        }else{
          $('#carro_ic').attr('src','/images/icon_viatura/carroLight.png');
        }
      //  console.log($('#carro_ic').val());
      }

      function mudaHeli(){
        if($('#helicoptro_ic').attr('src') == '/images/icon_viatura/heliLight.png'){
          $('#helicoptro_ic').attr('src','/images/icon_viatura/heliDark.png');
          $('#carro_ic').attr('src','/images/icon_viatura/carroLight.png');
          $('#ambulancia_ic').attr('src','/images/icon_viatura/ambulanciaLight.png');
          $('#mota_ic').attr('src','/images/icon_viatura/motoLight.png');

        }else{
          $('#helicoptro_ic').attr('src','/images/icon_viatura/heliLight.png');

        }
      }

      function mudaAmbulancia(){
        if($('#ambulancia_ic').attr('src') == '/images/icon_viatura/ambulanciaLight.png'){
          $('#ambulancia_ic').attr('src','/images/icon_viatura/ambulanciaDark.png');
          $('#helicoptro_ic').attr('src','/images/icon_viatura/heliLight.png');
          $('#carro_ic').attr('src','/images/icon_viatura/carroLight.png');
          $('#mota_ic').attr('src','/images/icon_viatura/motoLight.png');
        }else{
          $('#ambulancia_ic').attr('src','/images/icon_viatura/ambulanciaLight.png');
        }
      }

      function mudaMota(){
        if($('#mota_ic').attr('src') == '/images/icon_viatura/motoLight.png'){
          $('#mota_ic').attr('src','/images/icon_viatura/motoDark.png');
          $('#helicoptro_ic').attr('src','/images/icon_viatura/heliLight.png');
          $('#carro_ic').attr('src','/images/icon_viatura/carroLight.png');
          $('#ambulancia_ic').attr('src','/images/icon_viatura/ambulanciaLight.png');

        }else{
          $('#mota_ic').attr('src','/images/icon_viatura/motoLight.png');
        }
      }
