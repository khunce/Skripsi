/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SimulasiAntrianPasien;

/**
 *
 * @author robby
 */
import RandomVariate.Exponential;
import RandomVariate.LCGRandom;
import RandomVariate.Poisson;
import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
public class StatisticsGenerator  {

    private double servicetime;
    private Poisson poisson;
    private Exponential exponential;
    private Exponential exponential2;
    private Random rand;
    private double meanservicetime;
    private double meanarrivaltime;
    private double meanservicetime2;
    private double meanservicetimepoli;
    private Object[][] data;
    BigDecimal bd;
    public StatisticsGenerator(double meanarrivaltime,double meanservicetime,  double meanservicetime2,double meanservicetimepoli){
        double temp=1/meanarrivaltime;
        this.meanarrivaltime=temp;
        bd = new BigDecimal(this.meanarrivaltime); 
        bd = bd.setScale(5,BigDecimal.ROUND_UP);  
        this.meanarrivaltime=bd.doubleValue();
        
        temp=1/meanservicetime;
        this.meanservicetime=temp;
        System.out.println("mean service time 1 : "+this.meanservicetime);
        bd = new BigDecimal(this.meanservicetime); 
        bd = bd.setScale(2,BigDecimal.ROUND_UP);  
        this.meanservicetime=bd.doubleValue();
        System.out.println("mean service time 1-2 : "+this.meanservicetime);
        
        temp=1/meanservicetime2;
        this.meanservicetime2=temp;
        System.out.println("mean service time 2 : "+this.meanservicetime);
        bd = new BigDecimal(this.meanservicetime2);
        bd = bd.setScale(2,BigDecimal.ROUND_UP);  
        this.meanservicetime2=bd.doubleValue();
        System.out.println("mean service time 2-2 : "+this.meanservicetime);
        
        temp=1/meanservicetimepoli;
        this.meanservicetimepoli=temp;
        System.out.println("mean service time poli : "+this.meanservicetimepoli);
        bd = new BigDecimal(this.meanservicetimepoli);
        bd = bd.setScale(2,BigDecimal.ROUND_UP);  
        this.meanservicetimepoli=bd.doubleValue();
        System.out.println("mean service time poli 2 : "+this.meanservicetimepoli);
        
        rand=new Random();
        this.poisson=new Poisson(this.meanarrivaltime,(int)rand.nextDouble());
        this.exponential=new Exponential(this.meanservicetime,1);
        this.exponential2=new Exponential(this.meanservicetime2,1);
    }
    
    public StatisticsGenerator(){
        
    }
    
    public double convertToRealTime(String time){
        String[] split=time.split(":");
        double seconds=(Double.parseDouble(split[2])/60);
        double minutes=Double.parseDouble(split[1]);
        double hour=Double.parseDouble(split[0])*60;
        bd = new BigDecimal(hour+minutes+seconds); 
        bd = bd.setScale(2,BigDecimal.ROUND_UP);
        return bd.doubleValue();
        
    }

     public double generateServiceTimePoli(){
        double servicetime=this.exponential(this.rand,this.meanservicetimepoli);
        bd = new BigDecimal(servicetime); 
        bd = bd.setScale(2,BigDecimal.ROUND_UP);
        return bd.doubleValue();
    }
    
    public  double exponential(Random rng, double mean) {
        return -mean * Math.log(rng.nextDouble());
    } 
    
    
    public double generateArrivalTime(){
        bd = new BigDecimal(this.poisson.gen()); 
        bd = bd.setScale(2,BigDecimal.ROUND_UP);
        return bd.doubleValue();
    }
    
    public double generateServiceTime(){
        //double servicetime=this.exponential(this.rand,this.meanservicetime);
        double servicetime=exponential.gen();
        bd = new BigDecimal(servicetime); 
        bd = bd.setScale(2,BigDecimal.ROUND_UP);
        return bd.doubleValue();
    }
    
    public double generateServiceTime2(){
        //double servicetime=this.exponential(this.rand,this.meanservicetime2);
        double servicetime=this.exponential2.gen();
        bd = new BigDecimal(servicetime); 
        bd = bd.setScale(2,BigDecimal.ROUND_UP);
        return bd.doubleValue();
    }
    
    public Object[][] generateStatisticsReportAwal(Queue<Customer> queuecustomer){
         data=new Object[queuecustomer.size()][9];
         int i=0;
         while(queuecustomer.isEmpty()==false){
             Customer temp=queuecustomer.remove();
             data[i][0]=temp.getNumber();
             data[i][1]=temp.getJenis();
             data[i][2]=this.convertSeconds(temp.getArrivaltime());
              System.out.println("cek generate : "+temp.getNumber()+" "+this.convertSeconds(temp.getArrivaltime())+" "+this.convertSeconds(temp.getServicetime()));
             data[i][3]=this.convertSeconds(temp.getServicetime());
             data[i][4]=this.convertSeconds(temp.getTimeServiceBegin());
             data[i][5]=this.convertSeconds(temp.getDelaytime());
             data[i][6]=this.convertSeconds(temp.getTimeServiceEnd());
             data[i][7]=this.convertSeconds(temp.getWaitingtime());
             data[i][8]=temp.getServerawal();
             i++;
          }
         return data;
    }
    
      public Object[][] generateStatisticsReportAwal2(LinkedList<Customer> queuecustomer){
         data=new Object[queuecustomer.size()][9];
         int i=0;
         while(i<queuecustomer.size()){
             Customer temp=queuecustomer.get(i);
             data[i][0]=temp.getNumber();
             data[i][1]=temp.getJenis();
             data[i][2]=this.convertSeconds(temp.getArrivaltime());
              System.out.println("cek generate : "+temp.getNumber()+" "+this.convertSeconds(temp.getArrivaltime())+" "+this.convertSeconds(temp.getServicetime()));
             data[i][3]=this.convertSeconds(temp.getServicetime());
             data[i][4]=this.convertSeconds(temp.getTimeServiceBegin());
             data[i][5]=this.convertSeconds(temp.getDelaytime());
             data[i][6]=this.convertSeconds(temp.getTimeServiceEnd());
             data[i][7]=this.convertSeconds(temp.getWaitingtime());
             data[i][8]=temp.getServerawal();
             i++;
          }
         return data;
    }
      
       public Object[][] generateStatisticsReportAwal3(Customer[] queuecustomer){
         data=new Object[queuecustomer.length][9];
         int i=0;
         while(i<queuecustomer.length){
             Customer temp=queuecustomer[i];
             data[i][0]=temp.getNumber();
             data[i][1]=temp.getJenis();
             data[i][2]=this.convertSeconds(temp.getArrivaltime());
              System.out.println("cek generate : "+temp.getNumber()+" "+this.convertSeconds(temp.getArrivaltime())+" "+this.convertSeconds(temp.getServicetime()));
             data[i][3]=this.convertSeconds(temp.getServicetime());
             data[i][4]=this.convertSeconds(temp.getTimeServiceBegin());
             data[i][5]=this.convertSeconds(temp.getDelaytime());
             data[i][6]=this.convertSeconds(temp.getTimeServiceEnd());
             data[i][7]=this.convertSeconds(temp.getWaitingtime());
             data[i][8]=temp.getServerawal();
             i++;
          }
         return data;
    }
    
     public Object[][] generateStatisticsReportPoli(Queue<Customer> queuecustomer){
         data=new Object[queuecustomer.size()][8];
         int i=0;
         while(queuecustomer.isEmpty()==false){
             Customer temp=queuecustomer.remove();
             data[i][0]=temp.getNumberinpoli();
             data[i][1]=temp.getJenis();
             data[i][2]=this.convertSeconds(temp.getArrivaltimepoli());
             System.out.println("cek generate 1 :"+" "+this.convertSeconds(temp.getArrivaltimepoli())+" "+this.convertSeconds(temp.getServicetimepoli())+" "+this.convertSeconds(temp.getTimeServiceBegin2())+" "+this.convertSeconds(temp.getDelaytimepoli())+" "+this.convertSeconds(temp.getWaitingtimepoli())+" "+this.convertSeconds(temp.getTimeServiceEnd2()));
              System.out.println("cek generate 2 :"+" "+this.convertSeconds(temp.getArrivaltimepoli2())+" "+this.convertSeconds(temp.getServicetimepoli2())+" "+this.convertSeconds(temp.getTimeServiceBegin3())+" "+this.convertSeconds(temp.getDelaytimepoli2())+" "+this.convertSeconds(temp.getWaitingtimepoli2())+" "+this.convertSeconds(temp.getTimeServiceEnd3()));
              System.out.println("cek generate 3 :"+" "+this.convertSeconds(temp.getArrivaltimepoli3())+" "+this.convertSeconds(temp.getServicetimepoli3())+" "+this.convertSeconds(temp.getTimeServiceBegin4())+" "+this.convertSeconds(temp.getDelaytimepoli3())+" "+this.convertSeconds(temp.getWaitingtimepoli3())+" "+this.convertSeconds(temp.getTimeServiceEnd4()));
             data[i][3]=this.convertSeconds(temp.getServicetimepoli()+temp.getServicetimepoli2()+temp.getServicetimepoli3());
             data[i][4]=this.convertSeconds(temp.getTimeServiceBegin2());
             data[i][5]=this.convertSeconds(temp.getDelaytime()+temp.getDelaytimepoli2()+temp.getDelaytimepoli3());
             data[i][6]=this.convertSeconds(temp.getTimeServiceEnd4());
             data[i][7]=this.convertSeconds(temp.getWaitingtimepoli()+temp.getWaitingtimepoli2()+temp.getWaitingtimepoli3());
             i++;
          }
         return data;
    }
     
     
     public Object[][] generateStatisticsReportPoli2(LinkedList<Customer> queuecustomer){
         data=new Object[queuecustomer.size()][8];
         int i=0;
         while(i<queuecustomer.size()){
             Customer temp=queuecustomer.get(i);
             data[i][0]=temp.getNumberinpoli();
             data[i][1]=temp.getJenis();
             data[i][2]=this.convertSeconds(temp.getArrivaltimepoli());
             System.out.println("cek generate 1 :"+" "+this.convertSeconds(temp.getArrivaltimepoli())+" "+this.convertSeconds(temp.getServicetimepoli())+" "+this.convertSeconds(temp.getTimeServiceBegin2())+" "+this.convertSeconds(temp.getDelaytimepoli())+" "+this.convertSeconds(temp.getWaitingtimepoli())+" "+this.convertSeconds(temp.getTimeServiceEnd2()));
              System.out.println("cek generate 2 :"+" "+this.convertSeconds(temp.getArrivaltimepoli2())+" "+this.convertSeconds(temp.getServicetimepoli2())+" "+this.convertSeconds(temp.getTimeServiceBegin3())+" "+this.convertSeconds(temp.getDelaytimepoli2())+" "+this.convertSeconds(temp.getWaitingtimepoli2())+" "+this.convertSeconds(temp.getTimeServiceEnd3()));
              System.out.println("cek generate 3 :"+" "+this.convertSeconds(temp.getArrivaltimepoli3())+" "+this.convertSeconds(temp.getServicetimepoli3())+" "+this.convertSeconds(temp.getTimeServiceBegin4())+" "+this.convertSeconds(temp.getDelaytimepoli3())+" "+this.convertSeconds(temp.getWaitingtimepoli3())+" "+this.convertSeconds(temp.getTimeServiceEnd4()));
             data[i][3]=this.convertSeconds(temp.getServicetimepoli()+temp.getServicetimepoli2()+temp.getServicetimepoli3());
             data[i][4]=this.convertSeconds(temp.getTimeServiceBegin2());
             data[i][5]=this.convertSeconds(temp.getDelaytime()+temp.getDelaytimepoli2()+temp.getDelaytimepoli3());
             data[i][6]=this.convertSeconds(temp.getTimeServiceEnd4());
             data[i][7]=this.convertSeconds(temp.getWaitingtimepoli()+temp.getWaitingtimepoli2()+temp.getWaitingtimepoli3());
             i++;
          }
         return data;
    }
     
     public Object[][] generateStatisticsReportPoli3(Customer[] queuecustomer){
         data=new Object[queuecustomer.length][8];
         int i=0;
         while(i<queuecustomer.length){
             Customer temp=queuecustomer[i];
             if(temp.getJenis().equals("BPJS Lama")||temp.getJenis().equals("BPJS Baru")){
                data[i][0]=temp.getNumberinpoli();
                data[i][1]=temp.getJenis();
                data[i][2]=this.convertSeconds(temp.getArrivaltimepoli());
                System.out.println("cek generate 1 :"+" "+this.convertSeconds(temp.getArrivaltimepoli())+" "+this.convertSeconds(temp.getServicetimepoli())+" "+this.convertSeconds(temp.getTimeServiceBegin2())+" "+this.convertSeconds(temp.getDelaytimepoli())+" "+this.convertSeconds(temp.getWaitingtimepoli())+" "+this.convertSeconds(temp.getTimeServiceEnd2()));
                 System.out.println("cek generate 2 :"+" "+this.convertSeconds(temp.getArrivaltimepoli2())+" "+this.convertSeconds(temp.getServicetimepoli2())+" "+this.convertSeconds(temp.getTimeServiceBegin3())+" "+this.convertSeconds(temp.getDelaytimepoli2())+" "+this.convertSeconds(temp.getWaitingtimepoli2())+" "+this.convertSeconds(temp.getTimeServiceEnd3()));
                 System.out.println("cek generate 3 :"+" "+this.convertSeconds(temp.getArrivaltimepoli3())+" "+this.convertSeconds(temp.getServicetimepoli3())+" "+this.convertSeconds(temp.getTimeServiceBegin4())+" "+this.convertSeconds(temp.getDelaytimepoli3())+" "+this.convertSeconds(temp.getWaitingtimepoli3())+" "+this.convertSeconds(temp.getTimeServiceEnd4()));
                data[i][3]=this.convertSeconds(temp.getServicetimepoli()+temp.getServicetimepoli2()+temp.getServicetimepoli3());
                data[i][4]=this.convertSeconds(temp.getTimeServiceBegin2());
                data[i][5]=this.convertSeconds(temp.getDelaytime()+temp.getDelaytimepoli2()+temp.getDelaytimepoli3());
                data[i][6]=this.convertSeconds(temp.getTimeServiceEnd4());
                data[i][7]=this.convertSeconds(temp.getWaitingtimepoli()+temp.getWaitingtimepoli2()+temp.getWaitingtimepoli3());
                i++;
             }
             else{
                System.out.println("kasus emergency :"+temp.getArrivaltime());
                data[i][0]=temp.getNumberinpoli();
                data[i][1]=temp.getJenis();
                data[i][2]=this.convertSeconds(temp.getArrivaltimepoli3());
                System.out.println("cek generate 1 :"+" "+this.convertSeconds(temp.getArrivaltimepoli())+" "+this.convertSeconds(temp.getServicetimepoli())+" "+this.convertSeconds(temp.getTimeServiceBegin2())+" "+this.convertSeconds(temp.getDelaytimepoli())+" "+this.convertSeconds(temp.getWaitingtimepoli())+" "+this.convertSeconds(temp.getTimeServiceEnd2()));
                System.out.println("cek generate 2 :"+" "+this.convertSeconds(temp.getArrivaltimepoli2())+" "+this.convertSeconds(temp.getServicetimepoli2())+" "+this.convertSeconds(temp.getTimeServiceBegin3())+" "+this.convertSeconds(temp.getDelaytimepoli2())+" "+this.convertSeconds(temp.getWaitingtimepoli2())+" "+this.convertSeconds(temp.getTimeServiceEnd3()));
                System.out.println("cek generate 3 :"+" "+this.convertSeconds(temp.getArrivaltimepoli3())+" "+this.convertSeconds(temp.getServicetimepoli3())+" "+this.convertSeconds(temp.getTimeServiceBegin4())+" "+this.convertSeconds(temp.getDelaytimepoli3())+" "+this.convertSeconds(temp.getWaitingtimepoli3())+" "+this.convertSeconds(temp.getTimeServiceEnd4()));
                data[i][3]=this.convertSeconds(temp.getServicetimepoli()+temp.getServicetimepoli2()+temp.getServicetimepoli3());
                data[i][4]=this.convertSeconds(temp.getTimeServiceBegin2());
                data[i][5]=this.convertSeconds(temp.getDelaytime()+temp.getDelaytimepoli2()+temp.getDelaytimepoli3());
                data[i][6]=this.convertSeconds(temp.getTimeServiceEnd4());
                data[i][7]=this.convertSeconds(temp.getWaitingtimepoli()+temp.getWaitingtimepoli2()+temp.getWaitingtimepoli3());
                i++;
             }
          }
         return data;
    }
     
     public double generateSummaryArrivalTime(Customer[] queuecustomer){
          if(queuecustomer.length>0){
            double sumArrivalTime=queuecustomer[queuecustomer.length-1].getArrivaltime()/2.0;
            bd = new BigDecimal(((double)queuecustomer.length*1.0)/sumArrivalTime*1.0); 
            bd = bd.setScale(2,BigDecimal.ROUND_UP);
            return bd.doubleValue();
          }
          else {
              return 0;
          }
      }
     
     public double generateSummaryArrivalTime2(Customer[] queuecustomer){
         if(queuecustomer.length>0){
            double sumArrivalTime=queuecustomer[queuecustomer.length-1].getArrivaltimepoli()/2.0;
            bd = new BigDecimal(((double)queuecustomer.length*1.0)/sumArrivalTime*1.0); 
            bd = bd.setScale(2,BigDecimal.ROUND_UP);
            return bd.doubleValue();
         }
         else {
             return 0;
         }
      }
     
     public double generateSummaryArrivalTime3(Customer[] queuecustomer){
         if(queuecustomer.length>0){
            double sumArrivalTime=queuecustomer[queuecustomer.length-1].getArrivaltimepoli2()/2.0;
            bd = new BigDecimal(((double)queuecustomer.length*1.0)/sumArrivalTime*1.0); 
            bd = bd.setScale(2,BigDecimal.ROUND_UP);
            return bd.doubleValue();
         }
         else {
             return 0;
         }
      }
     
     public double generateSummaryArrivalTime4(Customer[] queuecustomer){
         if(queuecustomer.length>0){
            double sumArrivalTime=queuecustomer[queuecustomer.length-1].getArrivaltimepoli3()/2.0;
            bd = new BigDecimal(((double)queuecustomer.length*1.0)/sumArrivalTime*1.0); 
            bd = bd.setScale(2,BigDecimal.ROUND_UP);
            return bd.doubleValue();
         }
         else {
             return 0;
         }
      }
     
      public double generateArrivalTimeBPJSLama(Customer[] queuecustomer){
         if(queuecustomer.length>0){
            int cari=0;
            for(int i=0;i<queuecustomer.length;i++){
                if(queuecustomer[i].getJenis().equals("BPJS Lama")){
                    cari=i;
                }
            }
            int total=0;
            for(int i=0;i<queuecustomer.length;i++){
                if(queuecustomer[i].getJenis().equals("BPJS Lama")){
                    total++;
                }
            }
            double sumArrivalTime=queuecustomer[cari].getArrivaltime()/2.0;
            bd = new BigDecimal(((double)total*1.0)/sumArrivalTime*1.0); 
            bd = bd.setScale(2,BigDecimal.ROUND_UP);
            return bd.doubleValue();
         }
         else{
             return 0;
         }
     }
      
      public double generateArrivalTimeBPJSLama2(Customer[] queuecustomer){
         int cari=0;
         if(queuecustomer.length>0){
            for(int i=0;i<queuecustomer.length;i++){
                if(queuecustomer[i].getJenis().equals("BPJS Lama")){
                    cari=i;
                }
            }
            int total=0;
            for(int i=0;i<queuecustomer.length;i++){
                if(queuecustomer[i].getJenis().equals("BPJS Lama")){
                    total++;
                }
            }
            double sumArrivalTime=queuecustomer[cari].getArrivaltimepoli()/2.0;
            bd = new BigDecimal(((double)total*1.0)/sumArrivalTime*1.0); 
            bd = bd.setScale(2,BigDecimal.ROUND_UP);
            return bd.doubleValue();
         }
         else {
             return 0;
         }
     }
      
      public double generateArrivalTimeBPJSLama3(Customer[] queuecustomer){
         int cari=0;
         if(queuecustomer.length>0){
            for(int i=0;i<queuecustomer.length;i++){
                if(queuecustomer[i].getJenis().equals("BPJS Lama")){
                    cari=i;
                }
            }
            int total=0;
            for(int i=0;i<queuecustomer.length;i++){
                if(queuecustomer[i].getJenis().equals("BPJS Lama")){
                    total++;
                }
            }
            double sumArrivalTime=queuecustomer[cari].getArrivaltimepoli2()/2.0;
            bd = new BigDecimal(((double)total*1.0)/sumArrivalTime*1.0); 
            bd = bd.setScale(2,BigDecimal.ROUND_UP);
            return bd.doubleValue();
         }
         else {
             return 0;
         }
     }
      
      public double generateArrivalTimeBPJSLama4(Customer[] queuecustomer){
         int cari=0;
         if(queuecustomer.length>0){
            for(int i=0;i<queuecustomer.length;i++){
                if(queuecustomer[i].getJenis().equals("BPJS Lama")){
                    cari=i;
                }
            }
            int total=0;
            for(int i=0;i<queuecustomer.length;i++){
                if(queuecustomer[i].getJenis().equals("BPJS Lama")){
                    total++;
                }
            }
            double sumArrivalTime=queuecustomer[cari].getArrivaltimepoli3()/2.0;
            bd = new BigDecimal(((double)total*1.0)/sumArrivalTime*1.0); 
            bd = bd.setScale(2,BigDecimal.ROUND_UP);
            return bd.doubleValue();
         }
         else {
             return 0;
         }
     }
      
      public double generateArrivalTimeBPJSBaru(Customer[] queuecustomer){
         if(queuecustomer.length>0){
            int cari=0;
            for(int i=0;i<queuecustomer.length;i++){
                if(queuecustomer[i].getJenis().equals("BPJS Baru")){
                    cari=i;
                }
            }
            int total=0;
            for(int i=0;i<queuecustomer.length;i++){
                if(queuecustomer[i].getJenis().equals("BPJS Baru")){
                    total++;
                }
            }
            double sumArrivalTime=queuecustomer[cari].getArrivaltime()/2.0;
            bd = new BigDecimal(((double)total*1.0)/sumArrivalTime*1.0); 
            bd = bd.setScale(2,BigDecimal.ROUND_UP);
            return bd.doubleValue();
         }
         else{
             return 0;
         }
      }
      
      public double generateArrivalTimeBPJSBaru2(Customer[] queuecustomer){
         int cari=0;
         if(queuecustomer.length>0){
                for(int i=0;i<queuecustomer.length;i++){
                    if(queuecustomer[i].getJenis().equals("BPJS Baru")){
                        cari=i;
                    }
                }
                int total=0;
                for(int i=0;i<queuecustomer.length;i++){
                    if(queuecustomer[i].getJenis().equals("BPJS Baru")){
                        total++;
                    }
                }
                double sumArrivalTime=queuecustomer[cari].getArrivaltimepoli()/2.0;
                bd = new BigDecimal(((double)total*1.0)/sumArrivalTime*1.0); 
                bd = bd.setScale(2,BigDecimal.ROUND_UP);
                return bd.doubleValue();
         }
         else{
             return 0;
         }
        
      }
      
      public double generateArrivalTimeBPJSBaru3(Customer[] queuecustomer){
         int cari=0;
         if(queuecustomer.length>0){
                for(int i=0;i<queuecustomer.length;i++){
                    if(queuecustomer[i].getJenis().equals("BPJS Baru")){
                        cari=i;
                    }
                }
                int total=0;
                for(int i=0;i<queuecustomer.length;i++){
                    if(queuecustomer[i].getJenis().equals("BPJS Baru")){
                        total++;
                    }
                }
                double sumArrivalTime=queuecustomer[cari].getArrivaltimepoli2()/2.0;
                bd = new BigDecimal(((double)total*1.0)/sumArrivalTime*1.0); 
                bd = bd.setScale(2,BigDecimal.ROUND_UP);
                return bd.doubleValue();
         }
         else{
             return 0;
         }
        
      }
      
      public double generateArrivalTimeBPJSBaru4(Customer[] queuecustomer){
         int cari=0;
         if(queuecustomer.length>0){
                for(int i=0;i<queuecustomer.length;i++){
                    if(queuecustomer[i].getJenis().equals("BPJS Baru")){
                        cari=i;
                    }
                }
                int total=0;
                for(int i=0;i<queuecustomer.length;i++){
                    if(queuecustomer[i].getJenis().equals("BPJS Baru")){
                        total++;
                    }
                }
                double sumArrivalTime=queuecustomer[cari].getArrivaltimepoli3()/2.0;
                bd = new BigDecimal(((double)total*1.0)/sumArrivalTime*1.0); 
                bd = bd.setScale(2,BigDecimal.ROUND_UP);
                return bd.doubleValue();
         }
         else{
             return 0;
         }
        
      }
      
      public double generateArrivalTimeEmergency(Customer[] queuecustomer){
         int cari=0;
         if(queuecustomer.length>0){
                for(int i=0;i<queuecustomer.length;i++){
                    if(queuecustomer[i].getJenis().equals("Emergency")){
                        cari=i;
                    }
                }
                int total=0;
                for(int i=0;i<queuecustomer.length;i++){
                    if(queuecustomer[i].getJenis().equals("Emergency")){
                        total++;
                    }
                }
                double sumArrivalTime=queuecustomer[cari].getArrivaltimepoli()/2.0;
                bd = new BigDecimal(((double)total*1.0)/sumArrivalTime*1.0); 
                bd = bd.setScale(2,BigDecimal.ROUND_UP);
                return bd.doubleValue();
         }
         else{
             return 0;
         }
        
      }
      
      public double generateAverageInterArrivalTime(Customer[] queuecustomer){
          double arrivaltime=this.generateSummaryArrivalTime(queuecustomer);
          if(arrivaltime>0){
                bd = new BigDecimal(((double)1.0)/arrivaltime*1.0); 
                bd = bd.setScale(2,BigDecimal.ROUND_UP);
                return bd.doubleValue();
          }
          else{
              return 0;
          }
      }
      
      public double generateAverageInterArrivalTime2(Customer[] queuecustomer){
          double arrivaltime=this.generateSummaryArrivalTime2(queuecustomer);
          if(arrivaltime>0){
                bd = new BigDecimal(((double)1.0)/arrivaltime*1.0); 
                bd = bd.setScale(2,BigDecimal.ROUND_UP);
                return bd.doubleValue();
          }
          else{
              return 0;
          }
      }
      
      public double generateAverageInterArrivalTime3(Customer[] queuecustomer){
          double arrivaltime=this.generateSummaryArrivalTime3(queuecustomer);
          if(arrivaltime>0){
                bd = new BigDecimal(((double)1.0)/arrivaltime*1.0); 
                bd = bd.setScale(2,BigDecimal.ROUND_UP);
                return bd.doubleValue();
          }
          else{
              return 0;
          }
      }
      
      public double generateAverageInterArrivalTime4(Customer[] queuecustomer){
          double arrivaltime=this.generateSummaryArrivalTime4(queuecustomer);
          if(arrivaltime>0){
                bd = new BigDecimal(((double)1.0)/arrivaltime*1.0); 
                bd = bd.setScale(2,BigDecimal.ROUND_UP);
                return bd.doubleValue();
          }
          else{
              return 0;
          }
      }
      
      public double generateAverageInterArrivalTimeBPJSLama(Customer[] queuecustomer){
          double arrivaltime=this.generateArrivalTimeBPJSLama(queuecustomer);
          if(arrivaltime>0){
            bd = new BigDecimal(((double)1.0)/arrivaltime*1.0); 
            bd = bd.setScale(2,BigDecimal.ROUND_UP);
            return bd.doubleValue();
          }
          else{
              return 0;
          }
      }
      
      public double generateAverageInterArrivalTimeBPJSLama2(Customer[] queuecustomer){
          double arrivaltime=this.generateArrivalTimeBPJSLama2(queuecustomer);
          if(arrivaltime>0){
            bd = new BigDecimal(((double)1.0)/arrivaltime*1.0); 
            bd = bd.setScale(2,BigDecimal.ROUND_UP);
            return bd.doubleValue();
          }
          else{
              return 0;
          }
      }
      
      public double generateAverageInterArrivalTimeBPJSLama3(Customer[] queuecustomer){
          double arrivaltime=this.generateArrivalTimeBPJSLama3(queuecustomer);
          if(arrivaltime>0){
            bd = new BigDecimal(((double)1.0)/arrivaltime*1.0); 
            bd = bd.setScale(2,BigDecimal.ROUND_UP);
            return bd.doubleValue();
          }
          else{
              return 0;
          }
      }
      
      public double generateAverageInterArrivalTimeBPJSLama4(Customer[] queuecustomer){
          double arrivaltime=this.generateArrivalTimeBPJSLama4(queuecustomer);
          if(arrivaltime>0){
            bd = new BigDecimal(((double)1.0)/arrivaltime*1.0); 
            bd = bd.setScale(2,BigDecimal.ROUND_UP);
            return bd.doubleValue();
          }
          else{
              return 0;
          }
      }
      
       public double generateAverageInterArrivalTimeBPJSBaru(Customer[] queuecustomer){
          double arrivaltime=this.generateArrivalTimeBPJSBaru(queuecustomer);
          if(arrivaltime>0){
            bd = new BigDecimal(((double)1.0)/arrivaltime*1.0); 
            bd = bd.setScale(2,BigDecimal.ROUND_UP);
            return bd.doubleValue();
          }
          else{
              return 0;
          }
      }
       
        public double generateAverageInterArrivalTimeBPJSBaru2(Customer[] queuecustomer){
          double arrivaltime=this.generateArrivalTimeBPJSBaru2(queuecustomer);
          if(arrivaltime>0){
            bd = new BigDecimal(((double)1.0)/arrivaltime*1.0); 
            bd = bd.setScale(2,BigDecimal.ROUND_UP);
            return bd.doubleValue();
          }
          else{
              return 0;
          }
      }
        
        public double generateAverageInterArrivalTimeBPJSBaru3(Customer[] queuecustomer){
          double arrivaltime=this.generateArrivalTimeBPJSBaru3(queuecustomer);
          if(arrivaltime>0){
            bd = new BigDecimal(((double)1.0)/arrivaltime*1.0); 
            bd = bd.setScale(2,BigDecimal.ROUND_UP);
            return bd.doubleValue();
          }
          else{
              return 0;
          }
      }
        
     public double generateAverageInterArrivalTimeBPJSBaru4(Customer[] queuecustomer){
          double arrivaltime=this.generateArrivalTimeBPJSBaru4(queuecustomer);
          if(arrivaltime>0){
            bd = new BigDecimal(((double)1.0)/arrivaltime*1.0); 
            bd = bd.setScale(2,BigDecimal.ROUND_UP);
            return bd.doubleValue();
          }
          else{
              return 0;
          }
      }
        
        
       public double generateAverageInterArrivalTimeEmergency(Customer[] queuecustomer){
          double arrivaltime=this.generateArrivalTimeEmergency(queuecustomer);
          if(arrivaltime>0){
            bd = new BigDecimal(((double)1.0)/arrivaltime*1.0); 
            bd = bd.setScale(2,BigDecimal.ROUND_UP);
            return bd.doubleValue();
          }
          else{
              return 0;
          }
      }

   
    
    public String convertSeconds(double value){
        String ret="";
        if(value<1){
            double seconds=value*60;
            if(seconds<10){
                 ret="00:00:0"+(int)seconds;
            }
            else{
                ret="00:00:"+(int)seconds;
            }
        }
        else if(value>=1&&value<60){
            int up=(int)value;
            double kurang=value-up;
            bd = new BigDecimal(kurang); 
            bd = bd.setScale(2,BigDecimal.ROUND_UP);
            kurang=bd.doubleValue();
            double seconds=kurang*60;
            if(up<10&&seconds<10){
                ret="00:0"+up+":0"+(int)seconds;
            }
            else if(up>=10&&seconds<10){
                ret="00:"+up+":0"+(int)seconds;
            }
            else if(up<10&&seconds>=10){
                ret="00:0"+up+":"+(int)seconds;
            }
            else{
                ret="00:"+up+":"+(int)seconds;
            }
        }
        else if(value>=60){
            int up=(int)value;
            double kurang=value-up;
            bd = new BigDecimal(kurang); 
            bd = bd.setScale(2,BigDecimal.ROUND_UP);
            kurang=bd.doubleValue();
            double seconds=kurang*60;
            int hours=up/60;
            int minutes=up%60;
            String hours2="";
            String minutes2="";
            String seconds2="";
            if(hours<10){
                hours2="0"+hours;
            }
            else{
                hours2=hours+"";
            }
            if(minutes<10){
                minutes2="0"+minutes;
            }
            else{
                 minutes2=minutes+"";
            }
            if(seconds<10){
                seconds2="0"+(int)seconds;
            }
            else{
                 seconds2=""+(int)seconds;
            }
            ret=hours2+":"+minutes2+":"+seconds2;
            
        }
        return ret;
    }
    
    public Object[][] generateUtilityServer(ServerAwal[] arrayServer){
        Object[][] utility=new Object[1][arrayServer.length];
        for(int i=0;i<arrayServer.length;i++){
           System.out.println("Service time : "+arrayServer[i].getTotalservicetime()+" Countercustomer :"+arrayServer[i].getCounter());
           if(arrayServer[i].getTotalservicetime()>0&&arrayServer[i].getCounter()>0){
                double temp=(1/(arrayServer[i].getTotalservicetime()/arrayServer[i].getCounter()))*100;
                bd = new BigDecimal(temp); 
                bd = bd.setScale(2,BigDecimal.ROUND_UP);
                temp=bd.doubleValue();
                System.out.println("temp : "+temp);
                if(temp>100){
                    temp=100;
                }
                utility[0][i]=temp+" %";
             }
           else{
               utility[0][i]="0 %";
           }
        }
        return utility;
        
    }
    
    public Object[][] generateUtilityServer2(ServerPetugas[] arrayServer){
        Object[][] utility=new Object[1][arrayServer.length];
        for(int i=0;i<arrayServer.length;i++){
            System.out.println("Service time : "+arrayServer[i].getTotalservicetime()+" Countercustomer :"+arrayServer[i].getCounter());
            if(arrayServer[i].getTotalservicetime()==0||arrayServer[i].getCounter()==0){
                utility[0][i]="0 %";
            }
            else{
                double temp=(1/(arrayServer[i].getTotalservicetime()/arrayServer[i].getCounter()))*100;
                System.out.println("temp ? :"+temp);
                bd = new BigDecimal(temp); 
                bd = bd.setScale(2,BigDecimal.ROUND_UP);
                temp=bd.doubleValue();
                System.out.println("temp : "+temp);
                if(temp>100){
                        temp=100;
                }
                utility[0][i]=temp+" %";
            }
            
        }
        return utility;
        
    }
    
     public Object[][] generateUtilityServer3(ServerPerawat[] arrayServer){
        Object[][] utility=new Object[1][arrayServer.length];
        for(int i=0;i<arrayServer.length;i++){
            System.out.println("Service time : "+arrayServer[i].getTotalservicetime()+" Countercustomer :"+arrayServer[i].getCounter());
            if(arrayServer[i].getTotalservicetime()==0||arrayServer[i].getCounter()==0){
                utility[0][i]="0 %";
            }
            else{
                double temp=(1/(arrayServer[i].getTotalservicetime()/arrayServer[i].getCounter()))*100;
                System.out.println("temp ? :"+temp);
                bd = new BigDecimal(temp); 
                bd = bd.setScale(2,BigDecimal.ROUND_UP);
                temp=bd.doubleValue();
                System.out.println("temp : "+temp);
                if(temp>100){
                        temp=100;
                }
                utility[0][i]=temp+" %";
            }
            
        }
        return utility;
        
    }
     
     
      public Object[][] generateUtilityServer4(ServerDokter[] arrayServer){
        Object[][] utility=new Object[1][arrayServer.length];
        for(int i=0;i<arrayServer.length;i++){
            System.out.println("Service time : "+arrayServer[i].getTotalservicetime()+" Countercustomer :"+arrayServer[i].getCounter());
            if(arrayServer[i].getTotalservicetime()==0||arrayServer[i].getCounter()==0){
                utility[0][i]="0 %";
            }
            else{
                double temp=(1/(arrayServer[i].getTotalservicetime()/arrayServer[i].getCounter()))*100;
                System.out.println("temp ? :"+temp);
                bd = new BigDecimal(temp); 
                bd = bd.setScale(2,BigDecimal.ROUND_UP);
                temp=bd.doubleValue();
                System.out.println("temp : "+temp);
                if(temp>100){
                        temp=100;
                }
                utility[0][i]=temp+" %";
            }
            
        }
        return utility;
        
    }
    
    public Object[][] generateAverageServiceTime(ServerAwal[] arrayServer){
        Object[][] res=new Object[1][arrayServer.length];
        for(int i=0;i<arrayServer.length;i++){
            if(arrayServer[i].getTotalservicetime()>0&&arrayServer[i].getCounter()>0){
                double temp=arrayServer[i].getTotalservicetime()*1.0/((double)arrayServer[i].getCounter()*1.0);
                bd = new BigDecimal(temp); 
                bd = bd.setScale(2,BigDecimal.ROUND_UP);
                res[0][i]=this.convertSeconds(bd.doubleValue());
            }
            else{
                res[0][i]="00:00:00";
            }
        }
        return res;
    }
    
    public Object[][] generateAverageServiceTime2(ServerPetugas[] arrayPetugas){
        Object[][] res=new Object[1][arrayPetugas.length];
        for(int i=0;i<arrayPetugas.length;i++){
            System.out.println("total service time : "+arrayPetugas[i].getTotalservicetime()+" Counter : "+arrayPetugas[i].getCounter());
            if(arrayPetugas[i].getTotalservicetime()>0&&arrayPetugas[i].getCounter()>0){
                double temp=arrayPetugas[i].getTotalservicetime()*1.0/((double)arrayPetugas[i].getCounter()*1.0);
                bd = new BigDecimal(temp); 
                bd = bd.setScale(2,BigDecimal.ROUND_UP);
                res[0][i]=this.convertSeconds(bd.doubleValue());
            }
            else{
                res[0][i]="00:00:00";
            }
        }
        return res;
    }
    
    public Object[][] generateAverageServiceTime3(ServerPerawat[] arrayPetugas){
        Object[][] res=new Object[1][arrayPetugas.length];
        for(int i=0;i<arrayPetugas.length;i++){
            System.out.println("total service time : "+arrayPetugas[i].getTotalservicetime()+" Counter : "+arrayPetugas[i].getCounter());
            if(arrayPetugas[i].getTotalservicetime()>0&&arrayPetugas[i].getCounter()>0){
                double temp=arrayPetugas[i].getTotalservicetime()*1.0/((double)arrayPetugas[i].getCounter()*1.0);
                bd = new BigDecimal(temp); 
                bd = bd.setScale(2,BigDecimal.ROUND_UP);
                res[0][i]=this.convertSeconds(bd.doubleValue());
            }
            else{
                res[0][i]="00:00:00";
            }
        }
        return res;
    }
    
    
    public Object[][] generateAverageServiceTime4(ServerDokter[] arrayPetugas){
        Object[][] res=new Object[1][arrayPetugas.length];
        for(int i=0;i<arrayPetugas.length;i++){
            System.out.println("total service time : "+arrayPetugas[i].getTotalservicetime()+" Counter : "+arrayPetugas[i].getCounter());
            if(arrayPetugas[i].getTotalservicetime()>0&&arrayPetugas[i].getCounter()>0){
                double temp=arrayPetugas[i].getTotalservicetime()*1.0/((double)arrayPetugas[i].getCounter()*1.0);
                bd = new BigDecimal(temp); 
                bd = bd.setScale(2,BigDecimal.ROUND_UP);
                res[0][i]=this.convertSeconds(bd.doubleValue());
            }
            else{
                res[0][i]="00:00:00";
            }
        }
        return res;
    }
    
     public Object[][] generateAverageWaitingTime(ServerAwal[] arrayServer){
        Object[][] res=new Object[1][arrayServer.length];
        for(int i=0;i<arrayServer.length;i++){
            if(arrayServer[i].getTotalWaitingTime()>0&&arrayServer[i].getCounter()>0){
                double temp=arrayServer[i].getTotalWaitingTime()*1.0/((double)arrayServer[i].getCounter()*1.0);
                bd = new BigDecimal(temp); 
                bd = bd.setScale(2,BigDecimal.ROUND_UP);
                res[0][i]=this.convertSeconds(bd.doubleValue());
            }
            else{
                res[0][i]="00:00:00";
            }
        }
        return res;
    }
     
     public Object[][] generateAverageWaitingTime2(ServerPetugas[] arrayPetugas){
        Object[][] res=new Object[1][arrayPetugas.length];
        for(int i=0;i<arrayPetugas.length;i++){
            System.out.println("waiting time : petugas "+arrayPetugas[i].getTotalWaitingTime()+" counter : "+arrayPetugas[i].getCounter());
            if(arrayPetugas[i].getTotalWaitingTime()>0&&arrayPetugas[i].getCounter()>0){
                System.out.println("waiting time : petugas "+arrayPetugas[i].getTotalWaitingTime()+" counter : "+arrayPetugas[i].getCounter());
                double temp=arrayPetugas[i].getTotalWaitingTime()*1.0/((double)arrayPetugas[i].getCounter()*1.0);
                System.out.println("temp petugas waiting time :"+temp);
                bd = new BigDecimal(temp); 
                bd = bd.setScale(2,BigDecimal.ROUND_UP);
                res[0][i]=this.convertSeconds(bd.doubleValue());
            }
            else{
                res[0][i]="00:00:00";
            }
        }
        return res;
    }
     
     public Object[][] generateAverageWaitingTime3(ServerPerawat[] arrayPetugas){
        Object[][] res=new Object[1][arrayPetugas.length];
        for(int i=0;i<arrayPetugas.length;i++){
            System.out.println("waiting time : petugas "+arrayPetugas[i].getTotalWaitingTime()+" counter : "+arrayPetugas[i].getCounter());
            if(arrayPetugas[i].getTotalWaitingTime()>0&&arrayPetugas[i].getCounter()>0){
                System.out.println("waiting time : petugas "+arrayPetugas[i].getTotalWaitingTime()+" counter : "+arrayPetugas[i].getCounter());
                double temp=arrayPetugas[i].getTotalWaitingTime()*1.0/((double)arrayPetugas[i].getCounter()*1.0);
                System.out.println("temp petugas waiting time :"+temp);
                bd = new BigDecimal(temp); 
                bd = bd.setScale(2,BigDecimal.ROUND_UP);
                res[0][i]=this.convertSeconds(bd.doubleValue());
            }
            else{
                res[0][i]="00:00:00";
            }
        }
        return res;
    }
     
     public Object[][] generateAverageWaitingTime4(ServerDokter[] arrayPetugas){
        Object[][] res=new Object[1][arrayPetugas.length];
        for(int i=0;i<arrayPetugas.length;i++){
            System.out.println("waiting time : petugas "+arrayPetugas[i].getTotalWaitingTime()+" counter : "+arrayPetugas[i].getCounter());
            if(arrayPetugas[i].getTotalWaitingTime()>0&&arrayPetugas[i].getCounter()>0){
                System.out.println("waiting time : petugas "+arrayPetugas[i].getTotalWaitingTime()+" counter : "+arrayPetugas[i].getCounter());
                double temp=arrayPetugas[i].getTotalWaitingTime()*1.0/((double)arrayPetugas[i].getCounter()*1.0);
                System.out.println("temp petugas waiting time :"+temp);
                bd = new BigDecimal(temp); 
                bd = bd.setScale(2,BigDecimal.ROUND_UP);
                res[0][i]=this.convertSeconds(bd.doubleValue());
            }
            else{
                res[0][i]="00:00:00";
            }
        }
        return res;
    }
     
     
     public Object[][] generateAverageDelayTime(ServerAwal[] arrayServer){
        Object[][] res=new Object[1][arrayServer.length];
        for(int i=0;i<arrayServer.length;i++){
            if(arrayServer[i].getTotalDelayTime()>0&&arrayServer[i].getCounter()>0){
                double temp=arrayServer[i].getTotalDelayTime()*1.0/((double)arrayServer[i].getCounter()*1.0);
                bd = new BigDecimal(temp); 
                bd = bd.setScale(2,BigDecimal.ROUND_UP);
                res[0][i]=this.convertSeconds(bd.doubleValue());
            }
            else{
                res[0][i]="00:00:00";
            }
        }
        return res;
    }
     
    public Object[][] generateAverageDelayTime2(ServerPetugas[] arrayServer){
        Object[][] res=new Object[1][arrayServer.length];
        for(int i=0;i<arrayServer.length;i++){
            System.out.println("delay time : petugas "+arrayServer[i].getTotalDelayTime()+" counter : "+arrayServer[i].getCounter());
            if(arrayServer[i].getTotalDelayTime()>0&&arrayServer[i].getCounter()>0){
                System.out.println("delay time : petugas "+arrayServer[i].getTotalDelayTime()+" counter : "+arrayServer[i].getCounter());
                double temp=arrayServer[i].getTotalDelayTime()*1.0/((double)arrayServer[i].getCounter()*1.0);
                System.out.println("temp petugas delay time :"+temp);
                bd = new BigDecimal(temp); 
                bd = bd.setScale(2,BigDecimal.ROUND_UP);
                res[0][i]=this.convertSeconds(bd.doubleValue());
            }
            else{
                res[0][i]="00:00:00";
            }
        }
        return res;
    }
    
     public Object[][] generateAverageDelayTime3(ServerPerawat[] arrayServer){
        Object[][] res=new Object[1][arrayServer.length];
        for(int i=0;i<arrayServer.length;i++){
            System.out.println("delay time : petugas "+arrayServer[i].getTotalDelayTime()+" counter : "+arrayServer[i].getCounter());
            if(arrayServer[i].getTotalDelayTime()>0&&arrayServer[i].getCounter()>0){
                System.out.println("delay time : petugas "+arrayServer[i].getTotalDelayTime()+" counter : "+arrayServer[i].getCounter());
                double temp=arrayServer[i].getTotalDelayTime()*1.0/((double)arrayServer[i].getCounter()*1.0);
                System.out.println("temp petugas delay time :"+temp);
                bd = new BigDecimal(temp); 
                bd = bd.setScale(2,BigDecimal.ROUND_UP);
                res[0][i]=this.convertSeconds(bd.doubleValue());
            }
            else{
                res[0][i]="00:00:00";
            }
        }
        return res;
    }
     
      public Object[][] generateAverageDelayTime4(ServerDokter[] arrayServer){
        Object[][] res=new Object[1][arrayServer.length];
        for(int i=0;i<arrayServer.length;i++){
            System.out.println("delay time : petugas "+arrayServer[i].getTotalDelayTime()+" counter : "+arrayServer[i].getCounter());
            if(arrayServer[i].getTotalDelayTime()>0&&arrayServer[i].getCounter()>0){
                System.out.println("delay time : petugas "+arrayServer[i].getTotalDelayTime()+" counter : "+arrayServer[i].getCounter());
                double temp=arrayServer[i].getTotalDelayTime()*1.0/((double)arrayServer[i].getCounter()*1.0);
                System.out.println("temp petugas delay time :"+temp);
                bd = new BigDecimal(temp); 
                bd = bd.setScale(2,BigDecimal.ROUND_UP);
                res[0][i]=this.convertSeconds(bd.doubleValue());
            }
            else{
                res[0][i]="00:00:00";
            }
        }
        return res;
    }
     
     public String generateSummaryOutput(ServerAwal[] arrayServer){
         String first="Output Analysis Summary Pendaftaran Awal\n \n";
         
         first+="Jumlah loket pendaftaran awal : "+arrayServer.length+" \n \n";
        
         double totalsystemspenttime=this.getMaxDepartureTimeServer(arrayServer)-this.getFirstArrivalTime(arrayServer);
         bd = new BigDecimal(totalsystemspenttime);
         bd = bd.setScale(2,BigDecimal.ROUND_UP);
         String totalsystemspenttime2=this.convertSeconds(totalsystemspenttime);
         first+="Total System Spent Time : "+totalsystemspenttime2+" \n \n";
         
         String servicetime=this.convertSeconds(this.generateAverageServiceTimeTotal(arrayServer));
         first+="Rata - rata waktu pelayanan : "+servicetime+" \n \n";
         
         String waitingtime=this.convertSeconds(this.generateAverageWaitingTimeTotal(arrayServer));
         first+="Rata - rata waktu tunggu : "+waitingtime+" \n \n";
         
         String delaytime=this.convertSeconds(this.generateAverageDelayTimeTotal(arrayServer));
         first+="Rata - rata waktu delay: "+delaytime+" \n \n";
         
//         double jumlahpasien=(this.getTotalPasien(arrayServer))/((this.getMaxDepartureTimeServer(arrayServer)*24*60)*(24*60*this.generateAverageWaitingTimeTotal(arrayServer)));
//         bd = new BigDecimal(jumlahpasien);
//         bd = bd.setScale(2,BigDecimal.ROUND_UP);
//         first+="JUMLAH PASIEN PADA SERVICE NODE DI WAKTU KE t : "+(int)jumlahpasien+" \n \n";
//         
//         double jumlahpasien2=(this.getTotalPasien(arrayServer))/((this.getMaxDepartureTimeServer(arrayServer)*24*60)*(this.generateAverageDelayTimeTotal(arrayServer)*24*60));
//         bd = new BigDecimal(jumlahpasien2);
//         bd = bd.setScale(2,BigDecimal.ROUND_UP); 
//         first+="JUMLAH PASIEN PADA ANTRIAN DI WAKTU KE t : "+(int)jumlahpasien2+" \n \n";
//         
//         
//         double jumlahpasien3=(this.getTotalPasien(arrayServer))/((this.getMaxDepartureTimeServer(arrayServer)*24*60)*(this.generateAverageServiceTimeTotal(arrayServer)*24*60));
//         bd = new BigDecimal(jumlahpasien3);
//         bd = bd.setScale(2,BigDecimal.ROUND_UP);
//         first+="JUMLAH PASIEN PADA PELAYANAN DI WAKTU KE t  : "+(int)jumlahpasien3+" \n \n";
             return first;
     }
     
      public String generateSummaryOutputPetugas(ServerPetugas[] arrayServer){
         String first="Output Analysis Summary Petugas\n \n";
         
         first+="Jumlah petugas poliklinik : "+arrayServer.length+" \n \n";
        
         double totalsystemspenttime=this.getMaxDepartureTimeServer2(arrayServer)-this.getFirstArrivalTime2(arrayServer);
         bd = new BigDecimal(totalsystemspenttime);
         bd = bd.setScale(2,BigDecimal.ROUND_UP);
         String totalsystemspenttime2=this.convertSeconds(totalsystemspenttime);
         first+="Total System Spent Time : "+totalsystemspenttime2+" \n \n";
         
         String servicetime=this.convertSeconds(this.generateAverageServiceTimeTotal2(arrayServer));
         first+="Rata - rata waktu pelayanan : "+servicetime+" \n \n";
         
         String waitingtime=this.convertSeconds(this.generateAverageWaitingTimeTotal2(arrayServer));
         first+="Rata - rata waktu tunggu : "+waitingtime+" \n \n";
         
         String delaytime=this.convertSeconds(this.generateAverageDelayTimeTotal2(arrayServer));
         first+="Rata - rata waktu delay: "+delaytime+" \n \n";
         
         return first;
      }
      
     public String generateSummaryOutputPerawat(ServerPerawat[] arrayServer){
         String first="Output Analysis Summary Perawat \n \n";
         
         first+="Jumlah perawat poliklinik : "+arrayServer.length+" \n \n";
        
         double totalsystemspenttime=this.getMaxDepartureTimeServer3(arrayServer)-this.getFirstArrivalTime3(arrayServer);
         bd = new BigDecimal(totalsystemspenttime);
         bd = bd.setScale(2,BigDecimal.ROUND_UP);
         String totalsystemspenttime2=this.convertSeconds(totalsystemspenttime);
         first+="Total System Spent Time : "+totalsystemspenttime2+" \n \n";
         
         String servicetime=this.convertSeconds(this.generateAverageServiceTimeTotal3(arrayServer));
         first+="Rata - rata waktu pelayanan : "+servicetime+" \n \n";
         
         String waitingtime=this.convertSeconds(this.generateAverageWaitingTimeTotal3(arrayServer));
         first+="Rata - rata waktu tunggu : "+waitingtime+" \n \n";
         
         String delaytime=this.convertSeconds(this.generateAverageDelayTimeTotal3(arrayServer));
         first+="Rata - rata waktu delay: "+delaytime+" \n \n";
         
         return first;
      }
     
      public String generateSummaryOutputDokter(ServerDokter[] arrayServer){
         String first="Output Analysis Summary Dokter \n \n";
         
         first+="Jumlah dokter poliklinik : "+arrayServer.length+" \n \n";
        
         double totalsystemspenttime=this.getMaxDepartureTimeServer4(arrayServer)-this.getFirstArrivalTime4(arrayServer);
         bd = new BigDecimal(totalsystemspenttime);
         bd = bd.setScale(2,BigDecimal.ROUND_UP);
         String totalsystemspenttime2=this.convertSeconds(totalsystemspenttime);
         first+="Total System Spent Time : "+totalsystemspenttime2+" \n \n";
         
         String servicetime=this.convertSeconds(this.generateAverageServiceTimeTotal4(arrayServer));
         first+="Rata - rata waktu pelayanan : "+servicetime+" \n \n";
         
         String waitingtime=this.convertSeconds(this.generateAverageWaitingTimeTotal4(arrayServer));
         first+="Rata - rata waktu tunggu : "+waitingtime+" \n \n";
         
         String delaytime=this.convertSeconds(this.generateAverageDelayTimeTotal4(arrayServer));
         first+="Rata - rata waktu delay: "+delaytime+" \n \n";
         
         return first;
      }
     
     
     public int getTotalPasien(ServerAwal[] arrayServer){
         int total=0;
         for(int i=0;i<arrayServer.length;i++){
             LinkedList<Customer> cust=arrayServer[i].getQueueReport2();
             total+=cust.size();
         }
         return total;
     }
     
     public double getFirstArrivalTime(ServerAwal[] arrayServer){
         bd = new BigDecimal(arrayServer[0].getQueueReport2().get(0).getTimeServiceBegin());
         bd = bd.setScale(2,BigDecimal.ROUND_UP);
         return bd.doubleValue();
     }
     
     public double getFirstArrivalTime2(ServerPetugas[] arrayServer){
         if(arrayServer[0].getQueueReport2().size()>0){
            bd = new BigDecimal(arrayServer[0].getQueueReport2().get(0).getTimeServiceBegin2());
            bd = bd.setScale(2,BigDecimal.ROUND_UP);
            return bd.doubleValue();
         }
         else{
             return 0;
         }
     }
     
     public double getFirstArrivalTime3(ServerPerawat[] arrayServer){
         if(arrayServer[0].getQueueReport2().size()>0){
            bd = new BigDecimal(arrayServer[0].getQueueReport2().get(0).getTimeServiceBegin3());
            bd = bd.setScale(2,BigDecimal.ROUND_UP);
            return bd.doubleValue();
         }
         else{
             return 0;
         }
     }
     
     public double getFirstArrivalTime4(ServerDokter[] arrayServer){
         if(arrayServer[0].getQueueReport2().size()>0){
            bd = new BigDecimal(arrayServer[0].getQueueReport2().get(0).getTimeServiceBegin4());
            bd = bd.setScale(2,BigDecimal.ROUND_UP);
            return bd.doubleValue();
         }
         else{
             return 0;
         }
     }
     
     public double generateAverageWaitingTimeTotal(ServerAwal[] arrayServer){
         double waitingtime=0;
         int size=0;
         for(int i=0;i<arrayServer.length;i++){
             LinkedList<Customer> customer=arrayServer[i].getQueueReport2();
             size+=customer.size();
             for(int k=0;k<customer.size();k++){
                 waitingtime+=customer.get(k).getWaitingtime();
             }
         }
         if(waitingtime>0&&size>0){
            double res=waitingtime/(size);
            bd = new BigDecimal(res);
            bd = bd.setScale(2,BigDecimal.ROUND_UP);
            return bd.doubleValue();
         }
         else{
             return 0;
         }
     }
     
      public double generateAverageWaitingTimeTotal2(ServerPetugas[] arrayServer){
         double waitingtime=0;
         int size=0;
         for(int i=0;i<arrayServer.length;i++){
             LinkedList<Customer> customer=arrayServer[i].getQueueReport2();
             size+=customer.size();
             for(int k=0;k<customer.size();k++){
                 waitingtime+=customer.get(k).getWaitingtimepoli();
             }
         }
         if(waitingtime>0&&size>0){
            double res=waitingtime/(size);
            bd = new BigDecimal(res);
            bd = bd.setScale(2,BigDecimal.ROUND_UP);
            return bd.doubleValue();
         }
         else{
             return 0;
         }
     }
      
      public double generateAverageWaitingTimeTotal3(ServerPerawat[] arrayServer){
         double waitingtime=0;
         int size=0;
         for(int i=0;i<arrayServer.length;i++){
             LinkedList<Customer> customer=arrayServer[i].getQueueReport2();
             size+=customer.size();
             for(int k=0;k<customer.size();k++){
                 waitingtime+=customer.get(k).getWaitingtimepoli2();
             }
         }
         if(waitingtime>0&&size>0){
            double res=waitingtime/(size);
            bd = new BigDecimal(res);
            bd = bd.setScale(2,BigDecimal.ROUND_UP);
            return bd.doubleValue();
         }
         else{
             return 0;
         }
     }
      
      public double generateAverageWaitingTimeTotal4(ServerDokter[] arrayServer){
         double waitingtime=0;
         int size=0;
         for(int i=0;i<arrayServer.length;i++){
             LinkedList<Customer> customer=arrayServer[i].getQueueReport2();
             size+=customer.size();
             for(int k=0;k<customer.size();k++){
                 waitingtime+=customer.get(k).getWaitingtimepoli3();
             }
         }
         if(waitingtime>0&&size>0){
            double res=waitingtime/(size);
            bd = new BigDecimal(res);
            bd = bd.setScale(2,BigDecimal.ROUND_UP);
            return bd.doubleValue();
         }
         else{
             return 0;
         }
     }
     
      public double generateAverageDelayTimeTotal(ServerAwal[] arrayServer){
         double delaytime=0;
         int size=0;
         for(int i=0;i<arrayServer.length;i++){
             LinkedList<Customer> customer=arrayServer[i].getQueueReport2();
             size+=customer.size();
             for(int k=0;k<customer.size();k++){
                 delaytime+=customer.get(k).getDelaytime();
             }
         }
         if(delaytime>0&&size>0){
            double res=delaytime/(size);
            bd = new BigDecimal(res);
            bd = bd.setScale(2,BigDecimal.ROUND_UP);
            return bd.doubleValue();
         }
         else{
             return 0;
         }
     }
      
      
      public double generateAverageDelayTimeTotal2(ServerPetugas[] arrayServer){
         double delaytime=0;
         int size=0;
         for(int i=0;i<arrayServer.length;i++){
             LinkedList<Customer> customer=arrayServer[i].getQueueReport2();
             size+=customer.size();
             for(int k=0;k<customer.size();k++){
                 delaytime+=customer.get(k).getDelaytimepoli();
             }
         }
         if(delaytime>0&&size>0){
            double res=delaytime/(size);
            bd = new BigDecimal(res);
            bd = bd.setScale(2,BigDecimal.ROUND_UP);
            return bd.doubleValue();
         }
         else{
             return 0;
         }
     }
      
      public double generateAverageDelayTimeTotal3(ServerPerawat[] arrayServer){
         double delaytime=0;
         int size=0;
         for(int i=0;i<arrayServer.length;i++){
             LinkedList<Customer> customer=arrayServer[i].getQueueReport2();
             size+=customer.size();
             for(int k=0;k<customer.size();k++){
                 delaytime+=customer.get(k).getDelaytimepoli2();
             }
         }
         if(delaytime>0&&size>0){
            double res=delaytime/(size);
            bd = new BigDecimal(res);
            bd = bd.setScale(2,BigDecimal.ROUND_UP);
            return bd.doubleValue();
         }
         else{
             return 0;
         }
     }
      
      public double generateAverageDelayTimeTotal4(ServerDokter[] arrayServer){
         double delaytime=0;
         int size=0;
         for(int i=0;i<arrayServer.length;i++){
             LinkedList<Customer> customer=arrayServer[i].getQueueReport2();
             size+=customer.size();
             for(int k=0;k<customer.size();k++){
                 delaytime+=customer.get(k).getDelaytimepoli3();
             }
         }
         if(delaytime>0&&size>0){
            double res=delaytime/(size);
            bd = new BigDecimal(res);
            bd = bd.setScale(2,BigDecimal.ROUND_UP);
            return bd.doubleValue();
         }
         else{
             return 0;
         }
     }
      
    public double generateAverageServiceTimeTotal(ServerAwal[] arrayServer){
         double servicetime=0;
         int size=0;
         for(int i=0;i<arrayServer.length;i++){
             LinkedList<Customer> customer=arrayServer[i].getQueueReport2();
             size+=customer.size();
             for(int k=0;k<customer.size();k++){
                 servicetime+=customer.get(k).getServicetime();
             }
         }
         if(servicetime>0&&size>0){
            double res=servicetime/(size);
            bd = new BigDecimal(res);
            bd = bd.setScale(2,BigDecimal.ROUND_UP);
            return bd.doubleValue();
         }
         else{
             return 0;
         }
     }
    
     public double generateAverageServiceTimeTotal2(ServerPetugas[] arrayServer){
         double servicetime=0;
         int size=0;
         for(int i=0;i<arrayServer.length;i++){
             LinkedList<Customer> customer=arrayServer[i].getQueueReport2();
             size+=customer.size();
             for(int k=0;k<customer.size();k++){
                 servicetime+=customer.get(k).getServicetimepoli();
             }
         }
         if(servicetime>0&&size>0){
            double res=servicetime/(size);
            bd = new BigDecimal(res);
            bd = bd.setScale(2,BigDecimal.ROUND_UP);
            return bd.doubleValue();
         }
         else{
             return 0;
         }
     }
     
     public double generateAverageServiceTimeTotal3(ServerPerawat[] arrayServer){
         double servicetime=0;
         int size=0;
         for(int i=0;i<arrayServer.length;i++){
             LinkedList<Customer> customer=arrayServer[i].getQueueReport2();
             size+=customer.size();
             for(int k=0;k<customer.size();k++){
                 servicetime+=customer.get(k).getServicetimepoli2();
             }
         }
         if(servicetime>0&&size>0){
            double res=servicetime/(size);
            bd = new BigDecimal(res);
            bd = bd.setScale(2,BigDecimal.ROUND_UP);
            return bd.doubleValue();
         }
         else{
             return 0;
         }
     }
    
       public double generateAverageServiceTimeTotal4(ServerDokter[] arrayServer){
         double servicetime=0;
         int size=0;
         for(int i=0;i<arrayServer.length;i++){
             LinkedList<Customer> customer=arrayServer[i].getQueueReport2();
             size+=customer.size();
             for(int k=0;k<customer.size();k++){
                 servicetime+=customer.get(k).getServicetimepoli3();
             }
         }
         if(servicetime>0&&size>0){
            double res=servicetime/(size);
            bd = new BigDecimal(res);
            bd = bd.setScale(2,BigDecimal.ROUND_UP);
            return bd.doubleValue();
         }
         else{
             return 0;
         }
     }
       
       
    public double generateAverageServiceTimeBPJSLamaTotal(ServerAwal[] arrayServer){
         double servicetime=0;
         int size=0;
         for(int i=0;i<arrayServer.length;i++){
             LinkedList<Customer> customer=arrayServer[i].getQueueReport2();
             for(int k=0;k<customer.size();k++){
                 if(customer.get(k).getJenis().equals("BPJS Lama")){
                    servicetime+=customer.get(k).getServicetime();
                    size++;
                 }
             }
         }
         if(servicetime>0&&size>0){
            double res=servicetime/(size);
            bd = new BigDecimal(res);
            bd = bd.setScale(2,BigDecimal.ROUND_UP);
            return bd.doubleValue();
         }
         else{
             return 0;
         }
     }
    
    public double generateAverageServiceTimeBPJSLamaTotal2(ServerPetugas[] arrayServer){
         double servicetime=0;
         int size=0;
         for(int i=0;i<arrayServer.length;i++){
             LinkedList<Customer> customer=arrayServer[i].getQueueReport2();
             for(int k=0;k<customer.size();k++){
                 if(customer.get(k).getJenis().equals("BPJS Lama")){
                    servicetime+=customer.get(k).getServicetimepoli();
                    size++;
                 }
             }
         }
         if(servicetime>0&&size>0){
            double res=servicetime/(size);
            bd = new BigDecimal(res);
            bd = bd.setScale(2,BigDecimal.ROUND_UP);
            return bd.doubleValue();
         }
         else{
             return 0;
         }
     }
    
    public double generateAverageServiceTimeBPJSLamaTotal3(ServerPerawat[] arrayServer){
         double servicetime=0;
         int size=0;
         for(int i=0;i<arrayServer.length;i++){
             LinkedList<Customer> customer=arrayServer[i].getQueueReport2();
             for(int k=0;k<customer.size();k++){
                 if(customer.get(k).getJenis().equals("BPJS Lama")){
                    servicetime+=customer.get(k).getServicetimepoli2();
                    size++;
                 }
             }
         }
         if(servicetime>0&&size>0){
            double res=servicetime/(size);
            bd = new BigDecimal(res);
            bd = bd.setScale(2,BigDecimal.ROUND_UP);
            return bd.doubleValue();
         }
         else{
             return 0;
         }
     }
    
    public double generateAverageServiceTimeBPJSLamaTotal4(ServerDokter[] arrayServer){
         double servicetime=0;
         int size=0;
         for(int i=0;i<arrayServer.length;i++){
             LinkedList<Customer> customer=arrayServer[i].getQueueReport2();
             for(int k=0;k<customer.size();k++){
                 if(customer.get(k).getJenis().equals("BPJS Lama")){
                    servicetime+=customer.get(k).getServicetimepoli3();
                    size++;
                 }
             }
         }
         if(servicetime>0&&size>0){
            double res=servicetime/(size);
            bd = new BigDecimal(res);
            bd = bd.setScale(2,BigDecimal.ROUND_UP);
            return bd.doubleValue();
         }
         else{
             return 0;
         }
     }
    
    
     public double generateAverageServiceTimeBPJSBaruTotal(ServerAwal[] arrayServer){
         double servicetime=0;
         int size=0;
         for(int i=0;i<arrayServer.length;i++){
             LinkedList<Customer> customer=arrayServer[i].getQueueReport2();
             for(int k=0;k<customer.size();k++){
                 if(customer.get(k).getJenis().equals("BPJS Baru")){
                    servicetime+=customer.get(k).getServicetime();
                    size++;
                 }
             }
         }
         if(servicetime>0&&size>0){
            double res=servicetime/(size);
            bd = new BigDecimal(res);
            bd = bd.setScale(2,BigDecimal.ROUND_UP);
            return bd.doubleValue();
         }
         else{
             return 0;
         }
     }
     
     public double generateAverageServiceTimeEmergency(ServerDokter[] arrayServer){
         double servicetime=0;
         int size=0;
         for(int i=0;i<arrayServer.length;i++){
             LinkedList<Customer> customer=arrayServer[i].getQueueReport2();
             for(int k=0;k<customer.size();k++){
                 if(customer.get(k).getJenis().equals("Emergency")){
                    servicetime+=customer.get(k).getServicetimepoli3();
                    size++;
                 }
             }
         }
         if(servicetime>0&&size>0){
            double res=servicetime/(size);
            bd = new BigDecimal(res);
            bd = bd.setScale(2,BigDecimal.ROUND_UP);
            return bd.doubleValue();
         }
         else{
             return 0;
         }
     }
     
     
     public double generateAverageServiceTimeBPJSBaruTotal2(ServerPetugas[] arrayServer){
         double servicetime=0;
         int size=0;
         for(int i=0;i<arrayServer.length;i++){
             LinkedList<Customer> customer=arrayServer[i].getQueueReport2();
             for(int k=0;k<customer.size();k++){
                 if(customer.get(k).getJenis().equals("BPJS Baru")){
                    servicetime+=customer.get(k).getServicetimepoli();
                    size++;
                 }
             }
         }
         if(servicetime>0&&size>0){
            double res=servicetime/(size);
            bd = new BigDecimal(res);
            bd = bd.setScale(2,BigDecimal.ROUND_UP);
            return bd.doubleValue();
         }
         else{
             return 0;
         }
     }
     
      public double generateAverageServiceTimeBPJSBaruTotal3(ServerPerawat[] arrayServer){
         double servicetime=0;
         int size=0;
         for(int i=0;i<arrayServer.length;i++){
             LinkedList<Customer> customer=arrayServer[i].getQueueReport2();
             for(int k=0;k<customer.size();k++){
                 if(customer.get(k).getJenis().equals("BPJS Baru")){
                    servicetime+=customer.get(k).getServicetimepoli2();
                    size++;
                 }
             }
         }
         if(servicetime>0&&size>0){
            double res=servicetime/(size);
            bd = new BigDecimal(res);
            bd = bd.setScale(2,BigDecimal.ROUND_UP);
            return bd.doubleValue();
         }
         else{
             return 0;
         }
     }
      
       public double generateAverageServiceTimeBPJSBaruTotal4(ServerDokter[] arrayServer){
         double servicetime=0;
         int size=0;
         for(int i=0;i<arrayServer.length;i++){
             LinkedList<Customer> customer=arrayServer[i].getQueueReport2();
             for(int k=0;k<customer.size();k++){
                 if(customer.get(k).getJenis().equals("BPJS Baru")){
                    servicetime+=customer.get(k).getServicetimepoli3();
                    size++;
                 }
             }
         }
         if(servicetime>0&&size>0){
            double res=servicetime/(size);
            bd = new BigDecimal(res);
            bd = bd.setScale(2,BigDecimal.ROUND_UP);
            return bd.doubleValue();
         }
         else{
             return 0;
         }
     }
     
     
        public double generateAverageDelayTimeBPJSBaruTotal(ServerAwal[] arrayServer){
         double delaytime=0;
         int size=0;
         for(int i=0;i<arrayServer.length;i++){
             LinkedList<Customer> customer=arrayServer[i].getQueueReport2();
             for(int k=0;k<customer.size();k++){
                 if(customer.get(k).getJenis().equals("BPJS Baru")){
                   delaytime+=customer.get(k).getDelaytime();
                    size++;
                 }
             }
         }
         if(delaytime>0&&size>0){
            double res=delaytime/(size);
            bd = new BigDecimal(res);
            bd = bd.setScale(2,BigDecimal.ROUND_UP);
            return bd.doubleValue();
         }
         else{
             return 0;
         }
     }
        
         
        public double generateAverageDelayTimeBPJSLamaTotal(ServerAwal[] arrayServer){
         double delaytime=0;
         int size=0;
         for(int i=0;i<arrayServer.length;i++){
             LinkedList<Customer> customer=arrayServer[i].getQueueReport2();
             for(int k=0;k<customer.size();k++){
                 if(customer.get(k).getJenis().equals("BPJS Lama")){
                    delaytime+=customer.get(k).getDelaytime();
                    size++;
                 }
             }
         }
         if(delaytime>0&&size>0){
            double res=delaytime/(size);
            bd = new BigDecimal(res);
            bd = bd.setScale(2,BigDecimal.ROUND_UP);
            return bd.doubleValue();
         }
         else{
             return 0;
         }
     }

    public double generateAverageWaitingTimeBPJSLamaTotal(ServerAwal[] arrayServer){
         double waitingtime=0;
         int size=0;
         for(int i=0;i<arrayServer.length;i++){
             LinkedList<Customer> customer=arrayServer[i].getQueueReport2();
             for(int k=0;k<customer.size();k++){
                 if(customer.get(k).getJenis().equals("BPJS Lama")){
                    waitingtime+=customer.get(k).getWaitingtime();
                    size++;
                 }
             }
         }
         if(waitingtime>0&&size>0){
            double res=waitingtime/(size);
            bd = new BigDecimal(res);
            bd = bd.setScale(2,BigDecimal.ROUND_UP);
            return bd.doubleValue();
         }
         else{
             return 0;
         }
     }
     
    
    
    public double generateAverageWaitingTimeBPJSBaruTotal(ServerAwal[] arrayServer){
         double waitingtime=0;
         int size=0;
         for(int i=0;i<arrayServer.length;i++){
             LinkedList<Customer> customer=arrayServer[i].getQueueReport2();
             for(int k=0;k<customer.size();k++){
                 if(customer.get(k).getJenis().equals("BPJS Baru")){
                    waitingtime+=customer.get(k).getWaitingtime();
                    size++;
                 }
             }
         }
         if(waitingtime>0&&size>0){
            double res=waitingtime/(size);
            bd = new BigDecimal(res);
            bd = bd.setScale(2,BigDecimal.ROUND_UP);
            return bd.doubleValue();
         }
         else{
            return 0; 
         }
     }
    
    public double generateServiceRate(ServerAwal[] arrayServer){
        double res=1/this.generateAverageServiceTimeTotal(arrayServer);
        bd = new BigDecimal(res);
        bd = bd.setScale(2,BigDecimal.ROUND_UP);
        return bd.doubleValue();
    }
    
    public double generateServiceRate2(ServerPetugas[] arrayServer){
        double res=1/this.generateAverageServiceTimeTotal2(arrayServer);
        bd = new BigDecimal(res);
        bd = bd.setScale(2,BigDecimal.ROUND_UP);
        return bd.doubleValue();
    }
    
    public double generateServiceRate3(ServerPerawat[] arrayServer){
        double res=1/this.generateAverageServiceTimeTotal3(arrayServer);
        bd = new BigDecimal(res);
        bd = bd.setScale(2,BigDecimal.ROUND_UP);
        return bd.doubleValue();
    }
    
    public double generateServiceRate4(ServerDokter[] arrayServer){
        double res=1/this.generateAverageServiceTimeTotal4(arrayServer);
        bd = new BigDecimal(res);
        bd = bd.setScale(2,BigDecimal.ROUND_UP);
        return bd.doubleValue();
    }
    
    public double generateServiceRateBPJSLama(ServerAwal[] arrayServer){
        if(this.generateAverageServiceTimeBPJSLamaTotal(arrayServer)>0){
            double res=1/this.generateAverageServiceTimeBPJSLamaTotal(arrayServer);
            bd = new BigDecimal(res);
            bd = bd.setScale(2,BigDecimal.ROUND_UP);
            return bd.doubleValue();
        }
        else{
            return 0;
        }
    }   
    
     public double generateServiceRateBPJSLama2(ServerPetugas[] arrayServer){
        if(this.generateAverageServiceTimeBPJSLamaTotal2(arrayServer)>0){
            double res=1/this.generateAverageServiceTimeBPJSLamaTotal2(arrayServer);
            bd = new BigDecimal(res);
            bd = bd.setScale(2,BigDecimal.ROUND_UP);
            return bd.doubleValue();
        }
        else{
            return 0;
        }
    }  
     
    public double generateServiceRateBPJSLama3(ServerPerawat[] arrayServer){
        if(this.generateAverageServiceTimeBPJSLamaTotal3(arrayServer)>0){
            double res=1/this.generateAverageServiceTimeBPJSLamaTotal3(arrayServer);
            bd = new BigDecimal(res);
            bd = bd.setScale(2,BigDecimal.ROUND_UP);
            return bd.doubleValue();
        }
        else{
            return 0;
        }
    }  
    
    public double generateServiceRateBPJSLama4(ServerDokter[] arrayServer){
        if(this.generateAverageServiceTimeBPJSLamaTotal4(arrayServer)>0){
            double res=1/this.generateAverageServiceTimeBPJSLamaTotal4(arrayServer);
            bd = new BigDecimal(res);
            bd = bd.setScale(2,BigDecimal.ROUND_UP);
            return bd.doubleValue();
        }
        else{
            return 0;
        }
    }  
    
    public double generateServiceRateBPJSBaru(ServerAwal[] arrayServer){
        if(this.generateAverageServiceTimeBPJSBaruTotal(arrayServer)>0){
            double res=1/this.generateAverageServiceTimeBPJSBaruTotal(arrayServer);
            bd = new BigDecimal(res);
            bd = bd.setScale(2,BigDecimal.ROUND_UP);
            return bd.doubleValue();
        }
        else{
            return 0;
        }
    }
     
    public double generateServiceRateBPJSBaru2(ServerPetugas[] arrayServer){
        if(this.generateAverageServiceTimeBPJSBaruTotal2(arrayServer)>0){
            double res=1/this.generateAverageServiceTimeBPJSBaruTotal2(arrayServer);
            bd = new BigDecimal(res);
            bd = bd.setScale(2,BigDecimal.ROUND_UP);
            return bd.doubleValue();
        }
        else{
            return 0;
        }
    }
    
    public double generateServiceRateBPJSBaru3(ServerPerawat[] arrayServer){
        if(this.generateAverageServiceTimeBPJSBaruTotal3(arrayServer)>0){
            double res=1/this.generateAverageServiceTimeBPJSBaruTotal3(arrayServer);
            bd = new BigDecimal(res);
            bd = bd.setScale(2,BigDecimal.ROUND_UP);
            return bd.doubleValue();
        }
        else{
            return 0;
        }
    }
    
    public double generateServiceRateBPJSBaru4(ServerDokter[] arrayServer){
        if(this.generateAverageServiceTimeBPJSBaruTotal4(arrayServer)>0){
            double res=1/this.generateAverageServiceTimeBPJSBaruTotal4(arrayServer);
            bd = new BigDecimal(res);
            bd = bd.setScale(2,BigDecimal.ROUND_UP);
            return bd.doubleValue();
        }
        else{
            return 0;
        }
    }
    
     public double generateServiceRateEmergency(ServerDokter[] arrayServer){
        if(this.generateAverageServiceTimeEmergency(arrayServer)>0){
            double res=1/this.generateAverageServiceTimeEmergency(arrayServer);
            bd = new BigDecimal(res);
            bd = bd.setScale(2,BigDecimal.ROUND_UP);
            return bd.doubleValue();
        }
        else{
            return 0;
        }
    }
    
     public double getMaxDepartureTimeServer(ServerAwal[] arrayServer){
         double[] maxDepartureTime=new double[arrayServer.length];
         for(int i=0;i<arrayServer.length;i++){
             maxDepartureTime[i]=this.getMaxDepartureTime(arrayServer[i].getQueueReport2());
         }
         double res=maxDepartureTime[0];
         for(int k=1;k<maxDepartureTime.length;k++){
             if(res<maxDepartureTime[k]){
                 res=maxDepartureTime[k];
             }
         }
         return res;
     }
     
      public double getMaxDepartureTimeServer2(ServerPetugas[] arrayServer){
         double[] maxDepartureTime=new double[arrayServer.length];
         for(int i=0;i<arrayServer.length;i++){
             maxDepartureTime[i]=this.getMaxDepartureTime2(arrayServer[i].getQueueReport2());
         }
         double res=maxDepartureTime[0];
         for(int k=1;k<maxDepartureTime.length;k++){
             if(res<maxDepartureTime[k]){
                 res=maxDepartureTime[k];
             }
         }
         return res;
     }
      
      public double getMaxDepartureTimeServer3(ServerPerawat[] arrayServer){
         double[] maxDepartureTime=new double[arrayServer.length];
         for(int i=0;i<arrayServer.length;i++){
             maxDepartureTime[i]=this.getMaxDepartureTime3(arrayServer[i].getQueueReport2());
         }
         double res=maxDepartureTime[0];
         for(int k=1;k<maxDepartureTime.length;k++){
             if(res<maxDepartureTime[k]){
                 res=maxDepartureTime[k];
             }
         }
         return res;
     }
      
      public double getMaxDepartureTimeServer4(ServerDokter[] arrayServer){
         double[] maxDepartureTime=new double[arrayServer.length];
         for(int i=0;i<arrayServer.length;i++){
             maxDepartureTime[i]=this.getMaxDepartureTime4(arrayServer[i].getQueueReport2());
         }
         double res=maxDepartureTime[0];
         for(int k=1;k<maxDepartureTime.length;k++){
             if(res<maxDepartureTime[k]){
                 res=maxDepartureTime[k];
             }
         }
         return res;
     }
     
     public Object[][] generateTotalSpentTimeServer(ServerAwal[] arrayServer){
         Object[][] totalspenttime=new Object[1][arrayServer.length];
         for(int i=0;i<arrayServer.length;i++){
             int cust=arrayServer[i].getQueueReport2().size();
             if(cust>0){
                double max=arrayServer[i].getQueueReport2().get(cust-1).getTimeServiceEnd();
                System.out.println("max : "+this.convertSeconds(arrayServer[i].getQueueReport2().get(cust-1).getTimeServiceEnd()));
                double min=arrayServer[i].getQueueReport2().get(0).getArrivaltime();
                System.out.println("min : "+this.convertSeconds(arrayServer[i].getQueueReport2().get(0).getArrivaltime()));
                bd = new BigDecimal(max-min);
                bd = bd.setScale(2,BigDecimal.ROUND_UP);
                totalspenttime[0][i]=this.convertSeconds(bd.doubleValue());
             }
             else{
                 totalspenttime[0][i]="00:00:00";
             }
         }
         return totalspenttime;
     }
     
     public Object[][] generateTotalSpentTimeServer2(ServerPetugas[] arrayPetugas){
         Object[][] totalspenttime=new Object[1][arrayPetugas.length];
         for(int i=0;i<arrayPetugas.length;i++){
             int cust=arrayPetugas[i].getQueueReport2().size();
             System.out.println("cust : "+cust);
             if(cust>0){
                double max=arrayPetugas[i].getQueueReport2().get(cust-1).getTimeServiceEnd2();
                System.out.println("max cust petugas : "+this.convertSeconds(arrayPetugas[i].getQueueReport2().get(cust-1).getTimeServiceEnd2()));
                double min=arrayPetugas[i].getQueueReport2().get(0).getArrivaltimepoli();
                System.out.println("min cust petugas: "+this.convertSeconds(arrayPetugas[i].getQueueReport2().get(0).getArrivaltimepoli()));
                bd = new BigDecimal(max-min);
                bd = bd.setScale(2,BigDecimal.ROUND_UP);
                totalspenttime[0][i]=this.convertSeconds(bd.doubleValue());
             }
             else{
                 totalspenttime[0][i]="00:00:00";
             }
         }
         return totalspenttime;
     }
     
     public Object[][] generateTotalSpentTimeServer3(ServerPerawat[] arrayPetugas){
         Object[][] totalspenttime=new Object[1][arrayPetugas.length];
         for(int i=0;i<arrayPetugas.length;i++){
             int cust=arrayPetugas[i].getQueueReport2().size();
             System.out.println("cust : "+cust);
             if(cust>0){
                double max=arrayPetugas[i].getQueueReport2().get(cust-1).getTimeServiceEnd3();
                System.out.println("max cust petugas : "+this.convertSeconds(arrayPetugas[i].getQueueReport2().get(cust-1).getTimeServiceEnd2()));
                double min=arrayPetugas[i].getQueueReport2().get(0).getArrivaltimepoli2();
                System.out.println("min cust petugas: "+this.convertSeconds(arrayPetugas[i].getQueueReport2().get(0).getArrivaltimepoli()));
                bd = new BigDecimal(max-min);
                bd = bd.setScale(2,BigDecimal.ROUND_UP);
                totalspenttime[0][i]=this.convertSeconds(bd.doubleValue());
             }
             else{
                 totalspenttime[0][i]="00:00:00";
             }
         }
         return totalspenttime;
     }
     
     public Object[][] generateTotalSpentTimeServer4(ServerDokter[] arrayPetugas){
         Object[][] totalspenttime=new Object[1][arrayPetugas.length];
         for(int i=0;i<arrayPetugas.length;i++){
             int cust=arrayPetugas[i].getQueueReport2().size();
             System.out.println("cust : "+cust);
             if(cust>0){
                double max=arrayPetugas[i].getQueueReport2().get(cust-1).getTimeServiceEnd4();
                System.out.println("max cust petugas : "+this.convertSeconds(arrayPetugas[i].getQueueReport2().get(cust-1).getTimeServiceEnd2()));
                double min=arrayPetugas[i].getQueueReport2().get(0).getArrivaltimepoli3();
                System.out.println("min cust petugas: "+this.convertSeconds(arrayPetugas[i].getQueueReport2().get(0).getArrivaltimepoli()));
                bd = new BigDecimal(max-min);
                bd = bd.setScale(2,BigDecimal.ROUND_UP);
                totalspenttime[0][i]=this.convertSeconds(bd.doubleValue());
             }
             else{
                 totalspenttime[0][i]="00:00:00";
             }
         }
         return totalspenttime;
     }
     
     public double getMinDepartureTimeServer(ServerAwal[] arrayServer){
         double[] minDepartureTime=new double[arrayServer.length];
         for(int i=0;i<arrayServer.length;i++){
             minDepartureTime[i]=this.getMinDepartureTime(arrayServer[i].getQueueReport2());
         }
         double res=minDepartureTime[0];
         for(int k=1;k<minDepartureTime.length;k++){
             if(res>minDepartureTime[k]){
                 res=minDepartureTime[k];
             }
         }
         return res;
     }
     
     
     public double getMaxDepartureTime(LinkedList<Customer> customer){
         int cari=0;
         double compare=0;
         if(customer.size()>0){
            compare=customer.get(0).getTimeServiceEnd();
            for(int i=1;i<customer.size();i++){
                if(compare<customer.get(i).getTimeServiceEnd()){
                    compare=customer.get(i).getTimeServiceEnd();
                    cari=i;
                }
            }
         }
         return compare;
     }
     
     public double getMaxDepartureTime2(LinkedList<Customer> customer){
         int cari=0;
         double compare=0;
         if(customer.size()>0){
            compare=customer.get(0).getTimeServiceEnd2();
            for(int i=1;i<customer.size();i++){
                if(compare<customer.get(i).getTimeServiceEnd2()){
                    compare=customer.get(i).getTimeServiceEnd2();
                    cari=i;
                }
            }
         }
         return compare;
     }
     
     public double getMaxDepartureTime3(LinkedList<Customer> customer){
         int cari=0;
         double compare=0;
         if(customer.size()>0){
            compare=customer.get(0).getTimeServiceEnd3();
            for(int i=1;i<customer.size();i++){
                if(compare<customer.get(i).getTimeServiceEnd3()){
                    compare=customer.get(i).getTimeServiceEnd3();
                    cari=i;
                }
            }
         }
         return compare;
     }
     
      public double getMaxDepartureTime4(LinkedList<Customer> customer){
         int cari=0;
         double compare=0;
         if(customer.size()>0){
            compare=customer.get(0).getTimeServiceEnd4();
            for(int i=1;i<customer.size();i++){
                if(compare<customer.get(i).getTimeServiceEnd4()){
                    compare=customer.get(i).getTimeServiceEnd4();
                    cari=i;
                }
            }
         }
         return compare;
     }
     
     
     public double getMinDepartureTime(LinkedList<Customer> customer){
         int cari=0;
         double compare=0;
         if(customer.size()>0){
            compare=customer.get(0).getTimeServiceEnd();
            for(int i=1;i<customer.size();i++){
                if(compare>customer.get(i).getTimeServiceEnd()){
                    compare=customer.get(i).getTimeServiceEnd();
                    cari=i;
                }
            }
         }
         return compare;
     }
    
    public String[] generateColumnNamesServer(ServerAwal[] arrayServer){
        String [] columns=new String[arrayServer.length];
        for(int i=0;i<columns.length;i++){
            columns[i]="Loket ke - "+arrayServer[i].getServernumber();
        }
        return columns;
    }
     
    public String[] generateColumnNamesServer2(ServerPetugas[] arrayPetugas){
        String [] columns=new String[arrayPetugas.length];
        for(int i=0;i<columns.length;i++){
            columns[i]="Petugas ke - "+arrayPetugas[i].getServernumber();
        }
        return columns;
    }
    
     public String[] generateColumnNamesServer3(ServerPerawat[] arrayPetugas){
        String [] columns=new String[arrayPetugas.length];
        for(int i=0;i<columns.length;i++){
            columns[i]="Perawat ke - "+arrayPetugas[i].getServernumber();
        }
        return columns;
    }
     
    public String[] generateColumnNamesServer4(ServerDokter[] arrayPetugas){
        String [] columns=new String[arrayPetugas.length];
        for(int i=0;i<columns.length;i++){
            columns[i]="Dokter ke - "+arrayPetugas[i].getServernumber();
        }
        return columns;
    }
   
   
     
    /**
     * @return the meanservicetime
     */
    public double getMeanservicetime() {
        return meanservicetime;
    }

    /**
     * @param meanservicetime the meanservicetime to set
     */
    public void setMeanservicetime(double meanservicetime) {
        this.meanservicetime = meanservicetime;
    }

    /**
     * @return the meanarrivaltime
     */
    public double getMeanarrivaltime() {
        return meanarrivaltime;
    }

    /**
     * @param meanarrivaltime the meanarrivaltime to set
     */
    public void setMeanarrivaltime(double meanarrivaltime) {
        this.meanarrivaltime = meanarrivaltime;
    }

    /**
     * @return the meanservicetime2
     */
    public double getMeanservicetime2() {
        return meanservicetime2;
    }

    /**
     * @param meanservicetime2 the meanservicetime2 to set
     */
    public void setMeanservicetime2(double meanservicetime2) {
        this.meanservicetime2 = meanservicetime2;
    }

    /**
     * @return the meanservicetimepoli
     */
    public double getMeanservicetimepoli() {
        return meanservicetimepoli;
    }

    /**
     * @param meanservicetimepoli the meanservicetimepoli to set
     */
    public void setMeanservicetimepoli(double meanservicetimepoli) {
        this.meanservicetimepoli = meanservicetimepoli;
    }
    
    
}
