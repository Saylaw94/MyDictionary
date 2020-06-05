package com.example.dictionary;

public class Word {
    private String kr;
    private String en;
    private int audioResourceId;


    public Word(String kr, String en, int audioResourceId) {
        this.kr = kr;
        this.en = en;
        this.audioResourceId = audioResourceId;
    }

    public int getAudioResourceId() {
        return audioResourceId;
    }

    public String getKr() {
        return kr;
    }

    public String getEn() {
        return en;
    }
}