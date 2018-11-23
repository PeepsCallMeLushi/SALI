package pt.sali.sali;

import android.app.Application;

import java.util.ArrayList;

import pt.sali.sali.model.Atuacao;
import pt.sali.sali.model.Avaliacao;
import pt.sali.sali.model.Equipa;
import pt.sali.sali.model.Farmaco;
import pt.sali.sali.model.Freguesia;
import pt.sali.sali.model.Ocorrencia;
import pt.sali.sali.model.Pergunta;
import pt.sali.sali.model.Utente;

public class AppSali extends Application {

    Ocorrencia o;
    Avaliacao ava;
    Atuacao atu;
    Equipa eq;
    ArrayList<Farmaco> arFarmacos;
    ArrayList<Freguesia> arFreguseias;
    ArrayList<Pergunta> arPerguntas;
    Utente u;

    @Override
    public void onCreate() {
        super.onCreate();
        arFarmacos = new ArrayList<>();
        arFreguseias = new ArrayList<>();
        arPerguntas = new ArrayList<>();
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
}
