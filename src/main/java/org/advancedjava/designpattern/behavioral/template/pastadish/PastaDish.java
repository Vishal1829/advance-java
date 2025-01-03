package org.advancedjava.designpattern.behavioral.template.pastadish;

public abstract class PastaDish {

    protected abstract void addPasta();
    protected abstract void addSauce();
    protected abstract void addProtein();
    protected abstract void addGarnish();

    private void boilWater() {
        System.out.println("Boiling water");
    }

    private void cookPasta() {
        System.out.println("Cooking pasta");
    }

    private void drainAndPlate() {
        System.out.println("Drain the plate and serve the pasta");
    }

    public final void makeRecipe() {
        boilWater();
        addPasta();
        cookPasta();
        drainAndPlate();
        addSauce();
        addProtein();
        addGarnish();
    }
}
