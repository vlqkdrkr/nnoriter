package com.example.noriter;

import android.graphics.drawable.Drawable;

public class pcinfo_item {
    private int pcindex ;
    private String name ;
    private String ad_si ;
    private String ad_rns ;
    private String ad_rn ;
    private String number ;
    private int lo_x;
    private int lo_y;
    private int CPU_B;
    private int CPU_G;
    private String CPU_C;
    private int RAM;
    private String GPU;
    private int charger;
    private int printer;
    private int office;
    private int card;
    private String pc_main;
    private String pc_menu;

    public void setPcindex(int pcindex1) {
        pcindex = pcindex1 ;
    }
    public void setName(String name1) {
        name = name1 ;
    }
    public void setAd_si(String ad_si1) {
        ad_si = ad_si1 ;
    }
    public void setAd_rns(String ad_rns1) { ad_rns = ad_rns1 ; }
    public void setAd_rn(String ad_rn1) {
        ad_rn = ad_rn1 ;
    }
    public void setNumber(String number1) {
        number = number1 ;
    }
    public void setLo_x(int lo_x1) {
        lo_x = lo_x1 ;
    }
    public void setLo_y(int lo_y1) { lo_y = lo_y1 ; }
    public void setCPU_B(int CPU1) { CPU_B = CPU1 ; }
    public void setCPU_G(int CPU1) { CPU_G = CPU1 ; }
    public void setCPU_C(String CPU1) { CPU_C = CPU1 ; }
    public void setRAM(int RAM1) { RAM = RAM1 ; }
    public void setGPU(String GPU1) { GPU = GPU1 ; }
    public void setCharger(int charger1) { charger = charger1 ; }
    public void setPrinter(int printer1) { printer = printer1 ; }
    public void setOffice(int office1) { office = office1 ; }
    public void setCard(int card1) { card = card1 ; }
    public void setPc_main(String pc_main1) { pc_main = pc_main1 ; }
    public void setPc_menu(String pc_menu1) { pc_menu = pc_menu1 ; }

    public int getPcindex() { return pcindex; }
    public String getName() { return name; }
    public String getAd_si() { return ad_si; }
    public String getAd_rns() { return ad_rns; }
    public String getAd_rn() { return ad_rn; }
    public String getNumber() { return number; }
    public int getLo_x() { return lo_x; }
    public int getLo_y() { return lo_y; }
    public int getCPU_B() { return CPU_B; }
    public int getCPU_G() { return CPU_G; }
    public String getCPU_C() { return CPU_C; }
    public int getRAM() { return RAM; }
    public String getGPU() { return GPU; }
    public int isCharger() { return charger; }
    public int isPrinter() { return printer; }
    public int isOffice() { return office; }
    public int isCard() { return card; }
    public String getPc_main() { return pc_main; }
    public String getPc_menu() { return pc_menu; }
}
