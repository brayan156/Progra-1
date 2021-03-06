package Listas;

import javafx.scene.layout.AnchorPane;
import sample.Ficha;

public class Matriz {
    public Ficha[][] matriz= new Ficha[15][15];
    public int width=41,height=41;
    double inix= 5-height/2;
    double iniy= 77-width/2;


    public void agregar(Ficha img, Listapares pares, ListaFichas listaFichas){//agrega individualmente cada ficha que se coloque en el area de la matriz
        int contx=0, conty=0;
        double x= inix;
        double y= iniy;
        while (contx<15){
            if (img.getX() >= x && img.getX() <=x+41 ){
                while (conty<15){
                    if(img.getY() >= y && img.getY() <=y+41 && (matriz[conty][contx] ==null || matriz[conty][contx]==img)){
                        matriz[conty][contx] = img;
                        pares.addFirst(new Pares(conty,contx));
                        System.out.println(img.getY());
                        System.out.println(img.getX());
                        System.out.println(matriz[conty][contx].getId()+" guardada en "+conty+","+contx);
                        img.setY(y+img.getFitWidth()/2);
                        img.setX(x+img.getFitHeight()/2);
                        System.out.println(img.getImage().impl_getUrl());
                        System.out.println(img.getLetra());
                        System.out.println(img.getValor());
                        break;
                    }
                    else if(img.getY() >= y && img.getY() <=y+41 && matriz[conty][contx] !=null){
                        img.setY(img.getPosy());
                        img.setX(img.getPosx());
                        listaFichas.addFirst(img);
                        break;
                    }
                    else{
                        conty++;
                        y+=41;

                    }
                }
                break;
            }
            else{
                contx++;
                x+=41;
            }
        }
    }
    public void agregar(String[][] matriz, AnchorPane pane) {//agrega las fichas faltantes a la matriz y ancla las fichas al pane para que no puedan volver a ser movidas
        System.out.println("al menos entre aca");
        int contx = 0, conty = 0;
        while (contx < 15) {
            while (conty < 15) {
                if (matriz[conty][contx]!=null && this.matriz[conty][contx]==null) {
                    this.matriz[conty][contx] = new Ficha((int)inix+41*contx+height/2,(int)iniy+41*conty+width/2,matriz[conty][contx]);
                    this.matriz[conty][contx].setFitHeight(height);
                    this.matriz[conty][contx].setFitWidth(width);
                    this.matriz[conty][contx].crearimagen();
                    System.out.println("estoy pintando");
                    pane.getChildren().add(this.matriz[conty][contx]);
                    conty++;
                }
                else if(matriz[conty][contx]!=null && this.matriz[conty][contx]!=null){
                    pane.getChildren().remove(this.matriz[conty][contx]);
                    this.matriz[conty][contx] = new Ficha((int)inix+41*contx+height/2,(int)iniy+41*conty+width/2,matriz[conty][contx]);
                    this.matriz[conty][contx].setFitHeight(height);
                    this.matriz[conty][contx].setFitWidth(width);
                    this.matriz[conty][contx].crearimagen();
                    System.out.println("estoy pintando y quitando");
                    pane.getChildren().add(this.matriz[conty][contx]);
                    conty++;
                }
                else {
                    conty++;

                }
            }
            contx++;
            conty=0;

        }
    }
    public String[][] convertir() {//convierte la matriz a una matriz de strings para poder ser enviada por json
        String[][] matrizstr = new String[15][15];
        int contx = 0, conty = 0;
        while (contx < 15) {
            while (conty < 15) {
                if (this.matriz[conty][contx] != null) {
                    matrizstr[conty][contx] = this.matriz[conty][contx].getLetra();
                    conty++;
                } else {
                    conty++;
                }
            }
            contx++;
            conty = 0;
        }
        return matrizstr;
    }
    public void reordenar(ListaFichas listaFichas){//quita las fichas que no pertenezcan a la matriz global y las vuelve a colocar en su sitio
        int contx = 0, conty = 0;
        while (contx < 15) {
            while (conty < 15) {
                if (this.matriz[conty][contx]!=null && this.matriz[conty][contx].getPosy() != this.matriz[conty][contx].getY() && this.matriz[conty][contx].getPosx() != this.matriz[conty][contx].getX()) {
                    listaFichas.addLast(this.matriz[conty][contx]);
                    this.matriz[conty][contx].setX(this.matriz[conty][contx].getPosx());
                    this.matriz[conty][contx].setY(this.matriz[conty][contx].getPosy());
                    conty++;
                } else {
                    conty++;
                }
            }
            contx++;
            conty = 0;
        }
    }
    public Boolean verificarsoledad(Listapares pares){//ve si una ficha esta sola
        Boolean sola=false;
        int cont=0;
        while (cont<pares.largo){
            int cond=0;
            int y=pares.buscar(cont).getR();
            int x=pares.buscar(cont).getC();
            if (y==14){cond+=1;}
            else{
                if (matriz[y+1][x]==null){cond+=1;}
            }
            if (y==0){cond+=1;}
            else{
                if (matriz[y-1][x]==null){cond+=1;}
            }
            if (x==14){cond+=1;}
            else{
                if (matriz[y][x+1]==null){cond+=1;}
            }
            if (x==0){cond+=1;}
            else{
                if (matriz[y][x-1]==null){cond+=1;}
            }
            if (cond==4){ sola=true;}
            System.out.println("la suma fue "+cond);
            cont++;
        }
        return sola;
    }

}
