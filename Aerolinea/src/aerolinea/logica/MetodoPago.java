/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.logica;

/**
 *
 * @author Ian Rodriguez
 */
public class MetodoPago {
    String id,cardNum,vemc,vcc,holder,correoP;

    public MetodoPago(String id, String cardNum, String vemc, String vcc, String holder, String correoP) {
        this.id = id;
        this.cardNum = cardNum;
        this.vemc = vemc;
        this.vcc = vcc;
        this.holder = holder;
        this.correoP = correoP;
    }

    public MetodoPago() {
        this.id = "";
        this.cardNum = "";
        this.vemc = "";
        this.vcc = "";
        this.holder = "";
        this.correoP = "";
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public String getVemc() {
        return vemc;
    }

    public void setVemc(String vemc) {
        this.vemc = vemc;
    }

    public String getVcc() {
        return vcc;
    }

    public void setVcc(String vcc) {
        this.vcc = vcc;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public String getCorreoP() {
        return correoP;
    }

    public void setCorreoP(String correoP) {
        this.correoP = correoP;
    }

    @Override
    public String toString() {
        return "MetodoPago{" + "id=" + id + ", cardNum=" + cardNum + ", vemc=" + vemc + ", vcc=" + vcc + ", holder=" + holder + ", correoP=" + correoP + '}';
    }
    
    
    
}
