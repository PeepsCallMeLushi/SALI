package pt.sali.sali;

import android.app.Application;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import java.util.ArrayList;

import pt.sali.sali.model.Atuacao;
import pt.sali.sali.model.Avaliacao;
import pt.sali.sali.model.Equipa;
import pt.sali.sali.model.Farmaco;
import pt.sali.sali.model.Freguesia;
import pt.sali.sali.model.Login;
import pt.sali.sali.model.Ocorrencia;
import pt.sali.sali.model.Pergunta;
import pt.sali.sali.model.Role;
import pt.sali.sali.model.Utente;
import pt.sali.sali.model.Utilizador;

public class AppSali extends Application {

    public final static int RIGHT = 1, LEFT= 2,STATIC=0;
    public final static String KUSER = "kuser", KPARTNER = "kpartner", KOCORRENCIAS ="kocorrencias";


    String username;
    String password;
    Utilizador user;
    Utilizador parceiro;
    Ocorrencia o;
    Avaliacao ava;
    Atuacao atu;
    Equipa eq;
    ArrayList<Farmaco> arFarmacos;
    ArrayList<Freguesia> arFreguseias;
    ArrayList<Pergunta> arPerguntas;
    ArrayList<Utilizador> arUtilizadores;
    ArrayList<Ocorrencia> arOcorrencias;
    Utente u;
    SharedPreferences sharedPreferences;

    @Override
    public void onCreate() {
        super.onCreate();
        o = new Ocorrencia();
        arFarmacos = new ArrayList<>();
        arFreguseias = new ArrayList<>();
        arPerguntas = new ArrayList<>();
        arUtilizadores = new ArrayList<>();
        arOcorrencias = new ArrayList<>();
        eq = new Equipa();
        sharedPreferences = this.getSharedPreferences(AppSali.class.getName(),MODE_PRIVATE);
        loadMockUpData();
    }

    private void loadMockUpData(){

        Utilizador m = new Utilizador("João",new Role("Medico"), "123","Pediatria",new Login("123","123"), "activo");
        Utilizador e = new Utilizador("Joana",new Role("Enfermeiro"),"123","Anatesia",new Login("123","123"), "activo");


        setUser(m);
        if (user.getRole().getNome().compareTo("Medico")==0){
            Utilizador e2 = new Utilizador("Maria",new Role("Enfermeiro"),"456","Vacinação",new Login("456","123"), "activo");
            Utilizador e3 = new Utilizador("Francisca",new Role("Enfermeiro"),"789","Analises",new Login("456","123"), "activo");
            arUtilizadores.add(e);
            arUtilizadores.add(e2);
            arUtilizadores.add(e3);
            eq.setMedico(getUser());
        }else if(user.getRole().getNome().compareTo("Enfermeiro")==0){
            Utilizador m2 = new Utilizador("Pedro",new Role("Medico"), "456","Genecologia",new Login("123","123"), "activo");
            Utilizador m3 = new Utilizador("Manuel",new Role("Medico"), "789","Ortopedia",new Login("123","123"), "activo");
            arUtilizadores.add(m);
            arUtilizadores.add(m2);
            arUtilizadores.add(m3);
            eq.setEnfermeiro(getUser());
        }


    }

    public void saveUtilizador(Utilizador u){
        String obj = new Gson().toJson(u);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KUSER, obj);
        editor.commit();
    }

    public Utilizador loadUtilizador(){
        String jobj = sharedPreferences.getString(KUSER,"");
        Utilizador u = new Gson().fromJson(jobj,Utilizador.class);
        return u;
    }

    public void savePartner(Utilizador u){
        String obj = new Gson().toJson(u);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KPARTNER, obj);
        editor.commit();
    }

    public Utilizador loadPartner(){
        String jobj = sharedPreferences.getString(KPARTNER,"");
        Utilizador u = new Gson().fromJson(jobj,Utilizador.class);
        return u;
    }



    public Ocorrencia getO() {
        return o;
    }

    public void setO(Ocorrencia o) {
        this.o = o;
    }

    public Avaliacao getAva() {
        return ava;
    }

    public void setAva(Avaliacao ava) {
        this.ava = ava;
    }

    public Atuacao getAtu() {
        return atu;
    }

    public void setAtu(Atuacao atu) {
        this.atu = atu;
    }

    public Equipa getEq() {
        return eq;
    }

    public void setEq(Equipa eq) {
        this.eq = eq;
    }

    public ArrayList<Farmaco> getArFarmacos() {
        return arFarmacos;
    }

    public void setArFarmacos(ArrayList<Farmaco> arFarmacos) {
        this.arFarmacos = arFarmacos;
    }

    public ArrayList<Freguesia> getArFreguseias() {
        return arFreguseias;
    }

    public void setArFreguseias(ArrayList<Freguesia> arFreguseias) {
        this.arFreguseias = arFreguseias;
    }

    public ArrayList<Pergunta> getArPerguntas() {
        return arPerguntas;
    }

    public void setArPerguntas(ArrayList<Pergunta> arPerguntas) {
        this.arPerguntas = arPerguntas;
    }

    public Utente getU() {
        return u;
    }

    public void setU(Utente u) {
        this.u = u;
    }

    public ArrayList<Utilizador> getArUtilizadores() {
        return arUtilizadores;
    }

    public void setArUtilizadores(ArrayList<Utilizador> arUtilizadores) {
        this.arUtilizadores = arUtilizadores;
    }

    public Utilizador getUser() {
        return user;
    }

    public void setUser(Utilizador user) {
        this.user = user;
    }

    public Utilizador getParceiro() {
        return parceiro;
    }

    public void setParceiro(Utilizador parceiro) {
        this.parceiro = parceiro;
    }

    public ArrayList<Ocorrencia> getArOcorrencias() {
        return arOcorrencias;
    }

    public void setArOcorrencias(ArrayList<Ocorrencia> arOcorrencias) {
        this.arOcorrencias = arOcorrencias;
    }
}
