/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifes.lfa.cln.cdp;

import java.util.List;

/**
 *
 * @author Thanner Soares Silva <thannersoares@gmail.com>
 */
public class Gramatica {
    private List<String> s;
    private List<String> v;
    private List<String> t;
    private List<String> p;

    /**
     * @return the s
     */
    public List<String> getS() {
        return s;
    }

    /**
     * @param s the s to set
     */
    public void setS(List<String> s) {
        this.s = s;
    }

    /**
     * @return the v
     */
    public List<String> getV() {
        return v;
    }

    /**
     * @param v the v to set
     */
    public void setV(List<String> v) {
        this.v = v;
    }

    /**
     * @return the t
     */
    public List<String> getT() {
        return t;
    }

    /**
     * @param t the t to set
     */
    public void setT(List<String> t) {
        this.t = t;
    }

    /**
     * @return the p
     */
    public List<String> getP() {
        return p;
    }

    /**
     * @param p the p to set
     */
    public void setP(List<String> p) {
        this.p = p;
    }

    public void getP(List<String> manipulaRegraProducao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
