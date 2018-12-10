package pt.sali.sali.util;

public class Webservices {

    public final static String SRVADD = "aws.peepscallmelushi.site";
    public final static String SRVPRT = "505000";
    //public final static String SRVADD = "app.sali.pt";
    //public final static String SRVPRT = "505000";

    //Utilizador
    public final static String LOGIN = "http://"+SRVADD+":"+SRVPRT+"/Utilizador/login";
    public final static String PARTNER = "http://"+SRVADD+":"+SRVPRT+"/Utilizador/listByRole";

    //Farmaco
    public final static String FARMACOS = "http://"+SRVADD+":"+SRVPRT+"/Farmaco/list";

    //Freguesia
    public final static String FREGUESIAS = "http://"+SRVADD+":"+SRVPRT+"/Freguesia/list";

    //Ocorrencias
    public final static String OCORRENCIA = "http://"+SRVADD+":"+SRVPRT+"/Ocorrencia/add";

    //Roles
    public final static String ROLES = "http://"+SRVADD+":"+SRVPRT+"/Role/list";

    //Sitoma
    public final static String SINTOMAS = "http://"+SRVADD+":"+SRVPRT+"/Sintoma/list";

}
