package com.github.alexandervmalysh.lesson_2_3_4.robot;

public class Jaeger {
    private String modelName;
    private String mark;
    private String origin;
    private String operationSystem;
    private String energyCore;
    private float height;
    private float weight;
    private int speed;
    private int strength;
    private int armor;

    public Jaeger() {
    }

    public Jaeger(String modelName, String mark, String origin, String operationSystem, String energyCore,
            float height, float weight, int speed, int strength, int armor) {
        this.modelName = modelName;
        this.mark = mark;
        this.origin = origin;
        this.operationSystem = operationSystem;
        this.energyCore = energyCore;
        this.height = height;
        this.weight = weight;
        this.speed = speed;
        this.strength = strength;
        this.armor = armor;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getOperationSystem() {
        return operationSystem;
    }

    public void setOperationSystem(String operationSystem) {
        this.operationSystem = operationSystem;
    }

    public String getEnergyCore() {
        return energyCore;
    }

    public void setEnergyCore(String energyCore) {
        this.energyCore = energyCore;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    void move() {
        System.out.println(modelName + " выполняет перемещение");
    }

    void scanKaiju() {
        System.out.println(modelName + " выполняет сканирование");
    }
}