
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SimulasiAntrianPasien;

import ExcelInputSimulation.ExcelReader;
import RandomVariate.Exponential;
import RandomVariate.LCGRandom;
import RandomVariate.LCGRandom2;
import RandomVariate.Poisson;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.Random;
/**
 *
 * @author robby
 */
public class Tester {
    public static void main(String[] args){
        Random rng=new Random();
        StatisticsGenerator gen=new StatisticsGenerator();
        LCGRandom2 random2=new LCGRandom2(1);
        Exponential e=new Exponential(0.33,1);
        Poisson p=new Poisson(5,(int)rng.nextInt(9)+1);
        LinkedList list=new LinkedList();
        list.add("x");
        for(int i=0;i<100;i++){
            System.out.print("exponential : "+e.gen());
        }
        System.out.println();
        for(int i=0;i<10;i++){
            System.out.print(0.0+p.gen()+" ");
        }
        System.out.println(rng.nextInt(3));
        System.out.println("TES Create Customer");
        System.out.println(System.currentTimeMillis()%(3600*60));
        double coba= 0.39;
       System.out.println(gen.convertSeconds(coba));
       Random r2=new Random();
       System.out.println(r2.nextInt(2));
       ExcelReader ex=new ExcelReader("demo_read_input.xlsx","Excel");
       ex.createFile();
       ex.readExcel();
       
       String red="00:00:23";
       System.out.println(gen.convertToRealTime(red));
    }
    
    public static double exponential(Random rng, double mean) {
        return -mean * Math.log(rng.nextDouble());
    }  
}
