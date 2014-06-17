package com.company;

public class Planet {

    //Members
    private float radius;
    private float density;
    private float mass;
    private float volume;
    private float force;
    private String name;

    //Constructor
    public Planet(){}

    public Planet(float radius, float density, String name){
        setRadius(radius);
        setDensity(density);
        setVolume(radius);
        setMass(getVolume(), getDensity());
        setName(name);
    }

    //Methods
    private float calcMass(float volume, float density){
        return volume*density;
    }

    private float calcVolume(float radius){
        return (float) ((4/3.0)*(Math.PI)*Math.pow(radius, 3));
    }

    public float calcForce(float mass1, float mass2, float radius){
        final double BIG_G =  6.67e-11;
        return (float) (BIG_G*mass1*mass2/Math.pow(radius,2));
    }

    public float getForce() {
        return force;
    }

    public void setForce(float mass1, float mass2, float radius) {
        this.force = calcForce(mass1, mass2, radius);
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public float getDensity() {
        return density;
    }

    public void setDensity(float density) {
        this.density = density;
    }

    public float getMass() {
        return mass;
    }

    public void setMass(float volume, float density) {
        this.mass = calcMass(volume, density);
    }

    public float getVolume() {
        return volume;
    }

    public void setVolume(float radius) {
        this.volume = calcVolume(radius);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
