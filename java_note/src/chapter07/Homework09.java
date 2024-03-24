package chapter07;

public class Homework09 {

    /*
    9.定义Music类，里面有音乐名name、音乐时长times属性，并有播放play功能和返回本身属性信息的功能方法getInfo.
     */

    public static void main(String[] args) {
        Music here = new Music("Here", "06:55");
        here.play();
        System.out.println(here.getInfo());
    }
}

class Music {

    String name;
    String times;

    public Music(String name, String times) {
        this.name = name;
        this.times = times;
    }

    public void play() {
        System.out.println(this.name + " is playing...");
    }

    public String getInfo() {
        return "音乐名：" + this.name + "\n时长：" + this.times;
    }
}
