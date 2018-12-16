$(document).ready(function(){

/*
$("#cabeca").hide();
$("#pescoco").hide();
$("#peito_drt").hide();
$("#costela_drt").hide();
$("#obliquo_drt").hide();
$("#abdomen").hide();
$("#obliquo_esq").hide();
$("#ombro_drt").hide();
$("#antebraco_esq").hide();
$("#antebraco_drt").hide();
$("#braco_drt").hide();
$("#braco_esq").hide();
$("#mao_drt").hide();
$("#mao_esq").hide();
$("#coxa_drt").hide();
$("#joelho_drt").hide();
$("#peito_esq").hide();
$("#ombro_esq").hide();
$("#anteperna_drt").hide();
$("#pe_drt").hide();
$("#pe_esq").hide();
$("#coxa_esq").hide();
$("#pe_drt").hide();
$("#joelho_esq").hide();
$("#anteperna_esq").hide();*/


$("#dropdownMenu2").click(function(){
  $("#corpo").toggle();
});

$("#dropdownMenu3").click(function(){
  $("#costas").toggle();
});

$("#dropdownMenu4").click(function(){
  $("#farmacos").toggle();
});



$("#all").click(function(){
     $("#all").toggle();
     if($(".st0").hasClass("xpto") == true){
       $(".st0").removeClass("xpto");
       $("#cabeca").attr('checked',false);
       $("#pescoco").attr('checked',false);
        $("#peito_drt").attr('checked',false);
        $("#costela_drt").attr('checked',false);
        $("#obliquo_drt").attr('checked',false);
        $("#abdomen").attr('checked',false);
        $("#obliquo_esq").attr('checked',false);
        $("#ombro_drt").attr('checked',false);
        $("#antebraco_esq").attr('checked',false);
        $("#braco_drt").attr('checked',false);
        $("#costela_esq").attr('checked',false);
        $("#antebraco_drt").attr('checked',false);
        $("#braco_esq").attr('checked',false);
        $("#mao_drt").attr('checked',false);
        $("#mao_esq").attr('checked',false);
        $("#coxa_drt").attr('checked',false);
        $("#joelho_drt").attr('checked',false);
        $("#peito_esq").attr('checked',false);
        $("#ombro_esq").attr('checked',false);
        $("#anteperna_drt").attr('checked',false);
        $("#pe_drt").attr('checked',false);
        $("#pe_esq").attr('checked',false);
        $("#coxa_esq").attr('checked',false);
        $("#joelho_esq").attr('checked',false);
        $("#anteperna_esq").attr('checked',false);
     }else{
       $(".st0").addClass("xpto");
       $("#cabeca").attr('checked',true);
       $("#pescoco").attr('checked',true);
        $("#peito_drt").attr('checked',true);
        $("#costela_drt").attr('checked',true);
        $("#obliquo_drt").attr('checked',true);
        $("#abdomen").attr('checked',true);
        $("#obliquo_esq").attr('checked',true);
        $("#ombro_drt").attr('checked',true);
        $("#antebraco_esq").attr('checked',true);
        $("#braco_drt").attr('checked',true);
        $("#costela_esq").attr('checked',true);
        $("#antebraco_drt").attr('checked',true);
        $("#braco_esq").attr('checked',true);
        $("#mao_drt").attr('checked',true);
        $("#mao_esq").attr('checked',true);
        $("#coxa_drt").attr('checked',true);
        $("#joelho_drt").attr('checked',true);
        $("#peito_esq").attr('checked',true);
        $("#ombro_esq").attr('checked',true);
        $("#anteperna_drt").attr('checked',true);
        $("#pe_drt").attr('checked',true);
        $("#pe_esq").attr('checked',true);
        $("#coxa_esq").attr('checked',true);
        $("#joelho_esq").attr('checked',true);
        $("#anteperna_esq").attr('checked',true);
     }
});
$(".all").click(function(){
     $("#all").toggle();
     if($(".st0").hasClass("xpto") == true){
       $(".st0").removeClass("xpto");
       $("#all").attr('checked',false);

     }else{
       $(".st0").addClass("xpto");

       }
});

$("#cabeca").click(function(){
     $("#cabeca").toggle();
     if($(".st1").hasClass("xpto") == true){
       $(".st1").removeClass("xpto");
     }else{
       $(".st1").addClass("xpto");
     }
});
$(".cabeca").click(function(){
     $("#cabeca").toggle();
     if($(".st1").hasClass("xpto") == true){
       $(".st1").removeClass("xpto");
       $("#cabeca").attr('checked',false);
     }else{
       $(".st1").addClass("xpto");
       $("#cabeca").attr('checked',true);
     }
      //alert($("#cabeca").val());
});

$("#pescoco").click(function(){
  $("#pescoco").toggle();
  if($(".st2").hasClass("xpto") == true){
    $(".st2").removeClass("xpto");
  }else{
    $(".st2").addClass("xpto");
  }
});

$(".pescoco").click(function(){
  $("#pescoco").toggle();
  if($(".st2").hasClass("xpto") == true){
    $(".st2").removeClass("xpto");
     $("#pescoco").attr('checked',false);
  }else{
    $(".st2").addClass("xpto");
     $("#cabeca").attr('checked',true);
  }
});


$("#peito_drt").click(function(){
     $("#peito_drt").toggle();
     if($(".st3").hasClass("xpto") == true){
       $(".st3").removeClass("xpto");
     }else{
       $(".st3").addClass("xpto");
     }
});
$(".peito_drt").click(function(){
     $("#peito_drt").toggle();
     if($(".st3").hasClass("xpto") == true){
       $(".st3").removeClass("xpto");
       $("#peito_drt").attr('checked',false);
     }else{
       $(".st3").addClass("xpto");
       $("#peito_drt").attr('checked',true);
     }
    //  alert($("#cabeca").val());
});



$("#costela_drt").click(function(){
     $("#costela_drt").toggle();
     if($(".st4").hasClass("xpto") == true){
       $(".st4").removeClass("xpto");
     }else{
       $(".st4").addClass("xpto");
     }
});
$(".costela_drt").click(function(){
     $("#costela_drt").toggle();
     if($(".st4").hasClass("xpto") == true){
       $(".st4").removeClass("xpto");
       $("#peito_drt").attr('checked',false);
     }else{
       $(".st4").addClass("xpto");
       $("#costela_drt").attr('checked',true);
     }
    //  alert($("#cabeca").val());
});



$("#obliquo_drt").click(function(){
     $("#obliquo_drt").toggle();
     if($(".st5").hasClass("xpto") == true){
       $(".st5").removeClass("xpto");
     }else{
       $(".st5").addClass("xpto");
     }
});
$(".obliquo_drt").click(function(){
     $("#obliquo_drt").toggle();
     if($(".st5").hasClass("xpto") == true){
       $(".st5").removeClass("xpto");
       $("#obliquo_drt").attr('checked',false);
     }else{
       $(".st5").addClass("xpto");
       $("#obliquo_drt").attr('checked',true);
     }
    //  alert($("#cabeca").val());
});



$("#abdomen").click(function(){
     $("#abdomen").toggle();
     if($(".st6").hasClass("xpto") == true){
       $(".st6").removeClass("xpto");
     }else{
       $(".st6").addClass("xpto");
     }
});
$(".abdomen").click(function(){
     $("#abdomen").toggle();
     if($(".st6").hasClass("xpto") == true){
       $(".st6").removeClass("xpto");
       $("#abdomen").attr('checked',false);
     }else{
       $(".st6").addClass("xpto");
       $("#abdomen").attr('checked',true);
     }
    //  alert($("#cabeca").val());
});


$("#obliquo_esq").click(function(){
     $("#obliquo_esq").toggle();
     if($(".st7").hasClass("xpto") == true){
       $(".st7").removeClass("xpto");
     }else{
       $(".st7").addClass("xpto");
     }
});
$(".obliquo_esq").click(function(){
     $("#obliquo_esq").toggle();
     if($(".st7").hasClass("xpto") == true){
       $(".st7").removeClass("xpto");
       $("#obliquo_esq").attr('checked',false);
     }else{
       $(".st7").addClass("xpto");
       $("#obliquo_esq").attr('checked',true);
     }
    //  alert($("#cabeca").val());
});


$("#ombro_drt").click(function(){
     $("#ombro_drt").toggle();
     if($(".st8").hasClass("xpto") == true){
       $(".st8").removeClass("xpto");
     }else{
       $(".st8").addClass("xpto");
     }
});
$(".ombro_drt").click(function(){
     $("#ombro_drt").toggle();
     if($(".st8").hasClass("xpto") == true){
       $(".st8").removeClass("xpto");
       $("#ombro_drt").attr('checked',false);
     }else{
       $(".st8").addClass("xpto");
       $("#ombro_drt").attr('checked',true);
     }
    //  alert($("#cabeca").val());
});


$("#antebraco_esq").click(function(){
     $("#antebraco_esq").toggle();
     if($(".st9").hasClass("xpto") == true){
       $(".st9").removeClass("xpto");
     }else{
       $(".st9").addClass("xpto");
     }
});
$(".antebraco_esq").click(function(){
     $("#antebraco_esq").toggle();
     if($(".st9").hasClass("xpto") == true){
       $(".st9").removeClass("xpto");
       $("#antebraco_esq").attr('checked',false);
     }else{
       $(".st9").addClass("xpto");
       $("#antebraco_esq").attr('checked',true);
     }
    //  alert($("#cabeca").val());
});

$("#braco_drt").click(function(){
     $("#braco_drt").toggle();
     if($(".st10").hasClass("xpto") == true){
       $(".st10").removeClass("xpto");
     }else{
       $(".st10").addClass("xpto");
     }
});
$(".braco_drt").click(function(){
     $("#braco_drt").toggle();
     if($(".st10").hasClass("xpto") == true){
       $(".st10").removeClass("xpto");
       $("#braco_drt").attr('checked',false);
     }else{
       $(".st10").addClass("xpto");
       $("#braco_drt").attr('checked',true);
     }
    //  alert($("#cabeca").val());
});

$("#costela_esq").click(function(){
     $("#costela_esq").toggle();
     if($(".st11").hasClass("xpto") == true){
       $(".st11").removeClass("xpto");
     }else{
       $(".st11").addClass("xpto");
     }
});
$(".costela_esq").click(function(){
     $("#costela_esq").toggle();
     if($(".st11").hasClass("xpto") == true){
       $(".st11").removeClass("xpto");
       $("#costela_esq").attr('checked',false);
     }else{
       $(".st11").addClass("xpto");
       $("#costela_esq").attr('checked',true);
     }
    //  alert($("#cabeca").val());
});

$("#antebraco_drt").click(function(){
     $("#antebraco_drt").toggle();
     if($(".st12").hasClass("xpto") == true){
       $(".st12").removeClass("xpto");
     }else{
       $(".st12").addClass("xpto");
     }
});
$(".antebraco_drt").click(function(){
     $("#antebraco_drt").toggle();
     if($(".st12").hasClass("xpto") == true){
       $(".st12").removeClass("xpto");
       $("#antebraco_drt").attr('checked',false);
     }else{
       $(".st12").addClass("xpto");
       $("#antebraco_drt").attr('checked',true);
     }
    //  alert($("#cabeca").val());
});

$("#braco_esq").click(function(){
     $("#braco_esq").toggle();
     if($(".st13").hasClass("xpto") == true){
       $(".st13").removeClass("xpto");
     }else{
       $(".st13").addClass("xpto");
     }
});
$(".braco_esq").click(function(){
     $("#braco_esq").toggle();
     if($(".st13").hasClass("xpto") == true){
       $(".st13").removeClass("xpto");
       $("#braco_esq").attr('checked',false);
     }else{
       $(".st13").addClass("xpto");
       $("#braco_esq").attr('checked',true);
     }
    //  alert($("#cabeca").val());
});

$("#mao_drt").click(function(){
     $("#mao_drt").toggle();
     if($(".st14").hasClass("xpto") == true){
       $(".st14").removeClass("xpto");
     }else{
       $(".st14").addClass("xpto");
     }
});
$(".mao_drt").click(function(){
     $("#mao_drt").toggle();
     if($(".st14").hasClass("xpto") == true){
       $(".st14").removeClass("xpto");
       $("#mao_drt").attr('checked',false);
     }else{
       $(".st14").addClass("xpto");
       $("#mao_drt").attr('checked',true);
     }
    //  alert($("#cabeca").val());
});

$("#mao_esq").click(function(){
     $("#mao_esq").toggle();
     if($(".st15").hasClass("xpto") == true){
       $(".st15").removeClass("xpto");
     }else{
       $(".st15").addClass("xpto");
     }
});
$(".mao_esq").click(function(){
     $("#mao_esq").toggle();
     if($(".st15").hasClass("xpto") == true){
       $(".st15").removeClass("xpto");
       $("#mao_esq").attr('checked',false);
     }else{
       $(".st15").addClass("xpto");
       $("#mao_esq").attr('checked',true);
     }
    //  alert($("#cabeca").val());
});

$("#coxa_drt").click(function(){
     $("#coxa_drt").toggle();
     if($(".st16").hasClass("xpto") == true){
       $(".st16").removeClass("xpto");
     }else{
       $(".st16").addClass("xpto");
     }
});
$(".coxa_drt").click(function(){
     $("#coxa_drt").toggle();
     if($(".st16").hasClass("xpto") == true){
       $(".st16").removeClass("xpto");
       $("#coxa_drt").attr('checked',false);
     }else{
       $(".st16").addClass("xpto");
       $("#coxa_drt").attr('checked',true);
     }
    //  alert($("#cabeca").val());
});

$("#joelho_drt").click(function(){
     $("#joelho_drt").toggle();
     if($(".st17").hasClass("xpto") == true){
       $(".st17").removeClass("xpto");
     }else{
       $(".st17").addClass("xpto");
     }
});
$(".joelho_drt").click(function(){
     $("#joelho_drt").toggle();
     if($(".st17").hasClass("xpto") == true){
       $(".st17").removeClass("xpto");
       $("#joelho_drt").attr('checked',false);
     }else{
       $(".st17").addClass("xpto");
       $("#joelho_drt").attr('checked',true);
     }
    //  alert($("#cabeca").val());
});

$("#peito_esq").click(function(){
     $("#peito_esq").toggle();
     if($(".st18").hasClass("xpto") == true){
       $(".st18").removeClass("xpto");
     }else{
       $(".st18").addClass("xpto");
     }
});
$(".peito_esq").click(function(){
     $("#peito_esq").toggle();
     if($(".st18").hasClass("xpto") == true){
       $(".st18").removeClass("xpto");
       $("#peito_esq").attr('checked',false);
     }else{
       $(".st18").addClass("xpto");
       $("#peito_esq").attr('checked',true);
     }
    //  alert($("#cabeca").val());
});

$("#ombro_esq").click(function(){
     $("#ombro_esq").toggle();
     if($(".st19").hasClass("xpto") == true){
       $(".st19").removeClass("xpto");
     }else{
       $(".st19").addClass("xpto");
     }
});
$(".ombro_esq").click(function(){
     $("#ombro_esq").toggle();
     if($(".st19").hasClass("xpto") == true){
       $(".st19").removeClass("xpto");
       $("#ombro_esq").attr('checked',false);
     }else{
       $(".st19").addClass("xpto");
       $("#ombro_esq").attr('checked',true);
     }
    //  alert($("#cabeca").val());
});

$("#anteperna_drt").click(function(){
     $("#anteperna_drt").toggle();
     if($(".st20").hasClass("xpto") == true){
       $(".st20").removeClass("xpto");
     }else{
       $(".st20").addClass("xpto");
     }
});
$(".anteperna_drt").click(function(){
     $("#anteperna_drt").toggle();
     if($(".st20").hasClass("xpto") == true){
       $(".st20").removeClass("xpto");
       $("#anteperna_drt").attr('checked',false);
     }else{
       $(".st20").addClass("xpto");
       $("#anteperna_drt").attr('checked',true);
     }
    //  alert($("#cabeca").val());
});

$("#pe_drt").click(function(){
     $("#pe_drt").toggle();
     if($(".st21").hasClass("xpto") == true){
       $(".st21").removeClass("xpto");
     }else{
       $(".st21").addClass("xpto");
     }
});
$(".pe_drt").click(function(){
     $("#pe_drt").toggle();
     if($(".st21").hasClass("xpto") == true){
       $(".st21").removeClass("xpto");
       $("#pe_drt").attr('checked',false);
     }else{
       $(".st21").addClass("xpto");
       $("#pe_drt").attr('checked',true);
     }
    //  alert($("#cabeca").val());
});

$("#pe_esq").click(function(){
     $("#pe_esq").toggle();
     if($(".st22").hasClass("xpto") == true){
       $(".st22").removeClass("xpto");
     }else{
       $(".st22").addClass("xpto");
     }
});
$(".pe_esq").click(function(){
     $("#pe_esq").toggle();
     if($(".st22").hasClass("xpto") == true){
       $(".st22").removeClass("xpto");
       $("#pe_esq").attr('checked',false);
     }else{
       $(".st22").addClass("xpto");
       $("#pe_esq").attr('checked',true);
     }
    //  alert($("#cabeca").val());
});

$("#coxa_esq").click(function(){
     $("#coxa_esq").toggle();
     if($(".st23").hasClass("xpto") == true){
       $(".st23").removeClass("xpto");
     }else{
       $(".st23").addClass("xpto");
     }
});
$(".coxa_esq").click(function(){
     $("#coxa_esq").toggle();
     if($(".st23").hasClass("xpto") == true){
       $(".st23").removeClass("xpto");
       $("#coxa_esq").attr('checked',false);
     }else{
       $(".st23").addClass("xpto");
       $("#coxa_esq").attr('checked',true);
     }
    //  alert($("#cabeca").val());
});

$("#joelho_esq").click(function(){
     $("#joelho_esq").toggle();
     if($(".st24").hasClass("xpto") == true){
       $(".st24").removeClass("xpto");
     }else{
       $(".st24").addClass("xpto");
     }
});
$(".joelho_esq").click(function(){
     $("#joelho_esq").toggle();
     if($(".st24").hasClass("xpto") == true){
       $(".st24").removeClass("xpto");
       $("#joelho_esq").attr('checked',false);
     }else{
       $(".st24").addClass("xpto");
       $("#joelho_esq").attr('checked',true);
     }
    //  alert($("#cabeca").val());
});

$("#anteperna_esq").click(function(){
     $("#anteperna_esq").toggle();
     if($(".st25").hasClass("xpto") == true){
       $(".st25").removeClass("xpto");
     }else{
       $(".st25").addClass("xpto");
     }
});
$(".anteperna_esq").click(function(){
     $("#anteperna_esq").toggle();
     if($(".st25").hasClass("xpto") == true){
       $(".st25").removeClass("xpto");
       $("#anteperna_esq").attr('checked',false);
     }else{
       $(".st25").addClass("xpto");
       $("#anteperna_esq").attr('checked',true);
     }
    //  alert($("#cabeca").val());
});



/*Corpo selecionado
var seleted=[];
$('#selecionaCorpo: selected').each(function(){
  selected[$(this).val()]=$(this).text();
  if($(this).text == "cabeca"){
//  $(".cabeca").click(function(){
       $("#cabeca").toggle();
       if($(".st1").hasClass("xpto") == true){
         $(".st1").removeClass("xpto");
       }else{
         $(".st1").addClass("xpto");
       }
  };
  if($(this).text == "pescoco"){
//  $(".cabeca").click(function(){
       $("#pescoco").toggle();
       if($(".st2").hasClass("xpto") == true){
         $(".st2").removeClass("xpto");
       }else{
         $(".st2").addClass("xpto");
       }
  };


//  console.log(Selected);
});*/

//COSTAS

$("#back").click(function(){
     $("#back").toggle();
     if($(".st200").hasClass("xpto") == true){
       $(".st200").removeClass("xpto");
       $("#costas_cabeça").attr('checked',false);
       $("#costas_pescoco").attr('checked',false);
       $("#costas_ trapezioEsq").attr('checked',false);
       $("#costas_gluteoEsq").attr('checked',false);
       $("#costas_gluteoDrt").attr('checked',false);
       $("#costas_dorsalDrt").attr('checked',false);
      $("#costas_antebracoEsq").attr('checked',false);
      $("#costas_peEsq").attr('checked',false);
      $("#costas_ombroDrt").attr('checked',false);
      $("#costas_ombroEsq").attr('checked',false);
      $("#costas_bracoEsq").attr('checked',false);
      $("#costas_cotoveloEsq").attr('checked',false);
      $("#costas_pernaEsq").attr('checked',false);
      $("#costas_antepernaDrt").attr('checked',false);
      $("#costas_pernaDrt").attr('checked',false);
      $("#costas_antepernaEsq").attr('checked',false);
      $("#costas_antebracoDrt").attr('checked',false);
      $("#costas_trapezioEsq").attr('checked',false);
      $("#costas_trapezio_drt").attr('checked',false);
      $("#costas_obliquoDrt").attr('checked',false);
      $("#costas_bracoDrt").attr('checked',false);
      $("#costas_cotoveloDrt").attr('checked',false);
      $("#costas_maoEsq").attr('checked',false);
       $("#costas_maoDrt").attr('checked',false);
      $("#costas_dorsalEsq").attr('checked',false);
      $("#costas_peDrt").attr('checked',false);
      $("#costas_obliquoEsq").attr('checked',false);

     }else{
       $(".st200").addClass("xpto");
       $("#back").attr('checked',true);
       $("#costas_cabeça").attr('checked',true);
       $("#costas_pescoco").attr('checked',true);
       $("#costas_ trapezioEsq").attr('checked',true);
       $("#costas_gluteoEsq").attr('checked',true);
       $("#costas_gluteoDrt").attr('checked',true);
       $("#costas_dorsalDrt").attr('checked',true);
      $("#costas_antebracoEsq").attr('checked',true);
      $("#costas_peEsq").attr('checked',true);
      $("#costas_ombroDrt").attr('checked',true);
      $("#costas_ombroEsq").attr('checked',true);
      $("#costas_bracoEsq").attr('checked',true);
      $("#costas_cotoveloEsq").attr('checked',true);
      $("#costas_pernaEsq").attr('checked',true);
      $("#costas_antepernaDrt").attr('checked',true);
      $("#costas_pernaDrt").attr('checked',true);
      $("#costas_antepernaEsq").attr('checked',true);
      $("#costas_antebracoDrt").attr('checked',true);
      $("#costas_trapezioEsq").attr('checked',true);
      $("#costas_trapezio_drt").attr('checked',true);
      $("#costas_obliquoDrt").attr('checked',true);
      $("#costas_bracoDrt").attr('checked',true);
      $("#costas_cotoveloDrt").attr('checked',true);
      $("#costas_maoEsq").attr('checked',true);
       $("#costas_maoDrt").attr('checked',true);
      $("#costas_dorsalEsq").attr('checked',true);
      $("#costas_peDrt").attr('checked',true);
      $("#costas_obliquoEsq").attr('checked',true);

     }
});
$(".back").click(function(){
     $("#back").toggle();
     if($(".st200").hasClass("xpto") == true){
       $(".st200").removeClass("xpto");
       $("#back").attr('checked',false);
     }else{
       $(".st200").addClass("xpto");
       $("#back").attr('checked',false);
     }
    //  alert($("#cabeca").val());
});


$("#costas_cabeça").click(function(){
     $("#costas_cabeça").toggle();
     if($(".st142").hasClass("xpto") == true){
       $(".st142").removeClass("xpto");
     }else{
       $(".st142").addClass("xpto");
     }
});
$(".costas_cabeça").click(function(){
     $("#costas_cabeça").toggle();
     if($(".st142").hasClass("xpto") == true){
       $(".st142").removeClass("xpto");
       $("#costas_cabeça").attr('checked',false);
     }else{
       $(".st142").addClass("xpto");
       $("#costas_cabeça").attr('checked',true);
     }
    //  alert($("#cabeca").val());
});

$("#costas_pescoco").click(function(){
     $("#costas_pescoco").toggle();
     if($(".st119").hasClass("xpto") == true){
       $(".st119").removeClass("xpto");
     }else{
       $(".st119").addClass("xpto");
     }
});
$(".costas_pescoco").click(function(){
     $("#costas_pescoco").toggle();
     if($(".st119").hasClass("xpto") == true){
       $(".st119").removeClass("xpto");
       $("#costas_pescoco").attr('checked',false);
     }else{
       $(".st119").addClass("xpto");
       $("#costas_pescoco").attr('checked',true);
     }
    //  alert($("#cabeca").val());
});

$("#costas_ trapezioEsq").click(function(){
     $("#costas_ trapezioEsq").toggle();
     if($(".st131").hasClass("xpto") == true){
       $(".st131").removeClass("xpto");
     }else{
       $(".st131").addClass("xpto");
     }
});
$(".costas_ trapezioEsq").click(function(){
     $("#costas_ trapezioEsq").toggle();
     if($(".st131").hasClass("xpto") == true){
       $(".st131").removeClass("xpto");
       $("#costas_ trapezioEsq").attr('checked',false);
     }else{
       $(".st131").addClass("xpto");
       $("#costas_ trapezioEsq").attr('checked',true);
     }
    //  alert($("#cabeca").val());
});


$("#costas_gluteoEsq").click(function(){
     $("#costas_gluteoEsq").toggle();
     if($(".st100").hasClass("xpto") == true){
       $(".st100").removeClass("xpto");
     }else{
       $(".st100").addClass("xpto");
     }
});
$(".costas_gluteoEsq").click(function(){
     $("#costas_gluteoEsq").toggle();
     if($(".st100").hasClass("xpto") == true){
       $(".st100").removeClass("xpto");
       $("#costas_gluteoEsq").attr('checked',false);
     }else{
       $(".st100").addClass("xpto");
       $("#costas_gluteoEsq").attr('checked',true);
     }
    //  alert($("#cabeca").val());
});

$("#costas_gluteoDrt").click(function(){
     $("#costas_gluteoDrt").toggle();
     if($(".st101").hasClass("xpto") == true){
       $(".st101").removeClass("xpto");
     }else{
       $(".st101").addClass("xpto");
     }
});
$(".costas_gluteoDrt").click(function(){
     $("#costas_gluteoDrt").toggle();
     if($(".st101").hasClass("xpto") == true){
       $(".st101").removeClass("xpto");
       $("#costas_gluteoDrt").attr('checked',false);
     }else{
       $(".st101").addClass("xpto");
       $("#costas_gluteoDrt").attr('checked',true);
     }
    //  alert($("#cabeca").val());
});

$("#costas_dorsalDrt").click(function(){
     $("#costas_dorsalDrt").toggle();
     if($(".st102").hasClass("xpto") == true){
       $(".st102").removeClass("xpto");
     }else{
       $(".st102").addClass("xpto");
     }
});
$(".costas_dorsalDrt").click(function(){
     $("#costas_dorsalDrt").toggle();
     if($(".st102").hasClass("xpto") == true){
       $(".st102").removeClass("xpto");
       $("#costas_gluteoDrt").attr('checked',false);
     }else{
       $(".st102").addClass("xpto");
       $("#costas_dorsalDrt").attr('checked',true);
     }
    //  alert($("#cabeca").val());
});

$("#costas_antebracoEsq").click(function(){
     $("#costas_antebracoEsq").toggle();
     if($(".st103").hasClass("xpto") == true){
       $(".st103").removeClass("xpto");
     }else{
       $(".st103").addClass("xpto");
     }
});
$(".costas_antebracoEsq").click(function(){
     $("#costas_antebracoEsq").toggle();
     if($(".st103").hasClass("xpto") == true){
       $(".st103").removeClass("xpto");
       $("#costas_gluteoDrt").attr('checked',false);
     }else{
       $(".st103").addClass("xpto");
       $("#costas_antebracoEsq").attr('checked',true);
     }
    //  alert($("#cabeca").val());
});

$("#costas_peEsq").click(function(){
     $("#costas_peEsq").toggle();
     if($(".st104").hasClass("xpto") == true){
       $(".st104").removeClass("xpto");
     }else{
       $(".st104").addClass("xpto");
     }
});
$(".costas_peEsq").click(function(){
     $("#costas_peEsq").toggle();
     if($(".st104").hasClass("xpto") == true){
       $(".st104").removeClass("xpto");
       $("#costas_gluteoDrt").attr('checked',false);
     }else{
       $(".st104").addClass("xpto");
       $("#costas_peEsq").attr('checked',true);
     }
    //  alert($("#cabeca").val());
});

$("#costas_ombroDrt").click(function(){
     $("#costas_ombroDrt").toggle();
     if($(".st108").hasClass("xpto") == true){
       $(".st108").removeClass("xpto");
     }else{
       $(".st108").addClass("xpto");
     }
});
$(".costas_ombroDrt").click(function(){
     $("#costas_ombroDrt").toggle();
     if($(".st108").hasClass("xpto") == true){
       $(".st108").removeClass("xpto");
       $("#costas_gluteoDrt").attr('checked',false);
     }else{
       $(".st108").addClass("xpto");
       $("#costas_ombroDrt").attr('checked',true);
     }
    //  alert($("#cabeca").val());
});


$("#costas_ombroEsq").click(function(){
     $("#costas_ombroEsq").toggle();
     if($(".st109").hasClass("xpto") == true){
       $(".st109").removeClass("xpto");
     }else{
       $(".st109").addClass("xpto");
     }
});
$(".costas_ombroEsq").click(function(){
     $("#costas_ombroEsq").toggle();
     if($(".st109").hasClass("xpto") == true){
       $(".st109").removeClass("xpto");
       $("#costas_gluteoDrt").attr('checked',false);
     }else{
       $(".st109").addClass("xpto");
       $("#costas_ombroEsq").attr('checked',true);
     }
    //  alert($("#cabeca").val());
});

$("#costas_bracoEsq").click(function(){
     $("#costas_bracoEsq").toggle();
     if($(".st140").hasClass("xpto") == true){
       $(".st140").removeClass("xpto");
     }else{
       $(".st140").addClass("xpto");
     }
});
$(".costas_bracoEsq").click(function(){
     $("#costas_bracoEsq").toggle();
     if($(".st140").hasClass("xpto") == true){
       $(".st140").removeClass("xpto");
       $("#costas_gluteoDrt").attr('checked',false);
     }else{
       $(".st140").addClass("xpto");
       $("#costas_bracoEsq").attr('checked',true);
     }
    //  alert($("#cabeca").val());
});

$("#costas_cotoveloEsq").click(function(){
     $("#costas_cotoveloEsq").toggle();
     if($(".st150").hasClass("xpto") == true){
       $(".st150").removeClass("xpto");
     }else{
       $(".st150").addClass("xpto");
     }
});
$(".costas_cotoveloEsq").click(function(){
     $("#costas_cotoveloEsq").toggle();
     if($(".st150").hasClass("xpto") == true){
       $(".st150").removeClass("xpto");
       $("#costas_gluteoDrt").attr('checked',false);
     }else{
       $(".st150").addClass("xpto");
       $("#costas_cotoveloEsq").attr('checked',true);
     }
    //  alert($("#cabeca").val());
});

$("#costas_pernaEsq").click(function(){
     $("#costas_pernaEsq").toggle();
     if($(".st120").hasClass("xpto") == true){
       $(".st120").removeClass("xpto");
     }else{
       $(".st120").addClass("xpto");
     }
});
$(".costas_pernaEsq").click(function(){
     $("#costas_pernaEsq").toggle();
     if($(".st120").hasClass("xpto") == true){
       $(".st120").removeClass("xpto");
       $("#costas_pernaEsq").attr('checked',false);
     }else{
       $(".st120").addClass("xpto");
       $("#costas_pernaEsq").attr('checked',true);
     }
    //  alert($("#cabeca").val());
});

$("#costas_antepernaDrt").click(function(){
     $("#costas_antepernaDrt").toggle();
     if($(".st121").hasClass("xpto") == true){
       $(".st121").removeClass("xpto");
     }else{
       $(".st121").addClass("xpto");
     }
});
$(".costas_antepernaDrt").click(function(){
     $("#costas_antepernaDrt").toggle();
     if($(".st121").hasClass("xpto") == true){
       $(".st121").removeClass("xpto");
       $("#costas_antepernaDrt").attr('checked',false);
     }else{
       $(".st121").addClass("xpto");
       $("#costas_antepernaDrt").attr('checked',true);
     }
    //  alert($("#cabeca").val());
});

$("#costas_pernaDrt").click(function(){
     $("#costas_pernaDrt").toggle();
     if($(".st123").hasClass("xpto") == true){
       $(".st123").removeClass("xpto");
     }else{
       $(".st123").addClass("xpto");
     }
});
$(".costas_pernaDrt").click(function(){
     $("#costas_pernaDrt").toggle();
     if($(".st123").hasClass("xpto") == true){
       $(".st123").removeClass("xpto");
       $("#costas_pernaDrt").attr('checked',false);
     }else{
       $(".st123").addClass("xpto");
       $("#costas_pernaDrt").attr('checked',true);
     }
    //  alert($("#cabeca").val());
});

$("#costas_antepernaEsq").click(function(){
     $("#costas_antepernaEsq").toggle();
     if($(".st125").hasClass("xpto") == true){
       $(".st125").removeClass("xpto");
     }else{
       $(".st125").addClass("xpto");
     }
});
$(".costas_antepernaEsq").click(function(){
     $("#costas_antepernaEsq").toggle();
     if($(".st125").hasClass("xpto") == true){
       $(".st125").removeClass("xpto");
       $("#costas_antepernaEsq").attr('checked',false);
     }else{
       $(".st125").addClass("xpto");
       $("#costas_antepernaEsq").attr('checked',true);
     }
    //  alert($("#cabeca").val());
});

$("#costas_antebracoDrt").click(function(){
     $("#costas_antebracoDrt").toggle();
     if($(".st129").hasClass("xpto") == true){
       $(".st129").removeClass("xpto");
     }else{
       $(".st129").addClass("xpto");
     }
});
$(".costas_antebracoDrt").click(function(){
     $("#costas_antebracoDrt").toggle();
     if($(".st129").hasClass("xpto") == true){
       $(".st129").removeClass("xpto");
       $("#costas_antebracoDrt").attr('checked',false);
     }else{
       $(".st129").addClass("xpto");
       $("#costas_antebracoDrt").attr('checked',true);
     }
    //  alert($("#cabeca").val());
});

$("#costas_trapezioEsq").click(function(){
     $("#costas_trapezioEsq").toggle();
     if($(".st131").hasClass("xpto") == true){
       $(".st131").removeClass("xpto");
     }else{
       $(".st131").addClass("xpto");
     }
});
$(".costas_trapezioEsq").click(function(){
     $("#costas_trapezioEsq").toggle();
     if($(".st131").hasClass("xpto") == true){
       $(".st131").removeClass("xpto");
       $("#costas_trapezioEsq").attr('checked',false);
     }else{
       $(".st131").addClass("xpto");
       $("#costas_trapezioEsq").attr('checked',true);
     }
    //  alert($("#cabeca").val());
});


$("#costas_trapezio_drt").click(function(){
     $("#costas_trapezio_drt").toggle();
     if($(".st112").hasClass("xpto") == true){
       $(".st112").removeClass("xpto");
     }else{
       $(".st112").addClass("xpto");
     }
});
$(".costas_trapezio_drt").click(function(){
     $("#costas_trapezio_drt").toggle();
     if($(".st112").hasClass("xpto") == true){
       $(".st112").removeClass("xpto");
       $("#costas_trapezio_drt").attr('checked',false);
     }else{
       $(".st112").addClass("xpto");
       $("#costas_trapezio_drt").attr('checked',true);
     }
    //  alert($("#cabeca").val());
});

$("#costas_obliquoDrt").click(function(){
     $("#costas_obliquoDrt").toggle();
     if($(".st132").hasClass("xpto") == true){
       $(".st132").removeClass("xpto");
     }else{
       $(".st132").addClass("xpto");
     }
});
$(".costas_obliquoDrt").click(function(){
     $("#costas_obliquoDrt").toggle();
     if($(".st132").hasClass("xpto") == true){
       $(".st132").removeClass("xpto");
       $("#costas_obliquoDrt").attr('checked',false);
     }else{
       $(".st132").addClass("xpto");
       $("#costas_obliquoDrt").attr('checked',true);
     }
    //  alert($("#cabeca").val());
});

$("#costas_bracoDrt").click(function(){
     $("#costas_bracoDrt").toggle();
     if($(".st133").hasClass("xpto") == true){
       $(".st133").removeClass("xpto");
     }else{
       $(".st133").addClass("xpto");
     }
});
$(".costas_bracoDrt").click(function(){
     $("#costas_bracoDrt").toggle();
     if($(".st133").hasClass("xpto") == true){
       $(".st133").removeClass("xpto");
       $("#costas_bracoDrt").attr('checked',false);
     }else{
       $(".st133").addClass("xpto");
       $("#costas_bracoDrt").attr('checked',true);
     }
    //  alert($("#cabeca").val());
});

$("#costas_cotoveloDrt").click(function(){
     $("#costas_cotoveloDrt").toggle();
     if($(".st160").hasClass("xpto") == true){
       $(".st160").removeClass("xpto");
     }else{
       $(".st160").addClass("xpto");
     }
});
$(".costas_cotoveloDrt").click(function(){
     $("#costas_cotoveloDrt").toggle();
     if($(".st160").hasClass("xpto") == true){
       $(".st160").removeClass("xpto");
       $("#costas_cotoveloDrt").attr('checked',false);
     }else{
       $(".st160").addClass("xpto");
       $("#costas_cotoveloDrt").attr('checked',true);
     }
    //  alert($("#cabeca").val());
});

$("#costas_maoEsq").click(function(){
     $("#costas_maoEsq").toggle();
     if($(".st134").hasClass("xpto") == true){
       $(".st134").removeClass("xpto");
     }else{
       $(".st134").addClass("xpto");
     }
});
$(".costas_maoEsq").click(function(){
     $("#costas_maoEsq").toggle();
     if($(".st134").hasClass("xpto") == true){
       $(".st134").removeClass("xpto");
       $("#costas_maoEsq").attr('checked',false);
     }else{
       $(".st134").addClass("xpto");
       $("#costas_maoEsq").attr('checked',true);
     }
    //  alert($("#cabeca").val());
});

$("#costas_maoDrt").click(function(){
     $("#costas_maoDrt").toggle();
     if($(".st107").hasClass("xpto") == true){
       $(".st107").removeClass("xpto");
     }else{
       $(".st107").addClass("xpto");
     }
});
$(".costas_maoDrt").click(function(){
     $("#costas_maoDrt").toggle();
     if($(".st107").hasClass("xpto") == true){
       $(".st107").removeClass("xpto");
       $("#costas_maoDrt").attr('checked',false);
     }else{
       $(".st107").addClass("xpto");
       $("#costas_maoDrt").attr('checked',true);
     }
    //  alert($("#cabeca").val());
});

$("#costas_dorsalEsq").click(function(){
     $("#costas_dorsalEsq").toggle();
     if($(".st135").hasClass("xpto") == true){
       $(".st135").removeClass("xpto");
     }else{
       $(".st135").addClass("xpto");
     }
});
$(".costas_dorsalEsq").click(function(){
     $("#costas_dorsalEsq").toggle();
     if($(".st135").hasClass("xpto") == true){
       $(".st135").removeClass("xpto");
       $("#costas_dorsalEsq").attr('checked',false);
     }else{
       $(".st135").addClass("xpto");
       $("#costas_dorsalEsq").attr('checked',true);
     }
    //  alert($("#cabeca").val());
});

$("#costas_peDrt").click(function(){
     $("#costas_peDrt").toggle();
     if($(".st136").hasClass("xpto") == true){
       $(".st136").removeClass("xpto");
     }else{
       $(".st136").addClass("xpto");
     }
});
$(".costas_peDrt").click(function(){
     $("#costas_peDrt").toggle();
     if($(".st136").hasClass("xpto") == true){
       $(".st136").removeClass("xpto");
       $("#costas_peDrt").attr('checked',false);
     }else{
       $(".st136").addClass("xpto");
       $("#costas_peDrt").attr('checked',true);
     }
    //  alert($("#cabeca").val());
});


$("#costas_obliquoEsq").click(function(){
     $("#costas_obliquoEsq").toggle();
     if($(".st141").hasClass("xpto") == true){
       $(".st141").removeClass("xpto");
     }else{
       $(".st141").addClass("xpto");
     }
});
$(".costas_obliquoEsq").click(function(){
     $("#costas_obliquoEsq").toggle();
     if($(".st141").hasClass("xpto") == true){
       $(".st141").removeClass("xpto");
       $("#costas_obliquoEsq").attr('checked',false);
     }else{
       $(".st141").addClass("xpto");
       $("#costas_obliquoEsq").attr('checked',true);
     }
    //  alert($("#cabeca").val());
});



});
