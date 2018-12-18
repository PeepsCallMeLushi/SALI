///FARMACOS
var icrem=0;



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

function farma(x){
  var output="";
  var $this = $(x);
  var xvalue;
  var xid = $this.attr('id');
  var xclass="."+xid;
 console.log($this.val());
 console.log(xclass);

    if($this.is(':checked')){
      console.log("true");
      xvalue = $this.val();
      console.log(xvalue);
      output+='<input type="hidden" name="utentes[0].avaliacao.habitosFarmacologicos['+icrem+'].nome" value="'+xvalue+'" class="'+xid+'">';
      icrem+=1;
      $("#farmacos").append(output);
      }else{
        console.log("false");
        $(xclass).remove();
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

    $('#utentesexo').attr('value','Femenino');
  }else{
    $('#femenino_ic').attr('src','/images/femeninoLight.png');
    $('#utentesexo').attr('value','');
  }
//  console.log($('#carro_ic').val());
}


function mudaM(){
  if($('#masculino_ic').attr('src') == '/images/masculinoLight.png'){
    $('#masculino_ic').attr('src','/images/masculino.png');
      $('#femenino_ic').attr('src','/images/femeninoLight.png');
      $('#utentesexo').attr('value','Masculino');
  }else{
    $('#masculino_ic').attr('src','/images/masculinoLight.png');
    $('#utentesexo').attr('value','');
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

          $('#hiddenviatura').attr('value','Carro');
        }else{
          $('#carro_ic').attr('src','/images/icon_viatura/carroLight.png');
          $('#hiddenviatura').attr('value','');
        }
      //  console.log($('#carro_ic').val());
      }

      function mudaHeli(){
        if($('#helicoptro_ic').attr('src') == '/images/icon_viatura/heliLight.png'){
          $('#helicoptro_ic').attr('src','/images/icon_viatura/heliDark.png');
          $('#carro_ic').attr('src','/images/icon_viatura/carroLight.png');
          $('#ambulancia_ic').attr('src','/images/icon_viatura/ambulanciaLight.png');
          $('#mota_ic').attr('src','/images/icon_viatura/motoLight.png');

          $('#hiddenviatura').attr('value','Helicopetro');

        }else{
          $('#helicoptro_ic').attr('src','/images/icon_viatura/heliLight.png');
          $('#hiddenviatura').attr('value','');
        }
      }

      function mudaAmbulancia(){
        if($('#ambulancia_ic').attr('src') == '/images/icon_viatura/ambulanciaLight.png'){
          $('#ambulancia_ic').attr('src','/images/icon_viatura/ambulanciaDark.png');
          $('#helicoptro_ic').attr('src','/images/icon_viatura/heliLight.png');
          $('#carro_ic').attr('src','/images/icon_viatura/carroLight.png');
          $('#mota_ic').attr('src','/images/icon_viatura/motoLight.png');

          $('#hiddenviatura').attr('value','Ambulância');
        }else{
          $('#ambulancia_ic').attr('src','/images/icon_viatura/ambulanciaLight.png');
          $('#hiddenviatura').attr('value','');
        }
      }

      function mudaMota(){
        if($('#mota_ic').attr('src') == '/images/icon_viatura/motoLight.png'){
          $('#mota_ic').attr('src','/images/icon_viatura/motoDark.png');
          $('#helicoptro_ic').attr('src','/images/icon_viatura/heliLight.png');
          $('#carro_ic').attr('src','/images/icon_viatura/carroLight.png');
          $('#ambulancia_ic').attr('src','/images/icon_viatura/ambulanciaLight.png');

          $('#hiddenviatura').attr('value','Mota');

        }else{
          $('#mota_ic').attr('src','/images/icon_viatura/motoLight.png');
          $('#hiddenviatura').attr('value','');
        }
      }
