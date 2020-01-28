package s4.spring.tp1.models;

import java.util.Objects;

public class Element {
    private String nom;

    public int getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(int evaluation) {
        this.evaluation = evaluation;
    }

    private int evaluation;

    public Element(String nom) {
        this.nom=nom;
        this.evaluation=0;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Element element = (Element) obj;
        return Objects.equals(getNom(), element.getNom());
    }

    public void inc() {
        evaluation++;
    }
    public void dec() {
        evaluation--;
    }
}
