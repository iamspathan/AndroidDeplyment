package me.sohailpathan.www.androiddeplyment;

public class StudentClass {
    private  int simg;
    private String sname;
    private long sreg;

    public StudentClass(){
        this(R.drawable.ic_launcher_background, "Your Name", (long) 0);
    }

    public StudentClass(int img, String name, Long reg)
    {
        this.simg=img;
        this.sname=name;
        this.sreg=reg;
    }
    public int getImage()
    {
        return simg;
    }

    public void setImage(int img)
    {
        this.simg = img;
    }

    public long getRegno()
    {
        return sreg;
    }

    public String getName() {
        return sname;
    }

}
