package sample;


import Listas.ListaCliente;
import Listas.ListaPalabras;
import Listas.Listapares;

public class Datos {//esta clase es usada como el contenedor de datos para poder comunicarse por json de manera sencilla y que se envie toda la informacion necesaria
    private String accion,client,respueta,jugadores = "";
    private String matriz[][]=new String[15][15];
    private ListaCliente listacliente=new ListaCliente();
    private ListaPalabras listapalabras= new ListaPalabras();
    private ListaPalabras listafichas=new ListaPalabras();
    private Listapares listapares=new Listapares();
    private int codigo=-1;
	private String ip;
	private int id, tel;



    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getRespueta() {
        return respueta;
    }

    public void setRespueta(String respueta) {
        this.respueta = respueta;
    }

    public String[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(String[][] matriz) {
        this.matriz = matriz;
    }

    public ListaCliente getListacliente() {
        return listacliente;
    }

    public void setListacliente(ListaCliente listacliente) {
        this.listacliente = listacliente;
    }

    public ListaPalabras getListapalabras() {
        return listapalabras;
    }

    public void setListapalabras(ListaPalabras listapalabras) {
        this.listapalabras = listapalabras;
    }

    public String getJugadores() {
        return jugadores;
    }

    public void setJugadores(String jugadores) {
        this.jugadores = jugadores;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public ListaPalabras getListafichas() {
        return listafichas;
    }

    public void setListafichas(ListaPalabras listafichas) {
        this.listafichas = listafichas;
    }

    public Listapares getListapares() {
        return listapares;
    }

    public void setListapares(Listapares listapares) {
        this.listapares = listapares;
    }

	public String getIP() {
		return ip;
	}

	public void setIP(String ip) {
		this.ip = ip;
	}

	public int getID() {
		return id;
	}

	public void setID(int id) {
		this.id = id;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

}

