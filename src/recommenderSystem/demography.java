/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recommenderSystem;
import java.util.ArrayList;
import readData.readDataUsers;
import java.io.*;
import static java.lang.Integer.parseInt;
import java.lang.reflect.Array;
import java.util.Scanner;
import readData.decodeData;
import static readData.readData.readData;

/**
 *
 * @author ADMIN
 */
public class demography {
    // tim nhg users tuong dong
    public static ArrayList TakeSimUsers(ArrayList user){
    // public static void main(String args[]){ 
         //ArrayList user = new ArrayList();
        //int age = (Integer) user.get(0);//OK
        //String sex = (String) user.get(1);//OK
        //ArrayList user = new ArrayList();
       // user.add(24);
       // user.add("M");
        int age = (int) user.get(0);
        String sex = (String) user.get(1);
        int id;
        if(age <= 9)id = 0;
        else if((age <=19)&&(age >= 10))id = 1;
        else if((age <= 45)&&(age >=20))id = 2;
        else if((age <= 60)&&(age >= 46))id =3;
        else id = 4;
        //System.out.println(id);
        ArrayList simusers = new ArrayList();
        ArrayList DataUser = readDataUsers.DecodeDataUser();
        for(int i=0;i < DataUser.size();i++){
            ArrayList useri = (ArrayList) DataUser.get(i);
            String agei = (String) useri.get(1);
            int ageii = parseInt(agei);//tuoi
            String sexi = (String) useri.get(2);//gioi tinh
            int ed = 0;
            if(ageii <= 9)ed =0;
            else if((ageii <= 19)&&(ageii >= 10))ed =1;
            else if((ageii <= 45)&&(ageii >= 20))ed = 2;
            else if((ageii <= 60)&&(ageii >= 46))ed =3;
            else ed = 4;
            //System.out.println(ed);
            //System.out.println(id);
            //System.out.println(sex);
           // System.out.println(sexi);
            String idUser = (String) useri.get(0);
            if((sexi.equals(sex))&&(ed == id)){//sai chỗ so sánh này?????
                simusers.add(idUser);
                //System.out.println("hello");
            }else continue;
        
        //System.out.println(idUser);
            //else continue;
        
        //return simusers;
      //System.out.println(id);
    }
       return simusers;
    }
    //public static void main(String[] args){
    //Phương thức lấy ra các bộ film do những người dùng tương đồng đánh giá
    public static ArrayList TakeSimFilms(ArrayList userId){
        ArrayList data = decodeData.DecodeData();
        int l = data.size();
        ArrayList rateList = new ArrayList();
        for(int i=0;i < userId.size();i++){
            String id = (String) userId.get(i);
            int idi = parseInt(id);
            //System.out.println(id);
            for(int k = 0;k < l;k++){
                ArrayList datak = (ArrayList) data.get(k);
                //System.out.println(data.get(k));
                ArrayList pairIdRate = new ArrayList();
                int idk = (int) datak.get(0);
                //System.out.println(idk);
                if(idi == idk){
                   int idFilm = (int) datak.get(1);
                   int rateFilm = (int) datak.get(2);
                   pairIdRate.add(idFilm);
                   pairIdRate.add(rateFilm);
                   rateList.add(pairIdRate);
            }else continue;
        }
    }
        return rateList;
    }
    //Phương thức tách riêng các đánh giá về cùng 1 bộ film -< gọn hơn cho tính toán
    public static ArrayList TakeListFilm(ArrayList listfilm){
    //public static void main(String[] args){
       // ArrayList listfilm = new ArrayList();
        int l = listfilm.size();
        ArrayList film0 = (ArrayList) listfilm.get(0);
        int id0 = (int) film0.get(0);
        int rate = (int) film0.get(1);
        ArrayList idFilm = new ArrayList();
        idFilm.add(id0);
        for(int i = 1; i < l;i++){
            int count = 0;
            //int idi = (int) listfilm.get(i);
            ArrayList filmi = (ArrayList) listfilm.get(i);
            int idi = (int) filmi.get(0);
            for(int k = 0; k < idFilm.size();k++){
                int idk = (int) idFilm.get(k);
                if(idk != idi){
                    count++;
                }else continue;
            }
            if(count == idFilm.size()){
                idFilm.add(idi);
            }
            
        }
        ArrayList lastId = new ArrayList();
        for(int m =0;m < idFilm.size();m++){
            ArrayList filmM = new ArrayList();
            int idm = (int) idFilm.get(m);
            ArrayList ratem = new ArrayList();
            for(int n = 0; n < l;n++){
                ArrayList listfilmM = (ArrayList) listfilm.get(n);
                int idM = (int) listfilmM.get(0);
                if(idm == idM){
                    int rateM = (int) listfilmM.get(1);
                    ratem.add(rateM);
                }else continue;
            }
            filmM.add(idm);
            filmM.add(ratem);
            lastId.add(filmM);
        }
        return lastId;//list dạng id film, và các đánh giá cho film
        
    }
    //phương thức tính rank(i)
    //public static void main(String[] args){
    public static float TakeRank(ArrayList film){//tham số là list đánh giá cho 1 bộ film có dược từ phương thức trên
        
    
   ArrayList rate = (ArrayList) film.get(1);
        int totalRate = rate.size();
        ArrayList freq = new ArrayList();
        for(int i=1;i < 6;i++){
            int freqi = 0;
            for(int k = 0;k < rate.size();k++){
                int rateK = (int) rate.get(k);
                if(rateK == i){
                    freqi++;
                }else continue;
            }
            freq.add(freqi);
        }
        int freq1 = (int) freq.get(0);System.out.println(freq1);
        int freq2 = (int) freq.get(1);
        int freq3 = (int) freq.get(2);
        int freq4 = (int) freq.get(3);
        int freq5 = (int) freq.get(4);
        float pred = ((1*freq1 + 2*freq2 + 3*freq3 + 4*freq4 + 5*freq5)/totalRate);
        float rank = 35*totalRate + 65*pred;
    return rank;
}
public static void main(String args[]){
    Scanner scanIn = new Scanner(System.in);
    String age = "";
    String sex = "";
    try{
    System.out.print("Nhập tuổi user: ");
    age = scanIn.nextLine();
    System.out.print("Nhập F hoặc M cho giới tính user: ");
    sex = scanIn.nextLine();
}catch(Exception e){
    //System.out.println("Error!");
}
    ArrayList user = new ArrayList();
    int agei = Integer.parseInt(age);
    user.add(agei);
    user.add(sex);
   // System.out.println(user.get(0));
    //System.out.println(user.get(1));
    ArrayList a = new ArrayList();
    a = TakeSimUsers(user);
    ArrayList b = TakeSimFilms(a);
    ArrayList c = TakeListFilm(b);
    ArrayList last = new ArrayList();
    for(int i = 0;i < c .size();i++){
        ArrayList last1 = new ArrayList();
        ArrayList filmi = (ArrayList) c.get(i);
        int idi = (int) filmi.get(0);
        //System.out.println(idi);
        float ranki = TakeRank(filmi);
        //System.out.println(ranki);
        last1.add(idi);
        last1.add(ranki);
        last.add(last1);
    }
    //lấy 10 rank lớn nhất//quên !
    for(int e = 0;e < last.size() - 1;e++){
        ArrayList itemE = (ArrayList) last.get(e);
        int idE = (int) itemE.get(0);
        float rankE = (Float) itemE.get(1);
        for(int ei = e + 1;ei < last.size();ei++){
            ArrayList tt = new ArrayList();
            ArrayList itemEI = (ArrayList) last.get(ei);
            float rankEI = (Float) itemEI.get(1);
            int idEI = (int) itemEI.get(0);
            if(rankE < rankEI){
                 tt.add(idE);
                 tt.add(rankE);
                 idE = idEI;
                 rankE= rankEI;
                idEI = (int) tt.get(0);
                rankEI = (Float) tt.get(1);
 }
         
     }
       
        }
    ArrayList demography = new ArrayList();
    int lengthK = last.size();
    for(int ki = 1;ki < 11;ki++){
        ArrayList demographyK = (ArrayList) last.get(lengthK - ki);
        demography.add(demographyK);
    }
    System.out.println("Được gợi ý các bộ film:  ");
    for(int s = 0;s < demography.size();s++){
        ArrayList filmS = (ArrayList) demography.get(s);
        System.out.println(filmS.get(0));
    
    }
}
}






    
   /* public static void main(String args[]){
        ArrayList a = new ArrayList();
        a.add(24);
        a.add("lananh");
        ArrayList sim= (ArrayList) TakeSimUsers(a);
        for(int k=0;k < sim.size();k++){
            System.out.println(sim.get(k));
        }
    }
}*/

        /*Strring age = (String) user.get(0);
        int agen = parseInt(age);
        int id = 0;
        if(agen <= 9)id=0;
        if((agen <= 19)&&(agen >=10))id = 1;
        if((agen <= 45)&&(agen >= 20))id = 2;
        if((agen <= 60)&&(agen >= 46))id = 3;
        if (agen > 60)id =4;
        String sex = (String) user.get(1);
        ArrayList DataUser = readDataUsers.DecodeDataUser();
        ArrayList SimUser = new ArrayList();
        for(int i=0; i < DataUser.size();i++){
            ArrayList userI = (ArrayList) DataUser.get(i);
            String idUser = (String) userI.get(0);
            String ageI = (String) userI.get(1);
            int ageIn = parseInt(ageI);
            int ed = 0;
            if(ageIn <= 9)ed = 0;
            if((ageIn <= 19)&&(ageIn >= 10))ed = 1;
            if((ageIn <= 45)&&(ageIn >= 20))ed = 2;
            if((ageIn <= 60)&&(ageIn >= 46))ed = 3;
            if(ageIn > 60)ed = 4;
            String sexI = (String) userI.get(2);
            if((sex == sexI)&&(id == ed)){
                SimUser.add(idUser);
        }
        }
        return SimUser;
            }*/
    /*public static void main(String[] args){
        ArrayList user = new ArrayList();
        user.add("9");
        user.add("F");
        ArrayList a = TakeSimUsers(user);
        for(int i = 0; i < a.size();i++){
            System.out.println(a.get(i));
        }
    }*/
    

