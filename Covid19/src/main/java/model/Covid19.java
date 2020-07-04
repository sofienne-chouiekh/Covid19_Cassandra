/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author MSellami
 */
public class Covid19 {
    public Date Date;
    public City City;
    public int Infected;
    public int Death;
    public int Covred;
    public int TestCase;
    public boolean Quarantine;

    public Covid19(Date Date, City City, int Infected, int Death, int Covred, int TestCase, boolean Quarantine) {
        this.Date = Date;
        this.City = City;
        this.Infected = Infected;
        this.Death = Death;
        this.Covred = Covred;
        this.TestCase = TestCase;
        this.Quarantine = Quarantine;
    }

    public Date getDate() {
        return Date;
    }

    public void setDate(Date Date) {
        this.Date = Date;
    }

    public City getCity() {
        return City;
    }

    public void setCity(City City) {
        this.City = City;
    }

    public int getInfected() {
        return Infected;
    }

    public void setInfected(int Infected) {
        this.Infected = Infected;
    }

    public int getDeath() {
        return Death;
    }

    public void setDeath(int Death) {
        this.Death = Death;
    }

    public int getCovred() {
        return Covred;
    }

    public void setCovred(int Covred) {
        this.Covred = Covred;
    }

    public int getTestCase() {
        return TestCase;
    }

    public void setTestCase(int TestCase) {
        this.TestCase = TestCase;
    }

    public boolean isQuarantine() {
        return Quarantine;
    }

    public void setQuarantine(boolean Quarantine) {
        this.Quarantine = Quarantine;
    }
    
    
    
    
}
