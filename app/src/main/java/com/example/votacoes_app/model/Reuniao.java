package com.example.votacoes_app.model;

import java.io.Serializable;
import java.sql.SQLOutput;

public class Reuniao implements Serializable {

    private String id, conselho, data, local, quorum, secretario;
    private String hora = "00:00";
    private String horaFim = "23:59";
    private int status;
    private int limiar = 0;

    public Reuniao() {
    }

    public Reuniao(String conselho, String data, String hora, String local, String quorum, String secretario) {
        this.conselho = conselho;
        this.data = data;
        this.hora = hora;
        this.local = local;
        this.quorum = quorum;
        this.secretario = secretario;
        this.status = 2;
    }

    public int getLimiar(){
        return this.limiar;
    }

    public void setLimiar(int l){
        this.limiar = l;
    }

    public String getConselho() {
        return conselho;
    }

    public void setConselho(String conselho) {
        this.conselho = conselho;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        try{
        this.data = null;
        if (!data.isEmpty()) {
            String[] dataList = data.split("/");
            if (dataList.length == 3 & dataList[0].length() == 2 & dataList[1].length() == 2 & dataList[2].length() == 2){

                    int day = Integer.parseInt(dataList[0]);
                    int month = Integer.parseInt(dataList[1]);
                    int year = Integer.parseInt(dataList[2]);

                    if ((day > 0 & 32 > day) & (month > 0 & 13 > month) & (year > 0 & 100 > year)){
                        this.data = data;
                    }
                }
            }
        }catch (Exception ignore){
        }
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        try{
            this.hora = null;
            if (!hora.isEmpty()) {
                String[] horaList = hora.split(":");
                if (horaList.length == 2 && horaList[0].length() == 2 && horaList[1].length() == 2){
                    int hour;
                    int min;

                        hour = Integer.parseInt(horaList[0]);
                        min = Integer.parseInt(horaList[1]);
                        if ((hour >= 0 && 23 >= hour) && (min >= 0 && 59 >= min)){

                            String horaIni = hora.replace(":", "");
                            int horaIniNum = Integer.parseInt(horaIni);

                            String horaFim = this.getHoraFim().replace(":", "");
                            int horaFimNum = Integer.parseInt(horaFim);

                            if (horaFimNum - this.getLimiar() > horaIniNum){
                                this.hora = hora;
                            }
                        }
                }
            }
        }catch(Exception ignore){
        }
    }

    public void resetHora(){
        this.hora = "00:00";
    }

    public void resetHoraFim(){
        this.horaFim = "23:59";
    }

    public String getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(String hora) {
        try{
            this.horaFim = null;
            if (!hora.isEmpty()) {
                String[] horaList = hora.split(":");
                if (horaList.length == 2 && horaList[0].length() == 2 && horaList[1].length() == 2){
                    int hour;
                    int min;

                    hour = Integer.parseInt(horaList[0]);
                    min = Integer.parseInt(horaList[1]);
                    if ((hour >= 0 && 23 >= hour) && (min >= 0 && 59 >= min)){

                        String horaIni = this.getHora().replace(":", "");
                        int horaIniNum = Integer.parseInt(horaIni);

                        String horaFim = hora.replace(":", "");
                        int horaFimNum = Integer.parseInt(horaFim);

                        if (horaFimNum - this.getLimiar() > horaIniNum){
                            this.horaFim = hora;
                        }
                    }
                }
            }
        }catch(Exception ignore){
        }
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getQuorum() {
        return quorum;
    }

    public void setQuorum(String quorum) {
        this.quorum = quorum;
    }

    public String getSecretario() {
        return secretario;
    }

    public void setSecretario(String secretario) {
        this.secretario = secretario;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
